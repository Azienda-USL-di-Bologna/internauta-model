package it.bologna.ausl.model.entities.configurazione;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import it.nextsw.common.annotations.GenerateProjections;
import it.bologna.ausl.model.entities.scrivania.Attivita;
import it.bologna.ausl.model.entities.scrivania.AttivitaFatta;
import it.bologna.ausl.model.entities.scrivania.Menu;
import java.io.Serializable;
import java.time.ZonedDateTime;
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
import javax.persistence.Version;
import javax.validation.constraints.NotNull;
import org.hibernate.annotations.DynamicUpdate;
import org.springframework.format.annotation.DateTimeFormat;

/**
 *
 * @author spritz
 */
@Entity
@Table(name = "applicazioni", catalog = "internauta", schema = "configurazione")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Cacheable(false)
@GenerateProjections({})
@DynamicUpdate
public class Applicazione implements Serializable {

    private static final long serialVersionUID = 1L;

    public static enum Applicazioni {
        scrivania, babel, deli, dete, procton, verba, ribaltorg, pecg, gedi, baborg, gipi, shpeck, firmone, myaliseo, rubrica, scripta, ngipi
    }

    public static enum ApplicazioniIntimus {
        scrivania, baborg, shpeck, scripta, ngipi
    }

    public static enum UrlsGenerationStrategy {
        TRUSTED_URL_WITH_CONTEXT_INFORMATION,
        TRUSTED_URL_WITHOUT_CONTEXT_INFORMATION,
        RELATIVE_WITH_CONTEXT_INFORMATION,
        RELATIVE_WITHOUT_CONTEXT_INFORMATION,
        ABSOLUTE_WITH_CONTEXT_INFORMATION,
        ABSOLUTE_WITHOUT_CONTEXT_INFORMATION
    }

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

    @OneToMany(mappedBy = "idApplicazione", fetch = FetchType.LAZY, cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    @JsonBackReference(value = "menuList")
    private List<Menu> menuList;

    @OneToMany(mappedBy = "idApplicazione", fetch = FetchType.LAZY, cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    @JsonBackReference(value = "impostazioniApplicazioniList")
    private List<ImpostazioniApplicazioni> impostazioniApplicazioniList;

    @Column(name = "url_generation_strategy", columnDefinition = "text")
    @Basic(optional = false)
    @NotNull
    private String urlGenerationStrategy;

    @Version()
    @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss.SSSSSSXXX'['VV']'")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss.SSSSSSXXX'['VV']'")
    private ZonedDateTime version;

    public ZonedDateTime getVersion() {
        return version;
    }

    public void setVersion(ZonedDateTime version) {
        this.version = version;
    }

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

    public List<Menu> getMenuList() {
        return menuList;
    }

    public void setMenuList(List<Menu> menuList) {
        this.menuList = menuList;
    }

    public List<ImpostazioniApplicazioni> getImpostazioniApplicazioniList() {
        return impostazioniApplicazioniList;
    }

    public void setImpostazioniApplicazioniList(List<ImpostazioniApplicazioni> impostazioniApplicazioniList) {
        this.impostazioniApplicazioniList = impostazioniApplicazioniList;
    }

    public UrlsGenerationStrategy getUrlGenerationStrategy() {
        return UrlsGenerationStrategy.valueOf(urlGenerationStrategy);
    }

    public void setUrlGenerationStrategy(UrlsGenerationStrategy urlGenerationStrategy) {
        this.urlGenerationStrategy = urlGenerationStrategy.toString();
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
