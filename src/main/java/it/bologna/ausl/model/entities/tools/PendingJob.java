package it.bologna.ausl.model.entities.tools;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.vladmihalcea.hibernate.type.json.JsonBinaryType;
import it.nextsw.common.annotations.GenerateProjections;
import java.io.Serializable;
import java.math.BigInteger;
import java.time.ZonedDateTime;
import java.util.Map;
import javax.persistence.Basic;
import javax.persistence.Cacheable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Version;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;
import org.springframework.format.annotation.DateTimeFormat;

/**
 *
 * @author gdm
 */
@Entity
@Table(name = "pending_jobs", catalog = "internauta", schema = "tools")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Cacheable(false)
@GenerateProjections({})
@TypeDefs({
    @TypeDef(name = "jsonb", typeClass = JsonBinaryType.class)
})
@DynamicUpdate
public class PendingJob implements Serializable {

    private static final long serialVersionUID = 1L;

    public static enum PendigJobsState {
        IDLE, RUNNING, ERROR, DONE
    }
    
    public static enum PendigJobsServices {
        FASCICOLATORE_SAI
    }
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private BigInteger id;

    @Basic(optional = false)
    @NotNull
    @Column(name = "service")
    private String service;

    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2147483647)
    @Column(name = "state")
    private String state = PendigJobsState.IDLE.toString();

    @Type(type = "jsonb")
    @Column(name = "data", columnDefinition = "jsonb")
    private Map<String, Object> data;

    @Version()
    @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss.SSSSSSXXX'['VV']'")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss.SSSSSSXXX'['VV']'")
    private ZonedDateTime version;

    public PendingJob() {
    }

    public PendingJob(BigInteger id, String service, String state, Map<String, Object> data) {
        this.id = id;
        this.service = service;
        this.state = state;
        this.data = data;
        this.version = version;
    }
    
    public PendingJob(BigInteger id, PendigJobsServices service, PendigJobsState state, Map<String, Object> data) {
        this.id = id;
        if (service != null) {
            this.service = service.toString();
        }
        if (state != null) {
            this.state = state.toString();
        }
        this.data = data;
        this.version = version;
    }

    public BigInteger getId() {
        return id;
    }

    public void setId(BigInteger id) {
        this.id = id;
    }

    public PendigJobsServices getService() {
       if (service != null) {
            return PendigJobsServices.valueOf(service);
        } else {
            return null;
        }
    }

    public void setService(PendigJobsServices service) {
        if (service != null) {
            this.service = service.toString();
        } else {
            this.service = null;
        }
    }

    public PendigJobsState getState() {
        if (state != null) {
            return PendigJobsState.valueOf(state);
        } else {
            return null;
        }
    }

    public void setState(PendigJobsState state) {
        if (state != null) {
            this.state = state.toString();
        } else {
            this.state = null;
        }
    }
    
    public Map<String, Object> getData() {
        return data;
    }

    public void setData(Map<String, Object> data) {
        this.data = data;
    }

    public ZonedDateTime getVersion() {
        return version;
    }

    public void setVersion(ZonedDateTime version) {
        this.version = version;
    }

    @Override
    public String toString() {
        return getClass().getCanonicalName() + "[ id=" + id + " ]";
    }
}
