package com.kenzie.dynamiclists;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.apache.commons.lang.StringUtils;
import org.junit.jupiter.api.*;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class ApplicationTest {
    private ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private ByteArrayOutputStream errContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;
    private final PrintStream originalErr = System.err;
    private final InputStream originalIn = System.in;

    private final String multipleAttendeesText1 = "Howard\rTom\rBill\r\r";;
    private final String twoAttendeesText1 = "Howard\rTom\r\r\r";;
    private final String oneAttendeeText1 = "Howard\r\r";;

    private final String multipleAttendeesText2 = "Jack\rTim\rAndrew\r\r";;
    private final String twoAttendeesText2 = "Jack\rTim\r\r\r";;
    private final String oneAttendeeText2 = "Jack\r\r";;


    // Set up streams to test console input and output
    @BeforeAll
    public void setUpStreams() {
        System.setOut(new PrintStream(outContent));
        System.setErr(new PrintStream(errContent));
    }

    @AfterAll
    public void restoreStreams() {
        System.setOut(originalOut);
        System.setErr(originalErr);
        System.setIn(originalIn);
    }

    @BeforeEach
    public void setTestInput() {
        outContent = new ByteArrayOutputStream();
        errContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));
        System.setErr(new PrintStream(errContent));
    }

    public String runMainAndGetOutput(String inputText) {
        ByteArrayInputStream in = new ByteArrayInputStream(inputText.getBytes());
        System.setIn(in);
        Application.main(new String[]{});
        String output = outContent.toString();
        return output;
    }

    @Test
    public void containsYouHaveInvited_Test1() {
        String output = runMainAndGetOutput(multipleAttendeesText1);
        boolean expectedOutputContainsString = output.indexOf("You have invited: ") > -1;

        assertEquals(true, expectedOutputContainsString,"Reason: The output does not contain `You have invited`. Check all spacing and capitalization.");
    }

    @Test
    public void containsYouHaveInvited_Test2() {
        String output = runMainAndGetOutput(multipleAttendeesText2);
        boolean expectedOutputContainsString = output.indexOf("You have invited: ") > -1;

        assertEquals(true, expectedOutputContainsString,"Reason: The output does not contain `You have invited`. Check all spacing and capitalization.");
    }

    @Test
    public void addMultipleAttendees_Test1() {
        String output = runMainAndGetOutput(multipleAttendeesText1);
        boolean expectedOutputContainsString = output.indexOf("You have invited: ") > -1;

        assertEquals(true, expectedOutputContainsString,"Reason: The output does not contain `You have invited`. Check all spacing and capitalization.");

        String attendeesOutput = output.substring(output.indexOf("You have invited: ") + 18);
        boolean indexOfNamesInOutput = attendeesOutput.indexOf("Howard, Tom, and Bill") == 0;

        assertEquals(true, indexOfNamesInOutput, "Reason: Expected \"Howard, Tom, and Bill\". " +
                "Received: \"" + attendeesOutput + "\".  Output must contain the entered tests in order. Check spacing and punctuation.");
    }

    @Test
    public void addMultipleAttendees_Test2() {
        String output = runMainAndGetOutput(multipleAttendeesText2);
        boolean expectedOutputContainsString = output.indexOf("You have invited: ") > -1;

        assertEquals(true, expectedOutputContainsString,"Reason: The output does not contain `You have invited`. Check all spacing and capitalization.");

        String attendeesOutput = output.substring(output.indexOf("You have invited: ") + 18);
        boolean indexOfNamesInOutput = attendeesOutput.indexOf("Jack, Tim, and Andrew") == 0;

        // Test data from other attendee string groupings
        assertEquals(0, StringUtils.countMatches(attendeesOutput, "Howard"),
                "Reason: Expected \"Jack, Tim, and Andrew\". Received: \"" + attendeesOutput + "\". It looks like your output contains data from another test. Are you using a static variable to hold your attendees?");

        // Contains duplicates
        assertEquals(1, StringUtils.countMatches(attendeesOutput, "Tim"),
                "Reason: Expected \"Jack, Tim, and Andrew\". Received: \"" + attendeesOutput + "\". It looks like your output contains duplicates.");

        assertEquals(true, indexOfNamesInOutput, "Reason: Expected \"Jack, Tim, and Andrew\". " +
                "Received: \"" + attendeesOutput + "\".  Output must contain the entered tests in order. Check spacing and punctuation.");
    }

    @Test
    public void addTwoAttendees_Test1() {
        String output = runMainAndGetOutput(twoAttendeesText1);
        assertEquals(true, output.indexOf("You have invited: ") > -1,"Reason: The output does not contain `You have invited`. Check all spacing and capitalization.");

        String attendeesOutput = output.substring(output.indexOf("You have invited: ") + 18);
        boolean indexOfNamesInOutput = attendeesOutput.indexOf("Howard and Tom") == 0;

        // Test data from other attendee string groupings
        assertEquals(0, StringUtils.countMatches(attendeesOutput, "Jack") + StringUtils.countMatches(attendeesOutput, "Bill"),
                "Reason: Expected \"Howard and Tom\". Received: \"" + attendeesOutput + "\". It looks like your output contains data from another test. Are you using a static variable to hold your attendees?");

        // Contains Duplicates
        assertEquals(1, StringUtils.countMatches(attendeesOutput, "Tom"),
                "Reason: Expected \"Howard and Tom\". Received: \"" + attendeesOutput + "\". It looks like your output contains duplicates.");

        assertEquals(true, indexOfNamesInOutput,
                "Reason: Expected \"Howard and Tom\". Received: \"" + attendeesOutput + "\". Check spacing and punctuation");
    }

    @Test
    public void addTwoAttendees_Test2() {
        String output = runMainAndGetOutput(twoAttendeesText2);
        assertEquals(true, output.indexOf("You have invited: ") > -1,"Reason: The output does not contain `You have invited`. Check all spacing and capitalization.");

        String attendeesOutput = output.substring(output.indexOf("You have invited: ") + 18);
        boolean indexOfNamesInOutput = attendeesOutput.indexOf("Jack and Tim") == 0;

        assertEquals(0, StringUtils.countMatches(attendeesOutput, "Howard") +  StringUtils.countMatches(attendeesOutput, "Howard"),
                "Reason: Expected \"Jack and Tim\". Received: \"" + attendeesOutput + "\". It looks like your output contains output from another test. Are you using a static variable to hold your attendees?");

        // Contains Duplicates
        assertEquals(1, StringUtils.countMatches(attendeesOutput, "Jack"),
                "Reason: Expected \"Jack and Tim\". Received: \"" + attendeesOutput + "\". It looks like your output contains duplicates.");


        assertEquals(true, indexOfNamesInOutput,
                "Reason: Expected \"Jack and Tim\". Received: \"" + attendeesOutput + "\". Check spacing and punctuation");
    }

    @Test
    public void addOneAttendee_Test1() {
        String output = runMainAndGetOutput(oneAttendeeText1);
        assertEquals(true, output.indexOf("You have invited: ") > -1,"Reason: The output does not contain `You have invited`. Check all spacing and capitalization.");
        String attendeesOutput = output.substring(output.indexOf("You have invited: ") + 18);

        boolean indexOfNamesInOutput = attendeesOutput.indexOf("Howard") == 0;

        assertEquals(0, StringUtils.countMatches(attendeesOutput, "Jack"),
                "Reason: Expected \"Howard\". Received: \"" + attendeesOutput + "\". It looks like your output contains data from another test. Are you using a static variable to hold your attendees?");

        assertEquals(1, StringUtils.countMatches(attendeesOutput, "Howard"),
                "Reason: Expected \"Howard\". Received: \"" + attendeesOutput + "\". It looks like your output contains duplicates.");

        assertEquals(true, indexOfNamesInOutput,
                "Reason: Expected \"Howard\". Received: \"" + attendeesOutput + "\". Check spacing and punctuation");

    }

    @Test
    public void addOneAttendee_Test2() {
        String output = runMainAndGetOutput(oneAttendeeText2);
        assertEquals(true, output.indexOf("You have invited: ") > -1,"Reason: The output does not contain `You have invited`. Check all spacing and capitalization.");
        String attendeesOutput = output.substring(output.indexOf("You have invited: ") + 18);

        boolean indexOfNamesInOutput = attendeesOutput.indexOf("Jack") == 0;

        assertEquals(0, StringUtils.countMatches(attendeesOutput, "Howard") + StringUtils.countMatches(attendeesOutput, "Tim"),
                "Reason: Expected \"Jack\". Received: \"" + attendeesOutput + "\". It looks like your output contains data from another test. Are you using a static variable to hold your attendees?");

        assertEquals(true, indexOfNamesInOutput,
                "Reason: Expected \"Jack\". Received: \"" + attendeesOutput + "\". Check spacing and punctuation");

    }
}
