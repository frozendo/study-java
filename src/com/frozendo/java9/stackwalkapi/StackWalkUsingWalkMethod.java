package com.frozendo.java9.stackwalkapi;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class StackWalkUsingWalkMethod {

    public static void main(String[] args) {
        StackWalkUsingWalkMethod execute = new StackWalkUsingWalkMethod();
        execute.startChainExample();
    }

    private void startChainExample() {
        stackWalkerStackFrameWithBasicInstance();
    }

    private void stackWalkerStackFrameWithBasicInstance() {
        StackWalker stackWalker = StackWalker.getInstance();
        runExample(stackWalker);
        System.out.println("==============================================");
        stackWalkerStackFrameWithRetainClassReference();
    }

    private void stackWalkerStackFrameWithRetainClassReference() {
        StackWalker stackWalker = StackWalker.getInstance(StackWalker.Option.RETAIN_CLASS_REFERENCE);
        runExample(stackWalker);
        System.out.println("==============================================");
        stackWalkerStackFrameWithShowHiddenAndReflectFrames();
    }

    private void stackWalkerStackFrameWithShowHiddenAndReflectFrames() {
        StackWalker stackWalker = StackWalker.getInstance(
                Set.of(StackWalker.Option.SHOW_HIDDEN_FRAMES,
                        StackWalker.Option.SHOW_REFLECT_FRAMES));
        runExample(stackWalker);
        System.out.println("==============================================");
        stackWalkerStackFrameWithAll();
    }

    private void stackWalkerStackFrameWithAll() {
        StackWalker stackWalker = StackWalker.getInstance(
                Set.of(StackWalker.Option.SHOW_HIDDEN_FRAMES,
                        StackWalker.Option.SHOW_REFLECT_FRAMES, StackWalker.Option.RETAIN_CLASS_REFERENCE), 5);
        runExample(stackWalker);
    }

    private void runExample(StackWalker stackWalker) {
        List<StackWalker.StackFrame> stackFrames = stackWalker.walk(w ->
                w.dropWhile(f -> f.getMethodName().contains("main"))
                        .collect(Collectors.toList())
        );

        stackFrames.forEach(System.out::println);
    }

}
