package com.kenzie.dynamicstrings;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.*;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class ApplicationTest {

    // Create a stringbuilder object initialized with a name
    @Test
    public void createStringBuilderWithName_Test1() {
        StringBuilder result = Application.createStringBuilderWithName("Dread Pirate Roberts");
        assertEquals("Dread Pirate Roberts", result.toString());
    }

    @Test
    public void createStringBuilderWithName_Test2() {
        StringBuilder result = Application.createStringBuilderWithName("My String Builder");
        assertEquals("My String Builder", result.toString());
    }

    // Combine multiple strings to form a comma separated list
    @Test
    public void createCommaSeparatedList_Test1() {
        String result = Application.createCommaSeparatedList(
                "Inigo Montoya",
                "Humperdinck",
                "Tyrone Rugen",
                "Buttercup"
        );

        assertEquals( "Inigo Montoya, Humperdinck, Tyrone Rugen, Buttercup", result);
    }

    @Test
    public void createCommaSeparatedList_Test2() {
        String result = Application.createCommaSeparatedList(
                "Peter Gregory",
                "Gilfoyle",
                "Gavin Belson",
                "Richard Hendricks"
        );

        assertEquals( "Peter Gregory, Gilfoyle, Gavin Belson, Richard Hendricks", result);
    }

    // Replace substring with input
    @Test
    public void replaceTextInString_Test1() {
        String substring = "As you wish";
        String replacementValue = "I love you";
        String inputText = "That day, she was amazed to discover that when he was saying \"As you wish,\" what he meant was, \"I love you.\" And even more amazing was the day she realized she truly loved him back";
        String expectedResult = "That day, she was amazed to discover that when he was saying \"I love you,\" what he meant was, \"I love you.\" And even more amazing was the day she realized she truly loved him back";
        String output = Application.replaceTextInString(
                inputText,
                substring,
                replacementValue);
        assertEquals(expectedResult, output);
    }

    @Test
    public void replaceTextInString_Test2() {
        String substring = "Internet Explorer";
        String replacementValue = "Google Chrome";
        String inputText = "My least favorite web browser to use is \"Internet Explorer,\" what I meant choose was, \"Google Chrome.\"";
        String expectedResult = "My least favorite web browser to use is \"Google Chrome,\" what I meant choose was, \"Google Chrome.\"";
        String output = Application.replaceTextInString(
                inputText,
                substring,
                replacementValue);
        assertEquals(expectedResult, output);
    }

    // Create a sentence from an array
    @Test
    public void createFavoriteCharactersSentence_Test1() {
        String[] characters = new String[] {"Westley", "Buttercup", "Inigo Montoya", "Dread Pirate Roberts" };
        String result = Application.createFavoriteCharactersSentence(characters);
        String expectedResult = "My favorite characters are Westley, Buttercup, Inigo Montoya, and Dread Pirate Roberts.";
        assertEquals(expectedResult, result);
    }

    @Test
    public void createFavoriteCharactersSentence_Test2() {
        String[] characters = new String[] {"Peter Gregory", "Gilfoyle", "Gavin Belson", "Richard Hendricks" };
        String result = Application.createFavoriteCharactersSentence(characters);
        String expectedResult = "My favorite characters are Peter Gregory, Gilfoyle, Gavin Belson, and Richard Hendricks.";
        assertEquals(expectedResult, result);
    }


    // Does the program run?
    // This should pass automatically

    @Test
    public void runMain() {
        boolean crashed = false;
        try {
            Application.main(new String[]{});
        } catch (Exception e) {
            crashed = true;
        }

        assertEquals(false, crashed, "App can run without crashing") ;
    }
}
