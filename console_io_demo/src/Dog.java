public class Dog {
    // If you want to keep data around, you must declare it at Class level
    private String name;
    private int age;
    private String breed;

    //         Parameters are transient (destroyed)
    public Dog(String name, int age, String breed) {
        this.name = name;
        // this means this Class or object
        this.age = age;
        this.breed = breed;
    }
    // void means it will not return data
    public void Bark() {
        System.out.println(" Woof Woof!");
    }
    // getter function
    public String getName() {
        return this.name;
    }

    //setter function
    public void setName(String newName) {
        this.name =newName;

    }
    public void setAge(int newAge) {
    if (newAge < 0) {
        return;
    }

    public int getAge() {
        return this.age
        }
    }
}

