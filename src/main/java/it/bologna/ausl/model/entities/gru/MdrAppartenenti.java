/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.bologna.ausl.model.entities.gru;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import it.nextsw.common.annotations.GenerateProjections;
import it.bologna.ausl.model.entities.baborg.Azienda;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.time.ZonedDateTime;
import javax.persistence.Basic;
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
import javax.validation.constraints.Size;
import org.hibernate.annotations.DynamicUpdate;
import org.springframework.format.annotation.DateTimeFormat;

/**
 *
 * @author Top
 */
@Entity
@Table(name = "mdr_appartenenti", catalog = "internauta", schema = "gru")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@GenerateProjections({})
@DynamicUpdate
public class MdrAppartenenti implements Serializable {

    private static final long serialVersionUID = 1L;

    public static void selectAppartenentiByIdAzienda(String idAzienda) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    @Column(name = "codice_ente")
    private String codiceEnte;

    @Column(name = "codice_matricola")
    private Integer codiceMatricola;

    @Size(max = 2147483647)
    @Column(name = "cognome")
    private String cognome;

    @Size(max = 2147483647)
    @Column(name = "nome")
    private String nome;

    @Size(max = 2147483647)
    @Column(name = "codice_fiscale")
    private String codiceFiscale;

    @Column(name = "id_casella")
    private Integer idCasella;

    @Column(name = "datain")
    @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss.SSSSSSXXX'['VV']'")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss.SSSSSSXXX'['VV']'")
    private ZonedDateTime datain;

    @Column(name = "datafi")
    @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss.SSSSSSXXX'['VV']'")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss.SSSSSSXXX'['VV']'")
    private ZonedDateTime datafi;

    @Size(max = 2147483647)
    @Column(name = "tipo_appartenenza")
    private String tipoAppartenenza;

    @Size(max = 2147483647)
    @Column(name = "username")
    private String username;

    @Column(name = "data_assunzione")
    @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss.SSSSSSXXX'['VV']'")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss.SSSSSSXXX'['VV']'")
    private ZonedDateTime dataAssunzione;

    @Column(name = "data_dimissione")
    @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss.SSSSSSXXX'['VV']'")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss.SSSSSSXXX'['VV']'")
    private ZonedDateTime dataDimissione;

    @JoinColumn(name = "id_azienda", referencedColumnName = "id")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Azienda idAzienda;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;

    @Version()
    @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss.SSSSSSXXX'['VV']'")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss.SSSSSSXXX'['VV']'")
    private ZonedDateTime version;

    public MdrAppartenenti() {
    }

    public MdrAppartenenti(Integer id) {
        this.id = id;
    }

    public String getCodiceEnte() {
        return codiceEnte;
    }

    public void setCodiceEnte(String codiceEnte) {
        this.codiceEnte = codiceEnte;
    }

    public Integer getCodiceMatricola() {
        return codiceMatricola;
    }

    public void setCodiceMatricola(Integer codiceMatricola) {
        this.codiceMatricola = codiceMatricola;
    }

    public String getCognome() {
        return cognome;
    }

    public void setCognome(String cognome) {
        this.cognome = cognome;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCodiceFiscale() {
        return codiceFiscale;
    }

    public void setCodiceFiscale(String codiceFiscale) {
        this.codiceFiscale = codiceFiscale;
    }

    public Integer getIdCasella() {
        return idCasella;
    }

    public void setIdCasella(Integer idCasella) {
        this.idCasella = idCasella;
    }

    public ZonedDateTime getDatain() {
        return datain;
    }

    public void setDatain(ZonedDateTime datain) {
        this.datain = datain;
    }

    public ZonedDateTime getDatafi() {
        return datafi;
    }

    public void setDatafi(ZonedDateTime datafi) {
        this.datafi = datafi;
    }

    public String getTipoAppartenenza() {
        return tipoAppartenenza;
    }

    public void setTipoAppartenenza(String tipoAppartenenza) {
        this.tipoAppartenenza = tipoAppartenenza;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public ZonedDateTime getDataAssunzione() {
        return dataAssunzione;
    }

    public void setDataAssunzione(ZonedDateTime dataAssunzione) {
        this.dataAssunzione = dataAssunzione;
    }

    public ZonedDateTime getDataDimissione() {
        return dataDimissione;
    }

    public void setDataDimissione(ZonedDateTime dataDimissione) {
        this.dataDimissione = dataDimissione;
    }

    public Azienda getIdAzienda() {
        return idAzienda;
    }

    public void setIdAzienda(Azienda idAzienda) {
        this.idAzienda = idAzienda;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

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
        if (!(object instanceof MdrAppartenenti)) {
            return false;
        }
        MdrAppartenenti other = (MdrAppartenenti) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "it.bologna.ausl.model.entities.gru.MdrAppartenenti[ id=" + id + " ]";
    }

}
