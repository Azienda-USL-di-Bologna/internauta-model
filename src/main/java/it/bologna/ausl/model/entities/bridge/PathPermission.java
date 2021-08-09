package it.bologna.ausl.model.entities.bridge;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import it.bologna.ausl.model.entities.baborg.Persona;
import it.nextsw.common.annotations.GenerateProjections;
import java.io.Serializable;
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
import javax.validation.constraints.NotNull;

/**
 *
 * @author spritz
 */
@Entity
@Table(name = "paths_permissions", catalog = "internauta", schema = "bridge")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Cacheable(false)
@GenerateProjections({})
public class PathPermission implements Serializable {

    private static final long serialVersionUID = 1L;

    public static enum MethodBits {
        //Constants with values
        GET(1), PATCH(2),  POST(4), PUT(8), DELETE(16);
        //Instance variable
        private int bit;
        //Constructor to initialize the instance variable
        MethodBits(int bit) {
           this.bit = bit;
        }
        public int getBit() {
           return this.bit;
        }
    }
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;

    @JoinColumn(name = "id_certificate", referencedColumnName = "id")
    @ManyToOne(fetch = FetchType.EAGER, cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    private Certificate idCertificate;

    @Basic(optional = false)
    @NotNull
    @Column(name = "path", columnDefinition = "text")
    private String path;
    
    @Basic(optional = false)
    @NotNull
    @Column(name = "methods_bit_permissions")
    private Integer methodsBitPermissions;

    @Basic(optional = true)
    @Column(name = "notes", columnDefinition = "text")
    private String notes;
    
    public PathPermission() {
    }

    public PathPermission(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Certificate getIdCertificate() {
        return idCertificate;
    }

    public void setIdCertificate(Certificate idCertificate) {
        this.idCertificate = idCertificate;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public Integer getMethodsBitPermissions() {
        return methodsBitPermissions;
    }

    public void setMethodsBitPermissions(Integer methodsBitPermissions) {
        this.methodsBitPermissions = methodsBitPermissions;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
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
        if (!(object instanceof PathPermission)) {
            return false;
        }
        PathPermission other = (PathPermission) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return getClass().getCanonicalName()  + "[ id=" + id + " ]";
    }
}
