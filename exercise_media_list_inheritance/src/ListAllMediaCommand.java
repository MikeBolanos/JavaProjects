import java.util.List;

public class ListAllMediaCommand {
    // ListAllMediaCommand - handles displaying all media

    // Fields
    private final MediaService service;
    private final TerminalUtils utils;

    // Constructor
    public ListAllMediaCommand(MediaService service, TerminalUtils utils) {
        this.service = service;
        this.utils = utils;
    }

    // Method to execute list command
    public void execute() {
        // Check if media list is empty
        if (service.isEmpty()) {
            utils.displayMessage("No media present to display.");
        return;
        }

        // Call copy of list items method
        List<Media> allMedia = service.getAllMedia();

        // Display media list
        utils.displayMediaList(allMedia);
    }
}
