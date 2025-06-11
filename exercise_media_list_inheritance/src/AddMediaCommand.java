public class AddMediaCommand {
    // handles adding new media, be sure to first prompt for the media type and
    //collect all the data specific to that type (Videos will have different inputs than audio or books)

    // Fields
    private MediaService service;

    private TerminalUtils utils;

    // Constructor
    public AddMediaCommand(MediaService service, TerminalUtils utils) {
        this.service = service;
        this.utils = utils;
    }




}
