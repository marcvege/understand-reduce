import java.util.List;

import static org.apache.commons.lang.StringUtils.repeat;

public class Obfuscator {
    public String obfuscate(String data, List<String> masks) {
        return masks.stream()
                .reduce(data, (obfuscated, mask) -> obfuscated.replace(mask, repeat("*", mask.length())));
    }
}
