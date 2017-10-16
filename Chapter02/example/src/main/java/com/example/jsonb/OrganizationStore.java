package com.example.jsonb;

public class OrganizationStore {

    public Organization getOrganization(long id) {
        Organization organization = new Organization();
        organization.setId(id);
        return organization;
    }

}
