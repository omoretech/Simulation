package assignment3;

/*




 */
public class Request {

    //Instance Variables
    private int sourceFloor;
    private int destinationFloor;
    private int timeEntered;
    private int numberFloors;

    //Contructor
    public Request(int numberFloors) {

        sourceFloor = (int) (Math.random() * numberFloors + 1); //source floor
        destinationFloor = (int) (Math.random() * numberFloors + 1); // destination floor
        if (sourceFloor == destinationFloor) {
            destinationFloor = (int) (Math.random() * numberFloors + 1);
        }
    }

    //Setter and getter functions
    public int getSourceFloor() {
        return sourceFloor;
    }

    public void setSourceFloor(int sourceFloor) {
        this.sourceFloor = sourceFloor;
    }

    public int getDestinationFloor() {
        return destinationFloor;
    }

    public void setDestinationFloor(int destinationFloor) {
        this.destinationFloor = destinationFloor;
    }

    public int getTimeEntered() {
        return timeEntered;
    }

    public void setTimeEntered(int timeEntered) {
        this.timeEntered = timeEntered;
    }

    public int getNumberFloors() {
        return numberFloors;
    }

    public void setNumberFloors(int numberFloors) {
        this.numberFloors = numberFloors;
    }
}
