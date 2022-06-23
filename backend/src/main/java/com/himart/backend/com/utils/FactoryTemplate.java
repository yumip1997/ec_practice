package com.himart.backend.com.utils;

public interface FactoryTemplate<T>{

    <T> T getType();

}
