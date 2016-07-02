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

import android.widget.Button;
import android.widget.RadioButton;
import android.widget.TextView;

import android.widget.RadioButton;


public class MainActivity extends AppCompatActivity {
    TextView travelBuddy;
    Button test1,test2;
    RadioButton button1, button2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
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
        button1 = (RadioButton) findViewById(R.id.radioButton1);
        button2 = (RadioButton) findViewById(R.id.radioButton2);


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


}
