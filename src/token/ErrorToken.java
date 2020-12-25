package token;

import visitor.TokenVisitor;

public class ErrorToken implements Token {

    private final char unexpectedChar;

    public ErrorToken(char unexpectedChar) {
        this.unexpectedChar = unexpectedChar;
    }

    public char getUnexpectedChar() {
        return unexpectedChar;
    }

    @Override
    public void accept(TokenVisitor visitor) {
        throw new IllegalStateException("Unexpected character: " + unexpectedChar);
    }
}
