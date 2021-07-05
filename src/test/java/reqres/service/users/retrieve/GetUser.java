package reqres.service.users.retrieve;

import com.karki.reqres.retry.Retry;
import com.karki.reqres.service.ReqApi;
import io.restassured.response.ValidatableResponse;
import org.testng.Assert;
import org.testng.annotations.Test;

public class GetUser {

    @Test(testName = "T1",
            groups = {"bvt", "regression"},
            description = "Verify the single users.")
    public void testGetUsers() {
        ReqApi reqApi = new ReqApi();
        ValidatableResponse validatableResponse = reqApi
                .getUsers()
                .retrieveUser("2", 200);

        String s = validatableResponse.extract().body().jsonPath().get("data.email");
        System.out.println(s);
    }

    @Test(
            testName = "T2",
            groups = {"regression"},
            description = "Verify the list of users."
    )
    public void testGetUsers2() {
        ReqApi reqApi = new ReqApi();
        ValidatableResponse validatableResponse = reqApi
                .getUsers()
                .retrieveUser("2", 200);

        String s = validatableResponse.extract().body().jsonPath().get("data.email");
        System.out.println(s);
    }

    @Test(
            testName = "T3",
            groups = {"test", "regression"},
            description = "Verify the list of users.",
            retryAnalyzer = Retry.class
    )
    public void testGetUsers3() {
        ReqApi reqApi = new ReqApi();
        ValidatableResponse validatableResponse = reqApi
                .getUsers()
                .retrieveUser("2", 200);

        String s = validatableResponse.extract().body().jsonPath().get("data.email");
        Assert.assertFalse(true);
        System.out.println(s);
    }

    @Test(
            testName = "T5",
            groups = {"test", "regression"},
            description = "Verify the list of users."
    )
    public void testGetUsers5() {
        ReqApi reqApi = new ReqApi();
        ValidatableResponse validatableResponse = reqApi
                .getUsers()
                .retrieveUser("2", 200);

        String s = validatableResponse.extract().body().jsonPath().get("data.email");
        Assert.assertFalse(false);
        System.out.println(s);
    }


}
