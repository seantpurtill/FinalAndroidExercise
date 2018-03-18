package ca.seandoescode.www.finalandroidexercise;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.io.IOException;
import java.util.ArrayList;

public class AgentDataSource {
    SQLiteDatabase db;
    DBHelper helper;

    public AgentDataSource(Context context) {
        helper = new DBHelper(context);
        try {
            helper.createDataBase();
        } catch (IOException e) {
            e.printStackTrace();
        }
        db = helper.getWritableDatabase();
    }

    public Agent getAgent(int AgentId)
    {
        String [] args = { AgentId + "" };
        Cursor cursor = db.rawQuery("select * from Agents where AgentId=?", args);
        cursor.moveToNext();
        Agent c = new Agent(cursor.getInt(0), cursor.getString(1), cursor.getString(2), cursor.getString(3), cursor.getString(4),
                cursor.getString(5), cursor.getString(6), cursor.getInt(11));
        cursor.close();
        return c;
    }

    public ArrayList<Agent> getAllAgents()
    {
        ArrayList<Agent> list = new ArrayList<>();
        Cursor cursor = db.rawQuery("select * from Agents", null);
        while (cursor.moveToNext()) {
            list.add(new Agent(cursor.getInt(0), cursor.getString(1), cursor.getString(2), cursor.getString(3), cursor.getString(4),
                    cursor.getString(5), cursor.getString(6), cursor.getInt(11)));
        }
        cursor.close();
        return list;
    }

    public void insert(Agent a)
    {
        ContentValues values = new ContentValues();
        values.put("AgentID", a.getAgentID());
        values.put("AgtFirstName", a.getAgtFirstName());
        values.put("AgtMiddleInitial", a.getAgtMiddleInitial());
        values.put("AgtLastName", a.getAgtLastName());
        values.put("AgtBusPhone", a.getAgtBusPhone());
        values.put("AgtEmail", a.getAgtEmail());
        values.put("AgtPosition", a.getAgtPosition());
        values.put("AgencyID", a.getAgencyID());

        db.insert("Agents", null, values);
    }


    public void update(Agent c)
    {

    }

    public void delete(int AgentId)
    {

    }
}

