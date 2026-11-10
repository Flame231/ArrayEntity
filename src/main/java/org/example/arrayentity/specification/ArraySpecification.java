package org.example.arrayentity.specification;

import org.example.arrayentity.entity.impl.IntArray;

@FunctionalInterface
public interface ArraySpecification {

    boolean matches(IntArray intArray);
}
