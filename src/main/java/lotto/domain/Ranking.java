package lotto.domain;

public enum Ranking {

    FIRST(6, 2_000_000_000L, "6개 일치"),
    SECOND(5, 30_000_000L, "5개 일치, 보너스 볼 일치"),
    THIRD(5, 1_500_000L, "5개 일치"),
    FOURTH(4, 50_000L, "4개 일치"),
    FIFTH(3, 5_000L, "3개 일치"),
    NOTHING(0, 0L, "");

    private final int matchCount;
    private final long prizeMoney;
    private final String description;

    Ranking(int matchCount, long prizeMoney, String description) {
        this.matchCount = matchCount;
        this.prizeMoney = prizeMoney;
        this.description = description;
    }

    public long getPrizeMoney() {
        return prizeMoney;
    }

    public String getDescription() {
        return description;
    }

    public static Ranking valueOf(int matchCount, boolean hasBonus) {
        if (matchCount == 6) return FIRST;
        if (matchCount == 5 && hasBonus) return SECOND;
        if (matchCount == 5) return THIRD;
        if (matchCount == 4) return FOURTH;
        if (matchCount == 3) return FIFTH;
        return NOTHING;
    }
}
