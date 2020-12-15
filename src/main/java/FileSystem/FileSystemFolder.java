package FileSystem;

import java.util.List;

public interface FileSystemFolder extends FileSystemObject {
    List<Folder> getSubFolders();
    String getLocation();
    List<FileSystemObject> getContents();
    void addFolder(Folder folder);
}
