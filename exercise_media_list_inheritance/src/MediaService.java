import org.w3c.dom.stylesheets.MediaList;

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

    // removeMedia(String name) - removes media by name, returns boolean success
    public boolean removeMedia(String name) {
        // Need to build findMediaByName to make this work?


    }

    // findMediaByName(String name) - finds and returns Media by name
    public Media findMediaByName(String name) {
        for (int i = 0; i < mediaList.size(); i++) {
            Media media = mediaList.get(i);       // ***** Use the index? *****
            if (media.getName().equalsIgnoreCase(name)) { // returns match if found, ignoring case
                return media;
            }
        }
        return null; // returns nothing if no match found.
    }
}
