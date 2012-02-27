package br.com.caelum.vraptor.taglib;

import java.util.Collection;

import javax.servlet.jsp.JspTagException;
import javax.servlet.jsp.jstl.core.ConditionalTagSupport;

import br.com.caelum.vraptor.validator.Message;

public class HasErrorsTag extends ConditionalTagSupport {

	private static final long serialVersionUID = 1L;

	private String category;

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	protected boolean condition() throws JspTagException {

		@SuppressWarnings("unchecked")
		Collection<Message> errors = (Collection<Message>) pageContext.getRequest().getAttribute("errors");

		if (errors != null) {
			for (Message message : errors) {
				if (message.getCategory().equals(this.getCategory())) {
					return true;
				}
			}
		}

		return false;
	}

}
