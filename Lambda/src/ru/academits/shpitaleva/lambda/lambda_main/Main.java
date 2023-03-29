package ru.academits.shpitaleva.lambda.lambda_main;

import ru.academits.shpitaleva.lambda.Person;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        List<Person> persons = new ArrayList<>();
        persons.add(new Person("Иван", 25));
        persons.add(new Person("Мария", 30));
        persons.add(new Person("Сергей", 38));
        persons.add(new Person("Иван", 17));
        persons.add(new Person("Юлия", 25));
        persons.add(new Person("Юлия", 15));
        persons.add(new Person("Степан", 10));
        persons.add(new Person("Константин", 50));

        // Получаем и выводим список уникальных имен
        String uniqueNamesString = persons.stream()
                .map(Person::getName)
                .distinct()
                .collect(Collectors.joining(", ", "Имена: ", "."));

        System.out.println(uniqueNamesString);
        System.out.println();

        // Получаем список людей младше 18
        List<Person> personsYoungerEighteen = persons.stream()
                .filter(p -> p.getAge() < 18)
                .collect(Collectors.toList());

        System.out.println("Persons younger eighteen:");
        personsYoungerEighteen.forEach(p -> System.out.println(p.getName()));
        System.out.println();

        // Получаем средний возраст людей младше 18
        System.out.println("Average age: " + personsYoungerEighteen.stream()
                .mapToInt(Person::getAge).average());
        System.out.println();

        // При помощи группировки получаем Map, в котором ключи – имена, а значения – средний возраст
        Map<String, Double> personsAverageAgeByName = persons.stream().collect(Collectors.groupingBy(Person::getName, Collectors.averagingInt(Person::getAge)));
        System.out.println("Average age by name:");
        System.out.println(personsAverageAgeByName);
        System.out.println();

        // Получаем людей, возраст которых от 20 до 45, выводим их имена в порядке убывания возраста
        System.out.println("Persons from 20 till 45 (in descending order):");
        persons.stream()
                .filter(p -> p.getAge() >= 20 && p.getAge() <= 45)
                .sorted((p1, p2) -> p2.getAge() - p1.getAge())
                .map(Person::getName)
                .forEach(System.out::println);
    }
}
