package it.bologna.ausl.model.entities.scripta;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import it.bologna.ausl.model.entities.baborg.Azienda;
import it.bologna.ausl.model.entities.baborg.Persona;
import it.bologna.ausl.model.entities.baborg.Struttura;
import it.nextsw.common.annotations.GenerateProjections;
import java.io.Serializable;
import java.time.ZonedDateTime;
import javax.persistence.Basic;
import javax.persistence.Cacheable;
import javax.persistence.Column;
import javax.persistence.Entity;
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
@Table(name = "tip_sessioni_importazioni", catalog = "internauta", schema = "scripta")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Cacheable(false)
@GenerateProjections()
@DynamicUpdate
public class TipSessioneImportazione implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Long id;

    @Basic(optional = false)
    @Column(name = "tipologia")
    @NotNull
    @Enumerated
    private DocDetailInterface.TipologiaDoc tipologia;

    @Basic(optional = false)
    @Column(name = "separatore")
    @NotNull
    private String separatore = ";";
    
    @Basic(optional = true)
    @Column(name = "id_repo_csv")
    private String idRepoCsv;

    @JoinColumn(name = "id_azienda", referencedColumnName = "id")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Azienda idAzienda;
    
    @JoinColumn(name = "id_struttura_default", referencedColumnName = "id")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Struttura idStrutturaDefault;
    
    @JoinColumn(name = "id_archivio_default", referencedColumnName = "id")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Archivio idArchivioDefault;
    
    @JoinColumn(name = "id_persona_vicario_default", referencedColumnName = "id")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Persona idPersonaVicarioDefault;
    
    @Version()
    @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss.SSSSSSXXX'['VV']'")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss.SSSSSSXXX'['VV']'")
    private ZonedDateTime version;

    public TipSessioneImportazione() {
    }

    public TipSessioneImportazione(Long id, DocDetailInterface.TipologiaDoc tipologia, String idRepoCsv, ZonedDateTime version) {
        this.id = id;
        this.tipologia = tipologia;
        this.idRepoCsv = idRepoCsv;
        this.version = version;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public DocDetailInterface.TipologiaDoc getTipologia() {
        return tipologia;
    }

    public void setTipologia(DocDetailInterface.TipologiaDoc tipologia) {
        this.tipologia = tipologia;
    }

    public String getSeparatore() {
        return separatore;
    }

    public void setSeparatore(String separatore) {
        this.separatore = separatore;
    }

    public String getIdRepoCsv() {
        return idRepoCsv;
    }

    public void setIdRepoCsv(String idRepoCsv) {
        this.idRepoCsv = idRepoCsv;
    }

    public Azienda getIdAzienda() {
        return idAzienda;
    }

    public void setIdAzienda(Azienda idAzienda) {
        this.idAzienda = idAzienda;
    }

    public Struttura getIdStrutturaDefault() {
        return idStrutturaDefault;
    }

    public void setIdStrutturaDefault(Struttura idStrutturaDefault) {
        this.idStrutturaDefault = idStrutturaDefault;
    }

    public Archivio getIdArchivioDefault() {
        return idArchivioDefault;
    }

    public void setIdArchivioDefault(Archivio idArchivioDefault) {
        this.idArchivioDefault = idArchivioDefault;
    }

    public Persona getIdPersonaVicarioDefault() {
        return idPersonaVicarioDefault;
    }

    public void setIdPersonaVicarioDefault(Persona idPersonaVicarioDefault) {
        this.idPersonaVicarioDefault = idPersonaVicarioDefault;
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
        if (!(object instanceof TipSessioneImportazione)) {
            return false;
        }
        TipSessioneImportazione other = (TipSessioneImportazione) object;
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
