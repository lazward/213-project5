package com.leerazak.ticket;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    //TESTING
    EditText e1, e2;
    TextView t1, ticket_text;
    int num1, num2;
    Button main_ticket_button;
    public static final String EXTRA_MESSAGE = "com.example.leerazak.extra.MESSAGE";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

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
    /*public void launchTicketActivity(View view){
        Intent intent = new Intent(this, TicketActivity.class);
        String message = "hello from main!";
        intent.putExtra(EXTRA_MESSAGE, message);
        startActivity(intent);
    }*/


    public boolean getNumbers()
    {

        // defining the edit text 1 to e1
        e1 = (EditText)findViewById(R.id.main_num1);

        // defining the edit text 2 to e2
        e2 = (EditText)findViewById(R.id.main_num2);

        // defining the text view to t1
        t1 = (TextView)findViewById(R.id.main_output);

        // taking input from text box 1
        String s1 = e1.getText().toString();

        // taking input from text box 2
        String s2 = e2.getText().toString();

        // condition to check if box is not empty
        if ((s1.equals(null) && s2.equals(null))
                || (s1.equals("") && s2.equals(""))) {

            String result = "Please enter a value";
            t1.setText(result);

            return false;
        }
        else {
            // converting string to int.
            num1 = Integer.parseInt(e1.getText().toString());

            // converting string to int.
            num2 = Integer.parseInt(e2.getText().toString());
        }

        return true;
    }


    public void doSum(View v)
    {

        // get the input numbers

        if (getNumbers()) {
            int sum = num1 + num2;
            t1.setText(Integer.toString(sum));
        }
    }
}
