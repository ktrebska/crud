import java.util.Scanner;

public class Main {

    private PersonDataStore dataStore = new PersonDataStore();
    private Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        Main app = new Main();
        app.run();
    }

    public void run() {
        boolean running = true;
        while (running) {
            System.out.println("Select an option:");
            System.out.println("1. Add person");
            System.out.println("2. View all persons");
            System.out.println("3. View person by ID");
            System.out.println("4. Update person");
            System.out.println("5. Delete person by its id");
            System.out.println("6. Exit");

            int choice = scanner.nextInt();
            scanner.nextLine(); // consume newline character

            switch (choice) {
                case 1:
                    addPerson();
                    break;
                case 2:
                    viewAllPersons();
                    break;
                case 3:
                    viewPersonById();
                    break;
                case 4:
                    System.out.println("select id of person to update");
                    int i = scanner.nextInt();
                    System.out.println("select new name for that person");
                    String n = scanner.nextLine();
                    dataStore.updatePerson(i,n);
                    break;
                case 5:
                    System.out.println("select id of person to delete");
                    int x = scanner.nextInt();
                    scanner.nextLine();
                    dataStore.deletePerson(x);
                    break;
                case 6:
                    running = false;
                    break;
                default:
                    System.out.println("Invalid choice");
                    break;
            }
        }
    }

    private void viewPersonById() {
    }

    private void addPerson() {
        System.out.println("Enter name:");
        String name = scanner.nextLine();
        System.out.println("Enter age:");
        int age = scanner.nextInt();
        scanner.nextLine(); // consume newline character

        Person person = new Person(0, name, age);
        dataStore.addPerson(person);
        System.out.println("Person added with ID " + person.getId());
    }

    private void viewAllPersons() {
        System.out.println("All persons:");
        for (Person person : dataStore.getAllPersons()) {
            System.out.println(person.getId() + ": " + person.getName() + " (" + person.getAge() + ")");
        }
    }

}