public class Audio extends Media {

    // Fields
    int duration; // Duration in minutes
    String artist; // name of artist or performer

    // Constructor
    public Audio(String name, String artist, int duration) {
        this.name = name;
        this.artist = artist;
        this.duration = duration;
    }


    // Getter/setter for duration
    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    // Getter/setter for artist
    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    @Override
    public void play() { // play() method override with "Playing audio '[name]' using audio player software"
        System.out.println("Playing audio " + name + "using audio player software");
    }

    @Override
    public String getDescription() {  // // getDescription() method override with media name from the superclass and all subclass-specific fields
        return String.format("Audio: %s | Artist: %s | Duration: %d minutes", name, artist, duration);
    }
}
