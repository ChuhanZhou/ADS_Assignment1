public enum Operation {

    plus("+"),
    minus("-"),
    multiple("*"),
    divide("/"),
    leftRoundBrackets("("),
    rightRoundBrackets(")"),
    leftSquareBrackets("["),
    rightSquareBrackets("]");

    private String value;

    Operation(String s) {
        value = s;
    }

    public static Operation getOperation(String s) {
        switch (s) {
            case "+":
                return Operation.plus;
            case "-":
                return Operation.minus;
            case "*":
                return Operation.multiple;
            case "/":
                return Operation.divide;
            case "(":
                return Operation.leftRoundBrackets;
            case ")":
                return Operation.rightRoundBrackets;
            case "[":
                return Operation.leftSquareBrackets;
            case "]":
                return Operation.rightSquareBrackets;
            default:
                return null;
        }
    }

    public static boolean isBracket(Operation operation) {
        return operation == leftRoundBrackets || operation == rightRoundBrackets || operation == leftSquareBrackets || operation == rightSquareBrackets;
    }

    @Override
    public String toString() {
        return value;
    }
}
