/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cput.codez.angorora.test.services;

import cput.codez.angorora.eventstar.app.conf.ConnectionConfig;
import cput.codez.angorora.eventstar.model.Attendee;
import cput.codez.angorora.eventstar.model.Budget;
import cput.codez.angorora.eventstar.model.Company;
import cput.codez.angorora.eventstar.model.Contact;
import cput.codez.angorora.eventstar.model.Event;
import cput.codez.angorora.eventstar.model.Invitation;
import cput.codez.angorora.eventstar.model.Payment;
import cput.codez.angorora.eventstar.model.Reminder;
import cput.codez.angorora.eventstar.model.Statistics;
import cput.codez.angorora.eventstar.repository.AttendeeRepository;
import cput.codez.angorora.eventstar.repository.CompanyRepository;
import cput.codez.angorora.eventstar.repository.EventRepository;
import cput.codez.angorora.eventstar.services.AttendeeEventService;
import cput.codez.angorora.eventstar.services.TotalFeesService;
import cput.codez.angorora.eventstar.services.VegetarianService;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
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
public class VegetarianNumberService {

    private Event event;
    private Attendee att1;
    private Attendee att2;
    private Attendee att3;
    private Payment pay1;
    private Company company;
    private Company company1;
    private Contact contact;
    private Statistics statistics;
    private Budget budget;
    Reminder reminder;
    VegetarianService attendeeService;
    AttendeeEventService attendeeEventService;
    TotalFeesService totalFeesService;
    Invitation invitation;
    private static AttendeeRepository attRepo;
    private static EventRepository evRepo;
    private static CompanyRepository companyRepo;
    private List<Attendee> attList = new ArrayList<>();
    Calendar calendar = new GregorianCalendar();

    private static ApplicationContext ctx;

    public VegetarianNumberService() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    @Test
    public void createObjects() {
        evRepo = ctx.getBean(EventRepository.class);
        attRepo = ctx.getBean(AttendeeRepository.class);
        companyRepo = ctx.getBean(CompanyRepository.class);
        calendar.set(2014, 10, 12, 8, 00);
        pay1 = new Payment.Builder(100).build();
        contact = new Contact.Builder("0840472266")
                .email("allen.ngorora@gmail.com")
                .telno(null)
                .webaddress(null)
                .build();
        company = new Company.Builder("CPUT")
                .contact(null)
                .build();
        companyRepo.save(company);

        company1 = new Company.Builder("Toyota Cape Town")
                .contact(null)
                .build();
        companyRepo.save(company1);
        att1 = new Attendee.Builder(contact)
                .age(19)
                .company("CPUT")
                .diet("Vegaterian")
                .firstName("Allen")
                .ID("212199587")
                .lastName("Ngorora")
                .gender("M")
                .payment(pay1)
                .build();
        attRepo.save(att1);
        att2 = new Attendee.Builder(contact)
                .age(19)
                .company("Toyota Cape Town")
                .diet("Non-Vegaterian")
                .ID("212095166")
                .firstName("Anesu")
                .lastName("Ngorora")
                .gender("M")
                .payment(pay1)
                .build();
        attRepo.save(att2);
        att3 = new Attendee.Builder(contact)
                .age(19)
                .company("CPUT")
                .diet("Vegaterian")
                .ID("215636954")
                .firstName("Tatenda")
                .lastName("Ngorora")
                .gender("M")
                .payment(pay1)
                .build();
        attRepo.save(att3);
        attList.add(att1);
        attList.add(att2);
        attList.add(att3);
        statistics = new Statistics.Builder(20)
                .attendees(500)
                .males(100)
                .females(400)
                .build();
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
        invitation = new Invitation.Builder("You are invited to attend the Launch of the new Toyota Corolla")
                .issueDate(calendar)
                .build();
        reminder = new Reminder.Builder("On the 26 of May you are going to have a Holiday")
                .activeDate(calendar)
                .build();
        event = new Event.Builder("Techdays")
                .startDate(calendar)
                .endDate(calendar)
                .price(450)
                .eventType("Conference")
                .invitation(invitation)
                .budget(budget)
                .attendee(attList)
                .reminder(reminder)
                .stats(statistics)
                .refundable("Y")
                .refundrate(10)
                .build();
        evRepo.save(event);
    }

    @Test(dependsOnMethods = "createObjects")
    public void testAttendees() {
        long numOfVegans;
        attendeeService = ctx.getBean(VegetarianService.class);
        numOfVegans = attendeeService.getVegetarians("Techdays");
        Assert.assertEquals(numOfVegans, 2);
    }
@Test
public void totalFeesPaid(){
    double totFees=0;
     totalFeesService= ctx.getBean(TotalFeesService.class);
     totFees=totalFeesService.getTotalFees("Techdays");
     Assert.assertEquals(totFees, 300, 0.01);
}
    @Test(dependsOnMethods = "createObjects")
    public void findEventFromAttendee() {
        List<Event> events = new ArrayList<>();
        attendeeEventService = ctx.getBean(AttendeeEventService.class);
        events = attendeeEventService.getEvents("212199587");
        Assert.assertEquals(events.size(), 1);
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
        ctx = new AnnotationConfigApplicationContext(ConnectionConfig.class);
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
        evRepo.deleteAll();
        attRepo.deleteAll();
    }

    @BeforeMethod
    public void setUpMethod() throws Exception {
    }

    @AfterMethod
    public void tearDownMethod() throws Exception {
    }
}
