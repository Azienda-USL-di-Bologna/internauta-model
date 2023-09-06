package it.bologna.ausl.model.entities.tools;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.vladmihalcea.hibernate.type.array.IntArrayType;
import it.nextsw.common.data.annotations.GenerateProjections;
import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Cacheable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.Parameter;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;

/**
 *
 * @author Top
 */
@TypeDef(name = "int-array", typeClass = IntArrayType.class)

@Entity
@Table(name = "supported_files", catalog = "internauta", schema = "tools")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Cacheable(false)
@GenerateProjections({})
@DynamicUpdate
public class SupportedFile implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    
    @Column(name = "mime_type")
    private String mimeType;
    
    @Column(name = "estensione")
    private String estensione;
    
    @Column(name = "convertibile_pdf")
    private Boolean convertibilePdf = false;
    
    @Column(name = "anteprima_originale")
    private Boolean anteprimaOriginale = false;

    @Column(name = "id_aziende", columnDefinition = "integer[]")
    @Type(type = "int-array")
    private Integer[] idAziende;
    
    @Column(name = "note")
    private String note;

    public SupportedFile() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getMimeType() {
        return mimeType;
    }

    public void setMimeType(String mimeType) {
        this.mimeType = mimeType;
    }

    public String getEstensione() {
        return estensione;
    }

    public void setEstensione(String estensione) {
        this.estensione = estensione;
    }

    public Boolean getConvertibilePdf() {
        return convertibilePdf;
    }

    public void setConvertibilePdf(Boolean convertibilePdf) {
        this.convertibilePdf = convertibilePdf;
    }

    public Boolean getAnteprimaOriginale() {
        return anteprimaOriginale;
    }

    public void setAnteprimaOriginale(Boolean anteprimaOriginale) {
        this.anteprimaOriginale = anteprimaOriginale;
    }

    public Integer[] getIdAziende() {
        return idAziende;
    }

    public void setIdAziende(Integer[] idAziende) {
        this.idAziende = idAziende;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }
}
