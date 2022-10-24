package testClean;

import factoryRequest.FactoryRequest;
import factoryRequest.RequestInfo;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.junit.jupiter.api.Test;
import util.ApiConfiguration;

import static org.hamcrest.Matchers.equalTo;

public class UserCRUDTest {

    Response response;
    JSONObject body = new JSONObject();
    RequestInfo requestInfo = new RequestInfo();

    JSONObject newbody = new JSONObject();
    RequestInfo newrequestInfo = new RequestInfo();


    @Test
    public void verifyCRUDUser() {

        body.put("FullName", "juan lara");
        body.put("Email", "juanlara1234@gmail.com");
        body.put("Password", "1234567");

        /* CREATE USER */
        requestInfo.setUrl(ApiConfiguration.CREATE_USER);
        requestInfo.setBody(body.toString());
        response = FactoryRequest.make("post", body.get("Email").toString()).send(requestInfo);
        response.then().body("Email", equalTo(body.get("Email"))).statusCode(200);
        int idUser=response.then().extract().path("Id");

        /* READ USER */
        requestInfo.setUrl(String.format(ApiConfiguration.READ_USER,idUser));
        requestInfo.setBody(body.toString());
        response = FactoryRequest.make("get",body.get("Email").toString()).send(requestInfo);
        response.then().body("Email", equalTo(body.get("Email"))).statusCode(200);

        /* UPDATE USER */
        String newEmail =  "demo123@gmail.com";
        newbody.put("Email", newEmail);
        newrequestInfo.setUrl(String.format(ApiConfiguration.UPDATE_USER,idUser));
        newrequestInfo.setBody(newbody.toString());
        response = FactoryRequest.make("post",body.get("Email").toString()).send(newrequestInfo);
        response.then().body("Email", equalTo(newbody.get("Email"))).statusCode(200);

        /* DELETE USER */
        requestInfo.setUrl(String.format(ApiConfiguration.DELETE_USER,idUser));
        response = FactoryRequest.make("delete", newbody.get("Email").toString()).send(requestInfo);
        response.then().body("Email", equalTo(newEmail)).statusCode(200);

    }
}