import state.Tokenizer;
import token.Token;
import visitor.PrintVisitor;

import java.util.List;
import java.util.Scanner;

import static visitor.TokenVisitor.visitAll;

public class Main {

    public static void main(String[] args) {
//        System.out.println("Enter arithmetic expression:");
//
//        Scanner scanner = new Scanner(System. in);
//        String inputString = scanner. nextLine();
        String inputString = "(23 +  10) * 5 - 3 * (32 + 5) * (10 - 4 * 5) + 8 / 2";

        Tokenizer tokenizer = new Tokenizer(inputString);
        List<Token> tokenList = tokenizer.getTokenList();

        PrintVisitor printVisitor = new PrintVisitor();
        visitAll(tokenList, printVisitor);
    }
}
