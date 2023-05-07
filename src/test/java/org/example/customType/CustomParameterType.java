package org.example.customType;

import io.cucumber.java.ParameterType;
import org.example.domainObject.Product;

public class CustomParameterType {
    @ParameterType(".*")
    public Product product(String name) {
        return new Product(name.replace("\"", ""));
    }
}
