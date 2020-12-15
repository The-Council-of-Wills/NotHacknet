package FileSystem;

public class File implements FileSystemObject {
    private String fileName;
    private Folder parent;
    private String content;

    public File(Folder parent, String fileName, String content) {
        this.parent = parent;
        this.fileName = fileName;
        this.content = content;
    }


    @Override
    public String getName() {
        return fileName;
    }

    @Override
    public void setName(String name) {
        this.fileName = name;
    }
}
