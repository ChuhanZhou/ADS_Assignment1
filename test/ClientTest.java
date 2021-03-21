
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
            ArrayList<Token> tokenList =new ArrayList<Token>();
            tokenList.add(token);

            assertEquals(1,client.evaluateExpression(tokenList));
        });
    }

}
