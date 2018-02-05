import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.junit.jupiter.api.Assertions.*;

class CalculatorTest {
    private final Calculator calculator = new Calculator();

    @DisplayName("Positives cases")
    @ParameterizedTest(name = "\"{0}\" should be {1}")
    @CsvSource({"1, 1",
            "1|2,3",
            "10|20|30|40, 100"})
    void mask_data(String packedNumbers, int expectedResult) {
        int sum = calculator.sum(getNumbers(packedNumbers));

        assertThat(sum, is(expectedResult));
    }

    private List<String> getNumbers(String packedNumbers) {
        return Arrays.asList(packedNumbers.split("\\|"));
    }
}