package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class LottoGeneratorTest {

    @DisplayName("LottoGenerator는 6개의 정렬된 고유 번호로 이루어진 Lotto를 생성한다.")
    @Test
    void generate_lotto_success() {
        LottoGenerator generator = new LottoGenerator();
        Lotto lotto = generator.generate();

        List<Integer> numbers = lotto.getNumbers();

        assertThat(numbers).hasSize(6);

        assertThat(numbers).isSorted();

        assertThat(numbers).doesNotHaveDuplicates();
        assertThat(numbers).allMatch(n -> n >= 1 && n <= 45);
    }
}
