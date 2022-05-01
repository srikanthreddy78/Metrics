package com.securonix.solr.metrics;
import org.apache.solr.client.solrj.SolrRequest;
import org.apache.solr.client.solrj.SolrServerException;
import org.apache.solr.client.solrj.impl.CloudSolrClient;
import org.apache.solr.client.solrj.request.GenericSolrRequest;
import org.apache.solr.client.solrj.response.SimpleSolrResponse;
import org.apache.solr.common.params.MapSolrParams;
import org.apache.solr.common.util.NamedList;

import java.io.IOException;
import java.util.*;

public class MetricsRunner {


    private static final String METRICS_URI="/admin/metrics";

    public SimpleSolrResponse getMetricsReponse(Map<String, String> paramsMap) throws SolrServerException, IOException {
        final List<String> zkHost = new ArrayList<>();
        zkHost.add("localhost:2181");
        zkHost.add("localhost:2182");
        zkHost.add("localHost:2183");
        final CloudSolrClient solrClient = new CloudSolrClient.Builder(zkHost, Optional.empty()).build();
        solrClient.setDefaultCollection("col1");
        MapSolrParams params = new MapSolrParams(paramsMap);
        GenericSolrRequest req = new GenericSolrRequest(SolrRequest.METHOD.GET, METRICS_URI, params);
        SimpleSolrResponse rsp = req.process(solrClient, null);
        /*NamedList<Object> response = rsp.getResponse();
        ModeName modeName = new ModeName();
        Map<String, String> responseMetricParams = new HashMap<>();
        for (Object object : response) {
           // responseMetricParams.put();
        }*/
        return rsp;
    }
}
