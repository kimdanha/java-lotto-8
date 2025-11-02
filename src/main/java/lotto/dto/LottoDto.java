package lotto.dto;

import lotto.domain.Lotto;

import java.util.List;

public class LottoDto {

    private final List<Integer> numbers;

    public LottoDto(List<Integer> numbers) {
        this.numbers = numbers;
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    public static List<LottoDto> from(List<Lotto> lottos) {
        return lottos.stream()
                .map(lotto -> new LottoDto(lotto.getNumbers()))
                .toList();
    }
}
