public class ListAllMediaCommand {
    // ListAllMediaCommand - handles displaying all media

    // Fields
    private MediaService service;
    private TerminalUtils utils;

    // Constructor
    public ListAllMediaCommand(MediaService service, TerminalUtils utils) {
        this.service = service;
        this.utils = utils;
        
    }
}
