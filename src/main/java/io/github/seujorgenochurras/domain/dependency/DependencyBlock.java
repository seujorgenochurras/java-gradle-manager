package io.github.seujorgenochurras.domain.dependency;

import io.github.seujorgenochurras.domain.CodeBlock;
import io.github.seujorgenochurras.domain.FunctionLiteral;

public class DependencyBlock {
    private final CodeBlock codeBlock;
    private final FunctionLiteral functionLiteral;

    public DependencyBlock(FunctionLiteral functionLiteral) {
        this.functionLiteral = functionLiteral;
        this.codeBlock = functionLiteral.getBlock();
    }

    public void addDependency(Dependency dependency) {
        codeBlock.addLine(dependency.toString());
    }

}
