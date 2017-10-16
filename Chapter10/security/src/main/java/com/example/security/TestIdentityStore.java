package com.example.security;

import javax.enterprise.context.ApplicationScoped;
import javax.security.enterprise.credential.UsernamePasswordCredential;
import javax.security.enterprise.identitystore.CredentialValidationResult;
import javax.security.enterprise.identitystore.IdentityStore;

import static java.util.Collections.singleton;

@ApplicationScoped
public class TestIdentityStore implements IdentityStore {

    public CredentialValidationResult validate(UsernamePasswordCredential usernamePasswordCredential) {

        // validate
        // ...
        if (usernamePasswordCredential.compareTo("duke", "helloWorld")) {
            return new CredentialValidationResult("duke", singleton("admin"));
        }

        return CredentialValidationResult.INVALID_RESULT;
    }

}
