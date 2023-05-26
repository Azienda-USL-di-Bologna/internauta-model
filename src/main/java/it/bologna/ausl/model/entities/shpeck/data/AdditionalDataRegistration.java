package it.bologna.ausl.model.entities.shpeck.data;

import com.fasterxml.jackson.annotation.JsonInclude;
import it.bologna.ausl.model.entities.data.AdditionalDataShpeck;

/**
 *
 * @author gdm
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
//    @JsonTypeInfo(
//        use = JsonTypeInfo.Id.NAME,
//        include = JsonTypeInfo.As.PROPERTY,
//        property = "classType")
//    @JsonSubTypes({
//        @JsonSubTypes.Type(value = AdditionalDataRegistration.class, name = "AdditionalDataRegistration")
//    })AdditionalDataShpeck
public class AdditionalDataRegistration extends AdditionalDataShpeck {

    public AdditionalDataTagComponent.idPec idPec;
    public AdditionalDataTagComponent.idUtente idUtente;
    public AdditionalDataTagComponent.idAzienda idAzienda;
    public AdditionalDataTagComponent.idDocumento idDocumento;
    public String casellaPec;

    public AdditionalDataRegistration() {
    }

    public AdditionalDataRegistration(AdditionalDataTagComponent.idPec idPec, AdditionalDataTagComponent.idUtente idUtente, AdditionalDataTagComponent.idAzienda idAzienda, AdditionalDataTagComponent.idDocumento idDocumento, String casellaPec) {
        this.idPec = idPec;
        this.idUtente = idUtente;
        this.idAzienda = idAzienda;
        this.idDocumento = idDocumento;
        this.casellaPec = casellaPec;
    }

    public AdditionalDataTagComponent.idPec getIdPec() {
        return idPec;
    }

    public void setIdPec(AdditionalDataTagComponent.idPec idPec) {
        this.idPec = idPec;
    }

    public AdditionalDataTagComponent.idUtente getIdUtente() {
        return idUtente;
    }

    public void setIdUtente(AdditionalDataTagComponent.idUtente idUtente) {
        this.idUtente = idUtente;
    }

    public AdditionalDataTagComponent.idAzienda getIdAzienda() {
        return idAzienda;
    }

    public void setIdAzienda(AdditionalDataTagComponent.idAzienda idAzienda) {
        this.idAzienda = idAzienda;
    }

    public AdditionalDataTagComponent.idDocumento getIdDocumento() {
        return idDocumento;
    }

    public void setIdDocumento(AdditionalDataTagComponent.idDocumento idDocumento) {
        this.idDocumento = idDocumento;
    }

//    @Override
//    public String getClassType() {
//        return classType;
//    }
//
//    @Override
//    public void setClassType(String classType) {
//        this.classType = classType;
//    }
    public String getCasellaPec() {
        return casellaPec;
    }

    public void setCasellaPec(String casellaPec) {
        this.casellaPec = casellaPec;
    }
}
