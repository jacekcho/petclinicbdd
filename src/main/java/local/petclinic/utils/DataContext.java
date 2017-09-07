package local.petclinic.utils;

import local.petclinic.dictionary.TestDataKey;

import java.util.HashMap;
import java.util.Map;

public class DataContext {

    private static Map<TestDataKey, String> testData = new HashMap<>();

    public static void save(TestDataKey key, String value) {
        testData.put(key, value);
    }

    public static String getSavedData(TestDataKey key) {
        return testData.get(key);
    }

}