package util;

public class ApiConfiguration {


    public static final String CREATE_USER=GetProperties.getInstance().getHost()+"/api/user.json";
    public static final String UPDATE_USER =GetProperties.getInstance().getHost()+"/api/user/%s.json";
    public static final String READ_USER=GetProperties.getInstance().getHost()+"/api/user.json";
    public static final String DELETE_USER=GetProperties.getInstance().getHost()+"/api/user/%s.json";


}
