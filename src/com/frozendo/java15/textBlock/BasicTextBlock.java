package com.frozendo.java15.textBlock;

public class BasicTextBlock {

    public static void main(String[] args) {
        String textBlock = """
                A text block's principalis munus is to provide clarity by way of minimizing the Java syntax required to render a string that spans multiple lines.
                
                In earlier releases of the JDK, embedding multi-line code snippets required a tangled mess of explicit line terminators, string concatenations, and delimiters. 
                Text blocks eliminate most of these obstructions, allowing you to embed code snippets and text sequences more or less as-is.
                """;

        String textBlockWithSpecialCharacteres = """
                Using "quotation marks", 'simple quotes' and
                special characteres as !@#$%¨&*((
                with a string.
                """;

        String simpleHtml = """
                <!DOCTYPE html>
                    <html>
                        <body>
                                        
                            <h1>My First Heading</h1>
                            <p>My first paragraph.</p>
                                        
                        </body>
                    </html>
                """;

        System.out.println(textBlock);
        System.out.println();
        System.out.println(textBlockWithSpecialCharacteres);
        System.out.println();
        System.out.println(simpleHtml);
    }

}
