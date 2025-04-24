package basic.topic.interview;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

public class MCTest {
    public static void main(String[] args) {
	ConcurrentMap<String, String> cp = new ConcurrentHashMap<String, String>() {
	    @Override
	    public String put(String key, String value) {
		return super.put(null, null);
	    }
	};
	cp.put(null, null);
	cp.put("a", null);

    }

}
