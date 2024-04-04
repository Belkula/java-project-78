package hexlet.code.schemas;

import java.util.Map;
import java.util.function.Predicate;

public class MapSchema<K, V> extends BaseSchema<Map<K, V>> {

    public MapSchema<K, V> sizeof(int size) {
        Predicate<Map<K, V>> sizeConstraint = map -> map != null && map.size() == size;
        predicateList.add(sizeConstraint);
        return this;
    }

    @Override
    public boolean isValid(Map<K, V> input) {
        return super.isValid(input);
    }
}
