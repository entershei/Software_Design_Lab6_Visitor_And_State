package visitor;

import token.BraceToken;
import token.NumberToken;
import token.OperationToken;

public class ParseVisitor implements TokenVisitor {

    @Override
    public void visit(NumberToken token) {

    }

    @Override
    public void visit(BraceToken token) {

    }

    @Override
    public void visit(OperationToken token) {

    }
}
