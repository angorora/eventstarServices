/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cput.codez.angorora.test.services;

import cput.codez.angorora.eventstar.app.conf.ConnectionConfig;
import cput.codez.angorora.eventstar.model.Budget;
import cput.codez.angorora.eventstar.model.Contact;
import cput.codez.angorora.eventstar.model.Event;
import cput.codez.angorora.eventstar.model.Invitation;
import cput.codez.angorora.eventstar.model.Reminder;
import cput.codez.angorora.eventstar.model.Statistics;
import cput.codez.angorora.eventstar.model.Supplier;
import cput.codez.angorora.eventstar.repository.EventRepository;
import cput.codez.angorora.eventstar.repository.SupplierRepository;
import cput.codez.angorora.eventstar.repository.VenueRepository;
import cput.codez.angorora.eventstar.services.SameDayService;
import cput.codez.angorora.eventstar.services.StatisticsService;
import cput.codez.angorora.eventstar.services.SupplierService;
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
public class StatisticsTest {

    private Statistics statistics;
    private Budget budget;
    Reminder reminder;
    Invitation invitation;
    private static VenueRepository venRepo;
    private static EventRepository evRepo;
    private static SupplierRepository supRepo;
    private StatisticsService statisticsService;
    private static ApplicationContext ctx;
    private Event event1;
    private Event event2;
    private Event event3;
    private Supplier sup1;
    private Supplier sup2;
    private Supplier sup3;
    private SupplierService supService;
    SameDayService sameDayService;
    private Contact contact;
    List<Supplier> supList = new ArrayList<>();
    Calendar calendar = new GregorianCalendar();

    public StatisticsTest() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    @Test
    public void createEvents() {
        evRepo = ctx.getBean(EventRepository.class);
        supRepo = ctx.getBean(SupplierRepository.class);
        calendar.set(2014, 10, 12, 8, 00);
        contact = new Contact.Builder("0840472266").email("allen.ngorora@gmail.com").telno(null).webaddress(null).build();
        sup1 = new Supplier.Builder("McDonalds").supService("Food").contact(contact).build();
        supRepo.save(sup1);
        sup2 = new Supplier.Builder("AVS").supService("Multimedia").contact(contact).build();
        supRepo.save(sup2);
        sup3 = new Supplier.Builder("Fidelity").supService("Security").contact(contact).build();
        supRepo.save(sup3);
        supList.add(sup1);
        supList.add(sup2);
        supList.add(sup3);
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
        event1 = new Event.Builder("Banda Bands")
                .startDate(calendar)
                .endDate(calendar)
                .price(450)
                .supplier(supList)
                .eventType("Press COnference")
                .invitation(invitation)
                .budget(budget)
                .reminder(reminder)
                .stats(statistics)
                .refundable("Y")
                .refundrate(10)
                .build();
        evRepo.save(event1);
        event3 = new Event.Builder("Toyota Launch")
                .startDate(calendar)
                .endDate(calendar)
                .price(450)
                .invitation(invitation)
                .budget(budget)
                .reminder(reminder)
                .stats(statistics)
                .eventType("Trade Show")
                .refundable("Y")
                .refundrate(10)
                .build();
        evRepo.save(event3);
        event2 = new Event.Builder("BizSpark")
                .startDate(calendar)
                .endDate(calendar)
                .price(450)
                .invitation(invitation)
                .budget(budget)
                .reminder(reminder)
                .stats(statistics)
                .eventType("Seminar")
                .refundable("Y")
                .refundrate(10)
                .build();

        evRepo.save(event2);
    }

    @Test
    public void testStats() {
        statisticsService = ctx.getBean(StatisticsService.class);
        Statistics stats = statisticsService.getStatistics("Toyota Launch");
        Assert.assertEquals(stats.getFemaleAttendees(), 400);
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
        ctx = new AnnotationConfigApplicationContext(ConnectionConfig.class);
    }

    @Test
    public void testEventsSupplier() {
        List<Supplier> allSup = new ArrayList<>();
        supService = ctx.getBean(SupplierService.class);
        allSup = supService.getSuppliers("Banda Bands");
        Assert.assertEquals(allSup.size(), 3);
    }

    @Test
    public void testConcurrentEvents() {
        List<Event> samedayEvents = new ArrayList<>();
        sameDayService = ctx.getBean(SameDayService.class);
        samedayEvents = sameDayService.getConcurrentEvents(calendar);
        Assert.assertEquals(samedayEvents.size(), 3);
    }
    
    @AfterClass

    public static void tearDownClass() throws Exception {
        evRepo.deleteAll();
        supRepo.deleteAll();
        //  venRepo.deleteAll();
    }

    @BeforeMethod
    public void setUpMethod() throws Exception {
    }

    @AfterMethod
    public void tearDownMethod() throws Exception {
    }
}
