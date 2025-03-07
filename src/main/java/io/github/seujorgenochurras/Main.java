package io.github.seujorgenochurras;

import io.github.seujorgenochurras.generate.antlr.KotlinLexer;
import io.github.seujorgenochurras.generate.antlr.KotlinParser;
import io.github.seujorgenochurras.generate.antlr.KotlinParserBaseListener;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.TokenStreamRewriter;
import org.antlr.v4.runtime.tree.ParseTreeWalker;

import java.io.*;
import java.util.NoSuchElementException;

public class Main {
    public static void main(String[] args) throws IOException {
        File file = new File("build.gradle.kts");
        String rawFile = getFileAsString(file);
        KotlinLexer kotlinLexer = new KotlinLexer(CharStreams.fromString(rawFile));
        CommonTokenStream tokenStream = new CommonTokenStream(kotlinLexer);
        KotlinParser kotlinParser = new KotlinParser(tokenStream);
        var tree = kotlinParser.script();
        ParseTreeWalker walker = new ParseTreeWalker();
        TokenStreamRewriter rewriter = new TokenStreamRewriter(tokenStream);
        walker.walk(new TestListener(rewriter), tree);

        System.out.println(rewriter.getText());
        FileWriter fileWriter = new FileWriter("new.build.gralde.kts");
        fileWriter.write(rewriter.getText());
        fileWriter.flush();
    }

    public static String getFileAsString(File file) {
        StringBuilder fileAsString = new StringBuilder();

        try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(file)))) {
            String currentLine;
            while ((currentLine = bufferedReader.readLine()) != null) {
                fileAsString.append(currentLine).append("\n");
            }

        } catch (IOException e) {
            throw new NoSuchElementException(e);
        }
        return fileAsString.toString();
    }

    public static class TestListener extends KotlinParserBaseListener {
        String lastIdentifier = "";
        TokenStreamRewriter rewriter;

        public TestListener(TokenStreamRewriter rewriter) {
            this.rewriter = rewriter;
        }

        @Override
        public void enterSimpleIdentifier(KotlinParser.SimpleIdentifierContext ctx) {
         //   System.out.println(ctx.getText());
            lastIdentifier = ctx.getText();
        }

        @Override
        public void enterFunctionLiteral(KotlinParser.FunctionLiteralContext ctx) {
            rewriter.insertAfter(ctx.getStart(), "\n casdas");
        }

        @Override
        public void exitFunctionLiteral(KotlinParser.FunctionLiteralContext ctx) {
            lastIdentifier = "";
        }
    }
}