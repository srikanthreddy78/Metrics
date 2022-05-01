import java.util.*;
import java.lang.*;
import org.apache.solr.client.solrj.SolrClient;
import org.apache.solr.client.solrj.SolrRequest;
import org.apache.solr.client.solrj.impl.CloudSolrClient;
import org.apache.solr.client.solrj.request.GenericSolrRequest;
import org.apache.solr.client.solrj.response.SimpleSolrResponse;
import org.apache.solr.common.SolrInputDocument;
import org.apache.solr.common.params.MapSolrParams;
public class Main {
    private static final String m="/admin/metrics";
    public static void main(String args[]) throws Exception{
        final List<String> zkHost =new ArrayList<String>();
        zkHost.add("localhost:2181"); zkHost.add("localhost:2182"); zkHost.add("localHost:2183");
        final CloudSolrClient solrClient = new CloudSolrClient. Builder (zkHost,Optional.empty()).build();
        solrClient.setDefaultCollection("col1");
        MapSolrParams params = new MapSolrParams(Collections.singletonMap("group", "jvm"));
        GenericSolrRequest req = new GenericSolrRequest(SolrRequest.METHOD.GET, m, params);
        SimpleSolrResponse rsp = req.process(solrClient, null);
        System.out.println(rsp.getResponse());
    }
}
