package it.bologna.ausl.model.entities.versatore;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.vladmihalcea.hibernate.type.json.JsonBinaryType;
import com.vladmihalcea.hibernate.type.range.Range;
import it.bologna.ausl.model.entities.baborg.Azienda;
import java.io.Serializable;
import java.time.ZonedDateTime;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Cacheable;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
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
@Table(name = "sessioni_versamenti", schema = "versatore")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Cacheable(false)
@DynamicUpdate
public class SessioneVersamento implements Serializable {
    
    public static enum TipologiaVersamento {
        FORZATURA,
        GIORNALIERO,
        RITENTA,
        IMPORTATA
    }
    
    public static enum StatoSessioneVersamento {
        IDLE,
        RUNNING,
        DONE,
        PARTIALLY;
    }

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    
    @Basic(optional = false)
    @NotNull
    @Enumerated(EnumType.STRING)
    private TipologiaVersamento tipologia;
    
    @Basic(optional = false)
    @NotNull
    @Column(name = "stato")
    @Enumerated(EnumType.STRING)
    private StatoSessioneVersamento stato;
    
    @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss.SSSSSSXXX'['VV']'")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss.SSSSSSXXX'['VV']'")
    @Column(name = "time_interval", columnDefinition = "tstzrange")
    private Range<ZonedDateTime> timeInterval;
    
    @JoinColumn(name = "id_azienda", referencedColumnName = "id")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Azienda idAzienda;
    
    @Version()
    @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss.SSSSSSXXX'['VV']'")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss.SSSSSSXXX'['VV']'")
    private ZonedDateTime version;
    
    @OneToMany(cascade = {CascadeType.MERGE, CascadeType.PERSIST}, mappedBy = "idSessioneVersamento", fetch = FetchType.LAZY)
    @JsonBackReference(value = "versamentiList")
    private List<Versamento> versamentiList;

    public SessioneVersamento() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public TipologiaVersamento getTipologia() {
        return tipologia;
    }

    public void setTipologia(TipologiaVersamento tipologia) {
        this.tipologia = tipologia;
    }

    public StatoSessioneVersamento getStato() {
        return stato;
    }

    public void setStato(StatoSessioneVersamento stato) {
        this.stato = stato;
    }

    public Range<ZonedDateTime> getTimeInterval() {
        return timeInterval;
    }

    public void setTimeInterval(Range<ZonedDateTime> timeInterval) {
        this.timeInterval = timeInterval;
    }

    public ZonedDateTime getVersion() {
        return version;
    }

    public void setVersion(ZonedDateTime version) {
        this.version = version;
    }

    public Azienda getIdAzienda() {
        return idAzienda;
    }

    public void setIdAzienda(Azienda idAzienda) {
        this.idAzienda = idAzienda;
    }

    public List<Versamento> getVersamentiList() {
        return versamentiList;
    }

    public void setVersamentiList(List<Versamento> versamentiList) {
        this.versamentiList = versamentiList;
    }
    
    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SessioneVersamento)) {
            return false;
        }
        SessioneVersamento other = (SessioneVersamento) object;
        return !((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id)));
    }

    @Override
    public String toString() {
        return getClass().getCanonicalName()+ "[ id=" + id + " ]";
    }

}
