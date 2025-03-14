package io.github.seujorgenochurras.parser.groovy;


import io.github.seujorgenochurras.domain.FunctionLiteral;
import io.github.seujorgenochurras.domain.BuildScript;
import io.github.seujorgenochurras.domain.dependency.DependencyBlock;
import io.github.seujorgenochurras.parser.BuildScriptParser;
import io.github.seujorgenochurras.parser.listener.groovy.GroovyFunctionListener;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.TokenStreamRewriter;
import org.apache.groovy.parser.antlr4.GroovyParser;

import java.util.HashMap;

public class GroovyBuildScriptParser implements BuildScriptParser {
    private GroovyParser groovyParser;
    private GroovyParser.CompilationUnitContext mainContext;
    private TokenStreamRewriter rewriter;


    private void init(CommonTokenStream tokenStream) {
        this.groovyParser = new GroovyParser(tokenStream);
        this.mainContext = groovyParser.compilationUnit();
        this.rewriter = new TokenStreamRewriter(tokenStream);
    }

    @Override
    public BuildScript parse(CommonTokenStream tokenStream) {
        init(tokenStream);
        BuildScript buildScript = new BuildScript(rewriter);

        HashMap<String, FunctionLiteral> functionLiterals = getFunctionLiterals();
        DependencyBlock dependencyBlock = new DependencyBlock(functionLiterals.get("dependencies"));
        buildScript.setDependencyBlock(dependencyBlock);

        return buildScript;
    }

    private HashMap<String, FunctionLiteral> getFunctionLiterals() {
        var groovyFunctionListener = new GroovyFunctionListener(rewriter);
        groovyFunctionListener.visit(mainContext);
        return groovyFunctionListener.getFunctionLiterals();
    }
}
