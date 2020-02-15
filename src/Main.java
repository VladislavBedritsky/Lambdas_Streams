import java.util.function.BinaryOperator;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.function.UnaryOperator;
import java.util.stream.Stream;

public class Main {
    private static ExtendedList<Integer> list;

    public static void main(String[] args) {
        list = new ExtendedList<>();

    // map
        UnaryOperator<Integer> square = x -> x*x;
        list.map(square);
        System.out.println("____________");

     // feel
        Consumer<Integer> consumer = list::add;
        list.feel(consumer);
        list.forEach(System.out::println);
        System.out.println("____________");

    // forAll
        Predicate<Integer> predicate = (val) -> val % 2 == 0;
        System.out.println(list.forAll(predicate));
        System.out.println("____________");

    // predicate
        list.partition(predicate).forEach(x -> x.forEach(System.out::println));
        System.out.println("____________");

    // reduce
        Integer monoid = 0;
        BinaryOperator<Integer> binaryOperator = Integer::sum; // (x,y) -> x + y
        list.reduce(binaryOperator,monoid);
    }
}
