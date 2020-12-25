package visitor;

import token.BraceToken;
import token.NumberToken;
import token.OperationToken;

import java.util.Stack;

public class CalcVisitor implements TokenVisitor {

    Stack<Integer> stack = new Stack<>();

    @Override
    public void visit(NumberToken token) {
        stack.add(token.getNumber());
    }

    @Override
    public void visit(BraceToken token) {
        throw new IllegalStateException("Unexpected brace token");
    }

    @Override
    public void visit(OperationToken token) {
        int r = stack.peek();
        stack.pop();
        int l = stack.peek();
        stack.pop();

        int res = 0;
        switch (token.getOperation()) {
            case PLUS:
                res = l + r;
                break;
            case MINUS:
                res = l - r;
                break;
            case MULTIPLICATION:
                res = l * r;
                break;
            case DIVISION:
                res = l / r;
                break;
        }
        stack.add(res);
    }

    public int getResult() {
        return stack.peek();
    }
}
