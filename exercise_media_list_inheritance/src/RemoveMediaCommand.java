import javax.xml.namespace.QName;

public class RemoveMediaCommand {
    // RemoveMediaCommand - handles removing media from list

    // Fields
    private MediaService service;

    private TerminalUtils utils;

    // Constructor
    public RemoveMediaCommand(MediaService service, TerminalUtils utils) {
        this.service = service;
        this.utils = utils;
    }

    // Method to execute removeMedia
    public void execute() {
        if (service.isEmpty()) { // Check if media list is empty
            utils.displayMessage("No media present to remove.");
            return;
        }
        // Prompt for name of media to be removed
        utils.displayMessage("~*~*~Remove Media~*~*~");
        String name = ("Enter the name of the media being removed: ");

        // Remove media
        boolean removed = service.removeMedia(name);

        // Display whether the media was removed or not successful
        if (removed) {
            utils.displayMessage("Media, '" + name + "', has been removed!");
        } else {
            utils.displayMessage("Media, '" + name + "', not found.");
        }
    }
}
