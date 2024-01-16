package it.bologna.ausl.model.entities.tools;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.vladmihalcea.hibernate.type.json.JsonBinaryType;
import it.nextsw.common.data.annotations.GenerateProjections;
import java.io.Serializable;
import java.util.List;
import java.util.Map;
import javax.persistence.Basic;
import javax.persistence.Cacheable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;

/**
 *
 * @author gdm
 */
@Entity
@Table(name = "intimus_commands", catalog = "internauta", schema = "tools")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Cacheable(false)
@GenerateProjections({})
@TypeDefs({
    @TypeDef(name = "jsonb", typeClass = JsonBinaryType.class)
})
@DynamicUpdate
public class IntimusCommand implements Serializable {

    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;

    @Basic(optional = false)
    @NotNull
    @Column(name = "command")
    private String command;
    
    @Type(type = "jsonb")
    @Column(name = "params", columnDefinition = "jsonb")
    private Map<String, Object> params;
    
    @Type(type = "jsonb")
    @Column(name = "dest_objects", columnDefinition = "jsonb")
    private List<Map<String, Object>> destObjects;

    public IntimusCommand() {
    }

    public IntimusCommand(Integer id, String command, Map<String, Object> params, List<Map<String, Object>> destObjects) {
        this.id = id;
        this.command = command;
        this.params = params;
        this.destObjects = destObjects;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCommand() {
        return command;
    }

    public void setCommand(String command) {
        this.command = command;
    }

    public Map<String, Object> getParams() {
        return params;
    }

    public void setParams(Map<String, Object> params) {
        this.params = params;
    }

    public List<Map<String, Object>> getDestObjects() {
        return destObjects;
    }

    public void setDestObjects(List<Map<String, Object>> destObjects) {
        this.destObjects = destObjects;
    }

    @Override
    public String toString() {
        return getClass().getCanonicalName() + "[ id=" + id + " ]";
    }
}
