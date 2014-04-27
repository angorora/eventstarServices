/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package cput.codez.angorora.test.model;

import cput.codez.angorora.eventstar.model.Statistics;
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
public class StatisticsTest {
    private Statistics statistics;
    private Statistics newStatistics;
    public StatisticsTest() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
     @Test
     public void testCreation() {
         statistics=new Statistics.Builder(20)
                 .attendees(500)
                 .males(100)
                 .females(400)
                 .build();
         Assert.assertEquals(statistics.getFemaleAttendees(), 400);
     }
@Test
public void testUpdate(){
    newStatistics= new Statistics.Builder(20).copier(statistics).males(200).build();
    Assert.assertEquals(newStatistics.getMaleAttendees(), 200);
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
