package com.tunedapps.regestration.entities;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode
public abstract class EntityBase {

    private long id;
    private String name;
}
