package it.bologna.ausl.model.entities.configuration;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import it.bologna.ausl.model.entities.scrivania.Attivita;
import it.bologna.ausl.model.entities.scrivania.AttivitaFatta;
import java.io.Serializable;
import java.util.Set;
import javax.persistence.Basic;
import javax.persistence.Cacheable;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author spritz
 */
@Entity
@Table(name = "applicazioni", catalog = "internauta", schema = "configurazione")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Cacheable(false)
public class Applicazione implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = Integer.SIZE)
    @Column(name = "id")
    private String id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = Integer.SIZE)
    @Column(name = "nome")
    private String nome;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idApplicazione", fetch = FetchType.LAZY)
    @JsonBackReference(value = "attivitaSet")
    private Set<Attivita> attivitaSet;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idApplicazione", fetch = FetchType.LAZY)
    @JsonBackReference(value = "attivitaFattaSet")
    private Set<AttivitaFatta> attivitaFattaSet;

    public Applicazione() {
    }

    public Applicazione(String id) {
        this.id = id;
    }

    public Applicazione(String id, String nome) {
        this.id = id;
        this.nome = nome;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Set<Attivita> getAttivitaSet() {
        return attivitaSet;
    }

    public void setAttivitaSet(Set<Attivita> attivitaSet) {
        this.attivitaSet = attivitaSet;
    }

    public Set<AttivitaFatta> getAttivitaFattaSet() {
        return attivitaFattaSet;
    }

    public void setAttivitaFattaSet(Set<AttivitaFatta> attivitaFattaSet) {
        this.attivitaFattaSet = attivitaFattaSet;
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
        if (!(object instanceof Applicazione)) {
            return false;
        }
        Applicazione other = (Applicazione) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "it.bologna.ausl.configuration.model.entities.Applicazioni[ id=" + id + " ]";
    }
    
}
