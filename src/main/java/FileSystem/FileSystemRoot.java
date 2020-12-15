package FileSystem;

import java.util.ArrayList;
import java.util.List;

public class FileSystemRoot implements FileSystemFolder {
    String location = "/";
    List<Folder> subFolders = new ArrayList<>();
    List<File> files = new ArrayList<>();

    public FileSystemRoot() {

    }

    public List<FileSystemObject> getContents() {
        List<FileSystemObject> contents = new ArrayList<>();
        contents.addAll(subFolders);
        contents.addAll(files);
        return contents;
    }

    public void addFile(File file) {
        files.add(file);
    }

    @Override
    public void addFolder(Folder folder) {
        subFolders.add(folder);
    }

    @Override
    public List<Folder> getSubFolders() {
        return subFolders;
    }

    @Override
    public String getLocation() {
        return location;
    }

    @Override
    public String getName() {
        return "/";
    }

    @Override
    public void setName(String name) {
        //ignored since this is the File Root
    }

    @Override
    public String toString() {
        return "FileSystemRoot{" +
                "location='" + location + '\'' +
                ", subFolders=" + subFolders +
                ", files=" + files +
                '}';
    }
}
