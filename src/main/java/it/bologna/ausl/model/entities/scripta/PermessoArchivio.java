package it.bologna.ausl.model.entities.scripta;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.vladmihalcea.hibernate.type.array.IntArrayType;
import it.bologna.ausl.model.entities.baborg.Azienda;
import it.bologna.ausl.model.entities.baborg.Persona;
import it.nextsw.common.data.annotations.GenerateProjections;
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
@Table(name = "permessi_archivi", catalog = "internauta", schema = "scripta")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Cacheable(false)
@GenerateProjections({})
@DynamicUpdate
public class PermessoArchivio implements Serializable {
    /**
     * Bit
     * Binary  -DEC- PREDICATO
     * 0000001 - 1 - PASSAGGIO
     * 0000010 - 2 - VISUALIZZA
     * 0000100 - 4 - MODIFICA
     * 0001000 - 8 - ELIMINA
     * 0010000 - 16 - VICARIO
     * 0100000 - 32 - REPONSABILE_PROPOSTO
     * 1000000 - 64 - RESPONSABILE
     */
    
    public static enum TipoSoggetto {
        PERSONA, STRUTTURA
    }
    
     public enum DecimalePredicato {
    
        PASSAGGIO(1),
        VISUALIZZA(2), 
        MODIFICA(4), 
        ELIMINA(8),      
        VICARIO(16), 
        RESPONSABILE_PROPOSTO(32), 
        RESPONSABILE(64);

        private Integer typeOfBit;

        DecimalePredicato(Integer typeOfBit) {
            this.typeOfBit = typeOfBit;
        }
        
        public Integer getValue(){
            return typeOfBit;
        }

    }

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Long id;
    
    @Column(name = "bit")
    private Integer bit;
    
    
    @Column(name = "id_permessi_sorgente", columnDefinition = "integer[]")
    @Type(type = "int-array")
    private Integer[] idPermessiSorgente;
    
    @JoinColumn(name = "id_persona", referencedColumnName = "id")
    @ManyToOne(fetch = FetchType.LAZY, cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    //@JsonBackReference(value = "idPersona")
    private Persona idPersona;
    
    @JoinColumn(name = "id_archivio_detail", referencedColumnName = "id")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private ArchivioDetail idArchivioDetail;
    
    @JoinColumn(name = "id_azienda", referencedColumnName = "id")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Azienda idAzienda;
    
    @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss.SSSSSSXXX'['VV']'")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss.SSSSSSXXX'['VV']'")
    @Column(name = "data_creazione")
    @Basic(optional = false)
    @NotNull
    private ZonedDateTime dataCreazione;

    @Version()
    @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss.SSSSSSXXX'['VV']'")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss.SSSSSSXXX'['VV']'")
    private ZonedDateTime version;
    
    public PermessoArchivio() {
    }

    public PermessoArchivio(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getBit() {
        return bit;
    }

    public void setBit(Integer bit) {
        this.bit = bit;
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

    public Persona getIdPersona() {
        return idPersona;
    }

    public void setIdPersona(Persona idPersona) {
        this.idPersona = idPersona;
    }

    public Integer[] getIdPermessiSorgente() {
        return idPermessiSorgente;
    }

    public void setIdPermessiSorgente(Integer[] idPermessiSorgente) {
        this.idPermessiSorgente = idPermessiSorgente;
    }
    
    

//    public Integer getIdSoggetto() {
//        return idSoggetto;
//    }
//
//    public void setIdSoggetto(Integer idSoggetto) {
//        this.idSoggetto = idSoggetto;
//    }

//    public TipoSoggetto getTipoSoggetto() {
//        if (tipoSoggetto != null) {
//            return TipoSoggetto.valueOf(tipoSoggetto);
//        } else {
//            return null;
//        }
//    }
//
//    public void setTipoSoggetto(TipoSoggetto tipoSoggetto) {
//        if (tipoSoggetto != null) {
//            this.tipoSoggetto = tipoSoggetto.toString();
//        } else {
//            this.tipoSoggetto = null;
//        }
//    }

    public ArchivioDetail getIdArchivioDetail() {
        return idArchivioDetail;
    }

    public void setIdArchivioDetail(ArchivioDetail idArchivioDetail) {
        this.idArchivioDetail = idArchivioDetail;
    }

//    public Integer getBitPermesso() {
//        return bitPermesso;
//    }
//
//    public void setBitPermesso(Integer bitPermesso) {
//        this.bitPermesso = bitPermesso;
//    }

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
        if (!(object instanceof PermessoArchivio)) {
            return false;
        }
        PermessoArchivio other = (PermessoArchivio) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "it.bologna.ausl.model.entities.scripta.PermessoArchivio[ id=" + id + " ]";
    }
    
}
