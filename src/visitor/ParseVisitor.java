package visitor;

import token.BraceToken;
import token.NumberToken;
import token.OperationToken;
import token.Token;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import static token.BraceToken.BRACE_TYPE.LEFT;

public class ParseVisitor implements TokenVisitor {

    private final List<Token> rpn = new ArrayList<>();
    private final Stack<Token> stack = new Stack<>();

    @Override
    public void visit(NumberToken token) {
        rpn.add(token);
    }

    @Override
    public void visit(BraceToken token) {
        if (token.getBraceType() == LEFT) {
            stack.add(token);
        } else {
            while (!stack.empty() && !(stack.peek() instanceof BraceToken
                    && ((BraceToken) stack.peek()).getBraceType() == LEFT)) {
                rpn.add(stack.peek());
                stack.pop();
            }

            if (stack.empty()) {
                throw new IllegalStateException("Could not find match brace.");
            }
            stack.pop();
        }
    }

    @Override
    public void visit(OperationToken token) {
        while (!stack.empty() && (stack.peek() instanceof OperationToken &&
                (((OperationToken) stack.peek()).getOperation().getPriority() <= token.getOperation().getPriority()))) {
            rpn.add(stack.peek());
            stack.pop();
        }
        stack.add(token);
    }

    public List<Token> getRpn() {
        while (!stack.empty()) {
            if (stack.peek() instanceof OperationToken) {
                rpn.add(stack.peek());
                stack.pop();
            } else {
                throw new IllegalStateException("Incorrect expression");
            }
        }

        return rpn;
    }
}
