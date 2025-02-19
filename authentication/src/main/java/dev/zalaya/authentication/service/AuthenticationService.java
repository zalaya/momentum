package dev.zalaya.authentication.service;

import dev.zalaya.authentication.port.outbound.UserRepository;

public class AuthenticationService {

    private final UserRepository userRepository;

    public AuthenticationService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

}
