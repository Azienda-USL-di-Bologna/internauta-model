/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.bologna.ausl.model.entities.scripta;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import it.nextsw.common.annotations.GenerateProjections;
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
import org.springframework.format.annotation.DateTimeFormat;

/**
 *
 * @author Mdor
 */

@Entity
@Table(name = "dettagli_allegati", catalog = "internauta", schema = "scripta")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Cacheable(false)
@GenerateProjections({})
@DynamicUpdate
public class DettaglioAllegato {
    
    public static enum TipoDettaglioAllegato {
        ORIGINALE,
        CONVERTITO,
	SEGNAPOSTO,
	ORIGINALE_FIRMATO,
	ORIGINALE_FIRMATO_P7M,
	CONVERTITO_FIRMATO,
	CONVERTITO_FIRMATO_P7M
    }    
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    	
    @Basic(optional = false)
    @Column(name = "id_repository")
    private String idRepository;
    
    //allegato di cui sono il dettaglio
    @JoinColumn(name = "id_allegato", referencedColumnName = "id")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Allegato idAllegato;
    
    
    //
    @JoinColumn(name = "id_dettaglio_allegato_padre", referencedColumnName = "id")
    @ManyToOne(optional = true, fetch = FetchType.LAZY)
    private DettaglioAllegato idDettaglioAllegatoPadre;
    
    
    @OneToMany(cascade =  {CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REMOVE}, mappedBy = "idDettaglioAllegatoPadre", fetch = FetchType.LAZY)
    @JsonBackReference(value = "dettagliAllagatoFigliList")
    private List<DettaglioAllegato> dettagliAllagatoFigliList;
        
    @Basic(optional = false)
    @Column(name = "estensione")
    private String estensione;
    
    @Basic(optional = false)
    @Column(name = "nome")
    private String nome;
    
    @Basic(optional = false)
    @Column(name = "dimensione_byte")
    private Integer dimensioneByte;

    @Basic(optional = false)
    @Column(name = "mime_type")
    private String mimeType;
    
    @Basic(optional = false)
    @Column(name = "caratteristica")
    private String caratteristica;
    
    @Basic(optional = false)
    @Column(name = "hash_md5")
    private String hashMd5;
    
    @Basic(optional = false)
    @Column(name = "hash_sha256")
    private String hashSha256;
    
    @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss.SSSSSSXXX'['VV']'")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss.SSSSSSXXX'['VV']'")
    private ZonedDateTime dataInserimento = ZonedDateTime.now();

    @Version()
    @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss.SSSSSSXXX'['VV']'")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss.SSSSSSXXX'['VV']'")
    private ZonedDateTime version;
    
    public DettaglioAllegato() {
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
    
    public TipoDettaglioAllegato getCaratteristica() {
        if (caratteristica != null) {
            return TipoDettaglioAllegato.valueOf(caratteristica);
        } else {
            return null;
        }
    }

    public void setCaratteristica(TipoDettaglioAllegato tipo) {
        if (tipo != null) {
            this.caratteristica = tipo.toString();
        } else {
            this.caratteristica = null;
        }
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getIdRepository() {
        return idRepository;
    }

    public void setIdRepository(String idRepository) {
        this.idRepository = idRepository;
    }

    public DettaglioAllegato getIdDettaglioAllegatoPadre() {
        return idDettaglioAllegatoPadre;
    }

    public void setIdDettaglioAllegatoPadre(DettaglioAllegato idDettaglioAllegatoPadre) {
        this.idDettaglioAllegatoPadre = idDettaglioAllegatoPadre;
    }

    public List<DettaglioAllegato> getDettagliAllagatoFigliList() {
        return dettagliAllagatoFigliList;
    }

    public void setDettagliAllagatoFigliList(List<DettaglioAllegato> dettagliAllagatoFigliList) {
        this.dettagliAllagatoFigliList = dettagliAllagatoFigliList;
    }

    public Allegato getIdAllegato() {
        return idAllegato;
    }

    public void setIdAllegato(Allegato idAllegato) {
        this.idAllegato = idAllegato;
    }

    public String getEstensione() {
        return estensione;
    }

    public void setEstensione(String estensione) {
        this.estensione = estensione;
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
    
    

}
