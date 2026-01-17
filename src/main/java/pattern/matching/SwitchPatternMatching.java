package pattern.matching;

/*/
Use to efficiently test the same variable against a different number of values.
 */
public class SwitchPatternMatching {

    Object inputObject = 500L;
    String formattedObject = switch (inputObject ) {
        case Integer i -> String.format("int %d", i);
        case Long l -> String.format("long %d", l);
        case Double d -> String.format("double %f", d);
        case String s -> String.format("String %s", s);
        default -> inputObject .toString();
    };

    // output --> long 500
}
