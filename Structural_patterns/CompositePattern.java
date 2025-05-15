package Structural_patterns;

import java.util.ArrayList;
import java.util.List;

interface FileSystemComponent {
    void display(String indent);
}

class File implements FileSystemComponent {
    private String name;

    public File(String name) {
        this.name = name;
    }

    @Override
    public void display(String indent) {
        System.out.println(indent + "- File: " + name);
    }
}


class Directory implements FileSystemComponent {
    private String name;
    private List<FileSystemComponent> children = new ArrayList<>();

    public Directory(String name) {
        this.name = name;
    }

    public void add(FileSystemComponent component) {
        children.add(component);
    }

    public void remove(FileSystemComponent component) {
        children.remove(component);
    }

    @Override
    public void display(String indent) {
        System.out.println(indent + "+ Directory: " + name);
        for (FileSystemComponent component : children) {
            component.display(indent + "  ");
        }
    }
}


public class CompositePattern {
    public static void main(String[] args) {
        FileSystemComponent file1 = new File("Resume.pdf");
        FileSystemComponent file2 = new File("Photo.jpg");

        Directory documents = new Directory("Documents");
        Directory images = new Directory("Images");

        documents.add(file1);
        images.add(file2);

        Directory root = new Directory("Root");
        root.add(documents);
        root.add(images);

        root.display("");
    }

}
