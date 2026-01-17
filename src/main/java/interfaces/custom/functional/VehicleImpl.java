package interfaces.custom.functional;

public class VehicleImpl implements Vehicle {
    private SpeedModel speedModel;
    private int weightPounds, hoursePower;
    public VehicleImpl(int weightPounds, int hoursePower) {
        this.weightPounds = weightPounds;
        this.hoursePower = hoursePower;
    }
    public void setSpeedModel(SpeedModel speedModel){
        this.speedModel = speedModel;
    }
    public double getSpeedMph(double timeSec){
        return this.speedModel.getSpeedMph(timeSec,
                this.weightPounds, this.hoursePower);
    };
}
