package it.bologna.ausl.model.entities.scripta;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import it.bologna.ausl.model.entities.baborg.Azienda;
import it.bologna.ausl.model.entities.baborg.Persona;
import it.nextsw.common.annotations.GenerateProjections;
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
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.persistence.Version;
import javax.validation.constraints.NotNull;
import org.hibernate.annotations.Filter;
import org.hibernate.annotations.FilterDef;
import org.hibernate.annotations.FilterJoinTable;
import org.hibernate.annotations.Formula;
import org.hibernate.annotations.Where;
import org.springframework.format.annotation.DateTimeFormat;

/**
 *
 * @author solidus83
 */
//@TypeDefs(
//        {
//            @TypeDef(name = "array", typeClass = GenericArrayUserType.class)
//        }
//)
@Entity
@Table(name = "docs", catalog = "internauta", schema = "scripta")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Cacheable(false)
//@GenerateProjections({"idPersonaCreazione,idAzienda", "idPersonaCreazione,idAzienda,mittenti,destinatari"})
@GenerateProjections({"idPersonaCreazione,idAzienda", "idPersonaCreazione,idAzienda,mittenti,competenti,coinvolti,related", "idPersonaCreazione,idAzienda,mittenti,competenti,coinvolti,related,allegati"})

public class Doc implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;

    @Basic(optional = true)
    @Column(name = "oggetto")
    private String oggetto;

    @JoinColumn(name = "id_persona_creazione", referencedColumnName = "id")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Persona idPersonaCreazione;

    @JoinColumn(name = "id_azienda", referencedColumnName = "id")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Azienda idAzienda;

    @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss.SSSSSSXXX'['VV']'")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss.SSSSSSXXX'['VV']'")
    @Column(name = "data_creazione")
    @Basic(optional = false)
    @NotNull
    private ZonedDateTime dataCreazione;

    //lista di mittenti che conterra per il momento solo un elemento
//    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idDoc", fetch = FetchType.LAZY)
//    @JsonBackReference(value = "mittenti")
    //@Filter(name = "mittenti")
    @Transient
//    @Where(clause = "tipo='MITTENTE'")
    private List<Related> mittenti;

//    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idDoc", fetch = FetchType.LAZY)
//    @JsonBackReference(value = "destinatari")
    //@Filter(name = "destinatari")
//    @Where(clause = "tipo='A'")
//    @Transient
//    private List<Related> destinatari;
    @Transient
    private List<Related> competenti;

    @Transient
    private List<Related> coinvolti;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idDoc", fetch = FetchType.LAZY)
    @JsonBackReference(value = "related")
    private List<Related> related;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idDoc", fetch = FetchType.LAZY)
    @JsonBackReference(value = "allagato")
    private List<Allegato> allegati;

    @Version()
    @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss.SSSSSSXXX'['VV']'")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss.SSSSSSXXX'['VV']'")
    private ZonedDateTime version;

    public Doc() {
    }

    public Doc(Integer id, String oggetto, Persona idPersonaCreazione, Azienda idAzienda, ZonedDateTime dataCreazione) {
        this.id = id;
        this.oggetto = oggetto;
        this.idPersonaCreazione = idPersonaCreazione;
        this.idAzienda = idAzienda;
        this.dataCreazione = dataCreazione;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getOggetto() {
        return oggetto;
    }

    public void setOggetto(String oggetto) {
        this.oggetto = oggetto;
    }

    public Persona getIdPersonaCreazione() {
        return idPersonaCreazione;
    }

    public void setIdPersonaCreazione(Persona idPersonaCreazione) {
        this.idPersonaCreazione = idPersonaCreazione;
    }

    public Azienda getIdAzienda() {
        return idAzienda;
    }

    public void setIdAzienda(Azienda idAzienda) {
        this.idAzienda = idAzienda;
    }

    public ZonedDateTime getDataCreazione() {
        return dataCreazione;
    }

    public void setDataCreazione(ZonedDateTime dataCreazione) {
        this.dataCreazione = dataCreazione;
    }

    public List<Related> getMittenti() {
        return mittenti;
    }

    public void setMittenti(List<Related> mittenti) {
        this.mittenti = mittenti;
    }

    public List<Related> getCompetenti() {
        return competenti;
    }

    public void setCompetenti(List<Related> competenti) {
        this.competenti = competenti;
    }

    public List<Related> getCoinvolti() {
        return coinvolti;
    }

    public void setCoinvolti(List<Related> coinvolti) {
        this.coinvolti = coinvolti;
    }

    public List<Related> getRelated() {
        return related;
    }

    public void setRelated(List<Related> related) {
        this.related = related;
    }

    public List<Allegato> getAllegati() {
        return allegati;
    }

    public void setAllegati(List<Allegato> allegati) {
        this.allegati = allegati;
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
        hash += (id != null ? id.hashCode() : super.hashCode());
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Doc)) {
            return false;
        }
        Doc other = (Doc) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return getClass().getCanonicalName() + "[ id=" + id + " ]";
    }

}
