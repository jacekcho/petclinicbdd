package local.petclinic.utils;

import local.petclinic.dictionary.TestDataKey;

import java.util.HashMap;
import java.util.Map;

public class TestData {

    private static Map<TestDataKey, String> testData = new HashMap<>();

    public static void set(TestDataKey key, String value) {
        testData.put(key, value);
    }

    public static String get(TestDataKey key) {
        return testData.get(key);
    }

}