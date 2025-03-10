package io.github.seujorgenochurras.parser;

import io.github.seujorgenochurras.domain.build.BuildScript;
import io.github.seujorgenochurras.generate.antlr.KotlinLexer;
import io.github.seujorgenochurras.parser.kotlin.KotlinBuildScriptParser;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;

public class BuildScriptFactory {

    public static BuildScript fromKotlinScript(String rawScript) {
        KotlinLexer kotlinLexer = new KotlinLexer(CharStreams.fromString(rawScript));
        CommonTokenStream tokenStream = new CommonTokenStream(kotlinLexer);
        return new KotlinBuildScriptParser().parse(tokenStream);
    }

    public static BuildScript fromGroovyScript(String rawScript) {
        return null;
    }

}
