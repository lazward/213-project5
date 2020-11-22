package com.leerazak.ticket;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView box1;
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
        Intent intent = new Intent(this, TicketActivity.class);
        String message = "hello from main!";
        intent.putExtra(EXTRA_MESSAGE, message);
        startActivity(intent);

    }
    public void locationOne(){
        Intent intent = new Intent(this, TicketActivity.class);
        String message = "LOCATION1 TEST";
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
