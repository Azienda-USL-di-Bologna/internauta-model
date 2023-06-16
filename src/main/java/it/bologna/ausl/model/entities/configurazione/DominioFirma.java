package it.bologna.ausl.model.entities.configurazione;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import it.nextsw.common.annotations.GenerateProjections;
import java.io.Serializable;
import java.time.ZonedDateTime;
import javax.persistence.Basic;
import javax.persistence.Cacheable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Version;
import javax.validation.constraints.NotNull;
import org.hibernate.annotations.DynamicUpdate;
import org.springframework.format.annotation.DateTimeFormat;

/**
 *
 * @author spritz
 */
@Entity
@Table(name = "domini_firme", catalog = "internauta", schema = "configurazione")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Cacheable(false)
@GenerateProjections({})
@DynamicUpdate
public class DominioFirma implements Serializable {

    private static final long serialVersionUID = 1L;

    public static enum DominiFirma {
        frAUSLBO, frAUSLPR, frAOPR, frAslImola, firma
    }

    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "codice", columnDefinition = "text")
    private String codice;

    @Basic(optional = false)
    @NotNull
    @Column(name = "nome", columnDefinition = "text")
    private String nome;

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

    public DominioFirma() {
    }

    public DominioFirma(String codice) {
        this.codice = codice;
    }

    public DominioFirma(String codice, String nome) {
        this.codice = codice;
        this.nome = nome;
    }

    public String getCodice() {
        return codice;
    }

    public void setCodice(String codice) {
        this.codice = codice;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codice != null ? codice.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DominioFirma)) {
            return false;
        }
        DominioFirma other = (DominioFirma) object;
        return !((this.codice == null && other.codice != null) || (this.codice != null && !this.codice.equals(other.codice)));
    }

    @Override
    public String toString() {
        return getClass().getCanonicalName() + "[ codice=" + codice + " ]";
    }
}
