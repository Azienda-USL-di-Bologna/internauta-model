package it.bologna.ausl.model.entities.scripta.data;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author gdm
 */
public class TipErroriImportazione {
    private Map<String, InfoColonna> infoColonne;

    public TipErroriImportazione() {
        this.infoColonne = new HashMap<>();
    }

    public TipErroriImportazione(String nomeColonna, String note, String warning, String error) {
        this();
        this.infoColonne.put(nomeColonna, new InfoColonna(note, warning, error));
    }

    public Map<String, InfoColonna> getInfoColonne() {
        return infoColonne;
    }

    public void setInfoColonne(Map<String, InfoColonna> infoColonne) {
        this.infoColonne = infoColonne;
    }
    
    public void setAllInfoColonna(String nomeColonna, String note, String warning, String error) {
        infoColonne.put(nomeColonna, new InfoColonna(note, warning, error));
    }
    
    @JsonIgnore
    public void setNoteInfoColonna(String nomeColonna, String note) {
        InfoColonna infoColonna = infoColonne.get(nomeColonna);
        if (infoColonna != null) {
            infoColonna.setNote(note);
        } else {
            setAllInfoColonna(nomeColonna, note, null, null);
        }
    }
    
    @JsonIgnore
    public void setWarningInfoColonna(String nomeColonna, String warning) {
        InfoColonna infoColonna = infoColonne.get(nomeColonna);
        if (infoColonna != null) {
            infoColonna.setWarning(warning);
        } else {
            setAllInfoColonna(nomeColonna, null, warning, null);
        }
    }
    
    @JsonIgnore
    public void setErrorInfoColonna(String nomeColonna, String error) {
        InfoColonna infoColonna = infoColonne.get(nomeColonna);
        if (infoColonna != null) {
            infoColonna.setError(error);
        } else {
            setAllInfoColonna(nomeColonna, null, null, error);
        }
    }
    
    @JsonIgnore
    public InfoColonna getInfoColonna(String nomeColonna) {
        return this.infoColonne.get(nomeColonna);
    }
    
    @JsonIgnore
    public String getNoteInfoColonna(String nomeColonna) {
        InfoColonna infoColonna = this.infoColonne.get(nomeColonna);
        if (infoColonna != null)
            return infoColonna.getNote();
        else
            return null;
    }
    
    @JsonIgnore
    public String getWarningInfoColonna(String nomeColonna) {
        InfoColonna infoColonna = this.infoColonne.get(nomeColonna);
        if (infoColonna != null)
            return infoColonna.getWarning();
        else
            return null;
    }
    
    @JsonIgnore
    public String getErrorInfoColonna(String nomeColonna) {
        InfoColonna infoColonna = this.infoColonne.get(nomeColonna);
        if (infoColonna != null)
            return infoColonna.getError();
        else
            return null;
    }
    
    public static class InfoColonna {
        private String note;
        private String warning;
        private String error;

        public InfoColonna(String note, String warning, String error) {
            this.note = note;
            this.warning = warning;
            this.error = error;
        }

        public String getNote() {
            return note;
        }

        public void setNote(String note) {
            this.note = note;
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
