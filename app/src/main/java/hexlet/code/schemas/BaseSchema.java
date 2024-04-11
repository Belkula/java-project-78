package hexlet.code.schemas;
import java.util.List;
import java.util.ArrayList;
import java.util.function.Predicate;

public abstract class BaseSchema<T> {
    protected final List<Predicate<T>> predicateList = new ArrayList<>();

   /** Определяет содержимое не нулевое карты.
     *
     * @return the BaseSchema instance for method
     */
    public BaseSchema<T> required() {
        Predicate<T> req = input -> input != null;
        predicateList.add(req);
        return this;
    }

   /** Определяет соответствует ли карта нужным параметрам
     *
     * @param input проверяемая карта
     * @return true if the map satisfies all predicates, false otherwise
     */
    public boolean isValid(T input) {
        for (Predicate<T> predicate : predicateList) {
            if (!predicate.test(input)) {
                return false;
            }
        }
        return true;
    }
}
