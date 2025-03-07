package io.github.seujorgenochurras.domain.kotlin;

import io.github.seujorgenochurras.domain.CodeBlock;
import org.antlr.v4.runtime.TokenStreamRewriter;

public class KotlinCodeBlock implements CodeBlock {

    private TokenStreamRewriter rewriter;

    @Override
    public void addLine(String codeLine) {

    }

    @Override
    public String getCodeBlock() {
        return "";
    }
}
