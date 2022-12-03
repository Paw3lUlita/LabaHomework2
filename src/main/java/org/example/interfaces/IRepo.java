package org.example.interfaces;

import java.util.List;

public interface IRepo <T>{

    void save(T t);

    List<T> findAll();

    void delete(T t);

}
