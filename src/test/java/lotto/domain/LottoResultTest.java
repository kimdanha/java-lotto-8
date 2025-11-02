package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.EnumMap;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

class LottoResultTest {

    @DisplayName("총 수익률을 올바르게 계산한다")
    @Test
    void calculateProfitRate_success() {

        Map<Ranking, Integer> counts = new EnumMap<>(Ranking.class);
        for (Ranking r : Ranking.values()) {
            counts.put(r, 0);
        }

        counts.put(Ranking.FIRST, 1);
        counts.put(Ranking.THIRD, 1);

        PurchaseAmount amount = new PurchaseAmount(10000);
        LottoResult result = new LottoResult(counts, amount);

        double expected = ((2_000_000_000L + 1_500_000L) / 10000.0) * 100;
        expected = Math.round(expected * 10.0) / 10.0;

        assertThat(result.getProfitRate()).isEqualTo(expected);
    }
}
