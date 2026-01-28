public class Main {

    public static void main(String[] args) {
        // Create the organization ("large department")
        Component organization = new Department("Organization");

        // Create departments:
        Component department1 = new Department("Marketing");
        Component department2 = new Department("Social Media Marketing");
        Component department3 = new Department("Development");
        Component department4 = new Department("Product Development");
        Component department5 = new Department("Business Development");
        Component department6 = new Department("Brand Development");
        Component department7 = new Department("Sales Development");

        // Create employees
        Component employee1 = new Employee("Jane Smith", 3100);
        Component employee2 = new Employee("Hannah Greene", 3000);
        Component employee3 = new Employee("Frank Woods", 3000);

        Component employee4 = new Employee("Will Daniels", 2600);
        Component employee5 = new Employee("Julie Hay", 2800);

        Component employee6 = new Employee("Robert Cook", 2900);
        Component employee7 = new Employee("Michael Brown", 2800);
        Component employee8 = new Employee("Natalie Good", 2700);

        Component employee9 = new Employee("Emily Spring", 3100);
        Component employee10 = new Employee("Olivia Carlson", 2800);

        Component employee11 = new Employee("Hans Highland", 3200);
        Component employee12 = new Employee("Eric Creek", 3000);

        // Add employees to departments:
        department1.add(employee1);
        department1.add(employee2);
        department1.add(employee3);

        department2.add(employee4);
        department2.add(employee5);

        department4.add(employee6);
        department4.add(employee7);
        department4.add(employee8);

        department6.add(employee9);
        department6.add(employee10);

        department7.add(employee11);
        department7.add(employee12);

        // Add departments to other departments:
        department5.add(department6);
        department5.add(department7);

        department3.add(department4);
        department3.add(department5);

        department1.add(department2);

        organization.add(department1);
        organization.add(department3);

        // Print the data to see the structure
        organization.printData("");
        // Print the total salary of the organization
        organization.printSalary();

        System.out.println("\n\n");

        // Move an employee from one department to another
        department6.remove(employee10);
        department2.add(employee10);

        // Move a department from one department to another
        department1.remove(department2);
        department6.add(department2);

        // Print the data to see the change
        organization.printData("");
        organization.printSalary();

    }
}
