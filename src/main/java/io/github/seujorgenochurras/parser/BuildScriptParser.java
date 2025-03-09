package io.github.seujorgenochurras.parser;

import io.github.seujorgenochurras.domain.build.BuildScript;
import org.antlr.v4.runtime.CommonTokenStream;

public interface BuildScriptParser {
    BuildScript parse(CommonTokenStream tokenStream);
}
