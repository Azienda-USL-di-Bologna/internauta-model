package it.bologna.ausl.model.entities.baborg;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import it.bologna.ausl.internauta.utils.jpa.tools.GenericArrayUserType;
import it.bologna.ausl.jenesisprojections.annotations.GenerateProjections;
import it.bologna.ausl.model.entities.rubrica.DettaglioContatto;
import java.io.Serializable;
import java.time.ZonedDateTime;
import java.util.List;
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
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.persistence.Version;
import javax.validation.constraints.NotNull;
import org.hibernate.annotations.Parameter;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;
import org.springframework.format.annotation.DateTimeFormat;

/**
 *
 * @author solidus83
 */
@TypeDefs(
        {
            @TypeDef(name = "array", typeClass = GenericArrayUserType.class)
        }
)
@Entity
@Table(name = "utenti_strutture", catalog = "internauta", schema = "baborg")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@GenerateProjections({"idAfferenzaStruttura", "idAfferenzaStruttura, idDettaglioContatto, idStruttura", "idAfferenzaStruttura, idUtente", "idStruttura"})
public class UtenteStruttura implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
//    @OneToMany(mappedBy = "idUtentiStrutture", fetch = FetchType.LAZY, cascade = {CascadeType.MERGE, CascadeType.PERSIST})
//    @JsonBackReference(value = "permessoList")
//    private List<Permesso> permessoList;
    @JoinColumn(name = "id_afferenza_struttura", referencedColumnName = "id")
    @ManyToOne(optional = false, fetch = FetchType.LAZY, cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    private AfferenzaStruttura idAfferenzaStruttura;
    @JoinColumn(name = "id_struttura", referencedColumnName = "id")
    @ManyToOne(optional = false, fetch = FetchType.LAZY, cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    private Struttura idStruttura;
    @JoinColumn(name = "id_utente", referencedColumnName = "id")
    @ManyToOne(optional = false, fetch = FetchType.LAZY, cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    private Utente idUtente;
    @JoinColumn(name = "id_dettaglio_contatto", referencedColumnName = "id")
    @OneToOne(fetch = FetchType.EAGER, cascade = {CascadeType.MERGE, CascadeType.PERSIST}, orphanRemoval = true)
    private DettaglioContatto idDettaglioContatto;

    @Column(name = "attributi", columnDefinition = "text[]")
    @Type(type = "array", parameters = @Parameter(name = "elements-type", value = GenericArrayUserType.TEXT_ELEMENT_TYPE))
    private String[] attributi;

    @Version()
    @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss.SSSSSSXXX'['VV']'")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss.SSSSSSXXX'['VV']'")
    private ZonedDateTime version;

    @Column(name = "attivo_dal")
    @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss.SSSSSSXXX'['VV']'")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss.SSSSSSXXX'['VV']'")
    private ZonedDateTime attivoDal;

    @Column(name = "attivo_al")
    @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss.SSSSSSXXX'['VV']'")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss.SSSSSSXXX'['VV']'")
    private ZonedDateTime attivoAl;

    @Basic(optional = false)
    @NotNull
    @Column(name = "attivo")
    private Boolean attivo;

    @Basic(optional = false)
    @NotNull
    @Column(name = "bit_ruoli")
    private Integer bitRuoli;
    
    @Transient
    private List<Ruolo> ruoliUtenteStruttura;

    public ZonedDateTime getVersion() {
        return version;
    }

    public void setVersion(ZonedDateTime version) {
        this.version = version;
    }

    public UtenteStruttura() {
    }

    public UtenteStruttura(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

//    public List<Permesso> getPermessoList() {
//        return permessoList;
//    }
//
//    public void setPermessoList(List<Permesso> permessoList) {
//        this.permessoList = permessoList;
//    }

    public AfferenzaStruttura getIdAfferenzaStruttura() {
        return idAfferenzaStruttura;
    }

    public void setIdAfferenzaStruttura(AfferenzaStruttura idAfferenzaStruttura) {
        this.idAfferenzaStruttura = idAfferenzaStruttura;
    }

    public Struttura getIdStruttura() {
        return idStruttura;
    }

    public void setIdStruttura(Struttura idStruttura) {
        this.idStruttura = idStruttura;
    }

    public Utente getIdUtente() {
        return idUtente;
    }

    public void setIdUtente(Utente idUtente) {
        this.idUtente = idUtente;
    }

    public DettaglioContatto getIdDettaglioContatto() {
        return idDettaglioContatto;
    }

    public void setIdDettaglioContatto(DettaglioContatto idDettaglioContatto) {
        this.idDettaglioContatto = idDettaglioContatto;
    }

    public String[] getAttributi() {
        return attributi;
    }

    public void setAttributi(String[] attributi) {
        this.attributi = attributi;
    }

    public ZonedDateTime getAttivoDal() {
        return attivoDal;
    }

    public void setAttivoDal(ZonedDateTime attivoDal) {
        this.attivoDal = attivoDal;
    }

    public ZonedDateTime getAttivoAl() {
        return attivoAl;
    }

    public void setAttivoAl(ZonedDateTime attivoAl) {
        this.attivoAl = attivoAl;
    }

    public Boolean getAttivo() {
        return attivo;
    }

    public void setAttivo(Boolean attivo) {
        this.attivo = attivo;
    }

    public Integer getBitRuoli() {
        return bitRuoli;
    }

    public void setBitRuoli(Integer bitRuoli) {
        this.bitRuoli = bitRuoli;
    }

    public List<Ruolo> getRuoliUtenteStruttura() {
        return ruoliUtenteStruttura;
    }

    public void setRuoliUtenteStruttura(List<Ruolo> ruoliUtenteStruttura) {
        this.ruoliUtenteStruttura = ruoliUtenteStruttura;
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
        if (!(object instanceof UtenteStruttura)) {
            return false;
        }
        UtenteStruttura other = (UtenteStruttura) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "it.bologna.ausl.model.entities.baborg.UtenteStruttura[ id=" + id + " ]";
    }

}
