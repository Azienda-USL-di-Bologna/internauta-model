package it.bologna.ausl.model.entities.scripta;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.vladmihalcea.hibernate.type.json.JsonBinaryType;
import it.bologna.ausl.model.entities.rubrica.DettaglioContatto;
import it.bologna.ausl.model.entities.shpeck.Message;
import it.nextsw.common.annotations.GenerateProjections;
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
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;
import org.springframework.format.annotation.DateTimeFormat;

/**
 *
 * @author solidus83
 */
@TypeDefs({
    @TypeDef(name = "jsonb", typeClass = JsonBinaryType.class)
})
@Entity
@Table(name = "spedizioni", catalog = "internauta", schema = "scripta")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Cacheable(false)
@GenerateProjections({"idRelated,idMezzo", "idMessage,idMezzo", "idSmistamento,idMezzo", "idMezzo"})
@DynamicUpdate
public class Spedizione implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;

    @JoinColumn(name = "id_related", referencedColumnName = "id")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Related idRelated;

    @JoinColumn(name = "id_message", referencedColumnName = "id")
    @ManyToOne(optional = true, fetch = FetchType.LAZY)
    private Message idMessage;

    @JoinColumn(name = "id_mezzo", referencedColumnName = "id")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Mezzo idMezzo;

    @JoinColumn(name = "id_dettaglio_contatto", referencedColumnName = "id")
    @ManyToOne(optional = true, fetch = FetchType.LAZY)
    private DettaglioContatto idDettaglioContatto;

    @Type(type = "jsonb")
    @Column(name = "indirizzo", columnDefinition = "jsonb")
    private IndirizzoSpedizione indirizzo;

    @JoinColumn(name = "id_smistamento", referencedColumnName = "id")
    @ManyToOne(optional = true, fetch = FetchType.LAZY)
    private Smistamento idSmistamento;

    @Basic(optional = true)
    @Column(name = "annullata")
    private Boolean annullata = false;

    @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss.SSSSSSXXX'['VV']'")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss.SSSSSSXXX'['VV']'")
    @Column(name = "data")
    @Basic(optional = false)
    @NotNull
    private ZonedDateTime data = ZonedDateTime.now();

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

    public Spedizione() {
    }

    public Spedizione(Integer id, Related idRelated, Message idMessage, Mezzo idMezzo, DettaglioContatto idDettaglioContatto, IndirizzoSpedizione indirizzo, Smistamento idSmistamento, ZonedDateTime version) {
        this.id = id;
        this.idRelated = idRelated;
        this.idMessage = idMessage;
        this.idMezzo = idMezzo;
        this.idDettaglioContatto = idDettaglioContatto;
        this.indirizzo = indirizzo;
        this.idSmistamento = idSmistamento;
        this.version = version;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Related getIdRelated() {
        return idRelated;
    }

    public void setIdRelated(Related idRelated) {
        this.idRelated = idRelated;
    }

    public Message getIdMessage() {
        return idMessage;
    }

    public void setIdMessage(Message idMessage) {
        this.idMessage = idMessage;
    }

    public Mezzo getIdMezzo() {
        return idMezzo;
    }

    public void setIdMezzo(Mezzo idMezzo) {
        this.idMezzo = idMezzo;
    }

    public DettaglioContatto getIdDettaglioContatto() {
        return idDettaglioContatto;
    }

    public void setIdDettaglioContatto(DettaglioContatto idDettaglioContatto) {
        this.idDettaglioContatto = idDettaglioContatto;
    }

    public IndirizzoSpedizione getIndirizzo() {
        return indirizzo;
    }

    public void setIndirizzo(IndirizzoSpedizione indirizzo) {
        this.indirizzo = indirizzo;
    }

    public Smistamento getIdSmistamento() {
        return idSmistamento;
    }

    public void setIdSmistamento(Smistamento idSmistamento) {
        this.idSmistamento = idSmistamento;
    }

    public Boolean getAnnullata() {
        return annullata;
    }

    public void setAnnullata(Boolean annullata) {
        this.annullata = annullata;
    }

    public ZonedDateTime getData() {
        return data;
    }

    public void setData(ZonedDateTime data) {
        this.data = data;
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
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : super.hashCode());
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Spedizione)) {
            return false;
        }
        Spedizione other = (Spedizione) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return getClass().getCanonicalName() + "[ id=" + id + " ]";
    }

    public static class IndirizzoSpedizione {

        String completo;
        String via;
        String civico;
        String comune;
        String provincia;
        String nazione;
        String cap;

        public IndirizzoSpedizione() {
        }
        
        public IndirizzoSpedizione(String completo) {
            this.completo = completo;
        }

        public String getCompleto() {
            return completo;
        }

        public void setCompleto(String completo) {
            this.completo = completo;
        }

        public String getVia() {
            return via;
        }

        public void setVia(String via) {
            this.via = via;
        }

        public String getCivico() {
            return civico;
        }

        public void setCivico(String civico) {
            this.civico = civico;
        }

        public String getComune() {
            return comune;
        }

        public void setComune(String comune) {
            this.comune = comune;
        }

        public String getProvincia() {
            return provincia;
        }

        public void setProvincia(String provincia) {
            this.provincia = provincia;
        }

        public String getNazione() {
            return nazione;
        }

        public void setNazione(String nazione) {
            this.nazione = nazione;
        }

        public String getCap() {
            return cap;
        }

        public void setCap(String cap) {
            this.cap = cap;
        }

    }
}
