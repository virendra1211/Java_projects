package org.ask.interview.coding;

import java.util.HashMap;
import java.util.Iterator;

/**
 * 
 * @author Virendra khade How to create Immutable class in Java 1. Declare the
 *         class is final so can't be extended 2. make all field private so that
 *         direct access is not allowed 3. don't provide setter methods for
 *         variable 4. Make all mutable fields Final so that it's value can be
 *         assigned only once. 5. Initialize all the field via constructor
 *         performing deep copy 6. perform cloning of object in the getter
 *         methods to return a copy rather than returning the actual object
 */
public class ImmutableClass {

}

final class MyFinalClass {

    private final Integer id;
    private final String name;
    private final HashMap<String, String> testMap;

    /**
     * Accessor function for mutable objects
     */
    public HashMap<String, String> getTestMap() {
	// return testMap;
	return (HashMap<String, String>) testMap.clone();
    }

    /**
     * Constructor performing Deep Copy
     * 
     * @param i
     * @param n
     * @param hm
     */

    public MyFinalClass(int i, String n, HashMap<String, String> hm) {
	System.out.println("Performing Deep Copy for Object initialization");
	this.id = i;
	this.name = n;
	HashMap<String, String> tempMap = new HashMap<String, String>();
	String key;
	Iterator<String> it = hm.keySet().iterator();
	while (it.hasNext()) {
	    key = it.next();
	    tempMap.put(key, hm.get(key));
	}
	this.testMap = tempMap;
    }
}
