package com.tunedapps.regestration.repository;

public class StudentsIdGenerator implements IdGenerator<Long>{

    private static long counter = 1;

    @Override
    public Long generateNewId() {
        return counter++;
    }
}
