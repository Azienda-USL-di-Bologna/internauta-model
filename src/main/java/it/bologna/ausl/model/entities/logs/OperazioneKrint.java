package it.bologna.ausl.model.entities.logs;

import com.fasterxml.jackson.annotation.JsonFormat;
import it.nextsw.common.annotations.GenerateProjections;
import java.io.Serializable;
import java.time.ZonedDateTime;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Version;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import org.hibernate.annotations.DynamicUpdate;
import org.springframework.format.annotation.DateTimeFormat;

/**
 *
 * @author Utente
 */
@Entity
@Table(name = "operazioni_krint", catalog = "internauta", schema = "logs")
@GenerateProjections({})
@DynamicUpdate
public class OperazioneKrint implements Serializable {
    
    public static enum CodiceOperazione{
        // Operazione Shpeck
        PEC_MESSAGE_SPOSTAMENTO,
        PEC_MESSAGE_PROTOCOLLAZIONE,
        PEC_MESSAGE_REMOVE_PROTOCOLLAZIONE,
        PEC_MESSAGE_IN_PROTOCOLLAZIONE,
        PEC_MESSAGE_REMOVE_IN_PROTOCOLLAZIONE,
        PEC_MESSAGE_REINDIRIZZAMENTO_IN,
        PEC_MESSAGE_REINDIRIZZAMENTO_OUT,
        PEC_MESSAGE_RISPOSTA,
        PEC_MESSAGE_RISPOSTA_A_TUTTI,
        PEC_MESSAGE_INOLTRO,
        PEC_MESSAGE_AGGIUNTA_TAG,
        PEC_MESSAGE_ELIMINAZIONE_TAG,
        PEC_MESSAGE_LETTO,
        PEC_MESSAGE_DA_LEGGERE,
        PEC_MESSAGE_FASCICOLAZIONE,
        PEC_MESSAGE_ERRORE_NON_VISTO,
        PEC_MESSAGE_ERRORE_VISTO,
        PEC_MESSAGE_DELETE_FROM_TRASH,
        PEC_MESSAGE_INVIO_NUOVA_MAIL,
        PEC_DRAFT_CREAZIONE,
        PEC_DRAFT_MODIFICA,
        PEC_DRAFT_CANCELLAZIONE,
        PEC_FOLDER_CREAZIONE,
        PEC_FOLDER_RINOMINA,
        PEC_FOLDER_ELIMINAZIONE,
        PEC_TAG_CREAZIONE,
        PEC_TAG_RINOMINA,
        PEC_TAG_ELIMINAZIONE,
        
        // Operazioni baborg
        BABORG_UFFICIO_CREATION,
        BABORG_UFFICIO_DELETE,
        BABORG_UFFICIO_ATTRIBUTI_STRUTTURA_UPDATE,
        BABORG_UFFICIO_STRUTTURA_PADRE_UPDATE,
        BABORG_UFFICIO_NOME_UPDATE,
        BABORG_UFFICIO_UTENTE_STRUTTURA_LIST_ADD,
        BABORG_UFFICIO_UTENTE_STRUTTURA_LIST_REMOVE,
        BABORG_UFFICIO_STRUTTURE_CONNESSE_LIST_ADD,
        BABORG_UFFICIO_STRUTTURE_CONNESSE_LIST_REMOVE,
        BABORG_UFFICIO_STRUTTURE_CONNESSE_LIST_PROPAGA_ADD,
        BABORG_UFFICIO_STRUTTURE_CONNESSE_LIST_PROPAGA_REMOVE,
        
        // Operazioni rubrica
        RUBRICA_CONTACT_CREATION,
        RUBRICA_CONTACT_DELETE,
        RUBRICA_CONTACT_RESTORE,
        RUBRICA_CONTACT_UPDATE,
        RUBRICA_CONTACT_DETAIL_CREATION,
        RUBRICA_CONTACT_DETAIL_DELETE,
        RUBRICA_CONTACT_DETAIL_UPDATE,
        RUBRICA_GROUP_CREATION,
        RUBRICA_GROUP_DELETE,
        RUBRICA_GROUP_RESTORE,
        RUBRICA_GROUP_UPDATE,
        RUBRICA_GROUP_CONTACT_CREATION,
        RUBRICA_GROUP_CONTACT_DELETE,
        RUBRICA_GROUP_CONTACT_UPDATE,
        RUBRICA_CONTACT_MERGE,
        
        // Operazioni Archivio
        SCRIPTA_ATTORE_ARCHIVIO_CREATION,
        SCRIPTA_ATTORE_ARCHIVIO_UPDATE,
        SCRIPTA_ATTORE_ARCHIVIO_DELETE
    }

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "codice")
    private String codice;
    @Size(max = 2147483647)
    @Column(name = "descrizione")
    private String descrizione;
        
    @Version()
    @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss.SSSSSSXXX'['VV']'")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss.SSSSSSXXX'['VV']'")
    private ZonedDateTime version;

    public ZonedDateTime getVersion() {
        return version;
    }

    public void setVersion(ZonedDateTime version) {
        this.version = version;
    }
    
    public OperazioneKrint() {
    }

    public OperazioneKrint(Integer id) {
        this.id = id;
    }

    public OperazioneKrint(Integer id, String codice) {
        this.id = id;
        this.codice = codice;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCodice() {
        return codice;
    }

    public void setCodice(String codice) {
        this.codice = codice;
    }

    public String getDescrizione() {
        return descrizione;
    }

    public void setDescrizione(String descrizione) {
        this.descrizione = descrizione;
    }


    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof OperazioneKrint)) {
            return false;
        }
        OperazioneKrint other = (OperazioneKrint) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "it.bologna.ausl.model.entities.logs.OperazioniKrint[ id=" + id + " ]";
    }
    
}
