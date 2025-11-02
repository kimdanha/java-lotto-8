package lotto.config;

public enum ErrorMessage {

    LOTTO_SIZE_ERROR("[ERROR] 로또 번호는 6개여야 합니다."),
    LOTTO_DUPLICATE_ERROR("[ERROR] 로또 번호는 중복될 수 없습니다."),
    LOTTO_RANGE_ERROR("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다."),

    PURCHASE_UNIT_ERROR("[ERROR] 구입 금액은 1,000원 단위여야 합니다."),
    PURCHASE_MIN_ERROR("[ERROR] 구입 금액은 최소 1,000원 이상이어야 합니다."),

    BONUS_RANGE_ERROR("[ERROR] 보너스 번호는 1부터 45 사이의 숫자여야 합니다."),
    BONUS_DUPLICATE_ERROR("[ERROR] 보너스 번호는 당첨 번호와 중복될 수 없습니다."),

    INVALID_NUMBER_INPUT("[ERROR] 입력값은 숫자여야 합니다."),
    INVALID_DELIMITER("[ERROR] 숫자는 쉼표(,)로 구분해야 합니다.");

    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
