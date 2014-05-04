/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package cput.codez.angorora.test.services;

import cput.codez.angorora.eventstar.app.conf.ConnectionConfig;
import cput.codez.angorora.eventstar.model.Budget;
import cput.codez.angorora.eventstar.model.Event;
import cput.codez.angorora.eventstar.model.Invitation;
import cput.codez.angorora.eventstar.model.Refund;
import cput.codez.angorora.eventstar.model.Reminder;
import cput.codez.angorora.eventstar.model.Statistics;
import cput.codez.angorora.eventstar.repository.EventRepository;
import cput.codez.angorora.eventstar.repository.RefundRepository;
import cput.codez.angorora.eventstar.services.RefundsService;
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
public class AllRefundsTest {
    private Refund refund1;
    private Refund refund2;
    private Refund refund3;
    private RefundRepository refRepo;
    private EventRepository eventRepo;
    private Event event;
    private Statistics statistics;
    private Budget budget;
    Reminder reminder;
    Invitation invitation;
    RefundsService refundsService;
    private List<Refund> refundList= new ArrayList<>();
    private static ApplicationContext ctx;
    Calendar calendar=new GregorianCalendar();
    public AllRefundsTest() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
     @Test
     public void createRefunds() {
         refRepo=ctx.getBean(RefundRepository.class);
         eventRepo=ctx.getBean(EventRepository.class);
         calendar.set(2014, 03, 12);
         refund1=new Refund.Builder(1)
                 .accountNumber("1073326543")
                 .bankName("ABSA")
                 .branchCode("ABSAZA")
                 .dateOfRefund(calendar)
                 .build();
         refRepo.save(refund1);
         refund2=new Refund.Builder(1)
                 .accountNumber("1073326543")
                 .bankName("ABSA")
                 .branchCode("ABSAZA")
                 .dateOfRefund(calendar)
                 .build();
          refRepo.save(refund2);
         refund3=new Refund.Builder(1)
                 .accountNumber("1073326543")
                 .bankName("ABSA")
                 .branchCode("ABSAZA")
                 .dateOfRefund(calendar)
                 .build();
          refRepo.save(refund3);
          refundList.add(refund1);
          refundList.add(refund2);
          refundList.add(refund3);
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
           event = new Event.Builder("KEFA")
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
                .refund(refundList)
                .build();
        eventRepo.save(event);
       
     }   
@Test 
public void testAllRefunds(){
    refundsService = ctx.getBean(RefundsService.class);
    List<Refund>  refunds= new ArrayList<>();
    refunds=refundsService.getRefund("KEFA");
    Assert.assertEquals(refunds.size(), 3);
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
