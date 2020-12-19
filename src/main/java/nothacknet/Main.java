package nothacknet;

import nothacknet.commands.commandparser.CommandParser;

import java.util.Scanner;

public class Main {

    static {
        CommandParser.initialise();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            String input = scanner.nextLine();
            if (input.equals("exit")) break;
            CommandParser.parse(input);
        }

    }
}
