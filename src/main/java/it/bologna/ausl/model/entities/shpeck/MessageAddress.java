/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.bologna.ausl.model.entities.shpeck;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.io.Serializable;
import javax.persistence.Cacheable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 *
 * @author Salo
 */
@Entity
@Table(name = "addresses", catalog = "internauta", schema = "pecgw")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Cacheable(false)
public class MessageAddress implements Serializable {
    
    private  static final long serialVersionUID = 1L;
    
    public static enum RoletType {
        FROM, TO, CC
    }

    @Id
    private Long id;
    
    @JoinColumn(name = "address", referencedColumnName = "id")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Address address;
    
    @JoinColumn(name = "original_address", referencedColumnName = "id")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Address originalAddress;
    
    @Column(name = "role")
    private RoletType recipientType;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public Address getOriginalAddress() {
        return originalAddress;
    }

    public void setOriginalAddress(Address originalAddress) {
        this.originalAddress = originalAddress;
    }

    public RoletType getRecipientType() {
        return recipientType;
    }

    public void setRecipientType(RoletType recipientType) {
        this.recipientType = recipientType;
    }
    
    @Override
    public String toString() {
        return "it.bologna.ausl.model.entities.pecgw.MessageAddress[ id=" + id + " ]";
    }
}
