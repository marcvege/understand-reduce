import org.apache.commons.lang.StringUtils;

import java.util.List;

public class Obfuscator {
    public String obfuscate(String data, List<String> masks) {
        return masks.stream()
                .reduce(data, (obfuscated, mask) -> obfuscated.replace(mask, StringUtils.repeat("*", mask.length())));
    }
}
