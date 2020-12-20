package nothacknet.commands.executables;

import nothacknet.FileSystem.File;
import nothacknet.FileSystem.FileSystemObject;
import nothacknet.GameState;
import nothacknet.commands.executables.interfaces.Exec;
import nothacknet.commands.executables.interfaces.Executable;

import java.util.List;

@Exec(key = "cat")
public class Cat implements Executable {

    public Cat() {

    }

    public void cat(File file) {
        System.out.println(file.getContent());
    }

    @Override
    public void execute(List<String> args) {
        if (args.size() < 2) {
            System.out.println("Not enough arguments");
            return;
        }
        FileSystemObject file = GameState.getCurrentDirectory().getObjectByName(args.get(1));
        if (file instanceof File) {
            cat((File) file);
        } else {
            System.out.println(args.get(1) + " is not a file");
        }
    }
}
