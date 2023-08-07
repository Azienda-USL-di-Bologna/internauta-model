package it.bologna.ausl.model.entities.versatore;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.vladmihalcea.hibernate.type.json.JsonBinaryType;
import it.bologna.ausl.model.entities.scripta.Allegato;
import it.bologna.ausl.model.entities.versatore.Versamento.StatoVersamento;
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
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;
import org.springframework.format.annotation.DateTimeFormat;

/**
 *
 * @author Giuseppe Russo <g.russo@nsi.it>
 */
@TypeDefs({
    @TypeDef(name = "jsonb", typeClass = JsonBinaryType.class)
})
@Entity
@Table(name = "versamenti_allegati", schema = "versatore")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Cacheable(false)
@DynamicUpdate
public class VersamentoAllegato implements Serializable {
    
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;
    
    @JoinColumn(name = "id_versamento", referencedColumnName = "id")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @JsonBackReference(value = "idVersamento")
    private Versamento idVersamento;
    
    @JoinColumn(name = "id_allegato", referencedColumnName = "id")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @JsonBackReference(value = "idAllegato")
    private Allegato idAllegato;
    
    @Column(name = "stato")
    private String stato;
    
    @Column(name = "forzabile")
    @NotNull
    @Basic(optional = false)
    private Boolean forzabile = false;
    
    @Column(name = "metadati_versati")
    private String metadatiVersati;
    
    @Column(name = "rapporto")
    private String rapporto;
    
    @Column(name = "codice_errore")
    private String codiceErrore;
    
    @Column(name = "descrizione_errore")
    private String descrizioneErrore;
    
    @Column(name = "dettaglio_allegato")
    @NotNull
    @Basic(optional = false)
    private String dettaglioAllegato;
    
    @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss.SSSSSSXXX'['VV']'")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss.SSSSSSXXX'['VV']'")
    @Column(name = "data_inserimento")
    @Basic(optional = false)
    @NotNull
    private ZonedDateTime dataInserimento = ZonedDateTime.now();
    
    @Version()
    @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss.SSSSSSXXX'['VV']'")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss.SSSSSSXXX'['VV']'")
    private ZonedDateTime version;

    public VersamentoAllegato() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Versamento getIdVersamento() {
        return idVersamento;
    }

    public void setIdVersamento(Versamento idVersamento) {
        this.idVersamento = idVersamento;
    }

    public Allegato getIdAllegato() {
        return idAllegato;
    }

    public void setIdAllegato(Allegato idAllegato) {
        this.idAllegato = idAllegato;
    }

    public StatoVersamento getStato() {
        if (stato != null) {
            return StatoVersamento.valueOf(stato);
        } else {
            return null;
        }
    }

    public void setStato(StatoVersamento stato) {
        if (stato != null) {
            this.stato = stato.toString();
        } else {
            this.stato = null;
        }
    }

    public Boolean getForzabile() {
        return forzabile;
    }

    public void setForzabile(Boolean forzabile) {
        this.forzabile = forzabile;
    }

    public Allegato.DettagliAllegato.TipoDettaglioAllegato getDettaglioAllegato() {
        if (dettaglioAllegato != null) {
            return Allegato.DettagliAllegato.TipoDettaglioAllegato.valueOf(dettaglioAllegato);
        } else {
            return null;
        }
    }
    
    public void setDettaglioAllegato(Allegato.DettagliAllegato.TipoDettaglioAllegato dettaglioAllegato) {
        if (dettaglioAllegato != null) {
            this.dettaglioAllegato = dettaglioAllegato.toString();
        } else {
            this.dettaglioAllegato = null;
        }
    }

    public String getMetadatiVersati() {
        return metadatiVersati;
    }

    public void setMetadatiVersati(String metadatiVersati) {
        this.metadatiVersati = metadatiVersati;
    }

    public String getRapporto() {
        return rapporto;
    }

    public void setRapporto(String rapporto) {
        this.rapporto = rapporto;
    }

    public String getCodiceErrore() {
        return codiceErrore;
    }

    public void setCodiceErrore(String codiceErrore) {
        this.codiceErrore = codiceErrore;
    }

    public String getDescrizioneErrore() {
        return descrizioneErrore;
    }

    public void setDescrizioneErrore(String descrizioneErrore) {
        this.descrizioneErrore = descrizioneErrore;
    }

    public ZonedDateTime getDataInserimento() {
        return dataInserimento;
    }

    public void setDataInserimento(ZonedDateTime dataInserimento) {
        this.dataInserimento = dataInserimento;
    }

    public ZonedDateTime getVersion() {
        return version;
    }

    public void setVersion(ZonedDateTime version) {
        this.version = version;
    }
    
    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof VersamentoAllegato)) {
            return false;
        }
        VersamentoAllegato other = (VersamentoAllegato) object;
        return !((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id)));
    }

    @Override
    public String toString() {
        return getClass().getCanonicalName()+ "[ id=" + id + " ]";
    }

}