package it.bologna.ausl.model.entities.lotti;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.io.Serializable;
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
import javax.persistence.Table;

/**
 *
 * @author QB
 */
@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Table(name = "componenti", catalog = "internauta", schema = "lotti")
public class Componente implements Serializable {
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    
    @Column(name = "codice_fiscale")
    private String codiceFiscale;

    @Column(name = "ragione_sociale")
    private String ragioneSociale;
    
    @JoinColumn(name = "id_ruolo", referencedColumnName = "id")
    @ManyToOne(fetch = FetchType.EAGER, cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    private RuoloComponente idRuolo;
    
    @JoinColumn(name = "id_gruppo", referencedColumnName = "id")
    @ManyToOne(fetch = FetchType.LAZY, cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    private GruppoLotto idGruppo;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCodiceFiscale() {
        return codiceFiscale;
    }

    public void setCodiceFiscale(String codiceFiscale) {
        this.codiceFiscale = codiceFiscale;
    }

    public String getRagioneSociale() {
        return ragioneSociale;
    }

    public void setRagioneSociale(String ragioneSociale) {
        this.ragioneSociale = ragioneSociale;
    }

    public RuoloComponente getIdRuolo() {
        return idRuolo;
    }

    public void setIdRuolo(RuoloComponente idRuolo) {
        this.idRuolo = idRuolo;
    }

    public GruppoLotto getIdGruppo() {
        return idGruppo;
    }

    public void setIdGruppo(GruppoLotto idGruppo) {
        this.idGruppo = idGruppo;
    }
    
    
}
