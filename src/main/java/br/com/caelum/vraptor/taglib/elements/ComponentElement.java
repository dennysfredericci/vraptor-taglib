/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.caelum.vraptor.taglib.elements;

/**
 *
 * @author robsonrodrigues
 */
public class ComponentElement extends Element{

    private final String componentName;
    private final String content;

    public ComponentElement(Element parentElements, String componentName, String content) {
        super(parentElements);
        this.componentName = componentName;
        this.content = content;
    }

    @Override
    public String getElement() {
        String atributesElements = " ";
        if (getParentElements() != null){
            atributesElements += getParentElements().getElement();
        }
        return "<" + componentName + atributesElements + ">" + content + "</"+ componentName +">";
    }
    
}
