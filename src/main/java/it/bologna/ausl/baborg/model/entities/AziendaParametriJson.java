package it.bologna.ausl.baborg.model.entities;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import java.io.Serializable;

/**
 *
 * @author gdm
 */
public class AziendaParametriJson implements Serializable {
    private String babelSuiteBdsToolsUrl;
    private String babelSuiteWebApiUrl;
    private String loginSSOField;
    private String loginDBField;
    private String loginDBFieldBaborg;
    private String shalboApiUrl;
    private MasterChefParmas masterchefParams;

    public AziendaParametriJson() {
    }

    public AziendaParametriJson(String babelSuiteBdsToolsUrl, String babelSuiteWebApiUrl, String loginSSOField, String loginDBField, String loginDBFieldBaborg, String shalboApiUrl, MasterChefParmas masterchefParams) {
        this.babelSuiteBdsToolsUrl = babelSuiteBdsToolsUrl;
        this.babelSuiteWebApiUrl = babelSuiteWebApiUrl;
        this.loginSSOField = loginSSOField;
        this.loginDBField = loginDBField;
        this.loginDBFieldBaborg = loginDBFieldBaborg;
        this.shalboApiUrl = shalboApiUrl;
        this.masterchefParams = masterchefParams;
    }

    public String getBabelSuiteBdsToolsUrl() {
        return babelSuiteBdsToolsUrl;
    }

    public void setBabelSuiteBdsToolsUrl(String babelSuiteBdsToolsUrl) {
        this.babelSuiteBdsToolsUrl = babelSuiteBdsToolsUrl;
    }

    public String getBabelSuiteWebApiUrl() {
        return babelSuiteWebApiUrl;
    }

    public void setBabelSuiteWebApiUrl(String babelSuiteWebApiUrl) {
        this.babelSuiteWebApiUrl = babelSuiteWebApiUrl;
    }

    public String getLoginSSOField() {
        return loginSSOField;
    }

    public void setLoginSSOField(String loginSSOField) {
        this.loginSSOField = loginSSOField;
    }

    public String getLoginDBField() {
        return loginDBField;
    }

    public void setLoginDBField(String loginDBField) {
        this.loginDBField = loginDBField;
    }

    public String getLoginDBFieldBaborg() {
        return loginDBFieldBaborg;
    }

    public void setLoginDBFieldBaborg(String loginDBFieldBaborg) {
        this.loginDBFieldBaborg = loginDBFieldBaborg;
    }

    public String getShalboApiUrl() {
        return shalboApiUrl;
    }

    public void setShalboApiUrl(String shalboApiUrl) {
        this.shalboApiUrl = shalboApiUrl;
    }

    public MasterChefParmas getMasterchefParams() {
        return masterchefParams;
    }

    public void setMasterchefParams(MasterChefParmas masterchefParams) {
        this.masterchefParams = masterchefParams;
    }

    public static AziendaParametriJson parse(ObjectMapper objectMapper, String src) throws IOException {
        return objectMapper.readValue(src, AziendaParametriJson.class);
    }
    
    public class MasterChefParmas {
        private String redisHost;
        private Integer redisPort;
        private String inQueue;
        

        public MasterChefParmas() {
        }

        public MasterChefParmas(String redisHost, Integer redisPort, String inQueue) {
            this.redisHost = redisHost;
            this.redisPort = redisPort;
            this.inQueue = inQueue;
        }

        public String getRedisHost() {
            return redisHost;
        }

        public void setRedisHost(String redisHost) {
            this.redisHost = redisHost;
        }

        public Integer getRedisPort() {
            return redisPort;
        }

        public void setRedisPort(Integer redisPort) {
            this.redisPort = redisPort;
        }

        public String getInQueue() {
            return inQueue;
        }

        public void setInQueue(String inQueue) {
            this.inQueue = inQueue;
        }
    }
}