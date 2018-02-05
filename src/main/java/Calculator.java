import org.apache.commons.lang.StringUtils;

import java.util.List;
import java.util.function.BinaryOperator;

public class Calculator {
    public int sum(List<String> numbers) {
        return apply(numbers, (i1, i2) -> i1 + i2);
    }

    public int multiply(List<String> numbers) {
        return apply(numbers, (i1, i2) -> i1 * i2);
    }

    private Integer apply(List<String> numbers, BinaryOperator<Integer> sum) {
        return numbers.stream()
                .filter(StringUtils::isNumeric)
                .filter(StringUtils::isNotEmpty)
                .map(Integer::parseInt)
                .reduce(sum)
                .orElse(0);
    }

}
