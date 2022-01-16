import java.util.Comparator;
import java.util.Optional;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class BuiltinFuncInterfaces {
    public static void main(String[] args) {
        Predicate<Integer> isPositive = i -> i > 0;
        System.out.println(isPositive.test(5));

        Predicate<Integer> isZero = i -> i == 0;
        System.out.println(isZero.test(5));

        Predicate<Integer> isNegative = isPositive.or(isZero).negate();
        System.out.println(isPositive.test(-5));

        Function<Person, String> getName = Person::getName;
        Function<String, Character> firstChar = s -> s.charAt(0);
        Function<Person, Character> firstCharName = getName.andThen(firstChar);
        System.out.println(firstCharName.apply(new Person("Kirillovishville", "Shabanovidze")));

        Supplier<Person> supplier = Person::new;
        Person person = supplier.get();
        System.out.println(person);


        Consumer<Person> consumer = p -> System.out.printf("Hello, %s%n", p.getName());
        consumer.accept(new Person("Kirillovishville", "Shabanovidze"));


        //Сравниватель
        Comparator<Person> comparator = (p1, p2) -> p1.getName().compareTo(p2.getName());
        Person person1 = new Person("John", "Doe");
        Person person2 = new Person("Alice", "Krige");
        System.out.println(
                comparator.compare
                        (person1, person2));


        //Обработка нулевых значений

        Optional<String> isEmpty = Optional.empty();
        if (!isEmpty.isEmpty())
            System.out.println(isEmpty.get());


        Optional<String> isNotEmpty = Optional.of("");
        isNotEmpty.ifPresent(s -> System.out.println(isNotEmpty.isPresent()));
        System.out.println(isNotEmpty.get());


        Optional<String> optionalS = Optional.ofNullable(null);
        System.out.println(optionalS.isPresent());


    }

}
