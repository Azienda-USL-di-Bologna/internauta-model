package it.bologna.ausl.model.entities.scripta;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import it.bologna.ausl.model.entities.baborg.Persona;
import it.bologna.ausl.model.entities.baborg.Struttura;
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
import javax.persistence.Table;
import javax.persistence.Version;
import javax.validation.constraints.NotNull;
import org.springframework.format.annotation.DateTimeFormat;

/**
 *
 * @author gusgus
 */
@Entity
@Table(name = "registri_docs", catalog = "internauta", schema = "scripta")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Cacheable(false)
@GenerateProjections({"idRegistro"})
public class RegistroDoc implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    
    @Basic(optional = false)
    @NotNull
    @Column(name = "numero")
    private Integer numero;
    
    @Basic(optional = false)
    @NotNull
    @Column(name = "anno")
    private Integer anno;
    
    @Column(name = "numero_visualizzazione")
    private String numeroVisualizzazione;
    
    @JoinColumn(name = "id_registro", referencedColumnName = "id")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @JsonBackReference(value = "idRegistro")
    private Registro idRegistro;
    
    @JoinColumn(name = "id_doc", referencedColumnName = "id")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @JsonBackReference(value = "idDoc")
    private Doc idDoc;
    
    @JoinColumn(name = "id_persona_registrante", referencedColumnName = "id")
    @ManyToOne(fetch = FetchType.EAGER, cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    @JsonBackReference(value = "idPersonaRegistrante")
    private Persona idPersonaRegistrante;
    
    @JoinColumn(name = "id_struttura_registrante", referencedColumnName = "id")
    @ManyToOne(fetch = FetchType.LAZY, cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    @JsonBackReference(value = "idStrutturaRegistrante")
    private Struttura idStrutturaRegistrante;
    
    @Basic(optional = false)
    @NotNull
    @Column(name = "data_registrazione")
    @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss.SSSSSSXXX'['VV']'")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss.SSSSSSXXX'['VV']'")
    private ZonedDateTime dataRegistrazione;
    
    @Version()
    @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss.SSSSSSXXX'['VV']'")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss.SSSSSSXXX'['VV']'")
    private ZonedDateTime version;

    public RegistroDoc() {
    }

    public RegistroDoc(Integer id) {
        this.id = id;
    }

    public RegistroDoc(Integer id, Integer numero, Integer anno, ZonedDateTime dataRegistrazione, ZonedDateTime version) {
        this.id = id;
        this.numero = numero;
        this.anno = anno;
        this.dataRegistrazione = dataRegistrazione;
        this.version = version;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getNumero() {
        return numero;
    }

    public void setNumero(Integer numero) {
        this.numero = numero;
    }

    public Integer getAnno() {
        return anno;
    }

    public void setAnno(Integer anno) {
        this.anno = anno;
    }

    public String getNumeroVisualizzazione() {
        return numeroVisualizzazione;
    }

    public void setNumeroVisualizzazione(String numeroVisualizzazione) {
        this.numeroVisualizzazione = numeroVisualizzazione;
    }
    
    public Persona getIdPersonaRegistrante() {
        return idPersonaRegistrante;
    }

    public void setIdPersonaRegistrante(Persona idPersonaRegistrante) {
        this.idPersonaRegistrante = idPersonaRegistrante;
    }

    public Struttura getIdStrutturaRegistrante() {
        return idStrutturaRegistrante;
    }

    public void setIdStrutturaRegistrante(Struttura idStrutturaRegistrante) {
        this.idStrutturaRegistrante = idStrutturaRegistrante;
    }

    public ZonedDateTime getDataRegistrazione() {
        return dataRegistrazione;
    }

    public void setDataRegistrazione(ZonedDateTime dataRegistrazione) {
        this.dataRegistrazione = dataRegistrazione;
    }

    public ZonedDateTime getVersion() {
        return version;
    }

    public void setVersion(ZonedDateTime version) {
        this.version = version;
    }

    public Registro getIdRegistro() {
        return idRegistro;
    }

    public void setIdRegistro(Registro idRegistro) {
        this.idRegistro = idRegistro;
    }

    public Doc getIdDoc() {
        return idDoc;
    }

    public void setIdDoc(Doc idDoc) {
        this.idDoc = idDoc;
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
        if (!(object instanceof RegistroDoc)) {
            return false;
        }
        RegistroDoc other = (RegistroDoc) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "it.bologna.ausl.model.entities.scripta.RegistroDoc[ id=" + id + " ]";
    }
    
}
