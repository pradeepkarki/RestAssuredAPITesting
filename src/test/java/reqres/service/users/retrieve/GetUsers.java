package reqres.service.users.retrieve;

import com.karki.reqres.service.ReqApi;
import io.restassured.response.ValidatableResponse;
import org.testng.annotations.Test;

public class GetUsers {

    @Test(testName = "T1",
            description = "Verify the list of users.")
    public void testGetUsers() {
        ReqApi reqApi = new ReqApi();
        ValidatableResponse validatableResponse = reqApi.getUsers().retrieveUser("2", 200);

        String s = validatableResponse.extract().body().jsonPath().get("data.email");
        System.out.println(s);
    }


}
