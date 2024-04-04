package hexlet.code.schemas;
import java.util.List;
import java.util.ArrayList;
import java.util.function.Predicate;

public abstract class BaseSchema<T> {
    List<Predicate<T>> predicateList = new ArrayList<>();
	
	public BaseSchema<T> required() {
		Predicate<T> req = input -> input != null;
		predicateList.add(req);
		return this;
	}
	

    public boolean isValid(T input) {
        for (Predicate<T> predicate : predicateList) {
            if (!predicate.test(input)) {
                return false;
            }
        }
        return true;
    }
}