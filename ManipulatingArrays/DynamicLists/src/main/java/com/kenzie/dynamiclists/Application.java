package com.kenzie.dynamiclists;

import java.util.Scanner;
import java.util.ArrayList;
import java.lang.StringBuilder;


public class Application {

    public static void main(String[] args) {
        // Step 1 - Print out a welcome message and instructions
        // Step 2 - In a loop, collect each attendee name and store it in a list
        // Step 3 - When they enter a blank name, then stop looping
        // Step 4 - Iterate over the attendee list to create the output string (using StringBuilder!)
        //
        // Note that there are three distinct formats for the output string depending on the number of attendees
        // More than 2 attendees:
        // You have invited: Leslie Knope, April Ludgate, and Ron Swanson
        //
        // Exactly 2 attendees:
        // You have invited: Leslie Knope and Ron Swanson
        //
        // Only 1 attendee:
        // You have invited: Leslie Knope
        //
        // Your output should exactly match the way these are formatted with spaces, commas, and the "and"

        // Your Code Here
        Scanner userInput = new Scanner(System.in);
        System.out.println("Greetings and Salutations! Please provide your list of invitees:");
        System.out.println("When there are no more, please press enter");
        ArrayList<String> invitees = new ArrayList<>();

        while(true){
            System.out.println("Please enter the name here:");
            String name = userInput.nextLine();
            if(name.equals("")){
                break;
            }
            invitees.add(name);
        }
       StringBuilder finalList = new StringBuilder("You have invited: ");
        int numOfAttendees = invitees.size();
        if(numOfAttendees == 1){
            finalList.append(invitees.get(0));
        }else if(numOfAttendees == 2){
            finalList
                    .append(invitees.get(0))
                    .append(" and ")
                    .append(invitees.get(1));
        }else if(numOfAttendees >=3){
            for(int i=0; i < numOfAttendees-1; i++){
                finalList
                        .append(invitees.get(i))
                        .append(", ");
            }
            finalList
                    .append("and ")
                    .append(invitees.get(numOfAttendees-1));


        }
        System.out.println(finalList.toString());
    }
    }