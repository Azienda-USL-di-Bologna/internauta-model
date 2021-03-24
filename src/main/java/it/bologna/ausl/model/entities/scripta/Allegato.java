/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.bologna.ausl.model.entities.scripta;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import it.bologna.ausl.model.entities.baborg.Persona;
import it.nextsw.common.annotations.GenerateProjections;
import java.io.Serializable;
import java.security.Timestamp;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;
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
import javax.persistence.Version;
import org.springframework.format.annotation.DateTimeFormat;

/**
 *
 * @author Top
 */
@Entity
@Table(name = "allegati", catalog = "internauta", schema = "scripta")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Cacheable(false)
@GenerateProjections({"idDoc", "idDoc,idAllegatoPadre"})
public class Allegato implements Serializable {

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

    @Basic(optional = false)
    @Column(name = "nome")
    private String nome;

    @Basic(optional = false)
    @Column(name = "estensione")
    private String estensione;

    @Basic(optional = false)
    @Column(name = "tipo")
    private String tipo;

    @Basic(optional = false)
    @Column(name = "id_repository")
    private String idRepository;

    @Basic(optional = true)
    @Column(name = "principale")
    private Boolean principale;

    @Basic(optional = false)
    @Column(name = "numero_allegato")
    private Integer numeroAllegato;

    @Basic(optional = true)
    @Column(name = "convertibile_pdf")
    private Boolean convertibilePdf;

    @Basic(optional = true)
    @Column(name = "dimensione_byte")
    private Integer dimensioneByte;

    @Basic(optional = true)
    @Column(name = "mime_type")
    private String mimeType;

    @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss.SSSSSSXXX'['VV']'")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss.SSSSSSXXX'['VV']'")
    private LocalDateTime dataInserimento;

    @Version()
    @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss.SSSSSSXXX'['VV']'")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss.SSSSSSXXX'['VV']'")
    private ZonedDateTime version;

    public Allegato(Integer id, Doc idDoc, Allegato idAllegatoPadre, String nome, String estensione, String tipo, String idRepository, Boolean principale, Integer numeroAllegato, Boolean convertibilePdf, Integer dimensioneByte, String mimeType, LocalDateTime dataInserimento, ZonedDateTime version) {
        this.id = id;
        this.idDoc = idDoc;
        this.idAllegatoPadre = idAllegatoPadre;
        this.nome = nome;
        this.estensione = estensione;
        this.tipo = tipo;
        this.idRepository = idRepository;
        this.principale = principale;
        this.numeroAllegato = numeroAllegato;
        this.convertibilePdf = convertibilePdf;
        this.dimensioneByte = dimensioneByte;
        this.mimeType = mimeType;
        this.dataInserimento = dataInserimento;
        this.version = version;
    }

    public Allegato() {
    }

    public Allegato(Doc idDoc, Allegato idAllegatoPadre, String nome, String estensione, String tipo, String idRepository, Boolean principale, Integer numeroAllegato, Boolean convertibilePdf, Integer dimensioneByte, String mimeType, LocalDateTime dataInserimento) {
        this.idDoc = idDoc;
        this.idAllegatoPadre = idAllegatoPadre;
        this.nome = nome;
        this.estensione = estensione;
        this.tipo = tipo;
        this.idRepository = idRepository;
        this.principale = principale;
        this.numeroAllegato = numeroAllegato;
        this.convertibilePdf = convertibilePdf;
        this.dimensioneByte = dimensioneByte;
        this.mimeType = mimeType;
        this.dataInserimento = dataInserimento;
    }

    public String getEstensione() {
        return estensione;
    }

    public void setEstensione(String estensione) {
        this.estensione = estensione;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public LocalDateTime getDataInserimento() {
        return dataInserimento;
    }

    public void setDataInserimento(LocalDateTime dataInserimento) {
        this.dataInserimento = dataInserimento;
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

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getIdRepository() {
        return idRepository;
    }

    public void setIdRepository(String idRepository) {
        this.idRepository = idRepository;
    }

    public Boolean getPrincipale() {
        return principale;
    }

    public void setPrincipale(Boolean principale) {
        this.principale = principale;
    }

    public Integer getNumeroAllegato() {
        return numeroAllegato;
    }

    public void setNumeroAllegato(Integer numeroAllegato) {
        this.numeroAllegato = numeroAllegato;
    }

    public Boolean getConvertibilePdf() {
        return convertibilePdf;
    }

    public void setConvertibilePdf(Boolean convertibilePdf) {
        this.convertibilePdf = convertibilePdf;
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

    public ZonedDateTime getVersion() {
        return version;
    }

    public void setVersion(ZonedDateTime version) {
        this.version = version;
    }

}
