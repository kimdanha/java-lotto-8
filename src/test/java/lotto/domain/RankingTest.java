package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class RankingTest {

    @DisplayName("일치 개수와 보너스 여부에 따라 올바른 Ranking을 반환한다.")
    @Test
    void valueOf_등수반환() {
        assertThat(Ranking.valueOf(6, false)).isEqualTo(Ranking.FIRST);
        assertThat(Ranking.valueOf(5, true)).isEqualTo(Ranking.SECOND);
        assertThat(Ranking.valueOf(5, false)).isEqualTo(Ranking.THIRD);
        assertThat(Ranking.valueOf(4, false)).isEqualTo(Ranking.FOURTH);
        assertThat(Ranking.valueOf(3, false)).isEqualTo(Ranking.FIFTH);
    }

    @DisplayName("3개 미만 일치하면 NOTHING을 반환한다.")
    @Test
    void valueOf_NOTHING_반환() {
        assertThat(Ranking.valueOf(2, false)).isEqualTo(Ranking.NOTHING);
        assertThat(Ranking.valueOf(1, false)).isEqualTo(Ranking.NOTHING);
        assertThat(Ranking.valueOf(0, false)).isEqualTo(Ranking.NOTHING);
    }

    @DisplayName("상금과 설명 정보를 정상적으로 가져온다.")
    @Test
    void prizeMoney_및_설명_확인() {
        assertThat(Ranking.FIRST.getPrizeMoney()).isEqualTo(2_000_000_000);
        assertThat(Ranking.SECOND.getPrizeMoney()).isEqualTo(30_000_000);
        assertThat(Ranking.THIRD.getPrizeMoney()).isEqualTo(1_500_000);
        assertThat(Ranking.FOURTH.getPrizeMoney()).isEqualTo(50_000);
        assertThat(Ranking.FIFTH.getPrizeMoney()).isEqualTo(5_000);
    }
}
