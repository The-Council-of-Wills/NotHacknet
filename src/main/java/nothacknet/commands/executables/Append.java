package nothacknet.commands.executables;

import nothacknet.FileSystem.File;
import nothacknet.FileSystem.FileSystemObject;
import nothacknet.GameState;

import java.util.List;

@Exec(key = "append")
public class Append implements Executable {

    public Append() {

    }

    public static void append(File file, String toAppend) {
        file.append(toAppend);
    }

    @Override
    public void execute(List<String> args) {
        if (args.size() < 2) {
            System.out.println("Error: Not enough arguments");
        }

        StringBuilder toAppend = new StringBuilder();

        FileSystemObject file = GameState.getCurrentDirectory().getObjectByName(args.get(1));
        if (file instanceof File) {
            for (int i = 2; i < args.size(); i++) {
                toAppend.append(args.get(i));
            }
        } else {
            System.out.println("Specified file is a Folder");
            return;
        }

        append((File) file, toAppend.toString());
    }
}
