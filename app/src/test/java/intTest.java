import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import hexlet.code.Validator;


class IntTest {

    @Test
    void testRequiredConstraint() {
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
    void testChainedConstraints() {
        Validator val = new Validator();
        var num = val.number();
		assertTrue(num.range(-1,1).required().isValid(0));
        assertFalse(num.range(-1,1).required().isValid(null)); 
		assertFalse(num.positive().required().isValid(-6));

    }
}
