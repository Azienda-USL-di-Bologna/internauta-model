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
    
    public String getRegistro();
    public void setRegistro(String registro);
    
    public String getNumero();
    public void setNumero(String numero);
    
    public String getAnno();
    public void setAnno(String anno);
    
    public SessioneImportazione getIdSessioneImportazione();
    public void setIdSessioneImportazione(SessioneImportazione idSessioneImportazione);

    public ImportazioneDocumento.StatiImportazioneDocumento getStato();
    public void setStato(ImportazioneDocumento.StatiImportazioneDocumento stato);
    
    public String getNote();
    public void setNote(String note);
    
    public String getIdRepoCsv();
    public void setIdRepoCsv(String idRepoCsv);
    
    public TipErroriImportazione getErrori();
    public void setErrori(TipErroriImportazione errori);
}
