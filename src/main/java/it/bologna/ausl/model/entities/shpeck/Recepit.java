package it.bologna.ausl.model.entities.shpeck;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author Salo
 */
@Entity
@Table(name = "recepits", catalog = "internauta", schema = "pecgw")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Recepit extends Message implements Serializable {

    private static final long serialVersionUID = 1L;
    
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2147483647)
    @Column(name = "recepit_type")
    private String recepitType;

    public Recepit() {
    }

    public Recepit(Integer id, String uuidMessage, Integer idMailConfig, LocalDateTime createTime, LocalDateTime updateTime, boolean isPec, Integer nAttachments, LocalDateTime receiveDate, String recepitType) {
        super(id, uuidMessage, idMailConfig, createTime, updateTime, isPec, nAttachments, receiveDate);
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
