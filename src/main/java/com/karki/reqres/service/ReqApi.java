package com.karki.reqres.service;

import com.karki.reqres.service.endpoints.RetrieveUserEndpoint;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;

public class ReqApi {

    RequestSpecBuilder requestSpecBuilder = null;
    RetrieveUserEndpoint retrieveUserEndpoint;

    public ReqApi() {
        RequestSpecification requestSpecification = getDefaultSpecifications();

        retrieveUserEndpoint = new RetrieveUserEndpoint(requestSpecification);
    }

    private RequestSpecification getDefaultSpecifications() {

        return requestSpecBuilder.setBasePath("https://reqres.in/")
                .setContentType(ContentType.JSON)
                .setBasePath("api").build();

    }


}
