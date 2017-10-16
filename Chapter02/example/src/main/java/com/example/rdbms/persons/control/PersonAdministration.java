package com.example.rdbms.persons.control;

import com.example.rdbms.persons.entity.Address;
import com.example.rdbms.persons.entity.Person;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
public class PersonAdministration {

    @PersistenceContext
    EntityManager entityManager;

    public void createPerson(Person person) {
        entityManager.persist(person);
    }

    public void updateAddress(long personId, Address newAddress) {
        Person person = entityManager.find(Person.class, personId);

        if (person == null)
            throw new IllegalArgumentException("Could not find person with ID " + personId);

        person.setAddress(newAddress);
    }

}
