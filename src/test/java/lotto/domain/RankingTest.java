package lotto.domain;

import lotto.domain.Ranking;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class RankingTest {

    @DisplayName("6개 번호 일치 시 1등")
    @Test
    void match6_isFirst() {
        assertThat(Ranking.valueOf(6, false)).isEqualTo(Ranking.FIRST);
    }

    @DisplayName("5개 번호 + 보너스 번호 일치 시 2등")
    @Test
    void match5_bonus_isSecond() {
        assertThat(Ranking.valueOf(5, true)).isEqualTo(Ranking.SECOND);
    }

    @DisplayName("5개 번호 일치 시 3등 (보너스 불일치)")
    @Test
    void match5_noBonus_isThird() {
        assertThat(Ranking.valueOf(5, false)).isEqualTo(Ranking.THIRD);
    }

    @DisplayName("4개 번호 일치 시 4등")
    @Test
    void match4_isFourth() {
        assertThat(Ranking.valueOf(4, false)).isEqualTo(Ranking.FOURTH);
    }

    @DisplayName("3개 번호 일치 시 5등")
    @Test
    void match3_isFifth() {
        assertThat(Ranking.valueOf(3, false)).isEqualTo(Ranking.FIFTH);
    }

    @DisplayName("0,1,2개 번호 일치 시 낙첨(NOTHING)")
    @Test
    void under3_isNothing() {
        assertThat(Ranking.valueOf(2, false)).isEqualTo(Ranking.NOTHING);
        assertThat(Ranking.valueOf(1, false)).isEqualTo(Ranking.NOTHING);
        assertThat(Ranking.valueOf(0, false)).isEqualTo(Ranking.NOTHING);
    }
}
