package lotto.util;

import lotto.config.ErrorMessage;

import java.util.Arrays;
import java.util.List;

public class StringConverter {

    public static List<Integer> toIntList(String input) {
        validateDelimiter(input);

        return Arrays.stream(input.split(","))
                .map(String::trim)
                .peek(StringConverter::validateNumber)
                .map(Integer::parseInt)
                .toList();
    }

    private static void validateDelimiter(String input) {
        if (!input.contains(",")) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_DELIMITER.getMessage());
        }
    }

    public static void validateNumber(String token) {
        if (!token.matches("\\d+")) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_NUMBER_INPUT.getMessage());
        }
    }
}
