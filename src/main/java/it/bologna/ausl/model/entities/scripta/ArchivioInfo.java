package it.bologna.ausl.model.entities.scripta;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import it.nextsw.common.data.annotations.GenerateProjections;
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
import javax.persistence.MapsId;
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
@Table(name = "archivi_info", catalog = "internauta", schema = "scripta")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Cacheable(false)
@GenerateProjections({})
@DynamicUpdate
public class ArchivioInfo {
    
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    
    @JoinColumn(name = "id", referencedColumnName = "id", insertable = false, updatable = false)
    @OneToOne(optional = false, fetch = FetchType.LAZY)
    @MapsId
    @JsonBackReference(value = "idArchivio")
    private Archivio idArchivio;
    
    @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss.SSSSSSXXX'['VV']'")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss.SSSSSSXXX'['VV']'")
    @Column(name = "data_ultimo_utilizzo")
    @Basic(optional = false)
    @NotNull
    private ZonedDateTime dataUltimoUtilizzo = ZonedDateTime.now();
    
    @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss.SSSSSSXXX'['VV']'")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss.SSSSSSXXX'['VV']'")
    @Column(name = "data_ultimo_ricalcolo_permessi")
    @Basic(optional = false)
    @NotNull
    private ZonedDateTime dataUltimoRicalcoloPermessi = ZonedDateTime.now();

    @Version()
    @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss.SSSSSSXXX'['VV']'")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss.SSSSSSXXX'['VV']'")
    private ZonedDateTime version;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Archivio getIdArchivio() {
        return idArchivio;
    }

    public void setIdArchivio(Archivio idArchivio) {
        this.idArchivio = idArchivio;
    }

    public ZonedDateTime getDataUltimoUtilizzo() {
        return dataUltimoUtilizzo;
    }

    public void setDataUltimoUtilizzo(ZonedDateTime dataUltimoUtilizzo) {
        this.dataUltimoUtilizzo = dataUltimoUtilizzo;
    }

    public ZonedDateTime getDataUltimoRicalcoloPermessi() {
        return dataUltimoRicalcoloPermessi;
    }

    public void setDataUltimoRicalcoloPermessi(ZonedDateTime dataUltimoRicalcoloPermessi) {
        this.dataUltimoRicalcoloPermessi = dataUltimoRicalcoloPermessi;
    }

    public ZonedDateTime getVersion() {
        return version;
    }

    public void setVersion(ZonedDateTime version) {
        this.version = version;
    }
    
    
}
