package it.bologna.ausl.model.entities.rubrica;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import it.nextsw.common.annotations.GenerateProjections;
import it.nextsw.common.annotations.NextSdrAncestor;
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
import javax.persistence.OneToOne;
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
@Table(name = "indirizzi", catalog = "internauta", schema = "rubrica")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Cacheable(false)
@GenerateProjections({"idDettaglioContatto"})
public class Indirizzo implements Serializable {

    @Size(max = 2147483647)
    @Column(name = "descrizione")
    private String descrizione;
    @Size(max = 2147483647)
    @Column(name = "cap")
    private String cap;
    @Size(max = 2147483647)
    @Column(name = "via")
    private String via;
    @Size(max = 2147483647)
    @Column(name = "civico")
    private String civico;
    @Size(max = 2147483647)
    @Column(name = "comune")
    private String comune;
    @Size(max = 2147483647)
    @Column(name = "provincia")
    private String provincia;
    @Size(max = 2147483647)
    @Column(name = "nazione")
    private String nazione;
    @Size(max = 2147483647)
    @Column(name = "tipo")
    private String tipo;
    @Basic(optional = false)
    @NotNull()
    @Column(name = "principale")
    private Boolean principale;
    @Basic(optional = false)
    @NotNull()
    @Size(min = 1, max = 2147483647)
    @Column(name = "provenienza")
    private String provenienza;
    
    @JoinColumn(name = "id_dettaglio_contatto", referencedColumnName = "id")
    @OneToOne(fetch = FetchType.LAZY, cascade = {CascadeType.MERGE, CascadeType.PERSIST}, orphanRemoval=true)
    private DettaglioContatto idDettaglioContatto;
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Version()
    @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss.SSSSSSXXX'['VV']'")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss.SSSSSSXXX'['VV']'")
    private ZonedDateTime version;
    @NextSdrAncestor(relationName = "idContattoDettaglioContatto")
    @JoinColumn(name = "id_contatto", referencedColumnName = "id")
    @ManyToOne(fetch = FetchType.EAGER, cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    private Contatto idContatto;

    public Indirizzo() {
    }

    public Indirizzo(Integer id) {
        this.id = id;
    }

    public Indirizzo(Integer id, Boolean principale, String provenienza) {
        this.id = id;
        this.principale = principale;
        this.provenienza = provenienza;
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

    public Contatto getIdContatto() {
        return idContatto;
    }

    public void setIdContatto(Contatto idContatto) {
        this.idContatto = idContatto;
    }

    public String getDescrizione() {
        return descrizione;
    }

    public void setDescrizione(String descrizione) {
        this.descrizione = descrizione;
    }

    public String getCap() {
        return cap;
    }

    public void setCap(String cap) {
        this.cap = cap;
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

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public boolean getPrincipale() {
        return principale;
    }

    public void setPrincipale(boolean principale) {
        this.principale = principale;
    }

    public String getProvenienza() {
        return provenienza;
    }

    public void setProvenienza(String provenienza) {
        this.provenienza = provenienza;
    }

    public DettaglioContatto getIdDettaglioContatto() {
        return idDettaglioContatto;
    }

    public void setIdDettaglioContatto(DettaglioContatto idDettaglioContatto) {
        this.idDettaglioContatto = idDettaglioContatto;
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
        if (!(object instanceof Indirizzo)) {
            return false;
        }
        Indirizzo other = (Indirizzo) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "it.bologna.ausl.model.entities.rubrica.Indirizzi[ id=" + id + " ]";
    }
}
