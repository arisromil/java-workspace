package pattern.nullobject;

public class Train implements Vehicle {
    public static int trainCount = 0;
    public Train() {
        trainCount++;
    }
    @Override
    public void travel() {
        System.out.println("A Train Travelling. choo choo");
    }
}