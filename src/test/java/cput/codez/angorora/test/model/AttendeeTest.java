/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package cput.codez.angorora.test.model;
import cput.codez.angorora.eventstar.model.Attendee;
import cput.codez.angorora.eventstar.model.Contact;
import cput.codez.angorora.eventstar.model.Payment;
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
public class AttendeeTest {
    private Attendee att;
    private Contact contact;
    private Attendee newAttendee;
    public AttendeeTest() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
     @Test
    public void testCreation() {
        contact=new Contact.Builder("0840472266")
                .email("allen.ngorora@gmail.com")
                .telno(null)
                .webaddress(null)
                .build();
        att=new Attendee.Builder(contact)
                .age(19)
                .company(null)
                .diet("Vegaterian")
                .firstName("Allen")
                .lastName("Ngorora")
                .gender("M")
                .build();
        Assert.assertEquals(att.getAge(),19,"         ");
    }
@Test
public void testUpdate(){
    newAttendee=new Attendee.Builder(contact)
            .copier(att)
            .age(10)
            .build();
    Assert.assertEquals(newAttendee.getAge(), 10);
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

    private static class Builder {

        public Builder(String string) {
        }
    }
}
