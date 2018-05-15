package calendar;

import java.util.*;
import java.io.*;
import org.junit.Test;


import static org.junit.Assert.*;



/**
 * Random Test Generator  for DataHandler class.
 */

public class DataHandlerRandomTest {
	
    private static final long TestTimeout = 30 * 500 * 1; /* Timeout at 30 seconds */
    private static final int NUM_TESTS = 100;

    /**
     * Return a randomly selected method to be tests !.
     */
    public static String RandomSelectMethod(Random random) {
        String[] methodArray = new String[] { "deleteAppt", "getApptRange", "setRecurrence" };// The list of the of methods to
                                                                                        // be tested in the Appt class
        int n = random.nextInt(methodArray.length);// get a random number between 0 (inclusive) and methodArray.length
                                                   // (exclusive)

        return methodArray[n]; // return the method name
    }

    /**
     * Return a randomly selected appointments to recur Weekly,Monthly, or Yearly !.
     */
    public static int RandomSelectRecur(Random random) {
        int[] RecurArray = new int[] { Appt.RECUR_BY_WEEKLY, Appt.RECUR_BY_MONTHLY, Appt.RECUR_BY_YEARLY };// The list
                                                                                                           // of the of
                                                                                                           // setting
                                                                                                           // appointments
                                                                                                           // to recur
                                                                                                           // Weekly,Monthly,
                                                                                                           // or Yearly

        int n = random.nextInt(RecurArray.length);// get a random number between 0 (inclusive) and RecurArray.length
                                                  // (exclusive)
        return RecurArray[n]; // return the value of the appointments to recur
    }

    /**
     * Return a randomly selected appointments to recur forever or Never recur !.
     */
    public static int RandomSelectRecurForEverNever(Random random) {
        int[] RecurArray = new int[] { Appt.RECUR_NUMBER_FOREVER, Appt.RECUR_NUMBER_NEVER };// The list of the of
                                                                                            // setting appointments to
                                                                                            // recur
                                                                                            // RECUR_NUMBER_FOREVER, or
                                                                                            // RECUR_NUMBER_NEVER

        int n = random.nextInt(RecurArray.length);// get a random number between 0 (inclusive) and RecurArray.length
                                                  // (exclusive)
        return RecurArray[n]; // return appointments to recur forever or Never recur
    }

    /**
     * Generate Random Tests that tests Appt Class.
     */
    @Test
    public void randomtest() throws Throwable {

        long startTime = Calendar.getInstance().getTimeInMillis();
        long elapsed = Calendar.getInstance().getTimeInMillis() - startTime;
        DataHandler dh = new DataHandler("data");
        DataHandler dh1 = new DataHandler("data1", false);
        System.out.println("Start testing...");
        
        try {
            for (int iteration = 0; elapsed < TestTimeout; iteration++) {
                long randomseed = System.currentTimeMillis(); // 10
                // System.out.println(" Seed:"+randomseed );
                Random random = new Random(randomseed);

                int startHour = ValuesGenerator.getRandomIntBetween(random, -11, 11);
                int startMinute = ValuesGenerator.getRandomIntBetween(random, -11, 11);
                int startDay = ValuesGenerator.getRandomIntBetween(random, -11, 11);
                int startMonth = ValuesGenerator.getRandomIntBetween(random, -11, 11);
                int startYear = ValuesGenerator.getRandomIntBetween(random, 2018, 2018);
                String title = "Birthday Party";
                String description = "This is my birthday party.";
                String emailAddress = "xyz@gmail.com";

                int startHour1 = ValuesGenerator.getRandomIntBetween(random, 1, 11);
                int startMinute1 = ValuesGenerator.getRandomIntBetween(random, 1, 11);
                int startDay1 = ValuesGenerator.getRandomIntBetween(random, 1, 11);
                int startMonth1 = ValuesGenerator.getRandomIntBetween(random, 1, 11);
                int startYear1 = ValuesGenerator.getRandomIntBetween(random, 2018, 2018);

                int startHour2 = ValuesGenerator.getRandomIntBetween(random, 1, 11);
                int startMinute2 = ValuesGenerator.getRandomIntBetween(random, 1, 11);
                int startDay2 = ValuesGenerator.getRandomIntBetween(random, 1, 11);
                int startMonth2 = ValuesGenerator.getRandomIntBetween(random, 1, 11);
                int startYear2 = ValuesGenerator.getRandomIntBetween(random, 2018, 2018);

                GregorianCalendar firstDay = new GregorianCalendar(startYear1, startMonth1, startDay1);
                GregorianCalendar lastDay = new GregorianCalendar(startYear2, startMonth2, startDay2);
                

                // Construct a new Appointment object with the initial data
                // Construct a new Appointment object with the initial data
                Appt appt = new Appt(startHour, startMinute, startDay, startMonth, startYear, title, description,
                        emailAddress);
                dh.saveAppt(appt);

                if (!firstDay.before(lastDay))
                    continue;
                for (int i = 0; i < NUM_TESTS; i++) {
                    String methodName = DataHandlerRandomTest.RandomSelectMethod(random);
                    if (methodName.equals("deleteAppt")) {
                        appt.setValid();
                        if (i % 2 == 0)
                            dh.deleteAppt(appt);
                        else
                            dh1.deleteAppt(appt);
                    } else if (methodName.equals("setRecurrence")) {
                        int sizeArray = ValuesGenerator.getRandomIntBetween(random, 0, 8);
                        int[] recurDays = ValuesGenerator.generateRandomArray(random, sizeArray);
                        int recur = ApptRandomTest.RandomSelectRecur(random);
                        int recurIncrement = ValuesGenerator.RandInt(random);
                        int recurNumber = ApptRandomTest.RandomSelectRecurForEverNever(random);
                        appt.setRecurrence(recurDays, recur, recurIncrement, recurNumber);
                    } else if (methodName.equals("getApptRange")){

                        if( i % 2 == 0)
                            dh.getApptRange(firstDay, lastDay);
                        else
                            dh1.getApptRange(firstDay, lastDay);
                    }
                    
                }

                elapsed = (Calendar.getInstance().getTimeInMillis() - startTime);
                if ((iteration % 10000) == 0 && iteration != 0)
                    System.out.println("elapsed time: " + elapsed + " of " + TestTimeout);

            }
        } catch (NullPointerException e) {

        }

        System.out.println("Done testing...");
    }


	
}
