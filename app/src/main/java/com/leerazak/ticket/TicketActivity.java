package com.leerazak.ticket;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

/**
 *
 * @author Aarif Razak ahr58, Julian Lee jl2203
 *
 */

public class TicketActivity extends AppCompatActivity{
    TextView ticket_text;
    EditText e1, e2;
    TextView t1;
    ImageView photo;
    int num1, num2;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_ticket);

            //Generate an intent, and check from where we got the input from
            Intent intent = getIntent();
            int temp = intent.getIntExtra(MainActivity.EXTRA_MESSAGE, 5);

            if(temp == 5){
                //testing where we got the button from
                TextView textView = findViewById(R.id.ticket_text);
                textView.setText(String.valueOf(temp));
            }else if(temp == 1){
                TextView textView = findViewById(R.id.ticket_text);
                textView.setText(String.valueOf(temp));
                ImageView picture = findViewById(R.id.ticket_picture);
                picture.setImageResource(R.drawable.pogchamp);
                //set link for the user to click
                picture.setOnClickListener(new View.OnClickListener() {

                    public void onClick(View v) {
                        Intent intent = new Intent();
                        intent.setAction(Intent.ACTION_VIEW);
                        intent.addCategory(Intent.CATEGORY_BROWSABLE);
                        intent.setData(Uri.parse("https://www.metmuseum.org/"));
                        startActivity(intent);
                    }
                });

            }else if (temp == 2){
                TextView textView = findViewById(R.id.ticket_text);
                textView.setText(String.valueOf(temp));
                ImageView picture = findViewById(R.id.ticket_picture);
                picture.setImageResource(R.drawable.tired);
                //set link for the user to click
                picture.setOnClickListener(new View.OnClickListener() {

                    public void onClick(View v) {
                        Intent intent = new Intent();
                        intent.setAction(Intent.ACTION_VIEW);
                        intent.addCategory(Intent.CATEGORY_BROWSABLE);
                        intent.setData(Uri.parse("https://www.moma.org"));
                        startActivity(intent);
                    }
                });


            }else if (temp == 3){
                TextView textView = findViewById(R.id.ticket_text);
                textView.setText(String.valueOf(temp));
                ImageView picture = findViewById(R.id.ticket_picture);
                picture.setImageResource(R.drawable.cayde);
                //set link for the user to click
                picture.setOnClickListener(new View.OnClickListener() {

                    public void onClick(View v) {
                        Intent intent = new Intent();
                        intent.setAction(Intent.ACTION_VIEW);
                        intent.addCategory(Intent.CATEGORY_BROWSABLE);
                        intent.setData(Uri.parse("https://www.amnh.org"));
                        startActivity(intent);
                    }
                });

            }else if (temp == 4){
                TextView textView = findViewById(R.id.ticket_text);
                textView.setText(String.valueOf(temp));
                ImageView picture = findViewById(R.id.ticket_picture);
                picture.setImageResource(R.drawable.actually_crying);
                //set link for the user to click
                picture.setOnClickListener(new View.OnClickListener() {

                    public void onClick(View v) {
                        Intent intent = new Intent();
                        intent.setAction(Intent.ACTION_VIEW);
                        intent.addCategory(Intent.CATEGORY_BROWSABLE);
                        intent.setData(Uri.parse("https://www.mcny.org"));
                        startActivity(intent);
                    }
                });

            }


            Toast toast = Toast.makeText(getApplicationContext(), R.string.toast, Toast.LENGTH_SHORT) ;
            toast.show() ;

        }

        //dummy stuff to test input and output stuff
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
