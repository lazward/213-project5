package com.leerazak.ticket;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.lang.reflect.Array;
import java.util.ArrayList;

/**
 *
 * @author Aarif Razak ahr58, Julian Lee jl2203
 *
 */

public class MainActivity extends AppCompatActivity {

    TextView box1, box2, box3, box4;
    //TESTING
    ListView museumList;

    Button main_ticket_button;
    //this extra_message allows communication between both activities
    public static final String EXTRA_MESSAGE = "com.example.leerazak.extra.MESSAGE";


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //important stuff ^^




        //ListView
        museumList = (ListView) findViewById(R.id.annoyingList);

        ArrayList<String> entries = new ArrayList<String>();

        entries.add(getResources().getString(R.string.met));
        entries.add(getResources().getString(R.string.moma));
        entries.add(getResources().getString(R.string.amnh));
        entries.add(getResources().getString(R.string.mcny));


        ArrayAdapter listAdapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, entries);

        museumList.setAdapter(listAdapter);

        museumList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                switch (i){
                    case 0:
                        locationOne();
                        break;
                    case 1:
                        locationTwo();
                        break;
                    case 2:
                        locationThree();
                        break;
                    case 3:
                        locationFour();
                        break;
                    default:
                        Toast toast = Toast.makeText(getApplicationContext(), R.string.error, Toast.LENGTH_SHORT) ;
                        toast.show() ;
                }
            }
        });



    }

    //TESTING



    public void locationOne(){
        Intent intent = new Intent(this, TicketActivity.class);
        int message = 1;
        intent.putExtra(EXTRA_MESSAGE, message);
        startActivity(intent);


    }
    public void locationTwo(){
        Intent intent = new Intent(this, TicketActivity.class);
        int message = 2;
        intent.putExtra(EXTRA_MESSAGE, message);
        startActivity(intent);


    }
    public void locationThree(){
        Intent intent = new Intent(this, TicketActivity.class);
        int message = 3;
        intent.putExtra(EXTRA_MESSAGE, message);
        startActivity(intent);
    }
    public void locationFour(){
        Intent intent = new Intent(this, TicketActivity.class);
        int message = 4;
        intent.putExtra(EXTRA_MESSAGE, message);
        startActivity(intent);


    }


}
