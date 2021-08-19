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

These methods can be override in a class that implements the interface or even extends by another interface, and you still can override them.
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

Optional help us with _NullPointerException_, making our code clearer and more readable. 
It doesn't replace the null value, but allow us to take smarter actions, working as a wrapper around our object, giving ways to validate wheather the object exists or not, or even get its value.
We have three methods to create an Optional: **_of_**, **_ofNullable_** and **_empty_**.

Other methods that we can use to work with Optional: 
* _get:_ retrieves the object involved by the optional. If the object doesn't exist, an error will occur
* _isPresent:_  checks wheather the object exists inside the optional. Usually this check occurs before a _get_ method.
* _ifPresent:_ performs some action if object exists.
* _filter:_ retrieves the object if the validation passed to the method returns true
* _map:_ when the object exists, apply the function that was given to the method and return its value wrapped in a new optional.
* _flatMap:_ does the same as the _map_ method, but can be used when we have complex objects
* _orElse:_ if the object exists, return it, or returns the value used as a parameter in the method
* _orElseGet:_ if the object exists, return it, or return a new object, created by the constructor passed as a parameter to the method
* _orElseThrow:_ if the object exists, return it, or throws the exception passed as a parameter to the method

# Date API

A new API for working with date and other time representations.
This new API was based on the famous Joda Time library, and built with three main ideas: immutable classes, domain segregation and support to different chronologies.

_LocalDate_, _LocalTime_ and _LocalDateTime_ are the main representations of this new API. Respectively, represents date, time and datetime values. 

If we need to support time zones, _ZonedDateTime_ might be an option, where different _ZoneId_ represents different time zones around the world. With the almost same ideia, the _OffsetDateTime_ class can represent diferent time zones, but it works with _ZoneOffset_.

_Instant_, _Period_ and _Durantion_ are other classes that can represent time in diferent ways. Basically, the name clearly indicates what each represents, that is, an instant (some) in time, a period in time, or the duration between times.

Also, this API has new ways to compare or even format a date, working in a much easier way.

# Functional Interface

_Fucntional Interface_ is an interface with a single abstract method. All classes that meet this rule are a functional interface, no matter if they are introduced in this version or exist in earlier versions. 

It's not mandatory, but you can represent a functional interface by placing the **@FunctionalInterface** annotation in its declaration. In this case, if the interface does not follow the rules of this type, an exception will be throw at compile time.

These interfaces are the heart of functional programming in Java.

# Lambda

Lambda are anonymous methods that implement some interface, more exactly functional interfaces. This feature has similarities with Anonymous Class concepts, but implementing it in a better and optimized way.
The lambda function can receive 1 or n parameters, as long as it respects the signature defined in the interface.

Another Java 8 feature that goes hand in hand with Lambda is the _Method Reference_, which can be used in almost every case when using lambda, and after the compilation, generates almost the same code.

# Stream and Parallel Streams

Stream can be defined as a wrapper to collections and arrays. But it can be more than that. 
With stream, we have a lot of power to manipulate, classify or even transform collections.

It could be created from a collection, array or passing the elements straight to the of method.
With stream, we can execute operations, that can be classified into two categories: intermediate or final. The main difference between them is that after a final operation, the stream can't be used again. The combination of multiple intermediate operations and one final operation is called Pipeline.

The Stream class runs all the process on a single thread. If we want to run the same process multithreaded, we need to use ParallelStreams. The functionality is similar in the two classes, but stateful operations like sorted e distinct can be different and result in different executions.