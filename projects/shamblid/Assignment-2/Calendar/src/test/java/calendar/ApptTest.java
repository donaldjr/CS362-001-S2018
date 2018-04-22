/** A JUnit test class to test the class ApptTest. */

package calendar;

import org.junit.Test;
import static org.junit.Assert.*;

import java.io.Console;

import calendar.Appt;
import calendar.CalendarUtil;
public class ApptTest  {

  @Test(timeout = 4000)
  public void test00()  throws Throwable  {
      Appt appt0 = new Appt(15, 30, 9, 14, 2018, "Birthday Party", "This is my birthday party", "xyz@gmail.com");
      String string0 = appt0.toString();
      assertEquals(2, appt0.getRecurBy());
      assertFalse(appt0.isRecurring());
      assertEquals("\t14/9/2018 at 3:30pm ,Birthday Party, This is my birthday party\n", string0);
      assertEquals(0, appt0.getRecurIncrement());
      appt0.setValid();
  }
@Test(timeout = 4000)
 public void test_setValid()  throws Throwable  {
    Appt appt = new Appt(12,30, 15, 12, 2018, "Doctor", "Appointment at doctor", "dj@dj.com");

    // setvalid month branch
    Appt appt0 = new Appt(12, 30, 15, -1, 2018, "Doctor", "Appointment at doctor", "dj@dj.com");
    //setvalid year branch
    Appt appt1 = new Appt(12, 30, 15, 11, 0, "Doctor", "Appointment at doctor", "dj@dj.com");
    //setvalid day branch
    Appt appt2 = new Appt(12, 30, 0, 12, 2018, "Doctor", "Appointment at doctor", "dj@dj.com");
    //setvalid day branch
    Appt appt3 = new Appt(12, 30, 32, 12, 2018, "Doctor", "Appointment at doctor", "dj@dj.com");
    //setvalid month branch
    Appt appt4 = new Appt(12, 30, 20, 13, 2018, "Doctor", "Appointment at doctor", "dj@dj.com");
    //setvalid hour branch
    Appt appt5 = new Appt(-1, 30, 20, 12, 2018, "Doctor", "Appointment at doctor", "dj@dj.com");
    //setvalid hour branch
    Appt appt6 = new Appt(24, 30, 20, 12, 2018, "Doctor", "Appointment at doctor", "dj@dj.com");
    //setvalid minute branch
    Appt appt7 = new Appt(12, 61, 20, 12, 2018, "Doctor", "Appointment at doctor", "dj@dj.com");
    //setvalid minute branch
    Appt appt8 = new Appt(12, -1, 20, 12, 2018, "Doctor", "Appointment at doctor", "dj@dj.com");

    appt.setValid();
    appt0.setValid();
    appt1.setValid();
    appt2.setValid();
    appt3.setValid();
    appt4.setValid();
    appt5.setValid();
    appt6.setValid();
    appt7.setValid();
    appt8.setValid();

    assertTrue(appt.getValid());
    assertFalse(appt0.getValid());
    assertFalse(appt1.getValid());
    assertFalse(appt2.getValid());
    assertFalse(appt3.getValid());
    assertFalse(appt4.getValid());
    assertFalse(appt5.getValid());
    assertFalse(appt6.getValid());
    assertFalse(appt7.getValid());
    assertFalse(appt8.getValid());
    
    //test tostring
    appt0.toString();

  }

  @Test(timeout = 4000)
 public void test_get()  throws Throwable  {
    Appt appt0 = new Appt(12, 30, 15, 11, 2018, "Doctor", "Appointment at doctor", "dj@dj.com");

    int hour = appt0.getStartHour();
    int minute = appt0.getStartMinute();
    int day = appt0.getStartDay();
    int month = appt0.getStartMonth();
    int year = appt0.getStartYear();
    String title = appt0.getTitle();
    String description = appt0.getDescription();
    String email = appt0.getEmailAddress();
    boolean valid = appt0.getValid(); 

    assertEquals(hour, 12);
    assertEquals(minute, 30);
    assertEquals(day, 15);
    assertEquals(month, 11);
    assertEquals(year, 2018);
    assertEquals(title, "Doctor");
    assertEquals(description, "Appointment at doctor");
    assertEquals(email, "dj@dj.com");
    assertTrue(valid);
    assertTrue(appt0.hasTimeSet());

  }
  
  @Test(timeout = 4000)
  public void test_dateIsOn() throws Throwable {
    Appt appt0 = new Appt(12, 30, 15, 11, 2018, "Doctor", "Appointment at doctor", "dj@dj.com");

    assertTrue(appt0.isOn(15, 11, 2018));
  }

  @Test(timeout = 4000)
  public void test_notime() throws Throwable {
    Appt appt0 = new Appt(15, 11, 2018, "Doctor", "Appointment at doctor", "dj@dj.com");

    assertFalse(appt0.hasTimeSet());
  }

  @Test(timeout = 4000)
  public void test_null_strings() throws Throwable {
    Appt appt0 = new Appt(15, 11, 2018, null, null, null);

    assertEquals("", appt0.getDescription());
    assertEquals("", appt0.getTitle());
    assertEquals("", appt0.getEmailAddress());

  }
}


