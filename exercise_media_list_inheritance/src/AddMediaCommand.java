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
            case 4 -> addimage();

        }
    }
    // add media methods by type
    private void addVideo() {
        String name = utils.getString("Enter the video name: ");
        int duration = utils.getInt("Enter the duration of the video in minutes: ");
        String resolution = utils.getString("Enter the resolution of the video (e.g., 1080p: ");
        Video video = new Video(name, duration, resolution);
        service.addMedia(video);
        utils.displayMessage("Video media added!");
    }

    private void addAudio() {
        String name = utils.getString("Enter the audio name: ");
        String artist = utils.getString("Enter the artist that created the audio: ");
        int duration = utils.getInt("Enter the duration of the audio in minutes: ");
        Audio audio = new Audio(name, artist, duration);
    }


}
