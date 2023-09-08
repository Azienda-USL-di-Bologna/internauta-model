package it.bologna.ausl.model.entities.scripta;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import it.bologna.ausl.model.entities.baborg.Persona;
import it.nextsw.common.data.annotations.GenerateProjections;
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
import javax.validation.constraints.Size;
import org.hibernate.annotations.DynamicUpdate;
import org.springframework.format.annotation.DateTimeFormat;

/**
 *
 * @author gusgus
 */
@Entity
@Table(name = "docs_docs", catalog = "internauta", schema = "scripta")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Cacheable(false)
@GenerateProjections({})
@DynamicUpdate
public class DocDoc implements Serializable {

    private static final long serialVersionUID = 1L;
    
    public static enum TipoCollegamentoDoc {
        PRECEDENTE
    }
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    
    @JoinColumn(name = "id_doc_sorgente", referencedColumnName = "id")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @JsonBackReference(value = "idDocSorgente")
    private Doc idDocSorgente;
    
    @JoinColumn(name = "id_doc_destinazione", referencedColumnName = "id")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @JsonBackReference(value = "idDocDestinazione")
    private Doc idDocDestinazione;
    
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2147483647)
    @Enumerated(EnumType.STRING)
    @Column(name = "tipo_collegamento")
    private TipoCollegamentoDoc tipoCollegamento;
    
    @JoinColumn(name = "id_persona_collegante", referencedColumnName = "id")
    @ManyToOne(optional = false, fetch = FetchType.LAZY, cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    @JsonBackReference(value = "idPersonaCollegante")
    private Persona idPersonaCollegante;

    @Basic(optional = false)
    @NotNull
    @Column(name = "data_inserimento_riga")
    @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss.SSSSSSXXX'['VV']'")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss.SSSSSSXXX'['VV']'")
    private ZonedDateTime dataInserimentoRiga = ZonedDateTime.now();
    
    @Version()
    @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss.SSSSSSXXX'['VV']'")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss.SSSSSSXXX'['VV']'")
    private ZonedDateTime version;

    public DocDoc() {
    }

    public DocDoc(Integer id) {
        this.id = id;
    }

    public DocDoc(Doc idDocSorgente, Doc idDocDestinazione, TipoCollegamentoDoc tipoCollegamento, Persona idPersonaCollegante) {
        this.idDocSorgente = idDocSorgente;
        this.idDocDestinazione = idDocDestinazione;
        this.tipoCollegamento = tipoCollegamento;
        this.idPersonaCollegante = idPersonaCollegante;
    }
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Doc getIdDocSorgente() {
        return idDocSorgente;
    }

    public void setIdDocSorgente(Doc idDocSorgente) {
        this.idDocSorgente = idDocSorgente;
    }

    public Doc getIdDocDestinazione() {
        return idDocDestinazione;
    }

    public void setIdDocDestinazione(Doc idDocDestinazione) {
        this.idDocDestinazione = idDocDestinazione;
    }

    public TipoCollegamentoDoc getTipoCollegamento() {
        return tipoCollegamento;
    }

    public void setTipoCollegamento(TipoCollegamentoDoc tipoCollegamento) {
        this.tipoCollegamento = tipoCollegamento;
    }

    public Persona getIdPersonaCollegante() {
        return idPersonaCollegante;
    }

    public void setIdPersonaCollegante(Persona idPersonaCollegante) {
        this.idPersonaCollegante = idPersonaCollegante;
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
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DocDoc)) {
            return false;
        }
        DocDoc other = (DocDoc) object;
        return !((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id)));
    }

    @Override
    public String toString() {
        return String.format("%s[id=%s]", getClass().getCanonicalName(), getId());
    }
    
}
