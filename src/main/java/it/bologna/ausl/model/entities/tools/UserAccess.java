/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.bologna.ausl.model.entities.tools;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import it.nextsw.common.annotations.GenerateProjections;
import java.io.Serializable;
import java.math.BigInteger;
import java.time.LocalDateTime;
import javax.persistence.Basic;
import javax.persistence.Cacheable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import org.springframework.format.annotation.DateTimeFormat;

/**
 *
 * @author Top
 */
@Entity
@Table(name = "user_access", catalog = "internauta", schema = "tools")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Cacheable(false)
@GenerateProjections({})
public class UserAccess implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private BigInteger id;

    @Basic(optional = false)
    @NotNull
    @Column(name = "id_utente")
    private Integer idUtente;

    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2147483647)
    @Column(name = "cf_utente")
    private String cfUtente;

    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2147483647)
    @Column(name = "descrizione_utente")
    private String descrizioneUtente;

    @Basic(optional = false)
    @NotNull
    @Column(name = "from_internet")
    private Boolean fromInternet;

    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2147483647)
    @Column(name = "applicazione")
    private String applicazione;

    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2147483647)
    @Column(name = "codice_azienda")
    private String codiceAzienda;

    @Basic(optional = false)
    @NotNull
    @Column(name = "ts")
    @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss.SSSSSS")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss.SSSSSS")
    private LocalDateTime ts = LocalDateTime.now();

    public UserAccess(Integer idUtente, String cfUtente, String descrizioneUtente, Boolean fromInternet, String applicazione, String codiceAzienda) {
        this.idUtente = idUtente;
        this.cfUtente = cfUtente;
        this.descrizioneUtente = descrizioneUtente;
        this.fromInternet = fromInternet;
        this.applicazione = applicazione;
        this.codiceAzienda = codiceAzienda;
    }

    public BigInteger getId() {
        return id;
    }

    public void setId(BigInteger id) {
        this.id = id;
    }

    public Integer getIdUtente() {
        return idUtente;
    }

    public void setIdUtente(Integer idUtente) {
        this.idUtente = idUtente;
    }

    public String getCfUtente() {
        return cfUtente;
    }

    public void setCfUtente(String cfUtente) {
        this.cfUtente = cfUtente;
    }

    public String getDescrizioneUtente() {
        return descrizioneUtente;
    }

    public void setDescrizioneUtente(String descrizioneUtente) {
        this.descrizioneUtente = descrizioneUtente;
    }

    public Boolean getFromInternet() {
        return fromInternet;
    }

    public void setFromInternet(Boolean fromInternet) {
        this.fromInternet = fromInternet;
    }

    public String getApplicazione() {
        return applicazione;
    }

    public void setApplicazione(String applicazione) {
        this.applicazione = applicazione;
    }

    public String getCodiceAzienda() {
        return codiceAzienda;
    }

    public void setCodiceAzienda(String codiceAzienda) {
        this.codiceAzienda = codiceAzienda;
    }

    public LocalDateTime getTs() {
        return ts;
    }

    public void setTs(LocalDateTime ts) {
        this.ts = ts;
    }

}
