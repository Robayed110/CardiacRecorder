package com.example.cardiacrecorder;
import org.junit.Test;

import static org.junit.Assert.*;

import com.example.cardiacrecorder.Domain.ListDomain;

public class UnitTest {

    ListDomain listDomain=new ListDomain("125","89","2023-07-06","10.53.22","102");
    ListDomain listDomain1=new ListDomain("135","99","2023-07-05","11.53.22","112");

    @Test
    public void testSystolic_pressure(){
        assertEquals("125",listDomain.getSystolic_pressure());
    }

    @Test
    public void testDiastolic_pressure(){
        assertEquals("89",listDomain.getDiastolic_pressure());
    }


    @Test
    public void testDate(){
        assertEquals("2023-07-06",listDomain.getDate());
    }

    @Test
    public void testTime(){
        assertEquals("10.53.22",listDomain.getTime());
    }

    @Test
    public void testKey(){
        assertEquals("102",listDomain.getKey());
    }



    /**
     * testing addData method
     */
    @Test
    public void testAddData() {
        Newclass dataList = new Newclass();

        dataList.addData(listDomain);
        assertEquals(1, dataList.getData().size());

        dataList.addData(listDomain1);
        assertEquals(2, dataList.getData().size());

        assertTrue(dataList.getData().contains(listDomain));
        assertTrue(dataList.getData().contains(listDomain1));
    }

    /**
     * testing deleteData method
     */
    @Test
    public void testDeleteData() {
        Newclass dataList = new Newclass();

        dataList.addData(listDomain);
        assertEquals(1, dataList.getData().size());


        dataList.addData(listDomain1);
        assertEquals(2, dataList.getData().size());

        assertTrue(dataList.getData().contains(listDomain));
        assertTrue(dataList.getData().contains(listDomain1));

        dataList.deleteData(listDomain);
        assertEquals(1, dataList.getData().size());
        assertFalse(dataList.getData().contains(listDomain));

        dataList.deleteData(listDomain1);
        assertEquals(0, dataList.getData().size());
        assertFalse(dataList.getData().contains(listDomain1));
    }

    /**
     * testing addData method for exceptions
     */
    @Test
    public void testAddRecordException() {

        Newclass dataList = new Newclass();
        dataList.addData(listDomain);

        assertThrows(IllegalArgumentException.class, () -> dataList.addData(listDomain));
    }

    /**
     * testing deleteData method for exceptions
     */
    @Test
    public void testDeleteRecordException() {


        Newclass dataList = new Newclass();

        dataList.addData(listDomain);

        dataList.deleteData(listDomain);

        assertThrows(IllegalArgumentException.class, () -> dataList.deleteData(listDomain));
    }

}
