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
import cput.codez.angorora.eventstar.model.Staff;
import cput.codez.angorora.eventstar.model.Statistics;
import cput.codez.angorora.eventstar.repository.EventRepository;
import cput.codez.angorora.eventstar.repository.StaffRepository;
import cput.codez.angorora.eventstar.repository.VenueRepository;
import cput.codez.angorora.eventstar.services.ReassignStaffService;
import cput.codez.angorora.eventstar.services.TotalCostService;
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
public class ReassignStaff {

    Staff staff1;
    Staff staff2;
    Staff staff3;
    private Event event1;
    private Event event2;
    private Event event3;
    Contact contact;
    private Statistics statistics;
    private Budget budget;
    Reminder reminder;
    Invitation invitation;
    private static VenueRepository venRepo;
    private static EventRepository evRepo;
    private static StaffRepository staffRepo;
    private static ApplicationContext ctx;
    private ReassignStaffService reStaffService;
    private TotalCostService totalCostService;
    Calendar calendar = new GregorianCalendar();
    Calendar calendar2 = new GregorianCalendar();

    public ReassignStaff() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    @Test
    public void createStaff() {
        staffRepo = ctx.getBean(StaffRepository.class);
        evRepo = ctx.getBean(EventRepository.class);
        calendar.set(2014, 10, 12, 8, 00);
        calendar2.set(2014, 10, 14, 8, 00);
        statistics = new Statistics.Builder(20)
                .attendees(500)
                .males(100)
                .females(400)
                .build();
        budget = new Budget.Builder(100)
                .audioVisualCost(100)
                .decor(100)
                .foodCost(100)
                .marketingCost(100)
                .photo(100)
                .security(100)
                .speaker(100)
                .staffCost(100)
                .transport(100)
                .build();
        invitation = new Invitation.Builder("You are invited to attend the Launch of the new Toyota Corolla")
                .issueDate(calendar)
                .build();
        reminder = new Reminder.Builder("On the 26 of May you are going to have a Holiday")
                .activeDate(calendar)
                .build();
        Assert.assertEquals(statistics.getFemaleAttendees(), 400);
        event1 = new Event.Builder("Techdays")
                .startDate(calendar)
                .endDate(calendar2)
                .price(450)
                .eventType("Conference")
                .invitation(invitation)
                .budget(budget)
                .reminder(reminder)
                .stats(statistics)
                .refundable("Y")
                .refundrate(10)
                .build();
        evRepo.save(event1);
        event3 = new Event.Builder("Techdays")
                .startDate(calendar)
                .endDate(calendar)
                .price(450)
                .invitation(invitation)
                .budget(budget)
                .reminder(reminder)
                .stats(statistics)
                .eventType("Conference")
                .refundable("Y")
                .refundrate(10)
                .build();
        evRepo.save(event3);
        event2 = new Event.Builder("Techdays")
                .startDate(calendar)
                .endDate(calendar)
                .price(450)
                .invitation(invitation)
                .budget(budget)
                .reminder(reminder)
                .stats(statistics)
                .eventType("Conference")
                .refundable("Y")
                .refundrate(10)
                .build();

        evRepo.save(event2);
        contact = new Contact.Builder("0840472266")
                .email("allen.ngorora@gmail.com")
                .telno(null)
                .webaddress(null)
                .build();
        staff1 = new Staff.Builder("Allen")
                .surname("Ngcxumza")
                .contact(contact)
                .build();
        staffRepo.save(staff1);
        staff2 = new Staff.Builder("Allen")
                .surname("Ngcxumza")
                .contact(contact)
                .build();
        staffRepo.save(staff2);
        staff3 = new Staff.Builder("Allen")
                .surname("Ngcxumza")
                .contact(contact)
                .build();
        staffRepo.save(staff3);
    }

    @Test(dependsOnMethods = "createStaff")
    public void reassignTest() {
        Event assignedEvent;
        reStaffService = ctx.getBean(ReassignStaffService.class);
        List<String> nameList = new ArrayList<>();
        nameList.add("Ngcxumza");
        String eventName = "Techdays";
        assignedEvent = reStaffService.getAssignedStaff(nameList, eventName);
        System.out.println(assignedEvent.getStaff());
    }
@Test
public void totalCostEstimate(){
    double eventCost;
    totalCostService= ctx.getBean(TotalCostService.class);
    eventCost=totalCostService.getTotalCost("Techdays");
    Assert.assertEquals(eventCost, 1000, 0.01);
}

    @BeforeClass
    public static void setUpClass() throws Exception {
        ctx = new AnnotationConfigApplicationContext(ConnectionConfig.class);
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
      evRepo.deleteAll();
      staffRepo.deleteAll();
    }

    @BeforeMethod
    public void setUpMethod() throws Exception {
    }

    @AfterMethod
    public void tearDownMethod() throws Exception {
    }
}
