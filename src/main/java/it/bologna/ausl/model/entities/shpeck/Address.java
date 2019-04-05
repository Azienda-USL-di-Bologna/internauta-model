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
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author Salo
 */
@Entity
@Table(name = "addresses", catalog = "internauta", schema = "pecgw")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Cacheable(false)
public class Address implements Serializable {

    private  static final long serialVersionUID = 1L;
    // ('ACCETTAZIONE', 'CONSEGNA', 'ERRORE_PRESA_IN_CARICO', 'ERRORE_CONSEGNA');
    public static enum RecipientType {
        ACCETTAZIONE, CONSEGNA, ERRORE_PRESA_IN_CARICO, ERRORE_CONSEGNA
    }
    
    @Id
    private Long id;
    
    @Column(name = "address")
    private String address;
    
    @Column(name = "original_address")
    private String originalAddress;
    
    @Column(name = "recipient_type")
    private RecipientType recipientType;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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
        return recipientType;
    }

    public void setRecipientType(RecipientType recipientType) {
        this.recipientType = recipientType;
    }
    
    @Override
    public String toString() {
        return "it.bologna.ausl.model.entities.pecgw.Address[ id=" + id + " ]";
    }
}
