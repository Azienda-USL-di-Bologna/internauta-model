package it.bologna.ausl.model.entities.configurazione;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.vladmihalcea.hibernate.type.json.JsonBinaryType;
import it.bologna.ausl.model.entities.baborg.Persona;
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
import javax.persistence.Transient;
import javax.persistence.Version;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;
import org.springframework.format.annotation.DateTimeFormat;

/**
 *
 * @author gusgus
 */
@Entity
@Table(name = "firme_persona", catalog = "internauta", schema = "configurazione")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Cacheable(false)
@GenerateProjections({})
@TypeDefs({
    @TypeDef(name = "jsonb", typeClass = JsonBinaryType.class)
})
@DynamicUpdate
public class FirmePersona implements Serializable {

    public static enum TipoFirma {
        CNS,
        REMOTA
    }

    public static enum TramiteFirma {
        APPLET,
        WEBSTART,
        ARUBA,
        INFOCERT,
        NAMIRIAL,
        JR,
        JNJ
    }

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;

    @JoinColumn(name = "id_persona", referencedColumnName = "id")
    @ManyToOne(fetch = FetchType.EAGER, cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    private Persona idPersona;

    @Basic(optional = false)
    @NotNull
    @Column(name = "predefinita")
    private Boolean predefinita;

    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2147483647)
    @Column(name = "tipo")
    private String tipo;

    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2147483647)
    @Column(name = "tramite")
    private String tramite;

    @Type(type = "jsonb")
    @Column(name = "additional_data", columnDefinition = "jsonb")
    private AdditionalDataFirma additionalData;
    
    @Transient
    private String password;

    @Version()
    @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss.SSSSSSXXX'['VV']'")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss.SSSSSSXXX'['VV']'")
    private ZonedDateTime version;

    public FirmePersona() {
    }

    public FirmePersona(Integer id) {
        this.id = id;
    }

    public FirmePersona(Integer id, Persona idPersona, Boolean predefinita, String tipo, String tramite) {
        this.id = id;
        this.idPersona = idPersona;
        this.predefinita = predefinita;
        this.tipo = tipo;
        this.tramite = tramite;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Persona getIdPersona() {
        return idPersona;
    }

    public void setIdPersona(Persona idPersona) {
        this.idPersona = idPersona;
    }

    public Boolean getPredefinita() {
        return predefinita;
    }

    public void setPredefinita(Boolean predefinita) {
        this.predefinita = predefinita;
    }

    public TipoFirma getTipo() {
        return TipoFirma.valueOf(tipo);
    }

    public void setTipo(TipoFirma tipo) {
        this.tipo = tipo.toString();
    }

    public TramiteFirma getTramite() {
        return TramiteFirma.valueOf(tramite);
    }

    public void setTramite(TramiteFirma tramite) {
        this.tramite = tramite.toString();
    }

    public AdditionalDataFirma getAdditionalData() {
        return additionalData;
    }

    public void setAdditionalData(AdditionalDataFirma additionalData) {
        this.additionalData = additionalData;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
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
        if (!(object instanceof FirmePersona)) {
            return false;
        }
        FirmePersona other = (FirmePersona) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "it.bologna.ausl.model.entities.configuration.FirmePersona[ id=" + id + " ]";
    }

    @JsonInclude(Include.NON_NULL)
    public static class AdditionalDataFirma {

        private String username;
        private String password;
        private String dominio;
        private String hostId;
        private String autenticazione;
        private String configurazione;
        private Boolean savedCredential;

        public AdditionalDataFirma() {
        }

        public String getUsername() {
            return username;
        }

        public void setUsername(String username) {
            this.username = username;
        }

        public String getPassword() {
            return password;
        }

        public void setPassword(String password) {
            this.password = password;
        }

        public String getDominio() {
            return dominio;
        }

        public void setDominio(String dominio) {
            this.dominio = dominio;
        }

        public String getHostId() {
            return hostId;
        }

        public void setHostId(String hostId) {
            this.hostId = hostId;
        }

        public String getAutenticazione() {
            return autenticazione;
        }

        public void setAutenticazione(String autenticazione) {
            this.autenticazione = autenticazione;
        }

        public String getConfigurazione() {
            return configurazione;
        }

        public void setConfigurazione(String configurazione) {
            this.configurazione = configurazione;
        }

        public Boolean getSavedCredential() {
            return savedCredential;
        }

        public void setSavedCredential(Boolean savedCredential) {
            this.savedCredential = savedCredential;
        }
    }
}
