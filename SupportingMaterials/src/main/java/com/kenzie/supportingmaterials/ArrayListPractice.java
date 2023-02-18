package com.kenzie.supportingmaterials;

import java.util.ArrayList;

public class ArrayListPractice {

    /*********************************
     * Practice Zero
     *********************************/
    public static void practiceZero() {
        System.out.println("Creating a dynamic array with ArrayList");
    }

    /*********************************
     * Practice One
     *     1. Add "Banana" to the end of the current array.
     *     2. Update the first element of the array to "Apple"
     *     3. Get the second value in the array after completing #1 and #2, convert it to all lowercase, and write the value back to the third value in the array using `set()`.
     *     4. Print out the current size of the array.
     *     5. Search if the ArrayList has an element "Banana". Where is the first index? where is the last.
     *     6. Remove the first instance of "Banana" from the array.
     *     7. Search if the ArrayList has any more occurrences of "Banana".
     *     8. Remove the first element of the array.
     *     9. Remove all the elements in the array.
     *********************************/

    public static void practiceOne() {
        ArrayList<String> fruitList = new ArrayList<>();

        fruitList.add("Favorite Fruit");
        fruitList.add("CHERRY");
        fruitList.add("Banana");
        fruitList.add("Peach");

        System.out.println(fruitList);

        // Write your code here
    }

    /*********************************
     * Practice Two
     *********************************/

    public static void practiceTwo() {
        System.out.println("Concatenating Two Lists");

        //Create ArrayList of type String
        ArrayList<String> fruitList = new ArrayList<>();

        //add elements to the ArrayList
        fruitList.add("Banana");
        fruitList.add("Peach");
        fruitList.add("Cherry");
        fruitList.add("Orange");


        //Create ArrayList of type String
        ArrayList<String> veggieList = new ArrayList<>();

        //add elements to the ArrayList
        veggieList.add("Carrot");
        veggieList.add("Kale");
        veggieList.add("Beet");
        veggieList.add("Celery");


        //Write your code here and display your final ArrayList

    }

    /*********************************
     * Practice Three
     *********************************/
    public static void practiceThree() {

        // Create ArrayList of type String
        ArrayList<String> wordList = new ArrayList<>();

        //add elements to the ArrayList
        wordList.add("Duck");
        wordList.add("Duck");
        wordList.add("Goose");
        wordList.add("Waldo0");

        // Write code here
    }

    /*********************************
     * Practice Four
     *********************************/
    public static void practiceFour() {
        ArrayList<String> bestThing = new ArrayList<>();
        bestThing.add("The");
        bestThing.add("best");
        bestThing.add("thing");
        bestThing.add("about");
        bestThing.add("a");
        bestThing.add("dynamic");
        bestThing.add("array");
        bestThing.add("is");
        bestThing.add("creating");
        bestThing.add("lists");
        bestThing.add("on");
        bestThing.add("a");
        bestThing.add("whim");

        System.out.println(bestThing);
        // Write code to loop through bestThing
        // Create a new array called resultList with only the words that start with "a"
        // Display using System.out.println
    }

    /*********************************
     * Practice Five
     *********************************/
    public static void practiceFive() {
        String[] primitiveStrArray = { "red", "blue", "green" };
        Integer[] primitiveIntArray = { 10, 20, 30, 40 };

        // Convert `primitiveIntArray` to an `ArrayList<Integer>` named `intArrayList`.
        // Convert `primitiveStrArray` to an `ArrayList<String>` named `strArrayList`.
        // Use `System.out.println()` to print the `intArrayList` and `strArrayList` values to the console.
    }

    /*********************************
     * Practice Six
     *********************************/
    public static void practiceSix() {
        System.out.println("Converting to primitive Arrays");

        // Create ArrayList of type String
        ArrayList<String> fruitList = new ArrayList<>();

        // Add elements to the ArrayList
        fruitList.add("Banana");
        fruitList.add("Peach");
        fruitList.add("Cherry");
        fruitList.add("Orange");

        // Create and assign `objArray` to the `toArray` call that returns an `Object[]`.

        // Create and assign the 'strArray' to the `toArray()` that returns a generic, in this case a `String[]`.

        // Display both using System.out.println. We have array memory addresses again!

        // After the code above compiles, try running getting the length of the first element of each:
        // strArray[0].length(); // This will be okay
        // objArray[0].length(); // This will cause an error

    }

    /*********************************
     * Practice Seven
     *********************************/
    public static void practiceSeven() {
        System.out.println("Creating a dynamic String ArrayList");

        // Create ArrayList of type String
        ArrayList<String> stringList = new ArrayList<>();

        // Display initial ArrayList
        System.out.println(stringList);

        // Add elements to the ArrayList
        stringList.add("January");
        stringList.add("February");
        stringList.add("March");
        stringList.add("April");

        // Display updated ArrayList
        System.out.println(stringList);
    }

}
