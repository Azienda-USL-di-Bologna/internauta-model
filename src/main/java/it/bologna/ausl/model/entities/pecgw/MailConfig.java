/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.bologna.ausl.model.entities.pecgw;

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
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

/**
 *
 * @author Salo
 */
@Entity
@Table(name = "mail_config")
@NamedQueries({
    @NamedQuery(name = "MailConfig.findAll", query = "SELECT m FROM MailConfig m")})
public class MailConfig extends Pec implements Serializable {

    private static final long serialVersionUID = 1L;
    @Column(name = "is_pec")
    private Boolean isPec;
    @Basic(optional = false)
    @NotNull
    @Column(name = "lastuid")
    private long lastuid;
    @Basic(optional = false)
    @NotNull
    @Column(name = "send_delay")
    private int sendDelay;
    @Column(name = "inherit")
    private Serializable inherit;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idMailConfig", fetch = FetchType.LAZY)
    private List<Tag> tagList;

    public MailConfig() {
    }

    public MailConfig(Integer id, long lastuid, int sendDelay) {
        super.id = id;
        this.lastuid = lastuid;
        this.sendDelay = sendDelay;
    }

    public Boolean getIsPec() {
        return isPec;
    }

    public void setIsPec(Boolean isPec) {
        this.isPec = isPec;
    }

    public long getLastuid() {
        return lastuid;
    }

    public void setLastuid(long lastuid) {
        this.lastuid = lastuid;
    }

    public int getSendDelay() {
        return sendDelay;
    }

    public void setSendDelay(int sendDelay) {
        this.sendDelay = sendDelay;
    }

    public Serializable getInherit() {
        return inherit;
    }

    public void setInherit(Serializable inherit) {
        this.inherit = inherit;
    }

    public List<Tag> getTagList() {
        return tagList;
    }

    public void setTagList(List<Tag> tagList) {
        this.tagList = tagList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public String toString() {
        return "it.bologna.ausl.model.entities.pecgw.MailConfig[ id=" + super.getId() + " ]";
    }
    
}
