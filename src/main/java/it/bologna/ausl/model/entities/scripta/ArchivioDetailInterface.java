package it.bologna.ausl.model.entities.scripta;

import it.bologna.ausl.model.entities.baborg.Azienda;
import it.bologna.ausl.model.entities.baborg.Persona;
import it.bologna.ausl.model.entities.baborg.Struttura;
import java.time.ZonedDateTime;
import java.util.List;
import javax.persistence.Id;

/**
 *
 * @author gusgus
 */
public interface ArchivioDetailInterface {

    public Integer getId();

    public void setId(Integer id);

    public Azienda getIdAzienda();

    public void setIdAzienda(Azienda idAzienda);

    public ZonedDateTime getDataCreazione();

    public void setDataCreazione(ZonedDateTime dataCreazione);

    public ArchivioDetailInterface getIdArchivioPadre();
    
    public void setIdArchivioPadre(ArchivioDetailInterface idArchivioPadre);
    
    public List<? extends ArchivioDetailInterface> getArchiviFigliList();
    
    public void setArchiviFigliList(List<? extends ArchivioDetailInterface> archiviFigliList);
    
    public ZonedDateTime getDataCreazionePadre();

    public void setDataCreazionePadre(ZonedDateTime dataCreazionePadre);
    
    public ArchivioDetailInterface getIdArchivioRadice();
    
    public void setIdArchivioRadice(ArchivioDetailInterface idArchivioRadice);
    
    public List<? extends ArchivioDetailInterface> getArchiviNipotiList();
    
    public void setArchiviNipotiList(List<? extends ArchivioDetailInterface> archiviNipotiList);
    
    public ZonedDateTime getDataCreazioneRadice();

    public void setDataCreazioneRadice(ZonedDateTime dataCreazioneRadice);
    
    public Boolean getFoglia();

    public void setFoglia(Boolean foglia);
    
    public Integer getNumero();

    public void setNumero(Integer numero);
            
    public Integer getAnno();

    public void setAnno(Integer anno);
    
    public String getNumerazioneGerarchica();

    public void setNumerazioneGerarchica(String numerazioneGerarchica);
    
    public String getOggetto();

    public void setOggetto(String oggetto);
    
    public String getOggettoTscol();

    public void setOggettoTscol(String oggettoTscol);
    
    public Double getRankingOggetto();

    public void setRankingOggetto(Double rankingOggetto);
    
    public Archivio.StatoArchivio getStato();

    public void setStato(Archivio.StatoArchivio stato);

    public Archivio.TipoArchivio getTipo();

    public void setTipo(Archivio.TipoArchivio tipo);
    
    public Persona getIdPersonaResponsabile();

    public void setIdPersonaResponsabile(Persona idPersonaResponsabile);
    
    public Persona getIdPersonaCreazione();

    public void setIdPersonaCreazione(Persona idPersonaCreazione);
    
    public Struttura getIdStruttura();

    public void setIdStruttura(Struttura idStruttura);
    
    public Integer getIdTitolo();
    
    public void setIdTitolo(Integer idTitolo);
    
    public List<Vicario> getVicari();

    public void setVicari(List<Vicario> vicari);
    
    public Integer[] getIdVicari();
    
    public String getTscol();

    public void setTscol(String tscol);
    
    public ZonedDateTime getDataInserimentoRiga();

    public void setDataInserimentoRiga(ZonedDateTime dataInserimentoRiga);

    public ZonedDateTime getVersion();

    public void setVersion(ZonedDateTime version);
    
    public static class Vicario {

        String descrizione;
        Integer idPersona;

        public String getDescrizione() {
            return descrizione;
        }

        public void setDescrizione(String descrizione) {
            this.descrizione = descrizione;
        }

        public Integer getIdPersona() {
            return idPersona;
        }

        public void setIdPersona(Integer idPersona) {
            this.idPersona = idPersona;
        }

    }
}
