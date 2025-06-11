public class Main {
    public static void main(String[] args) {
        // Create instance for MediaService and TerminalUtils
        MediaService service = new MediaService();
        TerminalUtils utils = new TerminalUtils();

        //  New AddMediaCommand with above instances
        AddMediaCommand addMedia = new AddMediaCommand(service, utils);

        // Calling addMedia execute method to test
        addMedia.execute();
        
    }
}
