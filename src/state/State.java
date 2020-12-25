package state;

interface State {

    void nextCharacter(Tokenizer tokenizer, char character);

    void EOF(Tokenizer tokenizer);
}
