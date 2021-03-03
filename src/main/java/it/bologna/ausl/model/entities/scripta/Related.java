package it.bologna.ausl.model.entities.scripta;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import it.bologna.ausl.model.entities.baborg.Azienda;
import it.bologna.ausl.model.entities.baborg.Persona;
import it.bologna.ausl.model.entities.rubrica.Contatto;
import it.bologna.ausl.model.entities.rubrica.GruppiContatti;
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
import org.springframework.format.annotation.DateTimeFormat;

/**
 *
 * @author solidus83
 */

@Entity
@Table(name = "related", catalog = "internauta", schema = "scripta")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Cacheable(false)
@GenerateProjections({"idContatto","idGruppo","relatedList","spedizioneList","idContatto,idGruppo"})
public class Related implements Serializable {

    private static final long serialVersionUID = 1L;

    public static enum TipoRelated {
        A,
        CC,
        MITTENTE
    }
    
    public static enum OrigineRelated {
        ESTERNO,
        INTERNO,
        VARIO
    }
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    
    @JoinColumn(name = "id_doc", referencedColumnName = "id")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Doc idDoc;
    
    @JoinColumn(name = "id_contatto", referencedColumnName = "id")
    @ManyToOne(optional = true, fetch = FetchType.LAZY)
    private Contatto idContatto;
    
    @JoinColumn(name = "id_persona_inserente", referencedColumnName = "id")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Persona idPersonaInserente;
    
    @JoinColumn(name = "id_gruppo", referencedColumnName = "id")
    @ManyToOne(optional = true, fetch = FetchType.LAZY)
    private Related idGruppo;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idGruppo", fetch = FetchType.LAZY)
    @JsonBackReference(value = "relatedList")
    private List<Related> relatedList;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idRelated", fetch = FetchType.LAZY)
    @JsonBackReference(value = "spedizioneList")
    private List<Spedizione> spedizioneList;
    
    @Basic(optional = false)
    @NotNull
    @Column(name = "tipo")
    private String tipo;
    
    @Basic(optional = false)
    @NotNull
    @Column(name = "origine")
    private String origine;
    
    @Basic(optional = false)
    @NotNull
    @Column(name = "descrizione")
    private String descrizione;
    
    @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss.SSSSSSXXX'['VV']'")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss.SSSSSSXXX'['VV']'")
    @Column(name = "data_inserimento")
    @Basic(optional = false)
    @NotNull
    private ZonedDateTime dataInserimento = ZonedDateTime.now();
    
    @Version()
    @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss.SSSSSSXXX'['VV']'")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss.SSSSSSXXX'['VV']'")
    private ZonedDateTime version;

    public Related() {
    }

    public Related(Integer id, Doc idDoc, Contatto idContatto, Persona idPersonaInserente, Related idGruppo, List<Related> relatedList, List<Spedizione> spedizioneList, String tipo, String origine, String descrizione, ZonedDateTime dataInserimento, ZonedDateTime version) {
        this.id = id;
        this.idDoc = idDoc;
        this.idContatto = idContatto;
        this.idPersonaInserente = idPersonaInserente;
        this.idGruppo = idGruppo;
        this.relatedList = relatedList;
        this.spedizioneList = spedizioneList;
        this.tipo = tipo;
        this.origine = origine;
        this.descrizione = descrizione;
        this.dataInserimento = dataInserimento;
        this.version = version;
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

    public Contatto getIdContatto() {
        return idContatto;
    }

    public void setIdContatto(Contatto idContatto) {
        this.idContatto = idContatto;
    }

    public Persona getIdPersonaInserente() {
        return idPersonaInserente;
    }

    public void setIdPersonaInserente(Persona idPersonaInserente) {
        this.idPersonaInserente = idPersonaInserente;
    }

    public Related getIdGruppo() {
        return idGruppo;
    }

    public void setIdGruppo(Related idGruppo) {
        this.idGruppo = idGruppo;
    }

    public List<Related> getRelatedList() {
        return relatedList;
    }

    public void setRelatedList(List<Related> relatedList) {
        this.relatedList = relatedList;
    }

    public List<Spedizione> getSpedizioneList() {
        return spedizioneList;
    }

    public void setSpedizioneList(List<Spedizione> spedizioneList) {
        this.spedizioneList = spedizioneList;
    }

    public TipoRelated getTipo() {
        if (tipo != null) {
            return TipoRelated.valueOf(tipo);
        } else {
            return null;
        }
    }

    public void setTipo(TipoRelated tipo) {
        if (tipo != null) {
            this.tipo = tipo.toString();
        } else {
            this.tipo = null;
        }
    }

    public OrigineRelated getOrigine() {
        if (origine != null) {
            return OrigineRelated.valueOf(origine);
        } else {
            return null;
        }
    }

    public void setOrigine(OrigineRelated origine) {
        if (origine != null) {
            this.origine = origine.toString();
        } else {
            this.origine = null;
        }
    }

    public String getDescrizione() {
        return descrizione;
    }

    public void setDescrizione(String descrizione) {
        this.descrizione = descrizione;
    }

    public ZonedDateTime getDataInserimento() {
        return dataInserimento;
    }

    public void setDataInserimento(ZonedDateTime dataInserimento) {
        this.dataInserimento = dataInserimento;
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
        if (!(object instanceof Related)) {
            return false;
        }
        Related other = (Related) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return getClass().getCanonicalName() + "[ id=" + id + " ]";
    }

}
