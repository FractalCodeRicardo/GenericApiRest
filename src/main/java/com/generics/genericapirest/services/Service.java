package com.generics.genericapirest.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.generics.genericapirest.repositories.Repository;
import com.generics.genericapirest.models.Model;

@Component
public class Service<T extends Model> {
    
    @Autowired
    Repository<T> repo;

    public T save(T entity) {
        return repo.save(entity);
    }

    public List<T> findAll() {
        var entities = repo.findAll();
        var list = new ArrayList<T>();
        entities.iterator().forEachRemaining(list::add);
        
        return list;
    }

    public void delete(long id) {
        repo.deleteById(id);
    }
}
