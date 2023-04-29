package collection;

import java.util.List;
import java.util.Map;

/*
 Generate an immutable collection (its state does not change after it is
constructed) of values

Utilize the Collection.of() construct
 */
public class ImmutableCollection {
    public static void main(String[] args){
        List<String> jvmLanguages = List.of("Java", "CSharp", "Ruby", "Python");
        System.out.println(jvmLanguages);
        try {
            jvmLanguages.add("Exception");
        } catch (UnsupportedOperationException uoe){
            System.out.println(uoe);
        }

        Map<Integer, String> players = Map.of(1, "Lebron", 2,"Brady", 3, "Kobe");
        System.out.println(players.values());
        
        try {
            players.put(5,"Exception");
        } catch (UnsupportedOperationException uoe){
            System.out.println(uoe);
        }
    }
}
