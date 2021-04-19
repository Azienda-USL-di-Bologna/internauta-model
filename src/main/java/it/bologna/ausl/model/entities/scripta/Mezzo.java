package it.bologna.ausl.model.entities.scripta;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import it.bologna.ausl.model.entities.baborg.Azienda;
import it.bologna.ausl.model.entities.baborg.Persona;
import it.nextsw.common.annotations.GenerateProjections;
import java.io.Serializable;
import java.time.ZonedDateTime;
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
import javax.persistence.Version;
import javax.validation.constraints.NotNull;
import org.springframework.format.annotation.DateTimeFormat;

/**
 *
 * @author solidus83
 */
@Entity
@Table(name = "mezzi", catalog = "internauta", schema = "scripta")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Cacheable(false)
@GenerateProjections()
public class Mezzo implements Serializable {

    private static final long serialVersionUID = 1L;

    public static enum CodiciMezzo {
        MAIL, PEC, POSTA_ORDINARIA, FAX, RACCOMANDATA, BABEL, TELEFONO
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;

    @Basic(optional = false)
    @Column(name = "codice")
    @NotNull
    private String codice;

    @Basic(optional = false)
    @Column(name = "descrizione")
    @NotNull
    private String descrizione;

    @Version()
    @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss.SSSSSSXXX'['VV']'")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss.SSSSSSXXX'['VV']'")
    private ZonedDateTime version;

    public Mezzo() {
    }

    public Mezzo(Integer id, String codice, String descrizione, ZonedDateTime version) {
        this.id = id;
        this.codice = codice;
        this.descrizione = descrizione;
        this.version = version;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCodice() {
        return codice;
    }

    public void setCodice(String codice) {
        this.codice = codice;
    }
//Da eliminare quando non si utilizzeranno piu le applicazioni inde
    @JsonIgnore
    public String ottieniCodiceArgo() {
        String codiceArgo = "";
        switch (codice.toUpperCase()) {
            case "PEC":
                codiceArgo = "Pec";
                break;
            case "MAIL":
                codiceArgo = "Email";
                // code block
                break;
            case "Posta Ordinaria":
                codiceArgo = "Posta ordinaria";
                // code block
                break;
            case "FAX":
                codiceArgo = "Fax";
                // code block
                break;
            case "RACCOMANDATA":
                codiceArgo = "Raccomandata";
                // code block
                break;
            case "BABEL":
                codiceArgo = "Babel";
                // code block
                break;
            case "TELEFONO":
                codiceArgo = "Tel";
                // code block
                break;
            default:
            codiceArgo ="Errore";
        }
        return codiceArgo;
    }

    public String getDescrizione() {
        return descrizione;
    }

    public void setDescrizione(String descrizione) {
        this.descrizione = descrizione;
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
        if (!(object instanceof Mezzo)) {
            return false;
        }
        Mezzo other = (Mezzo) object;
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
