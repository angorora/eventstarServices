/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package cput.codez.angorora.test.model;

import cput.codez.angorora.eventstar.model.GuestOfHonour;
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
public class GuestOfHonourTest {
    private GuestOfHonour guest;
    private GuestOfHonour newGuest;
    public GuestOfHonourTest() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
     @Test
     public void testCreation() {
         guest= new GuestOfHonour.Builder("Dr B")
                .surname("Kabaso")
                 .guestInfo("Graduated with 10 Cum Laudes in all his 10 degrees").build();
         Assert.assertEquals(guest.getGuestName(), "Dr B");
     }
@Test
public void testUpdate(){
    newGuest = new GuestOfHonour.Builder("Dr B").copier(guest).surname("com.Kabaso").build();
         Assert.assertEquals(newGuest.getGuestSurname(), "com.Kabaso");
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
