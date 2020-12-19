package nothacknet;

import nothacknet.FileSystem.FileSystemFolder;
import nothacknet.FileSystem.FileSystemRoot;
import nothacknet.FileSystem.Folder;

public class GameState {

    private static FileSystemRoot root = new FileSystemRoot();
    private static FileSystemFolder currentDirectory = root;

    public GameState() {

    }

    public static FileSystemFolder getCurrentDirectory() {
        return currentDirectory;
    }

    public static void changeCurrentDirectory(FileSystemFolder folder) {
        currentDirectory = folder;
    }

}
