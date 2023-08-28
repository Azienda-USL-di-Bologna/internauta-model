package it.bologna.ausl.model.entities.logs;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.vladmihalcea.hibernate.type.array.IntArrayType;
import com.vladmihalcea.hibernate.type.json.JsonBinaryType;
import it.bologna.ausl.model.entities.baborg.Persona;
import it.bologna.ausl.model.entities.configurazione.Applicazione;
import it.nextsw.common.annotations.GenerateProjections;
import java.time.ZonedDateTime;
import java.util.Map;
import javax.persistence.Basic;
import javax.persistence.Cacheable;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Version;
import javax.validation.constraints.NotNull;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;
import org.springframework.format.annotation.DateTimeFormat;

/**
 *
 * @author gusgus
 */
@TypeDefs({
    @TypeDef(name = "jsonb", typeClass = JsonBinaryType.class),
    @TypeDef(name = "int-array", typeClass = IntArrayType.class)
})
@Entity
@Table(name = "massive_actions_log", catalog = "internauta", schema = "logs")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Cacheable(false)
@GenerateProjections({})
@DynamicUpdate
public class MassiveActionLog {
    
    public static enum OperationType {
        MODIFICA_VICARI_E_PERMESSI,
        COPIA_ABILITAZIONI,
        TRASFERISCI_ABILITAZIONI,
        MODIFICA_RESPONSABILE
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;

    @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss.SSSSSSXXX'['VV']'")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss.SSSSSSXXX'['VV']'")
    @Column(name = "insertion_date")
    @Basic(optional = false)
    @NotNull
    private ZonedDateTime insertionDate = ZonedDateTime.now();

    @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss.SSSSSSXXX'['VV']'")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss.SSSSSSXXX'['VV']'")
    @Column(name = "completion_date")
    @Basic(optional = true)
    private ZonedDateTime completionDate;
    
    @JoinColumn(name = "id_executing_person", referencedColumnName = "id")
    @ManyToOne(fetch = FetchType.LAZY, cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    @JsonBackReference(value = "idExecutingPerson")
    private Persona idExecutingPerson;
    
    @Enumerated(EnumType.STRING)
    @Column(name = "operation_type")
    private OperationType operationType;
    
    @Basic(optional = false)
    @NotNull
    @JoinColumn(name = "id_app", referencedColumnName = "id")
    @ManyToOne(fetch = FetchType.LAZY, cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    private Applicazione idApp;
    
    @Type(type = "jsonb")
    @Column(name = "parameters", columnDefinition = "jsonb")
    private Map<String, Object> parameters;

    @Column(name = "id_objects_involved", columnDefinition = "integer[]")
    @Type(type = "int-array")
    private Integer[] idObjectsInvolved;

    @Type(type = "jsonb")
    @Column(name = "additional_data", columnDefinition = "jsonb")
    private Map<String, Object> additionalData;

    @Version()
    @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss.SSSSSSXXX'['VV']'")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss.SSSSSSXXX'['VV']'")
    private ZonedDateTime version;

    public MassiveActionLog() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public ZonedDateTime getInsertionDate() {
        return insertionDate;
    }

    public void setInsertionDate(ZonedDateTime insertionDate) {
        this.insertionDate = insertionDate;
    }

    public ZonedDateTime getCompletionDate() {
        return completionDate;
    }

    public void setCompletionDate(ZonedDateTime completionDate) {
        this.completionDate = completionDate;
    }

    public Persona getIdExecutingPerson() {
        return idExecutingPerson;
    }

    public void setIdExecutingPerson(Persona idExecutingPerson) {
        this.idExecutingPerson = idExecutingPerson;
    }

    public OperationType getOperationType() {
        return operationType;
    }

    public void setOperationType(OperationType operationType) {
        this.operationType = operationType;
    }

    public Applicazione getIdApp() {
        return idApp;
    }

    public void setIdApp(Applicazione idApp) {
        this.idApp = idApp;
    }

    public Map<String, Object> getParameters() {
        return parameters;
    }

    public void setParameters(Map<String, Object> parameters) {
        this.parameters = parameters;
    }

    public Integer[] getIdObjectsInvolved() {
        return idObjectsInvolved;
    }

    public void setIdObjectsInvolved(Integer[] idObjectsInvolved) {
        this.idObjectsInvolved = idObjectsInvolved;
    }

    public Map<String, Object> getAdditionalData() {
        return additionalData;
    }

    public void setAdditionalData(Map<String, Object> additionalData) {
        this.additionalData = additionalData;
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
        if (!(object instanceof MassiveActionLog)) {
            return false;
        }
        MassiveActionLog other = (MassiveActionLog) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "it.bologna.ausl.model.entities.logs.MassiveActionLog[ id=" + id + " ]";
    }
}
