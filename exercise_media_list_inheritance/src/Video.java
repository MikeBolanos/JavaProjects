public abstract class Video extends Media {

    // Fields
    int duration; // duration in minutes
    String resolution; // video resolution (e.g. 720p, 1080p, 4K

    // Constructor
    public Video(String name, int duration, String resolution) { // Added name to parameters
        this.name = name; // Inherited from Media class
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

    @Override
    public void play(){ // play() method override with: "Playing video '[name]' using video player software"
        System.out.println("Playing video " + name + " using video player software.");

    @Override
    public String getDescription() {  // getDescription method override with media name from the superclass and all subclass-specific fields
        return String.format(name + ":" 
        }
    }
}
