package com.example.security;

import javax.security.enterprise.authentication.mechanism.http.BasicAuthenticationMechanismDefinition;
import javax.security.enterprise.identitystore.DatabaseIdentityStoreDefinition;
import javax.security.enterprise.identitystore.IdentityStore;

@BasicAuthenticationMechanismDefinition(realmName = "car-realm")
@DatabaseIdentityStoreDefinition(
        dataSourceLookup = "java:comp/UserDS",
        callerQuery = "select password from users where name = ?",
        useFor = IdentityStore.ValidationType.VALIDATE
)
public class SecurityConfig {

    // nothing to configure

}
