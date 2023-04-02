package com.generics.genericapirest.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.generics.genericapirest.models.Foo;

@RestController
@RequestMapping("/foo")
public class FooController extends Controller<Foo>{
    
}
