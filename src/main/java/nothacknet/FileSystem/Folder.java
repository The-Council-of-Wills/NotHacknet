package nothacknet.FileSystem;

import java.util.ArrayList;
import java.util.List;

public class Folder implements FileSystemFolder {
    private String name;
    private FileSystemFolder parent;
    private List<Folder> subFolders = new ArrayList<>();
    private List<File> files = new ArrayList<>();

    public Folder(String name, FileSystemFolder parent) {
        this.name = name;
        this.parent = parent;
    }

    public List<FileSystemObject> getContents() {
        List<FileSystemObject> contents = new ArrayList<>();
        contents.addAll(subFolders);
        contents.addAll(files);
        return contents;
    }

    @Override
    public void addFolder(Folder folder) {
        subFolders.add(folder);
    }

    @Override
    public boolean contains(String fileName) {
        for (FileSystemObject obj : getContents()) {
            if (obj.getName().equals(fileName)) {
                return true;
            }
        }

        return false;
    }

    @Override
    public FileSystemObject getObjectByName(String fileName) {
        for (FileSystemObject obj : getContents()) {
            if (obj.getName().equals(fileName)) {
                return obj;
            }
        }
        return null;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public List<Folder> getSubFolders() {
        return subFolders;
    }

    @Override
    public String getFullFilepath() {
        return parent.getFullFilepath() + name + "/";
    }

    @Override
    public String toString() {
        return "Folder{" +
                "name='" + name + '\'' +
                ", parent=" + parent.getFullFilepath() +
                ", location=" + getFullFilepath() +
                ", subFolders=" + subFolders +
                ", files=" + files +
                '}';
    }
}
