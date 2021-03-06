package nothacknet.commands.commandparser;

import nothacknet.commands.executables.Append;
import nothacknet.commands.executables.Cat;
import nothacknet.commands.executables.ListDirectory;
import nothacknet.commands.executables.MakeDirectory;
import nothacknet.commands.executables.interfaces.Executable;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class CommandParser {

    private static HashMap<String, Executable> commands = new HashMap<>();

    public static void initialise() {
        commands.put("ls", new ListDirectory());
        commands.put("mkdir", new MakeDirectory());
        commands.put("append", new Append());
        commands.put("cat", new Cat());
    }

    public static void parse(String toParse) {
        List<String> stringSplit = splitInput(toParse);
        if (!commands.containsKey(stringSplit.get(0))) {
            System.out.println("Command not found");
            return;
        }
        commands.get(stringSplit.get(0)).execute(stringSplit);
    }


    private static List<String> splitInput(String input) {

        StringBuilder buffer = new StringBuilder();
        ArrayList<String> stringSplit = new ArrayList<>();

        boolean quoteFlag = false;
        for (int i = 0; i < input.length(); i++) {
            switch (input.charAt(i)) {
                case ' ' -> {
                    if (quoteFlag) {
                        buffer.append(' ');
                        break;
                    }
                    stringSplit.add(buffer.toString());
                    buffer.setLength(0);
                }
                case '"' -> quoteFlag = !quoteFlag;
                default -> buffer.append(input.charAt(i));
            }
        }
        stringSplit.add(buffer.toString());

        return stringSplit;
    }

}
