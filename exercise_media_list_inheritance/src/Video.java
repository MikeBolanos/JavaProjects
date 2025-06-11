public abstract class Video extends Media {

    // Fields
    int duration; // duration in minutes
    String resolution; // video resolution (e.g. 720p, 1080p, 4K

    // Constructor
    public Video(String name, int duration, String resolution) { // Added name to parameters
        this.duration = duration;
        this.resolution = resolution;
    }

    // Getter and Setter for duration
    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    // Getter and Setters for resolution
    public String getResolution() {
        return resolution;
    }

    public void setResolution(String resolution) {
        this.resolution = resolution;
    }

}
