/** A JUnit test class to test the class CalDay. */

package calendar;

import org.junit.Test;
import static org.junit.Assert.*;
import calendar.Appt;
import calendar.CalDay;
import java.util.*;


public class CalDayTest{

  @Test(timeout = 4000)
  public void test_get_full_info()  throws Throwable  {
    GregorianCalendar cal = new GregorianCalendar(2018, 12, 27);
    CalDay day = new CalDay(cal);
    Appt appt0 = new Appt(12, 30, 27, 12, 2018, "Doctor", "Appointment at doctor", "dj@dj.com");
    Appt appt1 = new Appt(0, 9, 27, 12, 2018, "Birthday Party", "Party!!", "dj@dj.com");

    day.addAppt(appt0);
    day.addAppt(appt1);

    day.getAppts();
    day.getSizeAppts();
    
    day.getFullInfomrationApp(day);
    
  }

  @Test(timeout = 4000)
  public void test_invalid_cal_day()  throws Throwable  {
    CalDay day = new CalDay();
    day.iterator();
    day.toString();
  }

  @Test(timeout = 4000)
  public void test_to_string() throws Throwable {
    GregorianCalendar cal = new GregorianCalendar(2018, 12, 27);
    CalDay day = new CalDay(cal);

    Appt appt0 = new Appt(13, 30, 27, 12, 2018, "Doctor", "Appointment at doctor", "dj@dj.com");
    Appt appt1 = new Appt(12, 30, 27, 12, 2018, "Birthday Party", "Party!!", "dj@dj.com");
    Appt appt2 = new Appt(11, 30, 27, -1, 2018, "Birthday Party", "Party!!", "dj@dj.com");
   
    appt0.setValid();
    appt1.setValid();
    appt2.setValid();

    assertTrue(appt0.getValid());
    assertTrue(appt1.getValid());
    assertFalse(appt2.getValid());

    day.addAppt(appt0);
    day.addAppt(appt1);
    day.addAppt(appt2);

    assertTrue(day.isValid());
    assertEquals(cal.get(cal.DAY_OF_MONTH), day.getDay());
    assertEquals(cal.get(cal.MONTH)+1, day.getMonth());

    assertTrue(day.appts.contains(appt0));
    assertTrue(day.appts.contains(appt1));
    assertFalse(day.appts.contains(appt2));


    assertEquals(day.getSizeAppts(), 2);
    assertEquals(day.getYear(), 2019);

    String test_string = day.toString();
    assertEquals(day.toString(), test_string);
  }

  @Test(timeout = 4000)
  public void test_decrement_operator() throws Throwable {
    GregorianCalendar cal = new GregorianCalendar(2018, 12, 27);
    CalDay day = new CalDay(cal);

    Appt appt1 = new Appt(13, 30, 27, 12, 2018, "Birthday Party", "Party!!", "dj@dj.com");
    Appt appt2 = new Appt(12, 30, 27, 12, 2018, "Birthday Party", "Party!!", "dj@dj.com");
    Appt appt3 = new Appt(11, 30, 27, 12, 2018, "Birthday Party", "Party!!", "dj@dj.com");

    day.addAppt(appt1);
    day.addAppt(appt2);
    day.addAppt(appt3);

    LinkedList<Appt> appts = day.getAppts();
    assertEquals(appts.get(0), appt3);
    assertEquals(appts.get(1), appt2);
    assertEquals(appts.get(2), appt1);

  }

  @Test(timeout = 4000)
  public void test_add_appt_boundary() throws Throwable {
    GregorianCalendar cal = new GregorianCalendar(2018, 12, 27);
    CalDay day = new CalDay(cal);

    Appt appt1 = new Appt(12, 31, 27, 12, 2018, "Birthday Party", "Party!!", "dj@dj.com");
    Appt appt2 = new Appt(12, 30, 27, 12, 2018, "Birthday Party", "Party!!", "dj@dj.com");
    Appt appt3 = new Appt(11, 30, 27, 12, 2018, "Birthday Party", "Party!!", "dj@dj.com");

    day.addAppt(appt1);
    day.addAppt(appt2);
    day.addAppt(appt3);

    LinkedList<Appt> appts = day.getAppts();
    assertEquals(appts.get(0), appt3);
    assertEquals(appts.get(1), appt1);
    assertEquals(appts.get(2), appt2);

  }
  
  @Test(timeout = 4000)
  public void test_init() throws Throwable {
    GregorianCalendar cal = new GregorianCalendar(2018, 12, 27);
    CalDay day = new CalDay(cal);

    assertNotNull(day.getAppts());

  }

  @Test(timeout = 4000)
  public void test_itr_boundary() throws Throwable {
    GregorianCalendar cal = new GregorianCalendar(2018, 12, 27);
    CalDay day = new CalDay(cal);

    Appt appt1 = new Appt(12, 31, 27, 12, 2018, "Birthday Party", "Party!!", "dj@dj.com");
    Appt appt2 = new Appt(12, 10, 27, 12, 2018, "Birthday Party", "Party!!", "dj@dj.com");
    Appt appt3 = new Appt(11, 1, 27, 12, 2018, "Birthday Party", "Party!!", "dj@dj.com");

    day.addAppt(appt1);
    day.addAppt(appt2);
    day.addAppt(appt3);

    assertTrue(appt1.hasTimeSet());
    assertTrue(appt2.hasTimeSet());
    assertTrue(appt3.hasTimeSet());

    String buffer1 = day.getFullInfomrationApp(day);
    assertNotNull(buffer1);


    Iterator itr = ((CalDay) day).iterator();

    String buffer;
    buffer = Integer.toString(((CalDay) day).getMonth()) + "-";
    buffer += Integer.toString(((CalDay) day).getDay()) + "-";
    buffer += Integer.toString(((CalDay) day).getYear()) + " ";

    Appt appointment;

    int minute;
    int hour;
    String minString;
    String meridianString;

    while (itr.hasNext()) {

      buffer += "\n\t";

      appointment = (Appt) itr.next();

      if (appointment.hasTimeSet()) {

        // figure AM/PM notation
        hour = appointment.getStartHour();
        if (hour > 12) {
          meridianString = "PM";
        } else {
          meridianString = "AM";
        }

        // convert from 24 to 12 hour time
        if (hour == 0) {
          hour = 12;
        } else {
          hour = hour % 12;
        }

        // add preceding zero to minutes less than 10
        minute = appointment.getStartMinute();
        if (minute < 10) {
          minString = new String("0" + Integer.toString(minute));
        } else {
          minString = Integer.toString(minute);
        }

        // create the string containing a data summary
        buffer += hour + ":" + minString + meridianString + " ";

      }
      buffer += appointment.getTitle() + " ";
      buffer += appointment.getDescription() + " ";

    }

    assertEquals(buffer1, buffer);

    
  }

  @Test(timeout = 4000)
  public void test_toString_r() throws Throwable {
    GregorianCalendar cal = new GregorianCalendar(2018, 12, 27);
    CalDay day = new CalDay(cal);

    Appt appt1 = new Appt(12, 31, 27, 12, 2018, "Birthday Party", "Party!!", "dj@dj.com");
    Appt appt2 = new Appt(12, 10, 27, 12, 2018, "Birthday Party", "Party!!", "dj@dj.com");
    Appt appt3 = new Appt(11, 1, 27, 12, 2018, "Birthday Party", "Party!!", "dj@dj.com");

    day.addAppt(appt1);
    day.addAppt(appt2);
    day.addAppt(appt3);

    String test = day.toString();
    assertNotNull(test);

    StringBuilder sb = new StringBuilder();

    if (day.isValid()) {
      String todayDate = (day.getMonth() + 1) + "/" + day.getDay() + "/" + day.getYear();
      sb.append("\t --- " + todayDate + " --- \n");
      sb.append(" --- -------- Appointments ------------ --- \n");
      Iterator<Appt> itr = day.getAppts().iterator();
      while (itr.hasNext()) {
        Object element = itr.next();

        sb.append(element + " ");
      }

      // sb.append(this.appts);
      sb.append("\n");
    }
    String test2 = sb.toString();

    assertEquals(test, test2);
  }
}
