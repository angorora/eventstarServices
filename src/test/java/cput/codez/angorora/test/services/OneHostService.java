/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package cput.codez.angorora.test.services;

import cput.codez.angorora.eventstar.app.conf.ConnectionConfig;
import cput.codez.angorora.eventstar.model.Budget;
import cput.codez.angorora.eventstar.model.Event;
import cput.codez.angorora.eventstar.model.Host;
import cput.codez.angorora.eventstar.model.Invitation;
import cput.codez.angorora.eventstar.model.Reminder;
import cput.codez.angorora.eventstar.model.Statistics;
import cput.codez.angorora.eventstar.repository.EventRepository;
import cput.codez.angorora.eventstar.repository.HostRepository;
import cput.codez.angorora.eventstar.services.EventsInCityService;
import cput.codez.angorora.eventstar.services.FreqHostService;
import cput.codez.angorora.eventstar.services.HostService;
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
public class OneHostService {
    private Event event1;
    private Event event2;
    private Event event3;
    private Host host;
    private Host host1;
    private Host host2;
    private List<Event> evList1 = new ArrayList<>();
    private Statistics statistics;
    private Budget budget;
    Reminder reminder;
    Invitation invitation;
    private static HostRepository hostRepo;
    private HostService hostService;
    private FreqHostService freqHostService;
    private static EventRepository evRepo;
    EventsInCityService eventsService;
    private static ApplicationContext ctx;
    Calendar calendar = new GregorianCalendar();

    public OneHostService() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
     @Test
     public void testCreation() {
         evRepo = ctx.getBean(EventRepository.class);
          calendar.set(2014, 10, 12, 8, 00);
          hostRepo=ctx.getBean(HostRepository.class);
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
          event1 = new Event.Builder("Techdays")
                .startDate(calendar)
                .endDate(calendar)
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
        evList1.add(event2);
        evList1.add(event3);
        host=new Host.Builder("Toyota Cape Town").event(evList1).build();
        host1=new Host.Builder("Cape Media").build();
        host2=new Host.Builder("Microsoft").build();
        hostRepo.save(host);
        hostRepo.save(host1);
        hostRepo.save(host2);
     }
@Test
public void testHostService(){
    List<Event> events = new ArrayList<>();
    hostService=ctx.getBean(HostService.class);
    events=hostService.getEventsForHost("Toyota Cape Town");
    Assert.assertEquals(events.size(), 3);
}
@Test
public void testMostFrequentHost(){
    Host freqHost;
    freqHostService=ctx.getBean(FreqHostService.class);
    freqHost=freqHostService.getFreqHost();
    Assert.assertNotNull(freqHost);
}
    @BeforeClass
    public static void setUpClass() throws Exception {
          ctx = new AnnotationConfigApplicationContext(ConnectionConfig.class);
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
        evRepo.deleteAll();
        hostRepo.deleteAll();
    }

    @BeforeMethod
    public void setUpMethod() throws Exception {
    }

    @AfterMethod
    public void tearDownMethod() throws Exception {
    }
}
