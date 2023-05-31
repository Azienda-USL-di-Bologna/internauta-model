package it.bologna.ausl.model.entities.tip.data;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import it.bologna.ausl.model.entities.tip.SessioneImportazione;
import it.bologna.ausl.model.entities.tip.data.ColonneImportazioneOggettoEnums.ColonneDelibera;
import it.bologna.ausl.model.entities.tip.data.ColonneImportazioneOggettoEnums.ColonneDetermina;
import it.bologna.ausl.model.entities.tip.data.ColonneImportazioneOggettoEnums.ColonneProtocolloEntrata;
import it.bologna.ausl.model.entities.tip.data.ColonneImportazioneOggettoEnums.ColonneProtocolloUscita;
import java.util.List;

/**
 *
 * @author gdm
 */
@JsonTypeInfo(
        use = JsonTypeInfo.Id.CLASS,
        include = JsonTypeInfo.As.PROPERTY,
        property = "classz")

// Per permettere la generazione corretta del JSON bisogna inserire un @JsonSubTypes.Type per ogni implementazione di questa classe astratta
@JsonSubTypes({
    @JsonSubTypes.Type(value = ColonneDelibera.class, name = "ColonneDelibera"),
    @JsonSubTypes.Type(value = ColonneDetermina.class, name = "ColonneDetermina"),
    @JsonSubTypes.Type(value = ColonneProtocolloEntrata.class, name = "ColonneProtocolloEntrata"),
    @JsonSubTypes.Type(value = ColonneProtocolloUscita.class, name = "ColonneProtocolloUscita")})
public interface ColonneImportazioneOggetto {
    public List<String> getValuesList();
    
    public static Class<? extends ColonneImportazioneOggetto> getEnum(SessioneImportazione.TipologiaPregresso tipologia) {
        switch (tipologia) {
            case PROTOCOLLO_IN_ENTRATA:
                return ColonneProtocolloEntrata.class;
            case PROTOCOLLO_IN_USCITA:
                return ColonneProtocolloUscita.class;
            case DETERMINA:
                return ColonneDetermina.class;
            case DELIBERA:
                return ColonneDelibera.class;
            default:
                throw new AssertionError(String.format("tipologia %s non valida", tipologia));
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
