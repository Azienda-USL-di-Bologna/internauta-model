package it.bologna.ausl.model.entities.rubrica;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import it.bologna.ausl.internauta.utils.jpa.tools.GenericArrayUserType;
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
import javax.persistence.Version;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
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
public class Contatto implements Serializable {

    public static enum CategoriaContatto {
        Persona,
        Struttura,
        Esterno,
        Gruppo
    }

    public static enum TipoContatto {
        Organigramma,
        Persona_Fisica,
        Azienda,
        Pubblica_Amministrazione,
        Vario
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
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_utente_creazione")
    private Utente idUtenteCreazione;
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_persona_creazione")
    private Persona idPersonaCreazione;
    @NotNull
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
    private Boolean daVerificare;
    @Basic(optional = false)
    @NotNull
    @Column(name = "modificabile")
    private Boolean modificabile;
    @Basic(optional = false)
    @NotNull
    @Column(name = "eliminato")
    private Boolean eliminato;
    @Size(max = 2147483647)
    @Column(name = "contatto_errato")
    private String contattoErrato;
    @Size(max = 2147483647)
    @Column(name = "tscol", columnDefinition = "tsvector")
    private String tscol;
    @Version()
    @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss.SSSXXX'['VV']'")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss.SSSXXX'['VV']'")
    private ZonedDateTime version;
    @OneToMany(mappedBy = "idContattoPadre", fetch = FetchType.LAZY, cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    @JsonBackReference(value = "contattiFigliList")
    private List<Contatto> contattiFigliList;
    @JoinColumn(name = "id_contatto_padre", referencedColumnName = "id")
    @ManyToOne(fetch = FetchType.LAZY, cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    @JsonBackReference(value = "idContattoPadre")
    private Contatto idContattoPadre;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idContatto", fetch = FetchType.LAZY)
    @JsonBackReference(value = "gruppiContattiList")
    private List<GruppiContatti> gruppiContattiList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idGruppo", fetch = FetchType.LAZY)
    @JsonBackReference(value = "gruppiContattiList1")
    private List<GruppiContatti> gruppiContattiList1;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idContatto", fetch = FetchType.LAZY)
    @JsonBackReference(value = "telefonoList")
    private List<Telefono> telefonoList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idContatto", fetch = FetchType.LAZY)
    @JsonBackReference(value = "emailList")
    private List<Email> emailList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idContatto", fetch = FetchType.LAZY)
    @JsonBackReference(value = "indirizziList")
    private List<Indirizzo> indirizziList;

    @OneToOne(mappedBy = "idContatto", fetch = FetchType.LAZY, cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    @JsonBackReference(value = "idStruttura")
    private Struttura idStruttura;

    @OneToOne(mappedBy = "idContatto", fetch = FetchType.LAZY, cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    @JsonBackReference(value = "idPersona")
    private Persona idPersona;

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
        return TipoContatto.valueOf(tipo);
    }

    public void setTipo(TipoContatto tipo) {
        this.tipo = tipo.toString();
    }

    public CategoriaContatto getCategoria() {
        return CategoriaContatto.valueOf(categoria);
    }

    public void setCategoria(CategoriaContatto categoria) {
        this.categoria = categoria.toString();
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

    public Boolean getModificabile() {
        return modificabile;
    }

    public void setModificabile(Boolean modificabile) {
        this.modificabile = modificabile;
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

    public List<Contatto> getContattiFilgiList() {
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

    public List<GruppiContatti> getGruppiContattiList() {
        return gruppiContattiList;
    }

    public void setGruppiContattiList(List<GruppiContatti> gruppiContattiList) {
        this.gruppiContattiList = gruppiContattiList;
    }

    public List<GruppiContatti> getGruppiContattiList1() {
        return gruppiContattiList1;
    }

    public void setGruppiContattiList1(List<GruppiContatti> gruppiContattiList1) {
        this.gruppiContattiList1 = gruppiContattiList1;
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
