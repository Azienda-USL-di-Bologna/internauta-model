package it.bologna.ausl.model.entities.scripta;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import it.bologna.ausl.model.entities.baborg.Persona;
import it.nextsw.common.data.annotations.GenerateProjections;
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
import javax.validation.constraints.Size;
import org.hibernate.annotations.DynamicUpdate;
import org.springframework.format.annotation.DateTimeFormat;

/**
 *
 * @author gdm
 */
@Entity
@Table(name = "note_doc", catalog = "internauta", schema = "scripta")
@JsonIgnoreProperties(value = {"hibernateLazyInitializer", "handler"}, ignoreUnknown = true)
@GenerateProjections({"idPersonaInserente"})
@DynamicUpdate

public class NotaDoc implements Serializable {
    
    private static final long serialVersionUID = 1L;
    
    public static enum TipoNotaDoc {
        ANNULLAMENTO,
        VERSAMENTO,
        DOCUMENTO,
        FLUSSO
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
    private TipoNotaDoc tipo;
    
    @Basic(optional = false)
    @Size(min = 1, max = 2147483647)
    @Column(name = "testo")
    private String testo;
    
    @JoinColumn(name = "id_doc", referencedColumnName = "id")
    @ManyToOne(fetch = FetchType.LAZY, cascade = {CascadeType.MERGE, CascadeType.PERSIST}, optional = false)
    private Doc idDoc;
    
    @JoinColumn(name = "id_persona_inserente", referencedColumnName = "id")
    @ManyToOne(fetch = FetchType.LAZY, cascade = {CascadeType.MERGE, CascadeType.PERSIST}, optional = false)
    private Persona idPersonaInserente;
    
    @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss.SSSSSSXXX'['VV']'")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss.SSSSSSXXX'['VV']'")
    @Column(name = "data_inserimento_riga")
    @Basic(optional = false)
    private ZonedDateTime dataInserimentoRiga = ZonedDateTime.now();
    
    @Version()
    @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss.SSSSSSXXX'['VV']'")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss.SSSSSSXXX'['VV']'")
    private ZonedDateTime version;

    public NotaDoc() {
    }

    public NotaDoc(Doc idDoc, Persona idPersonaInserente, TipoNotaDoc tipo, String testo, ZonedDateTime dataInserimentoRiga) {
        this.idDoc = idDoc;
        this.idPersonaInserente = idPersonaInserente;
        this.tipo = tipo;
        this.testo = testo;
        this.dataInserimentoRiga = dataInserimentoRiga;
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

    public TipoNotaDoc getTipo() {
        return tipo;
    }

    public void setTipo(TipoNotaDoc tipo) {
        this.tipo = tipo;
    }

    public String getTesto() {
        return testo;
    }

    public void setTesto(String testo) {
        this.testo = testo;
    }

    public Persona getIdPersonaInserente() {
        return idPersonaInserente;
    }

    public void setIdPersonaInserente(Persona idPersonaInserente) {
        this.idPersonaInserente = idPersonaInserente;
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
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof NotaDoc)) {
            return false;
        }
        NotaDoc other = (NotaDoc) object;
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
