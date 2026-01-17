package interfaces.method;

/*
In Java 9 onwards, the ability to include private methods within an interface.
A private method is only available within that interface, and it cannot be used by any class that implements the interface.
However, each default method implementation that is part of the interface can use the private method.
 */
public interface Pool {

    public default double squareOrRectConstantDepth(double length, double
            width, double depth){
        return volumeCalc(length, width, depth);
    }

    public default double squareOrRectVariableDepth(double length,
                                                    double width, double shallowDepth,
                                                    double middleDepth, double deepDepth){
        double avgDepth = (shallowDepth + middleDepth + deepDepth) / 3;
        return volumeCalc(length, width, avgDepth);
    }

    private double volumeCalc(double length, double width, double depth){
        return length * width * depth * 7.5;
    }


    public class PoolExample implements Pool {
        public static void main(String args[]) {
            PoolExample pe = new PoolExample();
            System.out.println(pe.squareOrRectConstantDepth(
                    10,10,10));
        }
    }

}
