/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.bologna.ausl.model.entities.rubrica;

import it.bologna.ausl.model.entities.baborg.Persona;
import it.bologna.ausl.model.entities.baborg.Struttura;
import it.bologna.ausl.model.entities.baborg.Utente;
import java.time.ZonedDateTime;
import java.util.List;

/**
 *
 * @author Top
 */
public interface ContattoInterface {

    public boolean equals(Object object);

    public String getCodiceFiscale();

    public void setCodiceFiscale(String codiceFiscale);

    public String getRagioneSociale();

    public void setNome(String codiceFiscale);

    public String getNome();

    public void setCognome(String cognome);

    public String getCognome();

    public void setDescrizione(String descrizione);

    public String getDescrizione();

    public void setId(Integer id);

    public Integer getId();

    public Double getRanking();

    public void setRanking(Double ranking);

    public List<Contatto> getContattiContenuti();

    public void setContattiContenuti(List<Contatto> contattiContenuti);

    public String getPartitaIva();

    public void setPartitaIva(String partitaIva);

    public Contatto.TipoContatto getTipo();

    public void setTipo(Contatto.TipoContatto tipo);

    public Contatto.CategoriaContatto getCategoria();

    public void setCategoria(Contatto.CategoriaContatto categoria);

    public Utente getIdUtenteCreazione();

    public void setIdUtenteCreazione(Utente idUtenteCreazione);

    public Persona getIdPersonaCreazione();

    public void setIdPersonaCreazione(Persona idPersonaCreazione);

    public Integer[] getIdAziende();

    public void setIdAziende(Integer[] idAziende);

    public String getIdEsterno();

    public void setIdEsterno(String idEsterno);

    public String getProvenienza();

    public void setProvenienza(String provenienza);

    public Boolean getDaVerificare();

    public void setDaVerificare(Boolean daVerificare);

    public Boolean getProtocontatto();

    public void setProtocontatto(Boolean protocontatto);

    public Boolean getModificabile();

    public void setModificabile(Boolean modificabile);

    public Boolean getRiservato();

    public void setRiservato(Boolean riservato);

    public Boolean getEliminato();

    public void setEliminato(Boolean eliminato);

    public String getContattoErrato();

    public void setContattoErrato(String contattoErrato);

    public String getTscol();

    public void setTscol(String tscol);

    public ZonedDateTime getVersion();

    public void setVersion(ZonedDateTime version);

    public List<Contatto> getContattiFigliList();

    public void setContattiFigliList(List<Contatto> contattiList);

    public Contatto getIdContattoPadre();

    public void setIdContattoPadre(Contatto idContattoPadre);

    public List<GruppiContatti> getContattiDelGruppoList();

    public void setContattiDelGruppoList(List<GruppiContatti> gruppiContattiList1);

    public List<Telefono> getTelefonoList();

    public void setTelefonoList(List<Telefono> telefonoList);

    public List<Email> getEmailList();

    public void setEmailList(List<Email> emailList);

    public List<Indirizzo> getIndirizziList();

    public void setIndirizziList(List<Indirizzo> indirizziList);

    public Struttura getIdStruttura();

    public void setIdStruttura(Struttura idStruttura);

    public Persona getIdPersona();

    public void setIdPersona(Persona idPersona);

    public List<DettaglioContatto> getDettaglioContattoList();

    public void setDettaglioContattoList(List<DettaglioContatto> dettaglioContattoList);

    public List<GruppiContatti> getGruppiDelContattoList();

    public void setGruppiDelContattoList(List<GruppiContatti> gruppiDelContattoList);

    public String getTitolo();

    public void setTitolo(String titolo);

    public int hashCode();

    public String toString();

    public void setRagioneSociale(String ragioneSociale);
}
