package it.bologna.ausl.model.entities.scripta;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import it.bologna.ausl.model.entities.baborg.Azienda;
import it.nextsw.common.annotations.GenerateProjections;
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
import org.springframework.format.annotation.DateTimeFormat;

/**
 *
 * @author gusgus
 */
@Entity
@Table(name = "archivi", catalog = "internauta", schema = "scripta")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Cacheable(false)
@GenerateProjections({})
@DynamicUpdate
public class Archivio {
    
    public static enum TipoArchivio {
        FASCICOLO, SOTTOFASCICOLO, INSERTO
    }
    public static enum StatoArchivio {
        APERTO, PRECHIUSO, CHIUSO
    }
    
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
    private ZonedDateTime dataCreazione = ZonedDateTime.now();
    
    @JoinColumn(name = "id_archivio_padre", referencedColumnName = "id")
    @ManyToOne(fetch = FetchType.LAZY, cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    @JsonBackReference(value = "idArchivioPadre")
    private Archivio idArchivioPadre;
    
    @OneToMany(mappedBy = "idArchivioPadre", fetch = FetchType.LAZY, cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    @JsonBackReference(value = "archiviFigliList")
    private List<Archivio> archiviFigliList;
    
    @JoinColumn(name = "id_archivio_nonno", referencedColumnName = "id")
    @ManyToOne(fetch = FetchType.LAZY, cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    @JsonBackReference(value = "idArchivioNonno")
    private Archivio idArchivioNonno;
    
    @OneToMany(mappedBy = "idArchivioNonno", fetch = FetchType.LAZY, cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    @JsonBackReference(value = "archiviNipotiList")
    private List<Archivio> archiviNipotiList;
    
    @Column(name = "tipo")
    private String tipo;
    
    @Column(name = "foglia")
    private Boolean foglia;
    
    @Column(name = "numero")
    private Integer numero;
    
    @Column(name = "anno")
    private Integer anno;
    
    @Column(name = "oggetto")
    private String oggetto;
    
    @Column(name = "stato")
    private String stato;
    
    @JoinColumn(name = "id_archivio_precedente", referencedColumnName = "id")
    @ManyToOne(fetch = FetchType.LAZY, cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    @JsonBackReference(value = "idArchivioPrecedente")
    private Archivio idArchivioPrecedente;
    
    @OneToMany(mappedBy = "idArchivioPrecedente", fetch = FetchType.LAZY, cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    @JsonBackReference(value = "archiviSeguentiList")
    private List<Archivio> archiviSeguentiList;
    
    @Basic(optional = true)
    @Column(name = "id_titolo")
    private Integer idTitolo;
    
    @Basic(optional = true)
    @Column(name = "id_archivio_argo")
    private String idArchivioArgo;
    
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

    public Archivio() {
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

    public Archivio getIdArchivioPadre() {
        return idArchivioPadre;
    }

    public void setIdArchivioPadre(Archivio idArchivioPadre) {
        this.idArchivioPadre = idArchivioPadre;
    }

    public List<Archivio> getArchiviFigliList() {
        return archiviFigliList;
    }

    public void setArchiviFigliList(List<Archivio> archiviFigliList) {
        this.archiviFigliList = archiviFigliList;
    }

    public Archivio getIdArchivioNonno() {
        return idArchivioNonno;
    }

    public void setIdArchivioNonno(Archivio idArchivioNonno) {
        this.idArchivioNonno = idArchivioNonno;
    }

    public List<Archivio> getArchiviNipotiList() {
        return archiviNipotiList;
    }

    public void setArchiviNipotiList(List<Archivio> archiviNipotiList) {
        this.archiviNipotiList = archiviNipotiList;
    }

    public TipoArchivio getTipo() {
        if (tipo != null) {
            return TipoArchivio.valueOf(tipo);
        } else {
            return null;
        }
    }

    public void setTipo(TipoArchivio tipo) {
        if (tipo != null) {
            this.tipo = tipo.toString();
        } else {
            this.tipo = null;
        }
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

    public String getOggetto() {
        return oggetto;
    }

    public void setOggetto(String oggetto) {
        this.oggetto = oggetto;
    }

    public StatoArchivio getStato() {
        if (stato != null) {
            return StatoArchivio.valueOf(stato);
        } else {
            return null;
        }
    }

    public void setStato(StatoArchivio stato) {
        if (stato != null) {
            this.stato = stato.toString();
        } else {
            this.stato = null;
        }
    }

    public Archivio getIdArchivioPrecedente() {
        return idArchivioPrecedente;
    }

    public void setIdArchivioPrecedente(Archivio idArchivioPrecedente) {
        this.idArchivioPrecedente = idArchivioPrecedente;
    }

    public List<Archivio> getArchiviSeguentiList() {
        return archiviSeguentiList;
    }

    public void setArchiviSeguentiList(List<Archivio> archiviSeguentiList) {
        this.archiviSeguentiList = archiviSeguentiList;
    }

    public Integer getIdTitolo() {
        return idTitolo;
    }

    public void setIdTitolo(Integer idTitolo) {
        this.idTitolo = idTitolo;
    }

    public String getIdArchivioArgo() {
        return idArchivioArgo;
    }

    public void setIdArchivioArgo(String idArchivioArgo) {
        this.idArchivioArgo = idArchivioArgo;
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
        if (!(object instanceof Archivio)) {
            return false;
        }
        Archivio other = (Archivio) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "it.bologna.ausl.model.entities.scripta.Archivio[ id=" + id + " ]";
    }
}
