package it.bologna.ausl.model.entities.tip.data;

import it.bologna.ausl.model.entities.scripta.Mezzo;
import it.bologna.ausl.model.entities.tip.SessioneImportazione;
import java.util.Arrays;
import java.util.List;

/**
 *
 * @author gdm
 */
public class ColonneImportazioneOggettoEnums {    
    public static enum ColonneDetermina implements ColonneImportazioneOggetto {
        registro(Arrays.asList("registro")),
        numero(Arrays.asList("numero")),
        anno(Arrays.asList("anno")),
        oggetto(Arrays.asList("oggetto")),
        dataAdozione(Arrays.asList("data di adozione")),
        destinatariInterni(Arrays.asList("destinatari interni")),
        indirizziDestinatariEsterni(Arrays.asList("indirizzo destinatari esterni")),
        nomiDestinatariEsterni(Arrays.asList("nome destinatari esterni")),
        adottatoDa(Arrays.asList("adottato da", "adottata da")),
        
        firmatario(Arrays.asList("firmatario")),
        pareri(Arrays.asList("pareri")),
        redattore(Arrays.asList("redattore")),
        visto(Arrays.asList("visto")),
        
        idFascicoloPregresso(Arrays.asList("id fascicolo pregresso")),
        fascicolazione(Arrays.asList("cod fascicolo babel")),
        classificazione(Arrays.asList("classificazione")),
        allegati(Arrays.asList("allegati")),
        annotazioni(Arrays.asList("annotazioni")),
        
        numeroPubblicazione(Arrays.asList("numero pubblicazione")),
        dataInizio(Arrays.asList("data inizio")),
        dataFine(Arrays.asList("data fine")),
        annoPubblicazione(Arrays.asList("anno pubblicazione")),
        dataEsecutivita(Arrays.asList("data esecutivita", "data esecutività")),
        
        conservato(Arrays.asList("conservato")),
        collegamentoPrecedente(Arrays.asList("collegamento precedente")),
        note(Arrays.asList("nota")),
        annullato(Arrays.asList("flag annullato")),
        noteAnnullamento(Arrays.asList("nota annullamento", "note annullamento")),
        dataAnnullamento(Arrays.asList("data annullamento")),
        dataInvioConservazione(Arrays.asList("data invio conservazione", "data invio parer")),
        errori(Arrays.asList("errori"));
        
        private final List<String> valuesList;
        
        ColonneDetermina(List<String> values) {
            this.valuesList = values;
        }
        
        /**
        * torna la lista dei valori associati alla chiave enum (di fatto sono i nomi degli header che rappresentano il campo dell'entità)
        * @return la lista dei valori associati alla chiave enum
        */
        @Override
        public List<String> getValue() {
            return valuesList;
        }
        
        @Override
        public ColonneImportazioneOggetto getErroriColumn() {
            return errori;
        }
    }
    
    public static enum ColonneDelibera implements ColonneImportazioneOggetto { 
        registro(Arrays.asList("registro")),
        numero(Arrays.asList("numero")),
        anno(Arrays.asList("anno")),
        oggetto(Arrays.asList("oggetto")),
        dataAdozione(Arrays.asList("data di adozione", "data adozione")),
        destinatariInterni(Arrays.asList("destinatari interni")),
        indirizziDestinatariEsterni(Arrays.asList("indirizzo destinatari esterni")),
        nomiDestinatariEsterni(Arrays.asList("nome destinatari esterni")),
        
        direttoreGenerale(Arrays.asList("dg")),
        vicarioDirettoreGenerale(Arrays.asList("vicario dg")),
        direttoreSanitario(Arrays.asList("ds")),
        direttoreAmministrativo(Arrays.asList("da")),
        propostoDa(Arrays.asList("proposto da", "proposta da")),
        proponente(Arrays.asList("proponente")),
        pareri(Arrays.asList("pareri")),
        redattore(Arrays.asList("redattore")),
        visto(Arrays.asList("visto")),
        
        
        idFascicoloPregresso(Arrays.asList("id fascicolo pregresso")),
        fascicolazione(Arrays.asList("cod fascicolo babel")),
        classificazione(Arrays.asList("classificazione")),
        allegati(Arrays.asList("allegati")),
        annotazioni(Arrays.asList("annotazioni")),
        
        numeroPubblicazione(Arrays.asList("numero pubblicazione")),
        dataInizio(Arrays.asList("data inizio")),
        dataFine(Arrays.asList("data fine")),
        annoPubblicazione(Arrays.asList("anno pubblicazione")),
        dataEsecutivita(Arrays.asList("data esecutivita", "data esecutività")),
        
        controlloRegionale(Arrays.asList("controllo regionale")),
        conservato(Arrays.asList("conservato")),
        collegamentoPrecedente(Arrays.asList("collegamento precedente")),
        
        note(Arrays.asList("nota")),
        annullato(Arrays.asList("flag annullato")),
        noteAnnullamento(Arrays.asList("nota annullamento", "note annullamento")),
        dataAnnullamento(Arrays.asList("data annullamento")),
        dataInvioConservazione(Arrays.asList("data invio conservazione", "data invio parer")),
        errori(Arrays.asList("errori"));
        
        private final List<String> valuesList;
        
        ColonneDelibera(List<String> values) {
            this.valuesList = values;
        }
        
        /**
        * torna la lista dei valori associati alla chiave enum (di fatto sono i nomi degli header che rappresentano il campo dell'entità)
        * @return la lista dei valori associati alla chiave enum
        */
        @Override
        public List<String> getValue() {
            return valuesList;
        }
        
        @Override
        public ColonneImportazioneOggetto getErroriColumn() {
            return errori;
        }
    }
    
    public static enum ColonneProtocolloEntrata implements ColonneImportazioneOggetto {
              
        registro(Arrays.asList("registro")),
        numero(Arrays.asList("numero")),
        anno(Arrays.asList("anno")),
        oggetto(Arrays.asList("oggetto")),
        dataRegistrazione(Arrays.asList("data di registrazione","data registrazione")),
        dataArrivo(Arrays.asList("data di arrivo","data arrivo")),
        destinatariInterniA(Arrays.asList("destinatario interni a", "destinatari interni a", "destinatario interno a")),
        destinatariInterniCC(Arrays.asList("destinatario interni cc", "destinatari interni cc", "destinatario interno cc")),
        protocollatoDa(Arrays.asList("protocollato da")),
        protocolloEsterno(Arrays.asList("protocollo esterno")),
        dataProtocolloEsterno(Arrays.asList("data protocollo esterno")),
        indirizzoMittente(Arrays.asList("indirizzo mittente")),
        mittente(Arrays.asList("mittente")),
        mezzo(Arrays.asList("mezzo")),
        idFascicoloPregresso(Arrays.asList("id fascicolo pregresso")),
        fascicolazione(Arrays.asList("cod fascicolo babel")),
        classificazione(Arrays.asList("classificazione")),
        visibilitaLimitata(Arrays.asList("visibilita limitata", "visibilità limitata")),
        riservato(Arrays.asList("riservato")),
        allegati(Arrays.asList("allegati")),
        collegamentoPrecedente(Arrays.asList("collegamento precedente")),
        note(Arrays.asList("nota")),
        annullato(Arrays.asList("flag annullato")),
        noteAnnullamento(Arrays.asList("nota annullamento", "note annullamento")),
        dataAnnullamento(Arrays.asList("data annullamento")),
        dataInvioConservazione(Arrays.asList("data invio conservazione", "data invio parer")),
        errori(Arrays.asList("errori"));
        
        private final List<String> valuesList;
        
        ColonneProtocolloEntrata(List<String> values) {
            this.valuesList = values;
        }
        
        /**
        * torna la lista dei valori associati alla chiave enum (di fatto sono i nomi degli header che rappresentano il campo dell'entità)
        * @return la lista dei valori associati alla chiave enum
        */
        @Override
        public List<String> getValue() {
            return valuesList;
        }
        
        @Override
        public ColonneImportazioneOggetto getErroriColumn() {
            return errori;
        }
    }
    
    public static enum ColonneProtocolloUscita implements ColonneImportazioneOggetto {
        registro(Arrays.asList("registro")),
        numero(Arrays.asList("numero")),
        anno(Arrays.asList("anno")),
        oggetto(Arrays.asList("oggetto")),
        dataRegistrazione(Arrays.asList("data di registrazione","data registrazione")),
        indirizziDestinatariPrincipali(Arrays.asList("indirizzo destinatari principali","indirizzi destinatari principali")),
        destinatariPrincipali(Arrays.asList("destinatari principali")),
        descrizioneIndirizziPrincipali(Arrays.asList("descrizione indirizzi principali")),
        indirizziAltriDestinatari(Arrays.asList("indirizzo altri destinatari","indirizzi altri destinatari")),
        altriDestinatari(Arrays.asList("altri destinatari")),
        descrizioneAltriIndirizzi(Arrays.asList("descrizione altri indirizzi")),
        protocollatoDa(Arrays.asList("protocollato da")),
        pecMittente(Arrays.asList("pec mittente")),
        firmatari(Arrays.asList("firmatari")),
        pareri(Arrays.asList("pareri")),
        redattore(Arrays.asList("redattore")),
        idFascicoloPregresso(Arrays.asList("id fascicolo pregresso")),
        fascicolazione(Arrays.asList("cod fascicolo babel")),
        classificazione(Arrays.asList("classificazione")),
        visibilitaLimitata(Arrays.asList("visibilita limitata","visibilità limitata")),
        riservato(Arrays.asList("riservato")),
        allegati(Arrays.asList("allegati")),
        collegamentoPrecedente(Arrays.asList("collegamento precedente")),
        note(Arrays.asList("nota")),
        annullato(Arrays.asList("flag annullato")),
        noteAnnullamento(Arrays.asList("nota annullamento", "note annullamento")),
        dataAnnullamento(Arrays.asList("data annullamento")),
        dataInvioConservazione(Arrays.asList("data invio conservazione", "data invio parer")),
        errori(Arrays.asList("errori"));
         
        private final List<String> valuesList;
        
        ColonneProtocolloUscita(List<String> values) {
            this.valuesList = values;
        }
        
        /**
        * torna la lista dei valori associati alla chiave enum (di fatto sono i nomi degli header che rappresentano il campo dell'entità)
        * @return la lista dei valori associati alla chiave enum
        */
        @Override
        public List<String> getValue() {
            return valuesList;
        }
        
        @Override
        public ColonneImportazioneOggetto getErroriColumn() {
            return errori;
        }
    }
    
    public static enum MezziConsentiti implements KeyValueEnum<String>{
        POSTA_SEMPLICE("posta semplice"),
        FAX("fax"),
        A_MANO("a mano"),
        TELEFONO("telefono"),
        RACCOMANDATA("raccomandata"),
        EMAIL("email"),
        PEC("pec"),
        BABEL("babel");
        
        private final String value;
        
        MezziConsentiti(String value) {
            this.value = value;
        }

        @Override
        public String getValue() {
            return value;
        }
        
        public Mezzo.CodiciMezzo getCodiceMezzoScripta() {
            Mezzo.CodiciMezzo res;
            switch (this) {
                case POSTA_SEMPLICE:
                    res = Mezzo.CodiciMezzo.POSTA_ORDINARIA;
                    break;
                case RACCOMANDATA:
                    res = Mezzo.CodiciMezzo.RACCOMANDATA;
                    break;
                case EMAIL:
                    res = Mezzo.CodiciMezzo.MAIL;
                    break;
                case PEC:
                    res = Mezzo.CodiciMezzo.PEC;
                    break;
                case BABEL:
                    res = Mezzo.CodiciMezzo.BABEL;
                    break;
                case A_MANO:
                    res = Mezzo.CodiciMezzo.A_MANO;
                    break;
                case TELEFONO:
                    res = Mezzo.CodiciMezzo.TELEFONO;
                    break;
                case FAX:
                    res = Mezzo.CodiciMezzo.FAX;
                    break;
                default:
                    throw new AssertionError(String.format("mezzo con codice %s non valido", this.name()));
            }
            return res;
        }
    }
    
    public static ColonneImportazioneOggetto getColonnaFiles(SessioneImportazione.TipologiaPregresso tipologia) {
        ColonneImportazioneOggetto res;
        switch (tipologia) {
            case DELIBERA:
                res = ColonneDelibera.allegati;
                break;
            case DETERMINA:
                res = ColonneDetermina.allegati;
                break;
            case PROTOCOLLO_IN_ENTRATA:
                res = ColonneProtocolloEntrata.allegati;
                break;
            case PROTOCOLLO_IN_USCITA:
                res = ColonneProtocolloUscita.allegati;
                break;
            default:
                throw new AssertionError("non sono previsti file per questa tipologia");
        }
        return res;
    }
}
