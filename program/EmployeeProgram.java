package exercicios.clasAtrMet.lista.program;

import exercicios.clasAtrMet.lista.entities.Employee;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class EmployeeProgram {
    public static void main(String[] args) {
        Locale.setDefault(Locale.UK);
        Scanner scanner = new Scanner(System.in);

        List<Employee> employeeList = new ArrayList<>();

        System.out.print("How many employees will be registered? ");
        int n = scanner.nextInt();
        for (int i = 0; i < n; i++) {
            System.out.println("Emplyoee #" + (1 + i) + ":");
            System.out.print("id: ");
            int id = scanner.nextInt();
            System.out.print("Name: ");
            scanner.nextLine();
            String name = scanner.nextLine();
            System.out.print("Salary: ");
            double salary = scanner.nextDouble();
            Employee employee = new Employee(id, name, salary);
            employeeList.add(employee);
        }
        System.out.print("Enter the employee id that will have salary increase: ");
        int employeeId = scanner.nextInt();
        Employee employee = employeeList.stream().filter(x -> x.getId() == employeeId).findFirst().orElse(null);

        if ((employee == null)){
            System.out.println("This id does not exist!");
            System.out.println("List of employees:");
            for (Employee emp : employeeList){
                System.out.println(emp);
            }
            } else {
            System.out.print("Enter the percentage: ");
            double percentage = scanner.nextDouble();
            employee.increaseSalary(percentage);
            System.out.println("List of employees:");
            System.out.println(employee);
        }

        scanner.close();
    }
}
