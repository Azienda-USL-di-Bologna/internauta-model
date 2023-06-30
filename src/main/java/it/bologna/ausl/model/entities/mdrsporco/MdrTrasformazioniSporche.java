package it.bologna.ausl.model.entities.mdrsporco;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import it.nextsw.common.annotations.GenerateProjections;
import it.bologna.ausl.model.entities.baborg.Azienda;
import java.io.Serializable;
import java.time.ZonedDateTime;
import javax.persistence.Basic;
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
import org.hibernate.annotations.DynamicUpdate;
import org.springframework.format.annotation.DateTimeFormat;

/**
 *
 * @author Top
 */
@Entity
@Table(name = "mdr_trasformazioni", catalog = "internauta", schema = "mdr_sporco")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@GenerateProjections({})
@DynamicUpdate
public class MdrTrasformazioniSporche implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "progressivo_riga")
    private Integer progressivoRiga;
    @Column(name = "id_casella_partenza")
    private Integer idCasellaPartenza;
    @Column(name = "id_casella_arrivo")
    private Integer idCasellaArrivo;
    @Column(name = "data_trasformazione")
    @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss.SSSSSSXXX'['VV']'")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss.SSSSSSXXX'['VV']'")
    private ZonedDateTime dataTrasformazione;
    @Size(max = 2147483647)
    @Column(name = "motivo")
    private String motivo;
    @Column(name = "datain_partenza")
    @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss.SSSSSSXXX'['VV']'")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss.SSSSSSXXX'['VV']'")
    private ZonedDateTime datainPartenza;
    @Column(name = "dataora_oper")
    @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss.SSSSSSXXX'['VV']'")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss.SSSSSSXXX'['VV']'")
    private ZonedDateTime dataoraOper;
    @Column(name = "codice_ente")
    private String codiceEnte;
    @JoinColumn(name = "id_azienda", referencedColumnName = "id")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Azienda idAzienda;

    @Version()
    @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss.SSSSSSXXX'['VV']'")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss.SSSSSSXXX'['VV']'")
    private ZonedDateTime version;
    
    public MdrTrasformazioniSporche() {
    }

    public MdrTrasformazioniSporche(Integer progressivoRiga, Integer idCasellaPartenza, Integer idCasellaArrivo, ZonedDateTime dataTrasformazione, String motivo, ZonedDateTime datainPartenza, ZonedDateTime dataoraOper, String codiceEnte, Azienda idAzienda) {
        this.progressivoRiga = progressivoRiga;
        this.idCasellaPartenza = idCasellaPartenza;
        this.idCasellaArrivo = idCasellaArrivo;
        this.dataTrasformazione = dataTrasformazione;
        this.motivo = motivo;
        this.datainPartenza = datainPartenza;
        this.dataoraOper = dataoraOper;
        this.codiceEnte = codiceEnte;
        this.idAzienda = idAzienda;
    }
    
    

    public MdrTrasformazioniSporche(Integer id) {
        this.id = id;
    }

    public Integer getProgressivoRiga() {
        return progressivoRiga;
    }

    public void setProgressivoRiga(Integer progressivoRiga) {
        this.progressivoRiga = progressivoRiga;
    }

    public Integer getIdCasellaPartenza() {
        return idCasellaPartenza;
    }

    public void setIdCasellaPartenza(Integer idCasellaPartenza) {
        this.idCasellaPartenza = idCasellaPartenza;
    }

    public Integer getIdCasellaArrivo() {
        return idCasellaArrivo;
    }

    public void setIdCasellaArrivo(Integer idCasellaArrivo) {
        this.idCasellaArrivo = idCasellaArrivo;
    }

    public ZonedDateTime getDataTrasformazione() {
        return dataTrasformazione;
    }

    public void setDataTrasformazione(ZonedDateTime dataTrasformazione) {
        this.dataTrasformazione = dataTrasformazione;
    }

    public String getMotivo() {
        return motivo;
    }

    public void setMotivo(String motivo) {
        this.motivo = motivo;
    }

    public ZonedDateTime getDatainPartenza() {
        return datainPartenza;
    }

    public void setDatainPartenza(ZonedDateTime datainPartenza) {
        this.datainPartenza = datainPartenza;
    }

    public ZonedDateTime getDataoraOper() {
        return dataoraOper;
    }

    public void setDataoraOper(ZonedDateTime dataoraOper) {
        this.dataoraOper = dataoraOper;
    }

    public String getCodiceEnte() {
        return codiceEnte;
    }

    public void setCodiceEnte(String codiceEnte) {
        this.codiceEnte = codiceEnte;
    }

    public Azienda getIdAzienda() {
        return idAzienda;
    }

    public void setIdAzienda(Azienda idAzienda) {
        this.idAzienda = idAzienda;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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
        if (!(object instanceof MdrTrasformazioniSporche)) {
            return false;
        }
        MdrTrasformazioniSporche other = (MdrTrasformazioniSporche) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "it.bologna.ausl.model.entities.gru.MdrTrasformazioni[progressivo_riga=" + progressivoRiga + ", id_casella_partenza=" + idCasellaPartenza + ", id_casella_arrivo=" + idCasellaArrivo + ", codice_ente=" + codiceEnte + ", id_azienda=" + idAzienda + ", id=" + id + " ]";
    }
    
}
