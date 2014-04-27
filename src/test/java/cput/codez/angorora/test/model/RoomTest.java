/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cput.codez.angorora.test.model;

import cput.codez.angorora.eventstar.model.Room;
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
public class RoomTest {

    Room room;
    Room newRoom;

    public RoomTest() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    @Test
    public void testCreation() {
        room = new Room.Builder(123).roomName("Dromedaris").build();
        Assert.assertEquals(room.getCapacity(), 123);
    }

    @Test
    public void testUpdate() {
        newRoom = new Room.Builder(123).copier(room).roomName("MPH").build();
        Assert.assertEquals(newRoom.getRoomName(), "MPH");
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
