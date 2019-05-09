package it.bologna.ausl.model.entities.shpeck;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Cacheable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 *
 * @author Salo
 */
@Entity
@Table(name = "messages_addresses", catalog = "internauta", schema = "shpeck")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Cacheable(false)
public class MessageAddress implements Serializable {
    
    private  static final long serialVersionUID = 1L;
    
    public static enum AddressRoleType {
        FROM, TO, CC
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    
    @JoinColumn(name = "address", referencedColumnName = "id")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Address idAddress;
    
    @JoinColumn(name = "message", referencedColumnName = "id")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Message idMessage;

    @Column(name = "address_role")
    private String addressRole;

    public MessageAddress() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Address getIdAddress() {
        return idAddress;
    }

    public void setIdAddress(Address address) {
        this.idAddress = address;
    }

    public Message getIdMessage() {
        return idMessage;
    }

    public void setIdMessage(Message idMessage) {
        this.idMessage = idMessage;
    }

    public AddressRoleType getAddressRole() {
        return AddressRoleType.valueOf(addressRole);
    }

    public void setAddressRole(AddressRoleType roleType) {
        this.addressRole = roleType.toString();
    }

    @Override
    public String toString() {
        return "MessageAddress{" + "id=" + id + ", idAddress=" + idAddress + ", idMessage=" + idMessage + ", addressRole=" + addressRole + '}';
    }
}
