import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/**
 * @author Sam Gao
 * @date 05/22/20 9:26
 */
public class test2 {


    public static void main(String[] args) {
        Person lokesh = new Person(1, "Lokesh", "Gupta");
        Person brian = new Person(2, "Brian", "Clooney");
        Person alex = new Person(3, "Alex", "Kolen");
        Person alex1 = new Person(3, "Alex", "Kolen");

        //Add some random persons
        Collection<Person> list = Arrays.asList(lokesh, brian, alex, lokesh, brian, lokesh);

        // Get distinct objects by key
        List<Person> distinctElements = list.stream()
                                            .filter(distinctByKey(Person::getId))
                                            .collect(Collectors.toList());

        // Let's verify distinct elements
        System.out.println(distinctElements);
    }

    //Utility function
    public static <T> Predicate<T> distinctByKey(Function<? super T, Object> keyExtractor) {
        Map<Object, Boolean> map = new ConcurrentHashMap<>();
        return t -> map.putIfAbsent(keyExtractor.apply(t), Boolean.TRUE) == null;
    }


    //Model class

}
