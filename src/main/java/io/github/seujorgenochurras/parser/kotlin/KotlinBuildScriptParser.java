package io.github.seujorgenochurras.parser.kotlin;

import io.github.seujorgenochurras.domain.FunctionLiteral;
import io.github.seujorgenochurras.domain.build.BuildScript;
import io.github.seujorgenochurras.domain.build.KotlinBuildScript;
import io.github.seujorgenochurras.domain.dependency.DependencyBlock;
import io.github.seujorgenochurras.generate.antlr.KotlinParser;
import io.github.seujorgenochurras.parser.BuildScriptParser;
import io.github.seujorgenochurras.parser.listener.kotlin.KotlinFunctionListener;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.TokenStreamRewriter;
import org.antlr.v4.runtime.tree.ParseTreeWalker;

import java.util.HashMap;

public class KotlinBuildScriptParser implements BuildScriptParser {

    private KotlinParser kotlinParser;
    private KotlinParser.ScriptContext scriptContext;
    private TokenStreamRewriter rewriter;
    private ParseTreeWalker walker;

    private void init(CommonTokenStream tokenStream) {
        this.kotlinParser = new KotlinParser(tokenStream);
        this.scriptContext = kotlinParser.script();
        this.walker = new ParseTreeWalker();
        this.rewriter = new TokenStreamRewriter(tokenStream);
    }

    @Override
    public BuildScript parse(CommonTokenStream tokenStream) {
        init(tokenStream);

        var functionLiterals = getFunctionLiterals();

        FunctionLiteral dependencyFunctionLiteral = functionLiterals.get("dependencies");
        DependencyBlock dependencyBlock = new DependencyBlock(dependencyFunctionLiteral);
        KotlinBuildScript kotlinBuildScript = new KotlinBuildScript(rewriter);
        kotlinBuildScript.setDependencyNode(dependencyBlock);

        return kotlinBuildScript;
    }

    private HashMap<String, FunctionLiteral> getFunctionLiterals() {
        var kotlinFunctionListener = new KotlinFunctionListener(rewriter);

        walker.walk(kotlinFunctionListener, scriptContext);
        return kotlinFunctionListener.getFunctionLiterals();

    }
}
