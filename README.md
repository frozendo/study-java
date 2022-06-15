# Java 8

**Release Date:** 18/03/2014

**LTS version**

## Default Methods

Default Methods are interface methods that have a body and allow you to implement functionality in the interface.
With these methods, when a class implements the interface, we don't need to define them again, so we can use the interface's implementation.

To have some examples of _Default Method_ see [DefaultMethodExamples.java](https://github.com/frozendo/study-java/blob/java-8/src/com/frozendo/newjava/DefaultMethodsExamples.java).

## Static Methods

In interfaces, static methods work exactly equal to a static method in a class: the method is in the Interface scope.
So, to call one interface static method, we need to do _SomeInterface.staticMethod()_.

In interface [StaticMethods](https://github.com/frozendo/study-java/blob/java-8/src/com/frozendo/newjava/StaticMethods.java) we have an example of an interface that has a main method.

## Optional

Optional help us with _NullPointerException_, making our code clearer and more readable.
It doesn't replace the null value but allows us to take smarter actions, working as a wrapper around our object, giving ways to validate whether the object exists or not, or even get its value.

Class [OptionalExamples](https://github.com/frozendo/study-java/blob/java-8/src/com/frozendo/newjava/OptionalExamples.java) have more examples about _Optional_ and its methods.

## Date API

A new API for working with date and other time representations.
This new API was based on the famous Joda Time library and built with three main ideas: immutable classes, domain segregation, and support for different chronologies.

We have different classes to work with different representations of date and time.

* [LocalDate](https://github.com/frozendo/study-java/blob/java-8/src/com/frozendo/dateapi/LocalDateExamples.java)
* [LocalTime](https://github.com/frozendo/study-java/blob/java-8/src/com/frozendo/dateapi/LocalTimeExamples.java)
* [LocalDateTime](https://github.com/frozendo/study-java/blob/java-8/src/com/frozendo/dateapi/LocalDateTimeExamples.java)
* [ZonedDateTime](https://github.com/frozendo/study-java/blob/java-8/src/com/frozendo/dateapi/ZonedDateTimeExamples.java)
* [OffsetDateTime](https://github.com/frozendo/study-java/blob/java-8/src/com/frozendo/dateapi/OffsetDateTimeExamples.java)

Other classes that can represent time in different ways are [_Instant_, _Period_, and _Duration_](https://github.com/frozendo/study-java/blob/java-8/src/com/frozendo/dateapi/OtherDateExamples.java).

The form to compare and format date also change and can be done easily. See examples [here](https://github.com/frozendo/study-java/blob/java-8/src/com/frozendo/dateapi/CompareFormatExamples.java).

## Functional Interface

_Functional Interface_ is an interface with a single abstract method. All classes that meet this rule are a functional interface, no matter if they are introduced in this version or exist in earlier versions.

These interfaces are the heart of functional programming in Java.

## Lambda

Lambda is an anonymous method that implements some interface, more exactly functional interfaces. This feature has similarities with Anonymous Class concepts but is implemented in a better and more optimized way.
The lambda function can receive 1 or n parameters, as long as it respects the signature defined in the interface.

Another Java 8 feature that goes hand in hand with Lambda is the _Method Reference_, which can be used in almost every case when using lambda, and after the compilation, generates almost the same code.

You can see examples of utilization of lambda [here](https://github.com/frozendo/study-java/tree/java-8/src/com/frozendo/lambda).

## Stream and Parallel Streams

Stream can be defined as a wrapper to collections and arrays. But it can be more than that.
With stream, we have a lot of power to manipulate, classify or even transform collections.

It could be created from a collection, array, or passing the elements straight to the *_of_* method. For more examples, see [StreamExamples](https://github.com/frozendo/study-java/blob/java-8/src/com/frozendo/javastream/StreamExamples.java).

Stream API also has classes to primitive types: 
* [Int](https://github.com/frozendo/study-java/blob/java-8/src/com/frozendo/javastream/IntStreamExamples.java)
* [Double](https://github.com/frozendo/study-java/blob/java-8/src/com/frozendo/javastream/DoubleStreamExamples.java)
* [Long](https://github.com/frozendo/study-java/blob/java-8/src/com/frozendo/javastream/LongStreamExamples.java).

The Stream class runs all the processes on a single thread. If we want to run the same process multithreaded we need to use ParallelStreams, which work in the same way, but some operations maybe have different behavior.
[Here](https://github.com/frozendo/study-java/tree/java-8/src/com/frozendo/parallelstreams) we have examples of ParallelStreams.

## Reduction

Reductions are operations that get multi-elements and combine them into a unique result. This can be a sum operation, an aggregate operation, etc.

Stream API has two methods that can be used in this kind of operation: 
* [collect](https://github.com/frozendo/study-java/blob/java-8/src/com/frozendo/reduction/CollectExamples.java) 
* [reduce](https://github.com/frozendo/study-java/blob/java-8/src/com/frozendo/reduction/ReduceExamples.java). 
 
Some collectors can be combined with grouping operations. See some example [here](https://github.com/frozendo/study-java/blob/java-8/src/com/frozendo/reduction/GroupCollectorsExamples.java).

### To Read More
For more details about Java 8, you can read my articles about: 
* [Java 8 - Um novo java](https://frozendo.medium.com/java-8-um-novo-java-dfa1a42d1435)
* [Java 8 - Date API](https://frozendo.medium.com/java-8-date-api-6d462103622b)
* [Java 8 - Lambdas e o conceito funcional](https://frozendo.medium.com/java-8-lambdas-e-o-conceito-funcional-dcf17277477d)
* [Java 8 - Stream API](https://frozendo.medium.com/java-8-stream-api-1c1d0aa509bb)
* [Java 8 - Reduções e Parallel Stream](https://frozendo.medium.com/java-8-redu%C3%A7%C3%B5es-e-parallel-streams-a4a519084d55) 