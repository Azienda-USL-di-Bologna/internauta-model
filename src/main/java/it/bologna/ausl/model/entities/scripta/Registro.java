package it.bologna.ausl.model.entities.scripta;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import it.bologna.ausl.model.entities.baborg.Azienda;
import it.nextsw.common.annotations.GenerateProjections;
import java.io.Serializable;
import java.time.ZonedDateTime;
import java.util.List;
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
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Version;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import org.springframework.format.annotation.DateTimeFormat;

/**
 *
 * @author gusgus
 */
@Entity
@Table(name = "registri", catalog = "internauta", schema = "scripta")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Cacheable(false)
@GenerateProjections({})
public class Registro implements Serializable {
    
    public static enum CodiceRegistro {
        PG,
	DETE,
	DELI,
	RS,
	FASCICOLO,
	PROP_PG,
	PROP_DETE,
	PROP_DELI,
	PROP_RS
    }

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    
    @JoinColumn(name = "id_azienda", referencedColumnName = "id")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Azienda idAzienda;
    
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2147483647)
    @Column(name = "codice")
    private String codice;
    
    @Basic(optional = false)
    @NotNull
    @Column(name = "ufficiale")
    private Boolean ufficiale;
    
    @Column(name = "attivo")
    private Boolean attivo;
    
    @Version()
    @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss.SSSSSSXXX'['VV']'")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss.SSSSSSXXX'['VV']'")
    private ZonedDateTime version;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idRegistro", fetch = FetchType.LAZY)
    @JsonIgnoreProperties("idRegistro")
    private List<RegistroDoc> registroDocList;

    public Registro() {
    }

    public Registro(Integer id) {
        this.id = id;
    }

    public Registro(Integer id, Azienda idAzienda, String codice, boolean ufficiale, ZonedDateTime version) {
        this.id = id;
        this.idAzienda = idAzienda;
        this.codice = codice;
        this.ufficiale = ufficiale;
        this.version = version;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Azienda getIdAzienda() {
        return idAzienda;
    }

    public void setIdAzienda(Azienda idAzienda) {
        this.idAzienda = idAzienda;
    }

    public CodiceRegistro getCodice() {
        if (codice != null) {
            return CodiceRegistro.valueOf(codice);
        } else {
            return null;
        }
    }

    public void setCodice(CodiceRegistro codice) {
        if (codice != null) {
            this.codice = codice.toString();
        } else {
            this.codice = null;
        }
    }

    public boolean getUfficiale() {
        return ufficiale;
    }

    public void setUfficiale(Boolean ufficiale) {
        this.ufficiale = ufficiale;
    }

    public Boolean getAttivo() {
        return attivo;
    }

    public void setAttivo(Boolean attivo) {
        this.attivo = attivo;
    }

    public ZonedDateTime getVersion() {
        return version;
    }

    public void setVersion(ZonedDateTime version) {
        this.version = version;
    }

    public List<RegistroDoc> getRegistriDocsList() {
        return registroDocList;
    }

    public void setRegistriDocsList(List<RegistroDoc> registroDocList) {
        this.registroDocList = registroDocList;
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
        if (!(object instanceof Registro)) {
            return false;
        }
        Registro other = (Registro) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "it.bologna.ausl.model.entities.scripta.Registro[ id=" + id + " ]";
    }
    
}
