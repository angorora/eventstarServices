/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cput.codez.angorora.test.model;

import cput.codez.angorora.eventstar.model.Address;
import cput.codez.angorora.eventstar.model.Room;
import cput.codez.angorora.eventstar.model.Venue;
import java.util.ArrayList;
import java.util.List;
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
public class VenueTest {

    Venue venue;
    Venue newVenue;
    Address address;
    List<Room> rooms = new ArrayList<>();
    Room room;

    public VenueTest() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    @Test
    public void testCreation() {
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
    }

    @Test
    public void testUpdate() {
        newVenue = new Venue.Builder("Good hope Center").copier(venue).capacity(450).build();
        Assert.assertEquals(newVenue.getCapacity(), 450);
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
