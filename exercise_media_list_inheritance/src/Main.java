import java.util.List;

public class Main {
    public static void main(String[] args) {
        // Create instance for MediaService and TerminalUtils
        MediaService service = new MediaService();
        TerminalUtils utils = new TerminalUtils();

        //  New command class object with above instances
        AddMediaCommand addMedia = new AddMediaCommand(service, utils);
        RemoveMediaCommand removeMedia = new RemoveMediaCommand(service, utils);
        PlayMediaCommand playMedia = new PlayMediaCommand(service, utils);
        ListAllMediaCommand listAllMedia = new ListAllMediaCommand(service, utils);

        // Do-while loop to display menu at least once
        int choice;
    }
}

