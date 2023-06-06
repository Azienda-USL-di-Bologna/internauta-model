package it.bologna.ausl.model.entities.shpeck;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.vladmihalcea.hibernate.type.json.JsonBinaryType;
import it.nextsw.common.annotations.GenerateProjections;
import it.bologna.ausl.model.entities.baborg.Pec;
import it.bologna.ausl.model.entities.baborg.Utente;
import java.io.Serializable;
import java.time.ZonedDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.persistence.Basic;
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
import javax.persistence.Table;
import javax.persistence.Version;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.springframework.format.annotation.DateTimeFormat;

/**
 *
 * @author Salo
 */
@Entity
@Table(name = "folders", catalog = "internauta", schema = "shpeck")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@GenerateProjections({})
@DynamicUpdate
@TypeDef(name = "jsonb", typeClass = JsonBinaryType.class)
public class Folder implements Serializable {

    public static enum FolderType {
        DRAFT, INBOX, OUTBOX, TRASH, SPAM, CUSTOM, SENT, REGISTERED
        // READDRESSED
    }

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;

    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2147483647)
    @Column(name = "name")
    private String name;

    @Size(max = 2147483647)
    @Column(name = "description")
    private String description;

    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2147483647)
    @Column(name = "type")
    private String type;

    @Basic(optional = true)
    @Column(name = "`order`")
    private Integer order;

    @JoinColumn(name = "id_pec", referencedColumnName = "id")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @JsonBackReference(value = "idPec")
    private Pec idPec;

    @JoinColumn(name = "id_utente", referencedColumnName = "id")
    @ManyToOne(fetch = FetchType.LAZY)
    @JsonBackReference(value = "idUtente")
    private Utente idUtente;

    @Basic(optional = false)
    @Column(name = "create_time")
    @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss.SSSSSSXXX'['VV']'")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss.SSSSSSXXX'['VV']'")
    private ZonedDateTime createTime = ZonedDateTime.now();

    @Basic(optional = false)
    @Column(name = "update_time")
    @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss.SSSSSSXXX'['VV']'")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss.SSSSSSXXX'['VV']'")
    private ZonedDateTime updateTime = ZonedDateTime.now();

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idFolder", fetch = FetchType.LAZY)
    @JsonBackReference(value = "messageFolderList")
    private List<MessageFolder> messageFolderList;

    @OneToMany(cascade = {CascadeType.MERGE, CascadeType.PERSIST}, mappedBy = "idPreviousFolder", fetch = FetchType.LAZY)
    @JsonBackReference(value = "messagePreviousFolderList")
    private List<MessageFolder> messagePreviousFolderList;

    @Version()
    @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss.SSSSSSXXX'['VV']'")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss.SSSSSSXXX'['VV']'")
    private ZonedDateTime version;

    @Basic(optional = true)
    @Size(min = 1, max = 2147483647)
    @Column(name = "name_orig")
    private String nameInProvider;

    @Basic(optional = true)
    @Size(min = 1, max = 2147483647)
    @Column(name = "fullname_orig")
    private String fullnameInProvider;
    
    @Type(type = "jsonb")
    @Column(name = "additional_data", columnDefinition = "jsonb")
    private HashMap<String,Object> additionalData;

    @Column(name = "unread_messages")
    private Integer unreadMessages = 0;

    public ZonedDateTime getVersion() {
        return version;
    }

    public void setVersion(ZonedDateTime version) {
        this.version = version;
    }

    public Folder() {
    }

    public Folder(Integer id) {
        this.id = id;
    }

    public Folder(Integer id, String name, FolderType type) {
        this.id = id;
        this.name = name;
        this.type = type.toString();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public FolderType getType() {
        return FolderType.valueOf(type);
    }

    public void setType(FolderType type) {
        this.type = type.toString();
    }

    public Integer getOrder() {
        return order;
    }

    public void setOrder(Integer order) {
        this.order = order;
    }

    public Pec getIdPec() {
        return idPec;
    }

    public void setIdPec(Pec idPec) {
        this.idPec = idPec;
    }

    public Utente getIdUtente() {
        return idUtente;
    }

    public void setIdUtente(Utente idUtente) {
        this.idUtente = idUtente;
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

    public List<MessageFolder> getMessageFolderList() {
        return messageFolderList;
    }

    public void setMessageFolderList(List<MessageFolder> messageFolderList) {
        this.messageFolderList = messageFolderList;
    }

    public List<MessageFolder> getMessagePreviousFolderList() {
        return messagePreviousFolderList;
    }

    public void setMessagePreviousFolderList(List<MessageFolder> messagePreviousFolderList) {
        this.messagePreviousFolderList = messagePreviousFolderList;
    }

    public HashMap<String,Object> getAdditionalData() {
        return additionalData;
    }

    public void setAdditionalData(HashMap<String,Object> additionalData) {
        this.additionalData = additionalData;
    }

    public Integer getUnreadMessages() {
        return unreadMessages;
    }

    public void setUnreadMessages(Integer unreadMessages) {
        this.unreadMessages = unreadMessages;
    }

    public String getNameInProvider() {
        return nameInProvider;
    }

    public void setNameInProvider(String nameInProvider) {
        this.nameInProvider = nameInProvider;
    }

    public String getFullnameInProvider() {
        return fullnameInProvider;
    }

    public void setFullnameInProvider(String fullnameInProvider) {
        this.fullnameInProvider = fullnameInProvider;
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
        if (!(object instanceof Folder)) {
            return false;
        }
        Folder other = (Folder) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "it.bologna.ausl.model.entities.shpec.Folder[ id=" + id + " ]";
    }

}
