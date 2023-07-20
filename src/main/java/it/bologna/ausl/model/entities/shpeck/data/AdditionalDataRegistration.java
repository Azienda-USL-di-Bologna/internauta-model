package it.bologna.ausl.model.entities.shpeck.data;

import com.fasterxml.jackson.annotation.JsonInclude;
import it.bologna.ausl.model.entities.baborg.Azienda;
import it.bologna.ausl.model.entities.baborg.Pec;
import it.bologna.ausl.model.entities.baborg.Utente;
import it.bologna.ausl.model.entities.data.AdditionalDataShpeck;

/**
 *
 * @author gdm
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class AdditionalDataRegistration extends AdditionalDataShpeck {

    private AdditionalDataTagComponent.idPec idPec;
    private AdditionalDataTagComponent.idUtente idUtente;
    private AdditionalDataTagComponent.idAzienda idAzienda;
    private AdditionalDataTagComponent.idDocumento idDocumento;
    private String casellaPec;

    public AdditionalDataRegistration() {
    }

    public AdditionalDataRegistration(AdditionalDataTagComponent.idPec idPec, AdditionalDataTagComponent.idUtente idUtente, AdditionalDataTagComponent.idAzienda idAzienda, AdditionalDataTagComponent.idDocumento idDocumento, String casellaPec) {
        this.idPec = idPec;
        this.idUtente = idUtente;
        this.idAzienda = idAzienda;
        this.idDocumento = idDocumento;
        this.casellaPec = casellaPec;
    }
    
    /**
     *
     * @param idPec
     * @param idUtente
     * @param idAzienda
     * @param casellaPec
     */
    public AdditionalDataRegistration(Pec idPec, Utente idUtente, Azienda idAzienda, String casellaPec) {
        
        AdditionalDataTagComponent.idPec pec = new AdditionalDataTagComponent.idPec();
        pec.setId(idPec.getId().toString());
        pec.setIndirizzo(idPec.getIndirizzo());
        this.idPec = pec;
        
        AdditionalDataTagComponent.idUtente utente = new AdditionalDataTagComponent.idUtente();
        utente.setId(idUtente.getId());
        utente.setDescrizione(idUtente.getIdPersona().getDescrizione());
        this.idUtente = utente;
        
        
        AdditionalDataTagComponent.idAzienda azienda = new AdditionalDataTagComponent.idAzienda();
        azienda.setId(idAzienda.getId());
        azienda.setDescrizione(idAzienda.getDescrizione());
        azienda.setNome(idAzienda.getNome());
        this.idAzienda = azienda;
        
        this.casellaPec = idPec.getIndirizzo();
    }
//    @Override
//    public String getClassType() {
//        return getClass().getCanonicalName();
//    }
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

    public String getCasellaPec() {
        return casellaPec;
    }

    public void setCasellaPec(String casellaPec) {
        this.casellaPec = casellaPec;
    }
}
