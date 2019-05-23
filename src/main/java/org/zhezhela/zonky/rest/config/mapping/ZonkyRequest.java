package org.zhezhela.zonky.rest.config.mapping;

import java.util.Arrays;
import java.util.List;

public enum ZonkyRequest {

    LOANS_MARKETPLACE("loans/marketplace"),
    LOANS_LOAN("loans/%s"),
    LOANS_INVESTMENTS("loans/%s/investments");
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

    private static List<ZonkyRequest> authRequest = Arrays.asList(LOANS_INVESTMENTS);


    /**
     * Util method to check whether request shoud be authorized
     */
    public boolean isAuthRequest() {
        return authRequest.contains(this);
    }


}
