package ua.opnu;
import java.util.Arrays;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Consumer;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.

//Завдання 1
class Task1 {
    public static void main(String[] args) {
        System.out.println("Завдання 1: Напишіть предикат, який повертає true, якщо число є простим.\n");

        int[] numbers = {1, 4, 5, 7, 9, 11, 14, 17, 79, 97, 99};

        Predicate<Integer> isPrime = n -> {
            if (n < 2) return false;
            for (int i = 2; i <= Math.sqrt(n); i++)
                if (n % i == 0) return false;
            return true;
        };

        int[] result = Arrays.stream(numbers)
                .filter(isPrime::test)
                .toArray();

        System.out.println("Прості числа: " + Arrays.toString(result));
    }
}

class Student {
    private String name;
    private String surname;
    private String group;
    private int[] marks;

    public Student(String name, String surname, String group, int[] marks) {
        this.name = name;
        this.surname = surname;
        this.group = group;
        this.marks = marks;
    }

    public String getName() { return name; }
    public String getSurname() { return surname; }
    public String getGroup() { return group; }

    public int getDebtsCount() {
        int c = 0;
        for (int m : marks) if (m < 60) c++;
        return c;
    }

    @Override
    public String toString() {
        return surname + " " + name + " (" + group + ") " + Arrays.toString(marks);
    }
}

//Завдання 2
class Task2 {
    public static void main(String[] args) {
        System.out.println("Завдання 2: Дан наступний клас Student. У випадку необхідності додайте потрібні гетери, сетери...\n");

        Student[] students = {
                new Student("Дар'я", "Жиган", "AI-245", new int[]{75, 82, 91, 64, 61}),
                new Student("Марія", "Донік", "AI-244", new int[]{30, 70, 60, 85, 76}),
                new Student("Богдан", "Спиридонов", "AI-245", new int[]{100, 88, 100, 100, 89}),
                new Student("Леонід", "Інший", "AI-242", new int[]{40, 55, 60, 70, 90})
        };

        Predicate<Student> hasNoDebts = s -> s.getDebtsCount() == 0;
        Arrays.stream(students)
                .filter(hasNoDebts)
                .forEach(System.out::println);
    }
}

//Завдання 3
class Task3 {
    public static void main(String[] args) {
        System.out.println("Завдання 3: Напишіть метод фільтрації за двома умовами (два предикати). Елемент...\n");

        int[] numbers = {3, 8, 10, 12, 16, 18, 21, 25, 30};
        Predicate<Integer> isEven = n -> n % 2 == 0;
        Predicate<Integer> greaterThanTen = n -> n > 10;

        int[] result = Arrays.stream(numbers)
                .filter(n -> isEven.test(n) && greaterThanTen.test(n))
                .toArray();

        System.out.println("Результат: " + Arrays.toString(result));
    }
}

//Завдання 4
class Task4 {
    public static void main(String[] args) {
        System.out.println("Завдання 4: Напишіть інтерфейс Consumer, який приймає на вхід об'єкт типу Student...");

        Student[] students = {
                new Student("Дар'я", "Жиган", "AI-245", new int[]{80, 90, 100}),
                new Student("Марія", "Донік", "AI-244", new int[]{75, 82, 90})
        };

        Consumer<Student> printFullName = s -> System.out.println(s.getSurname() + " " + s.getName());

        forEach(students, printFullName);
    }

    public static void forEach(Student[] arr, Consumer<Student> action) {
        for (Student s : arr) action.accept(s);
    }
}

//Завдання 5
class Task5 {
    public static void main(String[] args) {
        System.out.println("Завдання 5: Напишіть метод, який приймає Predicate та Consumer. Дія в Consumer...\n");

        int[] numbers = {3, 7, 10, 12, 15, 18, 21, 30};

        Predicate<Integer> isEven = n -> n % 2 == 0;
        Consumer<Integer> print = n -> System.out.println("Число " + n + " проходить фыльтр");

        process(numbers, isEven, print);
    }

    public static void process(int[] arr, Predicate<Integer> condition, Consumer<Integer> action) {
        for (int n : arr)
            if (condition.test(n))
                action.accept(n);
    }
}

//Завдання 6
class Task6 {
    public static void main(String[] args) {
        System.out.println("Завдання 6: Напишіть Function, який приймає на вхід ціле число n та повертає ціле число 2^n...\n");

        int[] numbers = {1, 2, 3, 4, 5, 6, 7, 8, 10};
        Function<Integer, Integer> powerOfTwo = n -> (int) Math.pow(2, n);

        int[] result = Arrays.stream(numbers)
                .map(n -> powerOfTwo.apply(n))
                .toArray();

        System.out.println("Вхідні числа: " + Arrays.toString(numbers));
        System.out.println("2^n: " + Arrays.toString(result));
    }
}

//Завдання 7
class Task7 {
    public static void main(String[] args) {
        System.out.println("Завдання 7: Напишіть метод stringify(), який приймає на вхід масив цілих чисел від 0 до...\n");

        int[] numbers = {1, 2, 3, 4, 5, 6, 7, 8, 9, 24};

        Function<Integer, String> numberToWord = n -> {
            switch (n) {
                case 1: return "один";
                case 2: return "два";
                case 3: return "три";
                case 4: return "чотири";
                case 5: return "п'ять";
                case 6: return "шість";
                case 7: return "сім";
                case 8: return "вісім";
                case 9: return "дев'ять";
                default: return "невідомо";
            }
        };

        String[] result = stringify(numbers, numberToWord);

        System.out.println("Вхіднічисла:  " + Arrays.toString(numbers));
        System.out.println("Словами: " + Arrays.toString(result));
    }

    public static String[] stringify(int[] arr, Function<Integer, String> function) {
        String[] result = new String[arr.length];
        for (int i = 0; i < arr.length; i++) {
            result[i] = function.apply(arr[i]);
        }
        return result;
    }
}
