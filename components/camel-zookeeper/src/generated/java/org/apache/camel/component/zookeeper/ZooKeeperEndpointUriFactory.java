/* Generated by camel build tools - do NOT edit this file! */
package org.apache.camel.component.zookeeper;

import java.net.URISyntaxException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.apache.camel.spi.EndpointUriFactory;

/**
 * Generated by camel build tools - do NOT edit this file!
 */
public class ZooKeeperEndpointUriFactory extends org.apache.camel.support.component.EndpointUriFactorySupport implements EndpointUriFactory {

    private static final String BASE = ":serverUrls/path";

    private static final Set<String> PROPERTY_NAMES;
    static {
        Set<String> set = new HashSet<>(15);
        set.add("serverUrls");
        set.add("path");
        set.add("listChildren");
        set.add("timeout");
        set.add("backoff");
        set.add("bridgeErrorHandler");
        set.add("repeat");
        set.add("sendEmptyMessageOnDelete");
        set.add("exceptionHandler");
        set.add("exchangePattern");
        set.add("create");
        set.add("createMode");
        set.add("lazyStartProducer");
        set.add("basicPropertyBinding");
        set.add("synchronous");
        PROPERTY_NAMES = set;
    }

    @Override
    public boolean isEnabled(String scheme) {
        return "zookeeper".equals(scheme);
    }

    @Override
    public String buildUri(String scheme, Map<String, Object> properties) throws URISyntaxException {
        String syntax = scheme + BASE;
        String uri = syntax;

        Map<String, Object> copy = new HashMap<>(properties);

        uri = buildPathParameter(syntax, uri, "serverUrls", null, true, copy);
        uri = buildPathParameter(syntax, uri, "path", null, true, copy);
        uri = buildQueryParameters(uri, copy);
        return uri;
    }

    @Override
    public Set<String> propertyNames() {
        return PROPERTY_NAMES;
    }

    @Override
    public boolean isLenientProperties() {
        return false;
    }
}
