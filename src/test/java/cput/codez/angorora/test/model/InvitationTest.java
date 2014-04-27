/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cput.codez.angorora.test.model;

import cput.codez.angorora.eventstar.model.Invitation;
import java.util.Calendar;
import java.util.GregorianCalendar;
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
public class InvitationTest {

    private Invitation invitation;
    private Invitation newInvitation;
    private Calendar calendar = new GregorianCalendar();

    public InvitationTest() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    @Test
    public void testCreation() {
        calendar.set(2014, 06, 20, 13, 30);
        invitation = new Invitation.Builder("You are invited to attend the Launch of the new Toyota Corolla")
                .issueDate(calendar)
                .build();
        Assert.assertEquals(invitation.getInvitation(), "You are invited to attend the Launch of the new Toyota Corolla");
    }

    @Test
    public void testUpdate() {
        newInvitation = new Invitation.Builder("You are invited to attend the Launch of the new BMW").issueDate(calendar).build();
        Assert.assertEquals(newInvitation.getInvitation(), "You are invited to attend the Launch of the new BMW");
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
