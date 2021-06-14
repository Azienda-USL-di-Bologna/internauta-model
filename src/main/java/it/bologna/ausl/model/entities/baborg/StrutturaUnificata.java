package it.bologna.ausl.model.entities.baborg;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import it.nextsw.common.annotations.GenerateProjections;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.time.ZonedDateTime;
import javax.persistence.Basic;
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
import javax.persistence.Version;
import javax.validation.constraints.Size;
import org.springframework.format.annotation.DateTimeFormat;

/**
 *
 * @author solidus83
 */
@Entity
@Table(name = "strutture_unificate", catalog = "internauta", schema = "baborg")
@JsonIgnoreProperties(value = {"hibernateLazyInitializer", "handler"}, ignoreUnknown = true)
@GenerateProjections({"idStrutturaDestinazione, idStrutturaSorgente"})
public class StrutturaUnificata implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "data_attivazione")
    @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss.SSSSSSXXX'['VV']'")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss.SSSSSSXXX'['VV']'")
    private ZonedDateTime dataAttivazione;
    @Column(name = "data_disattivazione")
    @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss.SSSSSSXXX'['VV']'")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss.SSSSSSXXX'['VV']'")
    private ZonedDateTime dataDisattivazione;
    @Column(name = "tipo_operazione")
    @Size(max = 100)
    private String tipoOperazione;
    @JoinColumn(name = "id_struttura_destinazione", referencedColumnName = "id")
    @ManyToOne(optional = false, fetch = FetchType.LAZY, cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    private Struttura idStrutturaDestinazione;
    @JoinColumn(name = "id_struttura_sorgente", referencedColumnName = "id")
    @ManyToOne(optional = false, fetch = FetchType.LAZY, cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    private Struttura idStrutturaSorgente;
    @Column(name = "data_accensione_attivazione")
    @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss.SSSSSSXXX'['VV']'")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss.SSSSSSXXX'['VV']'")
    private ZonedDateTime dataAccensioneAttivazione;
    @Column(name = "data_inserimento_riga", updatable = false, insertable = false)
    @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss.SSSSSSXXX'['VV']'")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss.SSSSSSXXX'['VV']'")
    private ZonedDateTime dataInserimentoRiga;
        
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
    
    public StrutturaUnificata() {
    }

    public StrutturaUnificata(Integer id) {
        this.id = id;
    }

    public StrutturaUnificata(Integer id, ZonedDateTime dataAttivazione, Struttura idStrutturaDestinazione, Struttura idStrutturaSorgente) {
        this.id = id;
        this.dataAttivazione = dataAttivazione;
        this.idStrutturaDestinazione = idStrutturaDestinazione;
        this.idStrutturaSorgente = idStrutturaSorgente;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public ZonedDateTime getDataAttivazione() {
        return dataAttivazione;
    }

    public void setDataAttivazione(ZonedDateTime dataAttivazione) {
        this.dataAttivazione = dataAttivazione;
    }

    public ZonedDateTime getDataDisattivazione() {
        return dataDisattivazione;
    }

    public void setDataDisattivazione(ZonedDateTime dataDisattivazione) {
        this.dataDisattivazione = dataDisattivazione;
    }

    public String getTipoOperazione() {
        return tipoOperazione;
    }

    public void setTipoOperazione(String tipoOperazione) {
        this.tipoOperazione = tipoOperazione;
    }

    public Struttura getIdStrutturaDestinazione() {
        return idStrutturaDestinazione;
    }

    public void setIdStrutturaDestinazione(Struttura idStrutturaDestinazione) {
        this.idStrutturaDestinazione = idStrutturaDestinazione;
    }

    public Struttura getIdStrutturaSorgente() {
        return idStrutturaSorgente;
    }

    public void setIdStrutturaSorgente(Struttura idStrutturaSorgente) {
        this.idStrutturaSorgente = idStrutturaSorgente;
    }

    public ZonedDateTime getDataInserimentoRiga() {
        return dataInserimentoRiga;
    }

    public void setDataInserimentoRiga(ZonedDateTime dataInserimentoRiga) {
        this.dataInserimentoRiga = dataInserimentoRiga;
    }

    public ZonedDateTime getDataAccensioneAttivazione() {
        return dataAccensioneAttivazione;
    }

    public void setDataAccensioneAttivazione(ZonedDateTime dataAccensioneAttivazione) {
        this.dataAccensioneAttivazione = dataAccensioneAttivazione;
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
        if (!(object instanceof StrutturaUnificata)) {
            return false;
        }
        StrutturaUnificata other = (StrutturaUnificata) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "it.bologna.ausl.model.entities.baborg.StrutturaUnificata[ id=" + id + " ]";
    }

}
