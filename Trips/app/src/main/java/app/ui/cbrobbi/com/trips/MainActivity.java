package app.ui.cbrobbi.com.trips;


import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;

import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.RadioGroup.OnCheckedChangeListener;
import android.widget.RadioGroup;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {
    TextView travelBuddy;
    Button test1,test2;
    RadioButton button1, button2;
    RadioGroup with_without_air_radioGroup;
    ArrayAdapter<CharSequence> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        // switching between with air fragment and without air fragment
        RadioGroup with_without_air_radioGroup = (RadioGroup) findViewById(R.id.with_without_air);

        with_without_air_radioGroup.setOnCheckedChangeListener(new OnCheckedChangeListener()
        {
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                // checkedId is the RadioButton selected

                switch(checkedId) {
                    case R.id.with_air_button:
                        Toast.makeText(MainActivity.this, "with air", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.without_air_button:
                        Toast.makeText(MainActivity.this, "without air", Toast.LENGTH_SHORT).show();
                        break;

                }
            }
        });



        Spinner spinner_departure_cities = (Spinner) findViewById(R.id.departure_cities_spinner);

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.departure_cities, R.layout.spinner_layout);
        adapter.setDropDownViewResource(R.layout.spinner_dropdown_layout);
        spinner_departure_cities.setAdapter(adapter);


        travelBuddy = (TextView) findViewById(R.id.travelBuddyText);
        travelBuddy.setOnClickListener(new View.OnClickListener(){
                                           @Override
                                           public void onClick(View v) {
                                               Intent intent = new Intent(MainActivity.this, BuddyLayActivity.class);
                                               startActivity(intent);
                                           }
                                       }

        );
        test1= (Button)findViewById(R.id.test1);
        test1.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, HotelUpgradeActivity.class);
                startActivity(intent);
            }
        });





    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void radioMethod(View v){
        RadioButton button =(RadioButton) v;
        if(button.equals(button1)){
            button2.setChecked(false);
        }
        else if (button.equals(button2)){
            button1.setChecked(false);


        }

    }

    public void onRadioButtonClicked(View view) {
        // Is the button now checked?
        boolean checked = ((RadioButton) view).isChecked();

        // Check which radio button was clicked
        switch(view.getId()) {
            case R.id.with_air_button:
                if (checked)
                   Toast.makeText(MainActivity.this, "with air", Toast.LENGTH_SHORT).show();
                    break;
            case R.id.without_air_button:
                if (checked)
                    Toast.makeText(MainActivity.this, "without air", Toast.LENGTH_SHORT).show();
                    break;
        }
    }



}
