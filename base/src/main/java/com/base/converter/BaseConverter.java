package com.base.converter;

import java.util.ArrayList;
import java.util.List;

public abstract class BaseConverter<E, T> /**implements IConverter<E, T> */{
	

	public abstract T getDto(E e);

	public abstract E getEntity(T t);
	
	public List<T> getDtos(Iterable<E> entities) {
		if (entities ==null) 
			return null;
		List<T> dtos = new ArrayList<>();
		entities.forEach(entity -> dtos.add(getDto(entity)));
		return dtos;
	}

	public List<E> getEntities(List<T> dtos) {
		List<E> entities = new ArrayList<>();
		dtos.forEach(dto -> entities.add(getEntity(dto)));
		return entities;
	}

}
