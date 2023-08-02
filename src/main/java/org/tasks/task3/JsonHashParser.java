package org.tasks.task3;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import org.tasks.task3.models.Test;
import org.tasks.task3.models.Value;


import java.util.HashMap;

import static org.tasks.task3.HashMapExtender.goDeep;


public class JsonHashParser {
    private final HashMap<Integer, Test> hashTests;
    private final Value[] values;
    private final Test[] tests;
    public JsonHashParser(String test_file, String values_file) {

        this.tests = ParseTestFile(test_file);
        this.values = ParseValueFile(values_file);
        this.hashTests = getInlineHashMap(this.tests);
    }

    public static HashMap<Integer, Test> getInlineHashMap(Test[] tests) {
        HashMap<Integer, Test> testHashMap= new HashMap<>();
        for (Test i : tests)
            goDeep(i, testHashMap);
        return testHashMap;
    }


    public static Test[] ParseTestFile(String test_file) {
        GsonBuilder builder = new GsonBuilder();
        Gson gson = builder.create();
        JsonObject object = gson.fromJson(test_file, JsonObject.class);
        JsonElement answer = object.get("tests");
        return gson.fromJson(answer, Test[].class);
    }

    public static Value[] ParseValueFile(String value_file) {
        GsonBuilder builder = new GsonBuilder();
        Gson gson = builder.create();
        JsonObject object = gson.fromJson(value_file, JsonObject.class);
        JsonElement answer = object.get("values");
        return gson.fromJson(answer, Value[].class);
    }


    public void setValues() {
        for (Value value: this.values) {
            Test object = this.hashTests.get(value.getId());
            object.setValue(value.getValue());
        }
    }

    public String getJsonResponse(){
        GsonBuilder builder = new GsonBuilder().setPrettyPrinting();
        Gson gson = builder.create();
        return gson.toJson(this.tests, Test[].class);
    }

}
