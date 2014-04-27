/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cput.codez.angorora.test.repositories;

import cput.codez.angorora.eventstar.app.conf.ConnectionConfig;
import cput.codez.angorora.eventstar.model.Company;
import cput.codez.angorora.eventstar.model.Contact;
import cput.codez.angorora.eventstar.repository.CompanyRepository;
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
public class CompanyRepoTest {

    public static CompanyRepository repo;
    public static ApplicationContext ctx;
    private Company company;
    private Contact contact;
    public long id;

    public CompanyRepoTest() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    @Test
    public void testCreation() {
        repo = ctx.getBean(CompanyRepository.class);
        contact = new Contact.Builder("0840472266")
                .email("allen.ngorora@gmail.com")
                .telno("0800965774")
                .webaddress("info@Microsoft")
                .build();
        company = new Company.Builder("Microsoft")
                .contact(contact)
                .build();
        repo.save(company);
        id = company.getId();
        Company comp = repo.findOne(id);
        Assert.assertEquals(comp.getCompanyName(), "Microsoft", "Test::");
    }

    @Test(dependsOnMethods = "testCreation")
    public void testRead() {
        repo = ctx.getBean(CompanyRepository.class);
        Company comp = repo.findOne(id);
        Assert.assertEquals(comp.getCompanyName(), "Microsoft", "Test::");
    }

    @Test(dependsOnMethods = "testRead")
    public void testUpdate() {
        repo = ctx.getBean(CompanyRepository.class);
        Company comp = repo.findOne(id);
        Company newComp = new Company.Builder("Microsoft").copier(comp).build();
        repo.save(newComp);
        System.out.println(newComp.getCompanyName());
        newComp = repo.findOne(id);
        Assert.assertEquals(newComp.getCompanyName(), "Microsoft");
    }

    @Test(dependsOnMethods = "testUpdate")
    public void testDelete() {
        repo = ctx.getBean(CompanyRepository.class);
        repo.delete(company);
        Company deleted = repo.findOne(id);
        Assert.assertNull(deleted);
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
        ctx = new AnnotationConfigApplicationContext(ConnectionConfig.class);
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
        repo = ctx.getBean(CompanyRepository.class);
        repo.deleteAll();
    }

    @BeforeMethod
    public void setUpMethod() throws Exception {
    }

    @AfterMethod
    public void tearDownMethod() throws Exception {
    }
}
