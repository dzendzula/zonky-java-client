package org.zhezhela.zonky.rest.config.mapping;

import java.util.Collections;
import java.util.List;

public enum ZonkyRequest {

    LOANS_MARKETPLACE("loans/marketplace"),
    LOANS_LOAN("loans/%s"),
    LOANS_INVESTMENT("loans/%s/investment");
    //... ;

    private String path;

    ZonkyRequest(String path) {
        this.path = path;
    }

    /**
     * Forms a correct context path wit the parameters passed
     *
     * @param params ordered list of parameters to be inserted in path templete.
     * @return
     */
    public String getPath(String... params) {
        return String.format(path, params);
    }

    private static List<ZonkyRequest> authRequest = Collections.emptyList();


    /**
     * Util method to check whether request shoud be authorized
     */
    public boolean isAuthRequest() {
        return authRequest.contains(this);
    }


}
