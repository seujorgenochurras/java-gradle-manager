package io.github.seujorgenochurras.listener;

import io.github.seujorgenochurras.domain.FunctionLiteral;
import io.github.seujorgenochurras.domain.KotlinParserHelper;
import io.github.seujorgenochurras.generate.antlr.KotlinParser;
import io.github.seujorgenochurras.parser.listener.kotlin.KotlinFunctionListener;
import org.junit.jupiter.api.Test;

import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.*;

public class KotlinFunctionListenerTest {

    @Test
    void onValidNamedLambdaFunction_returnValidFunctionMap(){
        String validNamedLambdaFunction = """
                repositories {
                    mavenCentral()
                }
                
                dependencies {
                    testImplementation(platform("org.junit:junit-bom:5.10.0"))
                    testImplementation("org.junit.jupiter:junit-jupiter")
                    antlr ("org.antlr:antlr4:4.13.2")
                    implementation ("org.antlr:antlr4-runtime:4.13.1")
                    implementation("org.apache.groovy:groovy:4.0.26")
                }
                """;

        KotlinParserHelper helper = KotlinParserHelper.fromString(validNamedLambdaFunction);
        KotlinFunctionListener functionListener = new KotlinFunctionListener(helper.getRewriter());
        helper.getWalker().walk(functionListener,helper.getScriptContext());
        HashMap<String, FunctionLiteral> functionLiterals = functionListener.getFunctionLiterals();
        assertNotNull(functionLiterals.get("dependencies"));
        assertNotNull(functionLiterals.get("repositories"));
    }
}
