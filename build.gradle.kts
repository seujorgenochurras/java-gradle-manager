plugins {
    id("java")
    antlr
}

repositories {
    mavenCentral()
}

val groovyVersion = "4.0.16"


dependencies {
    antlr ("me.sunlan:antlr4:4.13.2.6")

    testImplementation(platform("org.junit:junit-bom:5.10.0"))
    testImplementation("org.junit.jupiter:junit-jupiter")
    implementation ("org.apache.groovy:groovy:$groovyVersion")

    implementation ("antlr:antlr:2.7.7")

    //TODO publish this to maven nexus
    implementation(files("src/main/java/lib/groovy.jar"))

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

