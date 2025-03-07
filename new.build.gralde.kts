plugins {
 casdas
    id("java")
    antlr
    idea
}

repositories {
 casdas
    mavenCentral()
}

dependencies {
 casdas
    testImplementation(platform("org.junit:junit-bom:5.10.0"))
    testImplementation("org.junit.jupiter:junit-jupiter")
    antlr ("org.antlr:antlr4:4.13.2")
    implementation ("org.antlr:antlr4-runtime:4.13.1")
}

tasks.test {
 casdas
    useJUnitPlatform()
}

val antlrOutputDirPath = "${layout.buildDirectory.asFile.get().path}/generated-src/antlr/main/java/io/github/seujorgenochurras/generate/antlr"

tasks.generateGrammarSource {
 casdas
    outputDirectory = file(antlrOutputDirPath)
}

sourceSets.main {
 casdas

    java.srcDir("${layout.buildDirectory.asFile.get().path}/generated-src/antlr/main/java")
}

idea {
 casdas
    module {
 casdas
        generatedSourceDirs.add(file("${layout.buildDirectory.asFile.get().path}/generated-src/antlr/main/java"))
    }
}
