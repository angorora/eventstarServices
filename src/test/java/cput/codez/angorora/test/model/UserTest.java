/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package cput.codez.angorora.test.model;
import cput.codez.angorora.eventstar.model.User;
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
public class UserTest {
    private User user;
    private User newuser;
    public UserTest() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
     @Test
     public void hello() {
            user= new User.Builder("Allen").user("34341991").userId(212199587).build();
            Assert.assertEquals(user.getUsername(), "Allen");
     }
     @Test
     public void testUpdate(){
           newuser= new User.Builder("Allen").copier(user).user("34321991").build();
           Assert.assertEquals(newuser.getPassword(), "34321991");
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
