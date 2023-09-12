package it.bologna.ausl.model.entities.baborg;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import it.nextsw.common.data.annotations.GenerateProjections;
import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Cacheable;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import org.hibernate.annotations.DynamicUpdate;

/**
 *
 * @author mido
 */
@Entity
@Table(name = "profili_predicati_ruoli", catalog = "internauta", schema = "baborg")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Cacheable(false)
@GenerateProjections()
@DynamicUpdate
public class ProfiliPredicatiRuoli implements Serializable {
    
    public static enum TipoSoggetto {
        PERSONA, UTENTE
    }
    public static enum TipoOggetto {
        UTENTI, STRUTTURE, PEC, ARCHIVI, CONTATTI
    }
    public static enum TipoAmbito {
        AVATAR, DELEGATO, MATRINT, BABORG, PECG, RUBRICA, SCRIPTA,
        GEDI, PICO, DETE, DELI
    }
    public static enum TipoPermesso {
        UFFICIO, PEC, ARCHIVIO, CONTATTO, FASCICOLO,
        DELEGA, FLUSSO,
    }
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    

    @JoinColumn(name = "id_profilo", referencedColumnName = "id", insertable = false, updatable = false)
    @ManyToOne(optional = false, fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Profili idProfilo;
    
    @JoinColumn(name = "id_ruolo", referencedColumnName = "id", insertable = false, updatable = false)
    @ManyToOne(optional = true, fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Ruolo idRuolo;
    
    
    //questo lo lascio String perche non esiste l'entita nel model ma solo 
    //in blackbox e blackbox non deve essere una dipendenza di model
    @Basic(optional = true)
    @Column(name = "predicato", columnDefinition = "String")
    private String predicato;
    
    @Basic(optional = false)
    @Enumerated(EnumType.STRING)
    @Column(name = "tipo_soggetto")
    private TipoSoggetto tipoSoggetto;
    
    @Basic(optional = false)
    @Enumerated(EnumType.STRING)
    @Column(name = "tipo_oggetto")
    private TipoOggetto tipoOggetto;
    
    @Basic(optional = false)
    @Enumerated(EnumType.STRING)
    @Column(name = "ambito_permesso")
    private TipoAmbito tipoAmbito;
    
    @Basic(optional = false)
    @Enumerated(EnumType.STRING)
    @Column(name = "tipo_permesso")
    private TipoPermesso tipoPermesso;
    
    public ProfiliPredicatiRuoli() {
    }
    
    
    public ProfiliPredicatiRuoli(Integer id, Profili idProfilo, Ruolo idRuolo, String predicato, TipoSoggetto tipoSoggetto, TipoOggetto tipoOggetto, TipoAmbito tipoAmbito, TipoPermesso tipoPermesso) {
        this.id = id;
        this.idProfilo = idProfilo;
        this.idRuolo = idRuolo;
        this.predicato = predicato;
        this.tipoSoggetto = tipoSoggetto;
        this.tipoOggetto = tipoOggetto;
        this.tipoAmbito = tipoAmbito;
        this.tipoPermesso = tipoPermesso;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Profili getIdProfilo() {
        return idProfilo;
    }

    public void setIdProfilo(Profili idProfilo) {
        this.idProfilo = idProfilo;
    }   

    public String getPredicato() {
        return predicato;
    }

    public void setPredicato(String predicato) {
        this.predicato = predicato;
    }

    public Ruolo getIdRuolo() {
        return idRuolo;
    }

    public void setIdRuolo(Ruolo idRuolo) {
        this.idRuolo = idRuolo;
    }

    public TipoSoggetto getTipoSoggetto() {
        return tipoSoggetto;
    }

    public void setTipoSoggetto(TipoSoggetto tipoSoggetto) {
        this.tipoSoggetto = tipoSoggetto;
    }

    public TipoOggetto getTipoOggetto() {
        return tipoOggetto;
    }

    public void setTipoOggetto(TipoOggetto tipoOggetto) {
        this.tipoOggetto = tipoOggetto;
    }

    public TipoAmbito getTipoAmbito() {
        return tipoAmbito;
    }

    public void setTipoAmbito(TipoAmbito tipoAmbito) {
        this.tipoAmbito = tipoAmbito;
    }

    public TipoPermesso getTipoPermesso() {
        return tipoPermesso;
    }

    public void setTipoPermesso(TipoPermesso tipoPermesso) {
        this.tipoPermesso = tipoPermesso;
    }
    
}

