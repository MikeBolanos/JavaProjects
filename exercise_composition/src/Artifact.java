public class Artifact {

    // Fields
    private String name;
    private int yearOfDiscovery;
    private Person discoverer;
    private Person curator;

    public Artifact(String name, int yearOfDiscovery, Person discoverer, Person curator) {
        this.name = name;
        this.yearOfDiscovery = yearOfDiscovery;
        this.discoverer = discoverer;
        this.curator = curator;
    }

    // Getters


    public String getName() {
        return name;
    }

    public int getYearOfDiscovery() {
        return yearOfDiscovery;
    }

    public Person getDiscoverer() {
        return discoverer;
    }

    public Person getCurator() {
        return curator;
    }

    // toString Override
    @Override
    public String toString() {
        return String.format("Artifact: %s (%d) \nDiscoverer: %s \nCurator: %s", name, yearOfDiscovery, discoverer, curator);
    }
}
