import java.util.List;

public class Calculator {
    public int sum(List<String> numbers) {
        if (numbers.isEmpty())
            return 0;
        return Integer.parseInt(numbers.get(0));
    }
}
