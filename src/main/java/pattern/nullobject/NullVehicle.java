package pattern.nullobject;

/*
Applying the Singleton design pattern when creating a NullVehicle object.
Because there can be an infinite number of invalid inputs, you do not want to create the NullVehicle object repeatedly.
* */
public class NullVehicle implements Vehicle {
    // Early initialization
    private static NullVehicle instance = new NullVehicle();
    public static int nullVehicleCount;
    // The constructor is private to prevent the use of "new"
    private NullVehicle() {
        nullVehicleCount++;
        System.out.print("A null vehicle object is created.");
    }
    // Global point of access.
    public static NullVehicle getInstance(){
        return instance;
    }
    @Override
    public void travel(){
        // Do nothing
    }
}
