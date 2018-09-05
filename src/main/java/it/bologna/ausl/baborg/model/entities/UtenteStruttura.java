/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.bologna.ausl.baborg.model.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.io.Serializable;
import java.util.Set;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author solidus83
 */
@Entity
@Table(name = "utenti_strutture", catalog = "internauta", schema = "organigramma")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class UtenteStruttura implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @OneToMany(mappedBy = "idUtentiStrutture", fetch = FetchType.LAZY)
    @JsonBackReference(value = "permessoSet")
    private Set<Permesso> permessoSet;
    @JoinColumn(name = "id_afferenza_struttura", referencedColumnName = "id")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private AfferenzaStruttura idAfferenzaStruttura;
    @JoinColumn(name = "id_struttura", referencedColumnName = "id")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Struttura idStruttura;
    @JoinColumn(name = "id_utente", referencedColumnName = "id")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Utente idUtente;

    public UtenteStruttura() {
    }

    public UtenteStruttura(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Set<Permesso> getPermessoSet() {
        return permessoSet;
    }

    public void setPermessoSet(Set<Permesso> permessoSet) {
        this.permessoSet = permessoSet;
    }

    public AfferenzaStruttura getIdAfferenzaStruttura() {
        return idAfferenzaStruttura;
    }

    public void setIdAfferenzaStruttura(AfferenzaStruttura idAfferenzaStruttura) {
        this.idAfferenzaStruttura = idAfferenzaStruttura;
    }

    public Struttura getIdStruttura() {
        return idStruttura;
    }

    public void setIdStruttura(Struttura idStruttura) {
        this.idStruttura = idStruttura;
    }

    public Utente getIdUtente() {
        return idUtente;
    }

    public void setIdUtente(Utente idUtente) {
        this.idUtente = idUtente;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : super.hashCode());
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof UtenteStruttura)) {
            return false;
        }
        UtenteStruttura other = (UtenteStruttura) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "it.bologna.ausl.baborg.model.entities.UtenteStruttura[ id=" + id + " ]";
    }
    
}
