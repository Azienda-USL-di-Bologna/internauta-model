/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.bologna.ausl.model.entities.pecgw;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author Salo
 */
@Entity
@Table(name = "messages")
@NamedQueries({
    @NamedQuery(name = "Message.findAll", query = "SELECT m FROM Message m")})
public class Message implements Serializable {

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
    @Column(name = "id_mail_config")
    private int idMailConfig;
    @Column(name = "id_sender_app")
    private Integer idSenderApp;
    @Column(name = "id_related")
    private Integer idRelated;
    @Size(max = 2147483647)
    @Column(name = "subject")
    private String subject;
    @Column(name = "id_message_status")
    private Integer idMessageStatus;
    @Size(max = 2147483647)
    @Column(name = "in_out")
    private String inOut;
    @Basic(optional = false)
    @NotNull
    @Column(name = "create_time")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createTime;
    @Basic(optional = false)
    @NotNull
    @Column(name = "update_time")
    @Temporal(TemporalType.TIMESTAMP)
    private Date updateTime;
    @Size(max = 2147483647)
    @Column(name = "message_type")
    private String messageType;
    @Basic(optional = false)
    @NotNull
    @Column(name = "is_pec")
    private boolean isPec;
    @Basic(optional = false)
    @NotNull
    @Column(name = "n_attachments")
    private int nAttachments;
    @Size(max = 2147483647)
    @Column(name = "uuid_mongo")
    private String uuidMongo;
    @Size(max = 2147483647)
    @Column(name = "mongo_path")
    private String mongoPath;
    @Size(max = 2147483647)
    @Column(name = "name")
    private String name;
    @Basic(optional = false)
    @NotNull
    @Column(name = "receive_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date receiveDate;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idMessage", fetch = FetchType.LAZY)
    private List<MessageTag> messageTagList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idMessage", fetch = FetchType.LAZY)
    private List<Inbox> inboxList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idMessage", fetch = FetchType.LAZY)
    private List<Outbox> outboxList;

    public Message() {
    }

    public Message(Integer id) {
        this.id = id;
    }

    public Message(Integer id, String uuidMessage, int idMailConfig, Date createTime, Date updateTime, boolean isPec, int nAttachments, Date receiveDate) {
        this.id = id;
        this.uuidMessage = uuidMessage;
        this.idMailConfig = idMailConfig;
        this.createTime = createTime;
        this.updateTime = updateTime;
        this.isPec = isPec;
        this.nAttachments = nAttachments;
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

    public int getIdMailConfig() {
        return idMailConfig;
    }

    public void setIdMailConfig(int idMailConfig) {
        this.idMailConfig = idMailConfig;
    }

    public Integer getIdSenderApp() {
        return idSenderApp;
    }

    public void setIdSenderApp(Integer idSenderApp) {
        this.idSenderApp = idSenderApp;
    }

    public Integer getIdRelated() {
        return idRelated;
    }

    public void setIdRelated(Integer idRelated) {
        this.idRelated = idRelated;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public Integer getIdMessageStatus() {
        return idMessageStatus;
    }

    public void setIdMessageStatus(Integer idMessageStatus) {
        this.idMessageStatus = idMessageStatus;
    }

    public String getInOut() {
        return inOut;
    }

    public void setInOut(String inOut) {
        this.inOut = inOut;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public String getMessageType() {
        return messageType;
    }

    public void setMessageType(String messageType) {
        this.messageType = messageType;
    }

    public boolean getIsPec() {
        return isPec;
    }

    public void setIsPec(boolean isPec) {
        this.isPec = isPec;
    }

    public int getNAttachments() {
        return nAttachments;
    }

    public void setNAttachments(int nAttachments) {
        this.nAttachments = nAttachments;
    }

    public String getUuidMongo() {
        return uuidMongo;
    }

    public void setUuidMongo(String uuidMongo) {
        this.uuidMongo = uuidMongo;
    }

    public String getMongoPath() {
        return mongoPath;
    }

    public void setMongoPath(String mongoPath) {
        this.mongoPath = mongoPath;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getReceiveDate() {
        return receiveDate;
    }

    public void setReceiveDate(Date receiveDate) {
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
