package io.github.seujorgenochurras.domain.dependency;

public enum DependencyType {
    IMPLEMENTATION("implementation"),
    TEST_IMPLEMENTATION("implementation");

    private final String type;

    DependencyType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return type;
    }
}
