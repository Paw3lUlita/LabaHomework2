package org.example.interfaces;

import org.example.exception.NoSuchRentDataFoundException;

import java.util.List;

public interface IRepo <T>{

    void add(T t);

    List<T> findAll();

    void delete(T t) throws Exception;

}
