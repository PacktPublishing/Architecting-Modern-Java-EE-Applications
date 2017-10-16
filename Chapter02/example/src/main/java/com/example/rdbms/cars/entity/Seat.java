package com.example.rdbms.cars.entity;

import javax.persistence.*;

@Entity
@Table(name = "seats")
public class Seat {

    @Id
    @GeneratedValue
    private long id;

    @Basic(optional = false)
    @Enumerated(EnumType.STRING)
    private SeatMaterial material;

    @Basic(optional = false)
    @Enumerated(EnumType.STRING)
    private SeatShape shape;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public SeatMaterial getMaterial() {
        return material;
    }

    public void setMaterial(SeatMaterial material) {
        this.material = material;
    }

    public SeatShape getShape() {
        return shape;
    }

    public void setShape(SeatShape shape) {
        this.shape = shape;
    }

}
