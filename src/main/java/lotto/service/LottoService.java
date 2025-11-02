package lotto.service;

import lotto.domain.*;

import java.util.*;
import java.util.stream.Collectors;

public class LottoService {

    private final LottoGenerator lottoGenerator;

    public LottoService(LottoGenerator lottoGenerator) {
        this.lottoGenerator = lottoGenerator;
    }

    public List<Lotto> buyLottos(PurchaseAmount amount) {
        return java.util.stream.IntStream.range(0, amount.getTicketCount())
                .mapToObj(i -> lottoGenerator.generate())
                .collect(Collectors.toList());
    }

    public Map<Ranking, Integer> calculateWinningResult(
            List<Lotto> purchasedLottos,
            Lotto winningLotto,
            BonusNumber bonusNumber
    ) {
        Map<Ranking, Integer> result = initResultMap();

        for (Lotto lotto : purchasedLottos) {
            int match = winningLotto.countMatchingNumbers(lotto);
            boolean hasBonus = lotto.contains(bonusNumber.getNumber());

            Ranking ranking = Ranking.valueOf(match, hasBonus);
            result.put(ranking, result.get(ranking) + 1);
        }

        return result;
    }

    private Map<Ranking, Integer> initResultMap() {
        Map<Ranking, Integer> map = new EnumMap<>(Ranking.class);
        for (Ranking ranking : Ranking.values()) {
            map.put(ranking, 0);
        }
        return map;
    }
}
