/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.caelum.vraptor.taglib.elements;

import java.util.List;

/**
 *
 * @author robsonrodrigues
 */
public class SelectItemsElement extends ComponentElement{

    public SelectItemsElement(Element parentElements, OptionElement content) {        
        super(parentElements, "select", content.getElement());
    }
    
}
