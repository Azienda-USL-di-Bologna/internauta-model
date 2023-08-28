package it.bologna.ausl.model.entities.scripta;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import it.bologna.ausl.model.entities.baborg.Persona;
import it.nextsw.common.annotations.GenerateProjections;
import java.io.Serializable;
import java.time.ZonedDateTime;
import java.util.Objects;
import javax.persistence.Basic;
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
import javax.persistence.Table;
import javax.persistence.Version;
import javax.validation.constraints.NotNull;
import org.hibernate.annotations.DynamicUpdate;
import org.springframework.format.annotation.DateTimeFormat;

/**
 *
 * @author gdm
 */
@Entity
@Table(name = "docs_annullati", catalog = "internauta", schema = "scripta")
@JsonIgnoreProperties(value = {"hibernateLazyInitializer", "handler"}, ignoreUnknown = true)
@GenerateProjections()
@DynamicUpdate
public class DocAnnullato implements Serializable {
    
    private static final long serialVersionUID = 1L;
    
    public static enum TipoAnnullamento {
        PRE_ANNULLATO,
        ANNULLATO
    } 
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
        
    @Column(name = "tipo")
    @Enumerated(EnumType.STRING)
    @Basic(optional = false)
    @NotNull
    private TipoAnnullamento tipo;
    
    @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss.SSSSSSXXX'['VV']'")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss.SSSSSSXXX'['VV']'")
    @Column(name = "data")
    @Basic(optional = false)
    private ZonedDateTime data = ZonedDateTime.now();
    
    @JoinColumn(name = "id_doc", referencedColumnName = "id")
    @ManyToOne(fetch = FetchType.LAZY, cascade = {CascadeType.MERGE, CascadeType.PERSIST}, optional = false)
    private Doc idDoc;
    
    @JoinColumn(name = "id_persona_annullante", referencedColumnName = "id")
    @ManyToOne(fetch = FetchType.LAZY, cascade = {CascadeType.MERGE, CascadeType.PERSIST}, optional = false)
    private Persona idPersonaAnnullante;
    
    @JoinColumn(name = "idNota", referencedColumnName = "id")
    @ManyToOne(fetch = FetchType.LAZY, cascade = {CascadeType.MERGE, CascadeType.PERSIST}, optional = false)
    private NotaDoc idNota;
    
    @Version()
    @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss.SSSSSSXXX'['VV']'")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss.SSSSSSXXX'['VV']'")
    private ZonedDateTime version;

    public DocAnnullato() {
    }

    public DocAnnullato(Doc idDoc, Persona idPersonaAnnullante, TipoAnnullamento tipo, ZonedDateTime data) {
        this.idDoc = idDoc;
        this.idPersonaAnnullante = idPersonaAnnullante;
        this.tipo = tipo;
        this.data = data;
    }
    
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public TipoAnnullamento getTipo() {
        return tipo;
    }

    public void setTipo(TipoAnnullamento tipo) {
        this.tipo = tipo;
    }

    public ZonedDateTime getData() {
        return data;
    }

    public void setData(ZonedDateTime data) {
        this.data = data;
    }

    public Doc getIdDoc() {
        return idDoc;
    }

    public void setIdDoc(Doc idDoc) {
        this.idDoc = idDoc;
    }

    public Persona getIdPersonaAnnullante() {
        return idPersonaAnnullante;
    }

    public void setIdPersonaAnnullante(Persona idPersonaAnnullante) {
        this.idPersonaAnnullante = idPersonaAnnullante;
    }

    public NotaDoc getIdNota() {
        return idNota;
    }

    public void setIdNota(NotaDoc idNota) {
        this.idNota = idNota;
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
        if (!(object instanceof DocAnnullato)) {
            return false;
        }
        DocAnnullato other = (DocAnnullato) object;
        return !((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id)));
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 59 * hash + Objects.hashCode(this.id);
        return hash;
    }
    
    @Override
    public String toString() {
        return String.format("%s[id=%s]", getClass().getCanonicalName(), getId());
    }
}
