package it.bologna.ausl.model.entities.shpeck.data;

import com.fasterxml.jackson.annotation.JsonInclude;
import it.bologna.ausl.model.entities.data.AdditionalData;
import java.time.LocalDateTime;

/**
 *
 * @author gdm
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
//    @JsonTypeInfo(
//        use = JsonTypeInfo.Id.CLASS,
//        include = JsonTypeInfo.As.PROPERTY,
//        property = "classType")
//    @JsonSubTypes({
//        @JsonSubTypes.Type(value = AdditionalDataArchiviation.class, name = "AdditionalDataArchiviation"),
//    })
public class AdditionalDataArchiviation extends AdditionalData {

    public AdditionalDataTagComponent.IdGdDoc idGdDoc;
    public AdditionalDataTagComponent.idUtente idUtente;
    public AdditionalDataTagComponent.idAzienda idAzienda;
    public AdditionalDataTagComponent.idFascicolo idFascicolo;
    //public AdditionalDataTagComponent.idDoc idDoc;
    public AdditionalDataTagComponent.idArchivio idArchivio;
//    @JsonIgnore
    public LocalDateTime dataArchiviazione;
    
//    private String classType;

    public AdditionalDataArchiviation() {
    }

    public AdditionalDataArchiviation(AdditionalDataTagComponent.IdGdDoc idGdDoc, AdditionalDataTagComponent.idUtente idUtente, AdditionalDataTagComponent.idAzienda idAzienda, AdditionalDataTagComponent.idFascicolo idFascicolo, LocalDateTime dataArchiviazione) {
        this.idGdDoc = idGdDoc;
        this.idUtente = idUtente;
        this.idAzienda = idAzienda;
        this.idFascicolo = idFascicolo;
        this.dataArchiviazione = dataArchiviazione;
    }
    
    public AdditionalDataArchiviation(AdditionalDataTagComponent.idUtente idUtente, AdditionalDataTagComponent.idAzienda idAzienda, AdditionalDataTagComponent.idArchivio idArchivio, LocalDateTime dataArchiviazione) {
        this.idUtente = idUtente;
        this.idAzienda = idAzienda;
        this.idArchivio = idArchivio;
        this.dataArchiviazione = dataArchiviazione;
    }

    public AdditionalDataTagComponent.IdGdDoc getIdGdDoc() {
        return idGdDoc;
    }

    public void setIdGdDoc(AdditionalDataTagComponent.IdGdDoc idGdDoc) {
        this.idGdDoc = idGdDoc;
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

    public AdditionalDataTagComponent.idFascicolo getIdFascicolo() {
        return idFascicolo;
    }

    public void setIdFascicolo(AdditionalDataTagComponent.idFascicolo idFascicolo) {
        this.idFascicolo = idFascicolo;
    }
    
    public AdditionalDataTagComponent.idArchivio getIdArchivio() {
        return idArchivio;
    }

    public void setIdArchivio(AdditionalDataTagComponent.idArchivio idArchivio) {
        this.idArchivio = idArchivio;
    }

//    public AdditionalDataTagComponent.idDoc getIdDoc() {
//        return idDoc;
//    }
//
//    public void setIdDoc(AdditionalDataTagComponent.idDoc idDoc) {
//        this.idDoc = idDoc;
//    }

    public LocalDateTime getDataArchiviazione() {
        return dataArchiviazione;
    }

    public void setDataArchiviazione(LocalDateTime dataArchiviazione) {
        this.dataArchiviazione = dataArchiviazione;
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
}
