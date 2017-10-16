package com.example.rdbms.cars.entity;

import javax.persistence.*;

@Entity
@Table(name = "engines")
public class Engine {

    @Id
    @GeneratedValue
    private long id;

    @Enumerated(EnumType.STRING)
    @Basic(optional = false)
    private EngineType type;

    private double ccm;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public EngineType getType() {
        return type;
    }

    public void setType(EngineType type) {
        this.type = type;
    }

    public double getCcm() {
        return ccm;
    }

    public void setCcm(double ccm) {
        this.ccm = ccm;
    }

}
