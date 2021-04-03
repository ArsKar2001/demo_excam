package com.example.demoexcam.jpa.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Entity
@Table(name = "manufacturer")
public class Manufacturer extends AbstractBaseEntity {
    @Column(name = "name")
    @NotNull
    private String name;
    @Column(name = "start_date", nullable = false)
    private LocalDate startDate;

    @Override
    public String toString() {
        return "Manufacturer{" +
                "name='" + name + '\'' +
                ", startDate=" + startDate +
                '}';
    }
}
