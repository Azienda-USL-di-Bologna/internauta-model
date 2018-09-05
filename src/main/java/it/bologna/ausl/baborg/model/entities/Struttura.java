package it.bologna.ausl.baborg.model.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Set;
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
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import org.springframework.format.annotation.DateTimeFormat;

/**
 *
 * @author solidus83
 */
@Entity
@Table(name = "strutture", catalog = "internauta", schema = "organigramma")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Struttura implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Column(name = "codice")
    private Integer codice;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 400)
    @Column(name = "nome")
    private String nome;
    @Size(max = 10)
    @Column(name = "codice_dislocazione")
    private String codiceDislocazione;
    @Size(max = 100)
    @Column(name = "dislocazione")
    private String dislocazione;
    @Column(name = "data_attivazione")
    @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss")
    private LocalDateTime dataAttivazione;
    @Column(name = "data_cessazione")
    @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss")
    private LocalDateTime dataCessazione;
    @Basic(optional = false)
    @NotNull
    @Column(name = "attiva")
    private Boolean attiva;
    @Basic(optional = false)
    @NotNull
    @Column(name = "spettrale")
    private Boolean spettrale;
    @Basic(optional = false)
    @NotNull
    @Column(name = "usa_segreteria_bucata_padre")
    private Boolean usaSegreteriaBucataPadre;
    @Column(name = "foglia")
    private Boolean foglia;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idStruttura", fetch = FetchType.LAZY)
    @JsonBackReference(value = "pecStrutturaSet")
    private Set<PecStruttura> pecStrutturaSet;
    @JoinColumn(name = "id_azienda", referencedColumnName = "id")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Azienda idAzienda;
    @OneToMany(mappedBy = "idStrutturaPadre", fetch = FetchType.LAZY)
    @JsonBackReference(value = "struttureFiglieSet")
    private Set<Struttura> struttureFiglieSet;
    @JoinColumn(name = "id_struttura_padre", referencedColumnName = "id")
    @ManyToOne(fetch = FetchType.LAZY)
    private Struttura idStrutturaPadre;
    @OneToMany(mappedBy = "idStrutturaSegreteria", fetch = FetchType.LAZY)
    @JsonBackReference(value = "struttureSegretariateSet")
    private Set<Struttura> struttureSegretariateSet;
    @JoinColumn(name = "id_struttura_segreteria", referencedColumnName = "id")
    @ManyToOne(fetch = FetchType.LAZY)
    private Struttura idStrutturaSegreteria;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idStrutturaDestinazione", fetch = FetchType.LAZY)
    @JsonBackReference(value = "strutturaUnificataDestinazioneSet")
    private Set<StrutturaUnificata> strutturaUnificataDestinazioneSet;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idStrutturaSorgente", fetch = FetchType.LAZY)
    @JsonBackReference(value = "strutturaUnificataSorgenteSet")
    private Set<StrutturaUnificata> strutturaUnificataSorgenteSet;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idStruttura", fetch = FetchType.LAZY)
    @JsonBackReference(value = "utenteStrutturaSet")
    private Set<UtenteStruttura> utenteStrutturaSet;

    public Struttura() {
    }

    public Struttura(Integer id) {
        this.id = id;
    }

    public Struttura(Integer id, Integer codice, String nome, String codiceDislocazione, String dislocazione, LocalDateTime dataAttivazione, LocalDateTime dataCessazione, Boolean attiva, Boolean spettrale, Boolean usaSegreteriaBucataPadre, Set<PecStruttura> pecStrutturaSet, Azienda idAzienda, Set<Struttura> struttureFiglieSet, Struttura idStrutturaPadre, Set<Struttura> struttureSegretariateSet, Struttura idStrutturaSegreteria, Set<StrutturaUnificata> strutturaUnificataDestinazioneSet, Set<StrutturaUnificata> strutturaUnificataSorgenteSet, Set<UtenteStruttura> utenteStrutturaSet) {
        this.id = id;
        this.codice = codice;
        this.nome = nome;
        this.codiceDislocazione = codiceDislocazione;
        this.dislocazione = dislocazione;
        this.dataAttivazione = dataAttivazione;
        this.dataCessazione = dataCessazione;
        this.attiva = attiva;
        this.spettrale = spettrale;
        this.usaSegreteriaBucataPadre = usaSegreteriaBucataPadre;
        this.pecStrutturaSet = pecStrutturaSet;
        this.idAzienda = idAzienda;
        this.struttureFiglieSet = struttureFiglieSet;
        this.idStrutturaPadre = idStrutturaPadre;
        this.struttureSegretariateSet = struttureSegretariateSet;
        this.idStrutturaSegreteria = idStrutturaSegreteria;
        this.strutturaUnificataDestinazioneSet = strutturaUnificataDestinazioneSet;
        this.strutturaUnificataSorgenteSet = strutturaUnificataSorgenteSet;
        this.utenteStrutturaSet = utenteStrutturaSet;
    }


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getCodice() {
        return codice;
    }

    public void setCodice(Integer codice) {
        this.codice = codice;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCodiceDislocazione() {
        return codiceDislocazione;
    }

    public void setCodiceDislocazione(String codiceDislocazione) {
        this.codiceDislocazione = codiceDislocazione;
    }

    public String getDislocazione() {
        return dislocazione;
    }

    public void setDislocazione(String dislocazione) {
        this.dislocazione = dislocazione;
    }

    public LocalDateTime getDataAttivazione() {
        return dataAttivazione;
    }

    public void setDataAttivazione(LocalDateTime dataAttivazione) {
        this.dataAttivazione = dataAttivazione;
    }

    public LocalDateTime getDataCessazione() {
        return dataCessazione;
    }

    public void setDataCessazione(LocalDateTime dataCessazione) {
        this.dataCessazione = dataCessazione;
    }

    public Boolean getAttiva() {
        return attiva;
    }

    public void setAttiva(Boolean attiva) {
        this.attiva = attiva;
    }

    public Boolean getSpettrale() {
        return spettrale;
    }

    public void setSpettrale(Boolean spettrale) {
        this.spettrale = spettrale;
    }

    public Boolean getUsaSegreteriaBucataPadre() {
        return usaSegreteriaBucataPadre;
    }

    public void setUsaSegreteriaBucataPadre(Boolean usaSegreteriaBucataPadre) {
        this.usaSegreteriaBucataPadre = usaSegreteriaBucataPadre;
    }
    
    
    public Boolean getFoglia() {
        return foglia;
    }

    public void setFoglia(Boolean foglia) {
        this.foglia = foglia;
    }

    public Set<PecStruttura> getPecStrutturaSet() {
        return pecStrutturaSet;
    }

    public void setPecStrutturaSet(Set<PecStruttura> pecStrutturaSet) {
        this.pecStrutturaSet = pecStrutturaSet;
    }

    public Azienda getIdAzienda() {
        return idAzienda;
    }

    public void setIdAzienda(Azienda idAzienda) {
        this.idAzienda = idAzienda;
    }

    public Set<Struttura> getStruttureFiglieSet() {
        return struttureFiglieSet;
    }

    public void setStruttureFiglieSet(Set<Struttura> struttureFiglieSet) {
        this.struttureFiglieSet = struttureFiglieSet;
    }

    public Struttura getIdStrutturaPadre() {
        return idStrutturaPadre;
    }

    public void setIdStrutturaPadre(Struttura idStrutturaPadre) {
        this.idStrutturaPadre = idStrutturaPadre;
    }

    public Set<Struttura> getStruttureSegretariateSet() {
        return struttureSegretariateSet;
    }

    public void setStruttureSegretariateSet(Set<Struttura> struttureSegretariateSet) {
        this.struttureSegretariateSet = struttureSegretariateSet;
    }

    public Struttura getIdStrutturaSegreteria() {
        return idStrutturaSegreteria;
    }

    public void setIdStrutturaSegreteria(Struttura idStrutturaSegreteria) {
        this.idStrutturaSegreteria = idStrutturaSegreteria;
    }

    public Set<StrutturaUnificata> getStrutturaUnificataDestinazioneSet() {
        return strutturaUnificataDestinazioneSet;
    }

    public void setStrutturaUnificataDestinazioneSet(Set<StrutturaUnificata> strutturaUnificataDestinazioneSet) {
        this.strutturaUnificataDestinazioneSet = strutturaUnificataDestinazioneSet;
    }

    public Set<StrutturaUnificata> getStrutturaUnificataSorgenteSet() {
        return strutturaUnificataSorgenteSet;
    }

    public void setStrutturaUnificataSorgenteSet(Set<StrutturaUnificata> strutturaUnificataSorgenteSet) {
        this.strutturaUnificataSorgenteSet = strutturaUnificataSorgenteSet;
    }

    public Set<UtenteStruttura> getUtenteStrutturaSet() {
        return utenteStrutturaSet;
    }

    public void setUtenteStrutturaSet(Set<UtenteStruttura> utenteStrutturaSet) {
        this.utenteStrutturaSet = utenteStrutturaSet;
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
        if (!(object instanceof Struttura)) {
            return false;
        }
        Struttura other = (Struttura) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "it.bologna.ausl.baborg.model.entities.Struttura[ id=" + id + " ]";
    }
    
}
