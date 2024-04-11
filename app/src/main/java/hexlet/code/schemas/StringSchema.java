package hexlet.code.schemas;
import java.util.function.Predicate;

public class StringSchema extends BaseSchema<String> {

    @Override
    public StringSchema required() {
        Predicate<String> req = input ->  input instanceof String &&  input.length() > 0;
        predicateList.add(req);
        return this;
    }
    public StringSchema minLength(int length) {
        Predicate<String> minlen = (input) -> input.length() >= length && input.length() > 0;
        predicateList.add(minlen);
        return this;
    }

    public StringSchema contains(String substring) {
        Predicate<String> substr = (input) ->  input == null || input.contains(substring);
        predicateList.add(substr);
        return this;
    }

    @Override
    public boolean isValid(String input) {
        return super.isValid(input);
    }
}
