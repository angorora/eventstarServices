/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package cput.codez.angorora.test.repositories;

import cput.codez.angorora.eventstar.app.conf.ConnectionConfig;
import cput.codez.angorora.eventstar.model.Refund;
import cput.codez.angorora.eventstar.repository.RefundRepository;
import java.util.Calendar;
import java.util.GregorianCalendar;
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
public class RefundRepoTest {
    private static RefundRepository repo;
    private static ApplicationContext ctx;
    Refund refund;
    private long id;
    Calendar calendar = new GregorianCalendar();
    public RefundRepoTest() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
     @Test
     public void testCreation() {
         repo=ctx.getBean(RefundRepository.class);
         calendar.set(2014, 02, 23);
         refund=new Refund.Builder(2)
                 .accountNumber("4513407890")
                 .amount(200).bankName("ABSA")
                 .branchCode("ZAJJ")
                 .dateOfRefund(calendar)
                 .build();
         repo.save(refund);
         id=refund.getId();
         Refund ref=repo.findOne(id);
         
         Assert.assertEquals(ref.getAmount(),200.0);
     }
@Test(dependsOnMethods="testCreation")
public void readTest(){
     repo=ctx.getBean(RefundRepository.class);
      Refund refund=repo.findOne(id);
      Assert.assertEquals(refund.getBankName(),"ABSA");
}
@Test(dependsOnMethods="readTest")
public void testUpdate(){
       repo=ctx.getBean(RefundRepository.class);
        Refund refund=repo.findOne(id);
        Refund newRefund=new Refund.Builder(1)
                .copier(refund)
                .branchCode("SANBEL")
                .build();
       repo.save(newRefund);
       newRefund =repo.findOne(id);
       Assert.assertEquals(newRefund.getBranchCode(), "SANBEL");
}
@Test(dependsOnMethods="testUpdate")
public void testDelete(){
       repo=ctx.getBean(RefundRepository.class);
       Refund newRefund =repo.findOne(id);
      repo.delete(newRefund);
       newRefund=repo.findOne(id);
       Assert.assertNull(newRefund);
}
    @BeforeClass
    public static void setUpClass() throws Exception {
        ctx = new AnnotationConfigApplicationContext(ConnectionConfig.class);
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
          repo=ctx.getBean(RefundRepository.class);
          repo.deleteAll();
    }

    @BeforeMethod
    public void setUpMethod() throws Exception {
    }

    @AfterMethod
    public void tearDownMethod() throws Exception {
    }
}
