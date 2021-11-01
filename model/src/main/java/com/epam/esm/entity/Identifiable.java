package com.epam.esm.entity;

import java.util.Objects;

/**
 * Abstract class {@code Identifiable} represents to identify objects.
 *
 * @author Anzhalika Dziarkach
 * @version 1.0
 */
public abstract class Identifiable {
    private long id;

    Identifiable() {
    }

    Identifiable(long id) {
        this.id = id;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Identifiable that = (Identifiable) o;
        return id == that.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
