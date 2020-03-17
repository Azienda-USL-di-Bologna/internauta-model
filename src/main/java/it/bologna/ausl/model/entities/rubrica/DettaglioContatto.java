package it.bologna.ausl.model.entities.rubrica;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import it.nextsw.common.annotations.NextSdrAncestor;
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
import org.springframework.format.annotation.DateTimeFormat;

/**
 *
 * @author gusgus
 */
@Entity
@Table(name = "dettagli_contatti", catalog = "internauta", schema = "rubrica")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Cacheable(false)
public class DettaglioContatto implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Size(max = 2147483647)
    @Column(name = "descrizione")
    private String descrizione;
    
    @NextSdrAncestor(relationName = "idContattoDettaglioContatto")
    @JoinColumn(name = "id_contatto", referencedColumnName = "id")
    @ManyToOne(fetch = FetchType.EAGER, cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    private Contatto idContatto;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idDettaglioContatto", fetch = FetchType.LAZY)
    @JsonBackReference(value = "gruppiDelContattoList")
    private List<GruppiContatti> gruppiDelDettaglioList;
    
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "idDettaglioContatto", fetch = FetchType.LAZY, orphanRemoval=true)
    @JsonBackReference(value = "telefono")
    private Telefono telefono;
    
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "idDettaglioContatto", fetch = FetchType.LAZY, orphanRemoval=true)
    @JsonBackReference(value = "email")
    private Email email;
    
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "idDettaglioContatto", fetch = FetchType.LAZY, orphanRemoval=true)
    @JsonBackReference(value = "indirizzo")
    private Indirizzo indirizzo;
    
    @Basic(optional = false)
    @NotNull
    @Column(name = "principale")
    private Boolean principale;
    @Version()
    @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss.SSSSSSXXX'['VV']'")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss.SSSSSSXXX'['VV']'")
    private ZonedDateTime version;
    
    public DettaglioContatto() {
    }

    public DettaglioContatto(Integer id) {
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

    public Contatto getIdContatto() {
        return idContatto;
    }

    public void setIdContatto(Contatto idContatto) {
        this.idContatto = idContatto;
    }

    public List<GruppiContatti> getGruppiDelDettaglioList() {
        return gruppiDelDettaglioList;
    }

    public void setGruppiDelDettaglioList(List<GruppiContatti> gruppiDelDettaglioList) {
        this.gruppiDelDettaglioList = gruppiDelDettaglioList;
    }

    public Telefono getTelefono() {
        return telefono;
    }

    public void setTelefono(Telefono telefono) {
        this.telefono = telefono;
    }

    public Email getEmail() {
        return email;
    }

//    public Email getEmail() {
//        return email;
//    }
//
//    public void setEmail(Email email) {
//        this.email = email;
//    }
    public void setEmail(Email email) {
        this.email = email;
    }

    public Indirizzo getIndirizzo() {
        return indirizzo;
    }

    public void setIndirizzo(Indirizzo indirizzo) {
        this.indirizzo = indirizzo;
    }

    public Boolean getPrincipale() {
        return principale;
    }

    public void setPrincipale(Boolean principale) {
        this.principale = principale;
    }

    public ZonedDateTime getVersion() {
        return version;
    }

    public void setVersion(ZonedDateTime version) {
        this.version = version;
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
        if (!(object instanceof DettaglioContatto)) {
            return false;
        }
        DettaglioContatto other = (DettaglioContatto) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "it.bologna.ausl.model.entities.rubrica.DettagliContatti[ id=" + id + " ]";
    }
    
}