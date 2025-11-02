package lotto;

import lotto.controller.LottoGameController;
import lotto.service.LottoService;
import lotto.domain.LottoGenerator;

public class Application {
    public static void main(String[] args) {
        LottoService lottoService = new LottoService(new LottoGenerator());
        LottoGameController controller = new LottoGameController(lottoService);
        controller.run();
    }
}
