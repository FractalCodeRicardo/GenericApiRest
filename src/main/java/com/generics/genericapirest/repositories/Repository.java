package com.generics.genericapirest.repositories;

import org.springframework.data.repository.CrudRepository;
import com.generics.genericapirest.models.Model;

public interface Repository<T extends Model> extends CrudRepository<T , Long> {
    
}
