package com.kenzie.dynamicarrays;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class ApplicationTest {
    private ArrayList<String> testInput1;

    private ArrayList<String> testInput2;
    @BeforeEach
    public void setTestInput() {
        testInput1 = new ArrayList<>(Arrays.asList("waffles", "apples", "oatmeal", "five hour energy shot"));
        testInput2 = new ArrayList<>(Arrays.asList("pancakes", "oranges", "eggs", "coffee"));
    }
    @AfterEach
    public void clearTestInput() {
        testInput1.clear();
        testInput2.clear();
    }

    // Exercise One - Create an Arraylist and add each of the given words to it.
    @Test
    public void createFoodsList_Test1() {
        ArrayList<String> output = Application.createFoodsList(testInput1.get(0), testInput1.get(1), testInput1.get(2), testInput1.get(3));
        assertEquals(testInput1.toString(), output.toString(), String.format("Expected createFoodList to return %s but was %s", testInput1.toString(), output));
    }

    @Test
    public void createFoodsList_Test2() {
        ArrayList<String> output = Application.createFoodsList(testInput2.get(0), testInput2.get(1), testInput2.get(2), testInput2.get(3));
        assertEquals(testInput2.toString(), output.toString(), String.format("Expected createFoodList to return %s but was %s", testInput2.toString(), output));
    }

    // Exercise Two - Find the size of the array
    @Test
    public void findTheSizeOfArrayList_Test1() {
        int expectedInitialArraySize = 4;
        int initialArraySize = Application.findTheSizeOfArrayList(testInput1);
        assertEquals(expectedInitialArraySize, initialArraySize, String.format("Expected the array list size to be %s but was %s", expectedInitialArraySize, initialArraySize));

        testInput1.add("changing the size");
        int expectedUpdatedArraySize = 5;
        int updatedArraySize = Application.findTheSizeOfArrayList(testInput1);
        assertEquals(expectedUpdatedArraySize, Application.findTheSizeOfArrayList(testInput1), String.format("Expected the array list size to be %s but was %s", expectedUpdatedArraySize,  updatedArraySize));
    }

    @Test
    public void findTheSizeOfArrayList_Test2() {
        int expectedInitialArraySize = 4;
        int initialArraySize = Application.findTheSizeOfArrayList(testInput2);
        assertEquals(expectedInitialArraySize, initialArraySize, String.format("Expected the array list size to be %s but was %s", expectedInitialArraySize, initialArraySize));

        testInput2.add("changing the size");
        int expectedUpdatedArraySize = 5;
        int updatedArraySize = Application.findTheSizeOfArrayList(testInput2);
        assertEquals(expectedUpdatedArraySize, Application.findTheSizeOfArrayList(testInput2), String.format("Expected the array list size to be %s but was %s", expectedUpdatedArraySize,  updatedArraySize));
    }

    // Exercise Three - Access the element at the index
    @Test
    public void accessTheElementAtParticularIndex_Test1() {
        int initialIndexToFind = 2;
        String initialItemAtIndex = Application.accessTheElementAtParticularIndex(testInput1, initialIndexToFind);
        assertEquals("oatmeal", initialItemAtIndex, String.format("Expected item "));

        int updatedIndexToFind = 4;
        testInput1.add("changing the size");
        String itemAtUpdatedIndex = Application.accessTheElementAtParticularIndex(testInput1, updatedIndexToFind);
        assertEquals("changing the size", itemAtUpdatedIndex);
    }

    @Test
    public void accessTheElementAtParticularIndex_Test2() {
        int initialIndexToFind = 2;
        String initialItemAtIndex = Application.accessTheElementAtParticularIndex(testInput2, initialIndexToFind);
        assertEquals("eggs", initialItemAtIndex, String.format("Expected item "));

        int updatedIndexToFind = 4;
        testInput2.add("changing the size");
        String itemAtUpdatedIndex = Application.accessTheElementAtParticularIndex(testInput2, updatedIndexToFind);
        assertEquals("changing the size", itemAtUpdatedIndex);
    }

    // Exercise Four - Count the number
    @Test
    public void countNumOfCakes_Test1() {
        int expectedInitialCountOfCakes = 2;
        testInput1.add("Cake");
        testInput1.add("Cake");
        testInput1.add("Pie");
        int actualInitialNumberOfCakes = Application.countNumOfCakes(testInput1);
        assertEquals(expectedInitialCountOfCakes, actualInitialNumberOfCakes, String.format("Expected count of cakes to be %s but was %s", expectedInitialCountOfCakes, actualInitialNumberOfCakes));

        int expectedUpdatedCountOfCakes = 3;
        testInput1.add("Cake");
        int actualUpdatedNumberOfCakes = Application.countNumOfCakes(testInput1);
        assertEquals(expectedUpdatedCountOfCakes, actualUpdatedNumberOfCakes, String.format("Expected count of cakes to be %s but was %s", expectedUpdatedCountOfCakes, actualUpdatedNumberOfCakes));
    }

    @Test
    public void countNumOfCakes_Test2() {
        int expectedInitialCountOfCakes = 1;
        testInput2.add("Pie");
        testInput2.add("Pie");
        testInput2.add("Cake");
        int actualInitialNumberOfCakes = Application.countNumOfCakes(testInput2);
        assertEquals(expectedInitialCountOfCakes, actualInitialNumberOfCakes, String.format("Expected count of cakes to be %s but was %s", expectedInitialCountOfCakes, actualInitialNumberOfCakes));

        int expectedUpdatedCountOfCakes = 2;
        testInput2.add("Cake");
        int actualUpdatedNumberOfCakes = Application.countNumOfCakes(testInput2);
        assertEquals(expectedUpdatedCountOfCakes, actualUpdatedNumberOfCakes, String.format("Expected count of cakes to be %s but was %s", expectedUpdatedCountOfCakes, actualUpdatedNumberOfCakes));
    }

    // Exercise Five - modify the element at the index
    @Test
    public void modifyTheElementAtParticularIndex_Test1() {
        int indexToModify = 2;
        String stringElement = "hashbrowns";

        Application.modifyTheElementAtParticularIndex(testInput1, indexToModify, stringElement);

        String actualElement = testInput1.get(indexToModify);

        assertEquals(stringElement, actualElement, String.format("Expected to receive the element %s at index %s, but instead received %s", stringElement, indexToModify, actualElement));
    }
    @Test
    public void modifyTheElementAtParticularIndex_Test2() {
        int indexToModify = 2;
        String stringElement = "toast";

        Application.modifyTheElementAtParticularIndex(testInput2, indexToModify, stringElement);

        String actualElement = testInput2.get(indexToModify);

        assertEquals(stringElement, actualElement, String.format("Expected to receive the element %s at index %s, but instead received %s", stringElement, indexToModify, actualElement));
    }

    // Exercise Six - sorting the array
    @Test
    public void sortTheArrayList_Test1() {
        String expectedSortedList = "[apples, five hour energy shot, oatmeal, waffles]";
        Application.sortTheArrayList(testInput1);

        String actualList = testInput1.toString();
        assertEquals(expectedSortedList, actualList, String.format("Expected the list: %s but was %s", expectedSortedList, actualList));
    }

    @Test
    public void sortTheArrayList_Test2() {
        String expectedSortedList = "[coffee, eggs, oranges, pancakes]";
        Application.sortTheArrayList(testInput2);

        String actualList = testInput2.toString();
        assertEquals(expectedSortedList, actualList, String.format("Expected the list: %s but was %s", expectedSortedList, actualList));
    }

    // Exercise Seven - convert to string array
    @Test
    public void convertArrayListToStringArray_Test1() {
        List<String> listToTest = Arrays.asList(Application.convertArrayListToStringArray(testInput1));
        String firstExpectedWord = "apples";
        assertTrue(listToTest.contains(firstExpectedWord));

        String secondExpectedWord = "waffles";
        assertTrue(listToTest.contains(secondExpectedWord));

        String thirdExpectedWord = "oatmeal";
        assertTrue(listToTest.contains(thirdExpectedWord));

        String fourthExpectedWord = "five hour energy shot";
        assertTrue(listToTest.contains(fourthExpectedWord));
    }

    @Test
    public void convertArrayListToStringArray_Test2() {
        List<String> listToTest = Arrays.asList(Application.convertArrayListToStringArray(testInput2));
        String firstExpectedWord = "pancakes";
        assertTrue(listToTest.contains(firstExpectedWord));

        String secondExpectedWord = "oranges";
        assertTrue(listToTest.contains(secondExpectedWord));

        String thirdExpectedWord = "eggs";
        assertTrue(listToTest.contains(thirdExpectedWord));

        String fourthExpectedWord = "coffee";
        assertTrue(listToTest.contains(fourthExpectedWord));
    }

    // Exercise Eight - convert string array to arraylist
    @Test
    public void convertStringArrayToArrayList_Test1() {
        String[] testArray = { "apples", "waffles", "oatmeal", "five hour energy shot" };
        ArrayList<String> stringArrayListToTest = Application.convertStringArrayToArrayList(testArray);

        String firstExpectedWord = "apples";
        assertTrue(stringArrayListToTest.contains(firstExpectedWord));

        String secondExpectedWord = "waffles";
        assertTrue(stringArrayListToTest.contains(secondExpectedWord));

        String thirdExpectedWord = "oatmeal";
        assertTrue(stringArrayListToTest.contains(thirdExpectedWord));

        String fourthExpectedWord = "five hour energy shot";
        assertTrue(stringArrayListToTest.contains(fourthExpectedWord));
    }

    @Test
    public void convertStringArrayToArrayList_Test2() {
        String[] testArray = { "pancakes", "oranges", "eggs", "coffee" };
        ArrayList<String> stringArrayListToTest = Application.convertStringArrayToArrayList(testArray);

        String firstExpectedWord = "pancakes";
        assertTrue(stringArrayListToTest.contains(firstExpectedWord));

        String secondExpectedWord = "oranges";
        assertTrue(stringArrayListToTest.contains(secondExpectedWord));

        String thirdExpectedWord = "eggs";
        assertTrue(stringArrayListToTest.contains(thirdExpectedWord));

        String fourthExpectedWord = "coffee";
        assertTrue(stringArrayListToTest.contains(fourthExpectedWord));
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