package it.bologna.ausl.model.entities.versatore;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.vladmihalcea.hibernate.type.json.JsonBinaryType;
import it.bologna.ausl.model.entities.baborg.Persona;
import it.bologna.ausl.model.entities.scripta.Archivio;
import it.bologna.ausl.model.entities.scripta.Doc;
import java.io.Serializable;
import java.time.ZonedDateTime;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Cacheable;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Version;
import javax.validation.constraints.NotNull;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;
import org.springframework.format.annotation.DateTimeFormat;

/**
 *
 * @author Giuseppe Russo <g.russo@nsi.it>
 */
@TypeDefs({
    @TypeDef(name = "jsonb", typeClass = JsonBinaryType.class)
})
@Entity
@Table(name = "versamenti", schema = "versatore")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Cacheable(false)
@DynamicUpdate
public class Versamento implements Serializable {
    
    public static enum StatoVersamento {
        IN_CARICO,
        FORZARE,
	VERSARE,
        AGGIORNARE,
	PARZIALE,
	VERSATO,
	ANNULLATO,
        IN_CARICO_CON_ERRORI,
        IN_CARICO_CON_ERRORI_RITENTABILI,
	ERRORE,
	ERRORE_RITENTABILE
    }

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    
    @JoinColumn(name = "id_doc", referencedColumnName = "id")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @JsonBackReference(value = "idDoc")
    private Doc idDoc;
    
    @JoinColumn(name = "id_sessione_versamento", referencedColumnName = "id")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @JsonBackReference(value = "idSessioneVersamento")
    private SessioneVersamento idSessioneVersamento;
    
    @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss.SSSSSSXXX'['VV']'")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss.SSSSSSXXX'['VV']'")
    @Column(name = "data")
    private ZonedDateTime data = ZonedDateTime.now();
    
    @Column(name = "stato")
    private String stato;
    
    @Column(name = "metadati_versati")
    private String metadatiVersati;
    
    @Column(name = "rapporto")
    private String rapporto;
    
    @Column(name = "codice_errore")
    private String codiceErrore;
    
    @Column(name = "descrizione_errore")
    private String descrizioneErrore;
        
    @JoinColumn(name = "id_archivio", referencedColumnName = "id")
    @ManyToOne(optional = true, fetch = FetchType.LAZY)
    @JsonBackReference(value = "idArchivio")
    private Archivio idArchivio;
    
    @Column(name = "ignora")
    @NotNull
    @Basic(optional = false)
    private Boolean ignora = false;
    
    @Column(name = "forzabile")
    @NotNull
    @Basic(optional = false)
    private Boolean forzabile = false;
    
    @JoinColumn(name = "id_versamento_ritentato", referencedColumnName = "id")
    @ManyToOne(optional = true, fetch = FetchType.LAZY)
    @JsonBackReference(value = "idVersamentoRitentato")
    private Versamento idVersamentoRitentato;
    
    @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss.SSSSSSXXX'['VV']'")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss.SSSSSSXXX'['VV']'")
    @Column(name = "data_inserimento")
    @Basic(optional = false)
    @NotNull
    private ZonedDateTime dataInserimento = ZonedDateTime.now();
    
    @JoinColumn(name = "id_persona_forzatura", referencedColumnName = "id")
    @ManyToOne(fetch = FetchType.EAGER, cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    @JsonBackReference(value = "idPersonaForzatura")
    private Persona idPersonaForzatura;
    
    @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss.SSSSSSXXX'['VV']'")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss.SSSSSSXXX'['VV']'")
    @Column(name = "data_forzatura")
    private ZonedDateTime dataForzatura;
    
    @OneToMany(cascade = {CascadeType.MERGE, CascadeType.PERSIST}, mappedBy = "idVersamento", fetch = FetchType.LAZY)
    @JsonBackReference(value = "versamentoAllegatoList")
    private List<VersamentoAllegato> versamentoAllegatoList;
        
    @Version()
    @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss.SSSSSSXXX'['VV']'")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss.SSSSSSXXX'['VV']'")
    private ZonedDateTime version;

    public Versamento() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Doc getIdDoc() {
        return idDoc;
    }

    public void setIdDoc(Doc idDoc) {
        this.idDoc = idDoc;
    }

    public SessioneVersamento getIdSessioneVersamento() {
        return idSessioneVersamento;
    }

    public void setIdSessioneVersamento(SessioneVersamento idSessioneVersamento) {
        this.idSessioneVersamento = idSessioneVersamento;
    }

    public ZonedDateTime getData() {
        return data;
    }

    public void setData(ZonedDateTime data) {
        this.data = data;
    }

    public StatoVersamento getStato() {
        if (stato != null) {
            return StatoVersamento.valueOf(stato);
        } else {
            return null;
        }
    }

    public void setStato(StatoVersamento stato) {
        if (stato != null) {
            this.stato = stato.toString();
        } else {
            this.stato = null;
        }
    }

    public String getMetadatiVersati() {
        return metadatiVersati;
    }

    public void setMetadatiVersati(String metadatiVersati) {
        this.metadatiVersati = metadatiVersati;
    }

    public String getRapporto() {
        return rapporto;
    }

    public void setRapporto(String rapporto) {
        this.rapporto = rapporto;
    }

    public String getCodiceErrore() {
        return codiceErrore;
    }

    public void setCodiceErrore(String codiceErrore) {
        this.codiceErrore = codiceErrore;
    }

    public String getDescrizioneErrore() {
        return descrizioneErrore;
    }

    public void setDescrizioneErrore(String descrizioneErrore) {
        this.descrizioneErrore = descrizioneErrore;
    }

    public ZonedDateTime getDataInserimento() {
        return dataInserimento;
    }

    public void setDataInserimento(ZonedDateTime dataInserimento) {
        this.dataInserimento = dataInserimento;
    }

    public Persona getIdPersonaForzatura() {
        return idPersonaForzatura;
    }

    public void setIdPersonaForzatura(Persona idPersonaForzatura) {
        this.idPersonaForzatura = idPersonaForzatura;
    }

    public ZonedDateTime getDataForzatura() {
        return dataForzatura;
    }

    public void setDataForzatura(ZonedDateTime dataForzatura) {
        this.dataForzatura = dataForzatura;
    }

    public Archivio getIdArchivio() {
        return idArchivio;
    }

    public void setIdArchivio(Archivio idArchivio) {
        this.idArchivio = idArchivio;
    }

    public Boolean getIgnora() {
        return ignora;
    }

    public void setIgnora(Boolean ignora) {
        this.ignora = ignora;
    }

    public Boolean getForzabile() {
        return forzabile;
    }

    public void setForzabile(Boolean forzabile) {
        this.forzabile = forzabile;
    }

    public Versamento getIdVersamentoRitentato() {
        return idVersamentoRitentato;
    }

    public void setIdVersamentoRitentato(Versamento idVersamentoRitentato) {
        this.idVersamentoRitentato = idVersamentoRitentato;
    }

    public List<VersamentoAllegato> getVersamentoAllegatoList() {
        return versamentoAllegatoList;
    }

    public void setVersamentoAllegatoList(List<VersamentoAllegato> versamentoAllegatoList) {
        this.versamentoAllegatoList = versamentoAllegatoList;
    }

    public ZonedDateTime getVersion() {
        return version;
    }

    public void setVersion(ZonedDateTime version) {
        this.version = version;
    }
    
    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Versamento)) {
            return false;
        }
        Versamento other = (Versamento) object;
        return !((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id)));
    }

    @Override
    public String toString() {
        return getClass().getCanonicalName()+ "[ id=" + id + " ]";
    }

}
