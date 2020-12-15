package Executeables;


import FileSystem.FileSystemFolder;
import FileSystem.FileSystemObject;

public class ListDirectory {


    public static String ls(FileSystemFolder folder) {
        StringBuilder builder = new StringBuilder();
        for (FileSystemObject fileSystemObject : folder.getContents()) {
            builder.append(fileSystemObject.getName()).append(" ");
        }
        return builder.toString();
    }

}
