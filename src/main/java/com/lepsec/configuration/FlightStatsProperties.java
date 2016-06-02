package com.lepsec.configuration;

import org.springframework.boot.context.properties.ConfigurationProperties;

import javax.validation.constraints.NotNull;

/**
 * Created by jonatannietoa on 02/06/2016.
 */
@ConfigurationProperties("flightstats.api")
public class FlightStatsProperties {
    private final Api api = new Api();

    public Api getApi() {
        return api;
    }

    /**
     * The type Api.
     */
    public static class Api {
        @NotNull
        private String appId;

        @NotNull
        private String appKey;

        /**
         * Gets app id.
         *
         * @return the app id
         */
        public String getAppId() {
            return appId;
        }

        /**
         * Sets app id.
         *
         * @param appId the app id
         */
        public void setAppId(String appId) {
            this.appId = appId;
        }

        /**
         * Gets app key.
         *
         * @return the app key
         */
        public String getAppKey() {
            return appKey;
        }

        /**
         * Sets app key.
         *
         * @param appKey the app key
         */
        public void setAppKey(String appKey) {
            this.appKey = appKey;
        }
    }
}
