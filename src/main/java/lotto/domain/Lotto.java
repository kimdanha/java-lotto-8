package lotto.domain;

import lotto.config.ErrorMessage;
import lotto.config.LottoConfig;

import java.util.HashSet;
import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        validateSize(numbers);
        validateDuplicate(numbers);
        validateRange(numbers);
    }

    private void validateSize(List<Integer> numbers) {
        if (numbers.size() != LottoConfig.LOTTO_SIZE) {
            throw new IllegalArgumentException(ErrorMessage.LOTTO_SIZE_ERROR.getMessage());
        }
    }

    private void validateDuplicate(List<Integer> numbers) {
        if (new HashSet<>(numbers).size() != numbers.size()) {
            throw new IllegalArgumentException(ErrorMessage.LOTTO_DUPLICATE_ERROR.getMessage());
        }
    }

    private void validateRange(List<Integer> numbers) {
        boolean isOutOfRange = numbers.stream()
                .anyMatch(num -> num < LottoConfig.MIN_NUMBER || num > LottoConfig.MAX_NUMBER);

        if (isOutOfRange) {
            throw new IllegalArgumentException(ErrorMessage.LOTTO_RANGE_ERROR.getMessage());
        }
    }

    public boolean contains(int number) {
        return numbers.contains(number);
    }

    public int countMatchingNumbers(Lotto other) {
        return (int) numbers.stream()
                .filter(other::contains)
                .count();
    }

    public List<Integer> getNumbers() {
        return List.copyOf(numbers);
    }
}
