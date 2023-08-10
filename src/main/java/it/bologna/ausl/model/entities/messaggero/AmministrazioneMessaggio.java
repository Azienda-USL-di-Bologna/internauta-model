package it.bologna.ausl.model.entities.messaggero;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.annotation.Nulls;
import com.vladmihalcea.hibernate.type.array.IntArrayType;
import com.vladmihalcea.hibernate.type.array.StringArrayType;
import it.nextsw.common.annotations.GenerateProjections;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.time.ZonedDateTime;
import javax.persistence.Basic;
import javax.persistence.Cacheable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Version;
import javax.validation.constraints.Size;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.Parameter;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;
import org.springframework.format.annotation.DateTimeFormat;

/**
 *
 * @author Giuseppe Russo <g.russo@nsi.it>
 */
@TypeDefs({
    @TypeDef(name = "string-array", typeClass = StringArrayType.class),
    @TypeDef(name = "int-array", typeClass = IntArrayType.class)
})

@Entity
@Table(name = "amministrazione_messaggi", catalog = "internauta", schema = "messaggero")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler", "authorities"})
@Cacheable(false)
@GenerateProjections({})
@DynamicUpdate
public class AmministrazioneMessaggio implements Serializable {
    
    public static enum InvasivitaEnum {
        LOGIN, POPUP
    }
    
    public static enum SeveritaEnum {
        INFO, WARNING, ERROR
    }
    
    public static enum TipologiaEnum {
        RIPRESENTA_CON_INTERVALLO, MOSTRA_UNA_SOLA_VOLTA, CONSENTI_SCELTA
    }
      
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    
    @Size(max = 2147483647)
    @Column(name = "titolo")
    private String titolo;
    
    @Size(max = 2147483647)
    @Column(name = "testo")
    private String testo;
    
    @Column(name = "id_applicazioni", columnDefinition = "text[]")
    @Type(type = "string-array")
    private String[] idApplicazioni;
    
    @Column(name = "id_aziende", columnDefinition = "integer[]")
    @Type(type = "int-array")
    private Integer[] idAziende;
    
    @Column(name = "id_strutture", columnDefinition = "integer[]")
    @Type(type = "int-array")
    private Integer[] idStrutture;
    
    @Column(name = "id_persone", columnDefinition = "integer[]")
    @Type(type = "int-array")
    private Integer[] idPersone;
   
    @Column(name = "per_tutti")
    private Boolean perTutti;
    
    @Column(name = "data_pubblicazione")
    @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss.SSSSSSXXX'['VV']'")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss.SSSSSSXXX'['VV']'")
    private ZonedDateTime dataPubblicazione;
    
    @Column(name = "invasivita")
    private String invasivita;
    
    @Column(name = "tipologia")
    private String tipologia;
    
    @Column(name = "severita")
    private String severita;
    
    @Column(name = "intervallo")
    private Integer intervallo;
    
    @Column(name = "data_scadenza")
    @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss.SSSSSSXXX'['VV']'")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss.SSSSSSXXX'['VV']'")
    private ZonedDateTime dataScadenza;
    
    @Basic(optional = false)
    @Column(name = "data_inserimento")
    @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss.SSSSSSXXX'['VV']'")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss.SSSSSSXXX'['VV']'")
    private ZonedDateTime dataInserimento = ZonedDateTime.now();
    
    @Basic(optional = false)
    @Column(name = "data_ultima_modifica")
    @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss.SSSSSSXXX'['VV']'")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss.SSSSSSXXX'['VV']'")
    private ZonedDateTime dataUltimaModifica = ZonedDateTime.now();
        
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
 
    public AmministrazioneMessaggio() {
    }

    public AmministrazioneMessaggio(String titolo, String testo, String[] idApplicazioni, Integer[] idAziende, Integer[] idStrutture, Integer[] idPersone, Boolean perTutti, ZonedDateTime dataPubblicazione, String invasivita, String tipologia, Integer intervallo, ZonedDateTime dataScadenza) {
        this.titolo = titolo;
        this.testo = testo;
        this.idApplicazioni = idApplicazioni;
        this.idAziende = idAziende;
        this.idStrutture = idStrutture;
        this.idPersone = idPersone;
        this.perTutti = perTutti;
        this.dataPubblicazione = dataPubblicazione;
        this.invasivita = invasivita;
        this.tipologia = tipologia;
        this.intervallo = intervallo;
        this.dataScadenza = dataScadenza;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitolo() {
        return titolo;
    }

    public void setTitolo(String titolo) {
        this.titolo = titolo;
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

    public Integer[] getIdPersone() {
        return idPersone;
    }

    public void setIdPersone(Integer[] idPersone) {
        this.idPersone = idPersone;
    }

    public Boolean getPerTutti() {
        return perTutti;
    }

    public void setPerTutti(Boolean perTutti) {
        this.perTutti = perTutti;
    }

    public ZonedDateTime getDataPubblicazione() {
        return dataPubblicazione;
    }

    public void setDataPubblicazione(ZonedDateTime dataPubblicazione) {
        this.dataPubblicazione = dataPubblicazione;
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

    @JsonSetter(nulls = Nulls.SKIP)
    public TipologiaEnum getTipologia() {
        if (this.tipologia != null) {
            return TipologiaEnum.valueOf(tipologia);
        } else {
            return null;
        }
    }

    @JsonSetter(nulls = Nulls.SKIP)
    public void setTipologia(TipologiaEnum tipologia) {
        this.tipologia = tipologia.toString();
    }
    
    public SeveritaEnum getSeverita() {
        if (this.severita != null) {
            return SeveritaEnum.valueOf(severita);
        } else {
            return null;
        }
    }

    @JsonSetter(nulls = Nulls.SKIP)
    public void setSeverita(SeveritaEnum severita) {
        this.severita = severita.toString();
    }

    public Integer getIntervallo() {
        return intervallo;
    }

    public void setIntervallo(Integer intervallo) {
        this.intervallo = intervallo;
    }

    public ZonedDateTime getDataScadenza() {
        return dataScadenza;
    }

    public void setDataScadenza(ZonedDateTime dataScadenza) {
        this.dataScadenza = dataScadenza;
    }

    public ZonedDateTime getDataInserimento() {
        return dataInserimento;
    }

    public void setDataInserimento(ZonedDateTime dataInserimento) {
        this.dataInserimento = dataInserimento;
    }

    public ZonedDateTime getDataUltimaModifica() {
        return dataUltimaModifica;
    }

    public void setDataUltimaModifica(ZonedDateTime dataUltimaModifica) {
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
        if (!(object instanceof AmministrazioneMessaggio)) {
            return false;
        }
        AmministrazioneMessaggio other = (AmministrazioneMessaggio) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "it.bologna.ausl.model.entities.baborg.AmministrazioneMessaggio[ id=" + id + " ]";
    } 
}
