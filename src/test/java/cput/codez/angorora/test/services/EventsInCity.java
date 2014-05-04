/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cput.codez.angorora.test.services;

import cput.codez.angorora.eventstar.services.EventsInCityService;
import cput.codez.angorora.eventstar.app.conf.ConnectionConfig;
import cput.codez.angorora.eventstar.model.Address;
import cput.codez.angorora.eventstar.model.Budget;
import cput.codez.angorora.eventstar.model.Event;
import cput.codez.angorora.eventstar.model.Invitation;
import cput.codez.angorora.eventstar.model.Reminder;
import cput.codez.angorora.eventstar.model.Room;
import cput.codez.angorora.eventstar.model.Statistics;
import cput.codez.angorora.eventstar.model.Venue;
import cput.codez.angorora.eventstar.repository.EventRepository;
import cput.codez.angorora.eventstar.repository.VenueRepository;
import cput.codez.angorora.eventstar.services.LongEventsService;
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
public class EventsInCity {

    private Event event1;
    private Event event2;
    private Event event3;
    private List<Event> evList1 = new ArrayList<>();
    private List<Event> evList2 = new ArrayList<>();
    private List<Event> evList3 = new ArrayList<>();
    private Venue venue1;
    private Venue venue2;
    private Venue venue3;
    private Address addr1;
    private Address addr2;
    private Address addr3;
    private Room r1;
    private Room r2;
    private Room r3;
    private Statistics statistics;
    private Budget budget;
    Reminder reminder;
    Invitation invitation;
    private static VenueRepository venRepo;
    private static EventRepository evRepo;
    EventsInCityService eventsService;
    LongEventsService longEventsService;
    private static ApplicationContext ctx;
    Calendar calendar = new GregorianCalendar();
    Calendar calendar2 = new GregorianCalendar();

    public EventsInCity() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    @Test
    public void saveAllEvents() {
        evRepo = ctx.getBean(EventRepository.class);
        venRepo = ctx.getBean(VenueRepository.class);
        calendar.set(2014, 10, 12, 8, 00);
          calendar2.set(2014, 10, 14, 8, 00);
         statistics=new Statistics.Builder(20)
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
           reminder=new Reminder.Builder("On the 26 of May you are going to have a Holiday")
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
        evList1.add(event1);
        evList2.add(event2);
        evList3.add(event3);
        r1 = new Room.Builder(50).roomName("Dromedaris").build();
        r2 = new Room.Builder(50).roomName("Drome").build();
        r3 = new Room.Builder(50).roomName("Dromed").build();
        addr1 = new Address.Builder("Cape Town").streetnum("109 Browning Rd").surbub("Obs").postal("7900").country("South Africa").build();
        addr2 = new Address.Builder("Paarl").streetnum("109 Browning Rd").surbub("Milnerton").postal("7900").country("South Africa").build();
        addr3 = new Address.Builder("Cape Town").streetnum("109 Browning Rd").surbub("Milnerton").postal("7925").country("South Africa").build();
        venue1 = new Venue.Builder("MPH").address(addr1).event(evList1).room(r1).build();
        venRepo.save(venue1);
        venue3 = new Venue.Builder("Good Hope Center").room(r2).event(evList2).address(addr2).build();
        venRepo.save(venue3);
        venue2 = new Venue.Builder("CTI Center").room(r3).event(evList3).address(addr3).build();
        venRepo.save(venue2);
    }
 @Test
 public void testAllEvents(){
     List<Event>venue = new ArrayList<>();
     eventsService=ctx.getBean(EventsInCityService.class);
     venue=eventsService.getEventsInCity("Cape Town");
     Assert.assertEquals(venue.size(), 2);
 }
@Test
public void testLongEvents(){
    List<Event>longEvents=new ArrayList<>();
    longEventsService=ctx.getBean(LongEventsService.class);
    longEvents= longEventsService.getLongEvents();
    Assert.assertEquals(longEvents.size(), 1);
}
    @BeforeClass
    public static void setUpClass() throws Exception {
        ctx = new AnnotationConfigApplicationContext(ConnectionConfig.class);
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
        venRepo.deleteAll();
        evRepo.deleteAll();
    }

    @BeforeMethod
    public void setUpMethod() throws Exception {
    }

    @AfterMethod
    public void tearDownMethod() throws Exception {
    }
}
