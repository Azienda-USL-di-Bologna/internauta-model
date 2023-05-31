/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package it.bologna.ausl.model.entities.tip.data;

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
        oggetto(Arrays.asList()),
        dataAdozione(Arrays.asList("data di adozione")),
        destinatariInterni(Arrays.asList("destinatari interni")),
        indirizziDestinatariEsterni(Arrays.asList("indirizzo destinatari esterni")),
        nomiDestinatariEsterni(Arrays.asList("nome destinatari esterni")),
        adottatoDa(Arrays.asList("adottato da")),
        firmatario(Arrays.asList()),
        pareri(Arrays.asList()),
        redattore(Arrays.asList()),
        visto(Arrays.asList()),
        idFascicoloPregresso(Arrays.asList("id fascicolo pregresso")),
        fascicolazione(Arrays.asList()),
        classificazione(Arrays.asList()),
        allegati(Arrays.asList()),
        annotazioni(Arrays.asList()),
        numeroPubblicazione(Arrays.asList("numero pubblicazione")),
        dataInizio(Arrays.asList("data inizio")),
        dataFine(Arrays.asList("data fine")),
        annoPubblicazione(Arrays.asList("anno pubblicazione")),
        conservato(Arrays.asList("conservato")),
        collegamentoPrecedente(Arrays.asList("collegamento precedente")),
        note(Arrays.asList("nota")),
        annullato(Arrays.asList("flag annullato")),
        noteAnnullamento(Arrays.asList("nota annullamento", "note annullamento")),
        dataAnnullamento(Arrays.asList("data annullamento")),
        dataInvioConservazione(Arrays.asList("data invio conservazione", "data invio parer")),
        errori(Arrays.asList());
        
        private final List<String> valuesList;
        
        ColonneDetermina(List<String> values) {
            this.valuesList = values;
        }
        
        @Override
        public List<String> getValuesList() {
            return valuesList;
        }
    }
    
    public static enum ColonneDelibera implements ColonneImportazioneOggetto { 
        registro(Arrays.asList("registro")),
        numero(Arrays.asList("numero")),
        anno(Arrays.asList("anno")),
        oggetto(Arrays.asList()),
        dataAdozione(Arrays.asList("data di adozione")),
        destinatariInterni(Arrays.asList("destinatari interni")),
        indirizziDestinatariEsterni(Arrays.asList("indirizzo destinatari esterni")),
        nomiDestinatariEsterni(Arrays.asList("nome destinatari esterni")),
        
        direttoreGenerale(Arrays.asList("dg")),
        vicarioDirettoreGenerale(Arrays.asList("vicario dg")),
        direttoreSanitario(Arrays.asList("ds")),
        direttoreAmministrativo(Arrays.asList("da")),
        propostoDa(Arrays.asList("proposto da")),
        proponente(Arrays.asList("proponente")),
        
        controlloRegionale(Arrays.asList("controllo regionale")),
        
        pareri(Arrays.asList()),
        redattore(Arrays.asList()),
        visto(Arrays.asList()),
        idFascicoloPregresso(Arrays.asList("id fascicolo pregresso")),
        fascicolazione(Arrays.asList()),
        classificazione(Arrays.asList()),
        allegati(Arrays.asList()),
        annotazioni(Arrays.asList()),
        numeroPubblicazione(Arrays.asList("numero pubblicazione")),
        dataInizio(Arrays.asList("data inizio")),
        dataFine(Arrays.asList("data fine")),
        annoPubblicazione(Arrays.asList("anno pubblicazione")),
        conservato(Arrays.asList("conservato")),
        collegamentoPrecedente(Arrays.asList("collegamento precedente")),
        note(Arrays.asList("nota")),
        annullato(Arrays.asList("flag annullato")),
        noteAnnullamento(Arrays.asList("nota annullamento", "note annullamento")),
        dataAnnullamento(Arrays.asList("data annullamento")),
        dataInvioConservazione(Arrays.asList("data invio conservazione", "data invio parer")),
        errori(Arrays.asList());
        
        private final List<String> valuesList;
        
        ColonneDelibera(List<String> values) {
            this.valuesList = values;
        }
        
        @Override
        public List<String> getValuesList() {
            return valuesList;
        }
    }
    
    public static enum ColonneProtocolloEntrata implements ColonneImportazioneOggetto {
              
        dataRegistrazione(Arrays.asList("data di registrazione")),
        dataArrivo(Arrays.asList("data di arrivo")),
        protocollatoDa(Arrays.asList("protocollato da")),
        indirizzoMittente(Arrays.asList("indirizzo mittente")),
        mittente(Arrays.asList()),
        mezzo(Arrays.asList()),
        protocolloEsterno(Arrays.asList("protocollo esterno")),
        dataProtocolloEsterno(Arrays.asList("data protocollo esterno")),
        destinatariInterniA(Arrays.asList("destinatario interni a", "destinatari interni a", "destinatario interno a")),
        destinatariInterniCC(Arrays.asList("destinatario interni cc", "destinatari interni cc", "destinatario interno cc")),
        visibilitaLimitata(Arrays.asList("visibilita limitata")),
        riservato(Arrays.asList()),
        
        registro(Arrays.asList("registro")),
        numero(Arrays.asList("numero")),
        anno(Arrays.asList("anno")),
        oggetto(Arrays.asList()),
        idFascicoloPregresso(Arrays.asList("id fascicolo pregresso")),
        fascicolazione(Arrays.asList()),
        classificazione(Arrays.asList()),
        allegati(Arrays.asList()),
        collegamentoPrecedente(Arrays.asList("collegamento precedente")),
        note(Arrays.asList("nota")),
        annullato(Arrays.asList("flag annullato")),
        noteAnnullamento(Arrays.asList("nota annullamento", "note annullamento")),
        dataAnnullamento(Arrays.asList("data annullamento")),
        dataInvioConservazione(Arrays.asList("data invio conservazione", "data invio parer")),
        errori(Arrays.asList());
        
        private final List<String> valuesList;
        
        ColonneProtocolloEntrata(List<String> values) {
            this.valuesList = values;
        }
        
        @Override
        public List<String> getValuesList() {
            return valuesList;
        }
    }
    
    public static enum ColonneProtocolloUscita implements ColonneImportazioneOggetto {
        indirizziDestinatariPrincipali(Arrays.asList("indirizzo destinatari principali")),
        destinatariPrincipali(Arrays.asList("destinatari principali")),
        descrizioneIndirizziPrincipali(Arrays.asList("descrizione indirizzi principali")),
        
        indirizziAltriDestinatari(Arrays.asList("indirizzo altri destinatari")),
        altriDestinatari(Arrays.asList("altri destinatari")),
        descrizioneAltriIndirizzi(Arrays.asList("descrizione altri indirizzi")),
        
        pecMittente(Arrays.asList("pec mittente")),
        firmatari(Arrays.asList()),
        pareri(Arrays.asList()),
        redattore(Arrays.asList()),
        
        dataRegistrazione(Arrays.asList("data di registrazione")),
        protocollatoDa(Arrays.asList("protocollato da")),
        visibilitaLimitata(Arrays.asList("visibilita limitata")),
        riservato(Arrays.asList()),
        
        registro(Arrays.asList("registro")),
        numero(Arrays.asList("numero")),
        anno(Arrays.asList("anno")),
        oggetto(Arrays.asList()),
        idFascicoloPregresso(Arrays.asList("id fascicolo pregresso")),
        fascicolazione(Arrays.asList()),
        classificazione(Arrays.asList()),
        allegati(Arrays.asList()),
        collegamentoPrecedente(Arrays.asList("collegamento precedente")),
        note(Arrays.asList("nota")),
        annullato(Arrays.asList("flag annullato")),
        noteAnnullamento(Arrays.asList("nota annullamento", "note annullamento")),
        dataAnnullamento(Arrays.asList("data annullamento")),
        dataInvioConservazione(Arrays.asList("data invio conservazione", "data invio parer"));
        
        private final List<String> valuesList;
        
        ColonneProtocolloUscita(List<String> values) {
            this.valuesList = values;
        }
        
        @Override
        public List<String> getValuesList() {
            return valuesList;
        }
    }
}
