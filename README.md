# Java 10

**Release Date:** 20/03/2018

## Streams

Java 10 brings three new collectors in Stream API, which allow the accumulation of elements in an immutable collection.

### toUnmodifiableList

This collector accumulates the elements in an immutable list without order. It produces a result similar to _List.of_. Including the method _List.of_ is used at the end of the collector.

### toUnmodifiableSet

This collector accumulates the elements in an immutable set without order. It produces a result similar to _Set.of_, and duplicate values aren't allowed.

### toUnmodifiableMap

This collector accumulates the elements in an immutable map, though different from the previous two, toUnmodifiableMap accepts two functions: one for key and the other for values. There is an overload of this method, which have a third parameter that allows defining a merge function.

To see more examples of these three collectors, see [UnmodifiableCollectorsExample](https://github.com/frozendo/study-java/blob/java-10/src/com/frozendo/streams/UnmodifiableCollectorsExample.java).

## Optional - orElseThrow

The optional class has a new version of *orElseThrow* method.

This overload has the same behavior as the previous one but without a parameter. If the optional is empty, then the method throws NoSucElementException.

This new method probably will override get method as they have the same behavior. The motivation is to adequate the nomenclature of the method with the other methods or in the Optional class.

[OrElseThrowExamples](https://github.com/frozendo/study-java/blob/java-10/src/com/frozendo/optionals/OrElseThrowExamples.java) show how to use this method.

## To read more

For more details about Java 10, you can read these articles about:

* [Optional e Stream - melhorias pós Java 8](https://frozendo.medium.com/optional-e-stream-melhorias-p%C3%B3s-java-8-95262079396f)

