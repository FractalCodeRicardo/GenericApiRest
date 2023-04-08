package com.generics.genericapirest.controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.generics.genericapirest.services.Service;
import com.generics.genericapirest.models.Model;

public class Controller<T extends Model> {

	@Autowired
	private Service<T> service;

	@RequestMapping(method = RequestMethod.GET)
	public List<T> list() {
		return service.findAll();
	}

	@RequestMapping(method = RequestMethod.POST)
	public T create(@RequestBody T entity) {
		return service.save(entity);
	}

	@RequestMapping(value = "{id}", method = RequestMethod.PUT)
	public T update(@PathVariable(value = "id") long id, @RequestBody T entity) {
		entity.setId(id);
		return service.save(entity);
	}

	@RequestMapping(value = "{id}", method = RequestMethod.DELETE)
	public void delete(@PathVariable(value = "id") long id) {
		service.delete(id);
	}

	@RequestMapping(value = "{id}", method = RequestMethod.GET)
	public T get(@PathVariable(value = "id") long id) {
		Optional<T> entity = service.get(id);

		if (!entity.isPresent()) {
			throw new ResponseStatusException(
				HttpStatus.NO_CONTENT, "entity not found"
				);
		}

		return entity.get();
	}
}
