package it.bologna.ausl.model.entities.shpeck;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author Salo
 */
@Entity
@Table(name = "inbox", catalog = "internauta", schema = "shpeck")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Inbox implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2147483647)
    @Column(name = "raw_message")
    private String rawMessage;
    @JoinColumn(name = "id_message", referencedColumnName = "id")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Message idMessage;

    public Inbox() {
    }

    public Inbox(Integer id) {
        this.id = id;
    }

    public Inbox(Integer id, String rawMessage) {
        this.id = id;
        this.rawMessage = rawMessage;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getRawMessage() {
        return rawMessage;
    }

    public void setRawMessage(String rawMessage) {
        this.rawMessage = rawMessage;
    }

    public Message getIdMessage() {
        return idMessage;
    }

    public void setIdMessage(Message idMessage) {
        this.idMessage = idMessage;
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
        if (!(object instanceof Inbox)) {
            return false;
        }
        Inbox other = (Inbox) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "it.bologna.ausl.model.entities.pecgw.Inbox[ id=" + id + " ]";
    }
    
}
