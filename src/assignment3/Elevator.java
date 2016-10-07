package assignment3;
/*

Elevator class is used handle the state of elevator
Incoming Request
Check the current and destination floor 

*/


public class Elevator {
    
    //Instance Variables
	private int currentFloor;
	private int elevatorState;//elevatorState (an int constant, either IDLE, TO_SOURCE, or TO_DESTINATION)
	private Request request; //(Request object representing the request being handled or null if the Elevator is idle)
        private int destinationFloor;
	public static final int IDLE = -2;
	public static final int TO_SOURCE = -1;
	public static final int TO_DESTINATION = 0;
        
	//Constructor
	public Elevator(){
		request = null; // Elevator is an IDLE
		setElevatorState(IDLE);
		setCurrentFloor(1);
		}
	
        //Getter and Setter functions used to set and get instance variables
	public int getCurrentFloor(){
		return currentFloor;
	}
	
	public void setCurrentFloor(int currentFloor){
		this.currentFloor = currentFloor;
	}
	
	public int getElevatorState(){
		return elevatorState;
	}
	
	public void setElevatorState(int elevatorState){
		this.elevatorState = elevatorState;
	}
	
	public Request getRequest(){
		return request;
	}
	
	public void setRequest(Request req){
		request = req;
	}

    /**
     * @return the destinationFloor
     */
    public int getDestinationFloor() {
        return destinationFloor;
    }

    /**
     * @param destinationFloor the destinationFloor to set
     */
    public void setDestinationFloor(int destinationFloor) {
        this.destinationFloor = destinationFloor;
    }
}


