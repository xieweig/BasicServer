package org.grow.core.domain;

public interface Morphling<H> {

    String toJsonString();

    H getInstanceFromJsonString(String jsonString);
}
