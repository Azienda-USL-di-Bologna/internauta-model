package it.bologna.ausl.model.entities.shpeck;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import it.bologna.ausl.model.entities.baborg.Pec;
import it.bologna.ausl.model.entities.configuration.Applicazione;
import java.io.Serializable;
import java.time.LocalDateTime;
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
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import org.springframework.format.annotation.DateTimeFormat;

/**
 *
 * @author Salo
 */
@Entity
@Table(name = "messages", schema = "shpeck")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Cacheable(false)
public class Message implements Serializable {

        public static enum InOut {
        IN, OUT
    }
    
    public static enum MessageStatus {
        RECEIVED, SENT, TO_SEND, WAITING_RECEPIT, ERROR, CONFIRMED
    }
    
    public static enum MessageType {
        ERRORE, MAIL, PEC, RICEVUTA
    }
    
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
    
    @JoinColumn(name = "id_applicazione", referencedColumnName = "id")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Applicazione idApplicazione;
    
    @JoinColumn(name = "id_related", referencedColumnName = "id")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
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
    @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss")
    private LocalDateTime createTime;
    
    @Basic(optional = false)
    @NotNull
    @Column(name = "update_time")
    @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss")
    private LocalDateTime updateTime;
    
    @Size(max = 2147483647)
    @Column(name = "message_type")
    private String messageType;
    
    @Basic(optional = false)
    @NotNull
    @Column(name = "is_pec")
    private Boolean isPec;
    
    @Basic(optional = false)
    @NotNull
    @Column(name = "n_attachments")
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
    @Column(name = "receive_date")
    @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss")
    private LocalDateTime receiveDate;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idMessage", fetch = FetchType.LAZY)
    private List<MessageTag> messageTagList;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idMessage", fetch = FetchType.LAZY)
    private List<Inbox> inboxList;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idMessage", fetch = FetchType.LAZY)
    private List<Outbox> outboxList;

    @OneToOne(optional=true, cascade = CascadeType.ALL, mappedBy = "idMessage", fetch = FetchType.LAZY)
//    @Fetch(FetchMode.JOIN)
    private Recepit idRecepit;
    
    public Message() {
    }

    public Message(Integer id) {
        this.id = id;
    }

    public Message(Integer id, String uuidMessage, Pec idPec, Applicazione idApplicazione, Message idRelated, String subject, String messageStatus, String inOut, LocalDateTime createTime, LocalDateTime updateTime, String messageType, Boolean isPec, Integer attachmentsNumber, String uuidMongo, String mongoPath, String name, LocalDateTime receiveDate) {
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
        this.receiveDate = receiveDate;
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

    public LocalDateTime getCreateTime() {
        return createTime;
    }

    public void setCreateTime(LocalDateTime createTime) {
        this.createTime = createTime;
    }

    public LocalDateTime getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(LocalDateTime updateTime) {
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

    public LocalDateTime getReceiveDate() {
        return receiveDate;
    }

    public void setReceiveDate(LocalDateTime receiveDate) {
        this.receiveDate = receiveDate;
    }

    public List<MessageTag> getMessageTagList() {
        return messageTagList;
    }

    public void setMessageTagList(List<MessageTag> messageTagList) {
        this.messageTagList = messageTagList;
    }

    public List<Inbox> getInboxList() {
        return inboxList;
    }

    public void setInboxList(List<Inbox> inboxList) {
        this.inboxList = inboxList;
    }

    public List<Outbox> getOutboxList() {
        return outboxList;
    }

    public void setOutboxList(List<Outbox> outboxList) {
        this.outboxList = outboxList;
    }

    public Recepit getIdRecepit() {
        return idRecepit;
    }

    public void setIdRecepit(Recepit idRecepit) {
        this.idRecepit = idRecepit;
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
        if (!(object instanceof Message)) {
            return false;
        }
        Message other = (Message) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "it.bologna.ausl.model.entities.pecgw.Message[ id=" + id + " ]";
    }
    
}
