package factoryRequest;

import io.restassured.response.Response;
import util.GetProperties;

import static io.restassured.RestAssured.given;

public class RequestGET implements IRequest{
    String emailAuthorization;
    public RequestGET(String emailAuth) {
        emailAuthorization=emailAuth;
    }

    @Override
    public Response send(RequestInfo info) {
        Response response =given()
                .auth()
                .preemptive()
                .basic(emailAuthorization,
                        GetProperties.getInstance().getPwd())
                .log().all()
        .when()
                .get(info.getUrl());
        response.then().log().all();
        return response;
    }


}
