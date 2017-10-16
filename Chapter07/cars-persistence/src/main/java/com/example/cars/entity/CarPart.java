package com.example.cars.entity;

import javax.persistence.*;

import static javax.persistence.EnumType.STRING;

@Entity
@Table(name = "car_parts")
public class CarPart {

    @Id
    @GeneratedValue
    private long id;

    @Basic(optional = false)
    // without this annotation our test example will fail
    @Column(name = "part_order")
    private String order;

    @Enumerated(STRING)
    @Basic(optional = false)
    private PartType type;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getOrder() {
        return order;
    }

    public void setOrder(String order) {
        this.order = order;
    }

    public PartType getType() {
        return type;
    }

    public void setType(PartType type) {
        this.type = type;
    }
}
