package hexlet.code.schemas;

import java.util.Map;
import java.util.HashMap;
import java.util.function.Predicate;

public class MapSchema<K, V> extends BaseSchema<Map<K, V>> {

    private final Map<String, BaseSchema<?>> propertySchemas;

    public MapSchema() {
        this.propertySchemas = new HashMap<>();
    }

   /** Определяет что карта необходимого размера.
     *
     * @param size нужный размер карты
     * @return the MapSchema instance for method
     */
    public MapSchema<K, V> sizeof(int size) {
        Predicate<Map<K, V>> sizeConstraint = map -> map != null && map.size() == size;
        predicateList.add(sizeConstraint);
        return this;
    }

   /** Определяет что карта соответсвует необходимым параметрам.
     *
     * @param input проверяемая карта
     * @return the MapSchema instance for method
     */
    @Override
    public boolean isValid(Map<K, V> input) {
        for (Predicate<Map<K, V>> predicate : predicateList) {
            if (!predicate.test(input)) {
                return false;
            }
        }
        for (Map.Entry<String, BaseSchema<?>> entry : propertySchemas.entrySet()) {
            String propertyName = entry.getKey();
            BaseSchema<?> propertySchema = entry.getValue();
            Object propertyValue = input.get(propertyName);

            @SuppressWarnings("unchecked")
            boolean isValid = ((BaseSchema<Object>) propertySchema).isValid(propertyValue);

            if (!isValid) {
                return false;
            }
        }
        return true;
    }

   /** Определяет содержимое карты 
     *
     * @param schemas проверяемая карта
     * @return the MapSchema instance for method
     */
    public void shape(Map<String, BaseSchema<?>> schemas) {
        this.propertySchemas.clear();
        this.propertySchemas.putAll(schemas);
    }
}
