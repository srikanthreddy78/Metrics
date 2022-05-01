package com.securonix.solr.metrics;


import org.apache.solr.client.solrj.SolrServerException;
import org.apache.solr.client.solrj.response.SimpleSolrResponse;
import org.junit.jupiter.api.Test;

import javax.print.attribute.standard.MediaName;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

class MetricsRunnerTest {


    MetricsRunner metricsRunner = new MetricsRunner();

    @Test
    public void testGetJvmMetrics() throws SolrServerException, IOException {
        Map<String, String> parameterMap = new HashMap<>();
        parameterMap.put("group", "jvm");
        SimpleSolrResponse response =  metricsRunner.getMetricsReponse(parameterMap);
        System.out.println(response);

    }

    public void testGetOSMetrics() throws SolrServerException, IOException {
        Map<String, String> parameterMap = new HashMap<>();
        parameterMap.put("prefix", "os");
        SimpleSolrResponse response =  metricsRunner.getMetricsReponse(parameterMap);
        System.out.println(response);
    }

}