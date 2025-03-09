package io.github.seujorgenochurras.domain.build;

import io.github.seujorgenochurras.domain.dependency.DependencyBlock;
import io.github.seujorgenochurras.domain.plugin.PluginBlock;
import org.antlr.v4.runtime.TokenStreamRewriter;

public interface BuildScript {
    DependencyBlock getDependencyBlock();

    PluginBlock getPluginBlock();

    TokenStreamRewriter getRewriter();

}
