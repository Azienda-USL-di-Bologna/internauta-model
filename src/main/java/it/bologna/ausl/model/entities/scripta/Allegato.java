package it.bologna.ausl.model.entities.scripta;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.google.common.base.CaseFormat;
import com.vladmihalcea.hibernate.type.json.JsonBinaryType;
import it.nextsw.common.annotations.GenerateProjections;
import java.io.Serializable;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
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
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Version;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;
import org.springframework.format.annotation.DateTimeFormat;

/**
 *
 * @author Mido
 */
@TypeDefs({
    @TypeDef(name = "jsonb", typeClass = JsonBinaryType.class)
})
@Entity
@Table(name = "allegati", catalog = "internauta", schema = "scripta")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Cacheable(false)
@GenerateProjections({
    "idDoc", 
    "idDoc, idAllegatoPadre",
    "idAllegatoPadre"
})
@DynamicUpdate
public class Allegato implements Serializable {

    public static enum TipoAllegato {
        ALLEGATO,
        LETTERA,
        FRONTESPIZIO,
        STAMPA_UNICA,
        FASCICOLATO,
        STAMPA_UNICA_OMISSIS,
        LETTERA_OMISSIS
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

    @OneToMany(mappedBy = "idAllegatoPadre", fetch = FetchType.LAZY, cascade = {CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REMOVE})
    @JsonBackReference(value = "allegatiFigliList")
    private List<Allegato> allegatiFigliList;

//    @OneToMany(mappedBy = "idAllegato", fetch = FetchType.LAZY, cascade = {CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REMOVE})
//    @JsonBackReference(value = "dettagliAllegatiList")
//    private List<it.bologna.ausl.model.entities.scripta.DettaglioAllegato> dettagliAllegatiList;
    
    @Type(type = "jsonb")
    @Column(name = "dettagli", columnDefinition = "jsonb")
    private DettagliAllegato dettagli;

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

    public DettagliAllegato getDettagli() {
        return dettagli;
    }

//    public List<it.bologna.ausl.model.entities.scripta.DettaglioAllegato> getDettagliAllegatiList() {
//        return dettagliAllegatiList;
//    }
//
//    public void setDettagliAllegatiList(List<it.bologna.ausl.model.entities.scripta.DettaglioAllegato> dettagliAllegatiList) {
//        this.dettagliAllegatiList = dettagliAllegatiList;
//    }
    public void setDettagli(DettagliAllegato dettagli) {
        this.dettagli = dettagli;
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

//    public it.bologna.ausl.model.entities.scripta.DettaglioAllegato getDettaglioByTipoDettaglioAllegato(it.bologna.ausl.model.entities.scripta.DettaglioAllegato.TipoDettaglioAllegato tipo) {
////ci possono avere piu di un firmato?
//        List<it.bologna.ausl.model.entities.scripta.DettaglioAllegato> collect = getDettagliAllegatiList().stream().filter(da -> da.getCaratteristica().equals(tipo)).collect(Collectors.toList());
//        if (collect != null && !collect.isEmpty()) {
//            return collect.get(0);
//        } else {
//            return null;
//        }
//
//    }
    
    public static class DettagliAllegato {
        
        public static enum TipoDettaglioAllegato {
            ORIGINALE,
            CONVERTITO,
            SEGNAPOSTO,
            ORIGINALE_FIRMATO,
            ORIGINALE_FIRMATO_P7M,
            CONVERTITO_FIRMATO,
            CONVERTITO_FIRMATO_P7M
        } 
        
        DettaglioAllegato originale;
        DettaglioAllegato convertito;
        DettaglioAllegato segnaposto;
        DettaglioAllegato originaleFirmato;
        DettaglioAllegato convertitoFirmato;
        DettaglioAllegato originaleFirmatoP7m;
        DettaglioAllegato convertitoFirmatoP7m;

        public DettagliAllegato() {
        }

        public DettaglioAllegato getOriginale() {
            return originale;
        }

        public void setOriginale(DettaglioAllegato originale) {
            this.originale = originale;
        }

        public DettaglioAllegato getConvertito() {
            return convertito;
        }

        public void setConvertito(DettaglioAllegato convertito) {
            this.convertito = convertito;
        }

        public DettaglioAllegato getOriginaleFirmato() {
            return originaleFirmato;
        }

        public void setOriginaleFirmato(DettaglioAllegato originaleFirmato) {
            this.originaleFirmato = originaleFirmato;
        }

        public DettaglioAllegato getConvertitoFirmato() {
            return convertitoFirmato;
        }

        public void setConvertitoFirmato(DettaglioAllegato convertitoFirmato) {
            this.convertitoFirmato = convertitoFirmato;
        }

        public DettaglioAllegato getSegnaposto() {
            return segnaposto;
        }

        public void setSegnaposto(DettaglioAllegato segnaposto) {
            this.segnaposto = segnaposto;
        }

        public DettaglioAllegato getOriginaleFirmatoP7m() {
            return originaleFirmatoP7m;
        }

        public void setOriginaleFirmatoP7m(DettaglioAllegato originaleFirmatoP7m) {
            this.originaleFirmatoP7m = originaleFirmatoP7m;
        }

        public DettaglioAllegato getConvertitoFirmatoP7m() {
            return convertitoFirmatoP7m;
        }

        public void setConvertitoFirmatoP7m(DettaglioAllegato convertitoFirmatoP7m) {
            this.convertitoFirmatoP7m = convertitoFirmatoP7m;
        }
        
        @JsonIgnore
        public DettaglioAllegato getDettaglioAllegato(TipoDettaglioAllegato tipoDettaglioAllegato) throws NoSuchMethodException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
            Class<? extends DettagliAllegato> aClass = this.getClass();
            Method declaredMethod = aClass.getDeclaredMethod(String.format("get%s",  CaseFormat.UPPER_UNDERSCORE.to(CaseFormat.UPPER_CAMEL, tipoDettaglioAllegato.toString())));
            return (DettaglioAllegato) declaredMethod.invoke(this);
        }
        
        @JsonIgnore
        public void setDettaglioAllegato(DettaglioAllegato dettaglioAllegato, TipoDettaglioAllegato tipoDettaglioAllegato) throws NoSuchMethodException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
            Class<? extends DettagliAllegato> aClass = this.getClass();
            Method declaredMethod = aClass.getDeclaredMethod(String.format("set%s",  CaseFormat.UPPER_UNDERSCORE.to(CaseFormat.UPPER_CAMEL, tipoDettaglioAllegato.toString())), DettaglioAllegato.class);
            declaredMethod.invoke(this, dettaglioAllegato);
        }
    }
    
    public static class DettaglioAllegato {
       
        String idRepository;
        String estensione;
        String nome;
        Integer dimensioneByte;
        String mimeType;
        String hashMd5;
        String hashSha256;
        ZonedDateTime dataCreazione;

        public DettaglioAllegato() {
        }

        public String getIdRepository() {
            return idRepository;
        }

        public void setIdRepository(String idRepository) {
            this.idRepository = idRepository;
        }

        public String getEstensione() {
            return estensione;
        }

        public void setEstensione(String estensione) {
            this.estensione = estensione;
        }

        public String getNome() {
            return nome;
        }

        public void setNome(String nome) {
            this.nome = nome;
        }

        public Integer getDimensioneByte() {
            return dimensioneByte;
        }

        public void setDimensioneByte(Integer dimensioneByte) {
            this.dimensioneByte = dimensioneByte;
        }

        public String getMimeType() {
            return mimeType;
        }

        public void setMimeType(String mimeType) {
            this.mimeType = mimeType;
        }

        public String getHashMd5() {
            return hashMd5;
        }

        public void setHashMd5(String hashMd5) {
            this.hashMd5 = hashMd5;
        }

        public String getHashSha256() {
            return hashSha256;
        }

        public void setHashSha256(String hashSha256) {
            this.hashSha256 = hashSha256;
        }

        public ZonedDateTime getDataCreazione() {
            return dataCreazione;
        }

        public void setDataCreazione(ZonedDateTime dataCreazione) {
            this.dataCreazione = dataCreazione;
        }

    }    
}
