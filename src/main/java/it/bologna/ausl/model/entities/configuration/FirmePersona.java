package it.bologna.ausl.model.entities.configuration;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import it.bologna.ausl.model.entities.baborg.Persona;
import it.nextsw.common.annotations.GenerateProjections;
import java.io.Serializable;
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
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author gusgus
 */
@Entity
@Table(name = "firme_persona", catalog = "internauta", schema = "configurazione")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Cacheable(false)
@GenerateProjections({})
public class FirmePersona implements Serializable {
    
    public static enum TipoFirma {
        CNS,
        REMOTA
    }
    
    public static enum TramiteFirma {
        APPLET,
        WEBSTART,
        ARUBA,
        JR
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
//    @Lob
//    @Column(name = "additional_data")
//    private Object additionalData;

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

//    public Object getAdditionalData() {
//        return additionalData;
//    }
//
//    public void setAdditionalData(Object additionalData) {
//        this.additionalData = additionalData;
//    }

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
    
}
