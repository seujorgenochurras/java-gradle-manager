package io.github.seujorgenochurras.domain.dependency;

public class Dependency {

    private DependencyType dependencyType;

    private String artifactId;
    private String version = "";
    private String groupId;

    public Dependency(DependencyType dependencyType, String rawAnnotation) {
        this.dependencyType = dependencyType;

        String[] separatedAnnotation = rawAnnotation.split(":");

        this.groupId = separatedAnnotation[0];
        this.artifactId = separatedAnnotation[1];

        if (separatedAnnotation.length == 3) { // Some dependencies have no version
            this.version = separatedAnnotation[2];
        }

    }

    @Override
    public String toString() {
        String rawImplementation = dependencyType.toString() + "(\"" + groupId + ":" + artifactId;

        if (!version.isBlank())
            rawImplementation += ":" + version;
        rawImplementation += "\")";

        return rawImplementation;
    }

    public DependencyType getDependencyType() {
        return dependencyType;
    }

    public Dependency setDependencyType(DependencyType dependencyType) {
        this.dependencyType = dependencyType;
        return this;
    }

    public String getArtifactId() {
        return artifactId;
    }

    public Dependency setArtifactId(String artifactId) {
        this.artifactId = artifactId;
        return this;
    }

    public String getVersion() {
        return version;
    }

    public Dependency setVersion(String version) {
        this.version = version;
        return this;
    }

    public String getGroupId() {
        return groupId;
    }

    public Dependency setGroupId(String groupId) {
        this.groupId = groupId;
        return this;
    }
}
