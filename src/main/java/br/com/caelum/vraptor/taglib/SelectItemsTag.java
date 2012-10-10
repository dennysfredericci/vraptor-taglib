package br.com.caelum.vraptor.taglib;

import br.com.caelum.vraptor.taglib.elements.Element;
import br.com.caelum.vraptor.taglib.elements.OptionElement;
import br.com.caelum.vraptor.taglib.elements.SelectItemsElement;
import br.com.caelum.vraptor.taglib.elements.atribute.IdElement;
import br.com.caelum.vraptor.taglib.elements.atribute.NameElement;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.TagSupport;

/**
 * @author Robson Ventrua Rodrigues robsonvnt@gmail.com Date: 09/10/12
 */
public class SelectItemsTag extends TagSupport {

    private String name;
    private List list;

    public List getList() {
        return list;
    }

    public void setList(List list) {
        this.list = list;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public int doStartTag() throws JspException {
        try {
            
            OptionElement optionElement = null;
            
            for (Object object : list) {
                optionElement = new OptionElement(optionElement, object.toString(), object.toString());
            }
            
            Element element = new NameElement(null, name);
            element = new IdElement(element, id);
            element = new SelectItemsElement(element, optionElement);
            
            
            pageContext.getOut().print(element.getElement());
            return super.doStartTag();
            
        } catch (IOException ex) {
            return super.doStartTag();
        }
    }
}
