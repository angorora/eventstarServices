/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package cput.codez.angorora.test.model;

import cput.codez.angorora.eventstar.model.Reminder;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;
import org.testng.Assert;
import static org.testng.Assert.*;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 *
 * @author marc
 */
public class ReminderTest {
    private Reminder reminder;
    private Reminder newReminder;
  Calendar calendar = new GregorianCalendar();
    public ReminderTest() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
     @Test
     public void testCreation() {
         calendar.set(2014, 04, 30, 18, 30);
         reminder=new Reminder.Builder("On the 26 of May you are going to have a Holiday")
                 .activeDate(calendar)
                 .build();
     }
     @Test
     public void tetsUpdate(){
         newReminder= new Reminder.Builder("On the 1st of May you are going to have a Holiday")
                 .activeDate(calendar)
                 .build();
         Assert.assertEquals(newReminder.getMessage(), "On the 1st of May you are going to have a Holiday");
     }
    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }

    @BeforeMethod
    public void setUpMethod() throws Exception {
    }

    @AfterMethod
    public void tearDownMethod() throws Exception {
    }
}
