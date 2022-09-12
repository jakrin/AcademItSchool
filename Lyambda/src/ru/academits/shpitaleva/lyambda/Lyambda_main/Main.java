package ru.academits.shpitaleva.lyambda.Lyambda_main;

import ru.academits.shpitaleva.lyambda.Person;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) {
        Person person1 = new Person("Иван", 25);
        Person person2 = new Person("Мария", 30);
        Person person3 = new Person("Сергей", 38);
        Person person4 = new Person("Иван", 17);
        Person person5 = new Person("Юлия", 25);
        Person person6 = new Person("Юлия", 15);
        Person person7 = new Person("Степан", 10);
        Person person8 = new Person("Константин", 50);

        List<Person> persons = new ArrayList<Person>(Arrays.asList(person1, person2, person3, person4, person5, person6, person7, person8));

        //Получаем и выводим список уникальных имен
        String uniqueNamesString = persons.stream()
                .map(Person::getName).distinct()
                .collect(Collectors.joining(", "));

        System.out.println("Имена: " + uniqueNamesString);
        System.out.println();

        //Получаем список людей младше 18
        List<Person> personsYoungerEighteen = persons.stream().filter(p -> p.getAge() < 18).collect(Collectors.toList());

        System.out.println("Persons younger eighteen:");
        personsYoungerEighteen.forEach(p -> System.out.println(p.getName()));
        System.out.println();

        //Получаем средний возраст людей младше 18
        IntStream ages = personsYoungerEighteen.stream().mapToInt(Person::getAge);
        System.out.println("Average age: " + ages.average());
        System.out.println();

        // При помощи группировки получаем Map, в котором ключи – имена, а значения – средний возраст
        Map<String, Double> personsAverageAgeByName = persons.stream().collect(Collectors.groupingBy(Person::getName, Collectors.averagingInt(Person::getAge)));
        System.out.println("Average age by name:");
        System.out.println(personsAverageAgeByName);
        System.out.println();

        // Получаем людей, возраст которых от 20 до 45, выводим их имена в порядке убывания возраста
        System.out.println("Persons from 20 till 45 (in descending order):");
        persons.stream().filter(p -> (p.getAge() >= 20 && p.getAge() <= 45)).
                sorted((p1, p2) -> p2.getAge() - p1.getAge()).
                map(Person::getName).
                forEach(System.out::println);
    }
}
