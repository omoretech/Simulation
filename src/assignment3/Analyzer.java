package assignment3;

import java.util.Scanner;
public class Analyzer {
	public static void main (String[] args) throws CustomException{
		
		System.out.println("Welcome to the Elevator simulator! ");
		System.out.println();
		Scanner s = new Scanner(System.in);
		
		System.out.print("Please enter the probability of arrival for Requests: ");
		double prob = s.nextDouble();
		if((prob < 0.0) || (prob > 1.0)){
			System.out.print("Probability must be between 0 and 1" +
				" inclusive, try again: ");
			prob = s.nextDouble();
		}
		
		System.out.print("Please enter the number of floors: ");
		int numFloors = s.nextInt();
		if(numFloors < 2){
			System.out.print("There must be at least 2 floors to " +
				"use an elevator try again: ");
			numFloors = s.nextInt();
			
		}
		
		System.out.print("Please enter the number of elevators: ");
		int numLifts = s.nextInt();
		if(numLifts < 1){
			System.out.print("There must be at least 1 Elevator to " +
				"use an elevator try again: ");
			numLifts = s.nextInt();
			
		}
		
		System.out.print("Please enter the length of the simulation (in time units): ");
		int simTime = s.nextInt();
		if(simTime < 1){
			System.out.print("The simulation doesn't run if it has " +
				"zero run time, try again: ");
			simTime = s.nextInt();
			
		}
		
		Simulator.simulate(prob, numFloors, numLifts, simTime);
	}
		
		
	}
	//main method which prompts the user, on separate lines, for each of the 4 parameters required for the simulate method of the Simulator class. Make sure to check that each of the values for these parameters are within the valid range and then run the actual simulation.


