package Java_Advanced_May_2024._06_Defining_Classes._02_Exercise._02_Company_Roster;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        ArrayList<Employee> listOfEmployees = new ArrayList<>();
        Map<String, Department> departmentMap = new HashMap<>();

        int num = Integer.parseInt(scan.nextLine());
        for (int i = 0; i < num; i++) {
            String[] info = scan.nextLine().split("\\s+");
            int size = info.length;
            String name = info[0];
            double salary = Double.parseDouble(info[1]);
            String position = info[2];
            String department = info[3];

            Employee employee;

            if (size == 4) {
                employee = new Employee(name, salary, position, department);
            } else if (size == 5) {
                if (info[4].length() > 3) {
                    String email = info[4];
                    employee = new Employee(name, salary, position, department, email);
                } else {
                    int age = Integer.parseInt(info[4]);
                    employee = new Employee(name, salary, position, department, age);
                }
            } else {
                String email = info[4];
                int age = Integer.parseInt(info[5]);
                employee = new Employee(name, salary, position, department, email, age);
            }

            departmentMap.putIfAbsent(department, new Department(department)); // put if absent new department;
            departmentMap.get(department).getEmployees().add(employee); // add the new employee
            listOfEmployees.add(employee);
        }

        Department highestPaidDepartment = departmentMap.entrySet().stream()
                .max(Comparator.comparingDouble(e -> e.getValue().calculateAverageSalary())).get().getValue();

        highestPaidDepartment.getEmployees().stream()
                .sorted((e1, e2) -> Double.compare(e2.getSalary(), e1.getSalary()))
                .forEach(System.out::println);
//
//
//
//        // use groupingBy in order to collect into Map of Department each employee in the list
//        Map<String, List<Employee>> departmentMap = listOfEmployees
//                .stream()
//                .collect(groupingBy(Employee::getDepartment));
//
//        // We use custom sorting in order to sort the department with the highest salary at the top of the List
//        // and then apply findFirst()
//        Map.Entry<String, List<Employee>> highestSalaryDepartment = departmentMap.entrySet()
//                .stream()
//                .sorted((entryOne, entryTwo) -> {
//                    double employee1AverageSalary = entryOne.getValue()
//                            .stream().
//                            mapToDouble(Employee::getSalary)
//                            .average()
//                            .getAsDouble();
//
//                    double employee2AverageSalary = entryTwo.getValue()
//                            .stream()
//                            .mapToDouble(Employee::getSalary)
//                            .average()
//                            .getAsDouble();
//
//                    return Double.compare(employee2AverageSalary, employee1AverageSalary);
//                })
//
//                .findFirst()
//                .orElse(null);
//
//
//        System.out.printf("Highest Average Salary: %s%n", highestSalaryDepartment.getKey());
//        highestSalaryDepartment.getValue()
//                .stream()
//                .sorted((e1, e2) -> Double.compare(e2.getSalary(), e1.getSalary()))
//                .forEach(System.out::println);
    }
}
