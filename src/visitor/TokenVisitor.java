package visitor;

import token.BraceToken;
import token.NumberToken;
import token.OperationToken;
import token.Token;

import java.util.List;

public interface TokenVisitor {

    static void visitAll(List<Token> tokens, TokenVisitor visitor) {
        for (Token token : tokens) {
            token.accept(visitor);
        }
    }

    void visit(NumberToken token);

    void visit(BraceToken token);

    void visit(OperationToken token);
}
