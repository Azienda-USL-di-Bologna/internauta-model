/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.bologna.ausl.model.entities.logs;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Utente
 */
@Entity
@Table(name = "operazioni_krint", catalog = "internauta", schema = "logs")
public class OperazioneKrint implements Serializable {
    
    public static enum CodiceOperazione{
        PEC_MESSAGE_SPOSTAMENTO,
        PEC_MESSAGE_PROTOCOLLAZIONE, 
        PEC_MESSAGE_REINDIRIZZAMENTO,
        PEC_MESSAGE_RISPOSTA, 
        PEC_MESSAGE_RISPOSTA_A_TUTTI, 
        PEC_MESSAGE_INOLTRO, 
        PEC_MESSAGE_AGGIUNTA_TAG,
        PEC_MESSAGE_ELIMINAZIONE_TAG,
        PEC_MESSAGE_LETTO,
        PEC_MESSAGE_DA_LEGGERE
    }

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "codice")
    private String codice;
    @Size(max = 2147483647)
    @Column(name = "descrizione")
    private String descrizione;

    public OperazioneKrint() {
    }

    public OperazioneKrint(Integer id) {
        this.id = id;
    }

    public OperazioneKrint(Integer id, String codice) {
        this.id = id;
        this.codice = codice;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCodice() {
        return codice;
    }

    public void setCodice(String codice) {
        this.codice = codice;
    }

    public String getDescrizione() {
        return descrizione;
    }

    public void setDescrizione(String descrizione) {
        this.descrizione = descrizione;
    }


    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof OperazioneKrint)) {
            return false;
        }
        OperazioneKrint other = (OperazioneKrint) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "it.bologna.ausl.model.entities.logs.OperazioniKrint[ id=" + id + " ]";
    }
    
}
