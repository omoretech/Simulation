package assignment3;

/*

This is the main Class where main logic is used,
It has simulate method which four arguments
Create object of class Request, BooleanSource, RequestQueue to proceed to
fulfil the main perpose of the elevator System


 */

public class Simulator {
//Instance/Global variables
    private static Elevator[] elevate;
    private static BooleanSource prob;
    private static int requests;
    private static int totalWait;
    private static int time;
    private static boolean debug = false; // used to print on the screen condition true or false

    public static void simulate(double probablity, int floors, int elevators, int length)
            throws IllegalArgumentException, CustomException {

        prob = new BooleanSource(probablity);////Create Object of BooleanSource
        elevate = new Elevator[elevators]; //Create elevator class array
        for (int i = 0; i < elevators; i++) {
            elevate[i] = new Elevator(); // Iterate all elevator positions
        }
        time = 0;
        RequestQueue que = new RequestQueue(); //Create object of RequestQueue
        while (time < length) {
            if (prob.requestArrived()) { //if request is arrived to the elevator
                Request enqueueTemp = new Request(floors);
                enqueueTemp.setTimeEntered(time); 
                que.enqueue(enqueueTemp); // add request to Vector(array data structor)
                if (debug) { // used for testing and debugging the code
                    System.out.println("Request from floor " + enqueueTemp.getSourceFloor());
                }
            }
            if (!que.isEmpty()) { // check if queue is empty 
                for (int i = 0; i < elevate.length; i++) {
                    if (elevate[i].getElevatorState() == Elevator.IDLE) { //so elevator is at IDLE state
                        if (!que.isEmpty()) {
                            if (debug) {
                                System.out.println("Elevator " + (i + 1) + " took a request");
                            }
                            elevate[i].setRequest(que.dequeue()); //extract request from dequeue
                            elevate[i].setElevatorState(Elevator.TO_SOURCE);
                        }
                    }
                }
            }
            for (int i = 0; i < elevate.length; i++) {
                if (elevate[i].getElevatorState() == Elevator.TO_SOURCE) { //If elevator at Souce state
                    toSource(i); //call this method
                } else if (elevate[i].getElevatorState() == Elevator.TO_DESTINATION) { // if this state
                    toDest(i); //call this method
                }
            }
            time++; // increament 1 for each request in the way we can get how much used to proceed request
        }
        if (requests != 0) { //If elevator have some request 
            
            //Calculate total Time, Request and Average time for all requests
            double avgWaitCalc = (int) (((double) totalWait / (double) requests * 100));
            System.out.println("Total Wait Time:" + totalWait + "\n" + "Total requests:" + requests
                    + "\nAverave Wait Time:" + (avgWaitCalc / 100));
        } else {
            //If no request
            String avgWaitCalc = "Infinite";
            System.out.println("Total Wait Time:" + totalWait + "\n" + "Total requests:" + requests
                    + "\nAverave Wait Time:" + avgWaitCalc);
        }
    }
    
//For Destination Floor
    public static void toDest(int i) {
        /*
        
        elevate[i].getCurrentFloor()->return the elevator current floor e.g elevator at 2nd floor
        elevate[i].getRequest().getDestinationFloor() -> Check where request is comes from e.g 8th floor
        if this increament by 1 to reach the 8th floor
        
        
        
        
        */
        if (elevate[i].getCurrentFloor() < elevate[i].getRequest().getDestinationFloor()) {
            elevate[i].setCurrentFloor(elevate[i].getCurrentFloor() + 1);
            if (debug) { //check where elevator is going 
                System.out.println("Elevator " + (i + 1) + " going up to " + elevate[i].getCurrentFloor());
            }
        }
        
        /*
        
        If elevator at 5th floor and request is comes from 2nd floor so decrement by 1
        
        */
        if (elevate[i].getCurrentFloor() > elevate[i].getRequest().getDestinationFloor()) {
            elevate[i].setCurrentFloor(elevate[i].getCurrentFloor() - 1);
            if (debug) {
                System.out.println("Elevator " + (i + 1) + " going down to " + elevate[i].getCurrentFloor());
            }
        }
        /*
        
        If evevator at 2nd floor and Request is also come from 2nd floor so Elevator is at IDLE state
        
        
        */
        if (elevate[i].getCurrentFloor() == elevate[i].getRequest().getDestinationFloor()) {
            elevate[i].setElevatorState(Elevator.IDLE);
            if (debug) {
                System.out.println("Elevator " + (i + 1) + " reached destination");
            }
        }
    }

    //For Source Floor
    public static void toSource(int i) {
        /*
        
        if current Floor is less than request source floor to increament by 1.
         and vice versa.
        
        */
        
        
        
        if (elevate[i].getCurrentFloor() < elevate[i].getRequest().getSourceFloor()) {
            elevate[i].setCurrentFloor(elevate[i].getCurrentFloor() + 1);
            if (debug) {
                System.out.println("Elevator " + (i + 1) + " going up to " + elevate[i].getCurrentFloor());
            }
        }
        if (elevate[i].getCurrentFloor() > elevate[i].getRequest().getSourceFloor()) {
            elevate[i].setCurrentFloor(elevate[i].getCurrentFloor() - 1);
            if (debug) {
                System.out.println("Elevator " + (i + 1) + " going down to " + elevate[i].getCurrentFloor());
            }
        }
        /*
        
        When elevator brings a person into it's destination floor then incremant request by 1.
        
        
        
        */
        if (elevate[i].getCurrentFloor() == elevate[i].getRequest().getSourceFloor()) {
            elevate[i].setElevatorState(Elevator.TO_DESTINATION);
            elevate[i].setDestinationFloor(elevate[i].getRequest().getDestinationFloor());
            requests++;
            totalWait += (time - elevate[i].getRequest().getTimeEntered()); // get the total to proceed a request
            if (debug) {
                System.out.println("Elevator " + (i + 1) + " reached source");
            }
        }
    }
}

