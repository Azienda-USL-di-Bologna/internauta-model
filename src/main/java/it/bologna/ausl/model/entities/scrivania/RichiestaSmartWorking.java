package it.bologna.ausl.model.entities.scrivania;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import it.bologna.ausl.internauta.utils.jpa.tools.GenericArrayUserType;
import it.nextsw.common.annotations.GenerateProjections;
import it.bologna.ausl.model.entities.baborg.Azienda;
import it.bologna.ausl.model.entities.baborg.Utente;
import java.io.Serializable;
import java.time.LocalDate;
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
import javax.validation.constraints.Size;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.Parameter;
import org.hibernate.annotations.Type;
import org.springframework.format.annotation.DateTimeFormat;

/**
 *
 * @author gusgus
 */
@Entity
@Table(name = "richieste_smart_working", catalog = "internauta", schema = "scrivania")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Cacheable(false)
@GenerateProjections({})
@DynamicUpdate
public class RichiestaSmartWorking implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @JoinColumn(name = "id_utente_richiedente", referencedColumnName = "id")
    @ManyToOne(fetch = FetchType.LAZY)
    private Utente idUtenteRichiedente;
    @Size(max = 2147483647)
    @Column(name = "richiedente")
    private String richiedente;
    @Size(max = 2147483647)
    @Column(name = "codice_fiscale")
    private String codiceFiscale;
    @Size(max = 2147483647)
    @Column(name = "mail_richiedente")
    private String mailRichiedente;
    @Size(max = 2147483647)
    @Column(name = "responsabile")
    private String responsabile;
    @JoinColumn(name = "id_utente_responsabile", referencedColumnName = "id")
    @ManyToOne(fetch = FetchType.LAZY)
    private Utente idUtenteResponsabile;
    @Size(max = 2147483647)
    @Column(name = "mail_responsabile")
    private String mailResponsabile;
    @Size(max = 2147483647)
    @Column(name = "mail_ufficio_personale")
    private String mailUfficioPersonale;
    @Column(name = "periodo_dal")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private LocalDate periodoDal;
    @Column(name = "periodo_al")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private LocalDate periodoAl;
    @Size(max = 2147483647)
    @Column(name = "motivazione")
    private String motivazione;
    @Column(name = "ho_postazione_esclusiva")
    private Boolean hoPostazioneEsclusiva;
    @Column(name = "postazione_ip")
    private Boolean postazioneIp;
    @Size(max = 2147483647)
    @Column(name = "ip")
    private String ip;
    @JoinColumn(name = "id_azienda", referencedColumnName = "id")
    @ManyToOne(fetch = FetchType.LAZY)
    private Azienda idAzienda;
    @Size(max = 2147483647)
    @Column(name = "azienda")
    private String azienda;
    @Size(max = 2147483647)
    @Column(name = "sede")
    private String sede;
    @Size(max = 2147483647)
    @Column(name = "pc")
    private String pc;
    @Size(max = 2147483647)
    @Column(name = "inventario")
    private String inventario;
    @Size(max = 2147483647)
    @Column(name = "nome_pc")
    private String nomePc;
    @Size(max = 2147483647)
    @Column(name = "sistema_operativo")
    private String sistemaOperativo;
    @Column(name = "connettivita_domestica")
    private Boolean connettivitaDomestica;
    @Size(max = 2147483647)
    @Column(name = "numero_tel")
    private String numeroTel;
    @Column(name = "ho_cellulare_aziendale")
    private Boolean hoCellulareAziendale;
    @Size(max = 2147483647)
    @Column(name = "numero_cell_aziendale")
    private String numeroCellAziendale;
    @Size(max = 2147483647)
    @Column(name = "contattabilita")
    private String contattabilita;
    @Column(name = "vpn")
    private Boolean vpn;
    @Column(name = "firma")
    private Boolean firma;
    @Column(name = "ha_lettore_smart_card")
    private Boolean haLettoreSmartCard;
    @Size(max = 2147483647)
    @Column(name = "attivita_smart_working")
    private String attivitaSmartWorking;
    @Column(name = "gru")
    private Boolean gru;
    @Column(name = "gaac")
    private Boolean gaac;
    @Column(name = "babel")
    private Boolean babel;
    @Column(name = "sirer")
    private Boolean sirer;
    @Column(name = "nextcloud")
    private Boolean nextcloud;
    @Size(max = 2147483647)
    @Column(name = "app_usate")
    private String appUsate;
    @Column(name = "cartelle_condivise")
    private Boolean cartelleCondivise;
    @Column(name = "ict_involved")
    private Boolean ictInvolved;
    @Column(name = "non_tutto_andra")
    private Boolean nonTuttoAndra;
    @Column(name = "policy")
    private Boolean policy;
    @Column(name = "visionato_informativa")
    private Boolean visionatoInformativa;
    @Size(max = 2147483647)
    @Column(name = "mailict")
    private String mailict;
    @Column(name = "dichiarazioni_finali", columnDefinition = "text[]")
    @Type(type = "array", parameters = @Parameter(name = "elements-type", value = GenericArrayUserType.TEXT_ELEMENT_TYPE))
    private String[] dichiarazioniFinali;
    @Column(name = "my_sanita")
    private Boolean mySanita;

    public RichiestaSmartWorking() {
    }

    public RichiestaSmartWorking(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Utente getIdUtenteRichiedente() {
        return idUtenteRichiedente;
    }

    public void setIdUtenteRichiedente(Utente idUtenteRichiedente) {
        this.idUtenteRichiedente = idUtenteRichiedente;
    }

    public String getRichiedente() {
        return richiedente;
    }

    public void setRichiedente(String richiedente) {
        this.richiedente = richiedente;
    }

    public String getCodiceFiscale() {
        return codiceFiscale;
    }

    public void setCodiceFiscale(String codiceFiscale) {
        this.codiceFiscale = codiceFiscale;
    }

    public String getMailRichiedente() {
        return mailRichiedente;
    }

    public void setMailRichiedente(String mailRichiedente) {
        this.mailRichiedente = mailRichiedente;
    }

    public String getResponsabile() {
        return responsabile;
    }

    public void setResponsabile(String responsabile) {
        this.responsabile = responsabile;
    }

    public Utente getIdUtenteResponsabile() {
        return idUtenteResponsabile;
    }

    public void setIdUtenteResponsabile(Utente idUtenteResponsabile) {
        this.idUtenteResponsabile = idUtenteResponsabile;
    }

    public String getMailResponsabile() {
        return mailResponsabile;
    }

    public void setMailResponsabile(String mailResponsabile) {
        this.mailResponsabile = mailResponsabile;
    }

    public String getMailUfficioPersonale() {
        return mailUfficioPersonale;
    }

    public void setMailUfficioPersonale(String mailUfficioPersonale) {
        this.mailUfficioPersonale = mailUfficioPersonale;
    }

    public LocalDate getPeriodoDal() {
        return periodoDal;
    }

    public void setPeriodoDal(LocalDate periodoDal) {
        this.periodoDal = periodoDal;
    }

    public LocalDate getPeriodoAl() {
        return periodoAl;
    }

    public void setPeriodoAl(LocalDate periodoAl) {
        this.periodoAl = periodoAl;
    }

    public String getMotivazione() {
        return motivazione;
    }

    public void setMotivazione(String motivazione) {
        this.motivazione = motivazione;
    }

    public Boolean getHoPostazioneEsclusiva() {
        return hoPostazioneEsclusiva;
    }

    public void setHoPostazioneEsclusiva(Boolean hoPostazioneEsclusiva) {
        this.hoPostazioneEsclusiva = hoPostazioneEsclusiva;
    }

    public Boolean getPostazioneIp() {
        return postazioneIp;
    }

    public void setPostazioneIp(Boolean postazioneIp) {
        this.postazioneIp = postazioneIp;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public Azienda getIdAzienda() {
        return idAzienda;
    }

    public void setIdAzienda(Azienda idAzienda) {
        this.idAzienda = idAzienda;
    }

    public String getAzienda() {
        return azienda;
    }

    public void setAzienda(String azienda) {
        this.azienda = azienda;
    }

    public String getSede() {
        return sede;
    }

    public void setSede(String sede) {
        this.sede = sede;
    }

    public String getPc() {
        return pc;
    }

    public void setPc(String pc) {
        this.pc = pc;
    }

    public String getInventario() {
        return inventario;
    }

    public void setInventario(String inventario) {
        this.inventario = inventario;
    }

    public String getNomePc() {
        return nomePc;
    }

    public void setNomePc(String nomePc) {
        this.nomePc = nomePc;
    }

    public String getSistemaOperativo() {
        return sistemaOperativo;
    }

    public void setSistemaOperativo(String sistemaOperativo) {
        this.sistemaOperativo = sistemaOperativo;
    }

    public Boolean getConnettivitaDomestica() {
        return connettivitaDomestica;
    }

    public void setConnettivitaDomestica(Boolean connettivitaDomestica) {
        this.connettivitaDomestica = connettivitaDomestica;
    }

    public String getNumeroTel() {
        return numeroTel;
    }

    public void setNumeroTel(String numeroTel) {
        this.numeroTel = numeroTel;
    }

    public Boolean getHoCellulareAziendale() {
        return hoCellulareAziendale;
    }

    public void setHoCellulareAziendale(Boolean hoCellulareAziendale) {
        this.hoCellulareAziendale = hoCellulareAziendale;
    }

    public String getNumeroCellAziendale() {
        return numeroCellAziendale;
    }

    public void setNumeroCellAziendale(String numeroCellAziendale) {
        this.numeroCellAziendale = numeroCellAziendale;
    }

    public String getContattabilita() {
        return contattabilita;
    }

    public void setContattabilita(String contattabilita) {
        this.contattabilita = contattabilita;
    }

    public Boolean getVpn() {
        return vpn;
    }

    public void setVpn(Boolean vpn) {
        this.vpn = vpn;
    }

    public Boolean getFirma() {
        return firma;
    }

    public void setFirma(Boolean firma) {
        this.firma = firma;
    }

    public Boolean getHaLettoreSmartCard() {
        return haLettoreSmartCard;
    }

    public void setHaLettoreSmartCard(Boolean haLettoreSmartCard) {
        this.haLettoreSmartCard = haLettoreSmartCard;
    }

    public String getAttivitaSmartWorking() {
        return attivitaSmartWorking;
    }

    public void setAttivitaSmartWorking(String attivitaSmartWorking) {
        this.attivitaSmartWorking = attivitaSmartWorking;
    }

    public Boolean getGru() {
        return gru;
    }

    public void setGru(Boolean gru) {
        this.gru = gru;
    }

    public Boolean getGaac() {
        return gaac;
    }

    public void setGaac(Boolean gaac) {
        this.gaac = gaac;
    }

    public Boolean getBabel() {
        return babel;
    }

    public void setBabel(Boolean babel) {
        this.babel = babel;
    }

    public Boolean getSirer() {
        return sirer;
    }

    public void setSirer(Boolean sirer) {
        this.sirer = sirer;
    }

    public Boolean getNextcloud() {
        return nextcloud;
    }

    public void setNextcloud(Boolean nextcloud) {
        this.nextcloud = nextcloud;
    }

    public String getAppUsate() {
        return appUsate;
    }

    public void setAppUsate(String appUsate) {
        this.appUsate = appUsate;
    }

    public Boolean getCartelleCondivise() {
        return cartelleCondivise;
    }

    public void setCartelleCondivise(Boolean cartelleCondivise) {
        this.cartelleCondivise = cartelleCondivise;
    }

    public Boolean getIctInvolved() {
        return ictInvolved;
    }

    public void setIctInvolved(Boolean ictInvolved) {
        this.ictInvolved = ictInvolved;
    }

    public Boolean getNonTuttoAndra() {
        return nonTuttoAndra;
    }

    public void setNonTuttoAndra(Boolean nonTuttoAndra) {
        this.nonTuttoAndra = nonTuttoAndra;
    }

    public Boolean getPolicy() {
        return policy;
    }

    public void setPolicy(Boolean policy) {
        this.policy = policy;
    }

    public Boolean getVisionatoInformativa() {
        return visionatoInformativa;
    }

    public void setVisionatoInformativa(Boolean visionatoInformativa) {
        this.visionatoInformativa = visionatoInformativa;
    }

    public String getMailict() {
        return mailict;
    }

    public void setMailict(String mailict) {
        this.mailict = mailict;
    }

    public String[] getDichiarazioniFinali() {
        return dichiarazioniFinali;
    }

    public void setDichiarazioniFinali(String[] dichiarazioniFinali) {
        this.dichiarazioniFinali = dichiarazioniFinali;
    }

    public Boolean getMySanita() {
        return mySanita;
    }

    public void setMySanita(Boolean mySanita) {
        this.mySanita = mySanita;
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
        if (!(object instanceof RichiestaSmartWorking)) {
            return false;
        }
        RichiestaSmartWorking other = (RichiestaSmartWorking) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "it.bologna.ausl.model.entities.scrivania.RichiestaSmartWorking[ id=" + id + " ]";
    }
    
}
