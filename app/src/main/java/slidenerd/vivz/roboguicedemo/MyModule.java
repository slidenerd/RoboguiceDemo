package slidenerd.vivz.roboguicedemo;

import com.google.inject.AbstractModule;

public class MyModule extends AbstractModule {
    @Override
    protected void configure() {
        bind(Shape.class).to(Square.class);
    }
    //a default constructor is fine for a Module
}