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

    Appt appt0 = new Appt(12, 30, 27, 12, 2018, "Doctor", "Appointment at doctor", "dj@dj.com");
    Appt appt1 = new Appt(20, 30, 27, 12, 2018, "Birthday Party", "Party!!", "dj@dj.com");

    day.addAppt(appt0);
    day.addAppt(appt1);

    assertTrue(day.isValid());
    day.toString();
  }
}
