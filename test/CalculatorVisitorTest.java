import org.junit.jupiter.api.Assertions;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CalculatorVisitorTest {
    LinkedStack<Token> tokenStack;
    CalculatorVisitor calculatorVisitor = new CalculatorVisitor();


    @Test
    public void getResult() throws MalformedExpressionException {
        Assertions.assertThrows(MalformedExpressionException.class, () -> {
         
          calculatorVisitor.visit(new Operand(7));
          calculatorVisitor.visit(new Operator(Operation.rightRoundBrackets));
          calculatorVisitor.getResult();
        });
    }
}
