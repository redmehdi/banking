package com.service.entities;

import com.base.service.IService;

public interface CustomerService<E, T> extends IService<E, T> {

	T findByLastName(final String email);

	T findByFirstLastName(final String firstName, final String lastName);

}
