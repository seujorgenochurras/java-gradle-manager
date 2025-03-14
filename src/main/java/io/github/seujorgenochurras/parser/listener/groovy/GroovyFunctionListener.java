package io.github.seujorgenochurras.parser.listener.groovy;

import io.github.seujorgenochurras.domain.FunctionLiteral;
import io.github.seujorgenochurras.domain.groovy.GroovyFunctionLiteral;
import org.antlr.v4.runtime.TokenStreamRewriter;
import org.apache.groovy.parser.antlr4.GroovyParser;
import org.apache.groovy.parser.antlr4.GroovyParserBaseVisitor;

import java.util.HashMap;

public class GroovyFunctionListener extends GroovyParserBaseVisitor<Void> {
    private String lastIdentifier = "";
    private TokenStreamRewriter rewriter;
    private HashMap<String, FunctionLiteral> functionLiterals = new HashMap<>();

    public GroovyFunctionListener(TokenStreamRewriter rewriter) {
        this.rewriter = rewriter;
    }

    @Override
    public Void visitClosure(GroovyParser.ClosureContext ctx) {
        FunctionLiteral groovyFunctionLiteral = new GroovyFunctionLiteral(lastIdentifier, ctx, rewriter);
        functionLiterals.put(lastIdentifier, groovyFunctionLiteral);
        return super.visitClosure(ctx);
    }

    @Override
    public Void visitIdentifier(GroovyParser.IdentifierContext ctx) {
        lastIdentifier = ctx.getText();
        return super.visitIdentifier(ctx);
    }

    public HashMap<String, FunctionLiteral> getFunctionLiterals() {
        return functionLiterals;
    }
}
