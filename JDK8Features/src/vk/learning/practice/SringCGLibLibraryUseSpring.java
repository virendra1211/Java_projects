package vk.learning.practice;

public class SringCGLibLibraryUseSpring {
	/*
	 * In a Spring Boot application, CGLIB (Code Generation Library) is often used
	 * behind the scenes by Spring for creating proxies—especially when using
	 * features like @Autowired, AOP, or @Transactional. Here's a breakdown of how
	 * CGLIB and autowiring relate and how you might explicitly or implicitly use
	 * CGLIB in a Spring Boot application.
	 * 
	 * Creating Proxies for Beans:
	 * 
	 * 1. Spring uses JDK dynamic proxies by default if the target implements an
	 * interface.
	 * 
	 * 2. If the bean doesn’t implement any interface, Spring will fall back to
	 * CGLIB to create a subclass-based proxy.
	 * 
	 * @Autowired and Proxying:
	 * 
	 * When you autowire a bean, and that bean is proxied (e.g., for AOP
	 * or @Transactional), Spring might use CGLIB to wrap it.
	 * 
	 * You don’t need to configure CGLIB manually—Spring Boot includes it via
	 * spring-core.
	 * 
	 * @Service public class MyService {
	 * 
	 * @Autowired private MyRepository repository;
	 * 
	 * @Transactional public void doSomething() { repository.save(...); // May
	 * trigger a CGLIB proxy if MyService has no interface } } In the above,
	 * MyService doesn't implement an interface. When Spring creates a proxy
	 * for @Transactional, it uses CGLIB to subclass MyService.
	 * 
	 * 🧠 Notes on Usage CGLIB requires the class not to be final, and methods being
	 * proxied must not be final either.
	 * 
	 * Spring Boot includes CGLIB transitively via spring-core, so you usually don’t
	 * need to include it manually.
	 * 
	 * 📦 Explicit CGLIB Dependency (Optional) Only add this if you need CGLIB
	 * directly (rare in Spring Boot):
	 * 
	 * xml Copy Edit <!-- In Maven (optional) --> <dependency>
	 * <groupId>cglib</groupId> <artifactId>cglib</artifactId>
	 * <version>3.3.0</version> </dependency> 🧹 Best Practices Prefer
	 * interface-based programming to avoid CGLIB unless subclass-based proxies are
	 * needed.
	 * 
	 * Avoid making beans or methods final if you expect Spring to proxy them.
	 * 
	 * ✅ Summary Feature CGLIB Usage
	 * 
	 * @Autowired Indirectly (if proxied)
	 * 
	 * @Transactional, @Async Yes (if no interface) Bean has no interface Yes (CGLIB
	 * subclass proxy) Bean or method is final ❌ CGLIB won't work
	 * 
	 * Let me know if you'd like to see a CGLIB proxy in action with a simple Spring
	 * Boot demo.
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 */
}
