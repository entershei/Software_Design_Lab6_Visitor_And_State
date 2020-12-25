package token;

import visitor.TokenVisitor;

public class BraceToken implements Token {

    private final BRACE_TYPE braceType;

    public BraceToken(BRACE_TYPE brace_type) {
        this.braceType = brace_type;
    }

    @Override
    public void accept(TokenVisitor visitor) {
        visitor.visit(this);
    }

    public BRACE_TYPE getBraceType() {
        return braceType;
    }

    public enum BRACE_TYPE {
        LEFT("("),
        RIGHT(")");

        private final String name;

        BRACE_TYPE(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }
    }
}
