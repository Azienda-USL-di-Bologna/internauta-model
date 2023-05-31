package it.bologna.ausl.model.entities.tip.data;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author gdm
 */
public class TipErroriImportazione implements Serializable {
    
    private Map<String, Flusso> flussi;

    public TipErroriImportazione() {
        this.flussi = new HashMap<>();
    }

    public TipErroriImportazione(ColonneImportazioneOggetto nomeColonna, Flusso.TipoFlusso tipoFlusso, String info, String warning, String error) {
        this();
        Flusso flusso = getFlusso(nomeColonna);
        flusso.setTipologia(tipoFlusso, new Tipologia(info, warning, error));
    }

    public Map<String, Flusso> getFlussi() {
        return flussi;
    }

    public void setFlussi(Map<String, Flusso> flussi) {
        this.flussi = flussi;
    }
    
    @JsonIgnore
    public Flusso getFlusso (ColonneImportazioneOggetto nomeColonna) {
        Flusso flusso = flussi.get(nomeColonna.toString());
        if (flusso == null) {
            flusso = new Flusso();
            flussi.put(nomeColonna.toString(), flusso);
        }
        return flusso;
    }
    
    @JsonIgnore
    public Tipologia getTipologia (ColonneImportazioneOggetto nomeColonna, Flusso.TipoFlusso tipoFlusso, Flusso flusso) {
        Tipologia tipologia = flusso.getTipologia(tipoFlusso);
        if (tipologia == null) {
            tipologia = new Tipologia();
        }
        return tipologia;
    }
    
    @JsonIgnore
    public void setInfo(ColonneImportazioneOggetto nomeColonna, Flusso.TipoFlusso tipoFlusso, String info) {
        Flusso flusso = getFlusso(nomeColonna);
        Tipologia tipologia = getTipologia(nomeColonna, tipoFlusso, flusso);
        tipologia.setInfo(info);
        flusso.setTipologia(tipoFlusso, tipologia);
    }
    
    @JsonIgnore
    public void setWarning(ColonneImportazioneOggetto nomeColonna, Flusso.TipoFlusso tipoFlusso, String warning) {
        Flusso flusso = getFlusso(nomeColonna);
        Tipologia tipologia = getTipologia(nomeColonna, tipoFlusso, flusso);
        tipologia.setWarning(warning);
        flusso.setTipologia(tipoFlusso, tipologia);
    }
    @JsonIgnore
    public void setError(ColonneImportazioneOggetto nomeColonna, Flusso.TipoFlusso tipoFlusso, String error) {
        Flusso flusso = getFlusso(nomeColonna);
        Tipologia tipologia = getTipologia(nomeColonna, tipoFlusso, flusso);
        tipologia.setError(error);
        flusso.setTipologia(tipoFlusso, tipologia);
    }
    
    
    public static class Flusso {
        public static enum TipoFlusso {
            VALIDAZIONE, IMPORTAZIONE
        }
        private Tipologia validazione;
        private Tipologia importazione;

        public Flusso() {
        }

        public Flusso(Tipologia validazione, Tipologia importazione) {
            this.validazione = validazione;
            this.importazione = importazione;
        }

        @JsonIgnore
        public void setTipologia(TipoFlusso flusso, Tipologia tipologia) {
            switch (flusso) {
                case VALIDAZIONE:
                    setValidazione(tipologia);
                    break;
                case IMPORTAZIONE:
                    setImportazione(tipologia);
                    break;
            }
        }
        
        @JsonIgnore
        public Tipologia getTipologia(TipoFlusso flusso) {
            Tipologia tipologia = null;
            switch (flusso) {
                case VALIDAZIONE:
                    tipologia = getValidazione();
                    break;
                case IMPORTAZIONE:
                    tipologia = getImportazione();
                    break;
            }
            return tipologia;
        }
        
        public Tipologia getValidazione() {
            return validazione;
        }

        public void setValidazione(Tipologia validazione) {
            this.validazione = validazione;
        }

        public Tipologia getImportazione() {
            return importazione;
        }

        public void setImportazione(Tipologia importazione) {
            this.importazione = importazione;
        }
    }
    
    public static class Tipologia {
        private String info;
        private String warning;
        private String error;

        public Tipologia() {
        }

        public Tipologia(String info, String warning, String error) {
            this.info = info;
            this.warning = warning;
            this.error = error;
        }

        public String getInfo() {
            return info;
        }

        public void setInfo(String info) {
            this.info = info;
        }

        public String getWarning() {
            return warning;
        }

        public void setWarning(String warning) {
            this.warning = warning;
        }

        public String getError() {
            return error;
        }

        public void setError(String error) {
            this.error = error;
        }
    }
}
