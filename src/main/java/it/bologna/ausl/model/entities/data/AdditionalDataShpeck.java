package it.bologna.ausl.model.entities.data;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import it.bologna.ausl.model.entities.shpeck.data.AdditionalDataArchiviation;
import it.bologna.ausl.model.entities.shpeck.data.AdditionalDataReaddressed;
import it.bologna.ausl.model.entities.shpeck.data.AdditionalDataRegistration;
import java.io.Serializable;
import java.util.List;

/**
 *
 * @author gdm
 */
@JsonTypeInfo(
        use = JsonTypeInfo.Id.NAME,
        include = JsonTypeInfo.As.PROPERTY,
        property = "classType")
@JsonSubTypes({
    @JsonSubTypes.Type(value = AdditionalDataArchiviation.class, name = "AdditionalDataArchiviation"),
    @JsonSubTypes.Type(value = AdditionalDataReaddressed.class, name = "AdditionalDataReaddressed"),
    @JsonSubTypes.Type(value = AdditionalDataRegistration.class, name = "AdditionalDataRegistration")
})
public abstract class AdditionalDataShpeck implements Serializable {
    
//    protected String classType;
//
//    public String getClassType() {
//        return classType;
//    }
//
//    public void setClassType(String classType) {
//        this.classType = classType;
//    }

//    public abstract String getClassType();
//
//    public abstract void setClassType(String classType);
    
    public static String toJsonString(ObjectMapper objectMapper, List<? extends AdditionalDataShpeck> value) throws JsonProcessingException {
        return objectMapper.writerFor(objectMapper.getTypeFactory().constructCollectionType(List.class, AdditionalDataShpeck.class)).writeValueAsString(value);
    }
    
    public static List<AdditionalDataShpeck> fromJsonString(ObjectMapper objectMapper, String value) throws JsonProcessingException {
        return objectMapper.readValue(value, new TypeReference<List<AdditionalDataShpeck>>() {});
    }
    
//    public static <T extends AdditionalDataShpeck> List<T> fromJsonString(ObjectMapper objectMapper, String value, Class<T> specificAdditionalDataClass ) throws JsonProcessingException {
//        return objectMapper.readValue(value, new TypeReference<List<T>>() {});
//    }
}
