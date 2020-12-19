package nothacknet.commands.executables;

import nothacknet.FileSystem.FileSystemFolder;
import nothacknet.FileSystem.Folder;
import nothacknet.GameState;

import java.util.List;

@Exec(key = "mkdir")
public class MakeDirectory implements Executable {

    public MakeDirectory() {

    }

    public static void mkdir(FileSystemFolder currentFolder, String newFolderName) {
        currentFolder.addFolder(new Folder(newFolderName, currentFolder));
    }

    @Override
    public void execute(List<String> args) {
        if (args.size() < 2) {
            System.out.println("Enough enough arguments");
            return;
        }
        if (GameState.getCurrentDirectory().contains(args.get(1))) {
            System.out.println("Error: A File or Folder with the specified name already exists");
            return;
        }
        mkdir(GameState.getCurrentDirectory(), args.get(1));
    }
}
