import javax.management.StandardEmitterMBean;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.function.UnaryOperator;

public class Main {
    private ExtendedList<Integer> list;

    public static void main(String[] args) {
        ExtendedList<Integer> list = new ExtendedList<>();

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

    }
}
