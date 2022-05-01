import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import org.apache.solr.client.solrj.SolrRequest;
import org.apache.solr.client.solrj.impl.CloudSolrClient;
import org.apache.solr.client.solrj.request.GenericSolrRequest;
import org.apache.solr.client.solrj.response.SimpleSolrResponse;
import org.apache.solr.common.params.MapSolrParams;
import org.apache.solr.common.util.NamedList;
import org.json.JSONObject;

public class Main {
    private static final String m="/admin/metrics";
    public static void main(String[] args) throws Exception{
        final List<String> zkHost = new ArrayList<>();
        zkHost.add("127.0.0.1:2181"); zkHost.add("127.0.0.1:2182"); zkHost.add("127.0.0.1:2183");
        final CloudSolrClient solrClient = new CloudSolrClient. Builder (zkHost,Optional.empty()).build();
        System.out.println("defaultCollection="+System.getProperty("defaultCollection"));
        solrClient.setDefaultCollection("col1");
        MapSolrParams params = new MapSolrParams(Collections.singletonMap("prefix","os"));
        GenericSolrRequest req = new GenericSolrRequest(SolrRequest.METHOD.GET, m, params);
        SimpleSolrResponse rsp = req.process(solrClient, null);
        System.out.println(rsp.getResponse());
    }
}
