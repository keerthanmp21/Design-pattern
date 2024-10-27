public class ProxyPattern {
    public static void main(String[] args) {
        Image image1 = new ImageProxy("photo1.jpg");
        Image image2 = new ImageProxy("photo2.jpg");

        // Image is loaded and displayed on first access
        image1.display();  
        System.out.println();

        // Image is already loaded, so it is directly displayed
        image1.display();  
        System.out.println();

        // Second image is loaded and displayed
        image2.display();  
    }
}

interface Image {
    void display();
}

class RealImage implements Image {
    private String filename;

    public RealImage(String filename) {
        this.filename = filename;
        loadFromDisk();  // Expensive operation
    }

    private void loadFromDisk() {
        System.out.println("Loading image from disk: " + filename);
    }

    @Override
    public void display() {
        System.out.println("Displaying image: " + filename);
    }
}

class ImageProxy implements Image {
    private RealImage realImage;
    private String filename;

    public ImageProxy(String filename) {
        this.filename = filename;
    }

    @Override
    public void display() {
        if (realImage == null) {
            realImage = new RealImage(filename);  // Load the image lazily
        }
        realImage.display();
    }
}
