import java.util.ArrayList;

public class CalculatorVisitor implements Visitor,Calculator{

    private LinkedStack<Token> tokenStack;

    public CalculatorVisitor()
    {
        tokenStack = new LinkedStack<>();
    }

    private void pushOperand(Operand operand)
    {
        tokenStack.push(operand);
    }

    private void performOperation(Operator operator) throws MalformedExpressionException {
        Token head = tokenStack.pop();
        tokenStack.push(head);
        switch (operator.getOperation())
        {
            case plus:
            case minus:
            case multiple:
            case divide:
                if (head instanceof Operator)
                {
                    if (((Operator) head).getOperation()!=Operation.rightRoundBrackets&&((Operator) head).getOperation()!=Operation.rightSquareBrackets)
                    throw new  MalformedExpressionException("The '" + operator.getOperation().toString() + "' can't after '" + ((Operator) head).getOperation().toString()+"'.");
                }
                break;
            case leftRoundBrackets:
            case leftSquareBrackets:
                if (head instanceof Operand)
                {
                    throw new  MalformedExpressionException("The '" + operator.getOperation().toString() + "' can't after '" + ((Operand) head).getValue()+"'.");
                }
                break;
            case rightRoundBrackets:
            case rightSquareBrackets:
                if (head instanceof Operator)
                {
                    if (!Operation.isBracket(((Operator) head).getOperation()))
                    {
                        throw new  MalformedExpressionException("The '" + operator.getOperation().toString() + "' can't after '" + ((Operator) head).getOperation().toString()+"'.");
                    }
                }
                break;
        }
        tokenStack.push(operator);
    }

    private static Operand noBracketCalculate(LinkedStack<Token> reverseOrderTokenStack) throws MalformedExpressionException {
        //Calculate multiplication and division
        LinkedStack<Token> resultStack = new LinkedStack<>(); //positive order
        while (!reverseOrderTokenStack.isEmpty())
        {
            Token hard = reverseOrderTokenStack.pop();
            int a = 1;
            int b = 1;
            if (hard instanceof Operator)
            {
                Operation hardOperation = ((Operator) hard).getOperation();
                if (resultStack.isEmpty())
                {
                    throw new  MalformedExpressionException("Missing number after '" + hardOperation.toString() + "'.");
                }
                a = ((Operand) reverseOrderTokenStack.pop()).getValue();
                switch (hardOperation)
                {
                    case plus:
                    case minus:
                        resultStack.push(hard);
                        break;
                    case multiple:
                        b = ((Operand)resultStack.pop()).getValue();
                        System.out.print(a + "*" + b + "=");
                        a = a * b;
                        System.out.println(a);
                        break;
                    case divide:
                        b = ((Operand)resultStack.pop()).getValue();
                        System.out.print(a + "/" + b + "=");
                        a = a / b;
                        System.out.println(a);
                        break;
                    default:
                        throw new  MalformedExpressionException("Wrong operation of '" + hardOperation.toString() + "'.");
                }
                resultStack.push(new Operand(a));
            }
            else if (hard instanceof Operand)
            {
                resultStack.push(hard);
            }
        }
        //Calculate addition and subtraction
        reverseOrderTokenStack = resultStack; //positive order
        resultStack = new LinkedStack<>(); //reverse order
        while (!reverseOrderTokenStack.isEmpty())
        {
            Token hard = reverseOrderTokenStack.pop();
            int a = 0;
            int b = 0;
            if (hard instanceof Operator)
            {
                Operation hardOperation = ((Operator) hard).getOperation();
                a = ((Operand) resultStack.pop()).getValue();
                b = ((Operand) reverseOrderTokenStack.pop()).getValue();
                switch (hardOperation)
                {
                    case plus:
                        System.out.print(a + "+" + b + "=");
                        a = a + b;
                        System.out.println(a);
                        break;
                    case minus:
                        System.out.print(a + "-" + b + "=");
                        a = a - b;
                        System.out.println(a);
                        break;
                    default:
                        throw new  MalformedExpressionException("Wrong operation of '" + hardOperation.toString() + "'.");
                }
                resultStack.push(new Operand(a));
            }
            else if (hard instanceof Operand)
            {
                resultStack.push(hard);
            }
        }
        return (Operand) resultStack.pop();
    }

    @Override
    public int getResult() throws MalformedExpressionException {
        LinkedStack<Token> resultStack = new LinkedStack<>(); //positive order
        LinkedStack<Operator> bracketStack = new LinkedStack<>();

        //remove bracket
        while (!tokenStack.isEmpty())
        {
            Token hard = tokenStack.pop();
            if (hard instanceof Operator)
            {
                Operation hardOperation = ((Operator) hard).getOperation();
                if (Operation.isBracket(hardOperation))
                {
                    if (hardOperation==Operation.leftRoundBrackets)
                    {
                        if (bracketStack.isEmpty()||bracketStack.pop().getOperation()!=Operation.rightRoundBrackets)
                        {
                            throw new  MalformedExpressionException("Missing '" + Operation.rightRoundBrackets.toString() + "'.");
                        }
                        else
                        {
                            //Count the number in round brackets
                            LinkedStack<Token> tokenStack = new LinkedStack<>(); //reverse order

                            while (true)
                            {
                                Token hardOfResult = resultStack.pop();
                                if (hardOfResult instanceof Operator&&((Operator) hardOfResult).getOperation()==Operation.rightRoundBrackets)
                                {
                                    break;
                                }
                                else
                                {
                                    tokenStack.push(hardOfResult);
                                }
                            }

                            resultStack.push(noBracketCalculate(tokenStack));
                        }
                    }
                    else if (hardOperation==Operation.leftSquareBrackets)
                    {
                        if (bracketStack.isEmpty()||bracketStack.pop().getOperation()!=Operation.rightSquareBrackets)
                        {
                            throw new  MalformedExpressionException("Missing '" + Operation.rightSquareBrackets.toString() + "'.");
                        }
                        else
                        {
                            //Count the number in square brackets
                            LinkedStack<Token> tokenStack = new LinkedStack<>(); //reverse order

                            while (true)
                            {
                                Token hardOfResult = resultStack.pop();
                                if (hardOfResult instanceof Operator&&((Operator) hardOfResult).getOperation()==Operation.rightSquareBrackets)
                                {
                                    break;
                                }
                                else
                                {
                                    tokenStack.push(hardOfResult);
                                }
                            }

                            resultStack.push(noBracketCalculate(tokenStack));
                        }
                    }
                    else
                    {
                        resultStack.push(hard);
                        bracketStack.push((Operator) hard);
                    }
                }
                else
                {
                    resultStack.push(hard);
                }
            }
            else if (hard instanceof Operand)
            {
                resultStack.push(hard);
            }
        }

        if (bracketStack.isEmpty())
        {
            LinkedStack<Token> reverseOrderTokenStack = new LinkedStack<>();
            while (!resultStack.isEmpty())
            {
                reverseOrderTokenStack.push(resultStack.pop());
            }

            return noBracketCalculate(reverseOrderTokenStack).getValue();
        }
        else
        {
            Operation operation = bracketStack.pop().getOperation();
            switch (operation)
            {
                case rightRoundBrackets:
                    throw new  MalformedExpressionException("Missing '" + Operation.leftRoundBrackets.toString() + "'.");
                case rightSquareBrackets:
                    throw new  MalformedExpressionException("Missing '" + Operation.leftSquareBrackets.toString() + "'.");
                default:
                    throw new  MalformedExpressionException("Error input '" + operation + "'.");
            }
        }
    }

    @Override
    public void visit(Operand operand) {
        pushOperand(operand);
    }

    @Override
    public void visit(Operator operator) {
        try {
            performOperation(operator);
        } catch (MalformedExpressionException e) {
            e.printStackTrace();
        }
    }
}
