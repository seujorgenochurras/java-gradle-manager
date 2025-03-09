package io.github.seujorgenochurras.domain.build;

import io.github.seujorgenochurras.domain.dependency.DependencyBlock;
import io.github.seujorgenochurras.domain.plugin.PluginBlock;
import org.antlr.v4.runtime.TokenStreamRewriter;

public class KotlinBuildScript implements BuildScript {
    private PluginBlock pluginBlock;
    private DependencyBlock dependencyBlock;
    private final TokenStreamRewriter rewriter;

    public KotlinBuildScript(TokenStreamRewriter rewriter) {
        this.rewriter = rewriter;
    }

    public KotlinBuildScript setPluginNode(PluginBlock pluginBlock) {
        this.pluginBlock = pluginBlock;
        return this;
    }

    public KotlinBuildScript setDependencyNode(DependencyBlock dependencyBlock) {
        this.dependencyBlock = dependencyBlock;
        return this;
    }

    @Override
    public PluginBlock getPluginBlock() {
        return pluginBlock;
    }

    @Override
    public TokenStreamRewriter getRewriter() {
        return rewriter;
    }

    @Override
    public DependencyBlock getDependencyBlock() {
        return dependencyBlock;
    }
}
