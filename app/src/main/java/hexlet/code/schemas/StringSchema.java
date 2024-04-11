package hexlet.code.schemas;
import java.util.function.Predicate;

public class StringSchema extends BaseSchema<String> {
    private Integer min;

   /** Определяет что значение должно быть не нулевым.
     *
     * @return the StringSchema instance for method
     */
    @Override
    public StringSchema required() {
        Predicate<String> req = input ->  input instanceof String &&  ((String) input).length() > 0;
        predicateList.add(req);
        return this;
    }

   /** Определяет что строка длиннее или ровна минимальной длинне.
     *
     * @param length минимальная длинна строки
     * @return the StringSchema instance for method
     */
    public StringSchema minLength(int length) {
        min = length;
        Predicate<String> minlen = (input) -> ((String) input).length() >= min;
        predicateList.add(minlen);
        return this;
    }

   /** Определяет что строка содержит указанную подстроку.
     *
     * @param substring подстрока
     * @return the StringSchema instance for method
     */
    public StringSchema contains(String substring) {
        Predicate<String> substr = (input) ->  ((String) input).contains(substring);
        predicateList.add(substr);
        return this;
    }
}
