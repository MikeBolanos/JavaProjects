public class ObjectPractice {

    public static void main(String[] args) {
        // Part 1: Car Dealership System
        Car car1 = new Car("Subaru", "Forester", 2025);
        Car car2 = new Car("Ford", "Mustang", 2022);
        car1.displayInfo();
        car2.displayInfo();


        // Part 2: Book Library System
        Book book1 = new Book("Ender's Game", "Orson Scott Card");
        book1.displayStatus();
        System.out.println("Borrowing the book...");
        book1.borrowBook();
        book1.displayStatus();


        // Part 3: Shared Account Reference
        BankAccount acc1 = new BankAccount("Alice", 1000.0);
        BankAccount acc2 = acc1; // Reference copy
        acc1.displayBalance();
        System.out.println("Depositing $500 to acc2...");
        acc2.deposit(1000);
        acc1.displayBalance();

        // Part 4: Employee Tracking
        new Employee("Larry");
        new Employee("Curly");
        new Employee("Moe");
        System.out.println("\nTotal Employees: " + Employee.getTotalEmployees());


    }

}
