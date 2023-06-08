package it.bologna.ausl.model.entities.shpeck.data;

import com.fasterxml.jackson.annotation.JsonInclude;
import it.bologna.ausl.model.entities.data.AdditionalDataShpeck;
import java.time.LocalDateTime;

/**
 *
 * @author gdm
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class AdditionalDataArchiviation extends AdditionalDataShpeck {

    private AdditionalDataTagComponent.IdGdDoc idGdDoc;
    private AdditionalDataTagComponent.idUtente idUtente;
    private AdditionalDataTagComponent.idAzienda idAzienda;
    private AdditionalDataTagComponent.idFascicolo idFascicolo;
    private AdditionalDataTagComponent.idArchivio idArchivio;
    private LocalDateTime dataArchiviazione;

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

    public LocalDateTime getDataArchiviazione() {
        return dataArchiviazione;
    }

    public void setDataArchiviazione(LocalDateTime dataArchiviazione) {
        this.dataArchiviazione = dataArchiviazione;
    }

}
