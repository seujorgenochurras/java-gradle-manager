package io.github.seujorgenochurras.domain.build;

import io.github.seujorgenochurras.domain.dependency.DependencyBlock;
import io.github.seujorgenochurras.domain.plugin.PluginBlock;
import org.antlr.v4.runtime.TokenStreamRewriter;

public class GroovyBuildScript implements BuildScript{
    private PluginBlock pluginBlock;
    private DependencyBlock dependencyBlock;
    private final TokenStreamRewriter rewriter;

    public GroovyBuildScript(TokenStreamRewriter rewriter) {
        this.rewriter = rewriter;
    }

    public GroovyBuildScript setPluginBlock(PluginBlock pluginBlock) {
        this.pluginBlock = pluginBlock;
        return this;
    }

    public GroovyBuildScript setDependencyBlock(DependencyBlock dependencyBlock) {
        this.dependencyBlock = dependencyBlock;
        return this;
    }

    @Override
    public TokenStreamRewriter getRewriter() {
        return rewriter;
    }

    @Override
    public PluginBlock getPluginBlock() {
        return pluginBlock;
    }

    @Override
    public DependencyBlock getDependencyBlock() {
        return dependencyBlock;
    }
}
