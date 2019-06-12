package it.bologna.ausl.model.entities.shpeck;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import it.bologna.ausl.model.entities.baborg.Pec;
import java.io.Serializable;
import java.util.List;
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
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author Salo
 */
@Entity
@Table(name = "folders", catalog = "internauta", schema = "shpeck")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Folder implements Serializable {

    public static enum FolderType {
        DRAFT, INBOX, OUTBOX, TRASH, SPAM, CUSTOM, SENT, REGISTERED
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

    @JoinColumn(name = "id_pec", referencedColumnName = "id")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @JsonBackReference(value = "idPec")
    private Pec idPec;
        
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idFolder", fetch = FetchType.LAZY)
    @JsonBackReference(value = "messageFolderList")
    private List<MessageFolder> messageFolderList;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idPreviousFolder", fetch = FetchType.LAZY)
    @JsonBackReference(value = "messagePreviousFolderList")
    private List<MessageFolder> messagePreviousFolderList;

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

    public Pec getIdPec() {
        return idPec;
    }

    public void setIdPec(Pec idPec) {
        this.idPec = idPec;
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
