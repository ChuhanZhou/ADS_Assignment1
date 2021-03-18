
import org.junit.Test;
import org.junit.jupiter.api.Assertions;

import java.net.MalformedURLException;
import java.util.ArrayList;

public class ClientTest {
    Token token;
    CalculatorVisitor calculatorVisitor;
    Client client = new Client();

    @Test
    public void evaluateExpression() throws MalformedExpressionException {
        Assertions.assertThrows(MalformedExpressionException.class, () -> {
            ArrayList<Token> tokenList = null;
            for (int i = 0; i < tokenList.size(); i++) {
                tokenList.get(i).accept(calculatorVisitor);
            }
            calculatorVisitor.getResult();
        });
    }

}
