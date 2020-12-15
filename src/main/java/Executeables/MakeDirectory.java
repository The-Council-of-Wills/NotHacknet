package Executeables;

import FileSystem.FileSystemFolder;
import FileSystem.Folder;

public class MakeDirectory {

    public static void mkdir(FileSystemFolder currentFolder, String newFolderName) {
        currentFolder.addFolder(new Folder(newFolderName, currentFolder));
    }
}
