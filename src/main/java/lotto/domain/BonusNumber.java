package lotto.domain;

import lotto.config.ErrorMessage;
import lotto.config.LottoConfig;

public class BonusNumber {

    private final int number;

    public BonusNumber(int number, Lotto winningLotto) {
        validate(number, winningLotto);
        this.number = number;
    }

    private void validate(int number, Lotto winningLotto) {
        validateRange(number);
        validateDuplicate(number, winningLotto);
    }

    private void validateRange(int number) {
        if (number < LottoConfig.MIN_NUMBER || number > LottoConfig.MAX_NUMBER) {
            throw new IllegalArgumentException(ErrorMessage.BONUS_RANGE_ERROR.getMessage());
        }
    }

    private void validateDuplicate(int number, Lotto winningLotto) {
        if (winningLotto.contains(number)) {
            throw new IllegalArgumentException(ErrorMessage.BONUS_DUPLICATE_ERROR.getMessage());
        }
    }

    public int getNumber() {
        return number;
    }
}