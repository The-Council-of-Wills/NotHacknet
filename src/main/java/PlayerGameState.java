import FileSystem.FileSystemFolder;
import FileSystem.FileSystemRoot;
import FileSystem.Folder;

public class PlayerGameState {

    private FileSystemRoot root = new FileSystemRoot();
    private FileSystemFolder currentDirectory = root;

    public PlayerGameState() {
        initialize();
    }

    private void initialize() {

    }

    public FileSystemFolder getCurrentDirectory() {
        return currentDirectory;
    }

    public void changeCurrentDirectory(FileSystemFolder folder) {
        currentDirectory = folder;
    }

}
