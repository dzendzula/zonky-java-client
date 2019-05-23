package org.zhezhela.zonky.rest.connector.impl;

import org.apache.http.NameValuePair;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.zhezhela.zonky.rest.config.mapping.ZonkyRequest;
import org.zhezhela.zonky.rest.connector.RestAbstactConnector;

import java.util.Collections;
import java.util.List;

@Component
public class ZonkyConnector extends RestAbstactConnector<ZonkyRequest> {

    @Value("${zonky.connection.schema:}")
    private String scheme;
    @Value("${zonky.connection.host:}")
    private String host;
    @Value("${zonky.connection.port:}")
    private Integer port;

    @Autowired
    private RestTemplate restTemplate;

    @Override
    protected RestTemplate getRestTemplate() {
        return restTemplate;
    }

    @Override
    protected String getScheme() {
        return scheme;
    }

    @Override
    protected String getHost() {
        return host;
    }

    @Override
    protected Integer getPort() {
        return port != null ? port : -1;
    }

    @Override
    protected String getPath(ZonkyRequest requestType, String... params) {
        return requestType.getPath(params);
    }

    @Override
    protected List<NameValuePair> getParameters(ZonkyRequest requestType) {
        //request params if needed
        //List<NameValuePair> params = new ArrayList<>();
        return Collections.emptyList();
    }

}
