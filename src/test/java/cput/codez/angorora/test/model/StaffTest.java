/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cput.codez.angorora.test.model;

import cput.codez.angorora.eventstar.model.Contact;
import cput.codez.angorora.eventstar.model.Staff;
import org.testng.Assert;
import static org.testng.Assert.*;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 *
 * @author marc
 */
public class StaffTest {

    Staff staff;
    Staff newStaff;
    Contact contact;

    public StaffTest() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    @Test
    public void testCreation() {
        contact = new Contact.Builder("0840472266")
                .email("allen.ngorora@gmail.com")
                .telno(null)
                .webaddress(null)
                .build();
        staff = new Staff.Builder("Allen")
              //  .eventId(10)
                .surname("Ngcxumza")
                .contact(contact)
                .build();
        Assert.assertEquals(staff.getStaffSurname(), "Ngcxumza");
    }

    @Test(dependsOnMethods="testCreation")
    public void testUpdate() {
        newStaff = new Staff.Builder("Allen")
                .copier(staff)
                .surname("Ngorora")
                .build();
        Assert.assertEquals(newStaff.getStaffSurname(), "Ngorora");
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
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
