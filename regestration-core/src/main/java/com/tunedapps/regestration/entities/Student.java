package com.tunedapps.regestration.entities;

import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import javax.xml.bind.annotation.XmlRootElement;
import java.time.LocalDate;
import java.util.List;

@Data
@Builder
@EqualsAndHashCode(callSuper = true)
@ToString
@XmlRootElement
public class Student extends EntityBase {

    private Gender gender;
    private LocalDate bod;
    private List<Course> courses;
    private Location location;
}
