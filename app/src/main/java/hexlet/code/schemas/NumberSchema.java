package hexlet.code.schemas;
import java.util.function.Predicate;
import java.util.Objects;

public class NumberSchema extends BaseSchema<Integer> {

   /** Определяет что число должно быть не нулевым.
     *
     * @return the NumberSchema instance for method
     */
    @Override
    public NumberSchema required() {
        Predicate<Integer> req = input ->  input instanceof Integer && !Objects.isNull(input);
        predicateList.add(req);
        return this;
    }

   /** Определяет что число должно быть положительным.
     *
     * @return the NumberSchema instance for method
     */
    public NumberSchema positive() {
        Predicate<Integer> positive = (input) -> input == null || input > 0;
        predicateList.add(positive);
        return this;
    }

   /** Определяет что число находится в диапазоне.
     *
     * @param min минимальное значение
     * @param max максимальное значение
     * @return the NumberSchema instance for method
     */
    public NumberSchema range(int min, int max) {
        Predicate<Integer> range = (input) -> input != null && input >= min && input <= max;
        predicateList.add(range);
        return this;
    }
}
