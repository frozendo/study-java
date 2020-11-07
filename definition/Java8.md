# Java 8

**Release Date:** 18/03/2014

## Default Methods

Default Methods are interface methods that have implementation and allows you to define functionality in the interface. 
With these methods, when implementing the interface in a class, we don't need to define them again, so we can use the interface's implementation.

To create a default method in an interface, we need to use the keyword **_default_** in method signature. 
Like other interface's methods types, default methods are implicitly public.

```
public interface SomeInterface {
  default String printByDefaultMethod() {
    return "Default method example";
  }
}
```

These methods can be override in a class implements the interface or even extends by another interface, and you still can override them.
They are very useful to extends class functionality, or add new methods without break exist code.

## Static Methods

In interfaces, static methods works exactly equal a static method in a class: the method is in the Interface scope. 
So, to call one interface static method, we need to do _SomeInterface.staticMethod()_.

Like class static method, we need to use keyword **_static_** to define this kind of method in an interface, and they body can't be empty. As the default methods, they're implicitly public.

```
public interface SomeInterface {
  static void printByStaticMethods() {
    System.out.println("Run Interface Static Methods");
  }
}
``` 

# Optional

Optional help us with _NullPointerException_, make our code clearer and more readable. 
It doesn't replace the null value, but allow us to take smarter actions, working like a wrapper around our object, given forms to validate if the object exists or not, or even get its value.
We have three methods to create an Optional: **_of_**, **_ofNullable_** and **_empty_**.

Other methods that we can use to work with Optional: 
* get
* isPresent
* ifPresent
* filter
* map
* flatMap
* orElse
* orElseGet
* orElseThrow