import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.junit.jupiter.api.Assertions.*;

class CalculatorTest {
    private final Calculator calculator = new Calculator();

    @Test
    void return_0_when_sum_empty_list() {
        ArrayList<String> emptyList = new ArrayList<>();

        int sum = calculator.sum(emptyList);

        assertThat(sum, is(0));
    }

    @DisplayName("Positives cases")
    @ParameterizedTest(name = "\"{0}\" should be {1}")
    @CsvSource({"1, 1",
            "1|2,3",
            "A|B,0",
            "1|A|2,3",
            "1||2,3",
            "10|20|30|40, 100"})
    void sum_data(String packedNumbers, int expectedResult) {
        int sum = calculator.sum(getNumbers(packedNumbers));

        assertThat(sum, is(expectedResult));
    }

    @Test
    void return_0_when_multiply_empty_list() {
        ArrayList<String> emptyList = new ArrayList<>();

        int multiply = calculator.multiply(emptyList);

        assertThat(multiply, is(0));
    }

    @DisplayName("Positives cases")
    @ParameterizedTest(name = "\"{0}\" should be {1}")
    @CsvSource({"1, 1",
            "1|2,2",
            "A|B,0",
            "1|A|2,2",
            "1||2,2",
            "10|20|1, 200"})
    void multiply_data(String packedNumbers, int expectedResult) {
        int multiply = calculator.multiply(getNumbers(packedNumbers));

        assertThat(multiply, is(expectedResult));
    }

    private List<String> getNumbers(String packedNumbers) {
        return Arrays.asList(packedNumbers.split("\\|"));
    }
}