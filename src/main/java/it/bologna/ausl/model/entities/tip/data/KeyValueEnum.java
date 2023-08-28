package it.bologna.ausl.model.entities.tip.data;

/**
 *
 * @author gdm
 * @param <T> indentifica il tipo del valore della chiave enum
 */
public interface KeyValueEnum<T> {
        
    /**
     * torna il valore associato alla chiave enum
     * @return 
     */
    public T getValue();
    
    public static <T extends KeyValueEnum<?>> T findEnumKeyFromValue(Object toFind, Class<T> aEnum) {
        T[] values = aEnum.getEnumConstants();
        T foundKey = null;
        for (T key : values) {
            Object value = key.getValue();
            if (value.equals(toFind)) {
                foundKey = key;
            }
        }
        return foundKey;
    }
}
