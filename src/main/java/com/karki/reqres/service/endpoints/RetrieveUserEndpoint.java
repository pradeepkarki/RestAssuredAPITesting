package com.karki.reqres.service.endpoints;

import com.karki.reqres.service.BaseWebEndpoint;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;

public class RetrieveUserEndpoint extends BaseWebEndpoint {

    private static final String RETRIEVE_USER_ENDPOINT = "/users/{userid}";

    public RetrieveUserEndpoint(RequestSpecification requestSpecification) {
        this.requestSpecification = requestSpecification;
    }

    public ValidatableResponse retrieveUser(String userId, int statusCode) {
        LOGGER.info("GET user by id = {}", userId);

        return this.get(requestSpecification, RETRIEVE_USER_ENDPOINT, userId);
    }

}
