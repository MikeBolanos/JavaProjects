public class Image extends Media{

    // Fields
    String dimensions; // image dimensions (e.g., "1920x1080")
    String fileFormat; // image format (e.g., "JPEG", "PNG")


    // Constructor
    public Image(String name, String fileFormat, String dimensions) {
        this.name = name;
        this.fileFormat = fileFormat;
        this.dimensions = dimensions;
    }

    // Getter/setter for dimensions
    public String getDimensions() {
        return dimensions;
    }

    public void setDimensions(String dimensions) {
        this.dimensions = dimensions;
    }

    // Getter/setter for fileFormat
    public String getFileFormat() {
        return fileFormat;
    }

    public void setFileFormat(String fileFormat) {
        this.fileFormat = fileFormat;
    }

    @Override
    public void play() { // play() method override with "Displaying image '[name]' using image viewer software"
        System.out.println("Displaying image, '" + name + "', using image viewer software...");
    }

    @Override
    public String getDescription() { // getDescription() method override with media name from the superclass and all subclass-specific fields
        return String.format("Image: %s | File Format: %s | Dimensions: %s", name, fileFormat, dimensions);
    }
}
