package com.generics.genericapirest.repositories;

import org.springframework.context.annotation.Primary;

import com.generics.genericapirest.models.Foo;

@Primary
public interface FooRepo extends Repository<Foo> {
    
}
