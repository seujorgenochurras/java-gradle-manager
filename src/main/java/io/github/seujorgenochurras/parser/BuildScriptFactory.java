package io.github.seujorgenochurras.parser;

import io.github.seujorgenochurras.domain.BuildScript;
import io.github.seujorgenochurras.generate.antlr.KotlinLexer;
import io.github.seujorgenochurras.parser.groovy.GroovyBuildScriptParser;
import io.github.seujorgenochurras.parser.kotlin.KotlinBuildScriptParser;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.apache.groovy.parser.antlr4.GroovyLexer;

public class BuildScriptFactory {

    public static BuildScript fromKotlinScript(String rawScript) {
        KotlinLexer kotlinLexer = new KotlinLexer(CharStreams.fromString(rawScript));
        CommonTokenStream tokenStream = new CommonTokenStream(kotlinLexer);
        return new KotlinBuildScriptParser().parse(tokenStream);
    }

    public static BuildScript fromGroovyScript(String rawScript) {
        GroovyLexer groovyLexer = new GroovyLexer(CharStreams.fromString(rawScript));
        CommonTokenStream tokenStream = new CommonTokenStream(groovyLexer);

        return new GroovyBuildScriptParser().parse(tokenStream);
    }

}
