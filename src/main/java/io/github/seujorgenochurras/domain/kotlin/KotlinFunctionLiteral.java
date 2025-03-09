package io.github.seujorgenochurras.domain.kotlin;

import io.github.seujorgenochurras.domain.CodeBlock;
import io.github.seujorgenochurras.domain.FunctionLiteral;
import io.github.seujorgenochurras.generate.antlr.KotlinParser;
import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.TokenStreamRewriter;

public class KotlinFunctionLiteral implements FunctionLiteral {
    private final String identifier;
    private final KotlinParser.FunctionLiteralContext context;
    private CodeBlock codeBlock;
    private final TokenStreamRewriter rewriter;

    public KotlinFunctionLiteral(KotlinParser.FunctionLiteralContext context, String identifier, TokenStreamRewriter rewriter) {
        this.context = context;
        this.identifier = identifier;
        this.rewriter = rewriter;
    }

    private CodeBlock genCodeBlock() {
        return new KotlinCodeBlock()
                .setRewriter(rewriter)
                .setContext(context.statements());
    }

    @Override
    public String getIdentifier() {
        return identifier;
    }

    @Override
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
}
