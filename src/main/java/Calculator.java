import java.util.List;

public class Calculator {
    public int sum(List<String> numbers) {
        if (numbers.isEmpty())
            return 0;
        return numbers.stream()
                .map(Integer::parseInt)
                .reduce((i1, i2) -> i1 + i2)
                .orElse(0);

    }
}
