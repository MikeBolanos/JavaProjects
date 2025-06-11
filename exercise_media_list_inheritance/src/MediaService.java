import java.util.ArrayList;
import java.util.List;

public class MediaService {
    // class to manage the media collection

    // Fields
    private List<Media> mediaList;

    // Constructor
    public MediaService() {
        mediaList = new ArrayList<>();
    }

    // addMedia(Media media) - adds media to the list
    public void addMedia(Media media) {
        mediaList.add(media);
    }
}
