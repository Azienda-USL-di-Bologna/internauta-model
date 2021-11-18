package it.bologna.ausl.model.entities.shpeck.data;

import it.bologna.ausl.model.entities.data.AdditionalData;
import com.fasterxml.jackson.annotation.JsonInclude;
import java.time.LocalDateTime;

/**
 *
 * @author gdm
 */
public class AdditionalDataTagComponent {
    
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public static class IdGdDoc {
        private String id;
        private String oggetto;

        public IdGdDoc() {
        }

        public IdGdDoc(String id, String oggetto) {
            this.id = id;
            this.oggetto = oggetto;
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getOggetto() {
            return oggetto;
        }

        public void setOggetto(String oggetto) {
            this.oggetto = oggetto;
        }
    }
    
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public static class idUtente {
        private Integer id;
        private String descrizione;

        public idUtente() {
        }

        public idUtente(Integer id, String descrizione) {
            this.id = id;
            this.descrizione = descrizione;
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
    }
    
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public static class idAzienda {
        private Integer id;
        private String nome;
        private String descrizione;

        public idAzienda() {
        }

        public idAzienda(Integer id, String nome, String descrizione) {
            this.id = id;
            this.nome = nome;
            this.descrizione = descrizione;
        }

        public Integer getId() {
            return id;
        }

        public void setId(Integer id) {
            this.id = id;
        }

        public String getNome() {
            return nome;
        }

        public void setNome(String nome) {
            this.nome = nome;
        }

        public String getDescrizione() {
            return descrizione;
        }

        public void setDescrizione(String descrizione) {
            this.descrizione = descrizione;
        }
    }
    
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public static class idFascicolo {
        private String id;
        private String oggetto;
        private String numerazioneGerarchica;

        public idFascicolo() {
        }

        public idFascicolo(String id, String oggetto, String numerazioneGerarchica) {
            this.id = id;
            this.oggetto = oggetto;
            this.numerazioneGerarchica = numerazioneGerarchica;
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getOggetto() {
            return oggetto;
        }

        public void setOggetto(String oggetto) {
            this.oggetto = oggetto;
        }

        public String getNumerazioneGerarchica() {
            return numerazioneGerarchica;
        }

        public void setNumerazioneGerarchica(String numerazioneGerarchica) {
            this.numerazioneGerarchica = numerazioneGerarchica;
        }
    }
    
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public static class idDocumento {
        private String oggetto;
        private String codiceRegistro;
        private String numeroProposta;
        private String dataProposta;
        private String dataProtocollo;
        private String numeroProtocollo;
        private String anno;

        public idDocumento() {
        }

        public idDocumento(String oggetto, String codiceRegistro, String numeroProposta, String dataProposta) {
            this.oggetto = oggetto;
            this.codiceRegistro = codiceRegistro;
            this.numeroProposta = numeroProposta;
            this.dataProposta = dataProposta;
        }

        public String getOggetto() {
            return oggetto;
        }

        public void setOggetto(String oggetto) {
            this.oggetto = oggetto;
        }

        public String getCodiceRegistro() {
            return codiceRegistro;
        }

        public void setCodiceRegistro(String codiceRegistro) {
            this.codiceRegistro = codiceRegistro;
        }

        public String getNumeroProposta() {
            return numeroProposta;
        }

        public void setNumeroProposta(String numeroProposta) {
            this.numeroProposta = numeroProposta;
        }

        public String getDataProposta() {
            return dataProposta;
        }

        public void setDataProposta(String dataProposta) {
            this.dataProposta = dataProposta;
        }

        public String getDataProtocollo() {
            return dataProtocollo;
        }

        public void setDataProtocollo(String dataProtocollo) {
            this.dataProtocollo = dataProtocollo;
        }

        public String getNumeroProtocollo() {
            return numeroProtocollo;
        }

        public void setNumeroProtocollo(String numeroProtocollo) {
            this.numeroProtocollo = numeroProtocollo;
        }

        public String getAnno() {
            return anno;
        }

        public void setAnno(String anno) {
            this.anno = anno;
        }
    }
    
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public static class idPec {
        private String id;
        private String indirizzo;

        public idPec() {
        }

        public idPec(String id, String indirizzo) {
            this.id = id;
            this.indirizzo = indirizzo;
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getIndirizzo() {
            return indirizzo;
        }

        public void setIndirizzo(String indirizzo) {
            this.indirizzo = indirizzo;
        }
    }
    
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public static class AdditionalDataArchiviation implements AdditionalData {
        public IdGdDoc idGdDoc;
        public idUtente idUtente;
        public idAzienda idAzienda;
        public idFascicolo idFascicolo;
        public LocalDateTime dataArchiviazione;

        public AdditionalDataArchiviation() {
        }
        
        public AdditionalDataArchiviation(IdGdDoc idGdDoc, idUtente idUtente, idAzienda idAzienda, idFascicolo idFascicolo, LocalDateTime dataArchiviazione) {
            this.idGdDoc = idGdDoc;
            this.idUtente = idUtente;
            this.idAzienda = idAzienda;
            this.idFascicolo = idFascicolo;
            this.dataArchiviazione = dataArchiviazione;
        }

        public IdGdDoc getIdGdDoc() {
            return idGdDoc;
        }

        public void setIdGdDoc(IdGdDoc idGdDoc) {
            this.idGdDoc = idGdDoc;
        }

        public idUtente getIdUtente() {
            return idUtente;
        }

        public void setIdUtente(idUtente idUtente) {
            this.idUtente = idUtente;
        }

        public idAzienda getIdAzienda() {
            return idAzienda;
        }

        public void setIdAzienda(idAzienda idAzienda) {
            this.idAzienda = idAzienda;
        }

        public idFascicolo getIdFascicolo() {
            return idFascicolo;
        }

        public void setIdFascicolo(idFascicolo idFascicolo) {
            this.idFascicolo = idFascicolo;
        }

        public LocalDateTime getDataArchiviazione() {
            return dataArchiviazione;
        }

        public void setDataArchiviazione(LocalDateTime dataArchiviazione) {
            this.dataArchiviazione = dataArchiviazione;
        }
    }
    
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public static class AdditionalDataRegistration implements AdditionalData {
        public idPec idPec;
        public idUtente idUtente;
        public idAzienda idAzienda;
        public idDocumento idDocumento;

        public AdditionalDataRegistration() {
        }

        public AdditionalDataRegistration(idPec idPec, idUtente idUtente, idAzienda idAzienda, idDocumento idDocumento) {
            this.idPec = idPec;
            this.idUtente = idUtente;
            this.idAzienda = idAzienda;
            this.idDocumento = idDocumento;
        }

        public idPec getIdPec() {
            return idPec;
        }

        public void setIdPec(idPec idPec) {
            this.idPec = idPec;
        }

        public idUtente getIdUtente() {
            return idUtente;
        }

        public void setIdUtente(idUtente idUtente) {
            this.idUtente = idUtente;
        }

        public idAzienda getIdAzienda() {
            return idAzienda;
        }

        public void setIdAzienda(idAzienda idAzienda) {
            this.idAzienda = idAzienda;
        }

        public idDocumento getIdDocumento() {
            return idDocumento;
        }

        public void setIdDocumento(idDocumento idDocumento) {
            this.idDocumento = idDocumento;
        }
    }
    
    
}
