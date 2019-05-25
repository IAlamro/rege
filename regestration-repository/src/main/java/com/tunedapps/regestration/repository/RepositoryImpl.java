package com.tunedapps.regestration.repository;

import com.tunedapps.regestration.entities.EntityBase;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class RepositoryImpl<T, R extends EntityBase> implements Repository<T, R>{

    private Map<T, R> map = new HashMap<>();

    private IdGenerator<T> idGenerator;

    public RepositoryImpl(IdGenerator<T> idGenerator) {
        this.idGenerator = idGenerator;
    }

    @Override
    public R findById(T id) {
        return map.get(id);
    }

    @Override
    public List<R> findAll() {
        return new LinkedList<>(map.values());
    }

    @Override
    public void delete(T id) {
        map.remove(id);
    }

    @Override
    public R update(T id, R student) {
        map.put(id, student);
        return student;
    }

    @Override
    public T create(R student) {
        T id = idGenerator.generateNewId();
        map.put(id, student);
        return id;
    }

    @Override
    public void setIdGenerator(IdGenerator<T> idGenerator) {
        this.idGenerator = idGenerator;
    }


}
