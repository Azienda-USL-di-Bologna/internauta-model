package it.bologna.ausl.model.entities.diagnostica;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.io.Serializable;
import java.time.LocalDateTime;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import org.springframework.format.annotation.DateTimeFormat;

/**
 *
 * @author Spritz
 */
@Entity
@Table(name = "report", catalog = "internauta", schema = "diagnostica")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Report implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;

    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2147483647)
    @Column(name = "tipologia")
    private String tipologia;

    @Basic(optional = false)
    @NotNull
    @Column(name = "data_inserimento_riga")
    @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss")
    private LocalDateTime data_inserimento_riga = LocalDateTime.now();

    @Column(name = "additional_data")
    private String additional_data;

    @Basic(optional = false)
    @Column(name = "risolto")
    private Boolean risolto = false;

    @Basic(optional = false)
    @NotNull
    @Column(name = "in_attesa_di_risoluzione")
    private Boolean in_attesa_di_risoluzione = false;

    @Basic(optional = false)
    @Column(name = "data_risoluzione")
    @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss")
    private LocalDateTime data_risoluzione = LocalDateTime.now();

    @Size(max = 2147483647)
    @Column(name = "note")
    private String note;

    public Report() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTipologia() {
        return tipologia;
    }

    public void setTipologia(String tipologia) {
        this.tipologia = tipologia;
    }

    public LocalDateTime getData_inserimento_riga() {
        return data_inserimento_riga;
    }

    public void setData_inserimento_riga(LocalDateTime data_inserimento_riga) {
        this.data_inserimento_riga = data_inserimento_riga;
    }

    public String getAdditional_data() {
        return additional_data;
    }

    public void setAdditional_data(String additional_data) {
        this.additional_data = additional_data;
    }

    public Boolean getRisolto() {
        return risolto;
    }

    public void setRisolto(Boolean risolto) {
        this.risolto = risolto;
    }

    public Boolean getIn_attesa_di_risoluzione() {
        return in_attesa_di_risoluzione;
    }

    public void setIn_attesa_di_risoluzione(Boolean in_attesa_di_risoluzione) {
        this.in_attesa_di_risoluzione = in_attesa_di_risoluzione;
    }

    public LocalDateTime getData_risoluzione() {
        return data_risoluzione;
    }

    public void setData_risoluzione(LocalDateTime data_risoluzione) {
        this.data_risoluzione = data_risoluzione;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
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
        if (!(object instanceof Report)) {
            return false;
        }
        Report other = (Report) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "it.bologna.ausl.model.entities.diagnostica.Report[ id=" + id + " ]";
    }

}
