package nothacknet.FileSystem;

import java.util.List;

public interface FileSystemFolder extends FileSystemObject {
    List<Folder> getSubFolders();
    List<FileSystemObject> getContents();
    void addFolder(Folder folder);
    boolean contains(String fileName);
    String getFullFilepath();
}
