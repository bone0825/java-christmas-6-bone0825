package christmas.domain;

public enum EvenetBadge {
    SANTABADGE("산타",20000),
    TREEBADGE("트리",10000),
    STARBADGE("별",5000);

    private String badge;
    private int minimumBenefit;
    private EvenetBadge(String badge, int minimumBenefit) {
        this.badge=badge;
        this.minimumBenefit = minimumBenefit;
    }

    public String getBadge(){
        return badge;
    }
    public int getMinimumBenefit() {
        return minimumBenefit;
    }
}
