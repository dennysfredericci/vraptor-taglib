package br.com.caelum.vraptor.taglib;

import java.io.IOException;
import java.util.Collection;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.TagSupport;

import br.com.caelum.vraptor.validator.Message;

/**
 * @author Dennys Fredericci
 * 
 */
public class ShowErrorsTag extends TagSupport {

	private static final long serialVersionUID = 1L;

	private String category;

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	@Override
	public int doEndTag() throws JspException {

		@SuppressWarnings("unchecked")
		Collection<Message> errors = (Collection<Message>) pageContext.getRequest().getAttribute("errors");

		if (errors != null) {
			for (Message message : errors) {
				if (message.getCategory().equals(this.getCategory())) {
					print(message);
				}
			}
		}

		return EVAL_PAGE;
	}

	private void print(Message message) throws JspException {
		try {
			pageContext.getOut().print(message.getMessage() + "<br />");
		} catch (IOException e) {
			throw new JspException(e);
		}
	}

}
