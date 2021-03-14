import java.util.ArrayList;

public class Client {
    private Token token;
    private CalculatorVisitor calculatorVisitor;

    public Client()
    {
        calculatorVisitor = new CalculatorVisitor();
    }

    public int evaluateExpression(ArrayList<Token> tokenList) throws MalformedExpressionException {
        for (int i=0;i<tokenList.size();i++)
        {
            tokenList.get(i).accept(calculatorVisitor);
        }
        return calculatorVisitor.getResult();
    }
}
