package com.karki.reqres.service;

import com.karki.reqres.service.endpoints.RetrieveUserEndpoint;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.ErrorLoggingFilter;
import io.restassured.filter.log.LogDetail;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;

public class ReqApi {

    RequestSpecBuilder requestSpecBuilder = new RequestSpecBuilder();
    RetrieveUserEndpoint retrieveUserEndpoint;

    public ReqApi() {
        RequestSpecification requestSpecification = getDefaultSpecifications();

        retrieveUserEndpoint = new RetrieveUserEndpoint(requestSpecification);
    }


    public RequestSpecification getDefaultSpecifications() {

        return requestSpecBuilder
                .setBaseUri("https://reqres.in/")
                .setContentType(ContentType.JSON)
                .setBasePath("api")
                .addFilter(new RequestLoggingFilter()) //Log Request
                .addFilter(new ResponseLoggingFilter()) //Log Response
                .addFilter(new ErrorLoggingFilter()) //Log Error
                .build();

    }

    public RetrieveUserEndpoint getUsers()
    {
        return retrieveUserEndpoint;
    }


}
