package io.github.seujorgenochurras.domain;

public interface FunctionLiteral extends ParserNode {
    CodeBlock getBlock();

    String getIdentifier();

}
