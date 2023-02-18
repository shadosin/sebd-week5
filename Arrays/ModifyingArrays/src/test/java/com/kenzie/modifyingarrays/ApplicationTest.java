package com.kenzie.modifyingarrays;

import org.junit.jupiter.api.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;


@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class ApplicationTest {
    // Exercise One
    //      - Increment each value by 1
    //      - This modifies the original array
    @Test
    public void incrementEveryNumber_Test1() {
        int[] original = {-1, 6, 10, 141, -10};
        int[] numbers = {-1, 6, 10, 141, -10};
        assertEquals(original.length, numbers.length, String.format("Expected length to be: %s but was %s", String.valueOf(original.length), String.valueOf(numbers.length)));
        Application.incrementEveryNumber(numbers);
        for(int i = 0; i < numbers.length; i++) {
            assertEquals(original[i] + 1, numbers[i], String.format("Expected number at index %s to be %s but was %s", String.valueOf(i), String.valueOf(original[i] + 1), String.valueOf(numbers[i])));
        }
    }

    @Test
    public void incrementEveryNumber_Test2() {
        int[] original = {-2, 12, 20, 282, -20};
        int[] numbers = {-2, 12, 20, 282, -20};
        assertEquals(original.length, numbers.length, String.format("Expected length to be: %s but was %s", String.valueOf(original.length), String.valueOf(numbers.length)));
        Application.incrementEveryNumber(numbers);
        for(int i = 0; i < numbers.length; i++) {
            assertEquals(original[i] + 1, numbers[i], String.format("Expected number at index %s to be %s but was %s", String.valueOf(i), String.valueOf(original[i] + 1), String.valueOf(numbers[i])));
        }
    }

    // Exercise Two
    //      - fill with random positive numbers between 1-27
    //      - this should modify the original array
    @Test
    public void fillWithRandomNumbers_Test1() {
        int[] numbers = new int[20];
        Application.fillWithRandomNumbers(numbers);
        for(int number : numbers) {
            assertTrue(number > 0, String.format("Expected number to be greater than 0 but was %s", String.valueOf(number)));
        }
    }

    @Test
    public void fillWithRandomNumbers_Test2() {
        int[] numbers = new int[10];
        Application.fillWithRandomNumbers(numbers);
        for(int number : numbers) {
            assertTrue(number > 0, String.format("Expected number to be greater than 0 but was %s", String.valueOf(number)));
        }
    }

    // Exercise Three
    //      - Remove every number in the array less than 10
    //      - Return a new array
    @Test
    public void removeNumbersBelowTen_Test1() {
        int[] input = {-1, 6, 10, 141, -10};
        int[] expected = {10, 141};
        int[] actual = Application.removeNumbersBelowTen(input);
        assertNotEquals(input, actual, String.format("Expected method removeNumbersBelowTen to remove numbers less than 10. Actual numbers returned was: %s.", Arrays.toString(actual)));
        Arrays.sort(expected);
        Arrays.sort(actual);
        assertTrue(Arrays.equals(expected, actual), String.format("Expected method removeNumbersBelowTen to return %s but %s was returned.", Arrays.toString(expected), Arrays.toString(actual)));
    }

    @Test
    public void removeNumbersBelowTen_Test2() {
        int[] input = {50, 100, 250, 180, 200};
        int[] expected = {50, 100, 250, 180, 200};
        int[] actual = Application.removeNumbersBelowTen(input);
        assertNotEquals(input, actual, String.format("Expected method removeNumbersBelowTen to remove numbers less than 10. Actual numbers returned was: %s.", Arrays.toString(actual)));
        Arrays.sort(expected);
        Arrays.sort(actual);
        assertTrue(Arrays.equals(expected, actual), String.format("Expected method removeNumbersBelowTen to return %s but %s was returned.", Arrays.toString(expected), Arrays.toString(actual)));
    }

    @Test
    public void removeNumbersBelowTen_Test3() {
        int[] input = {1, 2, 3, 4, 5};
        int[] expected = {};
        int[] actual = Application.removeNumbersBelowTen(input);
        assertNotEquals(input, actual, String.format("Expected method removeNumbersBelowTen to remove numbers less than 10. Actual numbers returned was: %s.", Arrays.toString(actual)));
        Arrays.sort(expected);
        Arrays.sort(actual);
        assertTrue(Arrays.equals(expected, actual), String.format("Expected method removeNumbersBelowTen to return %s but %s was returned.", Arrays.toString(expected), Arrays.toString(actual)));
    }

    // Exercise Four
    //      - Sum the numbers
    @Test
    public void addAllNumbersInArrayAndReturnSum_Test1() {
        int[] input = {-1, 6, 10, 141, -10};
        int expectedSum = 146;
        int actualSum = Application.addAllNumbers(input);
        assertEquals(expectedSum, actualSum, String.format("Expected the sum of inputs: %s to be %s but was %s", Arrays.toString(input), String.valueOf(expectedSum), String.valueOf(actualSum)));
    }

    @Test
    public void addAllNumbersInArrayAndReturnSum_Test2() {
        int[] input = {2, 10, 40, 100, 1000};
        int expectedSum = 1152;
        int actualSum = Application.addAllNumbers(input);
        assertEquals(expectedSum, actualSum, String.format("Expected the sum of inputs: %s to be %s but was %s", Arrays.toString(input), String.valueOf(expectedSum), String.valueOf(actualSum)));
    }

    // Exercise Five
    //      - Replace instances of input word with replacement value
    @Test
    public void replaceAllInstancesOfWord_Test1() {
        String[] input = "HOLD ON HOLD ON HOLD ON...HER SISTER WAS A WITCH RIGHT? AND WHAT WAS HER SISTER? A PRINCESS, THE WICKED WITCH OF THE EAST BRO. YOU'RE GONNA LOOK AT ME AND YOU'RE GONNA TELL ME THAT I'M INCORRECT? AM I INCORRECT? SHE WORE A CROWN AND SHE CAME DOWN IN A BUBBLE, DOUG.".split(" ");
        String expected = "HOLD ON HOLD ON HOLD ON...HER SISTER WAS A WITCH RIGHT? AND WHAT WAS HER SISTER? A PRINCESS, THE WICKED WITCH OF THE EAST BRO. YOU'RE GONNA LOOK AT ME AND YOU'RE GONNA TELL ME THAT I'M WRONG? AM I WRONG? SHE WORE A CROWN AND SHE CAME DOWN IN A BUBBLE, DOUG.";
        Application.replaceAll(input, "INCORRECT?", "WRONG?");
        String joinedString = String.join(" ", input);
        assertEquals(expected, joinedString
                , String.format("Expected string result of: %s but %s was returned.", expected, joinedString));
    }

    @Test
    public void replaceAllInstancesOfWord_Test2() {
        String[] input = "HOLD ON HOLD ON HOLD ON...HER SISTER WAS A WITCH RIGHT? AND WHAT WAS HER SISTER? A PRINCESS, THE WICKED WITCH OF THE EAST BRO. YOU'RE GONNA LOOK AT ME AND YOU'RE GONNA TELL ME THAT I'M INCORRECT? AM I INCORRECT? SHE WORE A CROWN AND SHE CAME DOWN IN A BUBBLE, DOUG.".split(" ");
        String expected = "HOLD ON HOLD ON HOLD ON...HER SISTER WAS A WITCH RIGHT? AND WHAT WAS HER SISTER? A PRINCESS, THE WONDERFUL WITCH OF THE EAST BRO. YOU'RE GONNA LOOK AT ME AND YOU'RE GONNA TELL ME THAT I'M INCORRECT? AM I INCORRECT? SHE WORE A CROWN AND SHE CAME DOWN IN A BUBBLE, DOUG.";
        Application.replaceAll(input, "WICKED", "WONDERFUL");
        String joinedString = String.join(" ", input);
        assertEquals(expected, joinedString
                , String.format("Expected string result of: %s but %s was returned.", expected, joinedString));
    }

    // Exercise Six
    //      - Reverse the order of the elements in the array
    @Test
    public void reverseOrderOfEveryElementInArray_Test1() {
        int[] input = {1,4,5,6,9};
        int[] expected = {9,6,5,4,1};
        Application.reverse(input);
        for(int i = 0; i < input.length; i++) {
            assertEquals(expected[i], input[i]);
            assertEquals(expected[i], input[i], String.format("Expected index %s to be %s but was %s", String.valueOf(i), String.valueOf(expected[i]), String.valueOf(input[i])));
        }
    }

    @Test
    public void reverseOrderOfEveryElementInArray_Test2() {
        int[] input = {100, 200, 300, 400, 500};
        int[] expected = {500, 400, 300, 200, 100};
        Application.reverse(input);
        for(int i = 0; i < input.length; i++) {
            assertEquals(expected[i], input[i]);
            assertEquals(expected[i], input[i], String.format("Expected index %s to be %s but was %s", String.valueOf(i), String.valueOf(expected[i]), String.valueOf(input[i])));
        }
    }

    // Exercise Seven
    //      - Reverse the order of the elements in the array
    @Test
    public void reverseStringOrderOfEveryElementInArray_Test1() {
        String[] input = "HOLD ON HOLD ON HOLD ON...HER SISTER WAS A WITCH RIGHT? AND WHAT WAS HER SISTER? A PRINCESS, THE WICKED WITCH OF THE EAST BRO. YOU'RE GONNA LOOK AT ME AND YOU'RE GONNA TELL ME THAT I'M INCORRECT? AM I INCORRECT? SHE WORE A CROWN AND SHE CAME DOWN IN A BUBBLE, DOUG.".split(" ");
        String[] reversed = {"DOUG.","BUBBLE,","A","IN","DOWN","CAME","SHE","AND","CROWN","A","WORE","SHE","INCORRECT?","I","AM","INCORRECT?","I'M","THAT","ME","TELL","GONNA","YOU'RE","AND","ME","AT","LOOK","GONNA","YOU'RE","BRO.","EAST","THE","OF","WITCH","WICKED","THE","PRINCESS,","A","SISTER?","HER","WAS","WHAT","AND","RIGHT?","WITCH","A","WAS","SISTER","ON...HER","HOLD","ON","HOLD","ON","HOLD"};
        Application.reverseString(input);
        for(int i = 0; i < input.length; i++) {
            assertEquals(reversed[i], input[i], String.format("Expected index %s to be %s but was %s", String.valueOf(i), String.valueOf(reversed[i]), String.valueOf(input[i])));
        }
    }

    @Test
    public void reverseStringOrderOfEveryElementInArray_Test2() {
        String[] input = "The best thing about a boolean is even if you are wrong you are only off by a bit".split(" ");
        String[] reversed = {"bit", "a", "by", "off", "only", "are", "you", "wrong", "are", "you", "if", "even", "is", "boolean", "a", "about", "thing", "best", "The"};
        Application.reverseString(input);
        for(int i = 0; i < input.length; i++) {
            assertEquals(reversed[i], input[i], String.format("Expected index %s to be %s but was %s", String.valueOf(i), String.valueOf(reversed[i]), String.valueOf(input[i])));
        }
    }

    // Exercise Eight
    //      - Return an array of 3 random elements from the array
    //      - The input array should be shuffled in place
    @Test
    public void removeLastNumberFromArray_Test1() {
        int[] original = {1,4,9,5,6,9,-10,9,6,-15};
        int[] input = {1,4,9,5,6,9,-10,9,6,-15};
        int[] expectedOutput = {1,4,9,5,6,9,-10,6,-15};
        int[] output = Application.removeLastOccurrence(input, 9);
        assertEquals(original.length - 1, output.length, String.format("Expected the length of the array to be %s but was%s", String.valueOf(original.length -1), String.valueOf(output.length)));

        String expectedOutputAsString = Arrays.toString(expectedOutput);
        String actualOutputAsString = Arrays.toString(output);

        assertEquals(expectedOutputAsString, actualOutputAsString);
    }
    @Test
    public void removeLastNumberFromArray_Test2() {
        int[] original = {1,5,10,5,11,33};
        int[] input = {1,5,10,5,11,33};
        int[] expectedOutput = {1,5,10,11,33};
        int[] output = Application.removeLastOccurrence(input, 5);
        assertEquals(original.length - 1, output.length, String.format("Expected the length of the array to be %s but was %s", String.valueOf(original.length -1), String.valueOf(output.length)));

        String expectedOutputAsString = Arrays.toString(expectedOutput);
        String actualOutputAsString = Arrays.toString(output);

        assertEquals(expectedOutputAsString, actualOutputAsString);
    }



    // Does the program run?
    // This should pass automatically

    @Test
    public void runApplication() {
        boolean crashed = false;
        try {
            Application.main(new String[]{});
        } catch (Exception e) {
            crashed = true;
        }

        assertEquals(false, crashed, "App can run without crashing") ;
    }
}