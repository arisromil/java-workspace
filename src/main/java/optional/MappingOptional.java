package optional;

import java.util.Optional;
import java.util.stream.Stream;

//apply a function to a collection of Optional instances, but only if they contain a value
public class MappingOptional {
    public static void main(String[] args) {

        Optional<String> firstOdd =
                Stream.of("fiver", "three", "four")
                        .filter( s -> s.length() % 2 != 0)
                        .findFirst();
        System.out.println(firstOdd.orElse("no odd length strings"));
    }
}
