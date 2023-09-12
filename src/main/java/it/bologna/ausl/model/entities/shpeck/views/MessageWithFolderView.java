package it.bologna.ausl.model.entities.shpeck.views;

import it.bologna.ausl.model.entities.shpeck.*;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import it.nextsw.common.data.annotations.GenerateProjections;
import it.bologna.ausl.model.entities.baborg.Azienda;
import it.bologna.ausl.model.entities.baborg.Pec;
import it.bologna.ausl.model.entities.configurazione.Applicazione;
import it.bologna.ausl.model.entities.scripta.MessageDoc;
import java.io.Serializable;
import java.time.ZonedDateTime;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Cacheable;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Version;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import org.hibernate.annotations.DynamicUpdate;
import org.springframework.format.annotation.DateTimeFormat;

/**
 *
 * @author gusgus
 */
@Entity
@Table(name = "messages_with_folders_view", catalog = "internauta", schema = "shpeck")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Cacheable(false)
@GenerateProjections({"idRecepit, messageAddressList", "messageAddressList, messageFolderList, messageTagList, messageDocList"})
@DynamicUpdate
public class MessageWithFolderView implements Serializable, MessageInterface {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;

    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2147483647)
    @Column(name = "uuid_message")
    private String uuidMessage;

    @Basic(optional = false)
    @NotNull
    @JoinColumn(name = "id_pec", referencedColumnName = "id")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Pec idPec;

    @JoinColumn(name = "id_azienda_repository", referencedColumnName = "id")
    @ManyToOne(optional = true, fetch = FetchType.LAZY)
    private Azienda idAziendaRepository;

    @JoinColumn(name = "id_applicazione", referencedColumnName = "id")
    @ManyToOne(optional = true, fetch = FetchType.LAZY)
    private Applicazione idApplicazione;

    @JoinColumn(name = "id_related", referencedColumnName = "id")
    @ManyToOne(optional = true, fetch = FetchType.LAZY)
    private Message idRelated;

    @Size(max = 2147483647)
    @Column(name = "subject")
    private String subject;

    @Column(name = "message_status")
    private String messageStatus;

    @Size(max = 2147483647)
    @Column(name = "in_out")
    private String inOut;

    @Basic(optional = false)
    @NotNull
    @Column(name = "create_time")
    @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss.SSSSSSXXX'['VV']'")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss.SSSSSSXXX'['VV']'")
    private ZonedDateTime createTime = ZonedDateTime.now();

    @Basic(optional = false)
    @NotNull
    @Column(name = "update_time")
    @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss.SSSSSSXXX'['VV']'")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss.SSSSSSXXX'['VV']'")
    private ZonedDateTime updateTime = ZonedDateTime.now();

    @Size(max = 2147483647)
    @Column(name = "message_type")
    private String messageType;

    @Basic(optional = false)
    @NotNull
    @Column(name = "is_pec")
    private Boolean isPec;

    @Basic(optional = false)
    @NotNull
    @Column(name = "attachments_number")
    private Integer attachmentsNumber;

    @Size(max = 2147483647)
    @Column(name = "uuid_repository")
    private String uuidRepository;

    @Size(max = 2147483647)
    @Column(name = "path_repository")
    private String pathRepository;

    @Size(max = 2147483647)
    @Column(name = "name")
    private String name;

    @Basic(optional = false)
    @NotNull
    @Column(name = "receive_time")
    @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss.SSSSSSXXX'['VV']'")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss.SSSSSSXXX'['VV']'")
    private ZonedDateTime receiveTime = ZonedDateTime.now();
    
    @Basic(optional = true)
    @Column(name = "receive_date_provider")
    @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss.SSSSSSXXX'['VV']'")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss.SSSSSSXXX'['VV']'")
    private ZonedDateTime receiveDateProvider = ZonedDateTime.now();

    @Size(max = 2147483647)
    @Column(name = "external_id")
    private String externalId;

    @Basic(optional = false)
    @NotNull
    @Column(name = "seen")
    private Boolean seen = false;

    @Size(max = 2147483647)
    @Column(name = "tscol", columnDefinition = "tsvector")
    private String tscol;

    @OneToMany(cascade = {CascadeType.MERGE, CascadeType.PERSIST}, mappedBy = "idMessage", fetch = FetchType.LAZY)
    @JsonBackReference(value = "messageAddressList")
    private List<MessageAddress> messageAddressList;

    @OneToMany(cascade = {CascadeType.MERGE, CascadeType.PERSIST}, mappedBy = "id", fetch = FetchType.EAGER)
    @JsonBackReference(value = "messageExtensionList")
    private List<MessageExtension> messageExtensionList;

//    @Formula("(select shpeck.messages_addresses ma where ma.address_role = 'FROM' and ma.message = id)")
//    private MessageAddress messageAddressFrom;
//    @JsonIgnore
//    @Formula("(select a.mail_address from shpeck.messages_addresses ma join shpeck.addresses a on a.id = ma.address where ma.address_role = 'FROM' and ma.message = id)")
//    private String addressFrom;
    @OneToMany(cascade = {CascadeType.MERGE, CascadeType.PERSIST}, mappedBy = "idMessage", fetch = FetchType.LAZY)
    @JsonBackReference(value = "messageTagList")
    private List<MessageTag> messageTagList;

    @OneToMany(cascade = {CascadeType.MERGE, CascadeType.PERSIST}, mappedBy = "idMessage", fetch = FetchType.LAZY)
    @JsonBackReference(value = "messageFolderList")
    private List<MessageFolder> messageFolderList;

    @OneToMany(cascade = {CascadeType.MERGE, CascadeType.PERSIST}, mappedBy = "idMessage", fetch = FetchType.LAZY)
    @JsonBackReference(value = "rawMessageList")
    private List<RawMessage> rawMessageList;

    @OneToMany(cascade = {CascadeType.MERGE, CascadeType.PERSIST}, mappedBy = "idRelated", fetch = FetchType.LAZY)
    @JsonBackReference(value = "idRelatedList")
    private List<Message> idRelatedList;

    @OneToMany(cascade = {CascadeType.MERGE, CascadeType.PERSIST}, mappedBy = "idMessage", fetch = FetchType.LAZY)
    @JsonBackReference(value = "noteList")
    private List<Note> noteList;

    @OneToOne(optional = true, cascade = {CascadeType.MERGE, CascadeType.PERSIST}, mappedBy = "idMessage", fetch = FetchType.LAZY)
//    @Fetch(FetchMode.JOIN)
    @JsonBackReference(value = "idRecepit")
    private Recepit idRecepit;

    @JsonBackReference(value = "in_reply_to")
    private String inReplyTo;

    @JsonBackReference(value = "relation_type")
    private String relationType;

    @Column(name = "id_outbox")
    private Integer idOutbox;

    @Column(name = "id_message_pecgw")
    private String idMessagePecgw;

    @Version()
    @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss.SSSSSSXXX'['VV']'")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss.SSSSSSXXX'['VV']'")
    private ZonedDateTime version;
    
    @JoinColumn(name = "id_folder", referencedColumnName = "id")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Folder idFolder;
    
    @Column(name = "deleted")
    private Boolean deleted = false;
    
    @OneToMany(cascade = {CascadeType.MERGE, CascadeType.PERSIST}, mappedBy = "idMessage", fetch = FetchType.LAZY)
    @JsonBackReference(value = "messageDocList")
    private List<MessageDoc> messageDocList;

    public ZonedDateTime getVersion() {
        return version;
    }

    public void setVersion(ZonedDateTime version) {
        this.version = version;
    }

    public MessageWithFolderView() {
    }

    public MessageWithFolderView(Integer id) {
        this.id = id;
    }

    public MessageWithFolderView(Integer id, String uuidMessage, Pec idPec, Applicazione idApplicazione, Message idRelated, String subject, String messageStatus, String inOut, ZonedDateTime createTime, ZonedDateTime updateTime, String messageType, Boolean isPec, Integer attachmentsNumber, String uuidMongo, String mongoPath, String name, ZonedDateTime receiveTime) {
        this.id = id;
        this.uuidMessage = uuidMessage;
        this.idPec = idPec;
        this.idApplicazione = idApplicazione;
        this.idRelated = idRelated;
        this.subject = subject;
        this.messageStatus = messageStatus;
        this.inOut = inOut;
        this.createTime = createTime;
        this.updateTime = updateTime;
        this.messageType = messageType;
        this.isPec = isPec;
        this.attachmentsNumber = attachmentsNumber;
        this.uuidRepository = uuidMongo;
        this.pathRepository = mongoPath;
        this.name = name;
        this.receiveTime = receiveTime;
    }
    
    public MessageWithFolderView(Integer id, String uuidMessage, Pec idPec, Applicazione idApplicazione, Message idRelated, String subject, String messageStatus, String inOut, ZonedDateTime createTime, ZonedDateTime updateTime, String messageType, Boolean isPec, Integer attachmentsNumber, String uuidMongo, String mongoPath, String name, ZonedDateTime receiveTime, ZonedDateTime receiveDateProvider) {
        this.id = id;
        this.uuidMessage = uuidMessage;
        this.idPec = idPec;
        this.idApplicazione = idApplicazione;
        this.idRelated = idRelated;
        this.subject = subject;
        this.messageStatus = messageStatus;
        this.inOut = inOut;
        this.createTime = createTime;
        this.updateTime = updateTime;
        this.messageType = messageType;
        this.isPec = isPec;
        this.attachmentsNumber = attachmentsNumber;
        this.uuidRepository = uuidMongo;
        this.pathRepository = mongoPath;
        this.name = name;
        this.receiveTime = receiveTime;
        this.receiveDateProvider = receiveDateProvider;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUuidMessage() {
        return uuidMessage;
    }

    public void setUuidMessage(String uuidMessage) {
        this.uuidMessage = uuidMessage;
    }

    public Pec getIdPec() {
        return idPec;
    }

    public void setIdPec(Pec idPec) {
        this.idPec = idPec;
    }

    public Azienda getIdAziendaRepository() {
        return idAziendaRepository;
    }

    public void setIdAziendaRepository(Azienda idAziendaRepository) {
        this.idAziendaRepository = idAziendaRepository;
    }

    public Applicazione getIdApplicazione() {
        return idApplicazione;
    }

    public void setIdApplicazione(Applicazione idApplicazione) {
        this.idApplicazione = idApplicazione;
    }

    public Message getIdRelated() {
        return idRelated;
    }

    public void setIdRelated(Message idRelated) {
        this.idRelated = idRelated;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public MessageStatus getMessageStatus() {
        return MessageStatus.valueOf(messageStatus);
    }

    public void setMessageStatus(MessageStatus messageStatus) {
        this.messageStatus = messageStatus.toString();
    }

    public InOut getInOut() {
        return InOut.valueOf(inOut);
    }

    public void setInOut(InOut inOut) {
        this.inOut = inOut.toString();
    }

    public ZonedDateTime getCreateTime() {
        return createTime;
    }

    public void setCreateTime(ZonedDateTime createTime) {
        this.createTime = createTime;
    }

    public ZonedDateTime getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(ZonedDateTime updateTime) {
        this.updateTime = updateTime;
    }

    public MessageType getMessageType() {
        return MessageType.valueOf(messageType);
    }

    public void setMessageType(MessageType messageType) {
        this.messageType = messageType.toString();
    }

    public Boolean getIsPec() {
        return isPec;
    }

    public void setIsPec(Boolean isPec) {
        this.isPec = isPec;
    }

    public Integer getAttachmentsNumber() {
        return attachmentsNumber;
    }

    public void setAttachmentsNumber(Integer attachmentsNumber) {
        this.attachmentsNumber = attachmentsNumber;
    }

    public String getUuidRepository() {
        return uuidRepository;
    }

    public void setUuidRepository(String uuidRepository) {
        this.uuidRepository = uuidRepository;
    }

    public String getPathRepository() {
        return pathRepository;
    }

    public void setPathRepository(String pathRepository) {
        this.pathRepository = pathRepository;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getExternalId() {
        return externalId;
    }

    public void setExternalId(String externalId) {
        this.externalId = externalId;
    }

    public String getTscol() {
        return tscol;
    }

    public void setTscol(String tscol) {
        this.tscol = tscol;
    }

    public ZonedDateTime getReceiveTime() {
        return receiveTime;
    }

    public void setReceiveTime(ZonedDateTime receiveTime) {
        this.receiveTime = receiveTime;
    }

    public ZonedDateTime getReceiveDateProvider() {
        return receiveDateProvider;
    }

    public void setReceiveDateProvider(ZonedDateTime receiveDateProvider) {
        this.receiveDateProvider = receiveDateProvider;
    }
    
    public Boolean getSeen() {
        return seen;
    }

    public void setSeen(Boolean seen) {
        this.seen = seen;
    }

    public List<MessageAddress> getMessageAddressList() {
        return messageAddressList;
    }

    public void setMessageAddressList(List<MessageAddress> messageAddressList) {
        this.messageAddressList = messageAddressList;
    }

    public List<MessageExtension> getMessageExtensionList() {
        return messageExtensionList;
    }

    public void setMessageExtensionList(List<MessageExtension> messageExtensionList) {
        this.messageExtensionList = messageExtensionList;
    }

//    public String getAddressFrom() {
//        return addressFrom;
//    }
//    public MessageAddress getMessageAddressFrom() {
//        return messageAddressFrom;
//    }
//
//    public void setMessageAddressFrom(MessageAddress messageAddressFrom) {
//        this.messageAddressFrom = messageAddressFrom;
//    }
//    public void setAddressFrom(String addressFrom) {
//        this.addressFrom = addressFrom;
//    }
    public List<MessageTag> getMessageTagList() {
        return messageTagList;
    }

    public void setMessageTagList(List<MessageTag> messageTagList) {
        this.messageTagList = messageTagList;
    }

    public List<MessageFolder> getMessageFolderList() {
        return messageFolderList;
    }

    public void setMessageFolderList(List<MessageFolder> messageFolderList) {
        this.messageFolderList = messageFolderList;
    }

    public List<RawMessage> getRawMessageList() {
        return rawMessageList;
    }

    public void setRawMessageList(List<RawMessage> rawMessageList) {
        this.rawMessageList = rawMessageList;
    }

    public List<Message> getIdRelatedList() {
        return idRelatedList;
    }

    public void setIdRelatedList(List<Message> idRelatedList) {
        this.idRelatedList = idRelatedList;
    }

    public List<Note> getNoteList() {
        return noteList;
    }

    public void setNoteList(List<Note> noteList) {
        this.noteList = noteList;
    }

    public Recepit getIdRecepit() {
        return idRecepit;
    }

    public void setIdRecepit(Recepit idRecepit) {
        this.idRecepit = idRecepit;
    }

    public String getInReplyTo() {
        return inReplyTo;
    }

    public void setInReplyTo(String inReplyTo) {
        this.inReplyTo = inReplyTo;
    }

    public String getRelationType() {
        return relationType;
    }

    public void setRelationType(String relationType) {
        this.relationType = relationType;
    }

    public Integer getIdOutbox() {
        return idOutbox;
    }

    public void setIdOutbox(Integer idOutbox) {
        this.idOutbox = idOutbox;
    }

    public String getIdMessagePecgw() {
        return idMessagePecgw;
    }

    public void setIdMessagePecgw(String idMessagePecgw) {
        this.idMessagePecgw = idMessagePecgw;
    }
    
    public Boolean getDeleted() {
        return deleted;
    }

    public void setDeleted(Boolean deleted) {
        this.deleted = deleted;
    }
    
    public Folder getIdFolder() {
        return idFolder;
    }

    public void setIdFolder(Folder idFolder) {
        this.idFolder = idFolder;
    }
    
    public List<MessageDoc> getMessageDocList() {
        return messageDocList;
    }

    public void setMessageDocList(List<MessageDoc> messageDocList) {
        this.messageDocList = messageDocList;
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
        if (!(object instanceof MessageWithFolderView)) {
            return false;
        }
        MessageWithFolderView other = (MessageWithFolderView) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "MessageWithFolderView{" + "id=" + id + ", uuidMessage=" + uuidMessage + ", subject=" + subject + ", messageStatus=" + messageStatus
                + ", inOut=" + inOut + ", createTime=" + createTime + ", updateTime=" + updateTime
                + ", messageType=" + messageType + ", attachmentsNumber=" + attachmentsNumber
                + ", uuidRepository=" + uuidRepository + ", pathRepository=" + pathRepository
                + ", receiveTime=" + receiveTime + ", seen=" + seen + ", inReplyTo=" + inReplyTo
                + ", relationType=" + relationType + ", idOutbox=" + idOutbox + ", id_message_vecchio=" + idMessagePecgw
                + ", idAzienda=" + idAziendaRepository + '}';
    }
}
