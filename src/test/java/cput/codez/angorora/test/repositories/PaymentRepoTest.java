/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cput.codez.angorora.test.repositories;

import cput.codez.angorora.eventstar.app.conf.ConnectionConfig;
import cput.codez.angorora.eventstar.model.Payment;
import cput.codez.angorora.eventstar.repository.PaymentRepository;
import cput.codez.angorora.eventstar.repository.UserRepository;
import static cput.codez.angorora.test.repositories.UserRepo.repo;
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
public class PaymentRepoTest {

    public static ApplicationContext ctx;
    public static PaymentRepository repo;
    Payment payment;
    long id;

    public PaymentRepoTest() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    @Test
    public void testCreation() {
        repo = ctx.getBean(PaymentRepository.class);
        payment = new Payment.Builder(270).build();
        repo.save(payment);
        id = payment.getId();
        Payment pay = repo.findOne(id);
        Assert.assertEquals(pay.getAmount(), 270, 0.01);
    }

    @Test(dependsOnMethods = "testCreation")
    public void testRead() {
        repo = ctx.getBean(PaymentRepository.class);
        Payment pay = repo.findOne(id);
        Assert.assertEquals(pay.getAmount(), 270, 0.01);
    }

    @Test(dependsOnMethods = "testRead")
    public void testUpdate() {
        repo = ctx.getBean(PaymentRepository.class);
        Payment oldpayment = repo.findOne(id);
        Payment newPayment = new Payment.Builder(1)
                .copier(payment)
                .build();
        repo.save(newPayment);
        Payment payment1 = repo.findOne(id);
        Assert.assertEquals(payment1.getAmount(), 270, 0.01);
    }

    @Test(dependsOnMethods = "testUpdate")
    public void testDelete() {
        repo = ctx.getBean(PaymentRepository.class);
        repo.delete(id);
        Payment pay = repo.findOne(id);
        Assert.assertNull(pay);
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
        ctx = new AnnotationConfigApplicationContext(ConnectionConfig.class);
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
        repo = ctx.getBean(PaymentRepository.class);
        repo.deleteAll();
    }

    @BeforeMethod
    public void setUpMethod() throws Exception {
    }

    @AfterMethod
    public void tearDownMethod() throws Exception {
    }
}
