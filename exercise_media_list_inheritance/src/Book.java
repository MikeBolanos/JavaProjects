public class Book extends Media {

    // Fields
    String author; // author name
    int pageCount; // number of pages in book

    //Constructor
    public Book(String name, String author, int pageCount) {
        this.name = name;
        this.author = author;
        this.pageCount = pageCount;
    }

    // Getter and Setter for author
    public String getAuthor() {
        return author;
    }
    public void setAuthor(String author) {
        this.author = author;
    }

    // Getter and Setter for pageCount

    public int getPageCount() {
        return pageCount;
    }

    public void setPageCount(int pageCount) {
        this.pageCount = pageCount;
    }

    @Override
    public void play(){ // play() method override with "Opening book '[name]' using e-reader software"
        System.out.println("Opening book, '" + name + "', using e-reader software...");
    }

    @Override
    public String getDescription() { // getDescription() method override with media name from the superclass and all subclass-specific fields
        return String.format("Book: %s | ")
    }
}
