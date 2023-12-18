package it.bologna.ausl.model.entities.scripta.annotations;

import it.bologna.ausl.model.entities.scripta.annotations.NextSdrClonable.NextSdrClonableParams;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

/**
 *
 * @author Michele D'Onza
 * @param <T>
 * @param <P>
 */
public interface NextSdrClonable<T, P extends NextSdrClonableParams>  {

    public <K extends NextSdrClonable> K cloneChild(P params, K value) throws CloneEntityException;
    
    public default <T> T cloneEntity(P params) throws CloneEntityException {
        List<Field> fieldsFromAnnotation = NextSdrClonable.getFieldsFromAnnotation(this.getClass(), CloneField.class);
        for (Field field : fieldsFromAnnotation) {
            if (field.getAnnotation(CloneField.class).deep()){
                try {
                    Object value = field.get(this);
                    if (value != null && 
                            Collection.class.isAssignableFrom(value.getClass()) && 
                            /*se lista di attore devo prendere attore se attore è proxyobject o è assegnabile*/
                            
                            ){
                    
                    }else {
                        if(value != null && NextSdrClonable.isEntityClassFromProxyObject(value.getClass()) && NextSdrClonable.class.isAssignableFrom(value.getClass())){
                            this.cloneChild(params, (NextSdrClonable) value);
                        }
                    }
                } catch (IllegalArgumentException | IllegalAccessException ex) {
                    throw new CloneEntityException("Errore nella clonazione dell'archivio", ex);
                }
                
            }else{
            //TODO: cosa devo fare su i campi non deep
            }
        }
       return null;
    }
    
    public static List<Field> getFieldsFromAnnotation(Class classz, Class annotationClass) {
        if (!annotationClass.isAnnotation()) {
            throw new RuntimeException(String.format("annotationClass deve essere un'annotazione"));
        }
        
        List<Field> declaredFields = new ArrayList(Arrays.asList(classz.getDeclaredFields()));
        Class superclass = classz.getSuperclass();
        while (superclass != null) {
            declaredFields.addAll(new ArrayList(Arrays.asList(superclass.getDeclaredFields())));
            superclass = superclass.getSuperclass();
        }
        List<Field> res = new ArrayList();
        for (Field declaredField : declaredFields) {
            if (declaredField.getAnnotation(annotationClass) != null) {
                res.add(declaredField);
                break;
            }
        }
        return res;
    }
    
    public static boolean isEntityClassFromProxyObject(Class classz) {
        java.lang.annotation.Annotation annotation = null;
        Class superclass = classz;
        while (superclass != null && annotation == null) {
            annotation = superclass.getAnnotation(javax.persistence.Entity.class);
            superclass = superclass.getSuperclass();
        }
        return annotation != null;
    }
    
    public interface NextSdrClonableParams {
        
    }
    
    
    public class CloneEntityException extends Exception {

        public CloneEntityException(String string) {
            super(string);
        }

        public CloneEntityException(String string, Throwable thrwbl) {
            super(string, thrwbl);
        }

        public CloneEntityException(Throwable thrwbl) {
            super(thrwbl);
        }
    
    }
    
}
