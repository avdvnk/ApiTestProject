package services;

import core.ServiceBuilder;
import helpers.ConfigHelper;
import models.ListUsersResTO;
import models.UserResTO;

public class ReqresService {

    private final String uri;

    public ReqresService() {
        this.uri = ConfigHelper.getBaseUri();
    }

    public ReqresService(String uri) {
        this.uri = uri;
    }

    public UserResTO postCreateUser(Object body, int expectedCode) {
        return new ServiceBuilder(uri)
                .addBody(body)
                .buildService()
                .postObject("/api/users", UserResTO.class, expectedCode);
    }

    public UserResTO putUpdateUser(int userId, Object body, int expectedCode) {
        return new ServiceBuilder(uri)
                .addPathParam("userId", userId)
                .addBody(body)
                .buildService()
                .putObject("/api/users/{userId}", UserResTO.class, expectedCode);
    }

    public void deleteUser(int userId, int expectedCode) {
        new ServiceBuilder(uri)
                .addPathParam("userId", userId)
                .buildService()
                .deleteResponse("/api/users/{userId}", expectedCode);
    }

    public ListUsersResTO getListUsers(int page, int expectedCode) {
        return new ServiceBuilder(uri)
                .addQueryParam("page", page)
                .buildService()
                .getObject("/api/users", ListUsersResTO.class, expectedCode);
    }
}
