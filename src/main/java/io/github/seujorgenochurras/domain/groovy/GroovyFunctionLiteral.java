package io.github.seujorgenochurras.domain.groovy;

import io.github.seujorgenochurras.domain.CodeBlock;
import io.github.seujorgenochurras.domain.FunctionLiteral;
import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.TokenStreamRewriter;
import org.apache.groovy.parser.antlr4.GroovyParser;

public class GroovyFunctionLiteral implements FunctionLiteral{
    private final String identifier;
    private final GroovyParser.GroovyParserRuleContext context;
    private CodeBlock codeBlock;
    private final TokenStreamRewriter rewriter;

    public GroovyFunctionLiteral(String identifier, GroovyParser.ClosureContext context, TokenStreamRewriter rewriter) {
        this.identifier = identifier;
        this.context = context;
        this.rewriter = rewriter;
    }

    private CodeBlock genCodeBlock() {
        return new GroovyCodeBlock(rewriter, context.getParent());
    }

    public String getIdentifier() {
        return identifier;
    }

    public CodeBlock getBlock() {
        if (codeBlock == null) {
            codeBlock = genCodeBlock();
        }
        return codeBlock;
    }


    @Override
    public ParserRuleContext getContext() {
        return context;
    }

    @Override
    public String toString() {
        return "GroovyFunctionLiteral{" +
                "identifier='" + identifier + '\'' +
                ", context=" + context +
                ", codeBlock=" + codeBlock +
                ", rewriter=" + rewriter +
                '}';
    }
}
