package optional;

import java.util.Optional;
import java.util.stream.Stream;

//
// Optional is designed to communicate to the user when a returned value may be legitimately be null
//
public class OptionalExample {


    // Creating an Optional with `ofNullable`
    public static <T> Optional<T> createOptionalEasyWay(T value) {
        return Optional.ofNullable(value);
    }

    public static void main(String[] args) {

        Optional<String> firstOdd =
                Stream.of("fiver", "three", "four")
                                .filter( s -> s.length() % 2 != 0)
                                .findFirst();
        System.out.println(firstOdd.orElse("no odd length strings"));
    }

}
