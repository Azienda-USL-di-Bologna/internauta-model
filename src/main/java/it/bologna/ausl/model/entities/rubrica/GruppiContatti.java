package it.bologna.ausl.model.entities.rubrica;

import com.fasterxml.jackson.annotation.JsonBackReference;
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
import javax.persistence.Table;
import javax.persistence.Version;
import org.springframework.format.annotation.DateTimeFormat;

/**
 *
 * @author gusgus
 */
@Entity
@Table(name = "gruppi_contatti", catalog = "internauta", schema = "rubrica")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Cacheable(false)
@GenerateProjections({"idContatto, idDettaglioContatto", "idDettaglioContatto, idGruppo", "idGruppo"})
public class GruppiContatti implements Serializable {

    

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Version()
    @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss.SSSSSSXXX'['VV']'")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss.SSSSSSXXX'['VV']'")
    private ZonedDateTime version;
    
    // Colonna id_contatto punta ad un contatto non di Categoria Gruppo.
    // Il valore di questa colonna può essere ripetuto con diversi id_gruppo ma mai con lo stesso id_gruppo
    @JoinColumn(name = "id_contatto", referencedColumnName = "id")
    @ManyToOne(fetch = FetchType.EAGER, cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    @JsonBackReference(value = "idContatto")
    private Contatto idContatto;
    
    // Colonna id_gruppo punta ad un contatto di Categoria GRUPPO
    @JoinColumn(name = "id_gruppo", referencedColumnName = "id")
    @ManyToOne(fetch = FetchType.EAGER, cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    @JsonBackReference(value = "idGruppo")
    private Contatto idGruppo;
    
    @JoinColumn(name = "id_dettaglio_contatto", referencedColumnName = "id")
    @ManyToOne(fetch = FetchType.EAGER, cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    @JsonBackReference(value = "idDettaglioContatto")
    private DettaglioContatto idDettaglioContatto;

    public GruppiContatti() {
    }

    public GruppiContatti(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public ZonedDateTime getVersion() {
        return version;
    }

    public void setVersion(ZonedDateTime version) {
        this.version = version;
    }

    public Contatto getIdGruppo() {
        return idGruppo;
    }

    public void setIdGruppo(Contatto idGruppo) {
        this.idGruppo = idGruppo;
    }

    public Contatto getIdContatto() {
        return idContatto;
    }

    public void setIdContatto(Contatto idContatto) {
        this.idContatto = idContatto;
    }
    
    public DettaglioContatto getIdDettaglioContatto() {
        return idDettaglioContatto;
    }

    public void setIdDettaglioContatto(DettaglioContatto idDettaglioContatto) {
        this.idDettaglioContatto = idDettaglioContatto;
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
        if (!(object instanceof GruppiContatti)) {
            return false;
        }
        GruppiContatti other = (GruppiContatti) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "it.bologna.ausl.model.entities.rubrica.GruppiContatti[ id=" + id + " ]";
    }
    
}
