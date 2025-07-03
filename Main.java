public class Main {
    public static void main(String[] args) {
        // Initialize the application and handle user interactions for CRUD operations
        EmployeeDAO employeeDAO = new EmployeeDAO();
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println("Employee Database Application");
            System.out.println("1. Add Employee");
            System.out.println("2. View Employee");
            System.out.println("3. Update Employee");
            System.out.println("4. Delete Employee");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    // Add Employee
                    System.out.print("Enter name: ");
                    String name = scanner.next();
                    System.out.print("Enter position: ");
                    String position = scanner.next();
                    System.out.print("Enter salary: ");
                    double salary = scanner.nextDouble();
                    Employee newEmployee = new Employee(name, position, salary);
                    employeeDAO.addEmployee(newEmployee);
                    break;
                case 2:
                    // View Employee
                    System.out.print("Enter employee ID: ");
                    int id = scanner.nextInt();
                    Employee employee = employeeDAO.viewEmployee(id);
                    if (employee != null) {
                        System.out.println("Employee Details: " + employee);
                    } else {
                        System.out.println("Employee not found.");
                    }
                    break;
                case 3:
                    // Update Employee
                    System.out.print("Enter employee ID: ");
                    int updateId = scanner.nextInt();
                    Employee existingEmployee = employeeDAO.viewEmployee(updateId);
                    if (existingEmployee != null) {
                        System.out.print("Enter new name: ");
                        String newName = scanner.next();
                        System.out.print("Enter new position: ");
                        String newPosition = scanner.next();
                        System.out.print("Enter new salary: ");
                        double newSalary = scanner.nextDouble();
                        existingEmployee.setName(newName);
                        existingEmployee.setPosition(newPosition);
                        existingEmployee.setSalary(newSalary);
                        employeeDAO.updateEmployee(existingEmployee);
                    } else {
                        System.out.println("Employee not found.");
                    }
                    break;
                case 4:
                    // Delete Employee
                    System.out.print("Enter employee ID: ");
                    int deleteId = scanner.nextInt();
                    employeeDAO.deleteEmployee(deleteId);
                    break;
                case 5:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 5);

        scanner.close();
    }
}