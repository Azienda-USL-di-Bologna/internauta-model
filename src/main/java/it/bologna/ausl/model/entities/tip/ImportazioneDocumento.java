package it.bologna.ausl.model.entities.tip;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import it.bologna.ausl.model.entities.tip.data.TipErroriImportazione;
import it.nextsw.common.annotations.GenerateProjections;
import java.io.Serializable;
import java.time.ZonedDateTime;
import javax.persistence.Basic;
import javax.persistence.Cacheable;
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
import javax.persistence.Table;
import javax.persistence.Version;
import javax.validation.constraints.NotNull;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.Type;
import org.springframework.format.annotation.DateTimeFormat;

/**
 *
 * @author gdm
 */
@Entity
@Table(name = "importazioni_documenti", catalog = "internauta", schema = "tip")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Cacheable(false)
@GenerateProjections()
@DynamicUpdate
public class ImportazioneDocumento implements Serializable, ImportazioneOggetto {
    
    private static final long serialVersionUID = 1L;

    public static final String FORMATO_DATA = "dd/MM/yyyy";
    public static final String DEFAULT_STRING_SEPARATOR = "#";
    public static final String DEFAULT_ATTORE_SEPARATOR = ":";
    public static final String REGEX_PREFISSI_ALLEGATI = "VER__\\d+__|RIC_ACC__|RIC_CONS__|RIC_ERR__|ALL_INT__";
        
    public static final String MINIO_DOCS_ROOT_PATH = "tip";
    
    public static enum PrefissiAllegati {
        VER__, RIC_ACC__, RIC_CONS__, RIC_ERR__, ALL_INT__
    }
    
    public static enum StatiImportazioneDocumento {
        VALIDARE,
        IMPORTARE,
        ANOMALIA_VALIDAZIONE,
        ANOMALIA_IMPORTAZIONE,
        IMPORTATO,
        GIA_IMPORTATO,
        ERRORE_VALIDAZIONE,
        ERRORE_IMPORTAZIONE
    }
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Long id;

    @Basic(optional = true)
    @Column(name = "data_registrazione")
    private String dataRegistrazione;

    @Basic(optional = true)
    @Column(name = "data_arrivo")
    private String dataArrivo;

    @Basic(optional = true)
    @Column(name = "data_adozione")
    private String dataAdozione;

    @Basic(optional = true)
    @Column(name = "destinatari_interni")
    private String destinatariInterni;

    @Basic(optional = true)
    @Column(name = "destinatari_interni_a")
    private String destinatariInterniA;

    @Basic(optional = true)
    @Column(name = "destinatari_interni_cc")
    private String destinatariInterniCC;

    @Basic(optional = true)
    @Column(name = "indirizzi_destinatari_principali")
    private String indirizziDestinatariPrincipali;

    @Basic(optional = true)
    @Column(name = "destinatari_principali")
    private String destinatariPrincipali;

    @Basic(optional = true)
    @Column(name = "descrizione_indirizzi_principali")
    private String descrizioneIndirizziPrincipali;

    @Basic(optional = true)
    @Column(name = "indirizzi_altri_destinatari")
    private String indirizziAltriDestinatari;

    @Basic(optional = true)
    @Column(name = "altri_destinatari")
    private String altriDestinatari;

    @Basic(optional = true)
    @Column(name = "descrizione_altri_indirizzi")
    private String descrizioneAltriIndirizzi;

    @Basic(optional = true)
    @Column(name = "indirizzi_destinatari_esterni")
    private String indirizziDestinatariEsterni;

    @Basic(optional = true)
    @Column(name = "nomi_destinatari_esterni")
    private String nomiDestinatariEsterni;

    @Basic(optional = true)
    @Column(name = "adottato_da")
    private String adottatoDa;

    @Basic(optional = true)
    @Column(name = "direttore_generale")
    private String direttoreGenerale;

    @Basic(optional = true)
    @Column(name = "vicario_direttore_generale")
    private String vicarioDirettoreGenerale;

    @Basic(optional = true)
    @Column(name = "direttore_sanitario")
    private String direttoreSanitario;

    @Basic(optional = true)
    @Column(name = "direttore_amministrativo")
    private String direttoreAmministrativo;

    @Basic(optional = true)
    @Column(name = "proposto_da")
    private String propostoDa;

    @Basic(optional = true)
    @Column(name = "protocollato_da")
    private String protocollatoDa;

    @Basic(optional = true)
    @Column(name = "protocollo_esterno")
    private String protocolloEsterno;

    @Basic(optional = true)
    @Column(name = "data_protocollo_esterno")
    private String dataProtocolloEsterno;

    @Basic(optional = true)
    @Column(name = "pec_mittente")
    private String pecMittente;

    @Basic(optional = true)
    @Column(name = "indirizzo_mittente")
    private String indirizzoMittente;

    @Basic(optional = true)
    @Column(name = "visibilita_limitata")
    private String visibilitaLimitata;

    @Basic(optional = true)
    @Column(name = "numero_pubblicazione")
    private String numeroPubblicazione;

    @Basic(optional = true)
    @Column(name = "data_inizio")
    private String dataInizio;

    @Basic(optional = true)
    @Column(name = "data_fine")
    private String dataFine;

    @Basic(optional = true)
    @Column(name = "anno_pubblicazione")
    private String annoPubblicazione;

    @Basic(optional = true)
    @Column(name = "data_esecutivita")
    private String dataEsecutivita;

    @Basic(optional = true)
    @Column(name = "controllo_regionale")
    private String controlloRegionale;

    @Basic(optional = true)
    @Column(name = "collegamento_precedente")
    private String collegamentoPrecedente;

    @Basic(optional = true)
    @Column(name = "note_annullamento")
    private String noteAnnullamento;

    @Basic(optional = true)
    @Column(name = "data_annullamento")
    private String dataAnnullamento;

    @Basic(optional = true)
    @Column(name = "data_invio_conservazione")
    private String dataInvioConservazione;

    @Basic(optional = true)
    @Column(name = "struttura_visibilita")
    private String strutturaVisibilita;

    @Basic(optional = true)
    @Column(name = "registro")
    private String registro;
    
    @Basic(optional = true)
    @Column(name = "numero")
    private String numero;

    @Basic(optional = true)
    @Column(name = "anno")
    private String anno;

    @Basic(optional = true)
    @Column(name = "oggetto")
    private String oggetto;

    @Basic(optional = true)
    @Column(name = "proponente")
    private String proponente;

    @Basic(optional = true)
    @Column(name = "mittente")
    private String mittente;

    @Basic(optional = true)
    @Column(name = "mezzo")
    private String mezzo;

    @Basic(optional = true)
    @Column(name = "firmatari")
    private String firmatari;

    @Basic(optional = true)
    @Column(name = "firmatario")
    private String firmatario;

    @Basic(optional = true)
    @Column(name = "pareri")
    private String pareri;

    @Basic(optional = true)
    @Column(name = "redattore")
    private String redattore;

    @Basic(optional = true)
    @Column(name = "visto")
    private String visto;

    @Basic(optional = true)
    @Column(name = "id_fascicolo_pregresso")
    private String idFascicoloPregresso;
    
    @Basic(optional = true)
    @Column(name = "fascicolazione")
    private String fascicolazione;

    @Basic(optional = true)
    @Column(name = "classificazione")
    private String classificazione;

    @Basic(optional = true)
    @Column(name = "riservato")
    private String riservato;

    @Basic(optional = true)
    @Column(name = "allegati")
    private String allegati;

    @Basic(optional = true)
    @Column(name = "annotazioni")
    private String annotazioni;

    @Basic(optional = true)
    @Column(name = "conservato")
    private String conservato;

    @Basic(optional = true)
    @Column(name = "note")
    private String note;

    @Basic(optional = true)
    @Column(name = "annullato")
    private String annullato;
        
    @Basic(optional = true)
    @Column(name = "id_repo_csv")
    private String idRepoCsv;
    
    @Basic(optional = false)
    @Column(name = "files_importati")
    @NotNull
    private Boolean filesImportati = false;
    
    @Basic(optional = false)
    @Column(name = "stato")
    @Enumerated(EnumType.STRING)
    private StatiImportazioneDocumento stato;
    
    @JoinColumn(name = "id_sessione_importazioni", referencedColumnName = "id")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private SessioneImportazione idSessioneImportazione;
    
    @Basic(optional = true)
    @Type(type = "jsonb")
    @Column(name = "errori", columnDefinition = "jsonb")
    private TipErroriImportazione errori;
    
    @Version()
    @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss.SSSSSSXXX'['VV']'")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss.SSSSSSXXX'['VV']'")
    private ZonedDateTime version;

    public ImportazioneDocumento() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDataRegistrazione() {
        return dataRegistrazione;
    }

    public void setDataRegistrazione(String dataRegistrazione) {
        this.dataRegistrazione = dataRegistrazione;
    }

    public String getDataArrivo() {
        return dataArrivo;
    }

    public void setDataArrivo(String dataArrivo) {
        this.dataArrivo = dataArrivo;
    }

    public String getDataAdozione() {
        return dataAdozione;
    }

    public void setDataAdozione(String dataAdozione) {
        this.dataAdozione = dataAdozione;
    }

    public String getDestinatariInterni() {
        return destinatariInterni;
    }

    public void setDestinatariInterni(String destinatariInterni) {
        this.destinatariInterni = destinatariInterni;
    }

    public String getDestinatariInterniA() {
        return destinatariInterniA;
    }

    public void setDestinatariInterniA(String destinatariInterniA) {
        this.destinatariInterniA = destinatariInterniA;
    }

    public String getDestinatariInterniCC() {
        return destinatariInterniCC;
    }

    public void setDestinatariInterniCC(String destinatariInterniCC) {
        this.destinatariInterniCC = destinatariInterniCC;
    }

    public String getIndirizziDestinatariPrincipali() {
        return indirizziDestinatariPrincipali;
    }

    public void setIndirizziDestinatariPrincipali(String indirizziDestinatariPrincipali) {
        this.indirizziDestinatariPrincipali = indirizziDestinatariPrincipali;
    }

    public String getDestinatariPrincipali() {
        return destinatariPrincipali;
    }

    public void setDestinatariPrincipali(String destinatariPrincipali) {
        this.destinatariPrincipali = destinatariPrincipali;
    }

    public String getDescrizioneIndirizziPrincipali() {
        return descrizioneIndirizziPrincipali;
    }

    public void setDescrizioneIndirizziPrincipali(String descrizioneIndirizziPrincipali) {
        this.descrizioneIndirizziPrincipali = descrizioneIndirizziPrincipali;
    }

    public String getIndirizziAltriDestinatari() {
        return indirizziAltriDestinatari;
    }

    public void setIndirizziAltriDestinatari(String indirizziAltriDestinatari) {
        this.indirizziAltriDestinatari = indirizziAltriDestinatari;
    }

    public String getAltriDestinatari() {
        return altriDestinatari;
    }

    public void setAltriDestinatari(String altriDestinatari) {
        this.altriDestinatari = altriDestinatari;
    }

    public String getDescrizioneAltriIndirizzi() {
        return descrizioneAltriIndirizzi;
    }

    public void setDescrizioneAltriIndirizzi(String descrizioneAltriIndirizzi) {
        this.descrizioneAltriIndirizzi = descrizioneAltriIndirizzi;
    }

    public String getIndirizziDestinatariEsterni() {
        return indirizziDestinatariEsterni;
    }

    public void setIndirizziDestinatariEsterni(String indirizziDestinatariEsterni) {
        this.indirizziDestinatariEsterni = indirizziDestinatariEsterni;
    }

    public String getNomiDestinatariEsterni() {
        return nomiDestinatariEsterni;
    }

    public void setNomiDestinatariEsterni(String nomiDestinatariEsterni) {
        this.nomiDestinatariEsterni = nomiDestinatariEsterni;
    }

    public String getAdottatoDa() {
        return adottatoDa;
    }

    public void setAdottatoDa(String adottatoDa) {
        this.adottatoDa = adottatoDa;
    }

    public String getDirettoreGenerale() {
        return direttoreGenerale;
    }

    public void setDirettoreGenerale(String direttoreGenerale) {
        this.direttoreGenerale = direttoreGenerale;
    }

    public String getVicarioDirettoreGenerale() {
        return vicarioDirettoreGenerale;
    }

    public void setVicarioDirettoreGenerale(String vicarioDirettoreGenerale) {
        this.vicarioDirettoreGenerale = vicarioDirettoreGenerale;
    }

    public String getDirettoreSanitario() {
        return direttoreSanitario;
    }

    public void setDirettoreSanitario(String direttoreSanitario) {
        this.direttoreSanitario = direttoreSanitario;
    }

    public String getDirettoreAmministrativo() {
        return direttoreAmministrativo;
    }

    public void setDirettoreAmministrativo(String direttoreAmministrativo) {
        this.direttoreAmministrativo = direttoreAmministrativo;
    }

    public String getPropostoDa() {
        return propostoDa;
    }

    public void setPropostoDa(String propostoDa) {
        this.propostoDa = propostoDa;
    }

    public String getProtocollatoDa() {
        return protocollatoDa;
    }

    public void setProtocollatoDa(String protocollatoDa) {
        this.protocollatoDa = protocollatoDa;
    }

    public String getProtocolloEsterno() {
        return protocolloEsterno;
    }

    public void setProtocolloEsterno(String protocolloEsterno) {
        this.protocolloEsterno = protocolloEsterno;
    }

    public String getDataProtocolloEsterno() {
        return dataProtocolloEsterno;
    }

    public void setDataProtocolloEsterno(String dataProtocolloEsterno) {
        this.dataProtocolloEsterno = dataProtocolloEsterno;
    }

    public String getPecMittente() {
        return pecMittente;
    }

    public void setPecMittente(String pecMittente) {
        this.pecMittente = pecMittente;
    }

    public String getIndirizzoMittente() {
        return indirizzoMittente;
    }

    public void setIndirizzoMittente(String indirizzoMittente) {
        this.indirizzoMittente = indirizzoMittente;
    }

    public String getVisibilitaLimitata() {
        return visibilitaLimitata;
    }

    public void setVisibilitaLimitata(String visibilitaLimitata) {
        this.visibilitaLimitata = visibilitaLimitata;
    }

    public String getNumeroPubblicazione() {
        return numeroPubblicazione;
    }

    public void setNumeroPubblicazione(String numeroPubblicazione) {
        this.numeroPubblicazione = numeroPubblicazione;
    }

    public String getDataInizio() {
        return dataInizio;
    }

    public void setDataInizio(String dataInizio) {
        this.dataInizio = dataInizio;
    }

    public String getDataFine() {
        return dataFine;
    }

    public void setDataFine(String dataFine) {
        this.dataFine = dataFine;
    }

    public String getAnnoPubblicazione() {
        return annoPubblicazione;
    }

    public void setAnnoPubblicazione(String annoPubblicazione) {
        this.annoPubblicazione = annoPubblicazione;
    }

    public String getDataEsecutivita() {
        return dataEsecutivita;
    }

    public void setDataEsecutivita(String dataEsecutivita) {
        this.dataEsecutivita = dataEsecutivita;
    }

    public String getControlloRegionale() {
        return controlloRegionale;
    }

    public void setControlloRegionale(String controlloRegionale) {
        this.controlloRegionale = controlloRegionale;
    }

    public String getCollegamentoPrecedente() {
        return collegamentoPrecedente;
    }

    public void setCollegamentoPrecedente(String collegamentoPrecedente) {
        this.collegamentoPrecedente = collegamentoPrecedente;
    }

    public String getNoteAnnullamento() {
        return noteAnnullamento;
    }

    public void setNoteAnnullamento(String noteAnnullamento) {
        this.noteAnnullamento = noteAnnullamento;
    }

    public String getDataAnnullamento() {
        return dataAnnullamento;
    }

    public void setDataAnnullamento(String dataAnnullamento) {
        this.dataAnnullamento = dataAnnullamento;
    }

    public String getDataInvioConservazione() {
        return dataInvioConservazione;
    }

    public void setDataInvioConservazione(String dataInvioConservazione) {
        this.dataInvioConservazione = dataInvioConservazione;
    }

    public String getStrutturaVisibilita() {
        return strutturaVisibilita;
    }

    public void setStrutturaVisibilita(String strutturaVisibilita) {
        this.strutturaVisibilita = strutturaVisibilita;
    }

    @Override
    public String getRegistro() {
        return registro;
    }

    @Override
    public void setRegistro(String registro) {
        this.registro = registro;
    }

    @Override
    public String getNumero() {
        return numero;
    }

    @Override
    public void setNumero(String numero) {
        this.numero = numero;
    }

    @Override
    public String getAnno() {
        return anno;
    }

    @Override
    public void setAnno(String anno) {
        this.anno = anno;
    }

    public String getOggetto() {
        return oggetto;
    }

    public void setOggetto(String oggetto) {
        this.oggetto = oggetto;
    }

    public String getProponente() {
        return proponente;
    }

    public void setProponente(String proponente) {
        this.proponente = proponente;
    }

    public String getMittente() {
        return mittente;
    }

    public void setMittente(String mittente) {
        this.mittente = mittente;
    }

    public String getMezzo() {
        return mezzo;
    }

    public void setMezzo(String mezzo) {
        this.mezzo = mezzo;
    }

    public String getFirmatari() {
        return firmatari;
    }

    public void setFirmatari(String firmatari) {
        this.firmatari = firmatari;
    }

    public String getFirmatario() {
        return firmatario;
    }

    public void setFirmatario(String firmatario) {
        this.firmatario = firmatario;
    }

    public String getPareri() {
        return pareri;
    }

    public void setPareri(String pareri) {
        this.pareri = pareri;
    }

    public String getRedattore() {
        return redattore;
    }

    public void setRedattore(String redattore) {
        this.redattore = redattore;
    }

    public String getVisto() {
        return visto;
    }

    public void setVisto(String visto) {
        this.visto = visto;
    }

    public String getIdFascicoloPregresso() {
        return idFascicoloPregresso;
    }

    public void setIdFascicoloPregresso(String idFascicoloPregresso) {
        this.idFascicoloPregresso = idFascicoloPregresso;
    }

    public String getFascicolazione() {
        return fascicolazione;
    }

    public void setFascicolazione(String fascicolazione) {
        this.fascicolazione = fascicolazione;
    }

    public String getClassificazione() {
        return classificazione;
    }

    public void setClassificazione(String classificazione) {
        this.classificazione = classificazione;
    }

    public String getRiservato() {
        return riservato;
    }

    public void setRiservato(String riservato) {
        this.riservato = riservato;
    }

    public String getAllegati() {
        return allegati;
    }

    public void setAllegati(String allegati) {
        this.allegati = allegati;
    }

    public String getAnnotazioni() {
        return annotazioni;
    }

    public void setAnnotazioni(String annotazioni) {
        this.annotazioni = annotazioni;
    }

    public String getConservato() {
        return conservato;
    }

    public void setConservato(String conservato) {
        this.conservato = conservato;
    }

    @Override
    public String getNote() {
        return note;
    }

    public String getAnnullato() {
        return annullato;
    }

    public void setAnnullato(String annullato) {
        this.annullato = annullato;
    }
    
    @Override
    public void setNote(String note) {
        this.note = note;
    }

    @Override
    public String getIdRepoCsv() {
        return idRepoCsv;
    }

    @Override
    public void setIdRepoCsv(String idRepoCsv) {
        this.idRepoCsv = idRepoCsv;
    }

    public Boolean getFilesImportati() {
        return filesImportati;
    }

    public void setFilesImportati(Boolean filesImportati) {
        this.filesImportati = filesImportati;
    }

    @Override
    public SessioneImportazione getIdSessioneImportazione() {
        return idSessioneImportazione;
    }

    @Override
    public void setIdSessioneImportazione(SessioneImportazione idSessioneImportazione) {
        this.idSessioneImportazione = idSessioneImportazione;
    }

    @Override
    public StatiImportazioneDocumento getStato() {
        return stato;
    }

    @Override
    public void setStato(StatiImportazioneDocumento stato) {
        this.stato = stato;
    }

    @Override
    public TipErroriImportazione getErrori() {
        return errori;
    }

    @Override
    public void setErrori(TipErroriImportazione errori) {
        this.errori = errori;
    }
    
    public ZonedDateTime getVersion() {
        return version;
    }

    public void setVersion(ZonedDateTime version) {
        this.version = version;
    }
    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ImportazioneDocumento)) {
            return false;
        }
        ImportazioneDocumento other = (ImportazioneDocumento) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return getClass().getCanonicalName() + "[ id=" + id + " ]";
    }

}
