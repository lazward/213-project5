package com.leerazak.ticket;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;


public class TicketActivity extends AppCompatActivity{
    TextView ticket_text;


        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_ticket);
            Intent intent = getIntent();
            String temp = intent.getStringExtra(MainActivity.EXTRA_MESSAGE);
            TextView textView = findViewById(R.id.ticket_text);
            textView.setText(temp);
        }
}
