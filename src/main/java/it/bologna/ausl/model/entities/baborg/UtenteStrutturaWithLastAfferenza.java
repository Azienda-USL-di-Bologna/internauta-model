/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package it.bologna.ausl.model.entities.baborg;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.vladmihalcea.hibernate.type.array.StringArrayType;
import it.bologna.ausl.model.entities.rubrica.DettaglioContatto;
import it.nextsw.common.data.annotations.GenerateProjections;
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
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.springframework.format.annotation.DateTimeFormat;

/**
 *
 * @author Michele D'Onza
 */
@TypeDef(name = "string-array", typeClass = StringArrayType.class)

@Entity
@Table(name = "utenti_strutture_with_ultima_afferenza", catalog = "internauta", schema = "baborg")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@GenerateProjections({
    "idAfferenzaStruttura, idStruttura",
    "idAfferenzaStruttura",
    "idAfferenzaStruttura, idDettaglioContatto, idStruttura",
    "idAfferenzaStruttura, idUtente",
    "idStruttura",
    "idAfferenzaStruttura, idUtente, idStruttura, idStrutturaVeicolante",})
@DynamicUpdate
public class UtenteStrutturaWithLastAfferenza implements Serializable {

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
    @OneToOne(fetch = FetchType.LAZY, cascade = {CascadeType.MERGE, CascadeType.PERSIST}, orphanRemoval = true)
    private DettaglioContatto idDettaglioContatto;

    @Column(name = "attributi", columnDefinition = "text[]")
    @Type(type = "string-array")
    private String[] attributi;

    @Version()
    @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss.SSSSSSXXX'['VV']'")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss.SSSSSSXXX'['VV']'")
    private ZonedDateTime version;

    @Column(name = "attivo_dal")
    @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss.SSSSSSXXX'['VV']'")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss.SSSSSSXXX'['VV']'")
    private ZonedDateTime attivoDal = ZonedDateTime.now();

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

    @JoinColumn(name = "id_struttura_veicolante", referencedColumnName = "id")
    @ManyToOne(optional = true, fetch = FetchType.LAZY, cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    private Struttura idStrutturaVeicolante;

    @Transient
    private List<Ruolo> ruoliUtenteStruttura;

    public UtenteStrutturaWithLastAfferenza(Integer id) {
        this.id = id;
    }

    public UtenteStrutturaWithLastAfferenza() {
    }
    
    public ZonedDateTime getVersion() {
        return version;
    }

    public void setVersion(ZonedDateTime version) {
        this.version = version;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

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

    public Struttura getIdStrutturaVeicolante() {
        return idStrutturaVeicolante;
    }

    public void setIdStrutturaVeicolante(Struttura idStrutturaVeicolante) {
        this.idStrutturaVeicolante = idStrutturaVeicolante;
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
        if (!(object instanceof UtenteStrutturaWithLastAfferenza)) {
            return false;
        }
        UtenteStrutturaWithLastAfferenza other = (UtenteStrutturaWithLastAfferenza) object;
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