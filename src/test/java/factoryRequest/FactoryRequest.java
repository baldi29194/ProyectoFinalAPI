package factoryRequest;

public class FactoryRequest {

    public static IRequest make (String requestType, String emailAuth){
        IRequest request;

        switch (requestType.toLowerCase()){
            case "post":
                request = new RequestPOST(emailAuth);
                break;
            case "put":
                request = new RequestPUT(emailAuth);
                break;
            case "delete":
                request= new RequestDELETE(emailAuth);
                break;
            default:
                request= new RequestGET(emailAuth);
                break;
        }
       return request;
    }

}
