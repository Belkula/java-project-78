import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import hexlet.code.Validator;
import java.util.HashMap;  
import java.util.Map;  

class mapTest {

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
