package lotto.dto;

import lotto.domain.Ranking;
import java.util.Map;

public class LottoResultDto {

    private final Map<Ranking, Integer> rankingCount;
    private final double profitRate;

    public LottoResultDto(Map<Ranking, Integer> rankingCount, double profitRate) {
        this.rankingCount = rankingCount;
        this.profitRate = profitRate;
    }

    public Map<Ranking, Integer> getRankingCount() {
        return rankingCount;
    }

    public double getProfitRate() {
        return profitRate;
    }
}