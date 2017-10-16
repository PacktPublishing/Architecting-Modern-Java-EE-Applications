package com.example.jsonb;

import javax.inject.Inject;
import javax.json.bind.adapter.JsonbAdapter;

public class OrganizationTypeAdapter implements JsonbAdapter<Organization, String> {

    @Inject
    OrganizationStore organizationStore;

    @Override
    public String adaptToJson(Organization organization) {
        return String.valueOf(organization.getId());
    }

    @Override
    public Organization adaptFromJson(String string) {
        long id = Long.parseLong(string);
        Organization organization = organizationStore.getOrganization(id);

        if (organization == null)
            throw new IllegalArgumentException("Could not find organization for ID " + string);

        return organization;
    }

}
