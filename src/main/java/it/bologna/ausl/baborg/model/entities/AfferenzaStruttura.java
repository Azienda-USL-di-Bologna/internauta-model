package it.bologna.ausl.baborg.model.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.io.Serializable;
import java.util.Set;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author solidus83
 */
@Entity
@Table(name = "afferenza_struttura", catalog = "internauta", schema = "organigramma")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class AfferenzaStruttura implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2147483647)
    @Column(name = "descrizione")
    private String descrizione;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2147483647)
    @Column(name = "codice")
    private String codice;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idAfferenzaStruttura", fetch = FetchType.LAZY)
    @JsonBackReference(value = "utenteStrutturaSet")
    private Set<UtenteStruttura> utenteStrutturaSet;

    public static enum CodiciAfferenzaStruttura {
        DIRETTA, FUNZIONALE
    }
        
    public AfferenzaStruttura() {
    }

    public AfferenzaStruttura(Integer id) {
        this.id = id;
    }

    public AfferenzaStruttura(Integer id, String descrizione, String codice) {
        this.id = id;
        this.descrizione = descrizione;
        this.codice = codice;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDescrizione() {
        return descrizione;
    }

    public void setDescrizione(String descrizione) {
        this.descrizione = descrizione;
    }

    public CodiciAfferenzaStruttura getCodice() {
        return CodiciAfferenzaStruttura.valueOf(codice);
    }

    public void setCodice(CodiciAfferenzaStruttura codice) {
        this.codice = codice.toString();
    }

    public Set<UtenteStruttura> getUtenteStrutturaSet() {
        return utenteStrutturaSet;
    }

    public void setUtenteStrutturaSet(Set<UtenteStruttura> utenteStrutturaSet) {
        this.utenteStrutturaSet = utenteStrutturaSet;
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
        if (!(object instanceof AfferenzaStruttura)) {
            return false;
        }
        AfferenzaStruttura other = (AfferenzaStruttura) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "it.bologna.ausl.baborg.model.entities.AfferenzaStruttura[ id=" + id + " ]";
    }
    
}
