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
 * 
 * Interfaccia che accomuna i vari enum che descrivono i campi delle entità delle tabelle di importazione (importazioni_documenti/importazioni_archivi)
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
public interface ColonneImportazioneOggetto extends KeyValueEnum<List<String>> {
    
    /**
     * torna l'enum corretto in base alla tipologia
     * @param tipologia
     * @return 
     */
    public static Class<? extends ColonneImportazioneOggetto> getColumnsEnum(SessioneImportazione.TipologiaPregresso tipologia) {
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
    
    /**
     * Reperisce l'enum delle colonne specifiche dell'oggetto che si vuole importare e ne trova il singolo valore corrispondente a seconda del header.
     * Per farlo viene usato un enum che ha come chiave il nome del campo della classe e come valori i possibili nomi degli header associati
     * @param value il valore del valore enum da cercare (corrisponde al nome dell'header del csv)
     * @param tipologia la tipologia di importazione. Serve per capire in quale enum cercare, dato che ce n'è uno per ogni tipologia
     * @return il singolo valore enum che si chiama come il campo sull'entità, null se non la trova
     */
    public static ColonneImportazioneOggetto findKey(String value, SessioneImportazione.TipologiaPregresso tipologia) {
        String toFind = value.toLowerCase();
        ColonneImportazioneOggetto foundKey = null;
        Class aEnum = getColumnsEnum(tipologia);
        
        Object[] enumConstants = aEnum.getEnumConstants();
        ColonneImportazioneOggetto[] values = (ColonneImportazioneOggetto[]) enumConstants;
        for (ColonneImportazioneOggetto key : values) {
            List<String> keyValues = key.getValue();
            if (toFind.equals(key.toString().toLowerCase()) || keyValues.contains(toFind)) {
                foundKey = key;
                break;
            }
        }
        return foundKey;
    }

    public ColonneImportazioneOggetto getErroriColumn();
}
