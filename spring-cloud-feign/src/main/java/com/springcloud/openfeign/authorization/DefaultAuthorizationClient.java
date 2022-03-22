package com.springcloud.openfeign.authorization;

public interface DefaultAuthorizationClient {

    boolean checkPermission(String jwtToken, String resource, String action);
}
