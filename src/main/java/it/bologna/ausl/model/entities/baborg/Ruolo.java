package it.bologna.ausl.model.entities.baborg;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import it.nextsw.common.annotations.GenerateProjections;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.time.ZonedDateTime;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Version;
import javax.validation.constraints.NotNull;
import org.springframework.format.annotation.DateTimeFormat;

/**
 *
 * @author solidus83
 */
@Entity
@Table(name = "ruoli", catalog = "internauta", schema = "baborg")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@GenerateProjections({})
public class Ruolo implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Column(name = "nome", columnDefinition = "text")
    private String nome;
    @Basic(optional = false)
    @NotNull
    @Column(name = "nome_breve", columnDefinition = "text")
    private String nomeBreve;
    @Basic(optional = false)
    @NotNull
    @Column(name = "maschera_bit")
    private Integer mascheraBit;
    @Basic(optional = false)
    @NotNull
    @Column(name = "super_aziendale")
    private Boolean superAziendale;

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

    public static enum CodiciRuolo {
        UG, MOS, OS, CA, CI, AS, SD, SR, R
    }

    public Ruolo() {
    }

    public Ruolo(Integer id) {
        this.id = id;
    }

    public Ruolo(Integer id, String nome, String nomeBreve, Integer mascheraBit, Boolean superAziendale) {
        this.id = id;
        this.nome = nome;
        this.nomeBreve = nomeBreve;
        this.mascheraBit = mascheraBit;
        this.superAziendale = superAziendale;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public CodiciRuolo getNomeBreve() {
        if (nomeBreve != null) {
            return CodiciRuolo.valueOf(nomeBreve);
        } else {
            return null;
        }
    }

    public void setNomeBreve(CodiciRuolo nomeBreve) {
        if (nomeBreve != null) {
            this.nomeBreve = nomeBreve.name();
        } else {
            this.nomeBreve = null;
        }
    }

    public Integer getMascheraBit() {
        return mascheraBit;
    }

    public void setMascheraBit(Integer mascheraBit) {
        this.mascheraBit = mascheraBit;
    }

    public Boolean getSuperAziendale() {
        return superAziendale;
    }

    public void setSuperAziendale(Boolean superAziendale) {
        this.superAziendale = superAziendale;
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
        if (!(object instanceof Ruolo)) {
            return false;
        }
        Ruolo other = (Ruolo) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "it.bologna.ausl.model.entities.baborg.Ruolo[ id=" + id + " ]";
    }

}
