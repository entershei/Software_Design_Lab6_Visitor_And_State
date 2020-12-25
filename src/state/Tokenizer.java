package state;

import token.Token;

import java.util.ArrayList;
import java.util.List;

public class Tokenizer {

    private final List<Token> tokenList = new ArrayList<>();
    private State state = new StartState();

    public Tokenizer(String s) {
        for (int i = 0; i < s.length(); i++) {
            state.nextCharacter(this, s.charAt(i));
        }
        state.EOF(this);
    }

    void addToken(Token token) {
        tokenList.add(token);
    }

    void changeState(State state) {
        this.state = state;
    }

    public List<Token> getTokenList() {
        return tokenList;
    }
}
