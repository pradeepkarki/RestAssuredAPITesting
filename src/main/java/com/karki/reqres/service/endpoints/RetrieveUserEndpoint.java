package com.karki.reqres.service.endpoints;

import com.karki.reqres.service.BaseWebEndpoint;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;

import java.util.Map;

public class RetrieveUserEndpoint extends BaseWebEndpoint {

    private static final String RETRIEVE_USER_ENDPOINT = "/users/{userid}";
    private static final String RETRIEVE_USERS_ENDPOINT = "/users";

    public RetrieveUserEndpoint(RequestSpecification requestSpecification) {
        this.requestSpecification = requestSpecification;
    }

    public ValidatableResponse retrieveUser(String userId, int statusCode) {
        LOGGER.info("GET user by id = {}", userId);

        return this.get(requestSpecification, RETRIEVE_USER_ENDPOINT, userId);
    }
    public ValidatableResponse retrieveAllUsers(Map<String,Integer> queryParams, int statusCode) {
        LOGGER.info("GET list of users = {}", queryParams);
        requestSpecification.queryParams(queryParams);
        return this.getAll(requestSpecification, RETRIEVE_USERS_ENDPOINT);
    }


}
