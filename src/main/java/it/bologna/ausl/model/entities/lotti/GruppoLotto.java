package it.bologna.ausl.model.entities.lotti;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.io.Serializable;
import java.time.ZonedDateTime;
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
import javax.persistence.Version;
import org.springframework.format.annotation.DateTimeFormat;

/**
 *
 * @author QB
 */
@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Table(name = "gruppi", catalog = "internauta", schema = "lotti")
public class GruppoLotto implements Serializable {
    private static final long serialVersionUID = 1L;
    
    public static enum TipoGruppo {
        PARTECIPANTE,
        AGGIUDICATARIO
    }
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    
    @Column(name = "tipo")
    private String tipo;
    
    @Version()
    @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss.SSSSSSXXX'['VV']'")
    private ZonedDateTime version;
    
    @JoinColumn(name = "id_lotto", referencedColumnName = "id")
    @ManyToOne(fetch = FetchType.LAZY)
    private Lotto idLotto;
    
    @OneToMany(mappedBy = "idGruppo", fetch = FetchType.EAGER, cascade = {CascadeType.REMOVE, CascadeType.PERSIST, CascadeType.MERGE})
    private List<Componente> componentiList;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public TipoGruppo getTipo() {
        if (this.tipo != null) {
            return TipoGruppo.valueOf(this.tipo);
        } else {
            return null;
        }
    }

    public void setTipo(TipoGruppo tipo) {
        if (tipo != null) {
            this.tipo = tipo.toString();
        } else {
            this.tipo = null;
        }
    }

    public ZonedDateTime getVersion() {
        return version;
    }

    public void setVersion(ZonedDateTime version) {
        this.version = version;
    }

    public Lotto getIdLotto() {
        return idLotto;
    }

    public void setIdLotto(Lotto idLotto) {
        this.idLotto = idLotto;
    }

    public List<Componente> getComponentiList() {
        return componentiList;
    }

    @JsonBackReference(value="GruppoLottoPartecipantiList")
    public void setComponentiList(List<Componente> componentiList) {
        this.componentiList = componentiList;
    }
    
    
}
