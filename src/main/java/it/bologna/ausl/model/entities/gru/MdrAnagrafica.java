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
@Table(name = "mdr_anagrafica", catalog = "internauta", schema = "gru")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@GenerateProjections({})
@DynamicUpdate
public class MdrAnagrafica implements Serializable {

    private static final long serialVersionUID = 1L;

    public static void selectAnagraficaByIdAzienda(String idAzienda) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    @Column(name = "codice_ente")
    private String codiceEnte;

    @Column(name = "codice_matricola")
    private String codiceMatricola;

    @Size(max = 2147483647)
    @Column(name = "cognome")
    private String cognome;

    @Size(max = 2147483647)
    @Column(name = "nome")
    private String nome;

    @Size(max = 2147483647)
    @Column(name = "codice_fiscale")
    private String codiceFiscale;

    @Size(max = 2147483647)
    @Column(name = "email")
    private String email;

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

    public MdrAnagrafica() {
    }

    public MdrAnagrafica(Integer id) {
        this.id = id;
    }

    public String getCodiceEnte() {
        return codiceEnte;
    }

    public void setCodiceEnte(String codiceEnte) {
        this.codiceEnte = codiceEnte;
    }

    public String getCodiceMatricola() {
        return codiceMatricola;
    }

    public void setCodiceMatricola(String codiceMatricola) {
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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
        if (!(object instanceof MdrAnagrafica)) {
            return false;
        }
        MdrAnagrafica other = (MdrAnagrafica) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "it.bologna.ausl.model.entities.gru.MdrAnagrafica[ id=" + id + " ]";
    }

}
