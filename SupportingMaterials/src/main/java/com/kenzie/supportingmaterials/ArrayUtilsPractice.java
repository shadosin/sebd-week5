package com.kenzie.supportingmaterials;

import java.util.Arrays;
import org.apache.commons.lang3.ArrayUtils;

public class ArrayUtilsPractice {

    /*********************************
     * Practice One
     *********************************/

    public static void practiceOne() {
        String seasonArray[] = {"spring", "summer"};
        seasonArray = ArrayUtils.add(seasonArray, "autumn") ;
        System.out.println(Arrays.toString(seasonArray));
        seasonArray = ArrayUtils.add(seasonArray, "winter");
        System.out.println(Arrays.toString(seasonArray));
    }

    /*********************************
     * Practice Two
     *********************************/

    public static void practiceTwo() {
        String[] weekArray = {"Monday", "Tuesday", "Thursday", "Friday"};
        weekArray = ArrayUtils.add(weekArray, 2,"Wednesday");


        System.out.println(Arrays.toString(weekArray));
    }
}
