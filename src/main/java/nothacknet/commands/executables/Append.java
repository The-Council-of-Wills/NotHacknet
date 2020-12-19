package nothacknet.commands.executables;

import nothacknet.FileSystem.File;
import nothacknet.FileSystem.FileSystemObject;
import nothacknet.GameState;
import nothacknet.commands.executables.interfaces.Exec;
import nothacknet.commands.executables.interfaces.Executable;

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
        for (int i = 1; i < args.size(); i++) {
            toAppend.append(args.get(i));
        }

        FileSystemObject file = GameState.getCurrentDirectory().getObjectByName(args.get(1));
        if (file instanceof File) {
            append((File) file, toAppend.toString());
        } else if (file == null) {
            GameState.getCurrentDirectory().addFile(new File(GameState.getCurrentDirectory().getParent(), args.get(1), toAppend.toString()));
        } else {
            System.out.println("Specified file is a Folder");
        }
    }
}
