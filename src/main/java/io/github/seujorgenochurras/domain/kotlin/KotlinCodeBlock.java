package io.github.seujorgenochurras.domain.kotlin;

import io.github.seujorgenochurras.domain.CodeBlock;
import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.TokenStreamRewriter;

public class KotlinCodeBlock implements CodeBlock {

    private TokenStreamRewriter rewriter;
    private ParserRuleContext context;

    public KotlinCodeBlock setRewriter(TokenStreamRewriter rewriter) {
        this.rewriter = rewriter;
        return this;
    }

    public KotlinCodeBlock setContext(ParserRuleContext context) {
        this.context = context;
        return this;
    }

    @Override
    public void addLine(String codeLine) {
        rewriter.insertAfter(getParent().start, "\n" + codeLine);
    }

    @Override
    public ParserRuleContext getContext() {
        return context;
    }
}
