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

    // Methods

    public void execute() {
        if (service.isEmpty()) { // Check if media list is empty
            utils.displayMessage("No media present to remove.");
            return;
        }
        utils.displayMessage("~*~*~Remove Media~*~*~");
        ("Enter the name of the media being removed: ");

        boolean removed = service.removeMedia(name);
    }
}
