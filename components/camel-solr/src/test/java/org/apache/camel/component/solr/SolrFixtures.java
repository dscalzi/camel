package org.apache.camel.component.solr;
import java.io.IOException;

import org.apache.camel.test.AvailablePortFinder;
import org.apache.log4j.Logger;
import org.apache.solr.client.solrj.SolrServer;
import org.apache.solr.client.solrj.SolrServerException;
import org.apache.solr.client.solrj.embedded.JettySolrRunner;
import org.apache.solr.client.solrj.impl.HttpSolrServer;;

public class SolrFixtures {
	static Logger log = Logger.getLogger(SolrFixtures.class);
	
    private static JettySolrRunner solrRunner;
    private static JettySolrRunner solrHttpsRunner;
    private static HttpSolrServer solrServer;
    private static HttpSolrServer solrHttpsServer;
    boolean useHttps;
    
	private static int port;
	private static int httpsPort;

    SolrFixtures(boolean useHttps) {
    	this.useHttps = useHttps;
    }
    
    String solrRouteUri() {
		if (useHttps) {
			return "solrs://localhost:" + httpsPort + "/solr";
		} else {
			return "solr://localhost:" + port + "/solr";
		}
    }
    
    SolrServer getServer() {
    	if (useHttps) {
    		return this.solrHttpsServer;
    	} else {
    		return this.solrServer;
    	}
    }
    
    static void createSolrFixtures() throws Exception {
    	solrHttpsRunner = JettySolrFactory.createJettyTestFixture(true);
    	httpsPort = solrHttpsRunner.getLocalPort();
    	log.info("Started Https Test Server: " + solrHttpsRunner.getBaseUrl());;
    	
    	solrRunner = JettySolrFactory.createJettyTestFixture(false);
    	port = solrRunner.getLocalPort();
    	
    	log.info("Started Test Server: " + solrRunner.getBaseUrl());

    }
    
    public static void teardownSolrFixtures() throws Exception {
        if (solrRunner != null) {
            solrRunner.stop();
        }
        if (solrHttpsRunner != null) {
            solrHttpsRunner.stop();
        }
    }
    
    public void clearFixtures() throws SolrServerException, IOException {
    	 if (solrServer != null) {
             // Clear the Solr index.
             solrServer.deleteByQuery("*:*");
             solrServer.commit();
         }
         if (solrHttpsServer != null) {
         	solrHttpsServer.deleteByQuery("*:*");
         	solrHttpsServer.commit();
         }
    }
    
    public void clearIndex() throws SolrServerException, IOException {
    	 if (solrServer != null) {
             // Clear the Solr index.
             solrServer.deleteByQuery("*:*");
             solrServer.commit();
         }
         if (solrHttpsServer != null) {
         	solrHttpsServer.deleteByQuery("*:*");
         	solrHttpsServer.commit();
         }
    }
}
