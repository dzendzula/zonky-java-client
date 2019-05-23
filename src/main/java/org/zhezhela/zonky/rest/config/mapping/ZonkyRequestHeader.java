package org.zhezhela.zonky.rest.config.mapping;

public enum ZonkyRequestHeader {

    X_ORDER("X-Order"),
    X_PAGE("X-Page"),
    X_SIZE("X-Size"),
    X_TOTAL("X-Total");


    private String value;

    ZonkyRequestHeader(String path) {
        this.value = path;
    }

    public String getValue() {
        return value;
    }

}
