/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package cput.codez.angorora.test.model;

import cput.codez.angorora.eventstar.model.Contact;
import cput.codez.angorora.eventstar.model.Host;
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
public class HostTest {
    private Host host;
    private Host newHost;
    private Contact contact;
    public HostTest() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //20
     @Test
     public void hello() {
          contact=new Contact.Builder("0840472266")
                .email("allen.ngorora@gmail.com")
                .telno("0800965774")
                .webaddress("info@Microsoft")
                .build();
         host=new Host.Builder("Microsoft")
                 .contact(contact)
                 .build();
         Assert.assertEquals(host.getHostName(), "Microsoft");
     }
@Test
public void testUpdate(){
    newHost=new Host.Builder("Microsoft").copier(host).build();
    Assert.assertEquals(newHost.getHostName(), "Microsoft");
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
