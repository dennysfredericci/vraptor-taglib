/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.caelum.vraptor.taglib.elements;

/**
 *
 * @author robsonrodrigues
 */
public class OptionElement extends Element{

    private final String value;
    private final String content;

    public OptionElement(OptionElement optionElement, String value, String content) {
        super(optionElement);
        this.value = value;
        this.content = content;
    }
    
    @Override
    public String getElement() {
        String contentParent = "";
        if (getParentElements() != null){
            contentParent = getParentElements().getElement();
        }
        return contentParent + "\n<option value=\""+ value +"\">"+ content +"</option>";
    }
    
}
