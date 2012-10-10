package br.com.caelum.vraptor.taglib;

import br.com.caelum.vraptor.taglib.elements.Element;
import br.com.caelum.vraptor.taglib.elements.OptionElement;
import br.com.caelum.vraptor.taglib.elements.SelectItemsElement;
import br.com.caelum.vraptor.taglib.elements.atribute.IdElement;
import br.com.caelum.vraptor.taglib.elements.atribute.NameElement;
import java.util.List;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.TagSupport;
import org.apache.commons.beanutils.PropertyUtils;

/**
 * @author Robson Ventrua Rodrigues robsonvnt@gmail.com Date: 09/10/12
 */
public class SelectItemsTag extends TagSupport {

    private String name;
    private List list;
    private String styleClass;
    private String value;
    private String label;

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

    public String getStyleClass() {
        return styleClass;
    }

    public void setStyleClass(String styleClass) {
        this.styleClass = styleClass;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    @Override
    public int doStartTag() throws JspException {
        try {
            
            OptionElement optionElement = null;
            
            for (Object object : list) {
                
                String valueOption = PropertyUtils.getProperty(object, value).toString();
                String labelOption = PropertyUtils.getProperty(object, label).toString();
                optionElement = new OptionElement(optionElement, valueOption, labelOption);
            }
            
            Element element = new NameElement(null, name);
            element = new IdElement(element, id);
            element = new SelectItemsElement(element, optionElement);
            
            
            pageContext.getOut().print(element.getElement());
            return super.doStartTag();
            
        } catch (Exception ex) {
            return super.doStartTag();
        }
    }
    
}
