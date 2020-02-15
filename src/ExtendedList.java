import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.BinaryOperator;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.function.UnaryOperator;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ExtendedList<T> extends ArrayList<T> {

    private List<Integer> list = Arrays.asList(1,2,3,4,8,2);

    void map(UnaryOperator<Integer> square) {
            for (Integer temp: list) {
                System.out.println(square.apply(temp));
            }
    }

    void feel(Consumer<Integer> consumer) {
        for (int i = 0; i < 5; i++) {
            consumer.accept((int) (Math.random() * 100));
        }
    }

    boolean forAll(Predicate<Integer> predicate) {
        int counter = 0;
        for (Integer temp : list) {
            if (predicate.test(temp)) {
                counter++;
            }
        }
        return counter == list.size();
    }

    List<ArrayList<Integer>> partition(Predicate<Integer> predicate) {
        List<ArrayList<Integer>> result = new ArrayList<>();
        ArrayList<Integer> oddList = new ArrayList<>();
        ArrayList<Integer> evenList = new ArrayList<>();

        for (Integer temp : list) {
            if (predicate.test(temp)) {
                evenList.add(temp);
            }else {
                oddList.add(temp);
            }
        }
        result.add(evenList);
        result.add(oddList);
        return result;
    }

    void reduce(BinaryOperator<Integer> binaryOperator, Integer monoid) {

        int result = 0;
        for (Integer temp : Stream.of(2,4,1,6).collect(Collectors.toList())) {
            result += binaryOperator.apply(temp,monoid);
        }
        System.out.println(result);
    }
}
