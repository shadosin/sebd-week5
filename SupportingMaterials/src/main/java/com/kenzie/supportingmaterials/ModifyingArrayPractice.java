package com.kenzie.supportingmaterials;

import java.util.Arrays;

public class ModifyingArrayPractice {
    public static void main(String[] args) {
        // First array of size 6
        int numbers[] = {10, 20, 30, 40, 50, 60};

        // Element to add to the array
        int newValue = 70;

        // Using the method to add newElement into the array
        // Look below for the declaration
        int[] newNumbers = addElement(numbers, newValue);

        // Print the arrays

        System.out.println(Arrays.toString(numbers));
        // Printing numbers will output [10,20,30,40,50,60]

        System.out.println(Arrays.toString(newNumbers));
        // Printing newNumbers output [10,20,30,40,50,60,70]
    }

    // Method to add the new element to the old array
    public static int[] addElement(int[] oldArray, int element) {
        // Code to copy oldArray and add one newValue element here
        return null;
    }
}
