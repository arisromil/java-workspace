package interfaces.custom.functional;

public class ExampleTest {


    private static void useCustomFunctionalInterface() {
        Vehicle vehicle = new VehicleImpl(3000, 200);
        SpeedModel speedModel = new SpeedModelImpl();
        vehicle.setSpeedModel(speedModel);
        System.out.println(vehicle.getSpeedMph(10.)); //prints: 122.0

        SpeedModel speedModel1 =  (t, wp, hp) -> {
            double v = 2.0 * hp * 746 * t * 32.17 / wp;
            return (double) Math.round(Math.sqrt(v) * 0.68);
        };

        speedModel = new SpeedModel(){
            public double getSpeedMph(double timeSec, int weightPounds, int horsePower){
                double v = 2.0 * horsePower * 746 * timeSec * 32.17 / weightPounds;
                return (double) Math.round(Math.sqrt(v) * 0.68);
            }
            public void m1(){}
            public void m2(){}
        };

        vehicle.setSpeedModel(speedModel);
        System.out.println(vehicle.getSpeedMph(10.)); //prints: 122.0
    }
}
