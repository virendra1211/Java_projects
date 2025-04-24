package vk.java8.features;

import java.util.HashMap;
import java.util.Map;

public class MapComputeIfPresent {
    public static void main(String[] args) {
	Map<String, Integer> map = new HashMap<>() {
	    @Override
	    public Integer put(String key, Integer value) {
		return super.putIfAbsent(key, value);
	    }
	};
	map.put("Pune", 1000);
	map.put("Indore", 4000);
	map.put("Dewas", 3000);
	map.put("Ujjain", 2000);
	map.put("Dewas", 30200);
	map.computeIfPresent("Ujjain", (key, value) -> value + 100);
	System.out.println(map.putIfAbsent("jay", 1));
	System.out.println(map.putIfAbsent("jay", 11));

	System.out.println(map);

    }
}
