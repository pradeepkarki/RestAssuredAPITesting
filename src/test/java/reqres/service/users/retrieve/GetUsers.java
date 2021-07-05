package reqres.service.users.retrieve;

import com.google.common.collect.ImmutableMap;
import com.karki.reqres.retry.Retry;
import com.karki.reqres.service.ReqApi;
import io.restassured.response.ValidatableResponse;
import jdk.nashorn.internal.ir.annotations.Immutable;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Map;

public class GetUsers {

    @Test(testName = "T11",
            groups = {"bvt", "regression"},
            description = "Verify the list of users.")
    public void testGetUsers() {

        Map<String,Integer> queryParams= ImmutableMap.of("page",3);
        ReqApi reqApi = new ReqApi();
        ValidatableResponse validatableResponse = reqApi
                .getUsers()
                .retrieveAllUsers(queryParams, 200);

        String s = validatableResponse.extract().body().asString();
        System.out.println(s);
    }




}
