/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cput.codez.angorora.test.model;

import cput.codez.angorora.eventstar.model.Attendee;
import cput.codez.angorora.eventstar.model.Budget;
import cput.codez.angorora.eventstar.model.Contact;
import cput.codez.angorora.eventstar.model.Event;
import cput.codez.angorora.eventstar.model.GuestOfHonour;
import cput.codez.angorora.eventstar.model.Host;
import cput.codez.angorora.eventstar.model.Invitation;
import cput.codez.angorora.eventstar.model.Reminder;
import cput.codez.angorora.eventstar.model.Staff;
import cput.codez.angorora.eventstar.model.Statistics;
import cput.codez.angorora.eventstar.model.Supplier;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 *
 * @author marc
 */
public class EventTest {

    private List<Staff> staffList=new ArrayList<>();
    private List<Attendee> attList=new ArrayList<>();
    private List<Supplier> supplierList=new ArrayList<>();
    private List<GuestOfHonour> guestOfHonourList=new ArrayList<>();
    private Statistics statistics;
    private Reminder reminder;
    private Invitation invitation;
    private Staff staff;
    private Attendee attendee;
    private Supplier supplier;
    private Budget budget;
    private GuestOfHonour guest;
    private Contact contact;
    private Event event;
    private Event newEvent;
    Calendar calendar = new GregorianCalendar();

    public EventTest() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    @Test
    public void tesCreation() {
        contact = new Contact.Builder("0840472266")
                .email("allen.ngorora@gmail.com")
                .telno(null)
                .webaddress(null)
                .build();
        attendee = new Attendee.Builder(contact)
                .age(19)
                .company(null)
                .diet("Vegaterian")
                .firstName("Allen")
                .lastName("Ngorora")
                .gender("M")
                .build();
        statistics = new Statistics.Builder(20)
                .attendees(500)
                .males(100)
                .females(400)
                .build();
        staff = new Staff.Builder("Allen")
                 .surname("Ngcxumza")
                .contact(contact)
                .build();
        supplier = new Supplier.Builder("KFC")
                .supService("Food")
                .contact(contact)
                .build();
        calendar.set(2014, 04, 30, 18, 30);
        reminder = new Reminder.Builder("On the 26 of May you are going to have a Holiday")
                .activeDate(calendar)
                .build();
        invitation = new Invitation.Builder("You are invited to attend the Launch of the new Toyota Corolla")
                .issueDate(calendar)
                .build();
        guest = new GuestOfHonour.Builder("Dr B")
               .surname("Kabaso")
                .guestInfo("Graduated with 10 Cum Laudes in all his 10 degrees").build();
        budget = new Budget.Builder(3)
                .audioVisualCost(100)
                .decor(300)
                .foodCost(500)
                .marketingCost(300)
                .photo(600)
                .security(200)
                .speaker(600)
                .staffCost(2000)
                .transport(500)
                .build();
        staffList.add(staff);
        attList.add(attendee);
        supplierList.add(supplier);
        guestOfHonourList.add(guest);
        event=new Event.Builder("Techdays")
                .eventType("Conference")
                .price(450)
                .refundable("N")
                .refundrate(0)
                .startDate(calendar)
                .attendee(attList)
                .guestOfHonour(guestOfHonourList)
                .invitation(invitation)
                .reminder(reminder)
                .staff(staffList)
                .supplier(supplierList)
                .build();
        
Assert.assertEquals(event.getGuestOfHonour().size(),1);
    }
@Test
public void testUpdate(){
    newEvent=new Event.Builder("Techdays").copier(event).refundable("Y").refundrate(0.5).build();
    Assert.assertEquals(newEvent.getRefundRate(), 0.5, 0.1);
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
