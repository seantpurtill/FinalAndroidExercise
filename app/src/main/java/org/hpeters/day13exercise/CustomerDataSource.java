package org.hpeters.day13exercise;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.io.IOException;
import java.util.ArrayList;


public class CustomerDataSource {
    SQLiteDatabase db;
    DBHelper helper;

    public CustomerDataSource(Context context) {
        helper = new DBHelper(context);
        try {
            helper.createDataBase();
        } catch (IOException e) {
            e.printStackTrace();
        }
        db = helper.getWritableDatabase();
    }

    public Customer getCustomer(int customerId)
    {
        String [] args = { customerId + "" };
        Cursor cursor = db.rawQuery("select * from Customers where CustomerId=?", args);
        cursor.moveToNext();
        Customer c = new Customer(cursor.getInt(0), cursor.getString(1), cursor.getString(2), cursor.getString(3), cursor.getString(4), cursor.getString(5), cursor.getString(6), cursor.getString(7), cursor.getString(8), cursor.getString(9), cursor.getString(10), cursor.getInt(11));
        cursor.close();
        return c;
    }

    public ArrayList<Customer> getAllCustomers()
    {
        ArrayList<Customer> list = new ArrayList<>();
        Cursor cursor = db.rawQuery("select * from Customers", null);
        while (cursor.moveToNext()) {
            list.add(new Customer(cursor.getInt(0), cursor.getString(1), cursor.getString(2), cursor.getString(3), cursor.getString(4), cursor.getString(5), cursor.getString(6), cursor.getString(7), cursor.getString(8), cursor.getString(9), cursor.getString(10), cursor.getInt(11)));
        }
        cursor.close();
        return list;
    }

    public void insert(Customer c)
    {
        ContentValues values = new ContentValues();
        values.put("CustFirstName", c.getCustFirstName());
        values.put("CustLastName", c.getCustLastName());
        values.put("CustAddress", c.getCustAddress());
        values.put("CustCity", c.getCustCity());
        values.put("CustProv", c.getCustProv());
        values.put("CustPostal", c.getCustPostal());
        values.put("CustCountry", c.getCustCountry());
        values.put("CustHomePhone", c.getCustHomePhone());
        values.put("CustBusPhone", c.getCustBusPhone());
        values.put("CustEmail", c.getCustEmail());
        values.put("AgentId", c.getAgentId());
        db.insert("Customers", null, values);
    }

    public void update(Customer c)
    {

    }

    public void delete(int customerId)
    {

    }
}
