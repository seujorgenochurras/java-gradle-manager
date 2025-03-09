package io.github.seujorgenochurras;

import io.github.seujorgenochurras.domain.build.BuildScript;
import io.github.seujorgenochurras.domain.dependency.Dependency;
import io.github.seujorgenochurras.domain.dependency.DependencyType;
import io.github.seujorgenochurras.parser.BuildScriptFactory;
import org.antlr.v4.runtime.TokenStreamRewriter;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import static io.github.seujorgenochurras.util.FileUtils.getFileAsString;

public class Main {
    public static void main(String[] args) throws IOException {
        File file = new File("build.gradle.kts");
        String rawFile = getFileAsString(file);

        BuildScript kotlinBuildScript = BuildScriptFactory.fromKotlinScript(rawFile);

        Dependency dependency = new Dependency(DependencyType.IMPLEMENTATION, "org.antlr:antlr4-runtime:4.13.1");
        kotlinBuildScript.getDependencyBlock().addDependency(dependency);

        TokenStreamRewriter rewriter = kotlinBuildScript.getRewriter();
        FileWriter fileWriter = new FileWriter("new.build.gralde.kts");
        fileWriter.write(rewriter.getText());
        fileWriter.flush();
    }

}
