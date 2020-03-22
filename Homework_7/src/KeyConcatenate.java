import java.util.HashMap;
import java.util.Map;

public class KeyConcatenate {
    public static <K, V> String concatenate(Map<K, V> map) {
        String str = map.keySet().stream().map(Object::toString).reduce((a, b) -> {
            return a + b;
        }).get();
        return str;
    }
}