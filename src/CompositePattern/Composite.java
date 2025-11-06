package CompositePattern;

import java.util.ArrayList;
import java.util.List;


abstract class FileSystemComponent {
    protected String name;

    public FileSystemComponent(String name) {
        this.name = name;
    }

    public abstract void display(String indent);
    public abstract int getSize();
}


class File extends FileSystemComponent {
    private int size;

    public File(String name, int size) {
        super(name);
        this.size = size;
    }

    @Override
    public void display(String indent) {
        System.out.println(indent + "- " + name + " (" + size + " KB)");
    }

    @Override
    public int getSize() {
        return size;
    }
}

class Directory extends FileSystemComponent {
    private List<FileSystemComponent> children = new ArrayList<>();

    public Directory(String name) {
        super(name);
    }

    public void addComponent(FileSystemComponent component) {
        if (!children.contains(component)) {
            children.add(component);
        } else {
            System.out.println("Компонент уже существует: " + component.name);
        }
    }

    public void removeComponent(FileSystemComponent component) {
        if (children.contains(component)) {
            children.remove(component);
        } else {
            System.out.println("Компонент не найден: " + component.name);
        }
    }

    @Override
    public void display(String indent) {
        System.out.println(indent + "+ " + name + " (" + getSize() + " KB)");
        for (FileSystemComponent c : children) {
            c.display(indent + "  ");
        }
    }

    @Override
    public int getSize() {
        int total = 0;
        for (FileSystemComponent c : children) {
            total += c.getSize();
        }
        return total;
    }
}


class CompositePattern {
    public static void main(String[] args) {
        File file1 = new File("document.txt", 50);
        File file2 = new File("song.mp3", 5000);
        File file3 = new File("video.mp4", 20000);

        Directory musicFolder = new Directory("Music");
        musicFolder.addComponent(file2);

        Directory videoFolder = new Directory("Videos");
        videoFolder.addComponent(file3);

        Directory rootFolder = new Directory("Root");
        rootFolder.addComponent(file1);
        rootFolder.addComponent(musicFolder);
        rootFolder.addComponent(videoFolder);

        rootFolder.display("");
        System.out.println("Общий размер: " + rootFolder.getSize() + " KB");
    }
}
