package com.kenzie.supportingmaterials;

public class StringBuilderPractice {

    /*********************************
     * Practice One
     *********************************/

    public static void practiceOne() {

        //Hint: "Wow, This is a whole New World"
        //What are the indexes of the positions where you want to replace and delete?
        StringBuilder sentence = new StringBuilder();
        sentence
                .append("Wow, This is a whole")
                .append("New World")
                .replace(15,20, "Brave")
                .delete(0, 5);

        System.out.println(sentence);

    }

    /*********************************
     * Practice Two
     *********************************/

    public static void practiceTwo() {
        String[] strArray = { "Make", "This", "Into", "A", "CSV" };
        String joinedString = String.join(",", strArray);
        System.out.println(joinedString);
    }

}
