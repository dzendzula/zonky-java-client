package org.zhezhela.zonky.rest.connector;

import org.apache.http.NameValuePair;
import org.apache.http.client.utils.URIBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.*;
import org.springframework.util.CollectionUtils;
import org.springframework.web.client.RestTemplate;
import org.zhezhela.zonky.rest.utils.RequestResponseLoggingInterceptor;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

public abstract class RestAbstactConnector<T extends Enum> {

    Logger log = LoggerFactory.getLogger(RequestResponseLoggingInterceptor.class);

    // coniguration methods to be overriden by a concrete connector implementation
    protected abstract String getScheme();

    protected abstract String getHost();

    protected abstract Integer getPort();

    protected abstract String getPath(T requestType, String... params);

    protected abstract RestTemplate getRestTemplate();

    /**
     * Abstract method to form a specific parameter set for each connector implemetnation
     *
     * @param requestType type of request to be prepared
     * @return list of parameters to be passed
     */
    protected abstract List<NameValuePair> getParameters(T requestType);


    public <O, R> R sendGetRequest(T requestType, String[] urlPathParams, O obj, List<NameValuePair> params, Map<String, String> headers, Class<R> claazz) {
        HttpEntity<O> entity = prepareHttpEntity(headers, obj);
        ResponseEntity<R> responseEntity = getRestTemplate().exchange(prepareRequestUri(requestType, urlPathParams, params), HttpMethod.GET, entity, claazz);
        //TODO process response codes from responseEntity
        if (responseEntity != null && responseEntity.getBody() != null) {
            return responseEntity.getBody();
        }
        return null;
    }


    public <O, R> R sendPostRequest(T requestType, O obj, String[] urlParams, List<NameValuePair> queryParams, Map<String, String> headers, Class<R> clazz) {
        HttpEntity<O> entity = prepareHttpEntity(headers, obj);
        ResponseEntity<R> responseEntity = getRestTemplate().exchange(prepareRequestUri(requestType, urlParams, queryParams), HttpMethod.POST, entity, clazz);
        //TODO process response codes from responseEntity
        if (responseEntity != null && responseEntity.getBody() != null) {
            return responseEntity.getBody();
        }
        return null;

    }


    public <O> void sendPutRequest(T requestType, O obj, String[] urlPathParams, List<NameValuePair> params, Map<String, String> headers) {
        HttpEntity<O> entity = prepareHttpEntity(headers, obj);
        ResponseEntity<Void> responseEntity = getRestTemplate().exchange(prepareRequestUri(requestType, urlPathParams, params), HttpMethod.PUT, entity, Void.class);
        //TODO process response codes from responseEntity
    }

    private <O> HttpEntity<O> prepareHttpEntity(Map<String, String> headers, O obj) {
        HttpHeaders requestHeaders = new HttpHeaders();
        requestHeaders.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
        if (headers != null && !CollectionUtils.isEmpty(headers)) {
            headers.forEach(requestHeaders::set);
        }
        return new HttpEntity<>(obj, requestHeaders);
    }


    private URI prepareRequestUri(T requestType, String[] urlParams, List<NameValuePair> queryParams) {
        try {
            if (queryParams == null) {
                queryParams = new ArrayList<>();
            }
            queryParams.addAll(getParameters(requestType));
            return new URIBuilder()
                    .setScheme(getScheme())
                    .setHost(getHost())
                    .setPort(getPort())
                    .setPath(getPath(requestType, urlParams))
                    .setParameters(queryParams)
                    .build();
        } catch (URISyntaxException e) {
            log.error("Error creating connection URL, check configuration or query parameteres. Error message: ", e.getMessage());
        }
        return null;
    }


}
