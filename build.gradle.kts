plugins {
    id("java")
    antlr
    idea
}

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(platform("org.junit:junit-bom:5.10.0"))
    testImplementation("org.junit.jupiter:junit-jupiter")
    antlr ("org.antlr:antlr4:4.13.2")
    implementation ("org.antlr:antlr4-runtime:4.13.1")
}

tasks.test {
    useJUnitPlatform()
}

val antlrOutputDirPath = "${layout.buildDirectory.asFile.get().path}/generated-src/antlr/main/java"

tasks.generateGrammarSource {
    outputDirectory = file("${antlrOutputDirPath}/io/github/seujorgenochurras/generate/antlr")
}

sourceSets.main {

    java.srcDir(antlrOutputDirPath)
}

idea {
    module {
        generatedSourceDirs.add(file(antlrOutputDirPath))
    }
}