package org.tasks.task3.models;

public class Test {
    private int id;
    private String title;
    private String value;
    private Test[] values;


    public void setValue(String value) {
        this.value = value;
    }


    public Test[] getTests(){
        return this.values;
    }

    public int getId() {
        return id;
    }

    public boolean valuesIsNull(){
        return this.values == null;
    }

    @Override
    public String toString() {
        return "Test{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", value='" + value + '\'' +
                '}';
    }
}

