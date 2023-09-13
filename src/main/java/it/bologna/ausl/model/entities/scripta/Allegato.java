package it.bologna.ausl.model.entities.scripta;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.google.common.base.CaseFormat;
import com.vladmihalcea.hibernate.type.json.JsonBinaryType;
import it.bologna.ausl.model.entities.versatore.Versamento;
import it.bologna.ausl.model.entities.versatore.VersamentoAllegato;
import it.nextsw.common.data.annotations.GenerateProjections;
import it.nextsw.common.data.types.AbstractJsonType;
import java.io.Serializable;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
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
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Version;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;
import org.slf4j.LoggerFactory;
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
    
    private static final org.slf4j.Logger log = LoggerFactory.getLogger(Allegato.class);

    public static enum TipoAllegato {
        ALLEGATO,
        TESTO,
        FRONTESPIZIO,
        STAMPA_UNICA,
        FASCICOLATO,
        STAMPA_UNICA_OMISSIS,
        TESTO_OMISSIS,
        ANNESSO,
        ANNOTAZIONE,
        REGISTRO_GIORNALIERO
    }
    
    public static enum SottotipoAllegato {
        DELIBERA_NO_OMISSIS,
        DELIBERA_OMISSIS,
        DESTINATARI,
        NOTE_DOCUMENTO,
        RICEVUTA_ACCETTAZIONE_PEC,
        RICEVUTA_CONSEGNA_PEC,
        RICEVUTA_ERRORE_PEC,
        RICEVUTA_MANCATA_CONSEGNA_PEC,
        RICEVUTA_SCONOSCIUTA_PEC,
        SEGNATURA,
        SMISTAMENTO,
        MITTENTI,
        RELATA,
        BIRD,
        SINTESI_TRASPARENZA
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
    @Enumerated(EnumType.STRING)
    private TipoAllegato tipo = TipoAllegato.ALLEGATO;

    @Column(name = "sottotipo")
    @Enumerated(EnumType.STRING)
    private SottotipoAllegato sottotipo;
    
    @Basic(optional = false)
    @Column(name = "principale")
    private Boolean principale = false;

//    @Basic(optional = false)
    @Column(name = "ordinale")
    private Integer ordinale;
    
    @Basic(optional = false)
    @Column(name = "firmato")
    private Boolean firmato = false;
    
    @Column(name = "estraibile")
    private Boolean estraibile = false;
    
    @Type(type = "jsonb")
    @Column(name = "additional_data", columnDefinition = "jsonb")
    private HashMap<String,Object> additionalData;
    
    @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss.SSSSSSXXX'['VV']'")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss.SSSSSSXXX'['VV']'")
    private ZonedDateTime dataInserimento = ZonedDateTime.now();

    @Version()
    @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss.SSSSSSXXX'['VV']'")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss.SSSSSSXXX'['VV']'")
    private ZonedDateTime version;
    
    @OneToMany(cascade = {CascadeType.MERGE, CascadeType.PERSIST}, mappedBy = "idAllegato", fetch = FetchType.LAZY)
    @JsonBackReference(value = "versamentiAllegatiList")
    private List<VersamentoAllegato> versamentiAllegatiList;

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
        return tipo;
    }

    public void setTipo(TipoAllegato tipo) {
        this.tipo = tipo;
    }

    public SottotipoAllegato getSottotipo() {
        return sottotipo;
    }

    public void setSottotipo(SottotipoAllegato sottotipo) {
        this.sottotipo = sottotipo;
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

    public Boolean getEstraibile() {
        return estraibile;
    }

    public void setEstraibile(Boolean estraibile) {
        this.estraibile = estraibile;
    }

    public HashMap<String, Object> getAdditionalData() {
        return additionalData;
    }

    public void setAdditionalData(HashMap<String, Object> additionalData) {
        this.additionalData = additionalData;
    }

    public ZonedDateTime getDataInserimento() {
        return dataInserimento;
    }

    public void setDataInserimento(ZonedDateTime dataInserimento) {
        this.dataInserimento = dataInserimento;
    }

    public List<VersamentoAllegato> getVersamentiAllegatiList() {
        return versamentiAllegatiList;
    }

    public void setVersamentiAllegatiList(List<VersamentoAllegato> versamentiAllegatiList) {
        this.versamentiAllegatiList = versamentiAllegatiList;
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
        
        private DettaglioAllegato originale;
        private DettaglioAllegato convertito;
        private DettaglioAllegato segnaposto;
        private DettaglioAllegato originaleFirmato;
        private DettaglioAllegato convertitoFirmato;
        private DettaglioAllegato originaleFirmatoP7m;
        private DettaglioAllegato convertitoFirmatoP7m;

        public DettagliAllegato() {
        }

        @JsonIgnore
        public DettaglioAllegato getByKey(TipoDettaglioAllegato tipoDettaglioAllegato) {
            switch (tipoDettaglioAllegato) {
                case ORIGINALE:
                    return this.originale;
                case SEGNAPOSTO:
                    return this.segnaposto;
                case CONVERTITO_FIRMATO:
                    return this.convertitoFirmato;
                case CONVERTITO:
                    return this.convertito;
                case CONVERTITO_FIRMATO_P7M:
                    return this.convertitoFirmatoP7m;
                case ORIGINALE_FIRMATO:
                    return this.originaleFirmato;
                case ORIGINALE_FIRMATO_P7M:
                    return this.originaleFirmatoP7m;
                default:
                    return null;
            }
        }
        
        @JsonIgnore
        public void setByKey(TipoDettaglioAllegato tipoDettaglioAllegato, DettaglioAllegato dettaglioAllegato){
            switch (tipoDettaglioAllegato) {
                case ORIGINALE:
                    this.originale = dettaglioAllegato;
                    break;
                case SEGNAPOSTO:
                    this.segnaposto = dettaglioAllegato;
                    break;
                case CONVERTITO_FIRMATO:
                    this.convertitoFirmato = dettaglioAllegato;
                    break;
                case CONVERTITO:
                    this.convertito = dettaglioAllegato;
                    break;
                case CONVERTITO_FIRMATO_P7M:
                    this.convertitoFirmatoP7m = dettaglioAllegato;
                    break;
                case ORIGINALE_FIRMATO:
                    this.originaleFirmato = dettaglioAllegato;
                    break;
                case ORIGINALE_FIRMATO_P7M:
                    this.originaleFirmatoP7m = dettaglioAllegato;
                    break;
            }
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
        
        /**
         * Restituisce tutti i formati dell'allegato contenuti nei dettagli.
         * Eg: Originale, Convertito, OriginaleFirmato, etc.
         * @return La lista di tutti i file dell'allegato.
         */
        @JsonIgnore
        public List<DettaglioAllegato> getAllTipiDettagliAllegati() {
            List<DettaglioAllegato> dettagliAllegato = new ArrayList();

            Class<? extends DettagliAllegato> aClass = this.getClass();
            for (Field f: aClass.getDeclaredFields()) {
                for (Method method : aClass.getDeclaredMethods()) {
                    try {                        
                        if ((method.getName().startsWith("get")) && (method.getName().length() == (f.getName().length() + 3)) && 
                            method.getName().toLowerCase().endsWith(f.getName().toLowerCase()) &&
                            method.getAnnotation(JsonIgnore.class) == null) {
                            DettaglioAllegato value = (DettaglioAllegato) method.invoke(this);
                            if (value != null) {
                                dettagliAllegato.add(value);
                            }
                        }        
                    } catch (Exception ex) {
                        log.error(ex.getMessage());
                    } 
                } 
            }
            return dettagliAllegato;
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
    
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class DettaglioAllegato extends AbstractJsonType {

        private String idRepository;
        private String estensione;
        private String nome;
        private Integer dimensioneByte;
        private String mimeType;
        private String hashMd5;
        private String hashSha256;
        
//        @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss.SSSSSSXXX'['VV']'", fallbackPatterns = {"yyyy-MM-dd'T'HH:mm:ss.SSSSSS", "yyyy-MM-dd'T'HH:mm:ss+01"})
//        @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss.SSSSSSXXX'['VV']'")
//        @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss.SSSSSS'Z'")
//        @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss.SSSSSS'Z'")
//        @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss")//, fallbackPatterns = {"yyyy-MM-dd'T'HH:mm:ss z"}
//        @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss[.SSS][.SS][.S][z]", locale = DEFAULT_LOCALE, timezone="Europe/Berlin", lenient = com.fasterxml.jackson.annotation.OptBoolean.TRUE)//, 
        private String dataCreazione;
        private Versamento.StatoVersamento statoUltimoVersamento;
        private Versamento.StatoVersamento statoVersamento;
        private Boolean versamentoForzabile = false;
        private Boolean daVersare = false;

        private String bucket;
        

        public DettaglioAllegato() {
            super();
            //ZonedDateTime.from(DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss.SSSSSS'Z'").parse("2022-05-31T15:12:09.000"));
            dataCreazione = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss.SSSSSSXXX'['VV']'").format(ZonedDateTime.now());
        }
        
        public Boolean getDaVersare() {
            return daVersare;
        }

        public void setDaVersare(Boolean daVersare) {
            this.daVersare = daVersare;
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

        public String getDataCreazione() {
            return dataCreazione;
        }

        public void setDataCreazione(String dataCreazione) {
            this.dataCreazione = dataCreazione;
        }

        public String getBucket() {
            return bucket;
        }

        public void setBucket(String bucket) {
            this.bucket = bucket;
        }

        public Versamento.StatoVersamento getStatoUltimoVersamento() {
            return statoUltimoVersamento;
        }

        public void setStatoUltimoVersamento(Versamento.StatoVersamento statoUltimoVersamento) {
            this.statoUltimoVersamento = statoUltimoVersamento;
        }
        
        public Versamento.StatoVersamento getStatoVersamento() {
            return statoVersamento;
        }

        public void setStatoVersamento(Versamento.StatoVersamento statoVersamento) {
            this.statoVersamento = statoVersamento;
        }

        public Boolean getVersamentoForzabile() {
            return versamentoForzabile;
        }

        public void setVersamentoForzabile(Boolean versamentoForzabile) {
            this.versamentoForzabile = versamentoForzabile;
        }
    }
}
