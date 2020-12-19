package nothacknet.FileSystem;

import java.util.List;

public interface FileSystemFolder extends FileSystemObject {
    List<Folder> getSubFolders();

    List<FileSystemObject> getContents();

    void addFolder(Folder folder);

    void addFile(File file);

    boolean contains(String fileName);

    String getFullFilepath();

    FileSystemFolder getParent();

    FileSystemObject getObjectByName(String fileName);
}
