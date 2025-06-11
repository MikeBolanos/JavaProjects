import org.w3c.dom.stylesheets.MediaList;

import java.util.ArrayList;
import java.util.List;

public class MediaService {
    // class to manage the media collection

    // Fields
    private final List<Media> mediaList;

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
        Media media = findMediaByName(name);
        if (media != null) { // use boolean to see if the name search returned no matches
            mediaList.remove(media);
            return true;
        }
        return  false;
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

    // getAllMedia() - returns copy of media list

    public List<Media> getAllMedia() {
        return new ArrayList<>(mediaList);
    }

    // getMediaCount() - returns number of media items
    public int getMediaCount() {
        return mediaList.size();
    }

    // isEmpty() - checks if Media list is empty
    public boolean isEmpty() {
        return mediaList.isEmpty();
    }

}
