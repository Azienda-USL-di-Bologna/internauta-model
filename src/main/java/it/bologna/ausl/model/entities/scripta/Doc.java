package it.bologna.ausl.model.entities.scripta;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import it.bologna.ausl.model.entities.baborg.Azienda;
import it.bologna.ausl.model.entities.baborg.Pec;
import it.bologna.ausl.model.entities.baborg.Persona;
import it.bologna.ausl.model.entities.versatore.Versamento;
import it.nextsw.common.data.annotations.GenerateProjections;
import java.io.Serializable;
import java.time.ZonedDateTime;
import java.util.HashMap;
import java.util.List;
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
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Version;
import javax.validation.constraints.NotNull;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.Where;
import org.springframework.format.annotation.DateTimeFormat;

/**
 *
 * @author solidus83
 */
@Entity
@Table(name = "docs", catalog = "internauta", schema = "scripta")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Cacheable(false)
//@GenerateProjections({"idPersonaCreazione,idAzienda", "idPersonaCreazione,idAzienda,mittenti,destinatari"})
@GenerateProjections({
    "idPersonaCreazione,idAzienda", 
    "idPersonaCreazione,idAzienda,mittenti,competenti,coinvolti,related", 
    "idPersonaCreazione,idAzienda,mittenti,competenti,coinvolti,related,allegati,registroDocList",
    "idPersonaCreazione,idAzienda,mittenti,competenti,coinvolti,related,allegati,registroDocList,attoriList",
    "idPersonaCreazione,idAzienda,mittenti,competenti,coinvolti,related,allegati,registroDocList,attoriList,archiviDocList,notaDocList",
    "idPersonaCreazione,idAzienda,mittenti,competenti,coinvolti,related,allegati,registroDocList,attoriList,archiviDocList,notaDocList,docAnnullatoList",
    "noteVersamentoList"
})
@DynamicUpdate
public class Doc implements Serializable {

    public static enum VisibilitaDoc {
        NORMALE,
        LIMITATA,
        RISERVATO
    }
    
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;

    @OneToOne(cascade = CascadeType.ALL, mappedBy = "idDoc", fetch = FetchType.LAZY, optional = true)
    @JsonBackReference(value = "idDocDetail")    
    private DocDetail idDocDetail;
    
    @Basic(optional = true)
    @Column(name = "oggetto")
    private String oggetto;

    @JoinColumn(name = "id_persona_creazione", referencedColumnName = "id")
    @ManyToOne(fetch = FetchType.LAZY)
    private Persona idPersonaCreazione;

    @JoinColumn(name = "id_azienda", referencedColumnName = "id")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Azienda idAzienda;

    @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss.SSSSSSXXX'['VV']'")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss.SSSSSSXXX'['VV']'")
    @Column(name = "data_creazione")
    @Basic(optional = false)
    @NotNull
    private ZonedDateTime dataCreazione = ZonedDateTime.now();
    
    @Column(name = "visibilita")
    @Enumerated(EnumType.STRING)
    private VisibilitaDoc visibilita = VisibilitaDoc.NORMALE;

    @Column(name = "tipologia")
    @Enumerated(EnumType.STRING)
    private DocDetailInterface.TipologiaDoc tipologia;
    
    @Column(name = "id_esterno")
    private String idEsterno;
    
    @Column(name = "pregresso")
    private Boolean pregresso;
    
    @Column(name = "stato_versamento")
    @Enumerated(EnumType.STRING)
    private Versamento.StatoVersamento statoVersamento;
    //lista di mittenti che conterra per il momento solo un elemento
//    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idDoc", fetch = FetchType.LAZY)

    
    
    //@Filter(name = "mittenti")
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idDoc", fetch = FetchType.LAZY)
    @Where(clause = "tipo='MITTENTE'")
    @JsonIgnoreProperties("idDoc")
    @JsonBackReference(value = "mittenti")
    private List<Related> mittenti;

//    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idDoc", fetch = FetchType.LAZY)
    
    //@Filter(name = "destinatari")
//    @Transient
//    private List<Related> destinatari;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idDoc", fetch = FetchType.LAZY)
    @Where(clause = "tipo = 'A'")
    @JsonIgnoreProperties("idDoc")
    @JsonBackReference(value = "competenti")
    private List<Related> competenti;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idDoc", fetch = FetchType.LAZY)
    @Where(clause = "tipo = 'CC'")
    @JsonIgnoreProperties("idDoc")
    @JsonBackReference(value = "coinvolti")
    private List<Related> coinvolti;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idDoc", fetch = FetchType.LAZY)
    @JsonBackReference(value = "related")
    private List<Related> related;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idDoc", fetch = FetchType.LAZY)
    @JsonBackReference(value = "messageDocList")
    private List<MessageDoc> messageDocList;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idDoc", fetch = FetchType.LAZY)
    @JsonBackReference(value = "noteVersamento")
    private List<NoteVersamento> noteVersamentoList;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idDoc", fetch = FetchType.LAZY)
    @JsonBackReference(value = "registroDocList")
    private List<RegistroDoc> registroDocList;
    
    @OneToMany(cascade = {CascadeType.MERGE, CascadeType.PERSIST}, mappedBy = "idDoc", fetch = FetchType.LAZY)
    @JsonBackReference(value = "allegati")
    private List<Allegato> allegati;
    
    @OneToMany(cascade = {CascadeType.MERGE, CascadeType.PERSIST}, mappedBy = "idDoc", fetch = FetchType.LAZY)
    @JsonBackReference(value = "attori")
    private List<AttoreDoc> attoriList;
    
    @OneToMany(cascade = {CascadeType.MERGE, CascadeType.PERSIST}, mappedBy = "idDoc", fetch = FetchType.LAZY)
    @JsonBackReference(value = "archiviDocList")
    private List<ArchivioDoc> archiviDocList;
    
    @OneToMany(cascade = {CascadeType.MERGE, CascadeType.PERSIST}, mappedBy = "idDoc", fetch = FetchType.LAZY)
    @JsonBackReference(value = "versamentiList")
    private List<Versamento> versamentiList;
    
    @OneToMany(cascade = {CascadeType.MERGE, CascadeType.PERSIST}, mappedBy = "idDocSorgente", fetch = FetchType.LAZY)
    @JsonBackReference(value = "docsCollegati")
    private List<DocDoc> docsCollegati;
    
    @OneToMany(cascade = {CascadeType.MERGE, CascadeType.PERSIST}, mappedBy = "idDoc", fetch = FetchType.LAZY)
    @JsonBackReference(value = "notaDocList")
    private List<NotaDoc> notaDocList;
    
    @OneToMany(cascade = {CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REMOVE}, mappedBy = "idDoc", fetch = FetchType.LAZY)
    @JsonBackReference(value = "docAnnullatoList")
    private List<DocAnnullato> docAnnullatoList;
    
    @Type(type = "jsonb")
    @Column(name = "additional_data", columnDefinition = "jsonb")
    private HashMap<String,Object> additionalData;
    
    @JoinColumn(name = "id_pec_mittente", referencedColumnName = "id")
    @ManyToOne(fetch = FetchType.LAZY, cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    @JsonBackReference(value = "idPecMittente")
    private Pec idPecMittente;

    @Version()
    @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss.SSSSSSXXX'['VV']'")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss.SSSSSSXXX'['VV']'")
    private ZonedDateTime version;

    public Doc() {
    }

    public Doc(Integer id, String oggetto, Persona idPersonaCreazione, Azienda idAzienda, ZonedDateTime dataCreazione) {
        this.id = id;
        this.oggetto = oggetto;
        this.idPersonaCreazione = idPersonaCreazione;
        this.idAzienda = idAzienda;
        this.dataCreazione = dataCreazione;
    }

    public Doc(String oggetto, Persona idPersonaCreazione, Azienda idAzienda, DocDetailInterface.TipologiaDoc tipologia) {
        this.oggetto = oggetto;
        this.idPersonaCreazione = idPersonaCreazione;
        this.idAzienda = idAzienda;
        this.tipologia = tipologia;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public DocDetail getIdDocDetail() {
        return idDocDetail;
    }

    public void setIdDocDetail(DocDetail idDocDetail) {
        this.idDocDetail = idDocDetail;
    }
    
    public String getOggetto() {
        return oggetto;
    }

    public void setOggetto(String oggetto) {
        this.oggetto = oggetto;
    }

    public Persona getIdPersonaCreazione() {
        return idPersonaCreazione;
    }

    public void setIdPersonaCreazione(Persona idPersonaCreazione) {
        this.idPersonaCreazione = idPersonaCreazione;
    }

    public Azienda getIdAzienda() {
        return idAzienda;
    }

    public void setIdAzienda(Azienda idAzienda) {
        this.idAzienda = idAzienda;
    }

    public ZonedDateTime getDataCreazione() {
        return dataCreazione;
    }

    public void setDataCreazione(ZonedDateTime dataCreazione) {
        this.dataCreazione = dataCreazione;
    }

    public VisibilitaDoc getVisibilita() {
        return visibilita;
    }

    public void setVisibilita(VisibilitaDoc visibilita) {
        this.visibilita = visibilita;
    }

    public DocDetailInterface.TipologiaDoc getTipologia() {
        return tipologia;
    }

    public void setTipologia(DocDetailInterface.TipologiaDoc tipologia) {
        this.tipologia = tipologia;
    }

    public List<Related> getMittenti() {
        return mittenti;
    }

    public void setMittenti(List<Related> mittenti) {
        this.mittenti = mittenti;
    }

    public List<Related> getCompetenti() {
        return competenti;
    }

    public void setCompetenti(List<Related> competenti) {
        this.competenti = competenti;
    }

    public List<Related> getCoinvolti() {
        return coinvolti;
    }

    public void setCoinvolti(List<Related> coinvolti) {
        this.coinvolti = coinvolti;
    }

    public List<Related> getRelated() {
        return related;
    }

    public void setRelated(List<Related> related) {
        this.related = related;
    }

    public List<MessageDoc> getMessageDocList() {
        return messageDocList;
    }

    public void setMessageDocList(List<MessageDoc> messageDocList) {
        this.messageDocList = messageDocList;
    }

    public List<RegistroDoc> getRegistroDocList() {
        return registroDocList;
    }

    public void setRegistroDocList(List<RegistroDoc> registroDocList) {
        this.registroDocList = registroDocList;
    }

    public List<Allegato> getAllegati() {
        return allegati;
    }

    public void setAllegati(List<Allegato> allegati) {
        this.allegati = allegati;
    }

    public List<AttoreDoc> getAttoriList() {
        return attoriList;
    }

    public void setAttoriList(List<AttoreDoc> attoriList) {
        this.attoriList = attoriList;
    }

    public ZonedDateTime getVersion() {
        return version;
    }

    public void setVersion(ZonedDateTime version) {
        this.version = version;
    }

    public String getIdEsterno() {
        return idEsterno;
    }

    public void setIdEsterno(String idEsterno) {
        this.idEsterno = idEsterno;
    }

    public Versamento.StatoVersamento getStatoVersamento() {
        return statoVersamento;
    }

    public void setStatoVersamento(Versamento.StatoVersamento statoVersamento) {
        this.statoVersamento = statoVersamento;
    }
    
    public List<ArchivioDoc> getArchiviDocList() {
        return archiviDocList;
    }

    public void setArchiviDocList(List<ArchivioDoc> archiviDocList) {
        this.archiviDocList = archiviDocList;
    }

    public List<Versamento> getVersamentiList() {
        return versamentiList;
    }

    public void setVersamentiList(List<Versamento> versamentiList) {
        this.versamentiList = versamentiList;
    }

    public List<NotaDoc> getNotaDocList() {
        return notaDocList;
    }

    public void setNotaDocList(List<NotaDoc> notaDocList) {
        this.notaDocList = notaDocList;
    }

    public HashMap<String, Object> getAdditionalData() {
        return additionalData;
    }

    public void setAdditionalData(HashMap<String, Object> additionalData) {
        this.additionalData = additionalData;
    }

    public Boolean getPregresso() {
        return pregresso;
    }

    public void setPregresso(Boolean pregresso) {
        this.pregresso = pregresso;
    }

    public List<NoteVersamento> getNoteVersamentoList() {
        return noteVersamentoList;
    }

    public void setNoteVersamentoList(List<NoteVersamento> noteVersamentoList) {
        this.noteVersamentoList = noteVersamentoList;
    }

    public Pec getIdPecMittente() {
        return idPecMittente;
    }

    public void setIdPecMittente(Pec idPecMittente) {
        this.idPecMittente = idPecMittente;
    }
    
    public List<DocDoc> getDocsCollegati() {
        return docsCollegati;
    }
    

    public void setDocsCollegati(List<DocDoc> docsCollegati) {
        this.docsCollegati = docsCollegati;
    }
    

    
    
    

    public List<DocAnnullato> getDocAnnullatoList() {
        return docAnnullatoList;
    }

    public void setDocAnnullatoList(List<DocAnnullato> docAnnullatoList) {
        this.docAnnullatoList = docAnnullatoList;
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
        if (!(object instanceof Doc)) {
            return false;
        }
        Doc other = (Doc) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return getClass().getCanonicalName() + "[ id=" + id + " ]";
    }

}
