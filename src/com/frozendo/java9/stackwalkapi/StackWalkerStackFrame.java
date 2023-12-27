package com.frozendo.java9.stackwalkapi;

import java.util.Set;

public class StackWalkerStackFrame {

    public static void main(String[] args) {
        StackWalkerStackFrame execute = new StackWalkerStackFrame();
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
        runExampleWithReatinClassReference(stackWalker);
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
        runExampleWithReatinClassReference(stackWalker);
    }

    private void runExample(StackWalker stackWalker) {
        stackWalker.forEach(s -> {
            System.out.println("Stack Frame: ClassName: " + s.getClassName());
            System.out.println("Stack Frame: MethodName: " + s.getMethodName());
            System.out.println("Stack Frame: FileName: " + s.getFileName());
            System.out.println("Stack Frame: ByteCodeIndex: " + s.getByteCodeIndex());
            System.out.println("Stack Frame: LineNumber: " + s.getLineNumber());
            System.out.println("-----------");
        });
    }

    private void runExampleWithReatinClassReference(StackWalker stackWalker) {
        stackWalker.forEach(s -> {
            System.out.println("Stack Frame: ClassName: " + s.getClassName());
            System.out.println("Stack Frame: MethodName: " + s.getMethodName());
            System.out.println("Stack Frame: FileName: " + s.getFileName());
            System.out.println("Stack Frame: ByteCodeIndex: " + s.getByteCodeIndex());
            System.out.println("Stack Frame: DeclaringClass (enable by RETAIN_CLASS_REFERENCE): " + s.getDeclaringClass());
            System.out.println("Stack Frame: LineNumber: " + s.getLineNumber());
            System.out.println("-----------");
        });
    }

}
