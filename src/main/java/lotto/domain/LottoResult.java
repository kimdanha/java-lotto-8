package lotto.domain;

import java.util.Map;

public class LottoResult {

    private final Map<Ranking, Integer> resultMap;

    public LottoResult(Map<Ranking, Integer> resultMap) {
        this.resultMap = resultMap;
    }

    public long getTotalPrize() {
        return resultMap.entrySet().stream()
                .mapToLong(entry -> entry.getKey().getPrizeMoney() * entry.getValue())
                .sum();
    }

    public double calculateProfitRate(PurchaseAmount amount) {
        long totalPrize = getTotalPrize();
        double spent = amount.getValue();
        return (totalPrize / spent) * 100;
    }
}
