package lotto.util;

import lotto.config.ErrorMessage;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class StringConverterTest {

    @DisplayName("쉼표로 구분된 숫자 문자열을 정수 리스트로 변환한다")
    @Test
    void convert_valid_input() {
        List<Integer> result = StringConverter.toIntList("1,2,3");
        assertThat(result).containsExactly(1, 2, 3);
    }

    @DisplayName("숫자가 아닌 값이 존재하면 예외가 발생한다")
    @Test
    void convert_invalid_not_number() {
        assertThatThrownBy(() -> StringConverter.toIntList("1,a,3"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ErrorMessage.INVALID_NUMBER_INPUT.getMessage());
    }

    @DisplayName("쉼표로 구분되지 않은 입력은 예외가 발생한다")
    @Test
    void convert_invalid_no_comma() {
        assertThatThrownBy(() -> StringConverter.toIntList("123"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ErrorMessage.INVALID_DELIMITER.getMessage());
    }
}
