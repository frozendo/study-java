# Java 16

## Streams

In Java 16, two new methods were added in Stream API

### mapMulti

Similar to the _flatMap_ executes an exchange of the stream elements by zero or more elements. Each element passes through the method and may or may not be changed.

The elements changed by the method are accumulated by a consumer before passing to the stream.

MapMulti is better than _flatMap_ in some situations, principally when each element of the stream is changed by a few elements, or when is more simple to utilize an imperative approach.


### toList

toList is a final operation that accumulates the elements in a list. Unlike Collectors.toList, this method return an immutable list, similar to List.of.

This method is not used with collect, but directly in final a pipeline.

[NewMethodsExamples](https://github.com/frozendo/study-java/blob/java-16/src/com/frozendo/streams/NewMethodsExample.java) show how to use both methods.

## To Read More

For more details about Java 9, you can read these articles about:

[Optional e Stream — melhorias pós Java 8](https://frozendo.medium.com/optional-e-stream-melhorias-p%C3%B3s-java-8-95262079396f)