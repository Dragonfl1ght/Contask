package org.tasks.task3;

import org.tasks.task3.models.Test;

import java.util.HashMap;

public class HashMapExtender {

    public static void extendData(HashMap<Integer, Test> testHashMap, Test[] to_add) {
        for (Test i : to_add) {
            if (!i.valuesIsNull())
                extendData(testHashMap, i.getTests());
            testHashMap.put(i.getId(), i);
        }
    }

    public static void goDeep(Test value, HashMap<Integer, Test> testHashMap) {
        testHashMap.put(value.getId(), value);
        if (!value.valuesIsNull()) {
            for (Test i : value.getTests()) {
                if (i.valuesIsNull()) {
                    testHashMap.put(i.getId(), i);
                    continue;
                }
                testHashMap.put(i.getId(), i);
                extendData(testHashMap, i.getTests());
            }

        }
    }
}
