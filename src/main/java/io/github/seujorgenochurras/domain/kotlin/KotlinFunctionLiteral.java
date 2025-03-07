package io.github.seujorgenochurras.domain.kotlin;

import io.github.seujorgenochurras.domain.FunctionLiteral;

public class KotlinFunctionLiteral implements FunctionLiteral {
    private String name;
    private String codeBlock;



    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getBlock() {
        return codeBlock;
    }
}
