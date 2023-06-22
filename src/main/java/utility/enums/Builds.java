package utility.enums;

public enum Builds {

    BUILD_28("build:3.2.14.55.28"),
    BUILD_23("build:3.2.14.55.23"),
    BUILD_19("build:3.2.14.55.19"),
    BUILD_13("build:3.2.14.55.13"),
    BUILD_7("build:3.2.14.55.7");

    private final String buildNum;

    Builds(String buildNum) {
        this.buildNum = buildNum;
    }

    public String getbuildNum(){
        return buildNum;
    }
}
