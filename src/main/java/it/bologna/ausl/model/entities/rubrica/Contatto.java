package it.bologna.ausl.model.entities.rubrica;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import it.bologna.ausl.internauta.utils.jpa.tools.GenericArrayUserType;
import it.nextsw.common.annotations.GenerateProjections;
import it.bologna.ausl.model.entities.baborg.Persona;
import it.bologna.ausl.model.entities.baborg.Struttura;
import it.bologna.ausl.model.entities.baborg.Utente;
import java.io.Serializable;
import java.time.ZonedDateTime;
import java.util.List;
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
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.persistence.Version;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.Formula;
import org.hibernate.annotations.Parameter;
import org.hibernate.annotations.Type;
import org.springframework.format.annotation.DateTimeFormat;

/**
 *
 * @author gusgus
 */
@Entity
@Table(name = "contatti", catalog = "internauta", schema = "rubrica")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Cacheable(false)
@GenerateProjections({
    "contattiDelGruppoList, emailList, gruppiDelContattoList, idContattoPadre, idPersona, idPersonaCreazione, idStruttura, idUtenteCreazione, indirizziList, telefonoList",
    "contattiDelGruppoList, emailList, idPersonaCreazione, indirizziList, telefonoList", //forse si può togliere
    "contattiDelGruppoList, idPersonaCreazione, idUtenteCreazione",
    "contattiDelGruppoList, dettaglioContattoList, idPersonaCreazione",
    "dettaglioContattoList",
    "dettaglioContattoList, emailList, gruppiDelContattoList, idPersona, idPersonaCreazione, idUtenteCreazione",
    "dettaglioContattoList, idPersonaCreazione, idStruttura",
    "dettaglioContattoList, idPersonaCreazione",
    "emailList",
    "emailList, gruppiDelContattoList, idPersonaCreazione, idUtenteCreazione, indirizziList, telefonoList",
    "emailList, idPersona, idPersonaCreazione, indirizziList, telefonoList",
    "emailList, idPersonaCreazione, indirizziList, telefonoList",
    "gruppiDelContattoList, idPersonaCreazione, idStruttura, idUtenteCreazione",
    "idPersona, idPersonaCreazione, idStruttura"})
@JsonIdentityInfo(generator = ObjectIdGenerators.IntSequenceGenerator.class, property = "@id", scope = Contatto.class)
@DynamicUpdate
public class Contatto implements Serializable, ContattoInterface {

    public static enum CategoriaContatto {
        PERSONA,
        STRUTTURA,
        ESTERNO,
        GRUPPO
    }

    public static enum TipoContatto {
        ORGANIGRAMMA,
        PERSONA_FISICA,
        AZIENDA,
        PUBBLICA_AMMINISTRAZIONE_ITALIANA,
        PUBBLICA_AMMINISTRAZIONE_ESTERA,
        VARIO,
        FORNITORE
    }

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2147483647)
    @Column(name = "descrizione")
    private String descrizione;
    // @JsonView(RubricaJsonViews.ContattoForSimilarity.class)
    @Size(max = 2147483647)
    @Column(name = "cognome")
    private String cognome;
    @Size(max = 2147483647)
    @Column(name = "nome")
    private String nome;
    @Size(max = 2147483647)
    @Column(name = "codice_fiscale")
    private String codiceFiscale;
    @Size(max = 2147483647)
    @Column(name = "ragione_sociale")
    private String ragioneSociale;
    @Size(max = 2147483647)
    @Column(name = "partita_iva")
    private String partitaIva;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2147483647)
    @Column(name = "tipo")
    private String tipo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2147483647)
    @Column(name = "categoria")
    private String categoria;
    @JoinColumn(name = "id_utente_creazione", referencedColumnName = "id")
    @ManyToOne(fetch = FetchType.LAZY, cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    @JsonBackReference(value = "idUtenteCreazione")
    private Utente idUtenteCreazione;
    @JoinColumn(name = "id_persona_creazione", referencedColumnName = "id")
    @ManyToOne(fetch = FetchType.LAZY, cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    @JsonBackReference(value = "idPersonaCreazione")
    private Persona idPersonaCreazione;
    @Column(name = "id_aziende", columnDefinition = "integer[]")
    @Type(type = "array", parameters = @Parameter(name = "elements-type", value = GenericArrayUserType.INTEGER_ELEMENT_TYPE))
    private Integer[] idAziende;
    @Size(max = 2147483647)
    @Column(name = "id_esterno")
    private String idEsterno;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2147483647)
    @Column(name = "provenienza")
    private String provenienza;
    @Basic(optional = false)
    @NotNull
    @Column(name = "da_verificare")
    private Boolean daVerificare = false;
    @Column(name = "protocontatto")
    private Boolean protocontatto = false;
    @Basic(optional = false)
    @NotNull
    @Column(name = "modificabile")
    private Boolean modificabile;
    @Basic(optional = false)
    @NotNull
    @Column(name = "eliminato")
    private Boolean eliminato;
    @Column(name = "riservato")
    private Boolean riservato;
    @Size(max = 2147483647)
    @Column(name = "contatto_errato")
    private String contattoErrato;
    @Size(max = 2147483647)
    @Column(name = "tscol", columnDefinition = "tsvector")
    private String tscol;
    @Size(max = 2147483647)
    @Column(name = "titolo")
    private String titolo;

    @Version()
    @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss.SSSSSSXXX'['VV']'")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss.SSSSSSXXX'['VV']'")
    private ZonedDateTime version;
    
    @OneToMany(mappedBy = "idContattoPadre", fetch = FetchType.LAZY, cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    @JsonBackReference(value = "contattiFigliList")
    private List<Contatto> contattiFigliList;
    
    @JoinColumn(name = "id_contatto_padre", referencedColumnName = "id")
    @ManyToOne(fetch = FetchType.LAZY, cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    @JsonBackReference(value = "idContattoPadre")
    private Contatto idContattoPadre;

    // E' la lista dei gruppi su cui il contatto è presente.
    // In questo caso il contatto non può essere di categoria GRUPPO
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idContatto", fetch = FetchType.LAZY)
    @JsonBackReference(value = "gruppiDelContattoList")
    private List<GruppiContatti> gruppiDelContattoList;

    // E' la lista dei contatti attaccati al gruppo.
    // In questo caso il contatto è di categoria GRUPPO
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idGruppo", fetch = FetchType.LAZY, orphanRemoval = true)
//    @JsonBackReference(value = "contattiDelGruppoList")
    private List<GruppiContatti> contattiDelGruppoList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idContatto", fetch = FetchType.LAZY, orphanRemoval = true)
//    @JsonBackReference(value = "telefonoList")
    private List<Telefono> telefonoList;
    //@JsonView(RubricaJsonViews.ContattoForSimilarity.class)
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idContatto", fetch = FetchType.LAZY, orphanRemoval = true)
    //@JsonBackReference(value = "emailList")
    private List<Email> emailList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idContatto", fetch = FetchType.LAZY, orphanRemoval = true)
//    @JsonBackReference(value = "indirizziList")
    private List<Indirizzo> indirizziList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idContatto", fetch = FetchType.LAZY, orphanRemoval = true)
    @JsonBackReference(value = "dettaglioContattoList")
    private List<DettaglioContatto> dettaglioContattoList;
    @OneToOne(mappedBy = "idContatto", fetch = FetchType.LAZY, cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    @JsonBackReference(value = "idStruttura")
    private Struttura idStruttura;
    @OneToOne(mappedBy = "idContatto", fetch = FetchType.LAZY, cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    @JsonBackReference(value = "idPersona")
    private Persona idPersona;
    
    @Transient
    private List<Contatto> contattiContenuti;
    
    @Formula("(select ts_rank(tscol, to_tsquery('italian',$${tscol.PLACEHOLDER_TS_RANK}$$), 8 | 1))")
    private Double ranking;
    
    public Double getRanking() {
        return ranking;
    }

    public void setRanking(Double ranking) {
        this.ranking = ranking;
    }

    public List<Contatto> getContattiContenuti() {
        return contattiContenuti;
    }

    public void setContattiContenuti(List<Contatto> contattiContenuti) {
        this.contattiContenuti = contattiContenuti;
    }

    public Contatto() {
    }

    public Contatto(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDescrizione() {
        return descrizione;
    }

    public void setDescrizione(String descrizione) {
        this.descrizione = descrizione;
    }

    public String getCognome() {
        return cognome;
    }

    public void setCognome(String cognome) {
        this.cognome = cognome;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCodiceFiscale() {
        return codiceFiscale;
    }

    public void setCodiceFiscale(String codiceFiscale) {
        this.codiceFiscale = codiceFiscale;
    }

    public String getRagioneSociale() {
        return ragioneSociale;
    }

    public void setRagioneSociale(String ragioneSociale) {
        this.ragioneSociale = ragioneSociale;
    }

    public String getPartitaIva() {
        return partitaIva;
    }

    public void setPartitaIva(String partitaIva) {
        this.partitaIva = partitaIva;
    }

    public TipoContatto getTipo() {
        if (tipo != null) {
            return TipoContatto.valueOf(tipo);
        } else {
            return null;
        }
    }

    public void setTipo(TipoContatto tipo) {
        if (tipo != null) {
            this.tipo = tipo.toString();
        } else {
            this.tipo = null;
        }
    }

    public CategoriaContatto getCategoria() {
        if (categoria != null) {
            return CategoriaContatto.valueOf(categoria);
        } else {
            return null;
        }
    }

    public void setCategoria(CategoriaContatto categoria) {
        if (categoria != null) {
            this.categoria = categoria.toString();
        } else {
            this.categoria = null;
        }
    }

    public Utente getIdUtenteCreazione() {
        return idUtenteCreazione;
    }

    public void setIdUtenteCreazione(Utente idUtenteCreazione) {
        this.idUtenteCreazione = idUtenteCreazione;
    }

    public Persona getIdPersonaCreazione() {
        return idPersonaCreazione;
    }

    public void setIdPersonaCreazione(Persona idPersonaCreazione) {
        this.idPersonaCreazione = idPersonaCreazione;
    }

    public Integer[] getIdAziende() {
        return idAziende;
    }

    public void setIdAziende(Integer[] idAziende) {
        this.idAziende = idAziende;
    }

    public String getIdEsterno() {
        return idEsterno;
    }

    public void setIdEsterno(String idEsterno) {
        this.idEsterno = idEsterno;
    }

    public String getProvenienza() {
        return provenienza;
    }

    public void setProvenienza(String provenienza) {
        this.provenienza = provenienza;
    }

    public Boolean getDaVerificare() {
        return daVerificare;
    }

    public void setDaVerificare(Boolean daVerificare) {
        this.daVerificare = daVerificare;
    }

    public Boolean getProtocontatto() {
        return protocontatto;
    }

    public void setProtocontatto(Boolean protocontatto) {
        this.protocontatto = protocontatto;
    }

    public Boolean getModificabile() {
        return modificabile;
    }

    public void setModificabile(Boolean modificabile) {
        this.modificabile = modificabile;
    }

    public Boolean getRiservato() {
        return riservato;
    }

    public void setRiservato(Boolean riservato) {
        this.riservato = riservato;
    }

    public Boolean getEliminato() {
        return eliminato;
    }

    public void setEliminato(Boolean eliminato) {
        this.eliminato = eliminato;
    }

    public String getContattoErrato() {
        return contattoErrato;
    }

    public void setContattoErrato(String contattoErrato) {
        this.contattoErrato = contattoErrato;
    }

    public String getTscol() {
        return tscol;
    }

    public void setTscol(String tscol) {
        this.tscol = tscol;
    }

    public ZonedDateTime getVersion() {
        return version;
    }

    public void setVersion(ZonedDateTime version) {
        this.version = version;
    }

    public List<Contatto> getContattiFigliList() {
        return contattiFigliList;
    }

    public void setContattiFigliList(List<Contatto> contattiList) {
        this.contattiFigliList = contattiList;
    }

    public Contatto getIdContattoPadre() {
        return idContattoPadre;
    }

    public void setIdContattoPadre(Contatto idContattoPadre) {
        this.idContattoPadre = idContattoPadre;
    }

    public List<GruppiContatti> getContattiDelGruppoList() {
        return contattiDelGruppoList;
    }

    public void setContattiDelGruppoList(List<GruppiContatti> gruppiContattiList1) {
        this.contattiDelGruppoList = gruppiContattiList1;
    }

    public List<Telefono> getTelefonoList() {
        return telefonoList;
    }

    public void setTelefonoList(List<Telefono> telefonoList) {
        this.telefonoList = telefonoList;
    }

    public List<Email> getEmailList() {
        return emailList;
    }

    public void setEmailList(List<Email> emailList) {
        this.emailList = emailList;
    }

    public List<Indirizzo> getIndirizziList() {
        return indirizziList;
    }

    public void setIndirizziList(List<Indirizzo> indirizziList) {
        this.indirizziList = indirizziList;
    }

    public Struttura getIdStruttura() {
        return idStruttura;
    }

    public void setIdStruttura(Struttura idStruttura) {
        this.idStruttura = idStruttura;
    }

    public Persona getIdPersona() {
        return idPersona;
    }

    public void setIdPersona(Persona idPersona) {
        this.idPersona = idPersona;
    }

    public List<DettaglioContatto> getDettaglioContattoList() {
        return dettaglioContattoList;
    }

    public void setDettaglioContattoList(List<DettaglioContatto> dettaglioContattoList) {
        this.dettaglioContattoList = dettaglioContattoList;
    }

    public List<GruppiContatti> getGruppiDelContattoList() {
        return gruppiDelContattoList;
    }

    public void setGruppiDelContattoList(List<GruppiContatti> gruppiDelContattoList) {
        this.gruppiDelContattoList = gruppiDelContattoList;
    }
    
    
    public String getTitolo() {
        return titolo;
    }

    public void setTitolo(String titolo) {
        this.titolo = titolo;
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
        if (!(object instanceof Contatto)) {
            return false;
        }
        Contatto other = (Contatto) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "it.bologna.ausl.model.entities.rubrica.Contatti[ id=" + id + " ]";
    }

}
