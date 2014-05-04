/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cput.codez.angorora.test.repositories;

import cput.codez.angorora.eventstar.app.conf.ConnectionConfig;
import cput.codez.angorora.eventstar.model.Address;
import cput.codez.angorora.eventstar.model.Attendee;
import cput.codez.angorora.eventstar.model.Budget;
import cput.codez.angorora.eventstar.model.Contact;
import cput.codez.angorora.eventstar.model.Event;
import cput.codez.angorora.eventstar.model.GuestOfHonour;
import cput.codez.angorora.eventstar.model.Invitation;
import cput.codez.angorora.eventstar.model.Payment;
import cput.codez.angorora.eventstar.model.Refund;
import cput.codez.angorora.eventstar.model.Reminder;
import cput.codez.angorora.eventstar.model.Staff;
import cput.codez.angorora.eventstar.model.Statistics;
import cput.codez.angorora.eventstar.model.Supplier;
import cput.codez.angorora.eventstar.repository.AttendeeRepository;
import cput.codez.angorora.eventstar.repository.EventRepository;
import cput.codez.angorora.eventstar.repository.GuestOfHonourRepository;
import cput.codez.angorora.eventstar.repository.RefundRepository;
import cput.codez.angorora.eventstar.repository.StaffRepository;
import cput.codez.angorora.eventstar.repository.SupplierRepository;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
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

    private List<Staff> staffList=new ArrayList<>();
    private List<Attendee> attList=new ArrayList<>();
    private List<Supplier> supplierList=new ArrayList<>();
    private List<Refund> refundList=new ArrayList<>();
    private List<GuestOfHonour> guestOfHonourList=new ArrayList<>();
    private Statistics stats;
    private Budget budget;
    private Reminder reminder;
    private Invitation invitation;
    private Staff staff;
    private Attendee att;
    private Contact contact;
    private Address address;
    private Supplier supplier;
    private Refund refund;
    private GuestOfHonour guestOfHonour;
    private Event event;
    private Payment payment;
    private Calendar calendar = new GregorianCalendar();
    private static EventRepository evRepo;
    private static StaffRepository staffRepo;
    private static SupplierRepository supRepo;
    private static RefundRepository refundRepo;
    private static GuestOfHonourRepository guestRepo;
    private static AttendeeRepository attRepo;
    private static ApplicationContext ctx;

    public EventRepoTest() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    @Test
    public void objectCreation() {
        refundRepo=ctx.getBean(RefundRepository.class);
        staffRepo=ctx.getBean(StaffRepository.class);
        supRepo=ctx.getBean(SupplierRepository.class);
        guestRepo=ctx.getBean(GuestOfHonourRepository.class);
        attRepo=ctx.getBean(AttendeeRepository.class);
        
        calendar.set(2014, 10, 12, 8, 00);
        payment=new Payment.Builder(300).build();
        contact = new Contact.Builder("0840472266")
                .email("allen.ngoroa@gmail.com")
                .telno("02068242")
                .webaddress("info@africa.org")
                .build();
        stats = new Statistics.Builder(5)
                .attendees(100)
                .males(60)
                .females(70)
                .build();
        budget = new Budget.Builder(1000)
                .audioVisualCost(500)
                .decor(200)
                .foodCost(1000)
                .marketingCost(5000)
                .photo(3000)
                .security(1000)
                .speaker(3000)
                .staffCost(10000)
                .transport(1000)
                .build();
        reminder = new Reminder.Builder("Yo have an Event to attend tommorow ")
                .activeDate(calendar)
                .build();
        invitation = new Invitation.Builder("You are cordialyy invited to the CPUT Annual General Conference")
                .issueDate(calendar)
                .build();
        staff = new Staff.Builder("Allen")
                .surname("Ngorora")
                .role("IT guy")
                .contact(contact)
                .build();
        att = new Attendee.Builder(contact)
                .age(10)
                .company("Microsoft")
                .diet("Vegetarian")
                .firstName("Tonata")
                .lastName("Nakashololo")
                .gender("M")
                .payment(payment)
                .build();
        supplier = new Supplier.Builder("MacDonald's")
                .contact(contact)
                .supService("Food")
                .build();
        refund = new Refund.Builder(1)
                .accountNumber("1073326543")
                .bankName("Nedbank")
                .branchCode("1165")
                .amount(400)
                .dateOfRefund(calendar)
                .build();
        guestOfHonour = new GuestOfHonour.Builder("Sir Boniface")
                .contact(contact)
                .surname("Kabaso")
                .guestInfo("Iri ndo DHARA manje ir usadherere")
                .build();
        staffList.add(staff);
        attList.add(att);
        supplierList.add(supplier);
        refundList.add(refund);
        guestOfHonourList.add(guestOfHonour);
        attRepo.save(att);
        //guestRepo.save(guestOfHonour);
        supRepo.save(supplier);
        staffRepo.save(staff);
       }

    @Test(dependsOnMethods = "objectCreation")
    public void testCreation() {
        evRepo= ctx.getBean(EventRepository.class);
        event=new Event.Builder("Techdays")
                .attendee(attList)
                .budget(budget)
                .endDate(calendar)
                .eventType("Conference")
                .guestOfHonour(guestOfHonourList)
                .invitation(invitation)
                .price(500)
                .refundable("Y").refundrate(10)
                .reminder(reminder)
                .staff(staffList)
                .startDate(calendar)
                .stats(stats)
                .supplier(supplierList)
                .build();
        evRepo.save(event);
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
         ctx = new AnnotationConfigApplicationContext(ConnectionConfig.class);
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
