package utility.enums;

public enum LaunchesFields {
    TOTAL("total"),
    PASSED("passed"),
    FAILED("failed"),
    SKIPPED("skipped"),
    PRODUCT_BUG("product bug"),
    AUTO_BUG("auto bug"),
    SYSTEM_ISSUE("system issue"),
    TO_INVESTIGATE("to investigate");

    private final String state;

    LaunchesFields(String state) {
        this.state = state;
    }

    public String getState(){
        return state;
    }
}
