import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class OperatorTest {
    Operation operation;
    Operator o = new Operator(operation);

    @Test
    public void getOperation() {
        assertEquals(operation, o.getOperation());
    }

}
