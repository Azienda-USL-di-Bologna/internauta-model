package it.bologna.ausl.model.entities.shpeck;

import it.bologna.ausl.model.entities.baborg.Azienda;
import it.bologna.ausl.model.entities.baborg.Pec;
import it.bologna.ausl.model.entities.configurazione.Applicazione;
import java.time.ZonedDateTime;
import java.util.List;

/**
 *
 * @author gusgus
 */
public interface MessageInterface {
     public static enum InOut {
        IN, OUT
    }

    public static enum MessageStatus {
        RECEIVED, SENT, TO_SEND, WAITING_RECEPIT, ERROR, CONFIRMED, ACCEPTED, RESENT
    }

    public static enum MessageType {
        ERROR, MAIL, PEC, RECEPIT, DRAFT
    }

    public static enum RelationType {
        RICEVUTA, INOLTRA, RISPONDI, RISPONDI_TUTTI, REINDIRIZZA
    }
    
    public ZonedDateTime getVersion();

    public void setVersion(ZonedDateTime version);

    public Integer getId();

    public void setId(Integer id);

    public String getUuidMessage();

    public void setUuidMessage(String uuidMessage);

    public Pec getIdPec();

    public void setIdPec(Pec idPec);

    public Azienda getIdAziendaRepository();

    public void setIdAziendaRepository(Azienda idAziendaRepository);

    public Applicazione getIdApplicazione();

    public void setIdApplicazione(Applicazione idApplicazione);

    public Message getIdRelated();

    public void setIdRelated(Message idRelated);

    public String getSubject();

    public void setSubject(String subject);

    public MessageStatus getMessageStatus();

    public void setMessageStatus(MessageStatus messageStatus);

    public InOut getInOut();

    public void setInOut(InOut inOut);

    public ZonedDateTime getCreateTime();

    public void setCreateTime(ZonedDateTime createTime);

    public ZonedDateTime getUpdateTime();

    public void setUpdateTime(ZonedDateTime updateTime);

    public MessageType getMessageType();

    public void setMessageType(MessageType messageType);

    public Boolean getIsPec();

    public void setIsPec(Boolean isPec);

    public Integer getAttachmentsNumber();

    public void setAttachmentsNumber(Integer attachmentsNumber);

    public String getUuidRepository();

    public void setUuidRepository(String uuidRepository);

    public String getPathRepository();

    public void setPathRepository(String pathRepository);

    public String getName();

    public void setName(String name);

    public String getExternalId();

    public void setExternalId(String externalId);

    public String getTscol();

    public void setTscol(String tscol);

    public ZonedDateTime getReceiveTime();

    public void setReceiveTime(ZonedDateTime receiveTime);

    public ZonedDateTime getReceiveDateProvider();

    public void setReceiveDateProvider(ZonedDateTime receiveDateProvider);
    
    public Boolean getSeen();

    public void setSeen(Boolean seen);

    public List<MessageAddress> getMessageAddressList();

    public void setMessageAddressList(List<MessageAddress> messageAddressList);

    public List<MessageExtension> getMessageExtensionList();

    public void setMessageExtensionList(List<MessageExtension> messageExtensionList);

    public List<MessageTag> getMessageTagList();

    public void setMessageTagList(List<MessageTag> messageTagList);

    public List<MessageFolder> getMessageFolderList();

    public void setMessageFolderList(List<MessageFolder> messageFolderList);

    public List<RawMessage> getRawMessageList();

    public void setRawMessageList(List<RawMessage> rawMessageList);

    public List<Message> getIdRelatedList();

    public void setIdRelatedList(List<Message> idRelatedList);

    public List<Note> getNoteList();

    public void setNoteList(List<Note> noteList);

    public Recepit getIdRecepit();

    public void setIdRecepit(Recepit idRecepit);

    public String getInReplyTo();

    public void setInReplyTo(String inReplyTo);

    public String getRelationType();

    public void setRelationType(String relationType);

    public Integer getIdOutbox();

    public void setIdOutbox(Integer idOutbox);

    public String getIdMessagePecgw();

    public void setIdMessagePecgw(String idMessagePecgw);
}
