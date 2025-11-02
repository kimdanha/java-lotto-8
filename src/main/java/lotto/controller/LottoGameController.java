package lotto.controller;

import lotto.domain.*;
import lotto.dto.LottoDto;
import lotto.dto.LottoResultDto;
import lotto.service.LottoService;
import lotto.util.StringConverter;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.List;
import java.util.Map;

public class LottoGameController {

    private final LottoService lottoService;

    public LottoGameController(LottoService lottoService) {
        this.lottoService = lottoService;
    }

    public void run() {
        PurchaseAmount purchaseAmount = inputPurchaseAmount();

        List<Lotto> lottos = lottoService.buyLottos(purchaseAmount);
        OutputView.printPurchasedLottos(LottoDto.from(lottos));

        Lotto winningLotto = inputWinningLotto();

        BonusNumber bonusNumber = inputBonusNumber(winningLotto);

        Map<Ranking, Integer> result = lottoService.calculateWinningResult(lottos, winningLotto, bonusNumber);

        LottoResult lottoResult = new LottoResult(result, purchaseAmount);
        LottoResultDto dto = LottoResultDto.from(lottoResult);

        OutputView.printWinningResult(dto);
    }

    private PurchaseAmount inputPurchaseAmount() {
        while (true) {
            try {
                String input = InputView.inputPurchaseAmount();
                return new PurchaseAmount(Integer.parseInt(input));
            } catch (Exception e) {
                OutputView.printError(e.getMessage());
            }
        }
    }

    private Lotto inputWinningLotto() {
        while (true) {
            try {
                String input = InputView.inputWinningNumbers();
                System.out.println();
                return new Lotto(StringConverter.toIntList(input));
            } catch (Exception e) {
                OutputView.printError(e.getMessage());
            }
        }
    }

    private BonusNumber inputBonusNumber(Lotto winningLotto) {
        while (true) {
            try {
                String input = InputView.inputBonusNumber();
                return new BonusNumber(Integer.parseInt(input), winningLotto);
            } catch (Exception e) {
                OutputView.printError(e.getMessage());
            }
        }
    }
}
