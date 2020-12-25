package visitor;

import token.BraceToken;
import token.NumberToken;
import token.OperationToken;

public class PrintVisitor implements TokenVisitor {

    @Override
    public void visit(NumberToken token) {
        System.out.print("NUMBER(" + token.getNumber() + ") ");
    }

    @Override
    public void visit(BraceToken token) {
        System.out.print(token.getBraceType().getName() + ' ');
    }

    @Override
    public void visit(OperationToken token) {
        System.out.print(token.getOperation().getName() + ' ');
    }
}
