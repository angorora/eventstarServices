/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package cput.codez.angorora.test.model;

import cput.codez.angorora.eventstar.model.Contact;
import cput.codez.angorora.eventstar.model.Supplier;
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
public class SupplierTest {
    private Supplier supplier;
    private Supplier newSupplier;
    private Contact contact;
    public SupplierTest() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
     @Test
     public void testCreation() {
          contact=new Contact.Builder("0840472266")
                  .email("allen.ngorora@gmail.com")
                  .telno("0206842")
                  .webaddress("www.KFC.com")
                  .build();
          supplier= new Supplier.Builder("KFC")
                  .supService("Food")
                  .contact(contact)
                  .build();
          Assert.assertEquals(supplier.getSuppliedService(),"Food");
     }
@Test
public void testUpdate(){
    newSupplier= new Supplier.Builder("KFC")
            .copier(supplier)
            .supService("Drinks")
            .build();
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
