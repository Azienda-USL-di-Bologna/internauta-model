package it.bologna.ausl.model.entities.shpeck.data;

import com.fasterxml.jackson.annotation.JsonInclude;
import it.bologna.ausl.model.entities.baborg.Pec;
import it.bologna.ausl.model.entities.baborg.Utente;
import it.bologna.ausl.model.entities.data.AdditionalDataShpeck;

/**
 *
 * @author Mido
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class AdditionalDataReaddressed extends AdditionalDataShpeck {

    private AdditionalDataTagComponent.idPec idPec;
    private AdditionalDataTagComponent.idUtente idUtente;

    public AdditionalDataReaddressed() {
    }

    
    public AdditionalDataReaddressed(Pec idPec, Utente idUtente) {
        AdditionalDataTagComponent.idPec pec = new AdditionalDataTagComponent.idPec();
        pec.setId(idPec.getId().toString());
        pec.setIndirizzo(idPec.getIndirizzo());
        this.idPec = pec;
        
        AdditionalDataTagComponent.idUtente utente = new AdditionalDataTagComponent.idUtente();
        utente.setId(idUtente.getId());
        utente.setDescrizione(idUtente.getIdPersona().getDescrizione());
        this.idUtente = utente;

    }
    
    public AdditionalDataReaddressed(AdditionalDataTagComponent.idPec idPec, AdditionalDataTagComponent.idUtente idUtente) {
        this.idPec = idPec;
        this.idUtente = idUtente;
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
    
    
    
}
