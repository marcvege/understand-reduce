import java.util.List;
import java.util.function.BinaryOperator;

public class Obfuscator {
    public String obfuscate(String data, List<String> masks){
        BinaryOperator<String> function = new BinaryOperator<String>() {
            public String apply(String data, String mask) {
                return data.replace(mask, repeat('*', mask.length()));
            }

        };
        return masks.stream()
                .reduce(data, function);
    }

    private String repeat(char c, int length) {
        char[] repeated = new char[length];
        for (int i = 0; i < length; i++) {
            repeated[i] = c;
        }
        return String.valueOf(repeated);
    }
}
