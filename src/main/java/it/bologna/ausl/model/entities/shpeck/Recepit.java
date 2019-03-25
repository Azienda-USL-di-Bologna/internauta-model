package it.bologna.ausl.model.entities.shpeck;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import it.bologna.ausl.model.entities.baborg.Pec;
import it.bologna.ausl.model.entities.configuration.Applicazione;
import it.bologna.ausl.model.entities.shpeck.Message;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Objects;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
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
@NamedQueries({
    @NamedQuery(name = "Recepit.findAll", query = "SELECT r FROM Recepit r")})
public class Recepit extends Message implements Serializable {

    private static final long serialVersionUID = 1L;
    
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2147483647)
    @Column(name = "recepit_type")
    private RecepitType recepitType;
    
    public static enum RecepitType {
        ACCETTAZIONE, CONSEGNA, ERRORE_PRESA_IN_CARICO, ERRORE_CONSEGNA
    }

    public Recepit() {
    }

    public Recepit(Integer id, String uuidMessage, Pec idPec, Applicazione idApplicazione, Message idRelated, String subject, String messageStatus, String inOut, LocalDateTime createTime, LocalDateTime updateTime, String messageType, Boolean isPec, Integer nAttachments, String uuidMongo, String mongoPath, String name, LocalDateTime receiveDate, RecepitType recepitType) {
        super(id, uuidMessage, idPec, idApplicazione, idRelated, subject, messageStatus, inOut, createTime, updateTime, messageType, isPec, nAttachments, uuidMongo, mongoPath, name, receiveDate);
        this.recepitType = recepitType;
    }

    public RecepitType getRecepitType() {
        return recepitType;
    }

    public void setRecepitType(RecepitType recepitType) {
        this.recepitType = recepitType;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (super.getId() != null ? super.getId().hashCode() : 0);
        return hash;
    }  

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Recepit other = (Recepit) obj;
        return Objects.equals(this.recepitType, other.recepitType);
    }

    @Override
    public String toString() {
        return "it.bologna.ausl.model.entities.shpeck.Recepit[ id=" + super.getId() + " ]";
    }
    
}
