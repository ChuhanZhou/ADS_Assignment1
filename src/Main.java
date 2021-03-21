import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        String a = ")7+7)";
        char[] b = a.toCharArray();
        ArrayList<Token> tokenList = new ArrayList<>();
        for (int x=0;x<b.length;x++)
        {
            String value = ""+b[x];
            try {
                tokenList.add(new Operand(Integer.parseInt(value)));
                System.out.println(value);
            }
            catch (Exception e)
            {
                tokenList.add(new Operator(Operation.getOperation(value)));
                System.out.println(Operation.getOperation(value));
            }
        }
        Client client = new Client();
        try {
            System.out.println(client.evaluateExpression(tokenList));
        } catch (MalformedExpressionException e) {
            e.printStackTrace();
        }
    }
}

