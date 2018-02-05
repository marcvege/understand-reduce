import org.apache.commons.lang.StringUtils;

import java.util.List;

public class Calculator {
    public int sum(List<String> numbers) {
        return numbers.stream()
                .filter(StringUtils::isNumeric)
                .map(Integer::parseInt)
                .reduce((i1, i2) -> i1 + i2)
                .orElse(0);
    }
}
