/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.bologna.ausl.model.entities.pecgw;

import it.bologna.ausl.model.entities.baborg.Pec;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
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
@Table(name = "recepits", catalog = "internauta", schema = "pecgw")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Table(name = "recepits")
@NamedQueries({
    @NamedQuery(name = "Recepit.findAll", query = "SELECT r FROM Recepit r")})
public class Recepit extends Message implements Serializable {

    private static final long serialVersionUID = 1L;
    
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2147483647)
    @Column(name = "recepit_type")
    private String recepitType;

    public Recepit() {
    }

    public Recepit(Integer id, String uuidMessage, Pec idPec, Date createTime, Date updateTime, boolean isPec, int nAttachments, Date receiveDate, String recepitType) {
        super(id, uuidMessage, idPec, createTime, updateTime, isPec, nAttachments, receiveDate);
        this.recepitType = recepitType;
    }

    public String getRecepitType() {
        return recepitType;
    }

    public void setRecepitType(String recepitType) {
        this.recepitType = recepitType;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (super.getId() != null ? super.getId().hashCode() : 0);
        return hash;
    }  

    @Override
    public String toString() {
        return "it.bologna.ausl.model.entities.pecgw.Recepit[ id=" + super.getId() + " ]";
    }
    
}
