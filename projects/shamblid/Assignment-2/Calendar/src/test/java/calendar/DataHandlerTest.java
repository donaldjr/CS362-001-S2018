
/** A JUnit test class to test the class DataHandler. */


package calendar;

import org.junit.Test;
import static org.junit.Assert.*;
import calendar.Appt;
import calendar.CalDay;
import calendar.DataHandler;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.LinkedList;


public class DataHandlerTest{

  @Test(timeout = 4000)
  public void test_constructor()  throws Throwable  {
    DataHandler one = new DataHandler();
    DataHandler two = new DataHandler("data");
    DataHandler three = new DataHandler("data1", false);
  
  }
  @Test(timeout = 4000)
  public void test01()  throws Throwable  {
    DataHandler one = new DataHandler("data");
    GregorianCalendar firstDay = new GregorianCalendar(2018, 12, 27);
    GregorianCalendar lastDay = new GregorianCalendar(2019, 2, 15);
   
    CalDay day1 = new CalDay(firstDay);
    CalDay day2 = new CalDay(lastDay);

    Appt appt0 = new Appt(12, 30, 27, 12, 2018, "Doctor", "Appointment at doctor", "dj@dj.com");
    Appt appt1 = new Appt(0, 9, 28, 12, 2018, "Birthday Party", "Party!!", "dj@dj.com");

    int[] recurringDays = new int[0];
    int[] recurringDays1 = new int[0];

    appt0.setRecurrence(recurringDays, appt0.RECUR_BY_WEEKLY, 1, 10);
    appt1.setRecurrence(recurringDays1, appt0.RECUR_BY_YEARLY, 1, 10);

    one.saveAppt(appt0);
    one.saveAppt(appt1);

    one.getApptRange(firstDay, lastDay);
    one.deleteAppt(appt1);
    one.save();
    
  }

  @Test(timeout = 4000)
  public void test02() throws Throwable {
    DataHandler one = new DataHandler();
    GregorianCalendar firstDay = new GregorianCalendar(2018, 12, 27);
    GregorianCalendar lastDay = new GregorianCalendar(2018, 12, 29);

    CalDay day1 = new CalDay(firstDay);
    CalDay day2 = new CalDay(lastDay);

    Appt appt0 = new Appt(12, 30, 27, 12, 2018, "Doctor", "Appointment at doctor", "dj@dj.com");
    Appt appt1 = new Appt(0, 9, 28, 12, 2018, "Birthday Party", "Party!!", "dj@dj.com");

    day1.addAppt(appt0);
    day2.addAppt(appt1);

    one.saveAppt(appt0);
    one.saveAppt(appt1);
    one.getApptRange(firstDay, lastDay);
    one.deleteAppt(appt1);
    one.save();

  }

  // @Test(timeout = 4000)
  // public void test03() throws Throwable{
  //   DataHandler dh = new DataHandler();
  //   GregorianCalendar firstDay = new GregorianCalendar(2018, 12, 30);
  //   GregorianCalendar lastDay = new GregorianCalendar(2018, 12, 29);

  //   dh.getApptRange(firstDay, lastDay);
  // }

  @Test(timeout = 4000)
  public void test04() throws Throwable {

    DataHandler dh = new DataHandler();
    GregorianCalendar firstDay = new GregorianCalendar(2018, 12, 20);
    GregorianCalendar lastDay = new GregorianCalendar(2019, 5, 25);

    Appt appt0 = new Appt(12, 30, 27, 12, 2018, "Doctor", "Appointment at doctor", "dj@dj.com");
    
    int[] recurringDays = new int[0];
    appt0.setRecurrence(recurringDays, Appt.RECUR_BY_WEEKLY, 2, 3);

    dh.saveAppt(appt0);

    dh.getApptRange(firstDay, lastDay);
  }

  @Test(timeout = 4000)
  public void test05() throws Throwable {

    DataHandler dh = new DataHandler();
    GregorianCalendar firstDay = new GregorianCalendar(2018, 12, 20);
    GregorianCalendar lastDay = new GregorianCalendar(2019, 12, 25);

    Appt appt0 = new Appt(12, 30, 27, 12, 2018, "Doctor", "Appointment at doctor", "dj@dj.com");
    
    int[] recurringDays = new int[1];
    recurringDays[0] = 1;
    appt0.setRecurrence(recurringDays, Appt.RECUR_BY_WEEKLY, 10, 10);

    dh.saveAppt(appt0);

    dh.getApptRange(firstDay, lastDay);
  }

  @Test(timeout = 4000)
  public void test06() throws Throwable {

    DataHandler dh = new DataHandler();
    GregorianCalendar firstDay = new GregorianCalendar(2018, 12, 20);
    GregorianCalendar lastDay = new GregorianCalendar(2019, 12, 25);

    Appt appt0 = new Appt(12, 30, 20, 12, 2018, "Doctor", "Appointment at doctor", "dj@dj.com");

    int[] recurringDays = new int[0];
    appt0.setRecurrence(recurringDays, Appt.RECUR_BY_WEEKLY, 2, 3);

    dh.saveAppt(appt0);

    dh.getApptRange(firstDay, lastDay);
  }
  
}
