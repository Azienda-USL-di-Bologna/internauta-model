package it.bologna.ausl.model.entities.shpeck;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Cacheable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author Salo
 */
@Entity
@Table(name = "addresses", catalog = "internauta", schema = "shpeck")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Cacheable(false)
public class Address implements Serializable {

    private  static final long serialVersionUID = 1L;

    public static enum RecipientType {
        PEC, REGULAR_EMAIL, UNKNOWN
    }
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    
    @Column(name = "address")
    private String address;
    
    @Column(name = "original_address")
    private String originalAddress;
    
    @Column(name = "recipient_type")
    private String recipientType;

    public Address() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getOriginalAddress() {
        return originalAddress;
    }

    public void setOriginalAddress(String originalAddress) {
        this.originalAddress = originalAddress;
    }

    public RecipientType getRecipientType() {
        return RecipientType.valueOf(recipientType);
    }

    public void setRecipientType(RecipientType recipientType) {
        this.recipientType = recipientType.toString();
    }
    
    @Override
    public String toString() {
        return "it.bologna.ausl.model.entities.shpeck.Address[ id=" + id + " ]";
    }
}
