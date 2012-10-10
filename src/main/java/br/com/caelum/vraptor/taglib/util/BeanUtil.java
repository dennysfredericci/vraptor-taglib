/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.caelum.vraptor.taglib.util;

import java.lang.reflect.InvocationTargetException;
import org.apache.commons.beanutils.PropertyUtils;

/**
 *
 * @author robson.rodrigues
 */
public class BeanUtil {
    
    public static Object getAtributeValue(Object instance, String atributeName) throws IllegalAccessException, InvocationTargetException, NoSuchMethodException{
        return PropertyUtils.getProperty(instance, atributeName);
    }
    
}
