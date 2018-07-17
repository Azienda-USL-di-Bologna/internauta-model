package it.bologna.ausl.baborg.model.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import java.io.Serializable;
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
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import org.hibernate.annotations.Proxy;

/**
 *
 * @author solidus83
 */
@Entity
@Table(name = "aziende", catalog = "internauta", schema = "organigramma")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Cacheable(false)
public class Azienda implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "codice")
    private String codice;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 250)
    @Column(name = "nome")
    private String nome;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 1000)
    @Column(name = "descrizione")
    private String descrizione;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "aoo")
    private String aoo;
    @Size(max = 20)
    @Column(name = "schema_gru")
    private String schemaGru;
    @Column(name = "id_azienda_gru")
    private Integer idAziendaGru;

    @Column(name = "parametri")
    private String parametri;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "codice_regione")
    private String codiceRegione;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ribalta_internauta")
    private Boolean ribaltaInternauta;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ribalta_argo")
    private Boolean ribaltaArgo;
    @Basic(optional = true)
    @Column(name = "path")
    private String path;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idAzienda", fetch = FetchType.LAZY)
    @JsonBackReference(value = "idpEntityIdSet")
    private Set<IdpEntityId> idpEntityIdSet;
    @OneToMany(mappedBy = "idAzienda", fetch = FetchType.LAZY)
    @JsonBackReference(value = "utenteSet")
    private Set<Utente> utenteSet;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idAzienda", fetch = FetchType.LAZY)
    @JsonBackReference(value = "strutturaSet")
    private Set<Struttura> strutturaSet;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idAzienda", fetch = FetchType.LAZY)
    @JsonBackReference(value = "pecSet")
    private Set<Pec> pecSet;

    public Azienda() {
    }

    public Azienda(Integer id) {
        this.id = id;
    }

    public Azienda(Integer id, String codice, String nome, String descrizione, String aoo, String codiceRegione, boolean ribaltaInternauta, boolean ribaltaArgo) {
        this.id = id;
        this.codice = codice;
        this.nome = nome;
        this.descrizione = descrizione;
        this.aoo = aoo;
        this.codiceRegione = codiceRegione;
        this.ribaltaInternauta = ribaltaInternauta;
        this.ribaltaArgo = ribaltaArgo;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCodice() {
        return codice;
    }

    public void setCodice(String codice) {
        this.codice = codice;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescrizione() {
        return descrizione;
    }

    public void setDescrizione(String descrizione) {
        this.descrizione = descrizione;
    }

    public String getAoo() {
        return aoo;
    }

    public void setAoo(String aoo) {
        this.aoo = aoo;
    }

    public String getSchemaGru() {
        return schemaGru;
    }

    public void setSchemaGru(String schemaGru) {
        this.schemaGru = schemaGru;
    }

    public Integer getIdAziendaGru() {
        return idAziendaGru;
    }

    public void setIdAziendaGru(Integer idAziendaGru) {
        this.idAziendaGru = idAziendaGru;
    }

    public String getParametri() {
        return parametri;
    }

    public void setParametri(String parametri) {
        this.parametri = parametri;
    }

    public String getCodiceRegione() {
        return codiceRegione;
    }

    public void setCodiceRegione(String codiceRegione) {
        this.codiceRegione = codiceRegione;
    }

    public Boolean getRibaltaInternauta() {
        return ribaltaInternauta;
    }

    public void setRibaltaInternauta(Boolean ribaltaInternauta) {
        this.ribaltaInternauta = ribaltaInternauta;
    }

    public Boolean getRibaltaArgo() {
        return ribaltaArgo;
    }

    public void setRibaltaArgo(Boolean ribaltaArgo) {
        this.ribaltaArgo = ribaltaArgo;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public Set<IdpEntityId> getIdpEntityIdSet() {
        return idpEntityIdSet;
    }

    public void setIdpEntityIdSet(Set<IdpEntityId> idpEntityIdSet) {
        this.idpEntityIdSet = idpEntityIdSet;
    }

    public Set<Utente> getUtenteSet() {
        return utenteSet;
    }

    public void setUtenteSet(Set<Utente> utenteSet) {
        this.utenteSet = utenteSet;
    }

    public Set<Struttura> getStrutturaSet() {
        return strutturaSet;
    }

    public void setStrutturaSet(Set<Struttura> strutturaSet) {
        this.strutturaSet = strutturaSet;
    }

    public Set<Pec> getPecSet() {
        return pecSet;
    }

    public void setPecSet(Set<Pec> pecSet) {
        this.pecSet = pecSet;
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
        if (!(object instanceof Azienda)) {
            return false;
        }
        Azienda other = (Azienda) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "it.bologna.ausl.baborg.model.entities.Azienda[ id=" + id + " ]";
    }
    
}
