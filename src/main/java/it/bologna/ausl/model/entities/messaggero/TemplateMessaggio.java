package it.bologna.ausl.model.entities.messaggero;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import it.bologna.ausl.internauta.utils.jpa.tools.GenericArrayUserType;
import it.bologna.ausl.model.entities.messaggero.AmministrazioneMessaggio.InvasivitaEnum;
import it.bologna.ausl.model.entities.messaggero.AmministrazioneMessaggio.TipologiaEnum;
import java.io.Serializable;
import java.time.LocalDateTime;
import javax.persistence.Basic;
import javax.persistence.Cacheable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import org.hibernate.annotations.Parameter;
import org.hibernate.annotations.Type;
import org.springframework.format.annotation.DateTimeFormat;

/**
 *
 * @author Giuseppe Russo <g.russo@nsi.it>
 */

@Entity
@Table(name = "template_messaggi", catalog = "internauta", schema = "messaggero")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler", "authorities"})
@Cacheable(false)
public class TemplateMessaggio implements Serializable { 
      
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    
    @Size(max = 2147483647)
    @Column(name = "nome_template")
    private String nomeTemplate;
    
    @Size(max = 2147483647)
    @Column(name = "testo")
    private String testo;
    
    @Column(name = "id_applicazioni", columnDefinition = "id_applicazioni[]")
    @Type(type = "array", parameters = @Parameter(name = "elements-type", value = GenericArrayUserType.TEXT_ELEMENT_TYPE))
    private String[] idApplicazioni;
    
    @Column(name = "id_aziende", columnDefinition = "id_aziende[]")
    @Type(type = "array", parameters = @Parameter(name = "elements-type", value = GenericArrayUserType.INTEGER_ELEMENT_TYPE))
    private Integer[] idAziende;
    
    @Column(name = "id_strutture", columnDefinition = "id_strutture[]")
    @Type(type = "array", parameters = @Parameter(name = "elements-type", value = GenericArrayUserType.INTEGER_ELEMENT_TYPE))
    private Integer[] idStrutture;
    
    @Column(name = "id_utenti", columnDefinition = "id_utenti[]")
    @Type(type = "array", parameters = @Parameter(name = "elements-type", value = GenericArrayUserType.INTEGER_ELEMENT_TYPE))
    private Integer[] idUtenti;
    
    @Column(name = "per_tutti")
    private Boolean perTutti;
   
    @Column(name = "invasivita")
    private String invasivita;
    
    @Column(name = "tipologia")
    private String tipologia;
    
    @Column(name = "intervallo")
    private Integer intervallo;
    
    @Basic(optional = false)
    @Column(name = "data_inserimento")
    @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss")
    private LocalDateTime dataInserimento = LocalDateTime.now();
    
    @Basic(optional = false)
    @Column(name = "data_ultima_modifica")
    @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss")
    private LocalDateTime dataUltimaModifica = LocalDateTime.now();

    public TemplateMessaggio() {
    }

    public TemplateMessaggio(String nomeTemplate, String testo, String[] idApplicazioni, Integer[] idAziende, Integer[] idStrutture, Integer[] idUtenti, Boolean perTutti, LocalDateTime dataPubblicazione, String invasivita, String tipologia, Integer intervallo, LocalDateTime dataScadenza) {
        this.nomeTemplate = nomeTemplate;
        this.testo = testo;
        this.idApplicazioni = idApplicazioni;
        this.idAziende = idAziende;
        this.idStrutture = idStrutture;
        this.idUtenti = idUtenti;
        this.perTutti = perTutti;
        this.invasivita = invasivita;
        this.tipologia = tipologia;
        this.intervallo = intervallo;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNomeTemplate() {
        return nomeTemplate;
    }

    public void setNomeTemplate(String nomeTemplate) {
        this.nomeTemplate = nomeTemplate;
    }

    public String getTesto() {
        return testo;
    }

    public void setTesto(String testo) {
        this.testo = testo;
    }

    public String[] getIdApplicazioni() {
        return idApplicazioni;
    }

    public void setIdApplicazioni(String[] idApplicazioni) {
        this.idApplicazioni = idApplicazioni;
    }

    public Integer[] getIdAziende() {
        return idAziende;
    }

    public void setIdAziende(Integer[] idAziende) {
        this.idAziende = idAziende;
    }

    public Integer[] getIdStrutture() {
        return idStrutture;
    }

    public void setIdStrutture(Integer[] idStrutture) {
        this.idStrutture = idStrutture;
    }

    public Integer[] getIdUtenti() {
        return idUtenti;
    }

    public void setIdUtenti(Integer[] idUtenti) {
        this.idUtenti = idUtenti;
    }

    public Boolean getPerTutti() {
        return perTutti;
    }

    public void setPerTutti(Boolean perTutti) {
        this.perTutti = perTutti;
    }

    public InvasivitaEnum getInvasivita() {
        if (this.invasivita != null) {
            return InvasivitaEnum.valueOf(invasivita);
        } else {
            return null;
        }
    }

    public void setInvasivita(InvasivitaEnum invasivita) {
        this.invasivita = invasivita.toString();
    }

    public TipologiaEnum getTipologia() {
        if (this.tipologia != null) {
            return TipologiaEnum.valueOf(tipologia);
        } else {
            return null;
        }
    }

    public void setTipologia(TipologiaEnum tipologia) {
        this.tipologia = tipologia.toString();
    }

    public Integer getIntervallo() {
        return intervallo;
    }

    public void setIntervallo(Integer intervallo) {
        this.intervallo = intervallo;
    }

    public LocalDateTime getDataInserimento() {
        return dataInserimento;
    }

    public void setDataInserimento(LocalDateTime dataInserimento) {
        this.dataInserimento = dataInserimento;
    }

    public LocalDateTime getDataUltimaModifica() {
        return dataUltimaModifica;
    }

    public void setDataUltimaModifica(LocalDateTime dataUltimaModifica) {
        this.dataUltimaModifica = dataUltimaModifica;
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
        if (!(object instanceof TemplateMessaggio)) {
            return false;
        }
        TemplateMessaggio other = (TemplateMessaggio) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "it.bologna.ausl.model.entities.baborg.TemplateMessaggi[ id=" + id + " ]";
    } 
}
