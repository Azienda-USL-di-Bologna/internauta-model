/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.bologna.ausl.model.entities.rubrica;

import java.time.ZonedDateTime;
import java.util.List;

/**
 *
 * @author Top
 */
public interface DettaglioContattoInterface {

    public String getMezzo();

    public void setMezzo(String mezzo);

    public String getTscol();

    public void setTscol(String tscol);

    public Integer getId();

    public void setId(Integer id);

    public String getDescrizione();

    public void setDescrizione(String descrizione);

    public Contatto getIdContatto();

    public void setIdContatto(Contatto idContatto);

    public List<GruppiContatti> getGruppiDelDettaglioList();

    public void setGruppiDelDettaglioList(List<GruppiContatti> gruppiDelDettaglioList);

    public Telefono getTelefono();

    public void setTelefono(Telefono telefono);

    public Email getEmail();

    public Boolean getEliminato();

    public void setEliminato(Boolean eliminato);

    public void setEmail(Email email);

    public Indirizzo getIndirizzo();

    public void setIndirizzo(Indirizzo indirizzo);

    public Contatto getIdContattoEsterno();

    public void setIdContattoEsterno(Contatto idContattoEsterno);

    public Boolean getPrincipale();

    public void setPrincipale(Boolean principale);
    
    public Boolean getDomicilioDigitale();

    public void setDomicilioDigitale(Boolean principale);

    public ZonedDateTime getVersion();

    public void setVersion(ZonedDateTime version);

    public int hashCode();

    public boolean equals(Object object);

    public String toString();
}
