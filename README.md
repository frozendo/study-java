# Java 9

**Release Date:** 21/09/2017

## APIS

### Process API

Process API has been improved to allow greater control over processes while making them easier to work. New methods and interfaces were added to the API and can be used to start, manage, and destroy system processes.

The interface _ProcessHandle_ identifies and gives more control over native processes. It is possible to monitor the process lifetime, get details, and even kill it. Beyond that, it's possible to get information about a child's process or even not direct descendants.

Another new interface is _ProcessHandle.Info_. It gives instant information about processes, such as the time it started, CPU utilization, args used to initiate the process, and the process's user.

To see the new API examples, see [ProcessApiExamples](https://github.com/frozendo/study-java/blob/java-9/src/com/frozendo/apis/ProcessApiExamples.java).
obs.: the examples assume a Linux environment, and some may not work in another OS.

### Stack Walk API

This API allows load frames of the current stack in an effective and practice way, supporting both: short analyses with few frames and extensive checks of the entire stack.

The principal is class _StackWalker_, and it has two important methods:

* *walk:* apply a lambda function, allowing walk through the program stack. This method doesn't return a Stream of frames. It creates a stream, executes the lambda over this stream, and returns a concrete result.
* *foreach:* also receive a lambda function, but here we don't have a return. The lambda executes against the stack, running through each element of the stack.

Another class of this API is StackFrame, which represents the frames in a stack.

Class [StackWalkApiExamples](https://github.com/frozendo/study-java/blob/java-9/src/com/frozendo/apis/StackWalkApiExamples.java) has examples of this API.

### Reactive Flow API

Flow API is the API that standardizes and attends to the requirements of reactive programming inside the JVM. This API has one class, _java.util.concurrent.Flow_, and inside this class we have four interfaces that define the four components of Reactive Streams:

* *Publisher:* publish the events of the stream and allow subscribers to register in this stream of events.
* *Subscriber:* connect to the Publisher to receive and process the stream of events.
* *Subscription:* represents the link between Publisher and Subscriber.
* *Processor:* combine the skills of a Publisher and a Subscriber in one class.

[ReactiveFlowExamples](https://github.com/frozendo/study-java/blob/java-9/src/com/frozendo/apis/ReactiveFlowExamples.java) has implementation examples of Flow API.

## Features

### Factories List

These new factory methods help us to create immutable collections easily.

The interfaces _List_ and _Set_ has the *of* method, which returns a collection with the items received in the parameter. The collections type created by these methods is not the most common, but specific internal types with restricted access.

The method *of* also exists in the Map interface. The only difference is to create each item of Map collections it's necessary two parameters: one for the key and one for the value. Beyond that, Map has another method called *ofEntries*. This method accepts a group of _Map.entry_ used to create the collection.

To see how to use these factory methods, see [FactoriesListExamples](https://github.com/frozendo/study-java/blob/java-9/src/com/frozendo/features/FactoriesListExamples.java).

### Private Method Interface

The private method in interfaces it's an evolution of default and static methods added in Java 8. Now it's possible to create static and non-static methods that have an implementation and is accessible just in interface scope.

Even if a class implements this interface, it doesn't have access to this private method. It means that a class cannot override or even call these methods.

[PrivateMethodsInterfaceExamples](https://github.com/frozendo/study-java/blob/java-9/src/com/frozendo/features/PrivateMethodsInterfaceExamples.java) show how to use this kind of method, with some examples of errors when a class tries to implement them.

### Anonymous Inner Class

_Anonymous Class_ and _Diamond Operator_ are concepts that exist before version 9. But we can't create an anonymous class with a diamond operator.

This change, and now it's possible to do that. We can implement any interface which uses the diamond operator inside another class or even in a method. It is up to the compiler to perform type inference at compile time.

[AnonymousInnerClassExamples](https://github.com/frozendo/study-java/blob/java-9/src/com/frozendo/features/AnonymousInnerClassExamples.java) show some examples.

### Final variable with Try With Resources

Try with resources was introduced in Java 7, and its principal goal is to guarantee that the resources utilized inside the try block are released at the end of the block. Although to use this feature, all the variables need to be declared inside the try declaration.

Now it's possible to use _try with resources_ with variables created outside its scope since they are final variables or effectively final variables (variables that are not declared as final but never change). The functionality doesn't change, and the resources still will be released at the end of the block.

See [TryWithResourcesExamples](https://github.com/frozendo/study-java/blob/java-9/src/com/frozendo/features/TryWithResourcesExamples.java) to compare.

## Streams

New methods and new collectors were added to _Streams API_.

### methods

* *takeWhile:* return a subset of the stream with the elements that match the condition passed in the parameter.
* *dropWhile:* return a subset of the stream with the items that don't match the condition passed in the parameter.
* *ofNullable:* create a new Stream and accept null values. When the value is null, the returned stream is empty.
* *iterate:* a new version of this method that has a condition function, which checks the value generated and if return is false, stops the creation of a sequential stream.

### collectors
* *filtering:* similar to _Stream.filter_, executes validations on downstream collectors, and if the check returns false, exclude the item.
* *flatMapping:* similar to _Stream.flatMap_, perform transformations and flats in downstream collectors.

To see these new methods and collectors in action, see [these](https://github.com/frozendo/study-java/tree/java-9/src/com/frozendo/streams) examples.

## Optional

The Optional class was improved in this version, with new options of methods.

* *or:* executes the lambda function receives in parameter when the optional is empty.
* *ifPresentOrElse:* execute a lambda function when the option has a value, and runnable when the option is empty.
* *stream:* similar to _Collection.stream_, create a stream from the optional.

The class [OptionalImprovementExamples](https://github.com/frozendo/study-java/blob/java-9/src/com/frozendo/optionals/OptionalImprovementExamples.java) show how use these methods.

## To Read More
For more details about Java 9, you can read these articles about:

* [Java 9 - Jshell](https://frozendo.medium.com/java-9-jshell-e3a75b850a9e)
* [Java 9 - novas features](https://frozendo.medium.com/java-9-novas-features-e6780508748c)
* [Novas API's pós Java 8](https://frozendo.medium.com/novas-apis-p%C3%B3s-java-8-4a1a05a93a93)
* [Optional e Stream - melhorias pós Java 8](https://frozendo.medium.com/optional-e-stream-melhorias-p%C3%B3s-java-8-95262079396f)