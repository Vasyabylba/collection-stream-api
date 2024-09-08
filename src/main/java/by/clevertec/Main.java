package by.clevertec;

import by.clevertec.model.Animal;
import by.clevertec.model.Car;
import by.clevertec.model.Examination;
import by.clevertec.model.Flower;
import by.clevertec.model.House;
import by.clevertec.model.Person;
import by.clevertec.model.Student;
import by.clevertec.util.Util;

import java.time.LocalDate;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Scanner;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {
        task1();
        task2();
        task3();
        task4();
        task5();
        task6();
        task7();
        task8();
        task9();
        task10();
        task11();
        task12();
        task13();
        task14();
        task15();
        task16();
        task17();
        task18();
        task19();
        task20();
        task21();
        task22();
    }

    public static void task1() {
        List<Animal> animals = Util.getAnimals();
        animals.stream()
                .filter(animal -> {
                    int age = animal.getAge();
                    return age > 9 && age < 21;
                })
                .sorted(Comparator.comparing(Animal::getAge))
                .skip(2 * 7)
                .limit(7)
                .forEach(System.out::println);
    }

    public static void task2() {
        List<Animal> animals = Util.getAnimals();
        animals.stream().
                filter(animal -> animal.getOrigin().equals("Japanese"))
                .peek(animal -> animal.setBread(animal.getBread().toUpperCase()))
                .filter(animal -> animal.getGender().equals("Female"))
                .map(Animal::getBread)
                .forEach(System.out::println);
    }

    public static void task3() {
        List<Animal> animals = Util.getAnimals();
        animals.stream()
                .filter(animal -> animal.getAge() > 30)
                .map(Animal::getOrigin)
                .filter(origin -> origin.startsWith("A"))
                .distinct()
                .forEach(System.out::println);
    }

    public static void task4() {
        List<Animal> animals = Util.getAnimals();
        long femaleCount = animals.stream()
                .filter(animal -> animal.getGender().equals("Female"))
                .count();
        System.out.println(femaleCount);
    }

    public static void task5() {
        List<Animal> animals = Util.getAnimals();
        boolean hasHungarianAnimal = animals.stream()
                .filter(animal -> {
                    int age = animal.getAge();
                    return age >= 20 & age <= 30;
                })
                .anyMatch(animal -> animal.getOrigin().equals("Hungarian"));
        System.out.println(hasHungarianAnimal);
    }

    public static void task6() {
        List<Animal> animals = Util.getAnimals();
        boolean allAreMaleOrFemale = animals.stream()
                .allMatch(animal -> {
                    String gender = animal.getGender();
                    return gender.equals("Male") || gender.equals("Female");
                });
        System.out.println(allAreMaleOrFemale);
    }

    public static void task7() {
        List<Animal> animals = Util.getAnimals();
        boolean noneFromOceania = animals.stream()
                .noneMatch(animal -> animal.getOrigin().equals("Oceania"));
        System.out.println(noneFromOceania);
    }

    public static void task8() {
        List<Animal> animals = Util.getAnimals();
        Optional<Integer> optionalMaxAge = animals.stream()
                .sorted(Comparator.comparing(Animal::getBread))
                .limit(100)
                .map(Animal::getAge)
                .max(Comparator.comparing(Function.identity()));
        if (optionalMaxAge.isPresent()) {
            System.out.println(optionalMaxAge.get());
        } else {
            System.out.println("No animals found");
        }
    }

    public static void task9() {
        List<Animal> animals = Util.getAnimals();
        Integer minLength = animals.stream()
                .map(Animal::getBread)
                .map(String::toCharArray)
                .map(chars -> chars.length)
                .min(Comparator.comparing(Function.identity()))
                .orElse(0);
        System.out.println(minLength);
    }

    public static void task10() {
        List<Animal> animals = Util.getAnimals();
        int totalAge = animals.stream()
                .mapToInt(Animal::getAge)
                .sum();
        System.out.println(totalAge);
    }

    public static void task11() {
        List<Animal> animals = Util.getAnimals();
        double averageAge = animals.stream()
                .filter(animal -> animal.getOrigin().equals("Indonesian"))
                .mapToInt(Animal::getAge)
                .average()
                .orElse(0.0);
        System.out.println(averageAge);
    }

    public static void task12() {
        List<Person> persons = Util.getPersons();
        persons.stream()
                .filter(person -> person.getGender().equals("Male"))
                .filter(person -> {
                    LocalDate now = LocalDate.now();
                    int age = person.getDateOfBirth().until(now).getYears();
                    return age >= 18 && age <= 27;
                })
                .sorted(Comparator.comparing(Person::getRecruitmentGroup))
                .limit(200)
                .forEach(System.out::println);
    }

    public static void task13() {
        List<House> houses = Util.getHouses();
//        houses.stream() Продолжить ...
    }

    public static void task14() {
        List<Car> cars = Util.getCars();
//        cars.stream() Продолжить ...
    }

    public static void task15() {
        List<Flower> flowers = Util.getFlowers();
//        flowers.stream() Продолжить ...
    }

    public static void task16() {
        List<Student> students = Util.getStudents();
        students.stream()
                .filter(student -> student.getAge() < 18)
                .sorted(Comparator.comparing(Student::getSurname))
                .forEach(student -> System.out.println(student.getSurname() + "(age=" + student.getAge() + ")"));
    }

    public static void task17() {
        List<Student> students = Util.getStudents();
        students.stream()
                .map(Student::getGroup)
                .distinct()
                .forEach(System.out::println);
    }

    public static void task18() {
        List<Student> students = Util.getStudents();
        Map<String, Double> averageAgeByFaculty = students.stream()
                .collect(Collectors.groupingBy(Student::getFaculty, Collectors.averagingInt(Student::getAge)));
        averageAgeByFaculty.entrySet().stream()
                .sorted(Map.Entry.<String, Double>comparingByValue().reversed())
                .forEach(entry -> System.out.println("faculty = " + entry.getKey() + ", average age = " + entry.getValue()));
    }

    public static void task19() {
        List<Student> students = Util.getStudents();
        List<Examination> examinations = Util.getExaminations();
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println("Enter group number:");
            String targetGroup = scanner.next().strip();
            if (targetGroup.isBlank()) {
                throw new IllegalArgumentException("The group number must not be empty!!!");
            }
            Map<Integer, List<Examination>> studentExamsMap = examinations.stream()
                    .collect(Collectors.groupingBy(Examination::getStudentId));
            List<Student> passedStudents = students.stream()
                    .filter(student -> student.getGroup().equals(targetGroup))
                    .filter(student -> studentExamsMap.containsKey(student.getId()))
                    .filter(student -> studentExamsMap.get(student.getId()).stream()
                            .anyMatch(exam -> exam.getExam3() > 4))
                    .toList();
            if (passedStudents.isEmpty()) {
                System.out.println("No passed students found in group " + targetGroup);
            } else {
                passedStudents.forEach(System.out::println);
            }
        }
    }

    public static void task20() {
        List<Student> students = Util.getStudents();
        List<Examination> examinations = Util.getExaminations();
        Map<String, List<Integer>> studentIdByFaculty = students.stream()
                .collect(Collectors.groupingBy(Student::getFaculty,
                        Collectors.mapping(Student::getId, Collectors.toList())));
        Map<Integer, Double> averageExam1ByStudentId = examinations.stream()
                .collect(Collectors.groupingBy(
                        Examination::getStudentId,
                        Collectors.averagingInt(Examination::getExam1)
                ));
        Map<String, Double> averageExam1ByFaculty = studentIdByFaculty.entrySet().stream()
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        entry -> entry.getValue().stream()
                                .mapToDouble(studentId ->
                                        averageExam1ByStudentId.getOrDefault(studentId, 0.0)
                                )
                                .average()
                                .orElse(0.0)
                ));
        String facultyWithMaxAverage = averageExam1ByFaculty.entrySet().stream()
                .max(Map.Entry.comparingByValue())
                .map(Map.Entry::getKey)
                .orElse("Unknown Faculty");
        System.out.println(facultyWithMaxAverage);
    }

    public static void task21() {
        List<Student> students = Util.getStudents();
//        students.stream() Продолжить ...
    }

    public static void task22() {
        List<Student> students = Util.getStudents();
//        students.stream() Продолжить ...
    }
}
