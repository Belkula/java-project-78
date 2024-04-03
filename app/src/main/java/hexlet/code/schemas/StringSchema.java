package hexlet.code.schemas;
import java.util.function.Predicate;

public class StringSchema extends BaseSchema<String> {

    public StringSchema minLength(int length) {
        Predicate<String> minlen = (input) -> input.length() < length;
        predicateList.add(minlen);
        return this;
    }

    public StringSchema contains(String substring) {
        Predicate<String> sublen = (input) -> input.contains(substring);
        predicateList.add(sublen);
        return this;
    }

    @Override
    public boolean isValid(String input) {
        return super.isValid(input);
    }
}
