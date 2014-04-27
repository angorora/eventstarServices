/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package cput.codez.angorora.test.model;

import cput.codez.angorora.eventstar.model.Address;
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
public class AddressTest {
    private Address address;
    private Address newAddress;
    public AddressTest() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
     @Test
     public void testCreation() {
         address= new Address.Builder("Mutare").streetnum("Hse No 3799 ").surbub("Chikanga 2").postal("365").country("Zimbabwe").build();
         Assert.assertEquals(address.getCity(), "Mutare", "Ndiyo city");
     }
@Test
public void testUpdate(){
    newAddress= new Address.Builder("Mutare").copier(address).country("Zambia").build();
    Assert.assertEquals(newAddress.getCountry(), "Zambia", "Ndiyo nyika");
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
