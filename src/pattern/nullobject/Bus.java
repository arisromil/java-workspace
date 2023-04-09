package pattern.nullobject;

public class Bus implements Vehicle {
    public static int busCount = 0;
    public Bus() {
        busCount++;
    }
    @Override
    public void travel() {
        System.out.println("A Bus travelling.");
    }
}
