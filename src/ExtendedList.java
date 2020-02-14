import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.function.UnaryOperator;

public class ExtendedList<T> extends ArrayList<T> {

    private List<Integer> list = Arrays.asList(1,2,3,4,8,2);

    public void map(UnaryOperator<Integer> square) {
            for (Integer temp: list) {
                System.out.println(square.apply(temp));
            }
    }

    public void feel(Consumer<Integer> consumer) {
        for (int i = 0; i < 5; i++) {
            consumer.accept((int) (Math.random() * 100));
        }
    }

    public boolean forAll (Predicate<Integer> predicate) {
        int counter = 0;
        for (Integer temp : list) {
            if (predicate.test(temp)) {
                counter++;
            }
        }
        return counter == list.size();
    }

    public List<ArrayList<Integer>> partition (Predicate<Integer> predicate) {
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
}
