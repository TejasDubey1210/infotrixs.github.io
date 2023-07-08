
package EmployeeSystem;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;
public class Demo {
    private static final String FILE_NAME = "employee_data.txt";

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        Scanner s1 = new Scanner(System.in);
        int ch;
        do {
            List<Employee> c = loadEmployeesFromFile();

            System.out.println("1.Insert Employee Information");
            System.out.println("2.Display all Employee");
            System.out.println("3.Search Employee");
            System.out.println("4.Delete Employee Information");
            System.out.println("5.Update Employee Data");
            System.out.println("0.Exit");

            System.out.println("***** ENTER YOUR CHOICE *****");
            ch = s.nextInt();

            switch (ch) {
                case 1:
                    System.out.print("Enter Employee Number: ");
                    int eno = s.nextInt();
                    System.out.print("Enter Employee Name: ");
                    String ename = s1.nextLine();
                    System.out.print("Enter Employee Salary: ");
                    int salary = s.nextInt();

                    c.add(new Employee(eno, ename, salary));
                    saveEmployeesToFile(c);
                    break;
                case 2:
                    System.out.println("------------------------------");
                    displayEmployees(c);
                    System.out.println("------------------------------");
                    break;
                case 3:
                    boolean found=false;
                    System.out.println(" Enter Empno to Search Employee ");
                    int empno=s.nextInt();
                    System.out.println("------------------------------");
                    Iterator<Employee>i=c.iterator();
                    while(i.hasNext())
                    {
                    	Employee e=i.next();
                    	if(e.getEmpno()==empno)
                    	{
                    		System.out.println(e);
                    		found=true;
                    	}
                    }
                    System.out.println("------------------------------");
                    if(!found)
                    {
                    	System.out.println(" Record Not Found ");
                    }
                    System.out.println("------------------------------");
                    break;
                case 4:
                
                	 System.out.print("Enter Employee number to delete: ");
                     int empno1 = s.nextInt();
                     boolean deleted = deleteEmployee(c, empno1);
                     if (deleted) {
                         saveEmployeesToFile(c);
                         System.out.println("Employee record deleted successfully.");
                     } else {
                         System.out.println("Employee record not found.");
                     }
                     break;
                    
                case 5:
                	 System.out.print("Enter Employee number to update: ");
                     int empnoToUpdate = s.nextInt();
                     boolean updated = updateEmployee(c, empnoToUpdate);
                     if (updated) {
                         saveEmployeesToFile(c);
                         System.out.println("Employee record updated successfully.");
                     } else {
                         System.out.println("Employee record not found.");
                     }
                     break;
            }
        } while (ch != 0);
    }

    private static List<Employee> loadEmployeesFromFile() {
        List<Employee> employees = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_NAME))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] employeeData = line.split(",");
                int empno = Integer.parseInt(employeeData[0]);
                String ename = employeeData[1];
                int salary = Integer.parseInt(employeeData[2]);
                employees.add(new Employee(empno, ename, salary));
            }
            System.out.println("Data loaded from " + FILE_NAME + " successfully.");
        } catch (IOException e) {
            System.out.println("Error reading data from file: " + e.getMessage());
        }
        return employees;
    }

    private static boolean deleteEmployee(List<Employee> employees, int empno) {
        Iterator<Employee> iterator = employees.iterator();
        boolean deleted = false;
        while (iterator.hasNext()) {
            Employee employee = iterator.next();
            if (employee.getEmpno() == empno) {
                iterator.remove();
                deleted = true;
            }
        }
        return deleted;
    }


    private static void saveEmployeesToFile(List<Employee> employees) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_NAME))) {
            for (Employee employee : employees) {
                writer.write(employee.getEmpno() + "," + employee.getEname() + "," + employee.getSalary());
                writer.newLine();
            }
            System.out.println(" ** Data added successfully ** ");
        } catch (IOException e) {
            System.out.println("Error writing data to file: " + e.getMessage());
        }
    }

    private static void displayEmployees(List<Employee> employees) {
        if (employees.isEmpty()) {
            System.out.println("No employee records found.");
        } else {
            for (Employee employee : employees) {
                System.out.println(employee);
            }
        }
    }
    
    private static boolean updateEmployee(List<Employee> employees, int empno) {
        for (Employee employee : employees) {
            if (employee.getEmpno() == empno) {
                Scanner s = new Scanner(System.in);
                Scanner s1 = new Scanner(System.in);

                System.out.print("Enter New Employee Name: ");
                String newEname = s1.nextLine();
                System.out.print("Enter New Employee Salary: ");
                int newSalary = s.nextInt();

                employee.setEname(newEname);
                employee.setSalary(newSalary);

                return true;
            }
        }
        return false;
    }
} 














    
		
	


