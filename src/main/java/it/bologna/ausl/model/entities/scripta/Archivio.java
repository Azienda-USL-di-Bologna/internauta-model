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
import javax.persistence.OneToOne;
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
@GenerateProjections({
    "idMassimario, idTitolo, idAzienda"    
})
@DynamicUpdate
public class Archivio {

    public static enum TipoArchivio {
        AFFARE, PROCEDIMENTO, ATTIVITA, SPECIALE
    }

    public static enum StatoArchivio {
        APERTO, PRECHIUSO, CHIUSO, BOZZA
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;

    @OneToOne(cascade = CascadeType.ALL, mappedBy = "idArchivio", fetch = FetchType.LAZY, optional = true)
    @JsonBackReference(value = "idArchivioDetail")
    private ArchivioDetail idArchivioDetail;
    
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

    @JoinColumn(name = "id_archivio_radice", referencedColumnName = "id")
    @ManyToOne(fetch = FetchType.LAZY, cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    @JsonBackReference(value = "idArchivioRadice")
    private Archivio idArchivioRadice;

    @Column(name = "tipo")
    private String tipo;

    @Column(name = "foglia")
    private Boolean foglia;

    @Column(name = "riservato")
    private Boolean riservato = false;

    @Column(name = "numero")
    private Integer numero;

    @Column(name = "anno")
    private Integer anno;

    @Column(name = "numerazione_gerarchica")
    private String numerazioneGerarchica;

    @Column(name = "oggetto")
    private String oggetto;

    @Column(name = "stato")
    private String stato;

    @Column(name = "livello")
    private Integer livello;

 
    @Column(name = "anni_tenuta")
    private Integer anniTenuta;

    @JoinColumn(name = "id_archivio_precedente", referencedColumnName = "id")
    @ManyToOne(fetch = FetchType.LAZY, cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    @JsonBackReference(value = "idArchivioPrecedente")
    private Archivio idArchivioPrecedente;

    @OneToMany(mappedBy = "idArchivioPrecedente", fetch = FetchType.LAZY, cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    @JsonBackReference(value = "archiviSeguentiList")
    private List<Archivio> archiviSeguentiList;

    @JoinColumn(name = "id_titolo", referencedColumnName = "id")
    @ManyToOne(fetch = FetchType.LAZY, cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    @JsonBackReference(value = "idTitolo")
    private Titolo idTitolo;

    @JoinColumn(name = "id_massimario", referencedColumnName = "id")
    @ManyToOne(fetch = FetchType.LAZY, cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    @JsonBackReference(value = "idMassimario")
    private Massimario idMassimario;
    
    @Column(name = "note")
    private String note;

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

    @OneToMany(mappedBy = "idArchivio", fetch = FetchType.LAZY, cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    @JsonBackReference(value = "attoriList")
    private List<AttoreArchivio> attoriList;

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

    public Archivio getIdArchivioRadice() {
        return idArchivioRadice;
    }

    public void setIdArchivioRadice(Archivio idArchivioRadice) {
        this.idArchivioRadice = idArchivioRadice;
    }

    public ArchivioDetail getIdArchivioDetail() {
        return idArchivioDetail;
    }

    public void setIdArchivioDetail(ArchivioDetail idArchivioDetail) {
        this.idArchivioDetail = idArchivioDetail;
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

    public Boolean getRiservato() {
        return riservato;
    }

    public void setRiservato(Boolean riservato) {
        this.riservato = riservato;
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

    public String getNumerazioneGerarchica() {
        return numerazioneGerarchica;
    }

    public void setNumerazioneGerarchica(String numerazioneGerarchica) {
        this.numerazioneGerarchica = numerazioneGerarchica;
    }

    public Integer getLivello() {
        return livello;
    }

    public void setLivello(Integer livello) {
        this.livello = livello;
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

    public Titolo getIdTitolo() {
        return idTitolo;
    }

    public void setIdTitolo(Titolo idTitolo) {
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

    public List<AttoreArchivio> getAttoriList() {
        return attoriList;
    }

    public void setAttoriList(List<AttoreArchivio> attoriList) {
        this.attoriList = attoriList;
    }

    public Massimario getIdMassimario() {
        return idMassimario;
    }

    public void setIdMassimario(Massimario idMassimario) {
        this.idMassimario = idMassimario;
    }
    
    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }
    
       public Integer getAnniTenuta() {
        return anniTenuta;
    }

    public void setAnniTenuta(Integer anniTenuta) {
        this.anniTenuta = anniTenuta;
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
