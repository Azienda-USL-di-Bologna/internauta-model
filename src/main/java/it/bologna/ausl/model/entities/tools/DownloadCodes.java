package it.bologna.ausl.model.entities.tools;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import it.nextsw.common.data.annotations.GenerateProjections;
import java.io.Serializable;
import java.time.ZonedDateTime;
import javax.persistence.Basic;
import javax.persistence.Cacheable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Version;
import javax.validation.constraints.NotNull;
import org.hibernate.annotations.DynamicUpdate;
import org.springframework.format.annotation.DateTimeFormat;

/**
 *
 * @author Top
 */
@Entity
@Table(name = "donwload_codes", catalog = "internauta", schema = "tools")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Cacheable(false)
@GenerateProjections()
@DynamicUpdate
public class DownloadCodes implements Serializable{
    
    public static enum TipologiaDownloadCodes {
        A_TEMPO,
        UNA_TANTUM
    }
    
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    
    @Basic(optional = true)
    @Column(name = "pec")
    private String pec;
    
    @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss.SSSSSSXXX'['VV']'")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss.SSSSSSXXX'['VV']'")
    @Column(name = "data_creazione")
    @Basic(optional = false)
    @NotNull
    private ZonedDateTime dataCreazione = ZonedDateTime.now();
    
    @Column(name = "tipologia")
    @Enumerated(EnumType.STRING)
    private TipologiaDownloadCodes tipologiaDownloadCodes;
    
    @Basic(optional = true)
    @Column(name = "codice_validazione")
    private String codiceValidazione;
    
    @Basic(optional = true)
    @Column(name = "tempo_valido")
    private Integer tempoValido;

    @Basic(optional = true)
    @Column(name = "link")
    private String link;
    
    @Version()
    @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss.SSSSSSXXX'['VV']'")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss.SSSSSSXXX'['VV']'")
    private ZonedDateTime version;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPec() {
        return pec;
    }

    public void setPec(String pec) {
        this.pec = pec;
    }

    public ZonedDateTime getDataCreazione() {
        return dataCreazione;
    }

    public void setDataCreazione(ZonedDateTime dataCreazione) {
        this.dataCreazione = dataCreazione;
    }

    public TipologiaDownloadCodes getTipologiaDownloadCodes() {
        return tipologiaDownloadCodes;
    }

    public void setTipologiaDownloadCodes(TipologiaDownloadCodes tipologiaDownloadCodes) {
        this.tipologiaDownloadCodes = tipologiaDownloadCodes;
    }

    public String getCodiceValidazione() {
        return codiceValidazione;
    }

    public void setCodiceValidazione(String codiceValidazione) {
        this.codiceValidazione = codiceValidazione;
    }

    public Integer getTempoValido() {
        return tempoValido;
    }

    public void setTempoValido(Integer tempoValido) {
        this.tempoValido = tempoValido;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public ZonedDateTime getVersion() {
        return version;
    }

    public void setVersion(ZonedDateTime version) {
        this.version = version;
    }
    
    
  
    
    
}
