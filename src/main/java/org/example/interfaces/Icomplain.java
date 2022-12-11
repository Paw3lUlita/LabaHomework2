package org.example.interfaces;

import org.example.entity.Complain;
import org.example.exception.EmptyMessageComplainException;

public interface Icomplain {

    void sendComplain(Complain complain) throws EmptyMessageComplainException;
}
