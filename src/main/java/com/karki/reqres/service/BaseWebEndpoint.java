package com.karki.reqres.service;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.common.mapper.TypeRef;
import io.restassured.mapper.ObjectMapperType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


import java.util.List;


import static io.restassured.RestAssured.given;

public class BaseWebEndpoint {

    protected static final Logger LOGGER = LogManager.getLogger();
    protected RequestSpecification requestSpecification;

    public BaseWebEndpoint() {
    }

    public BaseWebEndpoint(RequestSpecification requestSpecification) {
        this.requestSpecification = requestSpecification;
    }

    /**
     * A helper mehod to use rest assured to extract validatable response as desired object/ DTO
     */
    public static <T> T extractAsDto(ValidatableResponse validatableResponse, Class<T> dtoClass) {

        return validatableResponse.extract().as(dtoClass, ObjectMapperType.JACKSON_2);

    }


    /**
     * A helper mehod to use rest assured to extract validatable response as desired object type
     */
    public static <T> T extractAsDto(ValidatableResponse validatableResponse, TypeRef<T> type) {

        return validatableResponse.extract().as(type);

    }


    /**
     * A helper mehod to use rest assured to extract validatable response as desired object List
     */
    public static <T> List<T> extractAsDtoList(ValidatableResponse validatableResponse, Class<T> dtoClass) {

        return validatableResponse.extract().body().jsonPath().getList("", dtoClass);

    }

    /**
     * A helper mehod to use rest assured to extract validatable response as desired object List
     */
    public static JsonPath extractAsJsonPath(ValidatableResponse validatableResponse) {

        return validatableResponse.extract().body().jsonPath();

    }

    /**
     * Execute GET Request
     *
     * @param requestSpecification RequestSpecification - holds rest assured information about request
     * @param path - path of endpoint such as foo/bar
     * @param pathParams path params, for example if path contains foo/{fooparam1}/bar/{barparam1}
     *                   then parameters will replaced in it
     * @return ValidatableResponse
     */
    public ValidatableResponse get(RequestSpecification requestSpecification, String path, Object... pathParams) {
    LOGGER.debug("Send GET Request to url [{}]",path);
        return given()
                .spec(requestSpecification)
                .when()
                .get(path, pathParams)
                .then();
    }

    /**
     * Execute GET Request
     *
     * @param requestSpecification RequestSpecification - holds rest assured information about request
     * @param path - path of endpoint such as foo/bar
     *
     * @return ValidatableResponse
     */
    public ValidatableResponse getAll(RequestSpecification requestSpecification, String path) {
        LOGGER.debug("Send GET Request to url [{}]",path);
        return given()
                .spec(requestSpecification)
                .when()
                .get(path)
                .then();
    }

    /**
     * Execute POST request
     *
     * @param requestSpecification RequestSpecification - holds rest assured information about request
     * @param path - path of endpoint such as foo/bar
     * @param bodyPayload payload object
     * @param pathParams path params, for example if path contains foo/{fooparam1}/bar/{barparam1}
     *      *                   then parameters will replaced in it
     * @return ValidatableResponse
     */
    public ValidatableResponse post(RequestSpecification requestSpecification, String path, Object bodyPayload, Object... pathParams) {
        RequestSpecBuilder requestSpecBuilder = new RequestSpecBuilder();
        requestSpecBuilder.addRequestSpecification(requestSpecification);

        if (bodyPayload != null) {
            requestSpecBuilder.setBody(bodyPayload);
        }

        return given()
                .spec(requestSpecBuilder.build())
                .when()
                .post(path, pathParams)
                .then();
    }

    /**
     * Execute PUT Request
     *
     * @param requestSpecification RequestSpecification - holds rest assured information about request
     * @param path - path of endpoint such as foo/bar
     * @param pathParams path params, for example if path contains foo/{fooparam1}/bar/{barparam1}
     *      *                   then parameters will replaced in it
     * @return ValidatableResponse
     */
    public ValidatableResponse put(RequestSpecification requestSpecification, String path, Object... pathParams) {

        return given()
                .spec(requestSpecification)
                .when()
                .put(path, pathParams)
                .then();
    }
    /**
     * Execute DELETE
     *
     * @param requestSpecification RequestSpecification - holds rest assured information about request
     * @param path - path of endpoint such as foo/bar
     * @param pathParams path params, for example if path contains foo/{fooparam1}/bar/{barparam1}
     *      *                   then parameters will replaced in it
     * @return ValidatableResponse
     */
    public ValidatableResponse delete(RequestSpecification requestSpecification, String path, Object... pathParams) {

        return given()
                .spec(requestSpecification)
                .when()
                .delete(path, pathParams)
                .then();
    }

    /**
     * Execute DELETE with body
     *
     * @param requestSpecification RequestSpecification - holds rest assured information about request
     * @param path - path of endpoint such as foo/bar
     * @param bodyPayload payload object
     * @param pathParams path params, for example if path contains foo/{fooparam1}/bar/{barparam1}
     *      *                   then parameters will replaced in it
     * @return ValidatableResponse
     */
    public ValidatableResponse deleteByBody(RequestSpecification requestSpecification, String path, Object bodyPayload, Object... pathParams) {
        RequestSpecBuilder requestSpecBuilder = new RequestSpecBuilder();
        requestSpecBuilder.addRequestSpecification(requestSpecification);

        if (bodyPayload != null) {
            requestSpecBuilder.setBody(bodyPayload);
        }

        return given()
                .spec(requestSpecBuilder.build())
                .when()
                .delete(path, pathParams)
                .then();
    }

    /**
     * Execute HEAD request
     *
     * @param requestSpecification RequestSpecification - holds rest assured information about request
     * @param path - path of endpoint such as foo/bar
     * @param pathParams path params, for example if path contains foo/{fooparam1}/bar/{barparam1}
     *      *                   then parameters will replaced in it
     * @return ValidatableResponse
     */
    public ValidatableResponse head(RequestSpecification requestSpecification, String path, Object... pathParams) {

        return given()
                .when()
                .head(path, pathParams)
                .then();
    }

    /**
     * Execute PATCH request
     *
     * @param requestSpecification RequestSpecification - holds rest assured information about request
     * @param path - path of endpoint such as foo/bar
     * @param bodyPayload payload object
     * @param pathParams path params, for example if path contains foo/{fooparam1}/bar/{barparam1}
     *      *                   then parameters will replaced in it
     * @return ValidatableResponse
     */
    public ValidatableResponse patch(RequestSpecification requestSpecification, String path, Object bodyPayload, Object... pathParams) {

        return given()
                .when()
                .body(bodyPayload)
                .patch(path, pathParams)
                .then();
    }

    /**
     * Execute Request
     *
     * @param requestSpecification RequestSpecification - holds rest assured information about request
     * @param path - path of endpoint such as foo/bar
     * @param methodName - Method like POST,GET,PUT etc
     * @param statusCode expected status code
     * @param bodyPayload payload object
     * @param pathParams path params, for example if path contains foo/{fooparam1}/bar/{barparam1}
     *      *                   then parameters will replaced in it
     * @return ValidatableResponse
     */
    public ValidatableResponse makeRequest(RequestSpecification requestSpecification,String methodName,Object bodyPayload,String path,int statusCode,Object... pathParams)
    {
        RequestSpecBuilder requestSpecBuilder = new RequestSpecBuilder();
        requestSpecBuilder.addRequestSpecification(requestSpecification);

        if(bodyPayload!=null)
        {
            requestSpecBuilder.setBody(bodyPayload);
        }

        return given()
                .spec(requestSpecBuilder.build())
                .when()
                .request(methodName,path,pathParams)
                .then()
                .statusCode(statusCode);
    }



}
