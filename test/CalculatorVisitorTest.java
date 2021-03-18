import org.junit.jupiter.api.Assertions;
import org.junit.Test;

public class CalculatorVisitorTest {
    LinkedStack<Token> tokenStack;
    CalculatorVisitor calculatorVisitor = new CalculatorVisitor();


    @Test
    void getResult() throws MalformedExpressionException {
        Assertions.assertThrows(MalformedExpressionException.class, () -> {
            LinkedStack<Token> resultStack = new LinkedStack<>();
            LinkedStack<Operator> bracketStack = new LinkedStack<>();

            while (!tokenStack.isEmpty()) {
                Token hard = tokenStack.pop();
                if (hard instanceof Operator) {
                    Operation hardOperation = ((Operator) hard).getOperation();
                    Operation.isBracket(hardOperation);
                    hardOperation = Operation.leftRoundBrackets;
                    bracketStack.isEmpty();
                    bracketStack.pop().getOperation().equals(Operation.rightRoundBrackets);

                } else {
                    Operation operation = bracketStack.pop().getOperation();
                    switch (operation) {
                        case Operation.rightRoundBrackets:
                            throw new MalformedExpressionException("Missing '" + Operation.leftRoundBrackets.toString() + "'.");
                        case Operation.rightSquareBrackets:
                            throw new MalformedExpressionException("Missing '" + Operation.leftSquareBrackets.toString() + "'.");
                        default:
                            throw new MalformedExpressionException("Error input '" + operation + "'.");
                    }
                }
            }
        });
    }
}
