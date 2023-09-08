package it.bologna.ausl.model.entities.scrivania;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.vladmihalcea.hibernate.type.array.StringArrayType;
import it.bologna.ausl.model.entities.configurazione.Applicazione;
import it.nextsw.common.data.annotations.GenerateProjections;
import java.io.Serializable;
import java.time.ZonedDateTime;
import java.util.List;
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
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Version;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.Parameter;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;
import org.springframework.format.annotation.DateTimeFormat;

/**
 *
 * @author gusgus
 */
@TypeDef(name = "string-array", typeClass = StringArrayType.class)
@Entity
@Table(name = "bmenu", catalog = "internauta", schema = "scrivania")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Cacheable(false)
@GenerateProjections({"idApplicazione"})
@DynamicUpdate
public class Bmenu implements Serializable {
    
    public static enum CommandType {
        ROUTING,
        COMPONENT,
        URL
    }

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2147483647)
    @Column(name = "descrizione")
    private String descrizione;
    
    @Size(max = 2147483647)
    @Column(name = "icona")
    private String icona;
    
    @JoinColumn(name = "id_applicazione", referencedColumnName = "id")
    @ManyToOne(fetch = FetchType.LAZY, cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    private Applicazione idApplicazione;
    
    @Column(name = "open_command")
    private String openCommand;
    
    @Column(name = "commandType")
    private String commandType;
    
    @Column(name = "permessi_sufficienti", columnDefinition = "text[]")
    @Type(type = "string-array")
    private String[] permessiSufficienti;
    
    @Column(name = "ruoli_sufficienti", columnDefinition = "text[]")
    @Type(type = "string-array")
    private String[] ruoliSufficienti;
    
    @Column(name = "modulo", columnDefinition = "text")
    private String modulo;
    
    @Column(name = "aziende", columnDefinition = "text[]")
    @Type(type = "string-array")
    private String[] aziende;
    
    @Column(name = "scomponi_per_azienda")
    private Boolean scomponiPerAzienda;
    
    @Basic(optional = false)
    @NotNull
    @Column(name = "livello")
    private Integer livello;
    
    @Basic(optional = false)
    @NotNull
    @Column(name = "foglia")
    private Boolean foglia;
    
    @Basic(optional = false)
    @NotNull
    @Column(name = "ordinale")
    private Integer ordinale;
    
    @Version()
    @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss.SSSSSSXXX'['VV']'")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss.SSSSSSXXX'['VV']'")
    private ZonedDateTime version;  
    
    @OneToMany(mappedBy = "idPadre", fetch = FetchType.LAZY, cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    @JsonBackReference(value = "bmenuList")
    private List<Bmenu> bmenuList;
    
    @JoinColumn(name = "id_padre", referencedColumnName = "id")
    @ManyToOne(fetch = FetchType.LAZY, cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    @JsonBackReference(value = "idPadre")
    private Bmenu idPadre;

    public Bmenu() {
    }

    public Bmenu(Integer id) {
        this.id = id;
    }

    public Bmenu(Integer id, String descrizione, Applicazione idApplicazione, String openCommand, Integer livello, Boolean foglia, Integer ordinale) {
        this.id = id;
        this.descrizione = descrizione;
        this.idApplicazione = idApplicazione;
        this.openCommand = openCommand;
        this.livello = livello;
        this.foglia = foglia;
        this.ordinale = ordinale;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDescrizione() {
        return descrizione;
    }

    public void setDescrizione(String descrizione) {
        this.descrizione = descrizione;
    }

    public String getIcona() {
        return icona;
    }

    public void setIcona(String icona) {
        this.icona = icona;
    }

    public Applicazione getIdApplicazione() {
        return idApplicazione;
    }

    public void setIdApplicazione(Applicazione idApplicazione) {
        this.idApplicazione = idApplicazione;
    }

    public String getOpenCommand() {
        return openCommand;
    }

    public void setOpenCommand(String openCommand) {
        this.openCommand = openCommand;
    }
    
    public CommandType getCommandType() {
        return commandType == null ? null : CommandType.valueOf(commandType);
    }

    public void setCommandType(CommandType commandType) {
        this.commandType = commandType.toString();
    }
    
    public String[] getPermessiSufficienti() {
        return permessiSufficienti;
    }

    public void setPermessiSufficienti(String[] permessiSufficienti) {
        this.permessiSufficienti = permessiSufficienti;
    }

    public String[] getRuoliSufficienti() {
        return ruoliSufficienti;
    }

    public void setRuoliSufficienti(String[] ruoliSufficienti) {
        this.ruoliSufficienti = ruoliSufficienti;
    }

    public String getModulo() {
        return modulo;
    }

    public void setModulo(String modulo) {
        this.modulo = modulo;
    }

    public String[] getAziende() {
        return aziende;
    }

    public void setAziende(String[] aziende) {
        this.aziende = aziende;
    }

    public Boolean getScomponiPerAzienda() {
        return scomponiPerAzienda;
    }

    public void setScomponiPerAzienda(Boolean scomponiPerAzienda) {
        this.scomponiPerAzienda = scomponiPerAzienda;
    }

    public Integer getLivello() {
        return livello;
    }

    public void setLivello(int livello) {
        this.livello = livello;
    }

    public Boolean getFoglia() {
        return foglia;
    }

    public void setFoglia(boolean foglia) {
        this.foglia = foglia;
    }

    public Integer getOrdinale() {
        return ordinale;
    }

    public void setOrdinale(int ordinale) {
        this.ordinale = ordinale;
    }

    public ZonedDateTime getVersion() {
        return version;
    }

    public void setVersion(ZonedDateTime version) {
        this.version = version;
    }

    public List<Bmenu> getBmenuList() {
        return bmenuList;
    }

    public void setBmenuList(List<Bmenu> bmenuList) {
        this.bmenuList = bmenuList;
    }

    public Bmenu getIdPadre() {
        return idPadre;
    }

    public void setIdPadre(Bmenu idPadre) {
        this.idPadre = idPadre;
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
        if (!(object instanceof Bmenu)) {
            return false;
        }
        Bmenu other = (Bmenu) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "it.bologna.ausl.model.entities.scrivania.Bmenu[ id=" + id + " ]";
    }
}
