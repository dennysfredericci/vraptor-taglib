/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.caelum.vraptor.taglib.elements.atribute;

import br.com.caelum.vraptor.taglib.elements.Element;

/**
 *
 * @author Robson Ventura Rodrigues robsonvnt@gmail.com
 */
public class ValueElement extends AttributeElements{

    public ValueElement(Element parentElements, String value) {
        super(parentElements, "name", "=", value);
    }
    
}
