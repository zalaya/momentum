package dev.zalaya.authentication.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UserTest {

    private final String username = "username";
    private final String email = "email";
    private final String password = "password";

    @Test
    void shouldReturnCorrectValuesForUserAttributes() {
        // Arrange
        User user = new User(username, email, password);

        // Assert
        assertAll(
            () -> assertEquals(username, user.getUsername()),
            () -> assertEquals(email, user.getEmail()),
            () -> assertEquals(password, user.getPassword())
        );
    }

    @Test
    void shouldInitializeIsVerifiedAsFalse() {
        // Arrange
        User user = new User(
            username,
            email,
            password
        );

        // Assert
        assertFalse(user.isVerified());
    }

}
