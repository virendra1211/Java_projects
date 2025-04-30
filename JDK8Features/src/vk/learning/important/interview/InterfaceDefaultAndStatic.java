package vk.learning.important.interview;

import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Stream;

/*
 Qus >> Why default and static method has introduced 
 Earlier we dont' have this concept but when you are upgrading a system then we don't want to give any implementation of new method, if
 we define abstract then we must overriden the method.Like we are using with Stream aPI and List we have sort & replace as a default method.
 
 In java we don't have a concept of multiple inheritance it create a diamond problem
 suppose we have one class AA implements interface I and J and they are having same abstract method then
 we are implementing in our class itself but what happened if one of the interface want to provide implementation then
 - if both the interface have same default method then again we are facing the issue at compile time,  by overriding in sub clas it will solve.
 - if one of the class like D have one method implementation and we are extending that class, so here extended class and interface(default method) have the 
 same method then in the case class given more power and execute "class method" 
 - 
 
 
 */
public class InterfaceDefaultAndStatic {
	public static void main(String[] args) {
		I obj = new AA();
		obj.show();
		Stream.of(10, 11, 15, 20, 22, 321, 121).filter(x -> x > 20).forEach(System.out::println);

		// create, transform, collect

		Stream.of("a", "b", "c").map(String::toUpperCase).forEach(System.out::println);

		Integer s = Stream.of(1, 2, 3, 1).reduce(0, (x, y) -> (x + y));
		System.out.println("---- " + s);
	}

	public static <T> Predicate<T> distinctByKey(Function<? super T, ?> keyExtractor) {
		Set<Object> seen = ConcurrentHashMap.newKeySet();
		return t -> seen.add(keyExtractor.apply(t));
	}
}

interface J {
	public static final int c = 500;

	/*
	 * below method given and issue as it's already definedin the Object class
	 * default boolean equals(Object o) { return true; }
	 */
	void add();

	static void myway() {
		System.out.println("static ");
	}
}

class D {
	public void show() {
		System.out.println("class D");
	}
}

interface I {
	public static final int c = 500;

	void add();

	default public void show() {
		System.out.println("c-- " + (c * 2));
	}
}

class AA extends D implements I, J {

	@Override
	public void add() {
		System.out.println("We are using ");
	}
	/*
	 * public void show() { System.out.println("c-- " + (I.c * 2)); }
	 */
}
