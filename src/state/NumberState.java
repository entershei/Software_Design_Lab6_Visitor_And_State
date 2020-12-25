package state;

import token.NumberToken;

import static java.lang.Character.isDigit;

public class NumberState implements State {

    private int number = 0;

    @Override
    public void nextCharacter(Tokenizer tokenizer, char character) {
        if (isDigit(character)) {
            number = number * 10 + Integer.parseInt(Character.toString(character));
        } else {
            tokenizer.addToken(new NumberToken(number));

            State newState = new StartState();
            tokenizer.changeState(newState);
            newState.nextCharacter(tokenizer, character);
        }
    }

    @Override
    public void EOF(Tokenizer tokenizer) {
        tokenizer.addToken(new NumberToken(number));
    }
}
