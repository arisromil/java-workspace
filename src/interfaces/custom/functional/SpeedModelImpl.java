package interfaces.custom.functional;

public class SpeedModelImpl implements SpeedModel {
    public double getSpeedMph(double timeSec,
                              int weightPounds, int horsePower){
        double v = 2.0 * horsePower * 746 *
                timeSec * 32.17 / weightPounds;
        return (double) Math.round(Math.sqrt(v) * 0.68);
    }
}