package it.bologna.ausl.model.entities.scripta;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import it.bologna.ausl.model.entities.baborg.Azienda;
import it.nextsw.common.annotations.GenerateProjections;
import java.io.Serializable;
import java.time.ZonedDateTime;
import java.util.ArrayList;
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
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Version;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import org.hibernate.annotations.DynamicUpdate;
import org.springframework.format.annotation.DateTimeFormat;

/**
 *
 * @author spritz
 */
@Entity
@Table(name = "massimario", catalog = "internauta", schema = "scripta")
@JsonIgnoreProperties(value = {"hibernateLazyInitializer", "handler"}, ignoreUnknown = true)
@GenerateProjections({"titoli"})
@DynamicUpdate
public class Massimario implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2147483647)
    @Column(name = "nome")
    private String nome;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2147483647)
    @Column(name = "descrizione_tenuta")
    private String descrizioneTenuta;
    @Column(name = "anni_tenuta")
    private Integer anniTenuta;
    
    @Version()
    @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss.SSSSSSXXX'['VV']'")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss.SSSSSSXXX'['VV']'")
    private ZonedDateTime version;
    
    @JoinColumn(name = "id_azienda", referencedColumnName = "id")
    @ManyToOne(fetch = FetchType.LAZY, cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    private Azienda idAzienda;

    @ManyToMany(cascade = {
        CascadeType.ALL
    }, fetch = FetchType.LAZY, targetEntity = Titolo.class)
    @JoinTable(name = "massimario_titoli", schema = "scripta", catalog = "internauta",
            joinColumns = @JoinColumn(name = "id_massimario"),
            inverseJoinColumns = @JoinColumn(name = "id_titolo"))
    @JsonBackReference("titoli")
    private List<Titolo> titoli = new ArrayList<>();

    public Massimario() {
    }

    public Massimario(Integer id) {
        this.id = id;
    }

    public Massimario(Integer id, String nome, String descrizioneTenuta) {
        this.id = id;
        this.nome = nome;
        this.descrizioneTenuta = descrizioneTenuta;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescrizioneTenuta() {
        return descrizioneTenuta;
    }

    public void setDescrizioneTenuta(String descrizioneTenuta) {
        this.descrizioneTenuta = descrizioneTenuta;
    }

    public Integer getAnniTenuta() {
        return anniTenuta;
    }

    public void setAnniTenuta(Integer anniTenuta) {
        this.anniTenuta = anniTenuta;
    }

    public ZonedDateTime getVersion() {
        return version;
    }

    public void setVersion(ZonedDateTime version) {
        this.version = version;
    }

    public List<Titolo> getTitoli() {
        return titoli;
    }

    public void setTitoli(List<Titolo> titoli) {
        this.titoli = titoli;
    }

    public Azienda getIdAzienda() {
        return idAzienda;
    }

    public void setIdAzienda(Azienda idAzienda) {
        this.idAzienda = idAzienda;
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
        if (!(object instanceof Massimario)) {
            return false;
        }
        Massimario other = (Massimario) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "it.bologna.ausl.model.entities.scripta.Massimario[ id=" + id + " ]";
    }

}
