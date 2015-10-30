package com.foo.bar.restful.foobarservice;

import javax.ws.rs.core.Application;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by emilkirschner on 16/10/15.
 */
public class FooBarApp extends Application {
    @Override
    public Set<Class<?>> getClasses() {
        return new HashSet<Class<?>>(Arrays.asList(
                FooBarService.class
        ));
    }
}
