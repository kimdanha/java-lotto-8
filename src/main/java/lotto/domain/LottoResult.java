package lotto.domain;

import java.util.Map;

public class LottoResult {

    private final Map<Ranking, Integer> rankingCount;
    private final double profitRate;

    public LottoResult(Map<Ranking, Integer> rankingCount, PurchaseAmount amount) {
        this.rankingCount = rankingCount;
        this.profitRate = calculateProfitRate(amount);
    }

    public Map<Ranking, Integer> getRankingCount() {
        return rankingCount;
    }

    public double getProfitRate() {
        return profitRate;
    }

    private double calculateProfitRate(PurchaseAmount amount) {
        long totalWinningMoney = rankingCount.entrySet().stream()
                .mapToLong(e -> e.getKey().getPrizeMoney() * e.getValue())
                .sum();

        double rate = (double) totalWinningMoney / (amount.getTicketCount() * 1000) * 100;
        return Math.round(rate * 10.0) / 10.0;
    }
}
