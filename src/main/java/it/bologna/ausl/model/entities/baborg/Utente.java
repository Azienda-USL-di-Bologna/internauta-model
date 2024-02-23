package it.bologna.ausl.model.entities.baborg;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.querydsl.core.annotations.PropertyType;
import com.querydsl.core.annotations.QueryType;
import com.vladmihalcea.hibernate.type.array.StringArrayType;
import it.bologna.ausl.internauta.model.bds.types.PermessoEntitaStoredProcedure;
import it.bologna.ausl.model.entities.EntityInterface;
import it.nextsw.common.data.annotations.GenerateProjections;
import it.bologna.ausl.model.entities.ribaltoneutils.RibaltoneDaLanciare;
import it.bologna.ausl.model.entities.ribaltoneutils.StoricoAttivazione;
import it.bologna.ausl.model.entities.rubrica.Contatto;
import java.io.Serializable;
import java.time.ZonedDateTime;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Map;
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
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.persistence.Version;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

/**
 *
 * @author solidus83
 */
@TypeDef(name = "string-array", typeClass = StringArrayType.class)

@Entity
@Table(name = "utenti", catalog = "internauta", schema = "baborg")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler", "authorities"})
@Cacheable(false)
@GenerateProjections({"idAzienda, idPersona", "idAzienda, idPersona, utenteStrutturaList", "idPersona", "idAzienda"})
@DynamicUpdate
public class Utente implements Serializable, UserDetails, EntityInterface {

    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 250)
    @Column(name = "username")
    private String username;
    
    // @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="Invalid email")//if the field contains email address consider using this annotation to enforce field validation
    @Size(max = 400)
    @Column(name = "email")
    private String email;
    
    @Size(max = 5)
    @Column(name = "id_inquadramento")
    private String idInquadramento;
    
    @Size(max = 150)
    @Column(name = "telefono")
    private String telefono;
    
    // @Pattern(regexp="^\\(?(\\d{3})\\)?[- ]?(\\d{3})[- ]?(\\d{4})$", message="Invalid phone/fax format, should be as xxx-xxx-xxxx")//if the field contains phone or fax number consider using this annotation to enforce field validation
    @Size(max = 150)
    @Column(name = "fax")
    private String fax;
    
    @Basic(optional = false)
    @NotNull
    @Column(name = "omonimia")
    private Boolean omonimia = false;
    
    @Size(max = 200)
    @JsonIgnore
    @Column(name = "password_hash")
    private String passwordHash;
    
    @Column(name = "dominio")
    private Integer dominio;
    
    @Basic(optional = false)
    @NotNull
    @Column(name = "attivo")
    private Boolean attivo;
    
    @Basic(optional = false)
    @NotNull
    @Column(name = "bit_ruoli")
    private Integer bitRuoli = 1;
    
    @JoinColumn(name = "id_azienda", referencedColumnName = "id")
    @ManyToOne(fetch = FetchType.EAGER, cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    private Azienda idAzienda;
    
    @JoinColumn(name = "id_persona", referencedColumnName = "id")
    @ManyToOne(fetch = FetchType.EAGER, cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    private Persona idPersona;
    
    @OneToMany(mappedBy = "idUtente", fetch = FetchType.LAZY, cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    @JsonBackReference(value = "pecUtenteList")
    private List<PecUtente> pecUtenteList;
    
    @OneToMany(mappedBy = "idUtente", fetch = FetchType.LAZY, cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    @JsonBackReference(value = "utenteStrutturaList")
    private List<UtenteStruttura> utenteStrutturaList;

    @OneToMany(mappedBy = "idUtente", fetch = FetchType.LAZY)
    @JsonBackReference(value = "storicoAttivazioneList")
    private List<StoricoAttivazione> storicoAttivazioneList;

    @OneToMany(mappedBy = "idUtente", fetch = FetchType.LAZY)
    @JsonBackReference(value = "ribaltoneDaLanciareList")
    private List<RibaltoneDaLanciare> ribaltoneDaLanciareList;

    @OneToMany(mappedBy = "idUtenteCreazione", fetch = FetchType.LAZY, cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    @JsonBackReference(value = "contattiCreati")
    private List<Contatto> contattiCreati;

    @OneToMany(mappedBy = "idUtente", fetch = FetchType.LAZY)
    @JsonBackReference(value = "importazioniOrganigrammaList")
    private List<ImportazioniOrganigramma> importazioniOrganigrammaList;
    
    @Column(name = "data_spegnimento")
    @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss.SSSSSSXXX'['VV']'")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss.SSSSSSXXX'['VV']'")
    private ZonedDateTime dataSpegnimento;
    
    @Version()
    @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss.SSSSSSXXX'['VV']'")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss.SSSSSSXXX'['VV']'")
    private ZonedDateTime version;

    @Column(name = "emails", columnDefinition = "text[]")
    @Type(type = "string-array")
    private String[] emails;

    public String[] getEmails() {
        return emails;
    }

    public void setEmails(String[] emails) {
        this.emails = emails;
    }

    public ZonedDateTime getVersion() {
        return version;
    }

    public void setVersion(ZonedDateTime version) {
        this.version = version;
    }

    @Transient
    private Map<String, List<Ruolo>> mappaRuoli;

    /**
     * tutti i ruoli di tutte le aziende della persona dell'utente, divisi per
     * interaziendali e aziendali. mappa in cui la chiave è il codiceAzienda e
     * il valore la lista dei codici ruolo per quell'azienda nel caso dei ruoli
     * interaziendali la chiave è 'interaziendali'
     */
    @Transient
    private Map<String, Map<String, List<String>>> ruoliUtentiPersona;

    @Transient
    private Map<String, List<PermessoEntitaStoredProcedure>> permessiDiFlussoByCodiceAzienda;
    
    @Transient
    private Integer[] struttureDelSegretario;

    @Transient
    private Utente utenteReale;

    @Transient
    @QueryType(PropertyType.SIMPLE)
    private List<PermessoEntitaStoredProcedure> permessiDiFlusso;

    @Transient
    private List<PermessoEntitaStoredProcedure> permessiDiFlussoByIdUtente;

    public Utente() {
    }

    public Utente(Integer id) {
        this.id = id;
    }

    public Utente(Integer id, String username, String email, String idInquadramento, String telefono, String fax, Boolean omonimia, String passwordHash, Integer dominio, Boolean attivo, Integer bitRuoli, Azienda idAzienda, Persona idPersona, List<PecUtente> pecUtenteList, List<UtenteStruttura> utenteStrutturaList) {
        this.id = id;
        this.username = username;
        this.email = email;
        this.idInquadramento = idInquadramento;
        this.telefono = telefono;
        this.fax = fax;
        this.omonimia = omonimia;
        this.passwordHash = passwordHash;
        this.dominio = dominio;
        this.attivo = attivo;
        this.bitRuoli = bitRuoli;
        this.idAzienda = idAzienda;
        this.idPersona = idPersona;
        this.pecUtenteList = pecUtenteList;
        this.utenteStrutturaList = utenteStrutturaList;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Override
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getIdInquadramento() {
        return idInquadramento;
    }

    public void setIdInquadramento(String idInquadramento) {
        this.idInquadramento = idInquadramento;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getFax() {
        return fax;
    }

    public void setFax(String fax) {
        this.fax = fax;
    }

    public Boolean getOmonimia() {
        return omonimia;
    }

    public void setOmonimia(Boolean omonimia) {
        this.omonimia = omonimia;
    }

    public String getPasswordHash() {
        return passwordHash;
    }

    public void setPasswordHash(String passwordHash) {
        this.passwordHash = passwordHash;
    }

    public Integer getDominio() {
        return dominio;
    }

    public void setDominio(Integer dominio) {
        this.dominio = dominio;
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

    public Azienda getIdAzienda() {
        return idAzienda;
    }

    public void setIdAzienda(Azienda idAzienda) {
        this.idAzienda = idAzienda;
    }

    public Persona getIdPersona() {
        return idPersona;
    }

    public void setIdPersona(Persona idPersona) {
        this.idPersona = idPersona;
    }

    public List<PecUtente> getPecUtenteList() {
        return pecUtenteList;
    }

    public void setPecUtenteList(List<PecUtente> pecUtenteList) {
        this.pecUtenteList = pecUtenteList;
    }

    public List<UtenteStruttura> getUtenteStrutturaList() {
        return utenteStrutturaList;
    }

    public void setUtenteStrutturaList(List<UtenteStruttura> utenteStrutturaList) {
        this.utenteStrutturaList = utenteStrutturaList;
    }

    public Map<String, List<Ruolo>> getMappaRuoli() {
        return this.mappaRuoli;
    }

    public void setMappaRuoli(Map<String, List<Ruolo>> ruoli) {
        this.mappaRuoli = ruoli;
    }

    public Map<String, Map<String, List<String>>> getRuoliUtentiPersona() {
        return ruoliUtentiPersona;
    }

    public void setRuoliUtentiPersona(Map<String, Map<String, List<String>>> ruoliUtentiPersona) {
        this.ruoliUtentiPersona = ruoliUtentiPersona;
    }

    public Utente getUtenteReale() {
        return utenteReale;
    }

    public void setUtenteReale(Utente utenteReale) {
        this.utenteReale = utenteReale;
    }

    public List<PermessoEntitaStoredProcedure> getPermessiDiFlusso() {
        return permessiDiFlusso;
    }

    public void setPermessiDiFlusso(List<PermessoEntitaStoredProcedure> permessiDiFlusso) {
        this.permessiDiFlusso = permessiDiFlusso;
    }

    public Map<String, List<PermessoEntitaStoredProcedure>> getPermessiDiFlussoByCodiceAzienda() {
        return permessiDiFlussoByCodiceAzienda;
    }

    public void setPermessiDiFlussoByCodiceAzienda(Map<String, List<PermessoEntitaStoredProcedure>> permessiDiFlussoByCodiceAzienda) {
        this.permessiDiFlussoByCodiceAzienda = permessiDiFlussoByCodiceAzienda;
    }

    public Integer[] getStruttureDelSegretario() {
        return struttureDelSegretario;
    }

    public void setStruttureDelSegretario(Integer[] struttureDelSegretario) {
        this.struttureDelSegretario = struttureDelSegretario;
    }

    public List<PermessoEntitaStoredProcedure> getPermessiDiFlussoByIdUtente() {
        return permessiDiFlussoByIdUtente;
    }

    public void setPermessiDiFlussoByIdUtente(List<PermessoEntitaStoredProcedure> permessiDiFlussoByIdUtente) {
        this.permessiDiFlussoByIdUtente = permessiDiFlussoByIdUtente;
    }

    public List<StoricoAttivazione> getStoricoAttivazioneList() {
        return storicoAttivazioneList;
    }

    public void setStoricoAttivazioneList(List<StoricoAttivazione> storicoAttivazioneList) {
        this.storicoAttivazioneList = storicoAttivazioneList;
    }

    public List<RibaltoneDaLanciare> getRibaltoneDaLanciareList() {
        return ribaltoneDaLanciareList;
    }

    public void setRibaltoneDaLanciareList(List<RibaltoneDaLanciare> ribaltoneDaLanciareList) {
        this.ribaltoneDaLanciareList = ribaltoneDaLanciareList;
    }

    public List<Contatto> getContattiCreati() {
        return contattiCreati;
    }

    public void setContattiCreati(List<Contatto> contattiCreati) {
        this.contattiCreati = contattiCreati;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return Arrays.asList(new SimpleGrantedAuthority("gdm"));
    }

    @Override
    @JsonIgnore
    public String getPassword() {
        return passwordHash;
    }

    @Override
    @JsonIgnore
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    @JsonIgnore
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    @JsonIgnore
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    @JsonIgnore
    public boolean isEnabled() {
        return true;
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
        if (!(object instanceof Utente)) {
            return false;
        }
        Utente other = (Utente) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String getEntityDescription() {
        return getIdPersona().getEntityDescription();
    }

    @Override
    public String getEntityAdditionalData(String param) {
       return null;
    }
    
    @Override
    public String toString() {
        return getClass().getCanonicalName() + "[ id=" + id + " ]";
    }

    public ZonedDateTime getDataSpegnimento() {
        return dataSpegnimento;
    }

    public void setDataSpegnimento(ZonedDateTime dataSpegnimento) {
        this.dataSpegnimento = dataSpegnimento;
    }
}
