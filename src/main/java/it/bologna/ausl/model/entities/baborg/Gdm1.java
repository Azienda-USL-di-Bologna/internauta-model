package it.bologna.ausl.model.entities.baborg;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Cacheable;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import org.springframework.security.core.GrantedAuthority;

/**
 *
 * @author gdm
 */
@Entity
@Table(name = "gdm1", catalog = "internauta", schema = "organigramma")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Cacheable(false)
public class Gdm1 implements Serializable {
    
    public enum UtenteRole implements GrantedAuthority{
        ROLE_ADMIN(true,true),
        ROLE_USER(true,true);

        private boolean canAccessBackOffice;
        private boolean canAccessFrontOffice;


        UtenteRole(boolean canAccessBackOffice, boolean canAccessFrontOffice) {
            this.canAccessBackOffice = canAccessBackOffice;
            this.canAccessFrontOffice = canAccessFrontOffice;
        }

        @Override
        public String getAuthority() {
            return this.name();
        }

        public boolean isCanAccessBackOffice() {
            return canAccessBackOffice;
        }

        public boolean isCanAccessFrontOffice() {
            return canAccessFrontOffice;
        }
    }
    
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2147483647)
    @Column(name = "id")
    private String id;
    @Size(max = 2147483647)
    @Column(name = "descrizione")
    private String descrizione;
    
//    @Column(name = "UTENTE_ROLE", nullable = false, length = 2000)
//    @Enumerated(EnumType.STRING)
//    private UtenteRole utenteRole;

    public String getNecessario() {
        return necessario;
    }

    public void setNecessario(String necessario) {
        this.necessario = necessario;
    }
    @Size(max = 2147483647)
    @Column(name = "necessario", nullable = false)
    @NotNull
    private String necessario;
    @OneToMany(mappedBy = "idGdm1", fetch = FetchType.LAZY, cascade = {CascadeType.MERGE, CascadeType.PERSIST}, orphanRemoval = true, targetEntity = Gdm2.class)
    @JsonBackReference(value = "gdm2List")
    private List<Gdm2> gdm2List;

    public Gdm1() {
    }

    public Gdm1(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDescrizione() {
        return descrizione;
    }

    public void setDescrizione(String descrizione) {
        this.descrizione = descrizione;
    }

    public List<Gdm2> getGdm2List() {
        return gdm2List;
    }

    public void setGdm2List(List<Gdm2> gdm2List) {
        this.gdm2List = gdm2List;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : super.hashCode());
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Gdm1)) {
            return false;
        }
        Gdm1 other = (Gdm1) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "it.bologna.ausl.model.entities.baborg.Gdm1[ id=" + id + " ]";
    }
    
}
