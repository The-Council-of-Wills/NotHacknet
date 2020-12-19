package nothacknet.FileSystem;

public class File implements FileSystemObject {
    private String fileName;
    private FileSystemFolder parentFolder;
    private StringBuilder content;

    public File(FileSystemFolder parent, String fileName, String content) {
        this.parentFolder = parent;
        this.fileName = fileName;
        this.content = new StringBuilder(content);
    }

    public String getContent() {
        return content.toString();
    }

    public void setContent(String content) {
        this.content = new StringBuilder(content);
    }

    public void append(String toAppend) {
        content.append(toAppend);
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
