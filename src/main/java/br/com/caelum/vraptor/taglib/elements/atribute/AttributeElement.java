/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.caelum.vraptor.taglib.elements.atribute;

import br.com.caelum.vraptor.taglib.elements.Element;
import com.google.common.base.Strings;

/**
 *
 * @author Robson Ventura Rodrigues robsonvnt@gmail.com
 */
public class AttributeElement extends Element {

    private final String field;
    private final String separator;
    private final String value;

    public AttributeElement(Element parentElements, String field, String separator, String value) {
        super(parentElements);
        this.field = field;
        this.separator = separator;
        this.value = value;
    }

    @Override
    public String getElement() {
        String parentElementsString = "";
        if (getParentElements() != null) {
            parentElementsString = getParentElements().getElement();
        }
        if (Strings.isNullOrEmpty(value)){
            return parentElementsString;
        }
        return parentElementsString + " " + field + separator + "\"" + value + "\"";
    }
    
}
