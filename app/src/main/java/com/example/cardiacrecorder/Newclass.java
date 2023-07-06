package com.example.cardiacrecorder;

import com.example.cardiacrecorder.Domain.ListDomain;
import com.google.firebase.auth.FirebaseUserMetadata;

import java.util.ArrayList;
import java.util.List;

public class Newclass {
    public List<ListDomain> records = new ArrayList<>();
    /**
     * this method is used to add any new data
     * if data already exists,it will throw an exception
     * @param data a new record
     */
    public void addData(ListDomain data)
    {
        if(records.contains(data))
        {
            throw new IllegalArgumentException();
        }
        records.add(data);
    }
    /**
     * this method returns an instance of sorted record list
     * sort is based on first attribute by default
     * @return a list of data
     */

    public List<ListDomain> getData()
    {
        List<ListDomain>dataList = records;
        return dataList;
    }

    public List<ListDomain> getData(int x)
    {
        List<ListDomain> dataList = records;
        return dataList;
    }


    /**
     * this method for update of list
     */

    public void updateData(ListDomain updatedData,ListDomain existdata) {
        // Check if the updated data exists in the records list
        if (records.contains(existdata)) {
            // Get the index of the updated data
            int index = records.indexOf(existdata);
            // Replace the old data with the updated data at the same index
            records.set(index, updatedData);
        } else {
            // Throw an exception if the updated data is not found in the records list
            throw new IllegalArgumentException("Data not found");
        }
    }

    /**
     * this method is used for deleting a particular data
     * if the data doesnt exist,it will throw an exception
     * @param data a data that need to be deleted
     */
    public void deleteData(ListDomain data)
    {

        if(records.contains(data)){
            records.remove(data);
        }
        else
        {
            throw new IllegalArgumentException();
        }
    }

    /**
     * this method returns the size of list
     * @return int
     */
    public int countData()
    {
        return records.size();
    }
}
