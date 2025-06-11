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



}
