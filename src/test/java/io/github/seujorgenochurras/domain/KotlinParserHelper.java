package io.github.seujorgenochurras.domain;

import io.github.seujorgenochurras.generate.antlr.KotlinLexer;
import io.github.seujorgenochurras.generate.antlr.KotlinParser;
import io.github.seujorgenochurras.parser.kotlin.KotlinBuildScriptParser;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.TokenStreamRewriter;
import org.antlr.v4.runtime.tree.ParseTreeWalker;

public class KotlinParserHelper {
    private final KotlinParser kotlinParser;
    private final KotlinParser.ScriptContext scriptContext;
    private final TokenStreamRewriter rewriter;
    private final ParseTreeWalker walker;

    public static KotlinParserHelper fromString(String rawKotlinCode){

        KotlinLexer kotlinLexer = new KotlinLexer(CharStreams.fromString(rawKotlinCode));
        CommonTokenStream tokenStream = new CommonTokenStream(kotlinLexer);
        return new KotlinParserHelper(tokenStream);
    }
    public KotlinParserHelper(CommonTokenStream tokenStream) {
        this.kotlinParser = new KotlinParser(tokenStream);
        this.scriptContext = kotlinParser.script();
        this.walker = new ParseTreeWalker();
        this.rewriter = new TokenStreamRewriter(tokenStream);
    }

    public KotlinParser getKotlinParser() {
        return kotlinParser;
    }

    public KotlinParser.ScriptContext getScriptContext() {
        return scriptContext;
    }

    public TokenStreamRewriter getRewriter() {
        return rewriter;
    }

    public ParseTreeWalker getWalker() {
        return walker;
    }
}
