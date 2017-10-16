package com.example.jaxrs.control;

import com.example.jaxrs.entity.ValidUser;

import javax.json.JsonObject;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class ValidUserValidator implements ConstraintValidator<ValidUser, JsonObject> {

    public void initialize(ValidUser constraint) {
        // nothing to do
    }

    public boolean isValid(JsonObject json, ConstraintValidatorContext context) {
        // ...
        return json.getString("name", null) != null;
    }

}
