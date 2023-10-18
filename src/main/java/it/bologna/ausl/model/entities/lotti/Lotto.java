package it.bologna.ausl.model.entities.lotti;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.io.Serializable;
import java.time.LocalDate;
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
import javax.validation.constraints.Size;
import org.springframework.format.annotation.DateTimeFormat;

/**
 *
 * @author QB
 */
@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Table(name = "lotti", catalog = "internauta", schema = "lotti")
public class Lotto implements Serializable {
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    
    @Column(name = "cig")
    private String cig;
    
    @Column(name = "lotto")
    private String lotto;
    
    @JoinColumn(name = "id_tipologia", referencedColumnName = "id")
    @ManyToOne(fetch = FetchType.EAGER)
    private Tipologia idTipologia;
    
    @Size(max = 250)
    @Column(name = "oggetto")
    private String oggetto;
    
    @JoinColumn(name = "id_contraente", referencedColumnName = "id")
    @ManyToOne(fetch = FetchType.EAGER)
    private Contraente idContraente;
    
    @Column(name = "importo_totale")
    private Float importoTotale;
    
    @Column(name = "importo_liquidato")
    private Float importoLiquidato;
    
    @DateTimeFormat(pattern = "dd/MM/yyyy")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    @Column(name = "data_inizio")
    private LocalDate dataInizio;
    
    @DateTimeFormat(pattern = "dd/MM/yyyy")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    @Column(name = "data_completamento")
    private LocalDate dataCompletamento;
    
    @OneToMany(mappedBy = "idLotto", fetch = FetchType.EAGER, cascade = {CascadeType.REMOVE, CascadeType.PERSIST, CascadeType.MERGE})
    private List<GruppoLotto> gruppiList;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCig() {
        return cig;
    }

    public void setCig(String cig) {
        this.cig = cig;
    }

    public String getLotto() {
        return lotto;
    }

    public void setLotto(String lotto) {
        this.lotto = lotto;
    }

    public Tipologia getIdTipologia() {
        return idTipologia;
    }

    public void setIdTipologia(Tipologia idTipologia) {
        this.idTipologia = idTipologia;
    }

    public String getOggetto() {
        return oggetto;
    }

    public void setOggetto(String oggetto) {
        this.oggetto = oggetto;
    }

    public Contraente getIdContraente() {
        return idContraente;
    }

    public void setIdContraente(Contraente idContraente) {
        this.idContraente = idContraente;
    }

    public Float getImportoTotale() {
        return importoTotale;
    }

    public void setImportoTotale(Float importoTotale) {
        this.importoTotale = importoTotale;
    }

    public Float getImportoLiquidato() {
        return importoLiquidato;
    }

    public void setImportoLiquidato(Float importoLiquidato) {
        this.importoLiquidato = importoLiquidato;
    }

    public LocalDate getDataInizio() {
        return dataInizio;
    }

    public void setDataInizio(LocalDate dataInizio) {
        this.dataInizio = dataInizio;
    }

    public LocalDate getDataCompletamento() {
        return dataCompletamento;
    }

    public void setDataCompletamento(LocalDate dataCompletamento) {
        this.dataCompletamento = dataCompletamento;
    }

    public List<GruppoLotto> getGruppiList() {
        return gruppiList;
    }

    @JsonBackReference(value="LottoGruppiList")
    public void setGruppiList(List<GruppoLotto> gruppiList) {
        this.gruppiList = gruppiList;
    }
}
