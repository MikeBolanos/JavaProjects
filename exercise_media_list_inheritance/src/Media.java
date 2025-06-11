public abstract class Media {
    // Fields
    protected String name; // Media name

    // Methods

    // Getter for name
    public String getName() {
        return name;
    }

    // Setter for name (void because it doesn't return anything)
    public void setName(String name) {
        this.name = name;
    }

    // Abstract method to be overridden by subclasses
    abstract void play();


    // Abstract method to be overridden by subclasses
    abstract String getDescription();

}
