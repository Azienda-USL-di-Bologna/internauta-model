package it.bologna.ausl.model.entities;

import java.lang.reflect.Field;

/**
 *
 * @author gusgus & gdm & chatgpt
 */
public abstract class AbstractJsonType {
    
    // Metodo equals generico per confrontare due oggetti JSON
    @Override
    public boolean equals(Object other) {
        try {
            Field[] declaredFields = this.getClass().getDeclaredFields();
            for (Field declaredField : declaredFields) {
                declaredField.setAccessible(true);
                Object valueThis = declaredField.get(this);
                Object valueOther = declaredField.get(other);
                
                if (valueThis == null && valueOther != null || valueThis != null && valueOther == null) {
                    return false;
                }
                
                if (valueThis != null && valueOther != null) {
                    if (!valueThis.equals(valueOther)) {
                        return false;
                    }
                }
            }
            
            return true;
        } catch (Exception ex) {
            return false;
        }
    }
}
