package com.kenzie.modifyingarrays;

import java.util.Arrays;
import java.util.Random;

import org.apache.commons.lang3.ArrayUtils;

public class Application {
    /******************************************************************
     * Modifying Arrays
     * Complete the Following Exercises (1-6) WITHOUT using ArrayUtils
     * Complete Exercise 7-8 WITH ArrayUtils
     * Do not alter the print statements in the Main method
     ******************************************************************/

    /*************************************
     * Modifying One
     * do NOT use ArrayUtils
     *************************************/

    public static void incrementEveryNumber(int[] array) {
        // Increment every number in the array by one
        for(int i = 0; i < array.length; i++){
            array[i] +=1;
        }
        System.out.println(Arrays.toString(array));
    }

    /*************************************
     * Modifying Two
     * do NOT use ArrayUtils
     *************************************/

    public static void fillWithRandomNumbers(int[] array) {
        // Fill the array with random positive numbers up to 27 (Values from 1 to 27)
        Random random = new Random();
        for(int i=0; i < array.length; i++){
            array[i]=random.nextInt(27)+1;
        }
        System.out.println(Arrays.toString(array));
    }

    /*************************************
     * Modifying Three
     * do NOT use ArrayUtils
     *************************************/

    public static int[] removeNumbersBelowTen(int[] array) {
        // Add values to the new array if they are greater than or equal to 10
        // Do not modify the input array
        //
        // Notice that you don't know how big this new array should be!  You will need to find out.
        // You will have to loop TWICE to do this.
        // First, loop and count how many numbers are 10 or larger
        // Then, create a new array of that size
        // Finally, loop through the array again and copy the numbers over to the new array.
        // Return the new array
        int count=0;
        for(int i =0; i < array.length; i++){
            if(array[i] >= 10){
                count ++;
            }
        }
        int tracker=0;
        int[] result = new int[count];
        for(int j=0; j < array.length; j++){
            if(array[j] >=10){
                result[tracker] = array[j];
                tracker++;
            }
        }

        return result;
    }

    /*************************************
     * Modifying Four
     * do NOT use ArrayUtils
     *************************************/

    public static int addAllNumbers(int[] array) {
        // Add every number in the array and return the sum
        int sum=0;
        for( int i= 0; i < array.length; i++){
            sum += array[i];
        }
        return sum;
    }

    /*************************************
     * Modifying Five
     * do NOT use ArrayUtils
     *************************************/

    public static void replaceAll(String[] words, String wordToReplace, String newValue) {
        // Replace all instances of the given wordToReplace in the words array with the new value
        for(int i=0; i < words.length; i++){
            if(words[i].equals(wordToReplace)){
                words[i] = newValue;
            }
        }
    }

    /*************************************
     * Modifying Six
     * do NOT use ArrayUtils
     *************************************/

    public static void reverse(int[] array) {
        // Reverse the order of every element in the array. This should be done in-place
        // This should be done WITHOUT using ArrayUtils.reverse()
        // Hint, you will need to create a "temp" variable to hold one item at a time while you swap items.
    int temp=0;
    for(int i=0; i < array.length/2; i++){
        temp = array[i];
        array[i]= array[array.length-i-1];
        array[array.length-i-1] = temp;
    }

    }


    /*************************************
     * Exercise Seven
     * USE ArrayUtils
     *************************************/

    public static void reverseString(String[] words) {
        // Reverse the order of every element in the array.
        ArrayUtils.reverse(words);
    }

    /*************************************
     * Modifying Eight
     * USE ArrayUtils
     *************************************/

    public static int[] removeLastOccurrence(int[] array, int numberToRemove) {
        // Remove the last instance of the given number from the array.
        //
        // Note that the number may occur multiple times in the array, you should
        // only remove the LAST occurrence of the number.
        // Hint: You should be able to do this using two different ArrayUtils methods together...
        int indexToRemove = ArrayUtils.lastIndexOf(array, numberToRemove);
        array = ArrayUtils.remove(array, indexToRemove);
        int[] result = array;

        return result;
    }

    public static void main(String[] args) {
        // You do not need to modify anything in this method.  Just write your code above, then verify your answers in the console output.

        // ----------------------------------------------------------------------------------------------
        System.out.println("Exercise One");
        int[] numbers = {10, 11, 12, 13, 14, 15};
        incrementEveryNumber(numbers);
        System.out.println(Arrays.toString(numbers));
        // This should print [11, 12, 13, 14, 15, 16]


        // ----------------------------------------------------------------------------------------------
        System.out.println("Exercise Two");
        int[] randomNumberArray = new int[7];
        fillWithRandomNumbers(randomNumberArray);
        System.out.println(Arrays.toString(randomNumberArray));
        // This should print An array of 7 random numbers between 1 and 27

        // ----------------------------------------------------------------------------------------------
        System.out.println("Exercise Three");
        int[] moreNumbers = {1, 5, 22, 10, 8, 11, 9, 30, 0, 2};
        int[] resultThree = removeNumbersBelowTen(moreNumbers);
        System.out.println(Arrays.toString(moreNumbers));
        // This should print [1, 5, 22, 10, 8, 11, 9, 30, 0, 2]
        System.out.println(Arrays.toString(resultThree));
        // This should print [22, 10, 11, 30]


        // ----------------------------------------------------------------------------------------------
        System.out.println("Exercise Four");
        int[] numbersToAdd = {2, 5, 1, 22, 3, 15, 29};
        int sum = addAllNumbers(numbersToAdd);
        System.out.println(sum);
        //This should print 77


        // ----------------------------------------------------------------------------------------------
        System.out.println("Exercise Five");
        String[] words = {"His", "name", "is", "Frank", ".", "Have", "you", "met", "Frank", "?"};
        replaceAll(words, "Frank", "Shaun");
        System.out.println(Arrays.toString(words));
        // This should print: ["His", "name", "is", "Shaun", ".", "Have", "you", "met", "Shaun", "?"

        // ----------------------------------------------------------------------------------------------
        System.out.println("Exercise Six");
        int[] numbersToReverse = {1, 2, 3, 4, 5, 6, 7};
        reverse(numbersToReverse);
        System.out.println(Arrays.toString(numbersToReverse));
        // This should print: [7, 6, 5, 4, 3, 2, 1]

        // ----------------------------------------------------------------------------------------------
        System.out.println("Exercise Seven");
        String[] wordsToReverse = {"The", "dog", "jumped", "over", "the", "fence"};
        reverseString(wordsToReverse);
        System.out.println(Arrays.toString(wordsToReverse));
        // This should print: ["fence", "the", "over", "jumped", "dog", "The"]

        // ----------------------------------------------------------------------------------------------
        System.out.println("Exercise Eight");
        int[] values = {3, 7, 5, 9, 8, 5, 2, 1, 5, 4};
        int[] result = removeLastOccurrence(values, 5);
        System.out.println(Arrays.toString(result));
        // This should print [3, 7, 5, 9, 8, 5, 2, 1, 4]

    }
}