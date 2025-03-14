package io.github.seujorgenochurras.domain.groovy;

import io.github.seujorgenochurras.domain.CodeBlock;
import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.TokenStreamRewriter;
import org.antlr.v4.runtime.misc.Interval;

public class GroovyCodeBlock implements CodeBlock {
    private final TokenStreamRewriter rewriter;
    private final ParserRuleContext context;

    public GroovyCodeBlock(TokenStreamRewriter rewriter, ParserRuleContext context) {
        this.rewriter = rewriter;
        this.context = context;
    }

    @Override
    public ParserRuleContext getContext() {
        return this.context;
    }

    @Override
    public void addLine(String codeLine) {
        rewriter.insertAfter(getParent().start, "\n" + codeLine);
    }

    @Override
    public String toString() {
        return "GroovyCodeBlock{" +
                "rewriter=" + rewriter.getText(new Interval(context.start.getTokenIndex(), context.stop.getTokenIndex())) +
                '}';
    }
}
