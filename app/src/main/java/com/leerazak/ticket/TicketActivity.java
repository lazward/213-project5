package com.leerazak.ticket;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
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

    //Final arrays represent costs per museum, first index is the students, second is adult, third is senior.
    final int[] metPrices = {12, 25, 17};
    final int[] momaPrices = {14, 25, 18};
    final int[] amnhPrices = {18, 23, 18};
    final int[] mcnyPrices = {14, 20, 14};

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_ticket);

            //Generate an intent, and check from where we got the input from
            Intent intent = getIntent();
            int temp = intent.getIntExtra(MainActivity.EXTRA_MESSAGE, 5);

            //TextView textView = findViewById(R.id.ticket_text) ;
            //textView.setText(String.valueOf(temp)) ;
            ImageView picture = findViewById(R.id.ticket_picture) ;

            TextView nameText = findViewById(R.id.museumName) ;
            TextView stuText = findViewById(R.id.studentText);
            TextView aduText = findViewById(R.id.adultText);
            TextView senText = findViewById(R.id.seniorText);


            String url ;

            switch (temp) {

                case 1:
                    picture.setImageResource(R.drawable.met) ;
                    nameText.setText(R.string.met) ;
                    url = getResources().getString(R.string.metURL) ;
                    //Update Text Fields
                    stuText.append( " $" +  Integer.toString(metPrices[0]));
                    aduText.append( " $" + Integer.toString(metPrices[1]));
                    senText.append( " $" + Integer.toString(metPrices[2]));


                    break ;
                case 2:
                    picture.setImageResource(R.drawable.moma) ;
                    nameText.setText(R.string.moma) ;
                    url = getResources().getString(R.string.momaURL) ;

                    //Update Text Fields
                    stuText.append( " $" +  Integer.toString(momaPrices[0]));
                    aduText.append( " $" + Integer.toString(momaPrices[1]));
                    senText.append( " $" + Integer.toString(momaPrices[2]));


                    break ;
                case 3:
                    picture.setImageResource(R.drawable.amnh) ;
                    nameText.setText(R.string.amnh) ;
                    url = getResources().getString(R.string.amnhURL) ;

                    stuText.append( " $" +  Integer.toString(amnhPrices[0]));
                    aduText.append( " $" + Integer.toString(amnhPrices[1]));
                    senText.append( " $" + Integer.toString(amnhPrices[2]));

                    break ;
                case 4:
                    picture.setImageResource(R.drawable.mcny) ;
                    nameText.setText(R.string.mcny) ;
                    url = getResources().getString(R.string.mcnyURL) ;

                    stuText.append( " $" +  Integer.toString(mcnyPrices[0]));
                    aduText.append( " $" + Integer.toString(mcnyPrices[1]));
                    senText.append( " $" + Integer.toString(mcnyPrices[2]));

                    break ;
                default: // This shouldn't ever run
                    throw new IllegalStateException("Unexpected value: " + temp);

            }

            final String finalUrl = url;
            picture.setOnClickListener(new View.OnClickListener() {

                public void onClick(View v) {
                    Intent intent = new Intent();
                    intent.setAction(Intent.ACTION_VIEW);
                    intent.addCategory(Intent.CATEGORY_BROWSABLE);
                    intent.setData(Uri.parse(finalUrl));
                    startActivity(intent);
                }
            });

            //Select spinner options

            Spinner C_spinner = (Spinner) findViewById(R.id.studentSpinner);
// Create an ArrayAdapter using the string array and a default spinner layout
            ArrayAdapter<String> C_adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, getResources().getStringArray(R.array.number_array));
// Specify the layout to use when the list of choices appears
            C_adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
// Apply the adapter to the spinner
            C_spinner.setAdapter(C_adapter);

            Spinner P_spinner = (Spinner) findViewById(R.id.adultSpinner);
// Create an ArrayAdapter using the string array and a default spinner layout
            ArrayAdapter<String> P_adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, getResources().getStringArray(R.array.number_array));
// Specify the layout to use when the list of choices appears
            P_adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
// Apply the adapter to the spinner
           P_spinner.setAdapter(P_adapter);

            Spinner S_spinner = (Spinner) findViewById(R.id.seniorSpinner);
// Create an ArrayAdapter using the string array and a default spinner layout
            ArrayAdapter<String> S_adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, getResources().getStringArray(R.array.number_array));
// Specify the layout to use when the list of choices appears
            S_adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
// Apply the adapter to the spinner
            S_spinner.setAdapter(S_adapter);





            /*

            if(temp == 5){
                //testing where we got the button from
                TextView textView = findViewById(R.id.ticket_text);
                textView.setText(String.valueOf(temp));
            }else if(temp == 1){
                TextView textView = findViewById(R.id.ticket_text);
                textView.setText(String.valueOf(temp));
                ImageView picture = findViewById(R.id.ticket_picture);
                picture.setImageResource(R.drawable.pogchamp);
                TextView nameText = findViewById(R.id.museumName) ;
                nameText.setText(R.string.met) ;
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
                TextView nameText = findViewById(R.id.museumName) ;
                nameText.setText(R.string.moma) ;
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
                TextView nameText = findViewById(R.id.museumName) ;
                nameText.setText(R.string.amnh) ;
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
                TextView nameText = findViewById(R.id.museumName) ;
                nameText.setText(R.string.mcny) ;
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

            */


    //Toast testing
            Toast toast = Toast.makeText(getApplicationContext(), R.string.toast, Toast.LENGTH_SHORT) ;
            toast.show() ;

        }

        //dummy stuff to test input and output stuff
    /*
    public boolean getNumbers()
    {

        // defining the edit text 1 to e1
        e1 = (EditText)findViewById(R.id.studentTixNum);

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
    }*/
}
