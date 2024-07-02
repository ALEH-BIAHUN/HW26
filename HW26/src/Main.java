import java.util.*;
import java.util.regex.Pattern;

import static java.util.Arrays.stream;

public class Main {
    public static void main(String[] args) {
        //Task1
        Set<Set<String>> sets = new HashSet<>();
        Set<String> strings = new HashSet<>();
        strings.add("раз");
        strings.add("два");
        strings.add("три");
        Set<String> strings2 = new HashSet<>();
        strings2.add("Первое");
        strings2.add("Второе");
        strings2.add("Семьдесят шестое");
        Set<String> strings3 = new HashSet<>();
        strings3.add("12");
        strings3.add("783");
        strings3.add("37288736");
        Set<String> strings4 = new HashSet<>();
        strings4.add("Проверка");
        strings4.add("Струн");
        strings4.add("Раз-Два");

        sets.add(strings);
        sets.add(strings2);
        sets.add(strings3);
        sets.add(strings4);

        //todo Решение дз 1 тут

        int theTotalNumberOfLettersInTheCollection = sets.stream()
                .flatMap(Set::stream)
                .mapToInt(String::length)
                .sum();
        System.out.println("\n The total number of letters in the entire collection is: " + theTotalNumberOfLettersInTheCollection);

        int theLengthOfTheLongestWord = sets.stream()
                .flatMap(Set::stream)
                .mapToInt(String::length)
                .max().getAsInt();
        System.out.println(" The longest word consists of " + theLengthOfTheLongestWord + " letters");

        //Task2
        List<Employee> employees = EmployeeFactory.createEmployee();
        //todo решения дз 2 тут

        Employee employee =  employees.stream().max(Comparator.comparingInt(Employee::getKpi)).get();
        System.out.println("\n The employee with the highest KPI :" + employee);

        System.out.println("*****************************************");

        employees.stream()
                .filter(person -> person.getAge() > 65)
                .peek(person -> System.out.println("An employee who is over 65 years old :"))
                .forEach(System.out::println);

        System.out.println("*****************************************");

        Employee employee1 =  employees.stream()
                .max(Comparator.comparingInt(Employee::getSalary))
                .get();
        System.out.println("An employee with the highest salary :" + employee1);

        System.out.println("*****************************************");

        Pattern latinPattern = Pattern.compile("[A-Za-z]+");

        employees.stream()
                .filter(s -> latinPattern.matcher(s.getName()).matches())
                .peek(person -> System.out.println("A non-Russian employee :"))
                .forEach(System.out ::println);

        System.out.println("*****************************************");

        double averageKpi = employees.stream()
                .mapToDouble(Employee::getKpi)
                .average().getAsDouble();

        System.out.println("Employees with KPI above average:");
        employees.stream()
                .filter(s -> s.getKpi() > averageKpi)
                .forEach(System.out ::println);

        System.out.println("The average Kpi is: " + averageKpi);

        System.out.println("*****************************************");

        Pattern russianPattern = Pattern.compile("[А-я]+");

        double theAverageKpiValueAmongRussianEmployeesemployees =
                employees.stream()
                .filter(s-> russianPattern.matcher(s.getName()).matches())
                .filter(person -> person.getAge() < 45)
                .filter(salary -> salary.getSalary() > 20000)
                .mapToDouble(Employee::getKpi)
                .average().getAsDouble();

        System.out.println("Russian employees who are younger than 45 years old and whose salary is greater than 20000: ");
        employees.stream()
                .filter(s-> russianPattern.matcher(s.getName()).matches())
                .filter(person -> person.getAge() < 45)
                .filter(salary -> salary.getSalary() > 20000)
                .forEach(System.out ::println);

        System.out.println("The average KPI value among Russian employees who are younger than 45 years old " +
                "and whose salary is greater than 20000: " + theAverageKpiValueAmongRussianEmployeesemployees);


    }
}