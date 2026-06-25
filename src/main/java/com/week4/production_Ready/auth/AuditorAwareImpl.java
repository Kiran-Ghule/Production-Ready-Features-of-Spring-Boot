package com.week4.production_Ready.auth;

import org.springframework.data.domain.AuditorAware;

import java.util.Optional;

public class AuditorAwareImpl implements AuditorAware<String> {

    @Override
    public Optional<String> getCurrentAuditor() {
        // Get Security context
        // get Authentication
        // get principal
        // get username
        return Optional.of("The K");
    }
}
