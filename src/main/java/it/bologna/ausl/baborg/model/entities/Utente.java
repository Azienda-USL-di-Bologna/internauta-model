/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.bologna.ausl.baborg.model.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.io.Serializable;
import java.util.Arrays;
import java.util.Collection;
import java.util.Set;
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
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

/**
 *
 * @author solidus83
 */
@Entity
@Table(name = "utenti", catalog = "internauta", schema = "organigramma")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler", "authorities"})
@Cacheable(false)
public class Utente implements Serializable, UserDetails {

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
    @Size(max = 100)
    @Column(name = "matricola")
    private String matricola;
    @Size(max = 100)
    @Column(name = "nome")
    private String nome;
    @Size(max = 100)
    @Column(name = "cognome")
    private String cognome;
    @Size(max = 16)
    @Column(name = "codice_fiscale")
    private String codiceFiscale;
    @Size(max = 200)
    @Column(name = "descrizione")
    private String descrizione;
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
    private Boolean omonimia;
    @Size(max = 200)
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
    private Integer bitRuoli;
    @Column(name = "id_ruolo_aziendale")
    private Integer idRuoloAziendale;
    @JoinColumn(name = "id_azienda", referencedColumnName = "id")
    @ManyToOne(fetch = FetchType.LAZY)
    private Azienda idAzienda;
    @JoinColumn(name = "id_persona", referencedColumnName = "id")
    @ManyToOne(fetch = FetchType.LAZY)
    private Persona idPersona;
    @OneToMany(mappedBy = "idUtente", fetch = FetchType.LAZY)
    @JsonBackReference(value = "pecUtenteSet")
    private Set<PecUtente> pecUtenteSet;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idUtente", fetch = FetchType.LAZY)
    @JsonBackReference(value = "utenteStrutturaSet")
    private Set<UtenteStruttura> utenteStrutturaSet;

    public Utente() {
    }

    public Utente(Integer id) {
        this.id = id;
    }

    public Utente(Integer id, String username, String matricola, String nome, String cognome, String codiceFiscale, String descrizione, String email, String idInquadramento, String telefono, String fax, Boolean omonimia, String passwordHash, Integer dominio, Boolean attivo, Integer bitRuoli, Integer idRuoloAziendale, Azienda idAzienda, Persona idPersona, Set<PecUtente> pecUtenteSet, Set<UtenteStruttura> utenteStrutturaSet) {
        this.id = id;
        this.username = username;
        this.matricola = matricola;
        this.nome = nome;
        this.cognome = cognome;
        this.codiceFiscale = codiceFiscale;
        this.descrizione = descrizione;
        this.email = email;
        this.idInquadramento = idInquadramento;
        this.telefono = telefono;
        this.fax = fax;
        this.omonimia = omonimia;
        this.passwordHash = passwordHash;
        this.dominio = dominio;
        this.attivo = attivo;
        this.bitRuoli = bitRuoli;
        this.idRuoloAziendale = idRuoloAziendale;
        this.idAzienda = idAzienda;
        this.idPersona = idPersona;
        this.pecUtenteSet = pecUtenteSet;
        this.utenteStrutturaSet = utenteStrutturaSet;
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

    public String getMatricola() {
        return matricola;
    }

    public void setMatricola(String matricola) {
        this.matricola = matricola;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCognome() {
        return cognome;
    }

    public void setCognome(String cognome) {
        this.cognome = cognome;
    }

    public String getCodiceFiscale() {
        return codiceFiscale;
    }

    public void setCodiceFiscale(String codiceFiscale) {
        this.codiceFiscale = codiceFiscale;
    }

    public String getDescrizione() {
        return descrizione;
    }

    public void setDescrizione(String descrizione) {
        this.descrizione = descrizione;
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

    public boolean getOmonimia() {
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

    public boolean getAttivo() {
        return attivo;
    }

    public void setAttivo(Boolean attivo) {
        this.attivo = attivo;
    }

    public int getBitRuoli() {
        return bitRuoli;
    }

    public void setBitRuoli(Integer bitRuoli) {
        this.bitRuoli = bitRuoli;
    }

    public Integer getIdRuoloAziendale() {
        return idRuoloAziendale;
    }

    public void setIdRuoloAziendale(Integer idRuoloAziendale) {
        this.idRuoloAziendale = idRuoloAziendale;
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

    public Set<PecUtente> getPecUtenteSet() {
        return pecUtenteSet;
    }

    public void setPecUtenteSet(Set<PecUtente> pecUtenteSet) {
        this.pecUtenteSet = pecUtenteSet;
    }

    public Set<UtenteStruttura> getUtenteStrutturaSet() {
        return utenteStrutturaSet;
    }

    public void setUtenteStrutturaSet(Set<UtenteStruttura> utenteStrutturaSet) {
        this.utenteStrutturaSet = utenteStrutturaSet;
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
        hash += (id != null ? id.hashCode() : 0);
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
    public String toString() {
        return "it.bologna.ausl.baborg.model.entities.Utente[ id=" + id + " ]";
    }
    
}
