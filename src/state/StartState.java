package state;

import token.BraceToken;
import token.ErrorToken;
import token.OperationToken;

import static java.lang.Character.isDigit;
import static java.lang.Character.isWhitespace;
import static token.BraceToken.BRACE_TYPE.LEFT;
import static token.BraceToken.BRACE_TYPE.RIGHT;
import static token.OperationToken.Operation.*;

public class StartState implements State {

    @Override
    public void nextCharacter(Tokenizer tokenizer, char character) {
        switch (character) {
            case '+':
                tokenizer.addToken(new OperationToken(PLUS));
                break;
            case '-':
                tokenizer.addToken(new OperationToken(MINUS));
                break;
            case '*':
                tokenizer.addToken(new OperationToken(MULTIPLICATION));
                break;
            case '/':
                tokenizer.addToken(new OperationToken(DIVISION));
                break;
            case '(':
                tokenizer.addToken(new BraceToken(LEFT));
                break;
            case ')':
                tokenizer.addToken(new BraceToken(RIGHT));
                break;
            default:
                if (isDigit(character)) {
                    State newState = new NumberState();
                    tokenizer.changeState(newState);
                    newState.nextCharacter(tokenizer, character);
                } else if (!isWhitespace(character)) {
                    tokenizer.addToken(new ErrorToken(character));
                }
        }
    }

    @Override
    public void EOF(Tokenizer tokenizer) {
    }
}
