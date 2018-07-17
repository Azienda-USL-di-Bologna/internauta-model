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
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author solidus83
 */
@Entity
@Table(name = "tipi_permesso", catalog = "internauta", schema = "organigramma")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class TipoPermesso implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 300)
    @Column(name = "nome_permesso")
    private String nomePermesso;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 300)
    @Column(name = "ambito")
    private String ambito;
    @Size(max = 300)
    @Column(name = "nome_visualizzazione")
    private String nomeVisualizzazione;
    @Size(max = 300)
    @Column(name = "descrizione")
    private String descrizione;
    @OneToMany(mappedBy = "idTipoPermesso", fetch = FetchType.LAZY)
    @JsonBackReference(value = "permessoSet")
    private Set<Permesso> permessoSet;

    public TipoPermesso() {
    }

    public TipoPermesso(Integer id) {
        this.id = id;
    }

    public TipoPermesso(Integer id, String nomePermesso, String ambito) {
        this.id = id;
        this.nomePermesso = nomePermesso;
        this.ambito = ambito;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNomePermesso() {
        return nomePermesso;
    }

    public void setNomePermesso(String nomePermesso) {
        this.nomePermesso = nomePermesso;
    }

    public String getAmbito() {
        return ambito;
    }

    public void setAmbito(String ambito) {
        this.ambito = ambito;
    }

    public String getNomeVisualizzazione() {
        return nomeVisualizzazione;
    }

    public void setNomeVisualizzazione(String nomeVisualizzazione) {
        this.nomeVisualizzazione = nomeVisualizzazione;
    }

    public String getDescrizione() {
        return descrizione;
    }

    public void setDescrizione(String descrizione) {
        this.descrizione = descrizione;
    }

    public Set<Permesso> getPermessoSet() {
        return permessoSet;
    }

    public void setPermessoSet(Set<Permesso> permessoSet) {
        this.permessoSet = permessoSet;
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
        if (!(object instanceof TipoPermesso)) {
            return false;
        }
        TipoPermesso other = (TipoPermesso) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "it.bologna.ausl.baborg.model.entities.TipoPermesso[ id=" + id + " ]";
    }
    
}
