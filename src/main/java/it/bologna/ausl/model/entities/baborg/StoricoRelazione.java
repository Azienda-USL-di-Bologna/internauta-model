package it.bologna.ausl.model.entities.baborg;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import it.nextsw.common.annotations.GenerateProjections;
import java.io.Serializable;
import java.time.ZonedDateTime;
import javax.persistence.Basic;
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
 * @author gdm
 */
@Entity
@Table(name = "storico_relazioni", catalog = "internauta", schema = "baborg")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@GenerateProjections({"idStrutturaFiglia", "idStrutturaFiglia, idStrutturaPadre", "idStrutturaPadre"})
public class StoricoRelazione implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;

    @JoinColumn(name = "id_struttura_padre", referencedColumnName = "id")
    @ManyToOne(fetch = FetchType.LAZY, cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    @JsonBackReference(value = "idStrutturaPadre")
    private Struttura idStrutturaPadre;

    @JoinColumn(name = "id_struttura_figlia", referencedColumnName = "id")
    @ManyToOne(fetch = FetchType.LAZY, cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    @JsonBackReference(value = "idStrutturaFiglia")
    private Struttura idStrutturaFiglia;

    @Column(name = "attiva_dal")
    @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss.SSSSSS")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss.SSSSSS")
    private ZonedDateTime attivaDal;

    @Column(name = "attiva_al")
    @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss.SSSSSS")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss.SSSSSS")
    private ZonedDateTime attivaAl;

    @Version()
    @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss.SSSSSSXXX'['VV']'")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss.SSSSSSXXX'['VV']'")
    private ZonedDateTime version;

    public ZonedDateTime getVersion() {
        return version;
    }

    public void setVersion(ZonedDateTime version) {
        this.version = version;
    }
    
    public StoricoRelazione() {
    }

    public StoricoRelazione(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Struttura getIdStrutturaPadre() {
        return idStrutturaPadre;
    }

    public void setIdStrutturaPadre(Struttura idStrutturaPadre) {
        this.idStrutturaPadre = idStrutturaPadre;
    }

    public Struttura getIdStrutturaFiglia() {
        return idStrutturaFiglia;
    }

    public void setIdStrutturaFiglia(Struttura idStrutturaFiglia) {
        this.idStrutturaFiglia = idStrutturaFiglia;
    }

    public ZonedDateTime getAttivaDal() {
        return attivaDal;
    }

    public void ZonedDateTime(ZonedDateTime attivaDal) {
        this.attivaDal = attivaDal;
    }

    public ZonedDateTime getAttivaAl() {
        return attivaAl;
    }

    public void setAttivaAl(ZonedDateTime attivaAl) {
        this.attivaAl = attivaAl;
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
        if (!(object instanceof StoricoRelazione)) {
            return false;
        }
        StoricoRelazione other = (StoricoRelazione) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return getClass().getName() + "[ id=" + id + " ]";
    }

}
