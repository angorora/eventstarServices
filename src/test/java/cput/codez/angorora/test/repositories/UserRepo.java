/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cput.codez.angorora.test.repositories;

import cput.codez.angorora.eventstar.app.conf.ConnectionConfig;
import cput.codez.angorora.eventstar.model.User;
import cput.codez.angorora.eventstar.repository.UserRepository;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
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
public class UserRepo {

    public static ApplicationContext ctx;
    private Long id;
    User user;
    User newUser;
    static  UserRepository repo;

    public UserRepo() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    @Test
    public void createUser() {
        repo = ctx.getBean(UserRepository.class);
        user = new User.Builder("Allen")
                .userpass("34341991")
                .build();
        Assert.assertEquals(user.getUsername(), "Allen");
        repo.save(user);
        id = user.getId();
        Assert.assertNotNull(user);
    }

    @Test(dependsOnMethods = "createUser")
    public void readTest() {
        repo = ctx.getBean(UserRepository.class);
        user = repo.findOne(id);
        Assert.assertEquals(user.getUsername(), "Allen");
    }

    @Test(dependsOnMethods = "readTest")
    public void updateTest() {
        repo = ctx.getBean(UserRepository.class);
        User user = repo.findOne(id);
        newUser = new User.Builder("Allen")
                .copier(user)
                .userpass("34301991")
                .build();
        repo.save(newUser);
        newUser = repo.findOne(id);
        Assert.assertEquals(newUser.getPassword(), "34301991");

    }

    @Test(dependsOnMethods = "updateTest")
    public void deleteUser() {
         repo = ctx.getBean(UserRepository.class);
         repo.delete(id);
         User deletedUser = repo.findOne(id);
         Assert.assertNull(deletedUser);
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
        ctx = new AnnotationConfigApplicationContext(ConnectionConfig.class);
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
        repo = ctx.getBean(UserRepository.class);
        repo.deleteAll();
    }

    @BeforeMethod
    public void setUpMethod() throws Exception {
    }

    @AfterMethod
    public void tearDownMethod() throws Exception {
       
    }
}
