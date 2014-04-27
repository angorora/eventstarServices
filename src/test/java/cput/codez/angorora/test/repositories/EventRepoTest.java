/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cput.codez.angorora.test.repositories;

import cput.codez.angorora.eventstar.app.conf.ConnectionConfig;
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
import cput.codez.angorora.eventstar.repository.AttendeeRepository;
import cput.codez.angorora.eventstar.repository.BudgetRepository;
import cput.codez.angorora.eventstar.repository.EventRepository;
import cput.codez.angorora.eventstar.repository.GuestOfHonourRepository;
import cput.codez.angorora.eventstar.repository.HostRepository;
import cput.codez.angorora.eventstar.repository.StaffRepository;
import cput.codez.angorora.eventstar.repository.StatisticsRepository;
import cput.codez.angorora.eventstar.repository.SupplierRepository;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
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
public class EventRepoTest {

    private List<Staff> staffList = new ArrayList<>();
    private List<Attendee> attList = new ArrayList<>();
    private List<Supplier> supplierList = new ArrayList<>();
    private List<GuestOfHonour> guestOfHonourList = new ArrayList<>();
    private Statistics statistics;
    private Host host;
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
    public static ApplicationContext ctx;
    public static EventRepository evRepo;
    public static AttendeeRepository attRepo;
    public static SupplierRepository supRepo;
    private static StaffRepository staffRepo;
    private static BudgetRepository budgetRepo;
    private static HostRepository hostRepo;
    private static GuestOfHonourRepository guestRepo;
    private static StatisticsRepository statsRepo;
    private long id;
    private long evid;
    private long bid;
    Calendar calendar = new GregorianCalendar();

    public EventRepoTest() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    @Test
    public void eventObjectStage1() {
        attRepo = ctx.getBean(AttendeeRepository.class);
        statsRepo = ctx.getBean(StatisticsRepository.class);
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
        attRepo.save(attendee);
        statistics = new Statistics.Builder(20)
                .attendees(500)
                .males(100)
                .females(400)
                .build();
//        statsRepo.save(statistics);
        host = new Host.Builder("Microsoft")
                .contact(contact)
                .build();
    }

    @Test(dependsOnMethods = "eventObjectStage1")
    public void eventObjectStage2() {
        staffRepo = ctx.getBean(StaffRepository.class);
        supRepo = ctx.getBean(SupplierRepository.class);
        guestRepo = ctx.getBean(GuestOfHonourRepository.class);
        staff = new Staff.Builder("Allen")
                .surname("Ngcxumza")
                .contact(contact)
                .build();
        staffRepo.save(staff);
        supplier = new Supplier.Builder("KFC")
                .supService("Food")
                .contact(contact)
                .build();
        supRepo.save(supplier);
        calendar.set(2014, 04, 30, 18, 30);
        reminder = new Reminder.Builder("On the 26 of May you are going to have a Holiday")
                .activeDate(calendar)
                .build();
        invitation = new Invitation.Builder("You are invited to attend the Launch of the new Toyota Corolla")
                .issueDate(calendar)
                .build();
        guest = new GuestOfHonour.Builder("Dr B")
                .surname("Kabaso")
                .guestInfo("Graduated with 10 Cum Laudes in all his 10 degrees")
                .build();
        //guestRepo.save(guest);--NB:Though this is not an Embeddible, because there is a CASCADE.ALL in the parent class you wont persist
        //it seperately
    }

    @Test(dependsOnMethods = "eventObjectStage2")
    public void eventObjectStage3() {
        budgetRepo = ctx.getBean(BudgetRepository.class);
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
        //budgetRepo.save(budget);
        staffList.add(staff);
        attList.add(attendee);
        supplierList.add(supplier);
        guestOfHonourList.add(guest);
    }

    @Test(dependsOnMethods = "eventObjectStage3")
    public void tesCreation() {
        evRepo = ctx.getBean(EventRepository.class);

        event = new Event.Builder("Techdays")
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
                .host(host)
                .budget(budget)
                .supplier(supplierList)
                .build();
        evRepo.save(event);
        evid = event.getId();
        id = event.getGuestOfHonour().get(0).getId();
        GuestOfHonour guest = guestRepo.findOne(id);
        Assert.assertEquals(guest.getGuestName(), "Dr B");
    }

   

    @Test(dependsOnMethods = "tesCreation")
    public void testUpdate() {
        evRepo = ctx.getBean(EventRepository.class);
        Event eventOriginal = evRepo.findOne(evid);
        Event updated = new Event.Builder("TechDays")
                .copier(eventOriginal)
                .price(200)
                .build();
        evRepo.save(updated);
        evid = updated.getId();
        updated = evRepo.findOne(evid);
        Assert.assertEquals(updated.getPrice(), 200, 0.01);
    }
 @Test(dependsOnMethods = "testUpdate")
    public void testDelete() {
         budgetRepo = ctx.getBean(BudgetRepository.class);
         bid=event.getBudget().getId();
         budgetRepo.delete(bid);
         Budget budget=budgetRepo.findOne(bid);
        Assert.assertNull(budget);
        
    }
    @BeforeClass
    public static void setUpClass() throws Exception {
        ctx = new AnnotationConfigApplicationContext(ConnectionConfig.class);

    }

    @AfterClass
    public static void tearDownClass() throws Exception {
        attRepo = ctx.getBean(AttendeeRepository.class);
        statsRepo = ctx.getBean(StatisticsRepository.class);
        budgetRepo = ctx.getBean(BudgetRepository.class);
        evRepo = ctx.getBean(EventRepository.class);
        staffRepo = ctx.getBean(StaffRepository.class);
        supRepo = ctx.getBean(SupplierRepository.class);
        hostRepo = ctx.getBean(HostRepository.class);
        guestRepo = ctx.getBean(GuestOfHonourRepository.class);

        guestRepo.deleteAll();
        hostRepo.deleteAll();
        attRepo.deleteAll();
        attRepo.deleteAll();
        staffRepo.deleteAll();
        statsRepo.deleteAll();
        budgetRepo.deleteAll();

        evRepo.deleteAll();
    }

    @BeforeMethod
    public void setUpMethod() throws Exception {
    }

    @AfterMethod
    public void tearDownMethod() throws Exception {
    }
}
