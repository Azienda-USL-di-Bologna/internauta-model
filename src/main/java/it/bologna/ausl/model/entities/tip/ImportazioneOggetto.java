package it.bologna.ausl.model.entities.tip;

import it.bologna.ausl.model.entities.tip.data.TipErroriImportazione;

/**
 *
 * @author gdm
 */
public interface ImportazioneOggetto {
    public static <T extends ImportazioneOggetto> T getImportazioneOggettoImpl(SessioneImportazione.TipologiaPregresso tipologia) {
        T res = null;
        switch (tipologia) {
            case DELIBERA:
            case DETERMINA:
            case PROTOCOLLO_IN_ENTRATA:
            case PROTOCOLLO_IN_USCITA:
                res = (T) new ImportazioneDocumento();
                break;
            case FASCICOLO: // TODO: qui tornare l'entità associata alla tabella importazioni_archivi
                return (T) new ImportazioneDocumento();
        }
        return res;
    }
    
    public TipErroriImportazione getErrori();
    public void setErrori(TipErroriImportazione errori);
}
