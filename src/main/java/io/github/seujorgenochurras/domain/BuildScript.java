package io.github.seujorgenochurras.domain;

import io.github.seujorgenochurras.domain.dependency.DependencyBlock;
import io.github.seujorgenochurras.domain.plugin.PluginBlock;
import org.antlr.v4.runtime.TokenStreamRewriter;

public class  BuildScript {
    private PluginBlock pluginBlock;
    private DependencyBlock dependencyBlock;
    private final TokenStreamRewriter rewriter;

    public BuildScript(TokenStreamRewriter rewriter) {
        this.rewriter = rewriter;
    }

    public BuildScript setPluginBlock(PluginBlock pluginBlock) {
        this.pluginBlock = pluginBlock;
        return this;
    }

    public BuildScript setDependencyBlock(DependencyBlock dependencyBlock) {
        this.dependencyBlock = dependencyBlock;
        return this;
    }

    public TokenStreamRewriter getRewriter() {
        return rewriter;
    }

    public PluginBlock getPluginBlock() {
        return pluginBlock;
    }

    public DependencyBlock getDependencyBlock() {
        return dependencyBlock;
    }

}
