/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.caelum.vraptor.taglib.elements.atribute;

import br.com.caelum.vraptor.taglib.elements.Element;

/**
 *
 * @author Robson Ventura Rodrigues
 */
public class StyleElement extends AttributeElement{

    public StyleElement(Element parentElements, String value) {
        super(parentElements, "style", "=", value);
    }
    
}
