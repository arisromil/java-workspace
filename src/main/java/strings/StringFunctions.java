package strings;

public class StringFunctions {

    String stringVariable = "";
    boolean blank = stringVariable.isBlank();

    public void StrippingWhitespace() {
        String nameString = " well hello ";
        System.out.println( nameString.strip() );
        System.out.println( nameString.stripLeading() );
        System.out.println( nameString.stripTrailing() );
    }



}
