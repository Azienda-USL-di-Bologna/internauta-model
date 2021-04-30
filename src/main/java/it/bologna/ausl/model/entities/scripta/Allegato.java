package it.bologna.ausl.model.entities.scripta;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import it.bologna.ausl.model.entities.baborg.Struttura;
import it.nextsw.common.annotations.GenerateProjections;
import java.io.Serializable;
import java.time.ZonedDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
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
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.persistence.Version;
import org.hibernate.annotations.DynamicUpdate;
import org.springframework.format.annotation.DateTimeFormat;

/**
 *
 * @author Mido
 */
@Entity
@Table(name = "allegati", catalog = "internauta", schema = "scripta")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Cacheable(false)
@GenerateProjections({"idDoc", "idDoc,idAllegatoPadre","idAllegatoPadre,dettagliAllegatiList"})
@DynamicUpdate
public class Allegato implements Serializable {

    public static enum TipoAllegato {
        ALLEGATO,
        LETTERA,
        FRONTESPIZIO,
        STAMPA_UNICA,
        FASCICOLATO
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;

    @JoinColumn(name = "id_doc", referencedColumnName = "id")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Doc idDoc;

    @JoinColumn(name = "id_allegato_padre", referencedColumnName = "id")
    @ManyToOne(optional = true, fetch = FetchType.LAZY)
    private Allegato idAllegatoPadre;

    @OneToMany(mappedBy = "idAllegatoPadre", fetch = FetchType.LAZY, cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    @JsonBackReference(value = "allegatiFigliList")
    private List<Allegato> allegatiFigliList;

    @OneToMany(mappedBy = "idAllegato", fetch = FetchType.LAZY, cascade = {CascadeType.MERGE, CascadeType.PERSIST,CascadeType.REMOVE})
    @JsonBackReference(value = "dettagliAllegatiList")
    private List<DettaglioAllegato> dettagliAllegatiList;

    @Basic(optional = false)
    @Column(name = "nome")
    private String nome;

    @Basic(optional = false)
    @Column(name = "tipo")
    private String tipo;

    @Basic(optional = false)
    @Column(name = "principale")
    private Boolean principale;

    @Basic(optional = false)
    @Column(name = "ordinale")
    private Integer ordinale;
    
    @Basic(optional = false)
    @Column(name = "firmato")
    private Boolean firmato;
    
    @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss.SSSSSSXXX'['VV']'")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss.SSSSSSXXX'['VV']'")
    private ZonedDateTime dataInserimento = ZonedDateTime.now();

    @Version()
    @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss.SSSSSSXXX'['VV']'")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss.SSSSSSXXX'['VV']'")
    private ZonedDateTime version;

    public Allegato() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Doc getIdDoc() {
        return idDoc;
    }

    public void setIdDoc(Doc idDoc) {
        this.idDoc = idDoc;
    }

    public Allegato getIdAllegatoPadre() {
        return idAllegatoPadre;
    }

    public void setIdAllegatoPadre(Allegato idAllegatoPadre) {
        this.idAllegatoPadre = idAllegatoPadre;
    }

    public List<Allegato> getAllegatiFigliList() {
        return allegatiFigliList;
    }

    public void setAllegatiFigliList(List<Allegato> allegatiFigliList) {
        this.allegatiFigliList = allegatiFigliList;
    }

    public List<DettaglioAllegato> getDettagliAllegatiList() {
        return dettagliAllegatiList;
    }

    public void setDettagliAllegatiList(List<DettaglioAllegato> dettagliAllegatiList) {
        this.dettagliAllegatiList = dettagliAllegatiList;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public TipoAllegato getTipo() {
        if (tipo != null) {
            return TipoAllegato.valueOf(tipo);
        } else {
            return null;
        }
    }

    public void setTipo(TipoAllegato tipo) {
        if (tipo != null) {
            this.tipo = tipo.toString();
        } else {
            this.tipo = null;
        }
    }

    public Boolean getPrincipale() {
        return principale;
    }

    public void setPrincipale(Boolean principale) {
        this.principale = principale;
    }

    public Boolean getFirmato() {
        return firmato;
    }

    public void setFirmato(Boolean firmato) {
        this.firmato = firmato;
    }
    
    public Integer getOrdinale() {
        return ordinale;
    }

    public void setOrdinale(Integer ordinale) {
        this.ordinale = ordinale;
    }

    public ZonedDateTime getDataInserimento() {
        return dataInserimento;
    }

    public void setDataInserimento(ZonedDateTime dataInserimento) {
        this.dataInserimento = dataInserimento;
    }

    public ZonedDateTime getVersion() {
        return version;
    }

    public void setVersion(ZonedDateTime version) {
        this.version = version;
    }

    public DettaglioAllegato getDettaglioByTipoDettaglioAllegato(DettaglioAllegato.TipoDettaglioAllegato tipo) {
//ci possono avere piu di un firmato?
        List<DettaglioAllegato> collect = getDettagliAllegatiList().stream().filter(da -> da.getCaratteristica().equals(tipo)).collect(Collectors.toList());
        if (collect != null && !collect.isEmpty()) {
            return collect.get(0);
        } else {
            return null;
        }

    }

}
