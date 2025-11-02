package lotto.service;

import lotto.domain.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

class LottoServiceTest {

    private final LottoService lottoService = new LottoService(new LottoGenerator());

    @DisplayName("구입 금액만큼 로또를 발행한다")
    @Test
    void buyLottos_success() {
        PurchaseAmount amount = new PurchaseAmount(5000);
        List<Lotto> lottos = lottoService.buyLottos(amount);

        assertThat(lottos).hasSize(amount.getTicketCount());
        assertThat(lottos).allMatch(lotto -> lotto.getNumbers().size() == 6);
    }

    @DisplayName("구매한 로또와 당첨 정보를 통해 당첨 결과를 계산한다")
    @Test
    void calculateWinningResult_success() {

        List<Lotto> purchasedLottos = List.of(
                new Lotto(List.of(1,2,3,4,5,6)),   // 1등
                new Lotto(List.of(1,2,3,4,5,7)),   // 2등 (5개 + 보너스)
                new Lotto(List.of(1,2,3,4,5,8)),   // 3등
                new Lotto(List.of(1,2,3,4,8,9)),   // 4등
                new Lotto(List.of(1,2,3,10,11,12)),// 5등
                new Lotto(List.of(40,41,42,43,44,45)) // 낙첨
        );

        Lotto winningLotto = new Lotto(List.of(1,2,3,4,5,6));
        BonusNumber bonus = new BonusNumber(7, winningLotto);

        Map<Ranking, Integer> result = lottoService.calculateWinningResult(
                purchasedLottos,
                winningLotto,
                bonus
        );

        assertThat(result.get(Ranking.FIRST)).isEqualTo(1);
        assertThat(result.get(Ranking.THIRD)).isEqualTo(1);
        assertThat(result.get(Ranking.FOURTH)).isEqualTo(1);
        assertThat(result.get(Ranking.FIFTH)).isEqualTo(1);
        assertThat(result.get(Ranking.NOTHING)).isEqualTo(1);
    }
}
