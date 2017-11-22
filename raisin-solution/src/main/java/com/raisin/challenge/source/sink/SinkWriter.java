package com.raisin.challenge.source.sink;

import org.apache.log4j.Logger;
import org.springframework.http.HttpEntity;
import org.springframework.web.client.RestTemplate;

import com.raisin.challenge.RaisinSolution;

public class SinkWriter {

    private static final Logger LOGGER = Logger.getLogger(RaisinSolution.class);

    private final String sinkUrl;
    private final RestTemplate restTemplate;

    public SinkWriter(String sinkUrl) {
        super();
        this.sinkUrl = sinkUrl;
        restTemplate = new RestTemplate();
    }

    public void write(String id, String recordType) {
        String body = String.format("{\"kind\": \"%s\", \"id\": \"%s\"}", recordType, id);
        post(body);
    }

    private void post(String body) {
        try {
            HttpEntity<String> request = new HttpEntity<>(body);
            restTemplate.postForLocation(sinkUrl, request);
            LOGGER.info(String.format("Sucessfully posted [%s] to url [%s].", body, sinkUrl));
        } catch (Exception e) {
            LOGGER.warn(String.format("Error while posting [%s] to url [%s].", body, sinkUrl), e);
        }
    }

}
