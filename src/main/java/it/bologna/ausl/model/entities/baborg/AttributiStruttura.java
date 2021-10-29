package it.bologna.ausl.model.entities.baborg;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import it.nextsw.common.annotations.GenerateProjections;
import java.io.Serializable;
import java.time.ZonedDateTime;
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
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Version;
import org.hibernate.annotations.DynamicUpdate;
import org.springframework.format.annotation.DateTimeFormat;

/**
 *
 * @author solidus83
 */
@Entity
@Table(name = "attributi_strutture", catalog = "internauta", schema = "baborg")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Cacheable(false)
@GenerateProjections({"idStruttura, idTipologiaStruttura", "idTipologiaStruttura"})
@DynamicUpdate
public class AttributiStruttura implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    
    @JoinColumn(name = "id_struttura", referencedColumnName = "id")
    @OneToOne(optional = false, fetch = FetchType.LAZY, cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    private Struttura idStruttura;
    
    @JoinColumn(name = "id_tipologia_struttura", referencedColumnName = "id")
    @ManyToOne(optional = false, fetch = FetchType.EAGER, cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    private TipologiaStruttura idTipologiaStruttura;

    @Version()
    @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss.SSSSSSXXX'['VV']'")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss.SSSSSSXXX'['VV']'")
    private ZonedDateTime version;

    public AttributiStruttura() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Struttura getIdStruttura() {
        return idStruttura;
    }

    public void setIdStruttura(Struttura idStruttura) {
        this.idStruttura = idStruttura;
    }

    public TipologiaStruttura getIdTipologiaStruttura() {
        return idTipologiaStruttura;
    }

    public void setIdTipologiaStruttura(TipologiaStruttura idTipologiaStruttura) {
        this.idTipologiaStruttura = idTipologiaStruttura;
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
        hash += (id != null ? id.hashCode() : super.hashCode());
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof AttributiStruttura)) {
            return false;
        }
        AttributiStruttura other = (AttributiStruttura) object;
        return !((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id)));
    }

   @Override
    public String toString() {
        return getClass().getCanonicalName() + "[ id=" + id + " ]";
    }

}
