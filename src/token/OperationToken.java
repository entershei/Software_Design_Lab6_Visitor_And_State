package token;

import visitor.TokenVisitor;

public class OperationToken implements Token {

    private final Operation operation;

    public OperationToken(Operation operation) {
        this.operation = operation;
    }

    @Override
    public void accept(TokenVisitor visitor) {
        visitor.visit(this);
    }

    public Operation getOperation() {
        return operation;
    }

    public enum Operation {
        PLUS("PLUS"),
        MINUS("MINUS"),
        MULTIPLICATION("MULTIPLICATION"),
        DIVISION("DIVISION");

        private final String name;

        Operation(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }
    }
}
