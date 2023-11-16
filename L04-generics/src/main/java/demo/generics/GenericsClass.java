package demo.generics;

import java.util.HashMap;
import java.util.Map;

@SuppressWarnings({"java:S106", "java:S1481", "java:S1854", "java:S1068"})
public class GenericsClass<K, V> {

    private final Map<K, V> map = new HashMap<>();
    private K superKey;

    public static void main(String[] args) {
        GenericsClass<Integer, String> genericsClass = new GenericsClass<>();
        genericsClass.putVal(1, "data1");
        genericsClass.putVal(2, "data2");
        genericsClass.putVal(3, "data3");

        GenericsClass<String, String> stringStringGenericsClass = new GenericsClass<>();

        genericsClass.print();
    }

    private void putVal(K key, V val) {
        map.put(key, val);
    }

    private void print() {
        map.forEach((key, val) -> System.out.println("key:" + key + " , val:" + val));
    }
}
