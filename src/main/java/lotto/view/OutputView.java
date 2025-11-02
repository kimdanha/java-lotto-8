package lotto.view;

import lotto.dto.LottoDto;
import lotto.dto.LottoResultDto;
import lotto.domain.Ranking;

import java.util.List;
import java.util.Map;

public class OutputView {

    public static void printPurchasedLottos(List<LottoDto> lottos) {
        System.out.println();
        System.out.printf("%d개를 구매했습니다.%n", lottos.size());
        lottos.forEach(lotto -> System.out.println(lotto.getNumbers()));
        System.out.println();
    }

    public static void printWinningResult(LottoResultDto resultDto) {
        System.out.println();

        System.out.println("당첨 통계");
        System.out.println("---");

        Map<Ranking, Integer> rankingCount = resultDto.getRankingCount();

        Ranking[] printOrder = {
                Ranking.FIFTH,
                Ranking.FOURTH,
                Ranking.THIRD,
                Ranking.SECOND,
                Ranking.FIRST
        };

        for (Ranking rank : printOrder) {
            System.out.printf(
                    "%s (%s원) - %d개%n",
                    rank.getDescription(),
                    String.format("%,d", rank.getPrizeMoney()),
                    rankingCount.getOrDefault(rank, 0)
            );
        }

        System.out.printf("총 수익률은 %.1f%%%s%n",
                resultDto.getProfitRate(),
                "입니다.");
    }

    public static void printError(String message) {
        System.out.println(message);
    }
}
