public class PlayMediaCommand {
    // PlayMediaCommand - handles playing selected media

    // Fields
    private MediaService service;
    private TerminalUtils utils;

    // Constructor
    public PlayMediaCommand(MediaService service, TerminalUtils utils) {
        this.service = service;
        this.utils = utils;
    }

    // Method to execute playMedia
    public void execute () {
        // Check if media list is empty first
        if (service.isEmpty()) {
            utils.displayMessage("No media present to play");
        return;
        }
    // Prompt for name of media to play
        utils.displayMessage("~*~*~Play Media~*~*~");
        String name = utils.getString("Enter the name of the Media you want to play: ");

    //  Search for name in media list
    }

}
