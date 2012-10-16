/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.caelum.vraptor.taglib.elements;

/**
 *
 * @author Robson Ventura Rodrigues robsonvnt@gmail.com
 */
public abstract class Element {
    
    private Element parentElements;

    public Element(Element parentElements) {
        this.parentElements = parentElements;
    }

    public Element getParentElements() {
        return parentElements;
    }
    
    public abstract String getElement();
    
}
