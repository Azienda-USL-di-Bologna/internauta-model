package it.bologna.ausl.model.entities.rubrica;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
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
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
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
@Table(name = "contatti", catalog = "internauta", schema = "rubrica")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Cacheable(false)
public class Contatto implements Serializable {

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
    private int idUtenteCreazione;
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_persona_creazione")
    private int idPersonaCreazione;
    @Column(name = "id_aziende")
    private Serializable idAziende;
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
    private boolean daVerificare;
    @Basic(optional = false)
    @NotNull
    @Column(name = "modificabile")
    private boolean modificabile;
    @Basic(optional = false)
    @NotNull
    @Column(name = "eliminato")
    private boolean eliminato;
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
    @OneToMany(mappedBy = "idContattoPadre", fetch = FetchType.LAZY)
    private List<Contatto> contattiList;
    @JoinColumn(name = "id_contatto_padre", referencedColumnName = "id")
    @ManyToOne(fetch = FetchType.LAZY)
    private Contatto idContattoPadre;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idContatto", fetch = FetchType.LAZY)
    private List<GruppiContatti> gruppiContattiList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idGruppo", fetch = FetchType.LAZY)
    private List<GruppiContatti> gruppiContattiList1;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idContatto", fetch = FetchType.LAZY)
    private List<Telefono> telefonoList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idContatto", fetch = FetchType.LAZY)
    private List<Email> emailList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idContatto", fetch = FetchType.LAZY)
    private List<Indirizzo> indirizziList;

    public Contatto() {
    }

    public Contatto(Integer id) {
        this.id = id;
    }

    public Contatto(Integer id, String descrizione, String tipo, String categoria, int idUtenteCreazione, int idPersonaCreazione, String provenienza, boolean daVerificare, boolean modificabile, boolean eliminato) {
        this.id = id;
        this.descrizione = descrizione;
        this.tipo = tipo;
        this.categoria = categoria;
        this.idUtenteCreazione = idUtenteCreazione;
        this.idPersonaCreazione = idPersonaCreazione;
        this.provenienza = provenienza;
        this.daVerificare = daVerificare;
        this.modificabile = modificabile;
        this.eliminato = eliminato;
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

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public int getIdUtenteCreazione() {
        return idUtenteCreazione;
    }

    public void setIdUtenteCreazione(int idUtenteCreazione) {
        this.idUtenteCreazione = idUtenteCreazione;
    }

    public int getIdPersonaCreazione() {
        return idPersonaCreazione;
    }

    public void setIdPersonaCreazione(int idPersonaCreazione) {
        this.idPersonaCreazione = idPersonaCreazione;
    }

    public Serializable getIdAziende() {
        return idAziende;
    }

    public void setIdAziende(Serializable idAziende) {
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

    public boolean getDaVerificare() {
        return daVerificare;
    }

    public void setDaVerificare(boolean daVerificare) {
        this.daVerificare = daVerificare;
    }

    public boolean getModificabile() {
        return modificabile;
    }

    public void setModificabile(boolean modificabile) {
        this.modificabile = modificabile;
    }

    public boolean getEliminato() {
        return eliminato;
    }

    public void setEliminato(boolean eliminato) {
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

    public List<Contatto> getContattiList() {
        return contattiList;
    }

    public void setContattiList(List<Contatto> contattiList) {
        this.contattiList = contattiList;
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
