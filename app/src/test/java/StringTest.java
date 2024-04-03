import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import hexlet.code.Validator;


class StringTest {

    @Test
    void testRequiredConstraint() {
        var val = new Validator();
		var str = val.string();
		
        assertTrue(str.required().isValid("hello"));
        assertFalse(str.required().isValid(""));
        assertFalse(str.required().isValid(null));
    }
	
    @Test
    void testMinLengthConstraint() {
        Validator val = new Validator();
        var str = val.string();

        assertTrue(str.minLength(3).isValid("hello"));
        assertFalse(str.minLength(9).isValid("hello"));
        assertTrue(str.minLength(0).isValid(""));
        assertFalse(str.minLength(0).isValid(null));
    }
	
	@Test
    void testContainsConstraint() {
        Validator validator = new Validator();
        var schema = validator.string();

        assertTrue(schema.contains("hell").isValid("hello"));
        assertFalse(schema.contains("abc").isValid("hello"));
    }

    @Test
    void testChainedConstraints() {
        Validator validator = new Validator();
        var schema = validator.string();

        assertFalse(schema.minLength(10).required().isValid("hello"));
        assertFalse(schema.minLength(5).required().isValid(null)); 
        assertTrue(schema.minLength(0).required().isValid("hello")); // Valid
        assertTrue(schema.minLength(2).required().contains("hell").isValid("hello"));
    }
}
