package com.karki.reqres.service.endpoints;

import com.karki.reqres.service.BaseWebEndpoint;
import io.restassured.specification.RequestSpecification;

public class CreateUserEndpoint extends BaseWebEndpoint {

    private static final String CREATE_USER_ENDPOINT = "";
    public CreateUserEndpoint(RequestSpecification requestSpecification) {
       this.requestSpecification = requestSpecification;
    }
}
