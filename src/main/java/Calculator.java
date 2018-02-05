import org.apache.commons.lang.StringUtils;

import java.util.ArrayList;
import java.util.List;

public class Calculator {
    public int sum(List<String> numbers) {
        return numbers.stream()
                .filter(StringUtils::isNumeric)
                .filter(StringUtils::isNotEmpty)
                .map(Integer::parseInt)
                .reduce((i1, i2) -> i1 + i2)
                .orElse(0);
    }

    public int multiply(ArrayList<String> numbers) {
        throw new UnsupportedOperationException();
    }
}
