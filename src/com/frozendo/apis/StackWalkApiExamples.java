package com.frozendo.apis;

import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class StackWalkApiExamples {

    public static void main(String[] args) {
        StackWalkApiExamples execute = new StackWalkApiExamples();
        execute.startExamples();
    }

    private void startExamples() {
        getStackTraceOldWay();
    }

    private void getStackTraceOldWay() {
        System.out.println("##### Get Stack Trace - Old Way #####");

        System.out.println("Get stack trace from current thread");
        StackTraceElement[] currentThreadTraceElements = Thread.currentThread().getStackTrace();
        System.out.println(Arrays.toString(currentThreadTraceElements));

        System.out.println();

        System.out.println("Get stack trace from exception");
        StackTraceElement[] exceptionTraceElements = new Exception().getStackTrace();
        System.out.println(Arrays.toString(exceptionTraceElements));

        System.out.println();

        stackWalkGetInstanceExamples();

    }

    private void stackWalkGetInstanceExamples() {
        System.out.println("##### Stack Walk - getInstance #####");

        StackWalker stackWalkerSimple = StackWalker.getInstance();
        System.out.println(stackWalkerSimple);
        System.out.println();

        StackWalker stackWalkerOneOption = StackWalker.getInstance(StackWalker.Option.RETAIN_CLASS_REFERENCE);
        System.out.println(stackWalkerOneOption);
        System.out.println();

        StackWalker stackWalkerMultiOption = StackWalker.getInstance(
                Set.of(StackWalker.Option.SHOW_HIDDEN_FRAMES,
                        StackWalker.Option.SHOW_REFLECT_FRAMES));
        System.out.println(stackWalkerMultiOption);
        System.out.println();

        StackWalker stackWalkerLimit = StackWalker.getInstance(
                Set.of(StackWalker.Option.SHOW_HIDDEN_FRAMES,
                        StackWalker.Option.SHOW_REFLECT_FRAMES, StackWalker.Option.RETAIN_CLASS_REFERENCE), 5);
        System.out.println(stackWalkerLimit);

        System.out.println();

        stackWalkerStackFrameExample();

    }

    private void stackWalkerStackFrameExample() {
        System.out.println("##### Stack Frame properties #####");
        StackWalker stackWalker = StackWalker.getInstance(StackWalker.Option.RETAIN_CLASS_REFERENCE);

        stackWalker.forEach(s -> {
            System.out.println("Stack Frame: ClassName: " + s.getClassName());
            System.out.println("Stack Frame: MethodName: " + s.getMethodName());
            System.out.println("Stack Frame: FileName: " + s.getFileName());
            System.out.println("Stack Frame: ByteCodeIndex: " + s.getByteCodeIndex());
            System.out.println("Stack Frame: DeclaringClass (enable by RETAIN_CLASS_REFERENCE): " + s.getDeclaringClass());
            System.out.println("Stack Frame: LineNumber: " + s.getLineNumber());
            System.out.println("-----------");
        });

        System.out.println();

        stackWalkerForEachExample();
    }

    private void stackWalkerForEachExample() {
        System.out.println("##### Using stack walker foreach #####");
        StackWalker stackWalker = StackWalker.getInstance();

        stackWalker.forEach(s -> System.out.println(s.getClassName() + ", " + s.getMethodName()));

        System.out.println();

        stackWalkerWalkExample();
    }

    private void stackWalkerWalkExample() {
        System.out.println("##### Using walk from StackWalker #####");

        StackWalker stackWalker = StackWalker.getInstance();

        List<StackWalker.StackFrame> stackFrames = stackWalker.walk(w ->
                w.takeWhile(f -> f.getMethodName().contains("stack"))
                        .collect(Collectors.toList())
        );

        stackFrames.forEach(System.out::println);

        System.out.println();

    }

}


