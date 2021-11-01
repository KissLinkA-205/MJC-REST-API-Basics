package com.epam.esm.entity;

import java.util.Objects;

/**
 * Abstract class {@code Tag} represents tag entity.
 *
 * @author Anzhalika Dziarkach
 * @version 1.0
 */
public class Tag extends Identifiable {
    private String name;

    public Tag() {
    }

    public Tag(String name) {
        this.name = name;
    }

    public Tag(long id, String name) {
        super(id);
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Tag that = (Tag) o;
        return Objects.equals(name, that.name) && super.equals(that);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), name);
    }

    @Override
    public String toString() {
        final StringBuilder result = new StringBuilder("Tag{");
        result.append("id=").append(super.getId());
        result.append(", name='").append(name).append('\'');
        result.append('}');
        return result.toString();
    }
}
