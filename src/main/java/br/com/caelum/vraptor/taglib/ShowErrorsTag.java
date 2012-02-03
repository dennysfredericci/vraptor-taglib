/**
 * 
 */
package br.com.caelum.vraptor.taglib;

import java.io.IOException;
import java.util.Collection;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.TagSupport;

import com.google.common.collect.Multimap;

/**
 * @author Dennys Fredericci
 * 
 */
public class ShowErrorsTag extends TagSupport {

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
	public int doEndTag() throws JspException {

		Multimap<String, String> errorsMap = (Multimap<String, String>) pageContext.getRequest().getAttribute("errorsMap");

		if (errorsMap != null) {

			Collection<String> errors = errorsMap.get(category);

			if (errors != null) {

				for (String erro : errors) {
					print(erro);
				}
			}

		}

		return EVAL_PAGE;
	}

	private void print(String erro) throws JspException {
		try {
			pageContext.getOut().print(erro + "<br>");
		} catch (IOException e) {
			throw new JspException(e);
		}
	}

}
