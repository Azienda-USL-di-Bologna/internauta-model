package it.bologna.ausl.model.entities.configuration;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import it.bologna.ausl.model.entities.scrivania.Attivita;
import it.bologna.ausl.model.entities.scrivania.AttivitaFatta;
import java.io.Serializable;
import java.util.List;
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
    @Column(name = "id", columnDefinition = "text")
    private String id;
    @Basic(optional = false)
    @NotNull
    @Column(name = "nome", columnDefinition = "text")
    private String nome;
    @Column(name = "base_url", columnDefinition = "text")
    private String baseUrl;
    @Column(name = "index_page", columnDefinition = "text")
    private String indexPage;
    @OneToMany(mappedBy = "idApplicazione", fetch = FetchType.LAZY, cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    @JsonBackReference(value = "attivitaList")
    private List<Attivita> attivitaList;
    @OneToMany(mappedBy = "idApplicazione", fetch = FetchType.LAZY, cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    @JsonBackReference(value = "attivitaFattaList")
    private List<AttivitaFatta> attivitaFattaList;

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

    public String getBaseUrl() {
        return baseUrl;
    }

    public void setBaseUrl(String baseUrl) {
        this.baseUrl = baseUrl;
    }

    public String getIndexPage() {
        return indexPage;
    }

    public void setIndexPage(String indexPage) {
        this.indexPage = indexPage;
    }

    public List<Attivita> getAttivitaList() {
        return attivitaList;
    }

    public void setAttivitaList(List<Attivita> attivitaList) {
        this.attivitaList = attivitaList;
    }

    public List<AttivitaFatta> getAttivitaFattaList() {
        return attivitaFattaList;
    }

    public void setAttivitaFattaList(List<AttivitaFatta> attivitaFattaList) {
        this.attivitaFattaList = attivitaFattaList;
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
        return "it.bologna.ausl.model.entities.configuration.Applicazioni[ id=" + id + " ]";
    }

}
