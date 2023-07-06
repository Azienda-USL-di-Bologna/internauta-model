package it.bologna.ausl.model.entities.tip;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import it.bologna.ausl.model.entities.scripta.DocDoc;
import it.bologna.ausl.model.entities.scripta.Registro;
import it.nextsw.common.annotations.GenerateProjections;
import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Basic;
import javax.persistence.Cacheable;
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
import org.hibernate.annotations.DynamicUpdate;

/**
 *
 * @author gdm
 */
@Entity
@Table(name = "documenti_da_collegare", catalog = "internauta", schema = "tip")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Cacheable(false)
@GenerateProjections()
@DynamicUpdate
public class DocumentoDaCollegare implements Serializable {
    
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Long id;

        
    @JoinColumn(name = "id_sessione_importazioni", referencedColumnName = "id")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private SessioneImportazione idSessioneImportazione;

    @JoinColumn(name = "id_registro_sorgente", referencedColumnName = "id")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @JsonBackReference(value = "idRegistroSorgente")
    private Registro idRegistroSorgente;
    
    @Basic(optional = false)
    @Column(name = "numero_sorgente")
    @NotNull
    private Integer numeroSorgente;
    
    @Basic(optional = false)
    @Column(name = "anno_sorgente")
    @NotNull
    private Integer annoSorgente;
    
    @JoinColumn(name = "id_registro_destinazione", referencedColumnName = "id")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @JsonBackReference(value = "idRegistroDestinazione")
    private Registro idRegistroDestinazione;
    
    @Basic(optional = false)
    @Column(name = "numero_destinazione")
    @NotNull
    private Integer numeroDestinazione;
    
    @Basic(optional = false)
    @Column(name = "anno_destinazione")
    @NotNull
    private Integer annoDestinazione;
    
    @Basic(optional = false)
    @Column(name = "tipo_collegamento")
    @NotNull
    private DocDoc.TipoCollegamentoDoc tipoCollegamento;

    public DocumentoDaCollegare() {
    }

    public DocumentoDaCollegare(SessioneImportazione idSessioneImportazione, Registro idRegistroSorgente, Integer numeroSorgente, Integer annoSorgente, Registro idRegistroDestinazione, Integer numeroDestinazione, Integer annoDestinazione, DocDoc.TipoCollegamentoDoc tipoCollegamento) {
        this.idSessioneImportazione = idSessioneImportazione;
        this.idRegistroSorgente = idRegistroSorgente;
        this.numeroSorgente = numeroSorgente;
        this.annoSorgente = annoSorgente;
        this.idRegistroDestinazione = idRegistroDestinazione;
        this.numeroDestinazione = numeroDestinazione;
        this.annoDestinazione = annoDestinazione;
        this.tipoCollegamento = tipoCollegamento;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public SessioneImportazione getIdSessioneImportazione() {
        return idSessioneImportazione;
    }

    public void setIdSessioneImportazione(SessioneImportazione idSessioneImportazione) {
        this.idSessioneImportazione = idSessioneImportazione;
    }

    public Registro getIdRegistroSorgente() {
        return idRegistroSorgente;
    }

    public void setIdRegistroSorgente(Registro idRegistroSorgente) {
        this.idRegistroSorgente = idRegistroSorgente;
    }

    public Integer getNumeroSorgente() {
        return numeroSorgente;
    }

    public void setNumeroSorgente(Integer numeroSorgente) {
        this.numeroSorgente = numeroSorgente;
    }

    public Integer getAnnoSorgente() {
        return annoSorgente;
    }

    public void setAnnoSorgente(Integer annoSorgente) {
        this.annoSorgente = annoSorgente;
    }

    public Registro getIdRegistroDestinazione() {
        return idRegistroDestinazione;
    }

    public void setIdRegistroDestinazione(Registro idRegistroDestinazione) {
        this.idRegistroDestinazione = idRegistroDestinazione;
    }

    public Integer getNumeroDestinazione() {
        return numeroDestinazione;
    }

    public void setNumeroDestinazione(Integer numeroDestinazione) {
        this.numeroDestinazione = numeroDestinazione;
    }

    public Integer getAnnoDestinazione() {
        return annoDestinazione;
    }

    public void setAnnoDestinazione(Integer annoDestinazione) {
        this.annoDestinazione = annoDestinazione;
    }


    public DocDoc.TipoCollegamentoDoc getTipoCollegamento() {
        return tipoCollegamento;
    }

    public void setTipoCollegamento(DocDoc.TipoCollegamentoDoc tipoCollegamento) {
        this.tipoCollegamento = tipoCollegamento;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DocumentoDaCollegare)) {
            return false;
        }
        DocumentoDaCollegare other = (DocumentoDaCollegare) object;
        return !((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id)));
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 83 * hash + Objects.hashCode(this.id);
        return hash;
    }

    @Override
    public String toString() {
        return String.format("%s[id=%s]", getClass().getCanonicalName(), getId());
    }

}
