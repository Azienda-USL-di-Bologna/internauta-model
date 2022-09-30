package it.bologna.ausl.model.entities.scripta;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import it.bologna.ausl.model.entities.shpeck.Message;
import it.nextsw.common.annotations.GenerateProjections;
import java.io.Serializable;
import java.time.ZonedDateTime;
import javax.persistence.Basic;
import javax.persistence.Cacheable;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Version;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import org.hibernate.annotations.DynamicUpdate;
import org.springframework.format.annotation.DateTimeFormat;

/**
 *
 * @author gusgus
 */
@Entity
@Table(name = "messages_docs", catalog = "internauta", schema = "scripta")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Cacheable(false)
@GenerateProjections({})
@DynamicUpdate
public class MessageDoc implements Serializable {

    public static enum TipoMessageDoc {
        IN,
        OUT
    }
    
    public static enum ScopeMessageDoc {
        PROTOCOLLAZIONE,
        ARCHIVIAZIONE
    }
    
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    
    @Basic(optional = false)
    @NotNull    
    @JoinColumn(name = "id_message", referencedColumnName = "id")
    @ManyToOne(fetch = FetchType.LAZY, cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    @JsonBackReference(value = "idMessage")
    private Message idMessage;
    
    @JoinColumn(name = "id_doc", referencedColumnName = "id")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @JsonBackReference(value = "idDoc")
    private Doc idDoc;
    
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2147483647)
    @Column(name = "tipo")
    private String tipo;
    
    @Column(name = "data_inserimento")
    @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss.SSSSSSXXX'['VV']'")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss.SSSSSSXXX'['VV']'")
    private ZonedDateTime dataInserimento = ZonedDateTime.now();
    
    @Version()
    @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss.SSSSSSXXX'['VV']'")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss.SSSSSSXXX'['VV']'")
    private ZonedDateTime version;

    @Column(name = "scope")
    private String scope = "PROTOCOLLAZIONE";
    
    public MessageDoc() {
    }

    public MessageDoc(Integer id) {
        this.id = id;
    }

    public MessageDoc(Message idMessage, Doc idDoc, TipoMessageDoc tipo, ScopeMessageDoc scope) {
        this.idMessage = idMessage;
        this.idDoc = idDoc;
        if (tipo != null) {
            this.tipo = tipo.toString();
        } else {
            this.tipo = null;
        }
        if (scope != null) {
            this.scope = scope.toString();
        } else {
            this.scope = null;
        }
    }

    public MessageDoc(Integer id, Message idMessage, String tipo, ZonedDateTime dataInserimento, ZonedDateTime version) {
        this.id = id;
        this.idMessage = idMessage;
        this.tipo = tipo;
        this.dataInserimento = dataInserimento;
        this.version = version;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Message getIdMessage() {
        return idMessage;
    }

    public void setIdMessage(Message idMessage) {
        this.idMessage = idMessage;
    }

    public Doc getIdDoc() {
        return idDoc;
    }

    public void setIdDoc(Doc idDoc) {
        this.idDoc = idDoc;
    }

    public TipoMessageDoc getTipo() {
        if (tipo != null) {
            return TipoMessageDoc.valueOf(tipo);
        } else {
            return null;
        }
    }

    public void setTipo(TipoMessageDoc tipo) {
        if (tipo != null) {
            this.tipo = tipo.toString();
        } else {
            this.tipo = null;
        }
    }
    
    public ScopeMessageDoc getScope() {
        if (scope != null) {
            return ScopeMessageDoc.valueOf(scope);
        } else {
            return null;
        }
    }

    public void setScope(ScopeMessageDoc scope) {
        if (scope != null) {
            this.scope = scope.toString();
        } else {
            this.scope = null;
        }
    }

    public ZonedDateTime getDataInserimento() {
        return dataInserimento;
    }

    public void setDataInserimento(ZonedDateTime dataInserimento) {
        this.dataInserimento = dataInserimento;
    }

    public ZonedDateTime getVersion() {
        return version;
    }

    public void setVersion(ZonedDateTime version) {
        this.version = version;
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
        if (!(object instanceof MessageDoc)) {
            return false;
        }
        MessageDoc other = (MessageDoc) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "it.bologna.ausl.model.entities.scripta.MessageDoc[ id=" + id + " ]";
    }
    
}
