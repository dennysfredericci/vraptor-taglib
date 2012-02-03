package br.com.caelum.vraptor.taglib.validator;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.View;
import br.com.caelum.vraptor.core.Localization;
import br.com.caelum.vraptor.ioc.Component;
import br.com.caelum.vraptor.ioc.RequestScoped;
import br.com.caelum.vraptor.proxy.Proxifier;
import br.com.caelum.vraptor.util.test.MockResult;
import br.com.caelum.vraptor.validator.AbstractValidator;
import br.com.caelum.vraptor.validator.BeanValidator;
import br.com.caelum.vraptor.validator.DefaultValidator;
import br.com.caelum.vraptor.validator.I18nMessage;
import br.com.caelum.vraptor.validator.Message;
import br.com.caelum.vraptor.validator.Outjector;
import br.com.caelum.vraptor.validator.Validations;
import br.com.caelum.vraptor.view.ValidationViewsFactory;

import com.google.common.collect.HashMultimap;
import com.google.common.collect.Multimap;

/**
 * Implementacao alternativa do validator para adicionar um mapa com os erros
 * ocorridos no request
 * 
 * @author Dennys Fredericci
 * 
 */
@Component
@RequestScoped
public class Validator extends AbstractValidator {
	private static final Logger logger = LoggerFactory.getLogger(DefaultValidator.class);

	private final Result result;

	private final List<Message> errors = new ArrayList<Message>();
	private final ValidationViewsFactory viewsFactory;
	private final List<BeanValidator> beanValidators;

	private final Outjector outjector;

	private final Proxifier proxifier;

	private final Localization localization;

	public Validator(Result result, ValidationViewsFactory factory, Outjector outjector, Proxifier proxifier, List<BeanValidator> beanValidators, Localization localization) {
		this.result = result;
		this.viewsFactory = factory;
		this.outjector = outjector;
		this.proxifier = proxifier;
		this.beanValidators = beanValidators;
		this.localization = localization;
	}

	public void checking(Validations validations) {
		addAll(validations.getErrors(localization.getBundle()));
	}

	public void validate(Object object) {
		if (beanValidators == null || beanValidators.isEmpty()) {
			logger.warn("has no validators registered");
		} else {
			for (BeanValidator validator : beanValidators) {
				addAll(validator.validate(object));
			}
		}
	}

	public <T extends View> T onErrorUse(Class<T> view) {
		if (!hasErrors()) {
			return new MockResult(proxifier).use(view); // ignore anything, no
														// errors occurred
		}
		result.include("errors", errors);
		result.include("errorsMap", toMap(errors));
		outjector.outjectRequestMap();
		return viewsFactory.instanceFor(view, errors);
	}

	private Multimap<String, String> toMap(List<Message> errorsList) {

		Multimap<String, String> errorsMap = HashMultimap.create();

		for (Message message : errorsList) {
			errorsMap.put(message.getCategory(), message.getMessage());
		}

		return errorsMap;
	}

	public void addAll(Collection<? extends Message> messages) {
		for (Message message : messages) {
			add(message);
		}
	}

	public void add(Message message) {
		if (message instanceof I18nMessage && !((I18nMessage) message).hasBundle()) {
			((I18nMessage) message).setBundle(localization.getBundle());
		}
		this.errors.add(message);
	}

	public boolean hasErrors() {
		return !errors.isEmpty();
	}

	public List<Message> getErrors() {
		return Collections.unmodifiableList(this.errors);
	}

}
