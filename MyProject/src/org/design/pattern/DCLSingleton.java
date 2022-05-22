package org.design.pattern;

/**
 * @author Virendra khade
 * 
 *         1) A static volatile field is used to hold the instance of the
 *         Singelton class. The volatile variable is key here, without volatile,
 *         it won't be thread-safe because volatile provides the happens-before
 *         guarantee and when a volatile read is happening the memory barrier is
 *         refreshed as explained in Java Concurrency in Practice as well.
 * 
 *         2) The constructor is made private to disable instance creation
 *         outside of this class, but you can create an instance inside the
 *         class and that's what your getInstance() method does.
 * 
 *         3) There are two checks to see if the _instance member variable is
 *         initialized or not and that's why this code idiom it's called a
 *         double-checked locking idiom.
 * 
 *         4) The first check is non-synchronized, which may see a partially
 *         constructed object because of instruction re-ordering by the compiler
 *         or JVM.
 * 
 *         5) The second check is inside the synchronized block and only
 *         executes one time during the lifespan of Singleton. That's why you
 *         get the performance boost becuase locking only happens one time
 *         during the lifespan of the Singleton instance.
 * 
 *         Read more:
 *         https://www.java67.com/2016/04/why-double-checked-locking-was-broken-before-java5.html#ixzz7EXwL7C00
 
 *  ********** happens-before guarantee provided by the volatile variable  ********************
 https://www.java67.com/2016/04/why-double-checked-locking-was-broken-before-java5.html
 */
class DCLSingleton {

    private static volatile DCLSingleton _instance  = null;

    private DCLSingleton() {
    }

    public static DCLSingleton instance() {
        if (_instance == null) { // 1st check

            synchronized (DCLSingleton.class) {

                if (_instance == null) // 2nd check
                {
                    _instance = new DCLSingleton();
                }
            }
        }
        return _instance;
    }
}


//Read more: https://www.java67.com/2016/04/why-double-checked-locking-was-broken-before-java5.html#ixzz7EXvtTtg4