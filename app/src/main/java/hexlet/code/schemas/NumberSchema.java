package hexlet.code.schemas;
import java.util.function.Predicate;

public class NumberSchema extends BaseSchema<Integer> {

    @Override
    public NumberSchema required() {
        Predicate<Integer> req = input ->  input instanceof Integer && input > 0;
        predicateList.add(req);
        return this;
    }

    public NumberSchema positive() {
        Predicate<Integer> positive = (input) -> input != null && input > 0;
        predicateList.add(positive);
        return this;
    }

    public NumberSchema range(int min, int max) {
        Predicate<Integer> range = (input) -> input != null && input >= min && input <= max;
        predicateList.add(range);
        return this;
    }

    @Override
    public boolean isValid(Integer input) {
        return super.isValid(input);
    }
}
