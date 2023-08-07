/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package it.bologna.ausl.model.entities.baborg;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import it.nextsw.common.annotations.GenerateProjections;
import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Cacheable;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import org.hibernate.annotations.DynamicUpdate;

/**
 *
 * @author mido
 */
@Entity
@Table(name = "profili", catalog = "internauta", schema = "baborg")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Cacheable(false)
@GenerateProjections({"profiliPredicatiRuoliList"})
@DynamicUpdate
public class Profili implements Serializable {
    
    @Id
    @Basic(optional = false)
    @Column(name = "id_profilo")
    private String idProfilo;
    
    @Basic(optional = false)
    @Column(name = "descrizione")
    private String descrizione;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "id", fetch = FetchType.LAZY, orphanRemoval = true)
    @JsonBackReference(value = "profiliPredicatiRuoliList")
    private List<ProfiliPredicatiRuoli> profiliPredicatiRuoliList;

    public Profili(String idProfilo, String descrizione) {
        this.idProfilo = idProfilo;
        this.descrizione = descrizione;
    }

    public Profili() {
    }
    
    public String getIdProfilo() {
        return idProfilo;
    }

    public void setIdProfilo(String idProfilo) {
        this.idProfilo = idProfilo;
    }

    public String getDescrizione() {
        return descrizione;
    }

    public void setDescrizione(String descrizione) {
        this.descrizione = descrizione;
    }

    public List<ProfiliPredicatiRuoli> getProfiliPredicatiRuoliList() {
        return profiliPredicatiRuoliList;
    }

    public void setProfiliPredicatiRuoliList(List<ProfiliPredicatiRuoli> profiliPredicatiRuoliList) {
        this.profiliPredicatiRuoliList = profiliPredicatiRuoliList;
    }
    
    
    
    
    
}