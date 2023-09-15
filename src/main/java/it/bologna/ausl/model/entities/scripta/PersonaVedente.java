package it.bologna.ausl.model.entities.scripta;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import it.bologna.ausl.model.entities.baborg.Azienda;
import it.bologna.ausl.model.entities.baborg.Persona;
import it.nextsw.common.data.annotations.GenerateProjections;
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
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import org.hibernate.annotations.DynamicUpdate;
import org.springframework.format.annotation.DateTimeFormat;

/**
 *
 * @author gusgus
 */
@Entity
@Table(name = "persone_vedenti", catalog = "internauta", schema = "scripta")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Cacheable(false)
@GenerateProjections({})
@DynamicUpdate
public class PersonaVedente implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Long id;
    
    @JoinColumn(name = "id_persona", referencedColumnName = "id")
    @ManyToOne(fetch = FetchType.LAZY, cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    @JsonBackReference(value = "idPersona")
    private Persona idPersona;
    
    @Basic(optional = false)
    @NotNull
    @Column(name = "mio_documento")
    private Boolean mioDocumento;
    
    @Basic(optional = false)
    @NotNull
    @Column(name = "piena_visibilita")
    private Boolean pienaVisibilita;
    
    @Size(max = 2147483647)
    @Column(name = "modalita_apertura")
    private String modalitaApertura;
    
    @JoinColumn(name = "id_doc_detail", referencedColumnName = "id")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private DocDetail idDocDetail;
    
    @JoinColumn(name = "id_azienda", referencedColumnName = "id")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Azienda idAzienda;
    
    @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss.SSSSSSXXX'['VV']'")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss.SSSSSSXXX'['VV']'")
    @Column(name = "data_creazione")
    @Basic(optional = false)
    @NotNull
    private ZonedDateTime dataCreazione;

    public PersonaVedente() {
    }

    public PersonaVedente(Long id) {
        this.id = id;
    }

    public PersonaVedente(Long id, Persona idPersona, Boolean mioDocumento, Boolean pienaVisibilita) {
        this.id = id;
        this.idPersona = idPersona;
        this.mioDocumento = mioDocumento;
        this.pienaVisibilita = pienaVisibilita;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Persona getIdPersona() {
        return idPersona;
    }

    public void setIdPersona(Persona idPersona) {
        this.idPersona = idPersona;
    }

    public Boolean getMioDocumento() {
        return mioDocumento;
    }

    public void setMioDocumento(Boolean mioDocumento) {
        this.mioDocumento = mioDocumento;
    }

    public Boolean getPienaVisibilita() {
        return pienaVisibilita;
    }

    public void setPienaVisibilita(Boolean pienaVisibilita) {
        this.pienaVisibilita = pienaVisibilita;
    }

    public String getModalitaApertura() {
        return modalitaApertura;
    }

    public void setModalitaApertura(String modalitaApertura) {
        this.modalitaApertura = modalitaApertura;
    }

    public DocDetail getIdDocDetail() {
        return idDocDetail;
    }

    public void setIdDocDetail(DocDetail idDocDetail) {
        this.idDocDetail = idDocDetail;
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

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PersonaVedente)) {
            return false;
        }
        PersonaVedente other = (PersonaVedente) object;
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
