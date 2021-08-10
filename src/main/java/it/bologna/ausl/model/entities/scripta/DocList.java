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
import it.bologna.ausl.model.entities.baborg.Persona;
import it.bologna.ausl.model.entities.baborg.Struttura;
import it.bologna.ausl.model.entities.configuration.Applicazione;
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
@Table(name = "docs_list", catalog = "internauta", schema = "scripta")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Cacheable(false)
@GenerateProjections({
    "idAzienda,idPersonaResponsabileProcedimento,idPersonaRedattrice,idStrutturaRegistrazione,idApplicazione"
})
@DynamicUpdate
public class DocList implements Serializable {

    public static enum TipologiaDoc {
        PROTOCOLLO_IN_USCITA,
        PROTOCOLLO_IN_ENTRATA,
        DETERMINA,
        DELIBERA
    }

    public static enum CommandType {
        ROUTING,
        COMPONENT,
        URL
    }

    public static enum StatoDoc {
        REDAZIONE,
        CLASSIFICAZIONE,
        PARERE,
        VISTA,
        FIRMA,
        UFFICIO_ATTI,
        DG,
        DS,
        DA,
        DSC,
        SMISTAMENTO,
        SPEDIZIONE,
        FINE,
        NUMERAZIONE,
        REGISTRAZIONE_PROTOCOLLO,
        AVVIA_SPEDIZIONI,
        ASPETTA_SPEDIZIONI,
        ATTENDI_JOBS,
        CONTROLLO_SEGRETERIA,
        SPEDIZIONE_MANUALE
    }

    public static enum StatoUfficioAtti {
        SOSPESA,
        ELABORATA,
        DA_VALUTARE
    }

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
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
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

    @Type(type = "jsonb")
    @Column(name = "fascicolazioni", columnDefinition = "jsonb")
    private List<Fascicolazione> fascicolazioni;

    @Column(name = "fascicolazioni_tscol", columnDefinition = "tsvector")
    private String fascicolazioniTscol;

    @Formula("(select ts_rank(fascicolazioni_tscol, to_tsquery('italian',$${fascicolazioni_tscol.PLACEHOLDER_TS_RANK}$$), 8 | 1))")
    private Double rankingFascicolazioni;

    @Type(type = "jsonb")
    @Column(name = "classificazioni", columnDefinition = "jsonb")
    private List<Classificazione> classificazioni;

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

    @Type(type = "jsonb")
    @Column(name = "persone_vedenti", columnDefinition = "jsonb")
    private List<JsonNode> personeVedenti;

    @Column(name = "id_strutture_segreteria", columnDefinition = "integer[]")
    @Type(type = "array", parameters = @Parameter(name = "elements-type", value = GenericArrayUserType.INTEGER_ELEMENT_TYPE))
    private Integer[] idStruttureSegreteria;

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
    // Proprietà transient
    @Transient
    private String urlComplete;
    

    public DocList() {
    }

    public DocList(Integer id) {
        this.id = id;
    }

    public DocList(Integer id, Azienda idAzienda, String tipologia, String openCommand, String commandType, ZonedDateTime dataCreazione, ZonedDateTime dataInserimentoRiga, ZonedDateTime version) {
        this.id = id;
        this.idAzienda = idAzienda;
        this.tipologia = tipologia;
        this.openCommand = openCommand;
        this.commandType = commandType;
        this.dataCreazione = dataCreazione;
        this.dataInserimentoRiga = dataInserimentoRiga;
        this.version = version;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Azienda getIdAzienda() {
        return idAzienda;
    }

    public void setIdAzienda(Azienda idAzienda) {
        this.idAzienda = idAzienda;
    }

    public String getGuidDocumento() {
        return guidDocumento;
    }

    public void setGuidDocumento(String guidDocumento) {
        this.guidDocumento = guidDocumento;
    }

    public TipologiaDoc getTipologia() {
        if (tipologia != null) {
            return TipologiaDoc.valueOf(tipologia);
        } else {
            return null;
        }
    }

    public void setTipologia(TipologiaDoc tipologia) {
        if (tipologia != null) {
            this.tipologia = tipologia.toString();
        } else {
            this.tipologia = null;
        }
    }

    public String getOpenCommand() {
        return openCommand;
    }

    public void setOpenCommand(String openCommand) {
        this.openCommand = openCommand;
    }

    public CommandType getCommandType() {
        if (commandType != null) {
            return CommandType.valueOf(commandType);
        } else {
            return null;
        }
    }

    public void setCommandType(CommandType commandType) {
        if (commandType != null) {
            this.commandType = commandType.toString();
        } else {
            this.commandType = null;
        }
    }

    public Persona getIdPersonaResponsabileProcedimento() {
        return idPersonaResponsabileProcedimento;
    }

    public void setIdPersonaResponsabileProcedimento(Persona idPersonaResponsabileProcedimento) {
        this.idPersonaResponsabileProcedimento = idPersonaResponsabileProcedimento;
    }

    public Persona getIdPersonaRedattrice() {
        return idPersonaRedattrice;
    }

    public void setIdPersonaRedattrice(Persona idPersonaRedattrice) {
        this.idPersonaRedattrice = idPersonaRedattrice;
    }

    public ZonedDateTime getDataCreazione() {
        return dataCreazione;
    }

    public void setDataCreazione(ZonedDateTime dataCreazione) {
        this.dataCreazione = dataCreazione;
    }

    public Integer getNumeroProposta() {
        return numeroProposta;
    }

    public void setNumeroProposta(Integer numeroProposta) {
        this.numeroProposta = numeroProposta;
    }

    public Integer getAnnoProposta() {
        return annoProposta;
    }

    public void setAnnoProposta(Integer annoProposta) {
        this.annoProposta = annoProposta;
    }

    public Struttura getIdStrutturaRegistrazione() {
        return idStrutturaRegistrazione;
    }

    public void setIdStrutturaRegistrazione(Struttura idStrutturaRegistrazione) {
        this.idStrutturaRegistrazione = idStrutturaRegistrazione;
    }

    public ZonedDateTime getDataRegistrazione() {
        return dataRegistrazione;
    }

    public void setDataRegistrazione(ZonedDateTime dataRegistrazione) {
        this.dataRegistrazione = dataRegistrazione;
    }

    public Integer getNumeroRegistrazione() {
        return numeroRegistrazione;
    }

    public void setNumeroRegistrazione(Integer numeroRegistrazione) {
        this.numeroRegistrazione = numeroRegistrazione;
    }

    public Integer getAnnoRegistrazione() {
        return annoRegistrazione;
    }

    public void setAnnoRegistrazione(Integer annoRegistrazione) {
        this.annoRegistrazione = annoRegistrazione;
    }

    public ZonedDateTime getDataPubblicazione() {
        return dataPubblicazione;
    }

    public void setDataPubblicazione(ZonedDateTime dataPubblicazione) {
        this.dataPubblicazione = dataPubblicazione;
    }

    public String getOggetto() {
        return oggetto;
    }

    public void setOggetto(String oggetto) {
        this.oggetto = oggetto;
    }

    public String getOggettoTscol() {
        return oggettoTscol;
    }

    public void setOggettoTscol(String oggettoTscol) {
        this.oggettoTscol = oggettoTscol;
    }

    public List<Firmatario> getFirmatari() {
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.convertValue(firmatari, new TypeReference<List<DocList.Firmatario>>() {
        });
    }

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
    public List<Destinatario> getDestinatari() {
        return destinatari;
    }

    public void setDestinatari(List<Destinatario> destinatari) {
        this.destinatari = destinatari;
    }

    public String getDestinatariTscol() {
        return destinatariTscol;
    }

    public void setDestinatariTscol(String destinatariTscol) {
        this.destinatariTscol = destinatariTscol;
    }

    public List<Fascicolazione> getFascicolazioni() {
        return fascicolazioni;
    }

    public void setFascicolazioni(List<Fascicolazione> fascicolazioni) {
        this.fascicolazioni = fascicolazioni;
    }

    public String getFascicolazioniTscol() {
        return fascicolazioniTscol;
    }

    public void setFascicolazioniTscol(String fascicolazioniTscol) {
        this.fascicolazioniTscol = fascicolazioniTscol;
    }

    public List<Classificazione> getClassificazioni() {
        return classificazioni;
    }

    public void setClassificazioni(List<Classificazione> classificazioni) {
        this.classificazioni = classificazioni;
    }

    public StatoDoc getStato() {
        if (stato != null) {
            return StatoDoc.valueOf(stato);
        } else {
            return null;
        }
    }

    public void setStato(StatoDoc stato) {
        if (stato != null) {
            this.stato = stato.toString();
        } else {
            this.stato = null;
        }
    }

    public Boolean getVisibilitaLimitata() {
        return visibilitaLimitata;
    }

    public void setVisibilitaLimitata(Boolean visibilitaLimitata) {
        this.visibilitaLimitata = visibilitaLimitata;
    }

    public Boolean getRiservato() {
        return riservato;
    }

    public void setRiservato(Boolean riservato) {
        this.riservato = riservato;
    }

    public Boolean getAnnullato() {
        return annullato;
    }

    public void setAnnullato(Boolean annullato) {
        this.annullato = annullato;
    }

    public String getProtocolloEsterno() {
        return protocolloEsterno;
    }

    public void setProtocolloEsterno(String protocolloEsterno) {
        this.protocolloEsterno = protocolloEsterno;
    }

    public String getMittente() {
        return mittente;
    }

    public void setMittente(String mittente) {
        this.mittente = mittente;
    }

    public String getMittenteTscol() {
        return mittenteTscol;
    }

    public void setMittenteTscol(String mittenteTscol) {
        this.mittenteTscol = mittenteTscol;
    }

    public Mezzo getIdMezzoRicezione() {
        return idMezzoRicezione;
    }

    public void setIdMezzoRicezione(Mezzo idMezzoRicezione) {
        this.idMezzoRicezione = idMezzoRicezione;
    }

    public String getMailCollegio() {
        return mailCollegio;
    }

    public void setMailCollegio(String mailCollegio) {
        this.mailCollegio = mailCollegio;
    }

    public StatoUfficioAtti getStatoUfficioAtti() {
        if (statoUfficioAtti != null) {
            return StatoUfficioAtti.valueOf(statoUfficioAtti);
        } else {
            return null;
        }
    }

    public void setStatoUfficioAtti(StatoUfficioAtti statoUfficioAtti) {
        if (statoUfficioAtti != null) {
            this.statoUfficioAtti = statoUfficioAtti.toString();
        } else {
            this.statoUfficioAtti = null;
        }
    }

    public String getTscol() {
        return tscol;
    }

    public void setTscol(String tscol) {
        this.tscol = tscol;
    }

    public List<PersonaVedente> getPersoneVedenti() {
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.convertValue(personeVedenti, new TypeReference<List<DocList.PersonaVedente>>() {
        });
    }

    public void setPersoneVedenti(List<PersonaVedente> personeVedenti) {
        this.personeVedenti = (List<JsonNode>) (Object) personeVedenti;
    }

    public Integer[] getIdStruttureSegreteria() {
        return idStruttureSegreteria;
    }

    public void setIdStruttureSegreteria(Integer[] idStruttureSegreteria) {
        this.idStruttureSegreteria = idStruttureSegreteria;
    }

    public ZonedDateTime getDataInserimentoRiga() {
        return dataInserimentoRiga;
    }

    public void setDataInserimentoRiga(ZonedDateTime dataInserimentoRiga) {
        this.dataInserimentoRiga = dataInserimentoRiga;
    }

    public ZonedDateTime getVersion() {
        return version;
    }

    public void setVersion(ZonedDateTime version) {
        this.version = version;
    }

    public Double getRankingOggetto() {
        return rankingOggetto;
    }

    public void setRankingOggetto(Double rankingOggetto) {
        this.rankingOggetto = rankingOggetto;
    }

    public Double getRankingDestinatari() {
        return rankingDestinatari;
    }

    public void setRankingDestinatari(Double rankingDestinatari) {
        this.rankingDestinatari = rankingDestinatari;
    }

    public Double getRankingFascicolazioni() {
        return rankingFascicolazioni;
    }

    public void setRankingFascicolazioni(Double rankingFascicolazioni) {
        this.rankingFascicolazioni = rankingFascicolazioni;
    }

    public Double getRankingMittente() {
        return rankingMittente;
    }

    public void setRankingMittente(Double rankingMittente) {
        this.rankingMittente = rankingMittente;
    }

    public Double getRanking() {
        return ranking;
    }

    public void setRanking(Double ranking) {
        this.ranking = ranking;
    }

    public String getUrlComplete() {
        return urlComplete;
    }

    public void setUrlComplete(String urlComplete) {
        this.urlComplete = urlComplete;
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
        if (!(object instanceof DocList)) {
            return false;
        }
        DocList other = (DocList) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "it.bologna.ausl.model.entities.scripta.DocsList[ id=" + id + " ]";
    }

    public static class Fascicolazione {

        String nome;
        String numerazione;
        String idFascicoloArgo;

        public String getNome() {
            return nome;
        }

        public void setNome(String nome) {
            this.nome = nome;
        }

        public String getNumerazione() {
            return numerazione;
        }

        public void setNumerazione(String numerazione) {
            this.numerazione = numerazione;
        }

        public String getIdFascicoloArgo() {
            return idFascicoloArgo;
        }

        public void setIdFascicoloArgo(String idFascicoloArgo) {
            this.idFascicoloArgo = idFascicoloArgo;
        }
    }

    public static class Firmatario {

        String descrizione;
        Integer idPersona;

        public String getDescrizione() {
            return descrizione;
        }

        public void setDescrizione(String descrizione) {
            this.descrizione = descrizione;
        }

        public Integer getIdPersona() {
            return idPersona;
        }

        public void setIdPersona(Integer idPersona) {
            this.idPersona = idPersona;
        }
    }
    
    public static class Destinatario {

        String nome;
        String indirizzo;
        String tipo;

        public String getNome() {
            return nome;
        }

        public void setNome(String nome) {
            this.nome = nome;
        }

        public String getIndirizzo() {
            return indirizzo;
        }

        public void setIndirizzo(String indirizzo) {
            this.indirizzo = indirizzo;
        }

        public String getTipo() {
            return tipo;
        }

        public void setTipo(String tipo) {
            this.tipo = tipo;
        }
    }

    public static class Classificazione {

        String nome;
        String numerazione;

        public String getNome() {
            return nome;
        }

        public void setNome(String nome) {
            this.nome = nome;
        }

        public String getNumerazione() {
            return numerazione;
        }

        public void setNumerazione(String numerazione) {
            this.numerazione = numerazione;
        }
    }

    public static class PersonaVedente {

        Integer idPersona;
        Boolean mioDocumento;
        Boolean pienaVisibilita;
        String modalitaApertura;

        public Integer getIdPersona() {
            return idPersona;
        }

        public void setIdPersona(Integer idPersona) {
            this.idPersona = idPersona;
        }

        public Boolean getMioDocumento() {
            return mioDocumento;
        }

        public void setMioDocumento(Boolean mioDocumento) {
            this.mioDocumento = mioDocumento;
        }

        public Boolean getPienaVisibilita() {
            return pienaVisibilita;
        }

        public void setPienaVisibilita(Boolean pienaVisibilita) {
            this.pienaVisibilita = pienaVisibilita;
        }

        public String getModalitaApertura() {
            return modalitaApertura;
        }

        public void setModalitaApertura(String modalitaApertura) {
            this.modalitaApertura = modalitaApertura;
        }
    }

    public Applicazione getIdApplicazione() {
        return idApplicazione;
    }

    public void setIdApplicazione(Applicazione idApplicazione) {
        this.idApplicazione = idApplicazione;
    }
}
