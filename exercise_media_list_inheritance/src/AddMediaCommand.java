public class AddMediaCommand {
    // handles adding new media, be sure to first prompt for the media type
    //collect all the data specific to that type

    // Fields
    private MediaService service;

    private TerminalUtils utils;

    // Constructor
    public AddMediaCommand(MediaService service, TerminalUtils utils) {
        this.service = service;
        this.utils = utils;
    }

    // Methods

    // execute
    public void execute() {
        utils.displayMessage("\n~*~*~Add New Media~*~*~");
        utils.displayMessage("1. Video");
        utils.displayMessage("2. Audio");
        utils.displayMessage("3. Book");
        utils.displayMessage("4. Image");

        int choice = utils.getInt("\nSelect a media type by number: ");

        switch (choice) {  // cases will call add methods for each media type
            case 1 -> addVideo();
            case 2 -> addAudio();
            case 3 -> addBook();
            case 4 -> addImage();

        }
    }
    // add media methods by type
    private void addVideo() {
        String name = utils.getString("Enter the name of the video: ");
        int duration = utils.getInt("Enter the duration of the video in minutes: ");
        String resolution = utils.getString("Enter the resolution of the video (720p, 1080p, 4K, etc.): ");
        Video video = new Video(name, duration, resolution);
        service.addMedia(video);
        utils.displayMessage("Video media added!");
    }

    private void addAudio() {
        String name = utils.getString("Enter the name of the audio: ");
        String artist = utils.getString("Enter the artist that created the audio: ");
        int duration = utils.getInt("Enter the duration of the audio in minutes: ");
        Audio audio = new Audio(name, artist, duration);
        service.addMedia(audio);
        utils.displayMessage("Audio media added!");
    }

    private void addBook() {
        String name = utils.getString("Enter the name of the book: ");
        String author = utils.getString("Enter the book's author: ");
        int pageCount = utils.getInt("Enter the number of pages in the book: ");
        Book book = new Book(name, author, pageCount);
        service.addMedia(book);
        utils.displayMessage("Book media added!");
    }

    private void addImage() {
        String name = utils.getString("Enter the name of the image: ");
        String fileFormat = utils.getString("Enter the file format of the image (JPEG, PNG, etc.): ");
        String dimensions = utils.getString("Enter the dimensions of the image (1280x720, 1920x1080, etc.): ");
        Image image = new Image(name, fileFormat, dimensions);
        service.addMedia(image);
        utils.displayMessage("Image media added!");
    }


}
