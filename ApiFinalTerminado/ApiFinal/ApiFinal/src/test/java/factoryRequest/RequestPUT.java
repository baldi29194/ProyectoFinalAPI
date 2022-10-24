package factoryRequest;

import io.restassured.response.Response;
import util.GetProperties;

import static io.restassured.RestAssured.given;

public class RequestPUT implements IRequest{
    String emailAuthorization;
    public RequestPUT(String emailAuth) {
        emailAuthorization = emailAuth;
    }

    @Override
    public Response send(RequestInfo info) {
        Response response =given()
                .auth()
                .preemptive()
                .basic(emailAuthorization,
                        GetProperties.getInstance().getPwd())
                .body(info.getBody())
                .log().all()
        .when()
                .put(info.getUrl());

        response.then().log().all();
        return response;
    }

}
