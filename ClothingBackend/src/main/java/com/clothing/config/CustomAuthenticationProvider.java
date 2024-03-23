package com.clothing.config;

import com.mysql.cj.conf.PropertySet;
import com.mysql.cj.exceptions.ExceptionInterceptor;
import com.mysql.cj.protocol.AuthenticationProvider;
import com.mysql.cj.protocol.Protocol;

public class CustomAuthenticationProvider implements AuthenticationProvider {
    @Override
    public void init(Protocol protocol, PropertySet propertySet, ExceptionInterceptor exceptionInterceptor) {

    }

    @Override
    public void connect(String s, String s1, String s2) {

    }

    @Override
    public void changeUser(String s, String s1, String s2) {

    }
}
