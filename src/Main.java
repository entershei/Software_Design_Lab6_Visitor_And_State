import state.Tokenizer;
import token.Token;
import visitor.CalcVisitor;
import visitor.ParseVisitor;
import visitor.PrintVisitor;

import java.util.List;
import java.util.Scanner;

import static visitor.TokenVisitor.visitAll;

public class Main {

    public static void main(String[] args) {
        System.out.println("Enter arithmetic expression:");

        Scanner scanner = new Scanner(System. in);
        String inputString = scanner. nextLine();

        Tokenizer tokenizer = new Tokenizer(inputString);
        List<Token> tokenList = tokenizer.getTokenList();

        ParseVisitor parseVisitor = new ParseVisitor();
        visitAll(tokenList, parseVisitor);
        tokenList = parseVisitor.getRpn();

        System.out.println("RPN:");
        PrintVisitor printVisitor = new PrintVisitor();
        visitAll(tokenList, printVisitor);

        CalcVisitor calcVisitor = new CalcVisitor();
        visitAll(tokenList, calcVisitor);
        System.out.println("\nValue:");
        System.out.println(calcVisitor.getResult());
    }
}
