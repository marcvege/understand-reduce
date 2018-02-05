import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

class ObfuscatorTest {

    private final Obfuscator obfuscator = new Obfuscator();

    @DisplayName("Positives cases")
    @ParameterizedTest(name = "\"{0}\" should be {1}")
    @CsvSource({"param1:data1, data1, param1:*****",
            "param1:data1, param2:data2, param3:data3, data1|data3, param1:*****, param2:data2, param3:*****"})
    void mask_data(String dataToMask, String packedMasks, String dataExpected) {
        String dataMasked = obfuscator.obfuscate(dataToMask, getMasks(packedMasks));

        assertThat(dataMasked, is(dataExpected));
    }

    private List<String> getMasks(String packedMasks) {
        return Arrays.asList(packedMasks.split("\\|"));
    }
}