/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.bologna.ausl.model.entities.baborg;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Cacheable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedStoredProcedureQuery;
import javax.persistence.ParameterMode;
import javax.persistence.StoredProcedureParameter;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

/**
 *
 * @author fayssel
 */
@Entity
@Table(name = "ribaltoni_da_lanciare", catalog = "internauta", schema = "ribaltone_utils")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Cacheable(false)
@NamedStoredProcedureQuery(name = "ribaltone_utils.inserisci_ribaltone_da_lanciare", procedureName = "ribaltone_utils.inserisci_ribaltone_da_lanciare",
        parameters = {
            @StoredProcedureParameter(mode = ParameterMode.IN, name = "codice_azienda", type = String.class),
            @StoredProcedureParameter(mode = ParameterMode.IN, name = "indirizzo_mail", type = String.class),
            @StoredProcedureParameter(mode = ParameterMode.IN, name = "id_utente", type = Integer.class)
        }
)
public class RibaltoniDaLanciare implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Size(max = 2147483647)
    @Column(name = "codice_azienda")
    private String codiceAzienda;
    @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="Invalid email")//if the field contains email address consider using this annotation to enforce field validation
    @Size(max = 2147483647)
    @Column(name = "email")
    private String email;
    @Size(max = 2147483647)
    @Column(name = "stato")
    private String stato;
    @Column(name = "data_inserimento_riga")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dataInserimentoRiga;
    @Column(name = "data_ultima_modifica")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dataUltimaModifica;

    public RibaltoniDaLanciare() {
    }

    public RibaltoniDaLanciare(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCodiceAzienda() {
        return codiceAzienda;
    }

    public void setCodiceAzienda(String codiceAzienda) {
        this.codiceAzienda = codiceAzienda;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getStato() {
        return stato;
    }

    public void setStato(String stato) {
        this.stato = stato;
    }

    public Date getDataInserimentoRiga() {
        return dataInserimentoRiga;
    }

    public void setDataInserimentoRiga(Date dataInserimentoRiga) {
        this.dataInserimentoRiga = dataInserimentoRiga;
    }

    public Date getDataUltimaModifica() {
        return dataUltimaModifica;
    }

    public void setDataUltimaModifica(Date dataUltimaModifica) {
        this.dataUltimaModifica = dataUltimaModifica;
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
        if (!(object instanceof RibaltoniDaLanciare)) {
            return false;
        }
        RibaltoniDaLanciare other = (RibaltoniDaLanciare) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "it.bologna.ausl.baborg.model.entities.RibaltoniDaLanciare[ id=" + id + " ]";
    }
    
}
