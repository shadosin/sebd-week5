package com.kenzie.dynamicstrings;

public class Application {
    /*********************************
     * Using Dynamic Strings
     **********************************/

    /*********************************
     * Exercise One
     **********************************/

    public static StringBuilder createStringBuilderWithName(String name) {
        // Create a StringBuilder and initialize it with the given name.
        // Return the StringBuilder object
        StringBuilder built = new StringBuilder(name);
        return built;
    }

    /*********************************
     * Exercise Two
     **********************************/

    public static String createCommaSeparatedList(String item1, String item2, String item3, String item4) {
        // Create a new StringBuilder instance
        // Using the stringBuilder and the four parameters, create comma separated list of all the items.
        // The result should look like: "Cat, Dog, Mouse, Rabbit"
        // There should be a comma and space in-between each item ", "
        //
        // Add each word separately using the .append method (don't use +)
        // Convert your StringBuilder instance into a string and return it.
        StringBuilder list = new StringBuilder();
        list
                .append(item1 + ", ")
                .append(item2 + ", ")
                .append(item3 + ", ")
                .append(item4);

        return list.toString();
    }

    /*********************************
     * Exercise Three
     **********************************/

    public static String replaceTextInString(
            String content,
            String subString,
            String replacementValue
    ) {
        // Replace the subString with the value of replacementValue in the content
        //
        // For example, if the arguments are:
        //   content: "A fox jumped over a wall"
        //   subString: "fox"
        //   replacementValue: "cat"
        // Then you want to replace the word "fox" with the word "cat" inside the content.
        //
        // First, convert the content String into a StringBuilder
        // Then, using the .replace() method, swap the subString for the replacement value.
        // Google the documentation for the replace method.
        // Hint: You will first have to determine the start and end index of the subString within the content
        //
        // When you are done, return the completed String
        StringBuilder build = new StringBuilder(content);
        int startIndex = build.indexOf(subString);
        int endIndex = startIndex + subString.length();
        build.replace(startIndex, endIndex, replacementValue);
        String newValue = build.toString();
        return newValue;
    }

    /*********************************
     * Exercise Four
     **********************************/

    public static String createFavoriteCharactersSentence(String[] characters) {
        // Convert the Array into a sentence listing the characters.
        // - The sentence should start with: "My favorite characters are "
        // - There should be a comma and space in between each item, and the work "and" before the last item.
        // - The sentence should end in a period.
        // For example, if the input array is ["Superman", "Wonder Woman", "Batman", "Godzilla"]
        // Then your String would be: "My favorite characters are Superman, Wonder Woman, Batman, and Godzilla."
        //
        // Create a new StringBuild and use this to form your String.
        // You will need to iterate over the characters array, adding each item and the necessary other characters.
        String joinedString = String.join(", ", characters);
        StringBuilder heroes = new StringBuilder(joinedString);
        heroes.insert(0, "My favorite characters are ");
        heroes.append(".");
        int index = heroes.lastIndexOf(",");
        heroes.insert(index +1, " and");

        return heroes.toString();
    }

    public static void main(String[] args) {
        // ----------------------------------------------------------------------------------------------
        System.out.println("Exercise One");
        String favoriteCharacter = "Westley of Florin";
        StringBuilder favoriteCharacterBuilder = createStringBuilderWithName(favoriteCharacter);
        System.out.println(favoriteCharacterBuilder);
        // This should print: Westley of Florin

        // ----------------------------------------------------------------------------------------------
        System.out.println("Exercise Two");
        String favoriteCharacters = createCommaSeparatedList("Westley", "Buttercup", "Vizzini", "Fezzik");
        System.out.println(favoriteCharacters);
        // This should Print: Westley, Buttercup, Vizzini, Fezzik

        // ----------------------------------------------------------------------------------------------
        System.out.println("Exercise Three");

        // Notice we can stack arguments in a method call
        String result = replaceTextInString(
                "He ate an entire stick of butter and felt sick...",
                "stick of butter",
                "Reese's Peanut Butter");

        System.out.println(result);
        // This should print: He ate an entire Reese's Peanut Butter and felt sick...

        // ----------------------------------------------------------------------------------------------
        System.out.println("Exercise Four");
        String sentence = createFavoriteCharactersSentence(new String[]{"Westley", "Buttercup", "Vizzini", "Fezzik"});
        System.out.println(sentence);
        // This should print: My favorite characters are Westley, Buttercup, Vizzini, and Fezzik.

        // ----------------------------------------------------------------------------------------------
        // When you are done with all the exercises, check your console output to make sure it
        // matches the expected output of each exercise and remove any extraneous System.out.println()
        // statements from your code.
    }

}