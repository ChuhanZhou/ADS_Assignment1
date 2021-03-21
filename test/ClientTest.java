
import org.junit.Test;
import org.junit.jupiter.api.Assertions;

import java.net.MalformedURLException;
import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

public class ClientTest {
    Token token;
    CalculatorVisitor calculatorVisitor;
    Client client = new Client();

    @Test
    public void evaluateExpression() throws MalformedExpressionException {
        Assertions.assertThrows(MalformedExpressionException.class, () -> {
            ArrayList<Token> tokenList=new ArrayList<>();
            tokenList.add(new Operator(Operation.rightSquareBrackets));
            tokenList.add(new Operand(8));
            client.evaluateExpression(tokenList);
        });
    }

}
