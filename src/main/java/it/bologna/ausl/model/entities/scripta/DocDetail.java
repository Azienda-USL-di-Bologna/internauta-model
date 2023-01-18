package it.bologna.ausl.model.entities.scripta;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.vladmihalcea.hibernate.type.json.JsonBinaryType;
import it.bologna.ausl.internauta.utils.jpa.tools.GenericArrayUserType;
import it.bologna.ausl.model.entities.baborg.Azienda;
import it.bologna.ausl.model.entities.baborg.Pec;
import it.bologna.ausl.model.entities.baborg.Persona;
import it.bologna.ausl.model.entities.baborg.Struttura;
import it.bologna.ausl.model.entities.configurazione.Applicazione;
import it.bologna.ausl.model.entities.rubrica.Contatto;
import it.bologna.ausl.model.entities.versatore.Versamento;
import it.nextsw.common.annotations.GenerateProjections;
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
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.persistence.Version;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.Formula;
import org.hibernate.annotations.Parameter;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;
import org.springframework.format.annotation.DateTimeFormat;

/**
 *
 * @author gusgus
 */
@TypeDefs({
    @TypeDef(name = "jsonb", typeClass = JsonBinaryType.class)
})
@Entity
@Table(name = "docs_details", catalog = "internauta", schema = "scripta")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Cacheable(false)
@GenerateProjections({
    "idAzienda,idPersonaResponsabileProcedimento,idPersonaRedattrice,idStrutturaRegistrazione,idApplicazione,archiviDocList"
})
@DynamicUpdate
public class DocDetail implements Serializable, DocDetailInterface {


    
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;

    @JoinColumn(name = "id_azienda", referencedColumnName = "id")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Azienda idAzienda;

    @Size(max = 2147483647)
    @Column(name = "guid_documento")
    private String guidDocumento;

    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2147483647)
    @Column(name = "tipologia")
    private String tipologia;

    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2147483647)
    @Column(name = "open_command")
    private String openCommand;

    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2147483647)
    @Column(name = "command_type")
    private String commandType;

    @JoinColumn(name = "id_persona_responsabile_procedimento", referencedColumnName = "id")
    @ManyToOne(optional = true, fetch = FetchType.LAZY)
    private Persona idPersonaResponsabileProcedimento;

    @JoinColumn(name = "id_persona_redattrice", referencedColumnName = "id")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Persona idPersonaRedattrice;

    @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss.SSSSSSXXX'['VV']'")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss.SSSSSSXXX'['VV']'")
    @Column(name = "data_creazione")
    @Basic(optional = false)
    @NotNull
    private ZonedDateTime dataCreazione;

    @Column(name = "numero_proposta")
    private Integer numeroProposta;

    @Column(name = "anno_proposta")
    private Integer annoProposta;

    @JoinColumn(name = "id_struttura_registrazione", referencedColumnName = "id")
    @ManyToOne(fetch = FetchType.LAZY, cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    @JsonBackReference(value = "idStrutturaRegistrazione")
    private Struttura idStrutturaRegistrazione;

    @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss.SSSSSSXXX'['VV']'")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss.SSSSSSXXX'['VV']'")
    @Column(name = "data_registrazione")
    private ZonedDateTime dataRegistrazione;

    @Column(name = "numero_registrazione")
    private Integer numeroRegistrazione;

    @Column(name = "anno_registrazione")
    private Integer annoRegistrazione;

    @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss.SSSSSSXXX'['VV']'")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss.SSSSSSXXX'['VV']'")
    @Column(name = "data_pubblicazione")
    private ZonedDateTime dataPubblicazione;

    @Size(max = 2147483647)
    @Column(name = "oggetto")
    private String oggetto;

    @Column(name = "oggetto_tscol", columnDefinition = "tsvector")
    private String oggettoTscol;

    @Formula("(select ts_rank(oggetto_tscol, to_tsquery('italian',$${oggetto_tscol.PLACEHOLDER_TS_RANK}$$), 8 | 1))")
    private Double rankingOggetto;

    @Type(type = "jsonb")
    @Column(name = "firmatari", columnDefinition = "jsonb")
    private List<JsonNode> firmatari;

//    @Column(name = "firmatari_tscol", columnDefinition = "tsvector")
//    private String firmatariTscol;
    @Type(type = "jsonb")
    @Column(name = "destinatari", columnDefinition = "jsonb")
    private List<Destinatario> destinatari;

    @Column(name = "destinatari_tscol", columnDefinition = "tsvector")
    private String destinatariTscol;

    @Formula("(select ts_rank(destinatari_tscol, to_tsquery('italian',$${destinatari_tscol.PLACEHOLDER_TS_RANK}$$), 8 | 1))")
    private Double rankingDestinatari;

//    @Type(type = "jsonb")
//    @Column(name = "fascicolazioni", columnDefinition = "jsonb")
//    private List<Fascicolazione> fascicolazioni;

//    @Column(name = "fascicolazioni_tscol", columnDefinition = "tsvector")
//    private String fascicolazioniTscol;
//
//    @Formula("(select ts_rank(fascicolazioni_tscol, to_tsquery('italian',$${fascicolazioni_tscol.PLACEHOLDER_TS_RANK}$$), 8 | 1))")
//    private Double rankingFascicolazioni;
//
//    @Type(type = "jsonb")
//    @Column(name = "classificazioni", columnDefinition = "jsonb")
//    private List<Classificazione> classificazioni;

    @Size(max = 2147483647)
    @Column(name = "stato")
    private String stato;

    @Column(name = "visibilita_limitata")
    private Boolean visibilitaLimitata;

    @Column(name = "riservato")
    private Boolean riservato;

    @Column(name = "annullato")
    private Boolean annullato;

    @Size(max = 2147483647)
    @Column(name = "protocollo_esterno")
    private String protocolloEsterno;

    @Size(max = 2147483647)
    @Column(name = "mittente")
    private String mittente;

    @Column(name = "mittente_tscol", columnDefinition = "tsvector")
    private String mittenteTscol;

    @Formula("(select ts_rank(mittente_tscol, to_tsquery('italian',$${mittente_tscol.PLACEHOLDER_TS_RANK}$$), 8 | 1))")
    private Double rankingMittente;

    @JoinColumn(name = "id_mezzo_ricezione", referencedColumnName = "id")
    @ManyToOne(optional = true, fetch = FetchType.LAZY)
    private Mezzo idMezzoRicezione;

    @Size(max = 2147483647)
    @Column(name = "mail_collegio")
    private String mailCollegio;

    @Size(max = 2147483647)
    @Column(name = "stato_ufficio_atti")
    private String statoUfficioAtti;

    @Column(name = "tscol", columnDefinition = "tsvector")
    private String tscol;

    @Formula("(select ts_rank(tscol, to_tsquery('italian',$${tscol.PLACEHOLDER_TS_RANK}$$), 8 | 1))")
    private Double ranking;
    
    @Column(name = "conservazione")
    private Boolean conservazione;
    
    @Column(name = "stato_ultimo_versamento")
    private String statoUltimoVersamento;
    
    @Column(name = "stato_versamento_visto")
    private Boolean statoVersamentoVisto;
    
    @Column(name = "versamento_forzabile")
    @NotNull
    @Basic(optional = false)
    private Boolean versamentoForzabile = false;
    
    @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss.SSSSSSXXX'['VV']'")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss.SSSSSSXXX'['VV']'")
    @Column(name = "data_ultimo_versamento")
    private ZonedDateTime dataUltimoVersamento;

//    @Type(type = "jsonb")
//    @Column(name = "persone_vedenti", columnDefinition = "jsonb")
//    private List<JsonNode> personeVedenti;
    //@JsonBackReference(value = "personeVedentiList")
    @OneToMany(mappedBy = "idDocDetail", fetch = FetchType.LAZY, cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    @JsonBackReference(value = "personeVedentiList")
    private List<PersonaVedente> personeVedentiList;

    @Column(name = "id_strutture_segreteria", columnDefinition = "integer[]")
    @Type(type = "array", parameters = @Parameter(name = "elements-type", value = GenericArrayUserType.INTEGER_ELEMENT_TYPE))
    private Integer[] idStruttureSegreteria;

    @Column(name = "sulla_scrivania_di", columnDefinition = "jsonb")
    @Type(type = "jsonb")
    private List<JsonNode> sullaScrivaniaDi;

    @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss.SSSSSSXXX'['VV']'")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss.SSSSSSXXX'['VV']'")
    @Column(name = "data_inserimento_riga")
    @Basic(optional = false)
    @NotNull
    private ZonedDateTime dataInserimentoRiga = ZonedDateTime.now();

    @Version()
    @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss.SSSSSSXXX'['VV']'")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss.SSSSSSXXX'['VV']'")
    private ZonedDateTime version;

    @JoinColumn(name = "id_applicazione", referencedColumnName = "id")
    @ManyToOne(fetch = FetchType.LAZY, cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    @JsonBackReference(value = "idApplicazione")
    private Applicazione idApplicazione;
    
//    @Type(type = "jsonb")
//    @Column(name = "archiviazioni", columnDefinition = "jsonb")
//    private List<Archiviazione> archiviazioni;
    
    @Column(name = "id_archivi_antenati", columnDefinition = "integer[]")
    @Type(type = "array", parameters = @Parameter(name = "elements-type", value = GenericArrayUserType.INTEGER_ELEMENT_TYPE))
    private Integer[] idArchiviAntenati;
    
    @Column(name = "id_archivi", columnDefinition = "integer[]")
    @Type(type = "array", parameters = @Parameter(name = "elements-type", value = GenericArrayUserType.INTEGER_ELEMENT_TYPE))
    private Integer[] idArchivi;
    
    @OneToMany(cascade = {CascadeType.MERGE, CascadeType.PERSIST}, mappedBy = "idDoc", fetch = FetchType.LAZY)
    @JsonBackReference(value = "archiviDocList")
    private List<ArchivioDoc> archiviDocList;
    
    @JoinColumn(name = "id_pec_mittente", referencedColumnName = "id")
    @ManyToOne(fetch = FetchType.LAZY, cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    @JsonBackReference(value = "idPecMittente")
    private Pec idPecMittente;
    
    @JoinColumn(name = "id_contatto_mittente", referencedColumnName = "id")
    @ManyToOne(fetch = FetchType.LAZY, cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    @JsonBackReference(value = "idContattoMittente")
    private Contatto idContattoMittente;
   
    // Proprietà transient
    @Transient
    private String urlComplete;

    public DocDetail() {
    }

    public DocDetail(Integer id) {
        this.id = id;
    }

    public DocDetail(Integer id, Azienda idAzienda, String tipologia, String openCommand, String commandType, ZonedDateTime dataCreazione, ZonedDateTime dataInserimentoRiga, ZonedDateTime version) {
        this.id = id;
        this.idAzienda = idAzienda;
        this.tipologia = tipologia;
        this.openCommand = openCommand;
        this.commandType = commandType;
        this.dataCreazione = dataCreazione;
        this.dataInserimentoRiga = dataInserimentoRiga;
        this.version = version;
    }

    @Override
    public Integer getId() {
        return id;
    }

    @Override
    public void setId(Integer id) {
        this.id = id;
    }

    @Override
    public Azienda getIdAzienda() {
        return idAzienda;
    }

    @Override
    public void setIdAzienda(Azienda idAzienda) {
        this.idAzienda = idAzienda;
    }

    @Override
    public String getGuidDocumento() {
        return guidDocumento;
    }

    @Override
    public void setGuidDocumento(String guidDocumento) {
        this.guidDocumento = guidDocumento;
    }

    @Override
    public TipologiaDoc getTipologia() {
        if (tipologia != null) {
            return TipologiaDoc.valueOf(tipologia);
        } else {
            return null;
        }
    }

    @Override
    public void setTipologia(TipologiaDoc tipologia) {
        if (tipologia != null) {
            this.tipologia = tipologia.toString();
        } else {
            this.tipologia = null;
        }
    }

    @Override
    public String getOpenCommand() {
        return openCommand;
    }

    @Override
    public void setOpenCommand(String openCommand) {
        this.openCommand = openCommand;
    }

    @Override
    public CommandType getCommandType() {
        if (commandType != null) {
            return CommandType.valueOf(commandType);
        } else {
            return null;
        }
    }

    @Override
    public void setCommandType(CommandType commandType) {
        if (commandType != null) {
            this.commandType = commandType.toString();
        } else {
            this.commandType = null;
        }
    }

    @Override
    public Persona getIdPersonaResponsabileProcedimento() {
        return idPersonaResponsabileProcedimento;
    }

    @Override
    public void setIdPersonaResponsabileProcedimento(Persona idPersonaResponsabileProcedimento) {
        this.idPersonaResponsabileProcedimento = idPersonaResponsabileProcedimento;
    }

    @Override
    public Persona getIdPersonaRedattrice() {
        return idPersonaRedattrice;
    }

    @Override
    public void setIdPersonaRedattrice(Persona idPersonaRedattrice) {
        this.idPersonaRedattrice = idPersonaRedattrice;
    }

    @Override
    public ZonedDateTime getDataCreazione() {
        return dataCreazione;
    }

    @Override
    public void setDataCreazione(ZonedDateTime dataCreazione) {
        this.dataCreazione = dataCreazione;
    }

    public Boolean getConservazione() {
        return conservazione;
    }

    public void setConservazione(Boolean conservazione) {
        this.conservazione = conservazione;
    }

    @Override
    public Integer getNumeroProposta() {
        return numeroProposta;
    }

    @Override
    public void setNumeroProposta(Integer numeroProposta) {
        this.numeroProposta = numeroProposta;
    }

    @Override
    public Integer getAnnoProposta() {
        return annoProposta;
    }

    @Override
    public void setAnnoProposta(Integer annoProposta) {
        this.annoProposta = annoProposta;
    }

    @Override
    public Struttura getIdStrutturaRegistrazione() {
        return idStrutturaRegistrazione;
    }

    @Override
    public void setIdStrutturaRegistrazione(Struttura idStrutturaRegistrazione) {
        this.idStrutturaRegistrazione = idStrutturaRegistrazione;
    }

    @Override
    public ZonedDateTime getDataRegistrazione() {
        return dataRegistrazione;
    }

    @Override
    public void setDataRegistrazione(ZonedDateTime dataRegistrazione) {
        this.dataRegistrazione = dataRegistrazione;
    }

    @Override
    public Integer getNumeroRegistrazione() {
        return numeroRegistrazione;
    }

    @Override
    public void setNumeroRegistrazione(Integer numeroRegistrazione) {
        this.numeroRegistrazione = numeroRegistrazione;
    }

    @Override
    public Integer getAnnoRegistrazione() {
        return annoRegistrazione;
    }

    @Override
    public void setAnnoRegistrazione(Integer annoRegistrazione) {
        this.annoRegistrazione = annoRegistrazione;
    }

    @Override
    public ZonedDateTime getDataPubblicazione() {
        return dataPubblicazione;
    }

    @Override
    public void setDataPubblicazione(ZonedDateTime dataPubblicazione) {
        this.dataPubblicazione = dataPubblicazione;
    }

    @Override
    public String getOggetto() {
        return oggetto;
    }

    @Override
    public void setOggetto(String oggetto) {
        this.oggetto = oggetto;
    }

    @Override
    public String getOggettoTscol() {
        return oggettoTscol;
    }

    @Override
    public void setOggettoTscol(String oggettoTscol) {
        this.oggettoTscol = oggettoTscol;
    }

    @Override
    public List<Firmatario> getFirmatari() {
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.convertValue(firmatari, new TypeReference<List<DocDetail.Firmatario>>() {
        });
    }

    @Override
    public void setFirmatari(List<Firmatario> firmatari) {
        this.firmatari = (List<JsonNode>) (Object) firmatari;
    }

//    public String getFirmatariTscol() {
//        return firmatariTscol;
//    }
//
//    public void setFirmatariTscol(String firmatariTscol) {
//        this.firmatariTscol = firmatariTscol;
//    }
    @Override
    public List<Destinatario> getDestinatari() {
        return destinatari;
    }

    @Override
    public void setDestinatari(List<Destinatario> destinatari) {
        this.destinatari = destinatari;
    }

    @Override
    public String getDestinatariTscol() {
        return destinatariTscol;
    }

    @Override
    public void setDestinatariTscol(String destinatariTscol) {
        this.destinatariTscol = destinatariTscol;
    }

//    @Override
//    public List<Fascicolazione> getFascicolazioni() {
//        return fascicolazioni;
//    }
//
//    @Override
//    public void setFascicolazioni(List<Fascicolazione> fascicolazioni) {
//        this.fascicolazioni = fascicolazioni;
//    }
//
//    @Override
//    public String getFascicolazioniTscol() {
//        return fascicolazioniTscol;
//    }
//
//    @Override
//    public void setFascicolazioniTscol(String fascicolazioniTscol) {
//        this.fascicolazioniTscol = fascicolazioniTscol;
//    }
//
//    @Override
//    public List<Classificazione> getClassificazioni() {
//        return classificazioni;
//    }
//
//    @Override
//    public void setClassificazioni(List<Classificazione> classificazioni) {
//        this.classificazioni = classificazioni;
//    }

    @Override
    public StatoDoc getStato() {
        if (stato != null) {
            return StatoDoc.valueOf(stato);
        } else {
            return null;
        }
    }

    @Override
    public void setStato(StatoDoc stato) {
        if (stato != null) {
            this.stato = stato.toString();
        } else {
            this.stato = null;
        }
    }

    @Override
    public Boolean getVisibilitaLimitata() {
        return visibilitaLimitata;
    }

    @Override
    public void setVisibilitaLimitata(Boolean visibilitaLimitata) {
        this.visibilitaLimitata = visibilitaLimitata;
    }

    @Override
    public Boolean getRiservato() {
        return riservato;
    }

    @Override
    public void setRiservato(Boolean riservato) {
        this.riservato = riservato;
    }

    @Override
    public Boolean getAnnullato() {
        return annullato;
    }

    @Override
    public void setAnnullato(Boolean annullato) {
        this.annullato = annullato;
    }

    @Override
    public String getProtocolloEsterno() {
        return protocolloEsterno;
    }

    @Override
    public void setProtocolloEsterno(String protocolloEsterno) {
        this.protocolloEsterno = protocolloEsterno;
    }

    @Override
    public String getMittente() {
        return mittente;
    }

    @Override
    public void setMittente(String mittente) {
        this.mittente = mittente;
    }

    @Override
    public String getMittenteTscol() {
        return mittenteTscol;
    }

    @Override
    public void setMittenteTscol(String mittenteTscol) {
        this.mittenteTscol = mittenteTscol;
    }

    @Override
    public Mezzo getIdMezzoRicezione() {
        return idMezzoRicezione;
    }

    @Override
    public void setIdMezzoRicezione(Mezzo idMezzoRicezione) {
        this.idMezzoRicezione = idMezzoRicezione;
    }

    @Override
    public String getMailCollegio() {
        return mailCollegio;
    }

    @Override
    public void setMailCollegio(String mailCollegio) {
        this.mailCollegio = mailCollegio;
    }

    @Override
    public StatoUfficioAtti getStatoUfficioAtti() {
        if (statoUfficioAtti != null) {
            return StatoUfficioAtti.valueOf(statoUfficioAtti);
        } else {
            return null;
        }
    }

    @Override
    public void setStatoUfficioAtti(StatoUfficioAtti statoUfficioAtti) {
        if (statoUfficioAtti != null) {
            this.statoUfficioAtti = statoUfficioAtti.toString();
        } else {
            this.statoUfficioAtti = null;
        }
    }

    @Override
    public String getTscol() {
        return tscol;
    }

    @Override
    public void setTscol(String tscol) {
        this.tscol = tscol;
    }

//    public List<PersonaVedente> getPersoneVedenti() {
//        ObjectMapper objectMapper = new ObjectMapper();
//        return objectMapper.convertValue(personeVedenti, new TypeReference<List<DocList.PersonaVedente>>() {
//        });
//    }
//
//    public void setPersoneVedenti(List<PersonaVedente> personeVedenti) {
//        this.personeVedenti = (List<JsonNode>) (Object) personeVedenti;
//    }
    @Override
    public List<PersonaVedente> getPersoneVedentiList() {
        return personeVedentiList;
    }

    @Override
    public void setPersoneVedentiList(List<PersonaVedente> personeVedentiList) {
        this.personeVedentiList = personeVedentiList;
    }

    @Override
    public List<PersonaUsante> getSullaScrivaniaDi() {
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.convertValue(sullaScrivaniaDi, new TypeReference<List<DocDetail.PersonaUsante>>() {
        });
    }

    @Override
    public void setSullaScrivaniaDi(List<PersonaUsante> sullaScrivaniaDi) {
        this.sullaScrivaniaDi = (List<JsonNode>) (Object) sullaScrivaniaDi;
    }

    @Override
    public Integer[] getIdStruttureSegreteria() {
        return idStruttureSegreteria;
    }

    @Override
    public void setIdStruttureSegreteria(Integer[] idStruttureSegreteria) {
        this.idStruttureSegreteria = idStruttureSegreteria;
    }

    @Override
    public ZonedDateTime getDataInserimentoRiga() {
        return dataInserimentoRiga;
    }

    @Override
    public void setDataInserimentoRiga(ZonedDateTime dataInserimentoRiga) {
        this.dataInserimentoRiga = dataInserimentoRiga;
    }

    @Override
    public ZonedDateTime getVersion() {
        return version;
    }

    @Override
    public void setVersion(ZonedDateTime version) {
        this.version = version;
    }

    @Override
    public Double getRankingOggetto() {
        return rankingOggetto;
    }

    @Override
    public void setRankingOggetto(Double rankingOggetto) {
        this.rankingOggetto = rankingOggetto;
    }

    @Override
    public Double getRankingDestinatari() {
        return rankingDestinatari;
    }

    @Override
    public void setRankingDestinatari(Double rankingDestinatari) {
        this.rankingDestinatari = rankingDestinatari;
    }

//    @Override
//    public Double getRankingFascicolazioni() {
//        return rankingFascicolazioni;
//    }
//
//    @Override
//    public void setRankingFascicolazioni(Double rankingFascicolazioni) {
//        this.rankingFascicolazioni = rankingFascicolazioni;
//    }

    @Override
    public Double getRankingMittente() {
        return rankingMittente;
    }

    @Override
    public void setRankingMittente(Double rankingMittente) {
        this.rankingMittente = rankingMittente;
    }

    @Override
    public Double getRanking() {
        return ranking;
    }

    @Override
    public void setRanking(Double ranking) {
        this.ranking = ranking;
    }

    @Override
    public String getUrlComplete() {
        return urlComplete;
    }

    @Override
    public void setUrlComplete(String urlComplete) {
        this.urlComplete = urlComplete;
    }
    
//    @Override
//    public List<Archiviazione> getArchiviazioni() {
//        return archiviazioni;
//    }
//
//    @Override
//    public void setArchiviazioni(List<Archiviazione> archiviazioni) {
//        this.archiviazioni = archiviazioni;
//    }

    @Override
    public Integer[] getIdArchiviAntenati() {
        return idArchiviAntenati;
    }

    @Override
    public void setIdArchiviAntenati(Integer[] idArchiviAntenati) {
        this.idArchiviAntenati = idArchiviAntenati;
    }
    
    @Override
    public Integer[] getIdArchivi() {
        return idArchivi;
    }
    
    @Override
    public void setIdArchivi(Integer[] idArchivi) {
        this.idArchivi = idArchivi;
    }
    
    @Override
    public List<ArchivioDoc> getArchiviDocList() {
        return archiviDocList;
    }

    @Override
    public void setArchiviDocList(List<ArchivioDoc> archiviDocList) {
        this.archiviDocList = archiviDocList;
    }

    @Override
    public Boolean getStatoVersamentoVisto() {
        return statoVersamentoVisto;
    }

    @Override
    public void setStatoVersamentoVisto(Boolean statoVersamentoVisto) {
        this.statoVersamentoVisto = statoVersamentoVisto;
    }

    @Override
    public Versamento.StatoVersamento getStatoUltimoVersamento() {
        if (statoUltimoVersamento != null) {
            return Versamento.StatoVersamento.valueOf(statoUltimoVersamento);
        } else {
            return null;
        }
    }

    @Override
    public void setStatoUltimoVersamento(Versamento.StatoVersamento statoUltimoVersamento) {
        if (statoUltimoVersamento != null) {
            this.statoUltimoVersamento = statoUltimoVersamento.toString();
        } else {
            this.statoUltimoVersamento = null;
        }
    }
    
    @Override
    public ZonedDateTime getDataUltimoVersamento() {
        return dataUltimoVersamento;
    }

    @Override
    public void setDataUltimoVersamento(ZonedDateTime dataUltimoVersamento) {
        this.dataUltimoVersamento = dataUltimoVersamento;
    }

    @Override
    public Boolean getVersamentoForzabile() {
        return versamentoForzabile;
    }

    @Override
    public void setVersamentoForzabile(Boolean versamentoForzabile) {
        this.versamentoForzabile = versamentoForzabile;
    }

    @Override
    public Applicazione getIdApplicazione() {
        return idApplicazione;
    }

    @Override
    public void setIdApplicazione(Applicazione idApplicazione) {
        this.idApplicazione = idApplicazione;
    }

    public Pec getIdPecMittente() {
        return idPecMittente;
    }

    public void setIdPecMittente(Pec idPecMittente) {
        this.idPecMittente = idPecMittente;
    }

    public Contatto getIdContattoMittente() {
        return idContattoMittente;
    }

    public void setIdContattoMittente(Contatto idContattoMittente) {
        this.idContattoMittente = idContattoMittente;
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
        if (!(object instanceof DocDetail)) {
            return false;
        }
        DocDetail other = (DocDetail) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "it.bologna.ausl.model.entities.scripta.DocsList[ id=" + id + " ]";
    }
}
