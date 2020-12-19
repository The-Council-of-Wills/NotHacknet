package nothacknet.commands.executables;


import nothacknet.FileSystem.FileSystemFolder;
import nothacknet.FileSystem.FileSystemObject;
import nothacknet.GameState;

import java.util.List;

@Exec(key = "ls")
public class ListDirectory implements Executable {

    public ListDirectory() {

    }

    @Override
    public void execute(List<String> args) {

        for (FileSystemObject obj : GameState.getCurrentDirectory().getContents()) {
            if (obj instanceof FileSystemFolder) {
                System.out.print(obj.getName() + "/ ");
            } else {
                System.out.print(obj.getName());
            }
        }
        System.out.println();
    }
}
