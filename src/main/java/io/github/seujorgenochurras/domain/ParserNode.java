package io.github.seujorgenochurras.domain;

import org.antlr.v4.runtime.ParserRuleContext;

public interface ParserNode {

    default ParserRuleContext getParent() {
        return getContext().getParent();
    }

    ParserRuleContext getContext();
}
