import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import hexlet.code.Validator;
import hexlet.code.schemas.StringSchema;
import hexlet.code.schemas.NumberSchema;
import hexlet.code.schemas.MapSchema;
import java.util.HashMap;  
import java.util.Map;  

class appTest {

    @Test
    void testRequiredstrConstraint() {
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
    }
	
	@Test
    void testContainsConstraint() {
        Validator val = new Validator();
        var str = val.string();

        assertTrue(str.contains("hell").isValid("hello"));
        assertFalse(str.contains("abc").isValid("hello"));
    }

    @Test
    void testChainedstrConstraints() {
        Validator val = new Validator();
        var str = val.string();

        assertFalse(str.minLength(10).required().isValid("hello"));
        assertFalse(str.minLength(11).contains("hell").isValid("hello")); 
    }
	
	
    @Test
    void testRequirednumConstraint() {
        var val = new Validator();
		var num = val.number();
		
        assertTrue(num.required().isValid(22));
        assertFalse(num.required().isValid(null));
    }
	
    @Test
    void testpositiveConstraint() {
        Validator val = new Validator();
        var num = val.number();

        assertTrue(num.positive().isValid(1));
        assertFalse(num.positive().isValid(-1));
        assertFalse(num.positive().isValid(0));
    }
	
	@Test
    void testrangeConstraint() {
        Validator val = new Validator();
        var num = val.number();

        assertTrue(num.range(10,20).isValid(15));
        assertFalse(num.isValid(5));
    }

    @Test
    void testChainednumConstraints() {
        Validator val = new Validator();
        var num = val.number();
		assertTrue(num.range(-1,1).required().isValid(0));
        assertFalse(num.range(-1,1).required().isValid(null)); 
		assertFalse(num.positive().required().isValid(-6));

    }
	
    @Test
    public void testMapSchema() {
        Validator validator = new Validator();
        var schema = validator.map();

        assertTrue(schema.isValid(null)); 

        schema.required();
        assertFalse(schema.isValid(null));
        assertTrue(schema.isValid(new HashMap<>()));

        HashMap<String, String> data = new HashMap<>();
        data.put("key1", "value1");
        assertTrue(schema.isValid(data));

        schema.sizeof(2);
        assertFalse(schema.isValid(data));

        data.put("key2", "value2");
        assertTrue(schema.isValid(data)); 
    }
}