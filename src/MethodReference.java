public class MethodReference {
    public static void main(String[] args) {
        Converter<String, Integer> converter = Integer::valueOf;
        Integer i = converter.convert("22");
        System.out.println(i);
        Converter<Integer, String> converter1 = String::valueOf;
        String s = converter1.convert(22);
        System.out.println(s);


        Converter<String, Character> converter3 = StringsOperations::firstChar;
        System.out.println(converter3.convert("Japan"));


        PersonFactory<Person> personFactory = Person::new;
        Person person = personFactory.create("Kirill", "Shabanovidze");
        System.out.println(person);

    }
}

@FunctionalInterface
interface Converter<S, T> {
    T convert(S obj);

}

class StringsOperations {

    public static Character firstChar(String s) {
        return s.charAt(0);
    }
}

interface PersonFactory<P extends Person> {

    P create(String name, String surName);
}