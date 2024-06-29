import java.util.HashSet;
import java.util.List;
import java.util.OptionalInt;
import java.util.Set;

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


    }
}