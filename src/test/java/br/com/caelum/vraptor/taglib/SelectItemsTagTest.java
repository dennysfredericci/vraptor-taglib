/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.caelum.vraptor.taglib;

import br.com.caelum.vraptor.taglib.elements.Element;
import br.com.caelum.vraptor.taglib.elements.OptionElement;
import br.com.caelum.vraptor.taglib.elements.SelectItemsElement;
import br.com.caelum.vraptor.taglib.elements.atribute.IdElement;
import br.com.caelum.vraptor.taglib.elements.atribute.NameElement;
import br.com.caelum.vraptor.taglib.elements.atribute.ValueElement;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.BeforeClass;

/**
 *
 * @author robsonrodrigues
 */
public class SelectItemsTagTest {
  
    @Test
    public void testDoStartTag() throws Exception {
        
        OptionElement optionElement = new OptionElement(null, "1", "Barra Mansa");
        optionElement = new OptionElement(optionElement, "2", "Volta Redonda");
        optionElement = new OptionElement(optionElement, "3", "Resende");
        
        Element element = new NameElement(null, "testName");
        element = new ValueElement(element, "valueName");
        element = new IdElement(element, "idTest");
        element = new SelectItemsElement(element, optionElement);
        
        String elementString = element.getElement();
        
        System.out.println(elementString);
    }
    
}
