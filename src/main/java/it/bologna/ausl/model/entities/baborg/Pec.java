package it.bologna.ausl.model.entities.baborg;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.io.Serializable;
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
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author solidus83
 */
@Entity
@Table(name = "pec", catalog = "internauta", schema = "organigramma")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Pec implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Column(name = "indirizzo", columnDefinition = "text")
    private String indirizzo;
    @Basic(optional = false)
    @NotNull
    @Column(name = "username", columnDefinition = "text")
    private String username;
    @Basic(optional = false)
    @NotNull
    @Column(name = "password", columnDefinition = "text")
    private String password;
    @Basic(optional = false)
    @NotNull
    @Column(name = "attiva")
    private Boolean attiva;
    @Basic(optional = false)
    @NotNull
    @Column(name = "message_policy")
    private Integer messagePolicy;
    @Basic(optional = false)
    @NotNull
    @Column(name = "per_riservato")
    private Boolean perRiservato;
    @Column(name = "descrizione", columnDefinition = "text")
    private String descrizione;
    @OneToMany(cascade = {CascadeType.MERGE, CascadeType.PERSIST}, mappedBy = "idPec", fetch = FetchType.LAZY)
    @JsonBackReference(value = "pecStrutturaList")
    private List<PecStruttura> pecStrutturaList;
    @JoinColumn(name = "id_azienda", referencedColumnName = "id")
    @ManyToOne(optional = false, fetch = FetchType.LAZY, cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    private Azienda idAzienda;
    @JoinColumn(name = "id_pec_provider", referencedColumnName = "id")
    @ManyToOne(optional = false, fetch = FetchType.LAZY, cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    private PecProvider idPecProvider;
    @OneToMany(mappedBy = "idPec", fetch = FetchType.LAZY, cascade = {CascadeType.MERGE, CascadeType.PERSIST}, orphanRemoval = true)
    @JsonBackReference(value = "pecUtenteList")
    private List<PecUtente> pecUtenteList;

    public Pec() {
    }

    public Pec(Integer id) {
        this.id = id;
    }

    public Pec(Integer id, String indirizzo, String username, String password, boolean attiva, int messagePolicy, boolean perRiservato) {
        this.id = id;
        this.indirizzo = indirizzo;
        this.username = username;
        this.password = password;
        this.attiva = attiva;
        this.messagePolicy = messagePolicy;
        this.perRiservato = perRiservato;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getIndirizzo() {
        return indirizzo;
    }

    public void setIndirizzo(String indirizzo) {
        this.indirizzo = indirizzo;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Boolean getAttiva() {
        return attiva;
    }

    public void setAttiva(Boolean attiva) {
        this.attiva = attiva;
    }

    public Integer getMessagePolicy() {
        return messagePolicy;
    }

    public void setMessagePolicy(Integer messagePolicy) {
        this.messagePolicy = messagePolicy;
    }

    public Boolean getPerRiservato() {
        return perRiservato;
    }

    public void setPerRiservato(Boolean perRiservato) {
        this.perRiservato = perRiservato;
    }

    public String getDescrizione() {
        return descrizione;
    }

    public void setDescrizione(String descrizione) {
        this.descrizione = descrizione;
    }

    public List<PecStruttura> getPecStrutturaList() {
        return pecStrutturaList;
    }

    public void setPecStrutturaList(List<PecStruttura> pecStrutturaList) {
        this.pecStrutturaList = pecStrutturaList;
    }

    public Azienda getIdAzienda() {
        return idAzienda;
    }

    public void setIdAzienda(Azienda idAzienda) {
        this.idAzienda = idAzienda;
    }

    public PecProvider getIdPecProvider() {
        return idPecProvider;
    }

    public void setIdPecProvider(PecProvider idPecProvider) {
        this.idPecProvider = idPecProvider;
    }

    public List<PecUtente> getPecUtenteList() {
        return pecUtenteList;
    }

    public void setPecUtenteList(List<PecUtente> pecUtenteList) {
        this.pecUtenteList = pecUtenteList;
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
        if (!(object instanceof Pec)) {
            return false;
        }
        Pec other = (Pec) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "it.bologna.ausl.baborg.model.entities.Pec[ id=" + id + " ]";
    }

}
