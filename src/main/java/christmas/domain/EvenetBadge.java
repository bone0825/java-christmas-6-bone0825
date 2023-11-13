package christmas.domain;

public enum EvenetBadge {
    STARBADGE("별"),
    TREEBADGE("트리"),
    SANTABADGE("산타");

    private String badge;
    private EvenetBadge(String badge) {
        this.badge=badge;
    }

    public String getBadge(){return badge;}
}
