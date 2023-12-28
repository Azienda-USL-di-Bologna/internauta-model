package it.bologna.ausl.model.entities.scripta;

import it.nextsw.common.data.annotations.GenerateProjections;
import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Cacheable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import org.hibernate.annotations.DynamicUpdate;

/**
 *
 * @author Michele D'Onza
 */
@Entity
@Table(name = "sequenze_registri", catalog = "internauta", schema = "scripta")
@Cacheable(false)
@GenerateProjections({})
@DynamicUpdate
public class SequenzaRegistro implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    
    @JoinColumn(name = "id_registro", referencedColumnName = "id")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Registro idRegistro;
    
    @Basic(optional = false)
    @NotNull
    @Column(name = "anno")
    private Integer anno;
    
    @Basic(optional = false)
    @NotNull
    @Column(name = "ultimo_numero_staccato")
    private Integer ultimoNumeroStaccato;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Registro getIdRegistro() {
        return idRegistro;
    }

    public void setIdRegistro(Registro idRegistro) {
        this.idRegistro = idRegistro;
    }

    public Integer getAnno() {
        return anno;
    }

    public void setAnno(Integer anno) {
        this.anno = anno;
    }

    public Integer getUltimoNumeroStaccato() {
        return ultimoNumeroStaccato;
    }

    public void setUltimoNumeroStaccato(Integer ultimoNumeroStaccato) {
        this.ultimoNumeroStaccato = ultimoNumeroStaccato;
    }
    
    
}
