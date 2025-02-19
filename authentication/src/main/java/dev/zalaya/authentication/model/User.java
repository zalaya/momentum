package dev.zalaya.authentication.model;

import lombok.Getter;
import lombok.Setter;

@Getter
public class User {

    private final String username;
    private final String email;
    private final String password;

    @Setter
    private boolean isVerified;

    public User(String username, String email, String password) {
        this.username = username;
        this.email = email;
        this.password = password;
        this.isVerified = false;
    }

}
