package assignment3;

import java.util.Vector;

/*

extends RequestQueue class to Vector means we are
going to inheritance Vector class in our sub-class,
In this way we can use Vector class functions into
our class in order to handle requests


 */
public class RequestQueue extends Vector {

    RequestNode top; //Create object of inner class
    int size = 0;
    //Constructor

    public RequestQueue() {

    }
    //add elements into the Node like we add elements in the Array

    public void enqueue(Request req) {
        RequestNode reqNode = new RequestNode(req); // reqNode object is used to take care of Requests
        //Check if no element in the array 
        if (top == null) {
            top = reqNode;
        } else {
            //check if next elements contains so set next element 
            //In other words check next coming request for the elevator system
            reqNode.setNext(top.getNext());
            top.setNext(reqNode);
            size++;
        }
    }

    //Used to remove elements in the Array
    public Request dequeue() {

        Request returnData;//variable used to hold request while delete element in the array
        if (top == null) { // when no element in the array
            returnData = null;
        } else if (top.getNext() == null) { //when one element in the array
            returnData = top.getData();
            top = null;
        } else {
            returnData = top.getData(); // when more than 1 element in the array
            top = top.getNext();
            size--;

        }
        return returnData;
    }

    //used to return the current size of the Array
    public int size() {

        return size;
    }

    //Check if there is no element in the Array
    public boolean isEmpty() {
        if (top == null) {
            return true;
        } else {
            return false;
        }
    }

    //Get top data from the array it will be used when we check the first incoming request
    public Request peek() {
        return top.getData();
    }

    //Create a RequestNode class to which contains data of the array and address of next element
    private class RequestNode {

        private Request data;
        private RequestNode next;
        //Initialization of Request class object and store into data

        public RequestNode(Request req) {
            data = req;
        }
        //Setter and getter functions

        public Request getData() {
            return data;
        }

        public void setData(Request req) {
            if (req != null) {
                data = req;
            }
        }

        public void setNext(RequestNode next) {
            this.next = next;
        }

        public RequestNode getNext() {
            return next;
        }
    }
}
