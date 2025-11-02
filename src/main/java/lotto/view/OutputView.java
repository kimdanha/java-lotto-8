package lotto.view;

import lotto.dto.LottoDto;
import lotto.dto.LottoResultDto;
import lotto.domain.Ranking;

import java.util.List;
import java.util.Map;

public class OutputView {

    public static void printPurchasedLottos(List<LottoDto> lottos) {
        System.out.printf("%d개를 구매했습니다.%n", lottos.size());
        lottos.forEach(lotto -> System.out.println(lotto.getNumbers()));
    }

    public static void printWinningResult(LottoResultDto resultDto) {
        System.out.println("당첨 통계");
        System.out.println("---");

        Map<Ranking, Integer> rankingCount = resultDto.getRankingCount();

        for (Ranking rank : Ranking.values()) {
            if (rank.isNothing()) continue;
            System.out.printf(
                    "%s - %d개%n",
                    rank.getDescription(),
                    rankingCount.getOrDefault(rank, 0)
            );
        }

        System.out.printf(
                "총 수익률은 %.1f%%입니다.%n",
                resultDto.getProfitRate()
        );
    }

    public static void printError(String message) {
        System.out.println(message);
    }
}
