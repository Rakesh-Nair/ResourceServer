package com.appsdeveloperblog.ws.api.ResourceServer.response;

public class UserRest {
    private String userFirstName;
    private String userLastName;
    private String userId;

    public UserRest(String userFirstName, String userLastName, String userId) {
        this.userFirstName = userFirstName;
        this.userLastName = userLastName;
        this.userId = userId;
    }

    public String getUserFirstName() {
        return userFirstName;
    }

    public String getUserLastName() {
        return userLastName;
    }

    public String getUserId() {
        return userId;
    }
}
