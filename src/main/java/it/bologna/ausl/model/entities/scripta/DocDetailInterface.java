package it.bologna.ausl.model.entities.scripta;

import com.fasterxml.jackson.annotation.JsonInclude;
import it.bologna.ausl.model.entities.baborg.Azienda;
import it.bologna.ausl.model.entities.baborg.Persona;
import it.bologna.ausl.model.entities.baborg.Struttura;
import it.bologna.ausl.model.entities.configurazione.Applicazione;
import it.bologna.ausl.model.entities.versatore.Versamento;
import java.time.ZonedDateTime;
import java.util.List;

/**
 *
 * @author gusgus
 */
public interface DocDetailInterface {
    
     public static enum TipologiaDoc {
        PROTOCOLLO_IN_USCITA,
        PROTOCOLLO_IN_ENTRATA,
        DETERMINA,
        DELIBERA,
        DOCUMENT,
        DOCUMENT_PEC, 
        DOCUMENT_REGISTRO, 
        DOCUMENT_UTENTE,
        RGPICO,
        RGDETE,
        RGDELI
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
        SPEDIZIONE_MANUALE,
        APPROVAZIONE,
        ANNULLATO
    }

    public static enum StatoUfficioAtti {
        SOSPESA,
        ELABORATA,
        DA_VALUTARE,
        NON_RILEVANTE
    }
    
    public Integer getId();

    public void setId(Integer id);

    public Azienda getIdAzienda();

    public void setIdAzienda(Azienda idAzienda);

    public String getGuidDocumento();

    public void setGuidDocumento(String guidDocumento);

    public TipologiaDoc getTipologia();

    public void setTipologia(TipologiaDoc tipologia);

    public String getOpenCommand();

    public void setOpenCommand(String openCommand);

    public CommandType getCommandType();

    public void setCommandType(CommandType commandType);
    
    public Persona getIdPersonaResponsabileProcedimento();

    public void setIdPersonaResponsabileProcedimento(Persona idPersonaResponsabileProcedimento);

    public Persona getIdPersonaRedattrice();

    public void setIdPersonaRedattrice(Persona idPersonaRedattrice);

    public ZonedDateTime getDataCreazione();

    public void setDataCreazione(ZonedDateTime dataCreazione);

    public Integer getNumeroProposta();

    public void setNumeroProposta(Integer numeroProposta);

    public Integer getAnnoProposta();

    public void setAnnoProposta(Integer annoProposta);

    public Struttura getIdStrutturaRegistrazione();

    public void setIdStrutturaRegistrazione(Struttura idStrutturaRegistrazione);

    public ZonedDateTime getDataRegistrazione();

    public void setDataRegistrazione(ZonedDateTime dataRegistrazione);

    public Integer getNumeroRegistrazione();

    public void setNumeroRegistrazione(Integer numeroRegistrazione);

    public Integer getAnnoRegistrazione();

    public void setAnnoRegistrazione(Integer annoRegistrazione);

    public ZonedDateTime getDataPubblicazione();

    public void setDataPubblicazione(ZonedDateTime dataPubblicazione);

    public String getOggetto();

    public void setOggetto(String oggetto);

    public String getOggettoTscol();

    public void setOggettoTscol(String oggettoTscol);

    public List<Firmatario> getFirmatari();

    public void setFirmatari(List<Firmatario> firmatari);

    public List<Destinatario> getDestinatari();

    public void setDestinatari(List<Destinatario> destinatari);

    public String getDestinatariTscol();

    public void setDestinatariTscol(String destinatariTscol);

//    public List<Fascicolazione> getFascicolazioni();
//
//    public void setFascicolazioni(List<Fascicolazione> fascicolazioni);
//
//    public String getFascicolazioniTscol();
//
//    public void setFascicolazioniTscol(String fascicolazioniTscol);

//    public List<Classificazione> getClassificazioni();
//
//    public void setClassificazioni(List<Classificazione> classificazioni);

    public StatoDoc getStato(); 

    public void setStato(StatoDoc stato); 

    public Boolean getVisibilitaLimitata();

    public void setVisibilitaLimitata(Boolean visibilitaLimitata);

    public Boolean getRiservato();

    public void setRiservato(Boolean riservato);

    public Boolean getAnnullato();

    public void setAnnullato(Boolean annullato);

    public String getProtocolloEsterno();

    public void setProtocolloEsterno(String protocolloEsterno);

    public String getMittente();

    public void setMittente(String mittente);

    public String getMittenteTscol();

    public void setMittenteTscol(String mittenteTscol);

    public Mezzo getIdMezzoRicezione();

    public void setIdMezzoRicezione(Mezzo idMezzoRicezione);

    public String getMailCollegio();

    public void setMailCollegio(String mailCollegio);

    public StatoUfficioAtti getStatoUfficioAtti();

    public void setStatoUfficioAtti(StatoUfficioAtti statoUfficioAtti);

    public String getTscol();

    public void setTscol(String tscol);

    public List<PersonaVedente> getPersoneVedentiList();

    public void setPersoneVedentiList(List<PersonaVedente> personeVedentiList);
    
    public List<PersonaUsante> getSullaScrivaniaDi();

    public void setSullaScrivaniaDi(List<PersonaUsante> sullaScrivaniaDi);

    public Integer[] getIdStruttureSegreteria();

    public void setIdStruttureSegreteria(Integer[] idStruttureSegreteria);

    public ZonedDateTime getDataInserimentoRiga();

    public void setDataInserimentoRiga(ZonedDateTime dataInserimentoRiga);

    public ZonedDateTime getVersion();

    public void setVersion(ZonedDateTime version);

    public Double getRankingOggetto();

    public void setRankingOggetto(Double rankingOggetto);

    public Double getRankingDestinatari();

    public void setRankingDestinatari(Double rankingDestinatari);

//    public Double getRankingFascicolazioni();
//
//    public void setRankingFascicolazioni(Double rankingFascicolazioni);

    public Double getRankingMittente();

    public void setRankingMittente(Double rankingMittente);

    public Double getRanking();

    public void setRanking(Double ranking);

    public String getUrlComplete();

    public void setUrlComplete(String urlComplete);
    
    public Applicazione getIdApplicazione();

    public void setIdApplicazione(Applicazione idApplicazione);
        
//    public List<Archiviazione> getArchiviazioni();
//
//    public void setArchiviazioni(List<Archiviazione> archiviazioni);

    public Integer[] getIdArchiviAntenati();

    public void setIdArchiviAntenati(Integer[] idArchiviAntenati);
    
    public Integer[] getIdArchivi();

    public void setIdArchivi(Integer[] idArchivi);
    
    public List<ArchivioDoc> getArchiviDocList();

    public void setArchiviDocList(List<ArchivioDoc> archiviDocList);
    
    public Versamento.StatoVersamento getStatoUltimoVersamento();

    public void setStatoUltimoVersamento(Versamento.StatoVersamento statoUltimoVersamento);

    public ZonedDateTime getDataUltimoVersamento();
    
    public void setDataUltimoVersamento(ZonedDateTime dataUltimoVersamento);
    
    public Boolean getStatoVersamentoVisto();

    public void setStatoVersamentoVisto(Boolean statoVersamentoVisto);
    
    public Boolean getVersamentoForzabile();
    
    public void setVersamentoForzabile(Boolean versamentoForzabile);
    
//    public static class Fascicolazione {
//
//        String nome;
//        String numerazione;
//        String idFascicoloArgo;
//        String idFascicoloRadiceArgo;
//
//        public String getNome() {
//            return nome;
//        }
//
//        public void setNome(String nome) {
//            this.nome = nome;
//        }
//
//        public String getNumerazione() {
//            return numerazione;
//        }
//
//        public void setNumerazione(String numerazione) {
//            this.numerazione = numerazione;
//        }
//
//        public String getIdFascicoloArgo() {
//            return idFascicoloArgo;
//        }
//
//        public void setIdFascicoloArgo(String idFascicoloArgo) {
//            this.idFascicoloArgo = idFascicoloArgo;
//        }
//
//        public String getIdFascicoloRadiceArgo() {
//            return idFascicoloRadiceArgo;
//        }
//
//        public void setIdFascicoloRadiceArgo(String idFascicoloRadiceArgo) {
//            this.idFascicoloRadiceArgo = idFascicoloRadiceArgo;
//        }
//        
//    }
    
//    public static class Archiviazione {
//
//        String descrizione;
//        Integer idArchivio;
//
//        public String getDescrizione() {
//            return descrizione;
//        }
//
//        public void setDescrizione(String descrizione) {
//            this.descrizione = descrizione;
//        }
//
//        public Integer getIdArchivio() {
//            return idArchivio;
//        }
//
//        public void setIdArchivio(Integer idArchivio) {
//            this.idArchivio = idArchivio;
//        }
//
//    }
    @JsonInclude(JsonInclude.Include.NON_NULL)
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

    @JsonInclude(JsonInclude.Include.NON_NULL)
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

//    public static class Classificazione {
//
//        String nome;
//        String numerazione;
//
//        public String getNome() {
//            return nome;
//        }
//
//        public void setNome(String nome) {
//            this.nome = nome;
//        }
//
//        public String getNumerazione() {
//            return numerazione;
//        }
//
//        public void setNumerazione(String numerazione) {
//            this.numerazione = numerazione;
//        }
//    }

//    public static class PersonaVedente {
//
//        Integer idPersona;
//        Boolean mioDocumento;
//        Boolean pienaVisibilita;
//        String modalitaApertura;
//
//        public Integer getIdPersona() {
//            return idPersona;
//        }
//
//        public void setIdPersona(Integer idPersona) {
//            this.idPersona = idPersona;
//        }
//
//        public Boolean getMioDocumento() {
//            return mioDocumento;
//        }
//
//        public void setMioDocumento(Boolean mioDocumento) {
//            this.mioDocumento = mioDocumento;
//        }
//
//        public Boolean getPienaVisibilita() {
//            return pienaVisibilita;
//        }
//
//        public void setPienaVisibilita(Boolean pienaVisibilita) {
//            this.pienaVisibilita = pienaVisibilita;
//        }
//
//        public String getModalitaApertura() {
//            return modalitaApertura;
//        }
//
//        public void setModalitaApertura(String modalitaApertura) {
//            this.modalitaApertura = modalitaApertura;
//        }
//    }
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public static class PersonaUsante {

        Integer idPersona;
        String descrizione;

        public Integer getIdPersona() {
            return idPersona;
        }

        public void setIdPersona(Integer idPersona) {
            this.idPersona = idPersona;
        }

        public String getDescrizione() {
            return descrizione;
        }

        public void setDescrizione(String descrizione) {
            this.descrizione = descrizione;
        }

    }
}
