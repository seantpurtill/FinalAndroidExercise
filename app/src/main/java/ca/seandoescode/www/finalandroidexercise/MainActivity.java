package ca.seandoescode.www.finalandroidexercise;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {


    ListView lvAgents;
    AgentDataSource source;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        source = new AgentDataSource(this);
//
//        lvAgents = findViewById(R.id.lvAgents);
//        ArrayList list = source.getAllAgents();
//        ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, list);
//        lvAgents.setAdapter(adapter);

    }
}
