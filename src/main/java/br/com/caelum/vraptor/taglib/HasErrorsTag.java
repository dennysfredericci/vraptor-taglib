package br.com.caelum.vraptor.taglib;

import java.util.Collection;

import javax.servlet.jsp.JspTagException;
import javax.servlet.jsp.jstl.core.ConditionalTagSupport;

import com.google.common.collect.Multimap;

public class HasErrorsTag extends ConditionalTagSupport {

	private static final long serialVersionUID = 1L;

	private String category = null;

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	@Override
	@SuppressWarnings("unchecked")
	protected boolean condition() throws JspTagException {

		Multimap<String, String> errorsMap = (Multimap<String, String>) pageContext.getRequest().getAttribute("errorsMap");

		if (errorsMap != null) {

			Collection<String> errors = errorsMap.get(category);

			return errors != null && errors.size() > 0;

		}

		return false;
	}

}
