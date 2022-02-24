package it.bologna.ausl.model.entities.scripta;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.vladmihalcea.hibernate.type.json.JsonBinaryType;
import it.bologna.ausl.model.entities.baborg.Azienda;
import it.bologna.ausl.model.entities.baborg.Persona;
import it.bologna.ausl.model.entities.baborg.Struttura;
import it.nextsw.common.annotations.GenerateProjections;
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
import org.hibernate.annotations.Formula;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;
import org.hibernate.annotations.Where;
import org.springframework.format.annotation.DateTimeFormat;

/**
 *
 * @author gusgus
 */
@TypeDefs({
    @TypeDef(name = "jsonb", typeClass = JsonBinaryType.class)
})
@Entity
@Table(name = "archivi_details", catalog = "internauta", schema = "scripta")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Cacheable(false)
@GenerateProjections({"idArchivioPadre, archiviFigliList", "archiviFigliList,archiviNipotiList"})
@DynamicUpdate
public class ArchivioDetail implements Serializable, ArchivioDetailInterface {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;

    @JoinColumn(name = "id_azienda", referencedColumnName = "id")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Azienda idAzienda;

    @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss.SSSSSSXXX'['VV']'")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss.SSSSSSXXX'['VV']'")
    @Column(name = "data_creazione")
    @Basic(optional = false)
    @NotNull
    private ZonedDateTime dataCreazione;

    @JoinColumn(name = "id_archivio_padre", referencedColumnName = "id")
    @ManyToOne(fetch = FetchType.LAZY, cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    @JsonBackReference(value = "idArchivioPadre")
    private ArchivioDetail idArchivioPadre;

    @OneToMany(mappedBy = "idArchivioPadre", fetch = FetchType.LAZY, cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    @JsonBackReference(value = "archiviFigliList")
    private List<ArchivioDetail> archiviFigliList;

    @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss.SSSSSSXXX'['VV']'")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss.SSSSSSXXX'['VV']'")
    @Column(name = "data_creazione_padre")
    @Basic(optional = false)
    @NotNull
    private ZonedDateTime dataCreazionePadre;

    @JoinColumn(name = "id_archivio_radice", referencedColumnName = "id")
    @ManyToOne(fetch = FetchType.LAZY, cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    @JsonBackReference(value = "idArchivioRadice")
    private ArchivioDetail idArchivioRadice;

    @OneToMany(mappedBy = "idArchivioRadice", fetch = FetchType.LAZY, cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    @Where(clause = "livello = 3")
    @JsonBackReference(value = "archiviNipotiList")
    private List<ArchivioDetail> archiviNipotiList;

    @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss.SSSSSSXXX'['VV']'")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss.SSSSSSXXX'['VV']'")
    @Column(name = "data_creazione_radice")
    @Basic(optional = false)
    @NotNull
    private ZonedDateTime dataCreazioneRadice;

    @Column(name = "foglia")
    private Boolean foglia;

    @Column(name = "numero")
    private Integer numero;

    @Column(name = "anno")
    private Integer anno;

    @Column(name = "numerazione_gerarchica")
    private String numerazioneGerarchica;

    @Column(name = "oggetto")
    private String oggetto;

    @Column(name = "oggetto_tscol", columnDefinition = "tsvector")
    private String oggettoTscol;

    @Formula("(select ts_rank(oggetto_tscol, to_tsquery('italian',$${oggetto_tscol.PLACEHOLDER_TS_RANK}$$), 8 | 1))")
    private Double rankingOggetto;

    @Column(name = "stato")
    private String stato;

    @Column(name = "tipo")
    private String tipo;

    @Column(name = "livello")
    private Integer livello;

    @JoinColumn(name = "id_persona_responsabile", referencedColumnName = "id")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Persona idPersonaResponsabile;

    @JoinColumn(name = "id_persona_creazione", referencedColumnName = "id")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Persona idPersonaCreazione;

    @JoinColumn(name = "id_struttura", referencedColumnName = "id")
    @ManyToOne(fetch = FetchType.LAZY, cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    @JsonBackReference(value = "idStruttura")
    private Struttura idStruttura;

    @Column(name = "id_titolo")
    private Integer idTitolo;

    @Type(type = "jsonb")
    @Column(name = "vicari", columnDefinition = "jsonb")
    private List<JsonNode> vicari;

    @Column(name = "tscol", columnDefinition = "tsvector")
    private String tscol;

    @Formula("(select ts_rank(tscol, to_tsquery('italian',$${tscol.PLACEHOLDER_TS_RANK}$$), 8 | 1))")
    private Double ranking;

    @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss.SSSSSSXXX'['VV']'")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss.SSSSSSXXX'['VV']'")
    @Column(name = "data_inserimento_riga")
    @Basic(optional = false)
    @NotNull
    private ZonedDateTime dataInserimentoRiga = ZonedDateTime.now();

    @Version()
    @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss.SSSSSSXXX'['VV']'")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss.SSSSSSXXX'['VV']'")
    private ZonedDateTime version;

    public ArchivioDetail() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Azienda getIdAzienda() {
        return idAzienda;
    }

    public void setIdAzienda(Azienda idAzienda) {
        this.idAzienda = idAzienda;
    }

    public ZonedDateTime getDataCreazione() {
        return dataCreazione;
    }

    public void setDataCreazione(ZonedDateTime dataCreazione) {
        this.dataCreazione = dataCreazione;
    }

    public ArchivioDetail getIdArchivioPadre() {
        return idArchivioPadre;
    }

    public void setIdArchivioPadre(ArchivioDetailInterface idArchivioPadre) {
        if (idArchivioPadre != null) {
            this.idArchivioPadre = (ArchivioDetail) idArchivioPadre;
        } else {
            this.idArchivioPadre = null;
        }
    }

    public List<ArchivioDetail> getArchiviFigliList() {
        return archiviFigliList;
    }

    public void setArchiviFigliList(List archiviFigliList) {
        if (archiviFigliList != null) {
            this.archiviFigliList = (List<ArchivioDetail>) archiviFigliList;
        } else {
            this.archiviFigliList = null;
        }
    }

    public ZonedDateTime getDataCreazionePadre() {
        return dataCreazionePadre;
    }

    public void setDataCreazionePadre(ZonedDateTime dataCreazionePadre) {
        this.dataCreazionePadre = dataCreazionePadre;
    }

    public ArchivioDetail getIdArchivioRadice() {
        return idArchivioRadice;
    }

    public void setIdArchivioRadice(ArchivioDetailInterface idArchivioRadice) {
        if (idArchivioRadice != null) {
            this.idArchivioRadice = (ArchivioDetail) idArchivioRadice;
        } else {
            this.idArchivioRadice = null;
        }
    }

    public List<ArchivioDetail> getArchiviNipotiList() {
        return archiviNipotiList;
    }

    public void setArchiviNipotiList(List<? extends ArchivioDetailInterface> archiviNipotiList) {
        this.archiviNipotiList = (List<ArchivioDetail>) archiviNipotiList;
    }

    public ZonedDateTime getDataCreazioneRadice() {
        return dataCreazioneRadice;
    }

    public void setDataCreazioneRadice(ZonedDateTime dataCreazioneRadice) {
        this.dataCreazioneRadice = dataCreazioneRadice;
    }

    public Boolean getFoglia() {
        return foglia;
    }

    public void setFoglia(Boolean foglia) {
        this.foglia = foglia;
    }

    public Integer getNumero() {
        return numero;
    }

    public void setNumero(Integer numero) {
        this.numero = numero;
    }

    public Integer getAnno() {
        return anno;
    }

    public void setAnno(Integer anno) {
        this.anno = anno;
    }

    public Integer getLivello() {
        return livello;
    }

    public void setLivello(Integer livello) {
        this.livello = livello;
    }

    public String getNumerazioneGerarchica() {
        return numerazioneGerarchica;
    }

    public void setNumerazioneGerarchica(String numerazioneGerarchica) {
        this.numerazioneGerarchica = numerazioneGerarchica;
    }

    public String getOggetto() {
        return oggetto;
    }

    public void setOggetto(String oggetto) {
        this.oggetto = oggetto;
    }

    public String getOggettoTscol() {
        return oggettoTscol;
    }

    public void setOggettoTscol(String oggettoTscol) {
        this.oggettoTscol = oggettoTscol;
    }

    public Double getRankingOggetto() {
        return rankingOggetto;
    }

    public void setRankingOggetto(Double rankingOggetto) {
        this.rankingOggetto = rankingOggetto;
    }

    public Archivio.StatoArchivio getStato() {
        if (stato != null) {
            return Archivio.StatoArchivio.valueOf(stato);
        } else {
            return null;
        }
    }

    public void setStato(Archivio.StatoArchivio stato) {
        if (stato != null) {
            this.stato = stato.toString();
        } else {
            this.stato = null;
        }
    }

    public Archivio.TipoArchivio getTipo() {
        if (tipo != null) {
            return Archivio.TipoArchivio.valueOf(tipo);
        } else {
            return null;
        }
    }

    public void setTipo(Archivio.TipoArchivio tipo) {
        if (tipo != null) {
            this.tipo = tipo.toString();
        } else {
            this.tipo = null;
        }
    }

    public Persona getIdPersonaResponsabile() {
        return idPersonaResponsabile;
    }

    public void setIdPersonaResponsabile(Persona idPersonaResponsabile) {
        this.idPersonaResponsabile = idPersonaResponsabile;
    }

    public Persona getIdPersonaCreazione() {
        return idPersonaCreazione;
    }

    public void setIdPersonaCreazione(Persona idPersonaCreazione) {
        this.idPersonaCreazione = idPersonaCreazione;
    }

    public Struttura getIdStruttura() {
        return idStruttura;
    }

    public void setIdStruttura(Struttura idStruttura) {
        this.idStruttura = idStruttura;
    }

    public Integer getIdTitolo() {
        return idTitolo;
    }

    public void setIdTitolo(Integer idTitolo) {
        this.idTitolo = idTitolo;
    }

    public List<Vicario> getVicari() {
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.convertValue(vicari, new TypeReference<List<Vicario>>() {
        });
    }

    public void setVicari(List<Vicario> vicari) {
        this.vicari = (List<JsonNode>) (Object) vicari;
    }

    public String getTscol() {
        return tscol;
    }

    public void setTscol(String tscol) {
        this.tscol = tscol;
    }

    public Double getRanking() {
        return ranking;
    }

    public void setRanking(Double ranking) {
        this.ranking = ranking;
    }

    public ZonedDateTime getDataInserimentoRiga() {
        return dataInserimentoRiga;
    }

    public void setDataInserimentoRiga(ZonedDateTime dataInserimentoRiga) {
        this.dataInserimentoRiga = dataInserimentoRiga;
    }

    public ZonedDateTime getVersion() {
        return version;
    }

    public void setVersion(ZonedDateTime version) {
        this.version = version;
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
        if (!(object instanceof ArchivioDetail)) {
            return false;
        }
        ArchivioDetail other = (ArchivioDetail) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "it.bologna.ausl.model.entities.scripta.ArchivioDetail[ id=" + id + " ]";
    }
}
