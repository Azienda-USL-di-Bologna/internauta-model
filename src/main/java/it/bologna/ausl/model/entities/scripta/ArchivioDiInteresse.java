package it.bologna.ausl.model.entities.scripta;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.vladmihalcea.hibernate.type.array.IntArrayType;
import it.bologna.ausl.model.entities.baborg.Persona;
import it.nextsw.common.annotations.GenerateProjections;
import java.io.Serializable;
import java.time.ZonedDateTime;
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
import javax.persistence.Table;
import javax.persistence.Version;
import javax.validation.constraints.NotNull;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.Parameter;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.springframework.format.annotation.DateTimeFormat;

/**
 *
 * @author gusgus
 */
@TypeDef(name = "int-array", typeClass = IntArrayType.class)

@Entity
@Table(name = "archivi_di_interesse", catalog = "internauta", schema = "scripta")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Cacheable(false)
@GenerateProjections({})
@DynamicUpdate
public class ArchivioDiInteresse implements Serializable {
    
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    
    @JoinColumn(name = "id_persona", referencedColumnName = "id")
    @ManyToOne(fetch = FetchType.EAGER, cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    @JsonBackReference(value = "idPersona")
    private Persona idPersona;
    
    @Column(name = "id_archivi_preferiti", columnDefinition = "integer[]")
    @Type(type = "int-array")
    private Integer[] idArchiviPreferiti;
    
    @Column(name = "id_archivi_recenti", columnDefinition = "integer[]")
    @Type(type = "int-array")
    private Integer[] idArchiviRecenti;
    
    @Column(name = "id_archivi_frequenti", columnDefinition = "integer[]")
    @Type(type = "int-array")
    private Integer[] idArchiviFrequenti;
       
    @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss.SSSSSSXXX'['VV']'")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss.SSSSSSXXX'['VV']'")
    @Column(name = "data_inserimento_riga")
    @Basic(optional = false)
    @NotNull
    private ZonedDateTime dataInserimentoRiga = ZonedDateTime.now();
    
    @Version()
    @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss.SSSSSSXXX'['VV']'")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss.SSSSSSXXX'['VV']'")
    private ZonedDateTime version;

    public ArchivioDiInteresse() {
    }

    public ArchivioDiInteresse(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Persona getIdPersona() {
        return idPersona;
    }

    public void setIdPersona(Persona idPersona) {
        this.idPersona = idPersona;
    }

    public Integer[] getIdArchiviPreferiti() {
        return idArchiviPreferiti;
    }

    public void setIdArchiviPreferiti(Integer[] idArchiviPreferiti) {
        this.idArchiviPreferiti = idArchiviPreferiti;
    }

    public Integer[] getIdArchiviRecenti() {
        return idArchiviRecenti;
    }

    public void setIdArchiviRecenti(Integer[] idArchiviRecenti) {
        this.idArchiviRecenti = idArchiviRecenti;
    }

    public Integer[] getIdArchiviFrequenti() {
        return idArchiviFrequenti;
    }

    public void setIdArchiviFrequenti(Integer[] idArchiviFrequenti) {
        this.idArchiviFrequenti = idArchiviFrequenti;
    }

    public ZonedDateTime getDataInserimentoRiga() {
        return dataInserimentoRiga;
    }

    public void setDataInserimentoRiga(ZonedDateTime dataInserimentoRiga) {
        this.dataInserimentoRiga = dataInserimentoRiga;
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
        if (!(object instanceof ArchivioDiInteresse)) {
            return false;
        }
        ArchivioDiInteresse other = (ArchivioDiInteresse) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "it.bologna.ausl.model.entities.scripta.ArchivioDiInteresse[ id=" + id + " ]";
    }
    
}
