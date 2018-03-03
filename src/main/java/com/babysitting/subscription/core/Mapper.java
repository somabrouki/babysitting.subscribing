package com.babysitting.subscription.core;

public interface Mapper<T, T1> {

    T mapDtoToEntity(T1 t1);

    T1 mapEntityToDto(T t);
}
