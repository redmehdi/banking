package com.base.service;

import java.util.List;

public interface IService<E, T> {

	List<T> getAll();

	boolean addOrUpdate(T t);

	boolean addAll(List<T> t);

	boolean remove(String idExt);

	T findById(String id);

}
