package com.example.demoexcam.jpa.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@MappedSuperclass
@Access(AccessType.FIELD)
public abstract class AbstractBaseEntity {
    private static final int START_SEQ = 1000;

    @Id
    @Setter
    @Getter
    @SequenceGenerator(name = "global_seq", initialValue = START_SEQ, allocationSize = 1, sequenceName = "global_seq")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "global_seq")
    private Integer ID;

    public AbstractBaseEntity() {
    }
}
