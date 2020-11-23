package com.leerazak.ticket;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

/**
 *
 * @author Aarif Razak ahr58, Julian Lee jl2203
 *
 */

public class MainActivity extends AppCompatActivity {

    TextView box1, box2, box3, box4;
    //TESTING

    Button main_ticket_button;
    //this extra_message allows communication between both activities
    public static final String EXTRA_MESSAGE = "com.example.leerazak.extra.MESSAGE";


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //important stuff ^^

        //Based on the first museum selection
        box1 = (TextView) findViewById(R.id.main_loc_1);
        box1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                locationOne();
            }
        });
        //Every other selection
        box2 = (TextView) findViewById(R.id.main_loc_2);
        box2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                locationTwo();
            }
        });
        box3 = (TextView) findViewById(R.id.main_loc_3);
        box3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                locationThree();
            }
        });
        box4 = (TextView) findViewById(R.id.main_loc_4);
        box4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                locationFour();
            }
        });
        //Testing communication
        main_ticket_button = (Button) findViewById(R.id.main_ticket_button);
        main_ticket_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                launchTicketActivity();
            }
        });
    }

    //TESTING


    public void launchTicketActivity(){
        //test
        Intent intent = new Intent(this, TicketActivity.class);
        int message = 5;
        intent.putExtra(EXTRA_MESSAGE, message);
        startActivity(intent);

    }
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
    /*public void launchTicketActivity(View view){
        Intent intent = new Intent(this, TicketActivity.class);
        String message = "hello from main!";
        intent.putExtra(EXTRA_MESSAGE, message);
        startActivity(intent);
    }*/



}
