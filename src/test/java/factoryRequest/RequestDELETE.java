package factoryRequest;

import io.restassured.response.Response;
import util.GetProperties;

import static io.restassured.RestAssured.given;

public class RequestDELETE implements IRequest{

    String emailAuthorization;
    public RequestDELETE(String emailAuth) {
        emailAuthorization= emailAuth;
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
                .delete(info.getUrl());
        response.then().log().all();
        return response;
    }


    }

