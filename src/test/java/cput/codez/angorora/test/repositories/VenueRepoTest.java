/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cput.codez.angorora.test.repositories;

import cput.codez.angorora.eventstar.app.conf.ConnectionConfig;
import cput.codez.angorora.eventstar.model.Address;
import cput.codez.angorora.eventstar.model.Room;
import cput.codez.angorora.eventstar.model.Venue;
import cput.codez.angorora.eventstar.repository.VenueRepository;
import java.util.ArrayList;
import java.util.List;
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
public class VenueRepoTest {

    public static VenueRepository repo;
    public static ApplicationContext ctx;
    private Venue venue;
    private Room room;
    Address address;
    List<Room> rooms = new ArrayList<>();
    private long id;

    public VenueRepoTest() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    @Test
    public void testCreation() {
        repo = ctx.getBean(VenueRepository.class);
        address = new Address.Builder("Mutare")
                .streetnum("Hse No 3799 ")
                .surbub("Chikanga 2")
                .postal("365")
                .country("Zimbabwe")
                .build();
        room = new Room.Builder(123)
                .roomName("Dromedaris")
                .build();
        rooms.add(room);
        venue = new Venue.Builder("Good Hope Center")
                .address(address)
                .capacity(500).
                room(rooms)
                .build();
        repo.save(venue);
        id = venue.getId();
        Venue ven = repo.findOne(id);
        Assert.assertEquals(ven.getVenueName(), "Good Hope Center");
    }

    @Test(dependsOnMethods = "testCreation")
    public void testRead() {
        repo = ctx.getBean(VenueRepository.class);
        Venue ven = repo.findOne(id);
        Assert.assertEquals(ven.getVenueName(), "Good Hope Center");
    }

    @Test(dependsOnMethods = "testRead")
    public void testUpdate() {
        repo = ctx.getBean(VenueRepository.class);
        Venue ven = repo.findOne(id);
        Venue newVen = new Venue.Builder("Good Hope Center").copier(ven).capacity(5000).build();
        repo.save(newVen);
        id = newVen.getId();
        ven = repo.findOne(id);
        Assert.assertEquals(ven.getCapacity(), 5000);
    }

    @Test(dependsOnMethods = "testUpdate")
    public void testDelete() {
        repo = ctx.getBean(VenueRepository.class);
        Venue ven = repo.findOne(id);
        repo.delete(ven);
        Venue deletedVen = repo.findOne(id);
        Assert.assertNull(deletedVen);
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
        ctx = new AnnotationConfigApplicationContext(ConnectionConfig.class);
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
        repo = ctx.getBean(VenueRepository.class);
        repo.deleteAll();
    }

    @BeforeMethod
    public void setUpMethod() throws Exception {
    }

    @AfterMethod
    public void tearDownMethod() throws Exception {
    }
}
