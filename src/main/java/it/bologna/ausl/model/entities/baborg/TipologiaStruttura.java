package it.bologna.ausl.model.entities.baborg;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.vladmihalcea.hibernate.type.array.StringArrayType;
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
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Version;
import javax.validation.constraints.NotNull;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.Parameter;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;
import org.springframework.format.annotation.DateTimeFormat;

/**
 *
 * @author solidus83
 */
@TypeDef(name = "string-array", typeClass = StringArrayType.class)

@Entity
@Table(name = "tipologie_struttura", catalog = "internauta", schema = "baborg")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Cacheable(false)
@GenerateProjections({})
@DynamicUpdate
public class TipologiaStruttura implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
        
    @Basic(optional = false)
    @NotNull
    @Column(name = "tipologia")
    private String tipologia;
    
    @Basic(optional = false)
    @NotNull
    @Column(name = "associa_strutture")
    private Boolean associaStrutture = false;
    
    @Basic(optional = true)
    @Column(name = "ruoli", columnDefinition = "text[]")
    @Type(type = "string-array")
    private String[] ruoli;
    
    @Basic(optional = true)
    @Column(name = "predicati", columnDefinition = "text[]")
    @Type(type = "string-array")
    private String[] predicati;

    @Version()
    @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss.SSSSSSXXX'['VV']'")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss.SSSSSSXXX'['VV']'")
    private ZonedDateTime version;

    public TipologiaStruttura() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTipologia() {
        return tipologia;
    }

    public void setTipologia(String tipologia) {
        this.tipologia = tipologia;
    }

    public Boolean getAssociaStrutture() {
        return associaStrutture;
    }

    public void setAssociaStrutture(Boolean associaStrutture) {
        this.associaStrutture = associaStrutture;
    }

    public String[] getRuoli() {
        return ruoli;
    }

    public void setRuoli(String[] ruoli) {
        this.ruoli = ruoli;
    }

    public String[] getPredicati() {
        return predicati;
    }

    public void setPredicati(String[] predicati) {
        this.predicati = predicati;
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
        if (!(object instanceof TipologiaStruttura)) {
            return false;
        }
        TipologiaStruttura other = (TipologiaStruttura) object;
        return !((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id)));
    }

    @Override
    public String toString() {
        return getClass().getCanonicalName() + "[ id=" + id + " ]";
    }


}
