package io.github.seujorgenochurras.parser.listener.kotlin;

import io.github.seujorgenochurras.domain.FunctionLiteral;
import io.github.seujorgenochurras.domain.kotlin.KotlinFunctionLiteral;
import io.github.seujorgenochurras.generate.antlr.KotlinParser;
import io.github.seujorgenochurras.generate.antlr.KotlinParserBaseListener;
import org.antlr.v4.runtime.TokenStreamRewriter;

import java.util.HashMap;

public class KotlinFunctionListener extends KotlinParserBaseListener {
    private String lastIdentifier = "";
    private final TokenStreamRewriter rewriter;

    private final HashMap<String, FunctionLiteral> functionLiterals = new HashMap<>();

    public HashMap<String, FunctionLiteral> getFunctionLiterals() {
        return functionLiterals;
    }

    public KotlinFunctionListener(TokenStreamRewriter rewriter) {
        this.rewriter = rewriter;
    }

    @Override
    public void enterSimpleIdentifier(KotlinParser.SimpleIdentifierContext ctx) {
        lastIdentifier = ctx.getText();
    }

    @Override
    public void enterFunctionLiteral(KotlinParser.FunctionLiteralContext ctx) {
        KotlinFunctionLiteral functionLiteral = new KotlinFunctionLiteral(ctx, lastIdentifier, rewriter);
        functionLiterals.put(functionLiteral.getIdentifier(), functionLiteral);
    }

}