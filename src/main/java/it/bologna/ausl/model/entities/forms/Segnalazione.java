package it.bologna.ausl.model.entities.forms;

import it.bologna.ausl.model.entities.baborg.Struttura;
import it.bologna.ausl.model.entities.scrivania.AutorizzatoreModificheDocumentali;
import org.springframework.web.multipart.MultipartFile;

/**
 * Classe per mappare i campi della form "Invia Segnalazione Utente"
 * @author Giuseppe Russo <g.russo@nsi.it>
 */
public class Segnalazione {
    private String azienda;
    private String cognome;
    private String nome;
    private Struttura struttura;
    private String username;
    private String telefono;
    private String mail;
    private String oggetto;
    private String descrizione;
    private MultipartFile[] allegati;
    private String tipologiaSegnalazione;
    private AutorizzatoreModificheDocumentali autorizzatore;
    private String emailAutorizzatore;
    private String descrizioneAutorizzatore;

    public String getAzienda() {
        return azienda;
    }

    public void setAzienda(String azienda) {
        this.azienda = azienda;
    }

    public Struttura getStruttura() {
        return struttura;
    }

    public void setStruttura(Struttura struttura) {
        this.struttura = struttura;
    }

    public String getCognome() {
        return cognome;
    }

    public void setCognome(String cognome) {
        this.cognome = cognome;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getOggetto() {
        return oggetto;
    }

    public void setOggetto(String oggetto) {
        this.oggetto = oggetto;
    }

    public String getDescrizione() {
        return descrizione;
    }

    public void setDescrizione(String descrizione) {
        this.descrizione = descrizione;
    }

    public MultipartFile[] getAllegati() {
        return allegati;
    }

    public void setAllegati(MultipartFile[] allegati) {
        this.allegati = allegati;
    }

    public String getTipologiaSegnalazione() {
        return tipologiaSegnalazione;
    }

    public void setTipologiaSegnalazione(String tipologiaSegnalazione) {
        this.tipologiaSegnalazione = tipologiaSegnalazione;
    }

    public AutorizzatoreModificheDocumentali getAutorizzatore() {
        return autorizzatore;
    }

    public void setAutorizzatore(AutorizzatoreModificheDocumentali autorizzatore) {
        this.autorizzatore = autorizzatore;
    }

    public String getEmailAutorizzatore() {
        return emailAutorizzatore;
    }

    public void setEmailAutorizzatore(String emailAutorizzatore) {
        this.emailAutorizzatore = emailAutorizzatore;
    }

    public String getDescrizioneAutorizzatore() {
        return descrizioneAutorizzatore;
    }

    public void setDescrizioneAutorizzatore(String descrizioneAutorizzatore) {
        this.descrizioneAutorizzatore = descrizioneAutorizzatore;
    }
    
}
