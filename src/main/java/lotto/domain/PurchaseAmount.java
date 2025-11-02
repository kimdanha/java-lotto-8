package lotto.domain;

import lotto.config.ErrorMessage;

public class PurchaseAmount {

    private final int amount;

    public PurchaseAmount(int amount) {
        validate(amount);
        this.amount = amount;
    }

    private void validate(int amount) {
        validateMinimum(amount);
        validateUnit(amount);
    }

    private void validateMinimum(int amount) {
        if (amount < 1000) {
            throw new IllegalArgumentException(ErrorMessage.PURCHASE_MIN_ERROR.getMessage());
        }
    }

    private void validateUnit(int amount) {
        if (amount % 1000 != 0) {
            throw new IllegalArgumentException(ErrorMessage.PURCHASE_UNIT_ERROR.getMessage());
        }
    }

    public int getTicketCount() {
        return amount / 1000;
    }
}
