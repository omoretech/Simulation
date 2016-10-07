/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment3;

/**
 *
 * Create Custome Exception class to handle exceptions
 */
public class CustomException extends Exception {

    CustomException() {
        super(); // call the Exception class constructor

    }

    public CustomException(String message) { //constructor used to print cause of exception
        super(message);
    }
}
