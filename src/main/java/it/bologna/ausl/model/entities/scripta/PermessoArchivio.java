package it.bologna.ausl.model.entities.scripta;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import it.bologna.ausl.model.entities.baborg.Azienda;
import it.nextsw.common.annotations.GenerateProjections;
import java.io.Serializable;
import java.time.ZonedDateTime;
import javax.persistence.Basic;
import javax.persistence.Cacheable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "permessi_archivi", catalog = "internauta", schema = "scripta")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Cacheable(false)
@GenerateProjections({})
@DynamicUpdate
public class PermessoArchivio implements Serializable {
    
    public static enum TipoSoggetto {
        PERSONA, STRUTTURA
    }

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Long id;
    
    @JoinColumn(name = "id_soggetto")
    private Integer idSoggetto;
    
    @JoinColumn(name = "tipo_soggetto")
    private String tipoSoggetto;
    
    @JoinColumn(name = "id_archivio_detail", referencedColumnName = "id")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private ArchivioDetail idArchivioDetail;
    
    @JoinColumn(name = "id_azienda", referencedColumnName = "id")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Azienda idAzienda;
    
    @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss.SSSSSSXXX'['VV']'")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss.SSSSSSXXX'['VV']'")
    @Column(name = "data_creazione")
    @Basic(optional = false)
    @NotNull
    private ZonedDateTime dataCreazione;

    @JoinColumn(name = "bit_permesso")
    private Integer bitPermesso;
    
    @Version()
    @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss.SSSSSSXXX'['VV']'")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss.SSSSSSXXX'['VV']'")
    private ZonedDateTime version;
    
    public PermessoArchivio() {
    }

    public PermessoArchivio(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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

    public Integer getIdSoggetto() {
        return idSoggetto;
    }

    public void setIdSoggetto(Integer idSoggetto) {
        this.idSoggetto = idSoggetto;
    }

    public TipoSoggetto getTipoSoggetto() {
        if (tipoSoggetto != null) {
            return TipoSoggetto.valueOf(tipoSoggetto);
        } else {
            return null;
        }
    }

    public void setTipoSoggetto(TipoSoggetto tipoSoggetto) {
        if (tipoSoggetto != null) {
            this.tipoSoggetto = tipoSoggetto.toString();
        } else {
            this.tipoSoggetto = null;
        }
    }

    public ArchivioDetail getIdArchivioDetail() {
        return idArchivioDetail;
    }

    public void setIdArchivioDetail(ArchivioDetail idArchivioDetail) {
        this.idArchivioDetail = idArchivioDetail;
    }

    public Integer getBitPermesso() {
        return bitPermesso;
    }

    public void setBitPermesso(Integer bitPermesso) {
        this.bitPermesso = bitPermesso;
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
        if (!(object instanceof PermessoArchivio)) {
            return false;
        }
        PermessoArchivio other = (PermessoArchivio) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "it.bologna.ausl.model.entities.scripta.PersoneVedenti[ id=" + id + " ]";
    }
    
}