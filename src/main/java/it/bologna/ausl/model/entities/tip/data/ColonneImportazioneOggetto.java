package it.bologna.ausl.model.entities.tip.data;

import it.bologna.ausl.model.entities.tip.SessioneImportazione;
import it.bologna.ausl.model.entities.tip.data.ColonneImportazioneOggettoEnums.ColonneDetermina;
import java.util.List;

/**
 *
 * @author gdm
 */
public interface ColonneImportazioneOggetto {
    public List<String> getValuesList();
    
    public static Class<? extends ColonneImportazioneOggetto> getEnum(SessioneImportazione.TipologiaPregresso tipologia) {
        switch (tipologia) {
            case DETERMINA:
                return ColonneDetermina.class;
            default:
                throw new AssertionError();
        }
    }
    
    public static ColonneImportazioneOggetto findKey(String value, SessioneImportazione.TipologiaPregresso tipologia) {
        String toFind = value.toLowerCase();
        ColonneImportazioneOggetto foundKey = null;
        Class aEnum = getEnum(tipologia);
        
        Object[] enumConstants = aEnum.getEnumConstants();
        ColonneImportazioneOggetto[] values = (ColonneImportazioneOggetto[]) enumConstants;
        for (ColonneImportazioneOggetto key : values) {
            List<String> keyValues = key.getValuesList();
            if (toFind.equals(key.toString().toLowerCase()) || keyValues.contains(toFind)) {
                foundKey = key;
                break;
            }
        }
        return foundKey;
    }
}
