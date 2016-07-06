package app.ui.cbrobbi.com.trips;


import android.app.DatePickerDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;

import android.view.inputmethod.InputMethodManager;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.NumberPicker;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.RadioGroup.OnCheckedChangeListener;
import android.widget.RadioGroup;
import android.widget.Toast;

import java.util.Calendar;


public class MainActivity extends AppCompatActivity {


    Button test1,test2;
    RadioButton button1, button2;
    RadioGroup with_without_air_radioGroup;
    ArrayAdapter<CharSequence> adapter;
    private DatePicker datePicker;
    private Calendar calendar;
    private TextView dateView;
    private int year, month, day;
    TextView travelBuddy;
    EditText nightsNumber,nights1,nights2, adult, children, room;

    Spinner adltCntSpin, roomSpin, chldrnSpin;
    private static final String [] numbCount = {"1","2","3","4","5"};


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

        ArrayAdapter<CharSequence> adapter_cities = ArrayAdapter.createFromResource(this,
                R.array.cities, R.layout.spinner_layout);
        adapter_cities.setDropDownViewResource(R.layout.spinner_dropdown_layout);
        spinner_departure_cities.setAdapter(adapter_cities);

        Spinner spinner_rooms_num = (Spinner) findViewById(R.id.room_num_spinner);
        ArrayAdapter<CharSequence> adapter_rooms = ArrayAdapter.createFromResource(this,R.array.numbers, R.layout.spinner_layout);
        adapter_rooms.setDropDownViewResource(R.layout.spinner_dropdown_layout);
        spinner_rooms_num.setAdapter(adapter_rooms);




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

        dateView = (TextView) findViewById(R.id.textView301);
        calendar = Calendar.getInstance();
        year = calendar.get(Calendar.YEAR);

        month = calendar.get(Calendar.MONTH);
        day = calendar.get(Calendar.DAY_OF_MONTH);
        showDate(year, month+1, day);









        adult = (EditText) findViewById(R.id.adultNumber);
        children = (EditText) findViewById(R.id.childrenNumber);
        room = (EditText) findViewById(R.id.nightNumber);

        nightsNumber = (EditText) findViewById(R.id.nightNumber);

        //handle key presses, when one presses enter for nights,adult, children and room edittexts

        nightsNumber.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View v, int keyCode, KeyEvent event) {
                if (keyCode ==KeyEvent.KEYCODE_ENTER){
                    InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
                    imm.hideSoftInputFromWindow(nightsNumber.getWindowToken(),0);
                    nights1.setText(nightsNumber.getText().toString());
                    nights2.setText(nightsNumber.getText().toString());
                    nightsNumber.setCursorVisible(false);



                }
                return false;
            }
        });
        adult.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View v, int keyCode, KeyEvent event) {
                if (keyCode ==KeyEvent.KEYCODE_ENTER){
                    InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
                    imm.hideSoftInputFromWindow(nightsNumber.getWindowToken(),0);
                    adult.setText(adult.getText().toString());
                    adult.setCursorVisible(false);



                }
                return false;
            }
        });
        children.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View v, int keyCode, KeyEvent event) {
                if (keyCode ==KeyEvent.KEYCODE_ENTER){
                    InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
                    imm.hideSoftInputFromWindow(nightsNumber.getWindowToken(),0);
                    children.setText(children.getText().toString());
                    children.setCursorVisible(false);



                }
                return false;
            }
        });
        room.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View v, int keyCode, KeyEvent event) {
                if (keyCode ==KeyEvent.KEYCODE_ENTER){
                    InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
                    imm.hideSoftInputFromWindow(nightsNumber.getWindowToken(),0);
                    room.setText(room.getText().toString());
                    room.setCursorVisible(false);



                }
                return false;
            }
        });



    }

    //handle the clikc on the edittext of night and others
    public void setNumbers(View view){
        int id= view.getId();
        if(id== nightsNumber.getId()){
            nightsNumber.setCursorVisible(true);
        }
        if (id== adult.getId()){
            adult.setCursorVisible(true);

        }
        if(id==children.getId()){
            children.setCursorVisible(true);
        }
        if(id==room.getId()){
            room.setCursorVisible(true);
        }
    }

    @SuppressWarnings("deprecation")
    public void setDate(View view) {
        showDialog(999);
        Toast.makeText(getApplicationContext(), "ca", Toast.LENGTH_SHORT)
                .show();
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

    public void onValueChange(NumberPicker picker, int oldVal, int newVal)
    {
        Log.i("Main Numb Picker Adult", ""+newVal);
    }
    @Override
    protected Dialog onCreateDialog(int id) {
        // TODO Auto-generated method stub
        if (id == 999) {
            return new DatePickerDialog(this, myDateListener, year, month, day);
        }
        return null;
    }

    private DatePickerDialog.OnDateSetListener myDateListener = new DatePickerDialog.OnDateSetListener() {
        @Override
        public void onDateSet(DatePicker arg0, int arg1, int arg2, int arg3) {
            // TODO Auto-generated method stub
            // arg1 = year
            // arg2 = month
            // arg3 = day
            showDate(arg1, arg2+1, arg3);
        }
    };


    private void showDate(int year, int month, int day) {
        dateView.setText(new StringBuilder().append(day).append("/")
                .append(month).append("/").append(year));
    }





}
