import java.util.ArrayList;
import java.util.Scanner;

class Employee {
	private int id;
	private String name;
	private double rate;
	
	public Employee(final int id, final String name, final double rate) {
		this.id = id;
		this.name = ucfirst(name);
		this.rate = rate;
	}

	public Employee(final String fname, final String lname, final String address, final String email, final String job_position, final String rate2) {
	}

	public void setName(final String name) {
		this.name = ucfirst(name);
	}

	public void setRate(final double rate) {
		this.rate = rate;
	}

	public int getID() {
		return id;
	}

	public String getName() {
		return name;
	}

	public double getRate() {
		return rate;
	}

	public double getSalary(final double hours) {
		return hours * rate;
	}

	private String ucfirst(final String s) {
		return String.valueOf(s.charAt(0)).toUpperCase() + s.substring(1, s.length());
	}

	public String getFullName() {
		return null;
	}

	public String getAddress() {
		return null;
	}

	public String getemail() {
		return null;
	}

	public String getjob_position() {
		return null;
	}

	public String getrate() {
		return null;
	}
}

class Test {
	public static void main(final String[] args) {
		final Scanner scan = new Scanner(System.in);
		final ArrayList<Employee> employees = new ArrayList<Employee>();
		int id = 0;
		boolean exit = false;
		Employee e;
		
		do {
			System.out.println("Select Activity: ");
			System.out.println("1. Add Employee");
			System.out.println("2. Display all Employees");
			System.out.println("3. Update Employee");
			System.out.println("4. Delete Employee");
			System.out.println("5. Compute Salary");
			System.out.println("6. Exit Console");

			System.out.print("Option: ");
			final int option = scan.nextInt();
			
			switch(option) {
				case 1: 
					final int last_id = employees.isEmpty() ? 0 : 1 + employees.get(employees.size() - 1).getID();
					employees.add(addEmployee(last_id)); 
				break;
				case 2: displayEmployees(employees); break;
				case 3: 
					id = inputID();
					e = searchEmployee(id, employees);
					if(e == null) {
						System.out.println("Could not find Employee.");
					} else {
						updateEmployee(e);
					}
				break;
				case 4: 
					id = inputID();
					e = searchEmployee(id, employees);
					if(e == null) {
						System.out.println("Could not find Employee.");
					} else {
						employees.remove(e);
					}
				break;
				case 5:
					id = inputID();
					e = searchEmployee(id, employees);
					System.out.print("Enter Number of Hours: ");
					final double hours = scan.nextDouble();
					System.out.println("Salary: " +  e.getSalary(hours));
					break;
				case 6: exit = true; break;
			}
		} while(!exit);
		scan.close();
	}

	public static Employee addEmployee(final int last_id) {
		final Scanner scan = new Scanner(System.in);
		System.out.print("Enter Employee Name: ");
		final String name = scan.nextLine();
		System.out.print("Enter Employee Rate: ");
		final double rate = scan.nextDouble();
		return new Employee(last_id, name, rate);
	}

	public static void updateEmployee(final Employee employee) {
		final Scanner scan = new Scanner(System.in);
		System.out.println("Select Field to Update: ");
		System.out.println("1. Name");
		System.out.println("2. Rate");
		System.out.print("Option: ");
		final int option = scan.nextInt();
		
		System.out.print("Enter new value: ");
		final String update = scan.next();
		switch(option) {
			case 1: employee.setName(update); break;
			case 2: employee.setRate(Double.parseDouble(update)); break;
		}
}
	

	public static Employee searchEmployee(final int id, final ArrayList<Employee> employees) {
		for (final Employee employee : employees) {
			if (employee.getID() == id) {
				return employee;
			}
		}
		return null;
	}

	public static int inputID() {
		final Scanner scan = new Scanner(System.in);
		System.out.print("Enter Employee ID: ");
		final int n = scan.nextInt();
		return n;
			Scanner in.close();
		
	}

	private static void close() {
	}

	public static void displayEmployees(final ArrayList<Employee> employees) {
		if (employees.isEmpty()) {
			System.out.println("Cannot find employe record.");
			return;
		}
		System.out.println("List of Employees:");
		for (final Employee employee : employees) {
			System.out.println("ID: " + employee.getID() + ", Name: " + employee.getName() + ", Rate: " + employee.getRate());
		}
	}
}


