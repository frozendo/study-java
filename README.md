# Java 12

## Stream

### teeing

This is a collector compound by two downstream collectors and one merge function.

Teeing is very useful when we want to collect a stream in different forms, and compare or combine the results since the all elements are processed by both collectors.

The merge function is responsible two combine or compare the result of both collectors.

The [TeeingCollectorExamples](https://github.com/frozendo/study-java/blob/java-12/src/com/frozendo/streams/TeeingCollectorExamples.java) class has examples of using this collector.

## To read more

For more details about Java 12, you can read these articles about:

[Optional e Stream - melhorias pós Java 8](https://frozendo.medium.com/optional-e-stream-melhorias-p%C3%B3s-java-8-95262079396f#a960).

