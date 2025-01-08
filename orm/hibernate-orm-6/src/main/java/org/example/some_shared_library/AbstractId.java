package org.example.some_shared_library;

import jakarta.persistence.MappedSuperclass;

@MappedSuperclass
public class AbstractId {

    private String id;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
