package org.tasks.task3.models;

public class Value {
    private int id;
    private String value;

    public String getValue() {
        return this.value;
    }

    public int getId() {
        return this.id;
    }

    @Override
    public String toString() {
        return "Value{" +
                "id=" + id +
                ", value='" + value + '\'' +
                '}';
    }
}
