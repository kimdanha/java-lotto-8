package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.Assertions.assertThat;

class PurchaseAmountTest {

    @DisplayName("구입 금액이 1,000원 단위가 아니면 예외가 발생한다.")
    @Test
    void 구입금액이_1000원단위가_아니면_예외() {
        assertThatThrownBy(() -> new PurchaseAmount(1500))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 구입 금액은 1,000원 단위여야 합니다.");
    }

    @DisplayName("구입 금액이 1,000원 미만이면 예외가 발생한다.")
    @Test
    void 구입금액이_1000원_미만이면_예외() {
        assertThatThrownBy(() -> new PurchaseAmount(500))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 구입 금액은 최소 1,000원 이상이어야 합니다.");
    }

    @DisplayName("구입 금액에 해당하는 로또 개수를 반환한다.")
    @Test
    void 티켓개수_반환() {
        PurchaseAmount amount = new PurchaseAmount(8000);
        assertThat(amount.getTicketCount()).isEqualTo(8);
    }
}
