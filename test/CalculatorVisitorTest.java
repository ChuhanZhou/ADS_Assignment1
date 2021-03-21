import org.junit.jupiter.api.Assertions;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CalculatorVisitorTest {
    LinkedStack<Token> tokenStack;
    CalculatorVisitor calculatorVisitor = new CalculatorVisitor();


    @Test
    public void getResult() throws MalformedExpressionException {
        Assertions.assertThrows(MalformedExpressionException.class, () -> {
          LinkedStack<Operator> bracketStack = new LinkedStack<>();
          Operation operation = bracketStack.pop().getOperation();
          operation = Operation.rightSquareBrackets;
          calculatorVisitor.getResult();
        });
    }
}
