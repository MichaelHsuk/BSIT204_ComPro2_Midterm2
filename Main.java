import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ArrayList<Employee> employees = new ArrayList<Employee>();
        Scanner scan = new Scanner(System.in);

        boolean flag = true;
        char option = ' ';

        do {
            System.out.println("Welcome to Employee Record Console Application");
            System.out.println("[Q] - Add Employee Record.");
            System.out.println("[w] - Show Employees Record.");
            System.out.println("[E] - Exit Program");
            System.out.print("Option: ");
            option = scan.nextLine().charAt(0);

            switch(option) {
                case 'q': case 'Q': 
                        employees.add(createEmployee(scan));
                    break;

                case 'w': case 'W': 
                        showEmployees(employees);
                    break;

                case 'e': case 'E': flag = false; break;
            }
        } while(flag);
        scan.close();
    }

    private static Employee createEmployee(Scanner scan) {
        System.out.println("Add Employee Record");
        System.out.print("Enter First Name: ");
        String fname = scan.nextLine();

        System.out.print("Enter Last Name: ");
        String lname = scan.nextLine();

        System.out.print("Enter Address: ");
        String address = scan.nextLine();

        System.out.print("Enter Email: ");
        String email = scan.nextLine();

        System.out.print("Enter Job Position: ");
        String job_position = scan.nextLine();

        System.out.print("Enter Rate: ");
        String rate = scan.nextLine();

        return new Employee(fname, lname, address, email, job_position, rate);
    }

    private static void showEmployees(ArrayList<Employee> employees) {
        if(employees.isEmpty()) {
            System.out.println("No Available Record.");
        } else {
            System.out.println("List of Employees");
            for(Employee employee : employees) {
                System.out.println(
                    "Employee No. " + employees.indexOf(employee) + 
                    ", Employee Name: " + employee.getFullName()+
                    ", Address: " + employee.getAddress()+
                    ", Email: " + employee.getemail()+
                    ", Job Position: " + employee.getjob_position()+
                    ", Rate: " + employee.getrate()
                );
            }
        }
    }
}