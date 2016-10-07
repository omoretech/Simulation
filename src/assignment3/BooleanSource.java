package assignment3;

/*



 */
public class BooleanSource {

    private double probability; // Instance Variable

    public BooleanSource(double p) throws CustomException {

        if (p < 0.0 || p > 1.0) {
            throw new CustomException(); //if anything enter againest if condition so throws Custom Exception
        }
        probability = p;

    }

    public boolean requestArrived() {

        if (Math.random() < this.probability) { // Request is true if this condition true
            return true;
        }
        return false;//otherwise false
    }
}
