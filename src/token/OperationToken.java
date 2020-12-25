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
        PLUS("PLUS", 2),
        MINUS("MINUS", 2),
        MULTIPLICATION("MULTIPLICATION", 1),
        DIVISION("DIVISION", 1);

        private final String name;
        private final int priority;

        Operation(String name, int priority) {
            this.name = name;
            this.priority = priority;
        }

        public String getName() {
            return name;
        }

        public int getPriority() {
            return priority;
        }
    }
}
