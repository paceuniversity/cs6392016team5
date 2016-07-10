package app.ui.cbrobbi.com.trips;


import android.app.DatePickerDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.RectShape;
import android.os.Bundle;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.support.design.widget.AppBarLayout.LayoutParams;
import android.view.inputmethod.InputMethodManager;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.NumberPicker;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.RadioGroup.OnCheckedChangeListener;
import android.widget.RadioGroup;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Calendar;


public class MainActivity extends AppCompatActivity {


    Button test1,test2;
    RadioButton button1, button2;
    RadioGroup with_without_air_radioGroup;
    ArrayAdapter<CharSequence> adapter;
    private DatePicker datePicker;
    private Calendar calendar;
    private TextView dateView;
    private TextView dateViewBook1;
    private TextView dateViewBook2;
    private TextView dateViewBook3;
    private int year, month, day;
    TextView travelBuddy;
    EditText nightsNumber,nights1,nights2, adult, children, room;
    Spinner spinner_departure_cities;
    int count=0;
    int count2;
    int i;
    ArrayList <String> cities = new ArrayList();
    ArrayList <String> nights = new ArrayList();
    Spinner adltCntSpin, roomSpin, chldrnSpin;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        count2 = 0;

        // switching between with air fragment and without air fragment
//        RadioGroup with_without_air_radioGroup = (RadioGroup) findViewById(R.id.with_without_air);
//
//        with_without_air_radioGroup.setOnCheckedChangeListener(new OnCheckedChangeListener()
//        {
//            public void onCheckedChanged(RadioGroup group, int checkedId) {
//                // checkedId is the RadioButton selected
//
//                switch(checkedId) {
//                    case R.id.with_air_button:
//                        Toast.makeText(MainActivity.this, "with air", Toast.LENGTH_SHORT).show();
//                        break;
//                    case R.id.without_air_button:
//                        Toast.makeText(MainActivity.this, "without air", Toast.LENGTH_SHORT).show();
//                        break;
//
//                }
//            }
//        });



        travelBuddy = (TextView) findViewById(R.id.travelBuddyText);
        travelBuddy.setOnClickListener(new View.OnClickListener(){
                                           @Override
                                           public void onClick(View v) {
                                               Intent intent = new Intent(MainActivity.this, BuddyLayActivity.class);
                                               startActivity(intent);
                                           }
                                       }

        );
        //test1= (Button)findViewById(R.id.test1);
        //test1.setOnClickListener(new View.OnClickListener(){
          //  @Override
            //public void onClick(View v) {
              //  Intent intent = new Intent(MainActivity.this, HotelUpgradeActivity.class);
                //startActivity(intent);
            //}
        //});


        dateView = (TextView) findViewById(R.id.date_selected);
        dateViewBook1 = (TextView) findViewById(R.id.bookItDate1);
        dateViewBook2 = (TextView) findViewById(R.id.bookItDate2);
        dateViewBook3 = (TextView) findViewById(R.id.bookItDate3);
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
        Toast.makeText(getApplicationContext(), "Pick a date!", Toast.LENGTH_SHORT)
                .show();
    }
    public void setDate1(View view) {
        showDialog(998);
        Toast.makeText(getApplicationContext(), "Pick a date to leave for your trip!", Toast.LENGTH_SHORT)
                .show();
    }
    public void setDate2(View view) {
        showDialog(997);
        Toast.makeText(getApplicationContext(), "Pick a date to leave for your trip!", Toast.LENGTH_SHORT)
                .show();
    }
    public void setDate3(View view) {
        showDialog(996);
        Toast.makeText(getApplicationContext(), "Pick a date to leave for your trip!", Toast.LENGTH_SHORT)
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
        else if (id == R.id.action_cart) {
            Intent intent = new Intent(this, ShopingCartActivity.class);
            startActivity(intent);
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
        else if (id == 998)
        {
            return new DatePickerDialog(this, myDateListener1, year, month, day);
        }
        else if (id == 997)
        {
            return new DatePickerDialog(this, myDateListener2, year, month, day);
        }
        else if (id == 996)
        {
            return new DatePickerDialog(this, myDateListener3, year, month, day);
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
    private DatePickerDialog.OnDateSetListener myDateListener1 = new DatePickerDialog.OnDateSetListener() {
        @Override
        public void onDateSet(DatePicker arg0, int arg1, int arg2, int arg3) {
            // TODO Auto-generated method stub
            // arg1 = year
            // arg2 = month
            // arg3 = day
            showDate1(arg1, arg2+1, arg3);
        }
    };
    private DatePickerDialog.OnDateSetListener myDateListener2 = new DatePickerDialog.OnDateSetListener() {
        @Override
        public void onDateSet(DatePicker arg0, int arg1, int arg2, int arg3) {
            // TODO Auto-generated method stub
            // arg1 = year
            // arg2 = month
            // arg3 = day
            showDate2(arg1, arg2+1, arg3);
        }
    };
    private DatePickerDialog.OnDateSetListener myDateListener3 = new DatePickerDialog.OnDateSetListener() {
        @Override
        public void onDateSet(DatePicker arg0, int arg1, int arg2, int arg3) {
            // TODO Auto-generated method stub
            // arg1 = year
            // arg2 = month
            // arg3 = day
            showDate3(arg1, arg2+1, arg3);
        }
    };


    private void showDate(int year, int month, int day) {
        dateView.setText(new StringBuilder().append(day).append("/")
                .append(month).append("/").append(year));
    }

    private void showDate1(int year, int month, int day) {
        final TextView tv1 = (TextView)findViewById(R.id.bookItDate1);
        topDeals(tv1);
        dateViewBook1.setText(new StringBuilder()
                .append(month)
                .append(day)
                .append("/")
                .append("/")
                .append(year));
    }
    private void showDate2(int year, int month, int day) {
        final TextView tv2 = (TextView)findViewById(R.id.bookItDate2);
        topDeals2(tv2);
        dateViewBook2.setText(new StringBuilder().append(month)
                .append(day)
                .append("/")
                .append("/")
                .append(year));
    }
    private void showDate3(int year, int month, int day) {
        final TextView tv3 = (TextView)findViewById(R.id.bookItDate3);
        topDeals3(tv3);
        dateViewBook3.setText(new StringBuilder().append(month)
                .append(day)
                .append("/")
                .append("/")
                .append(year));
    }
    public void topDeals(View view)
    {
        final TextView tv1 = (TextView)findViewById(R.id.bookItDate1);
        final TextView tv2 = (TextView)findViewById(R.id.bookItDate2);
        final TextView tv3 = (TextView)findViewById(R.id.bookItDate3);



        tv1.addTextChangedListener(new TextWatcher() {

            @Override
            public void afterTextChanged(Editable s) {


            }

            @Override
            public void beforeTextChanged(CharSequence s, int start,
                                          int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start,
                                      int before, int count) {
                if(s.length() != 0)
                {

                    Intent intent = new Intent(MainActivity.this, ShopingCartActivity.class);
                    intent.putExtra("vacation","Going to London for 6 nights on: ");
                    intent.putExtra("cost","$1300");
                    TextView dateTv = (TextView)findViewById(R.id.bookItDate1);
                    intent.putExtra("date",dateTv.getText().toString());
                    tv1.setVisibility(View.GONE);
                    startActivity(intent);
                }
            }
        });
        /*tv2.addTextChangedListener(new TextWatcher() {

            @Override
            public void afterTextChanged(Editable s) {


            }

            @Override
            public void beforeTextChanged(CharSequence s, int start,
                                          int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start,
                                      int before, int count) {
                if(s.length() != 0)
                {

                    Intent intent = new Intent(MainActivity.this, ShopingCartActivity.class);
                    intent.putExtra("vacation","Going to the Middle East for 12 nights on: ");
                    intent.putExtra("cost","$1700");
                    TextView dateTv = (TextView)findViewById(R.id.bookItDate2);
                    intent.putExtra("date",dateTv.getText().toString());
                    startActivity(intent);
                }
            }
        });
        tv3.addTextChangedListener(new TextWatcher() {

            @Override
            public void afterTextChanged(Editable s) {


            }

            @Override
            public void beforeTextChanged(CharSequence s, int start,
                                          int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start,
                                      int before, int count) {
                if(s.length() != 0)
                {

                    Intent intent = new Intent(MainActivity.this, ShopingCartActivity.class);
                    intent.putExtra("vacation","Going To Asia for 10 nights on: ");
                    intent.putExtra("cost","$2900");
                    TextView dateTv = (TextView)findViewById(R.id.bookItDate3);
                    intent.putExtra("date",dateTv.getText().toString());
                    startActivity(intent);
                }
            }
        });*/

    }
    public void topDeals2(View view)
    {
        final TextView tv2 = (TextView)findViewById(R.id.bookItDate2);


        tv2.addTextChangedListener(new TextWatcher() {

            @Override
            public void afterTextChanged(Editable s) {


            }

            @Override
            public void beforeTextChanged(CharSequence s, int start,
                                          int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start,
                                      int before, int count) {
                if(s.length() != 0)
                {

                    Intent intent = new Intent(MainActivity.this, ShopingCartActivity.class);
                    intent.putExtra("vacation","Going to the Middle East for 12 nights on: ");
                    intent.putExtra("cost","$1700");
                    TextView dateTv = (TextView)findViewById(R.id.bookItDate2);
                    intent.putExtra("date",dateTv.getText().toString());
                    tv2.setVisibility(View.GONE);
                    startActivity(intent);
                }
            }
        });


    }
    public void topDeals3(View view)
    {

        final TextView tv3 = (TextView)findViewById(R.id.bookItDate3);

        tv3.addTextChangedListener(new TextWatcher() {

            @Override
            public void afterTextChanged(Editable s) {


            }

            @Override
            public void beforeTextChanged(CharSequence s, int start,
                                          int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start,
                                      int before, int count) {
                if(s.length() != 0)
                {

                    Intent intent = new Intent(MainActivity.this, ShopingCartActivity.class);
                    intent.putExtra("vacation","Going To Asia for 10 nights on: ");
                    intent.putExtra("cost","$2900");
                    TextView dateTv = (TextView)findViewById(R.id.bookItDate3);
                    intent.putExtra("date",dateTv.getText().toString());
                    tv3.setVisibility(View.GONE);
                    startActivity(intent);
                }
            }
        });

    }
    ///radio button method
    public void radioMethod(View v){
        boolean button =((RadioButton) v).isChecked();
        TextView tv2 = (TextView)findViewById(R.id.textView2);
        TextView tvFlyTo = (TextView)findViewById(R.id.flying_to_desc);
        Spinner classSpinnr = (Spinner)findViewById(R.id.cabin_class_spinner);
        TextView tvClassLbl = (TextView)findViewById(R.id.textView3);
        switch(v.getId())
        {
            case R.id.without_air_button:
                if(button)
                {
                    RadioButton ntChckd = (RadioButton)findViewById(R.id.with_air_button);
                    ntChckd.setChecked(false);

                    tv2.setText("Traveling From:");
                    tvFlyTo.setText("Traveling To:");
                    classSpinnr.setVisibility(View.GONE);
                    tvClassLbl.setVisibility(View.GONE);

                }
                break;
            case R.id.with_air_button:
                if(button)
                {
                    RadioButton ntChckd = (RadioButton)findViewById(R.id.without_air_button);
                    ntChckd.setChecked(false);
                    tv2.setText("Flying From:");
                    tvFlyTo.setText("Flying to:");
                    classSpinnr.setVisibility(View.VISIBLE);
                    tvClassLbl.setVisibility(View.VISIBLE);

                }
                break;
        }

    }

    //add city functionality
    public void add_city(View view) {
        count++;
        count2++;
        //adding horizontal layout
        LinearLayout LH = new LinearLayout(this);
        LH.setOrientation(LinearLayout.HORIZONTAL);
        LayoutParams LHParams = new LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT,LinearLayout.LayoutParams.WRAP_CONTENT);
        LH.setMinimumHeight(25);
        LHParams.setMargins(0,0,0,30);
        LH.setLayoutParams(LHParams);

        LH.setId(count2 + 10);

        //adding vertical layouts
        LinearLayout LV1 = new LinearLayout(this);
        LV1.setOrientation(LinearLayout.VERTICAL);
        LayoutParams LV1Params = new LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT,LinearLayout.LayoutParams.MATCH_PARENT);
        LV1Params.weight = 3f;
        LV1.setLayoutParams(LV1Params);

        FrameLayout FL1 = new FrameLayout(this);
        LayoutParams FL1Params = new LayoutParams(FrameLayout.LayoutParams.MATCH_PARENT,FrameLayout.LayoutParams.MATCH_PARENT);
        FL1.setLayoutParams(FL1Params);

        LinearLayout LV2 = new LinearLayout(this);
        LV2.setOrientation(LinearLayout.VERTICAL);
        LayoutParams LV2Params = new LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT,LinearLayout.LayoutParams.WRAP_CONTENT);
        LV2Params.weight = 3f;
        LV2.setLayoutParams(LV2Params);

        FrameLayout FL2 = new FrameLayout(this);
        LayoutParams FL2Params = new LayoutParams(FrameLayout.LayoutParams.MATCH_PARENT,FrameLayout.LayoutParams.MATCH_PARENT);
        FL2.setLayoutParams(FL2Params);

        LinearLayout LV3 = new LinearLayout(this);
        LV3.setOrientation(LinearLayout.VERTICAL);
        LayoutParams LV3Params = new LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT,LinearLayout.LayoutParams.MATCH_PARENT);
        LV3Params.weight =3f;
        LV3.setLayoutParams(LV3Params);

        FrameLayout FL3 = new FrameLayout(this);
        LayoutParams FL3Params = new LayoutParams(FrameLayout.LayoutParams.MATCH_PARENT,FrameLayout.LayoutParams.MATCH_PARENT);
        FL3.setLayoutParams(FL3Params);

        EditText edittext_nights = new EditText(this);
        edittext_nights.setId(count);
        LayoutParams edittext_params = new LayoutParams(LayoutParams.MATCH_PARENT,LayoutParams.WRAP_CONTENT);
        edittext_nights.setBackgroundResource(R.drawable.edittext_design);
        edittext_nights.setLayoutParams(edittext_params);

        Spinner spinner_add_city = new Spinner(this);
        ArrayAdapter<CharSequence> spinner_adapter_add_city = ArrayAdapter.createFromResource(this, R.array.visiting_cities, R.layout.spinner_layout);
        spinner_adapter_add_city.setDropDownViewResource(R.layout.spinner_dropdown_layout);
        spinner_add_city.setAdapter(spinner_adapter_add_city);
        spinner_add_city.setId(count*222);
        LayoutParams spiiner_params = new LayoutParams(LayoutParams.MATCH_PARENT,LayoutParams.MATCH_PARENT);
        spinner_add_city.setBackgroundResource(R.drawable.spinner_design);
        spinner_add_city.setLayoutParams(spiiner_params);
        Button remove_city_button = new Button (this);
        LayoutParams remove_city_button_params = new LayoutParams(LayoutParams.WRAP_CONTENT,LayoutParams.WRAP_CONTENT);
        remove_city_button.setBackgroundResource(R.drawable.button_design);
        remove_city_button_params.setMargins(0,20,0,20);
        remove_city_button.setText("Remove");
        remove_city_button.setTextColor(Color.parseColor("#FFFFFF"));
        remove_city_button.setLayoutParams(remove_city_button_params);
        remove_city_button.setId(count2+10);
        remove_city_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                removeAddCityLL(v, count2 + 10);
            }
        });



        LinearLayout parent_layout = (LinearLayout) findViewById(R.id.parent_layout);

        FL1.addView(spinner_add_city);
        FL2.addView(remove_city_button);
        FL3.addView(edittext_nights);

        LV1.addView(FL1);
        LV2.addView(FL2);
        LV3.addView(FL3);

        LH.addView(LV1);
        LH.addView(LV2);
        LH.addView(LV3);

        parent_layout.addView(LH);
        Toast.makeText(MainActivity.this, Integer.toString(count), Toast.LENGTH_SHORT).show();

        //Toast.makeText(MainActivity.this, Integer.toString(count)+Integer.toString(LL.getId())+Integer.toString(edit_text.getId()), Toast.LENGTH_SHORT).show();

    }
    public void removeAddCityLL(View view, int id)
    {
        LinearLayout ll = (LinearLayout)findViewById(view.getId());
        ll.setVisibility(View.GONE);

    }


    //passing user's itinirary to a new activity
    public void im_done(View view) {

        Spinner spinner_departure_cities = (Spinner) findViewById(R.id.departure_cities_spinner);
        Spinner spinner_cabin_class = (Spinner) findViewById(R.id.cabin_class_spinner);
        Spinner spinner_rooms_num = (Spinner) findViewById(R.id.room_num_spinner);
        Spinner spinner_arriving_city = (Spinner) findViewById(R.id.arriving_city_spinner);
        TextView date_selected = (TextView) findViewById(R.id.date_selected);
        EditText adults_num = (EditText) findViewById(R.id.adultNumber);
        EditText children_num = (EditText) findViewById(R.id.childrenNumber);
        EditText nights_num = (EditText) findViewById(R.id.nightNumber);
        TextView adults_error_message = (TextView) findViewById(R.id.adults_error_message);
        TextView nights_error_message = (TextView) findViewById(R.id.nights_error_message);

        if ((adults_num.getText().toString()).matches("") || Integer.parseInt(adults_num.getText().toString()) < 1){
            adults_error_message.setText("Enter a number!");

            if(Integer.parseInt(nights_num.getText().toString()) < 1)
            {
                adults_error_message.setText("Enter a number!");
            }
            else
            {
                adults_error_message.setText("Enter a number!");
            }
        }
        else if((nights_num.getText().toString()).matches("") || Integer.parseInt(nights_num.getText().toString()) < 1)
        {
            if(Integer.parseInt(nights_num.getText().toString()) < 1)
            {
                nights_error_message.setText("Atleast 1 Night!");
            }
            else
            {
                nights_error_message.setText("Enter a number!");
            }

        }
        else
        {
            if((children_num.getText().toString().matches("")))
            {
                children_num.setText("0");
            }
            for (int i = 0; i < count; i++) {
                //LinearLayout child_layout = (LinearLayout) findViewById(i);
                EditText child_text = (EditText) findViewById(i+1);
                Spinner spinner_text = (Spinner) findViewById((i+1)*222);
                String night_number=child_text.getText().toString();
                String city_name=spinner_text.getSelectedItem().toString();

                cities.add(city_name);
                nights.add(night_number);

                //al2()
                //Toast.makeText(MainActivity.this, Integer.toString(al(i)), Toast.LENGTH_SHORT).show();

            }
            nights.add(0,nights_num.getText().toString());


            // Toast.makeText(MainActivity.this, Integer.toString(al.size()), Toast.LENGTH_SHORT).show();


            String allItems = ""; //used to display in the toast

            for(String str : nights){
                allItems = allItems + "\n" + str; //adds a new line between items
            }

            Toast.makeText(getApplicationContext(),allItems, Toast.LENGTH_LONG).show();

            //Toast.makeText(getApplicationContext(),allItems, Toast.LENGTH_LONG).show();


            Intent imDoneIntent = new Intent(this, ImDoneActivity.class);
            imDoneIntent.putExtra("departure_city", spinner_departure_cities.getSelectedItem().toString());
            imDoneIntent.putExtra("cabin_class", spinner_cabin_class.getSelectedItem().toString());
            imDoneIntent.putExtra("rooms_num", spinner_rooms_num.getSelectedItem().toString());
            imDoneIntent.putExtra("arriving_city", spinner_arriving_city.getSelectedItem().toString());
            imDoneIntent.putExtra("selected_date", date_selected.getText().toString());
            imDoneIntent.putExtra("adults_number", Integer.parseInt(adults_num.getText().toString()));
            imDoneIntent.putExtra("children_number", Integer.parseInt(children_num.getText().toString()));
            imDoneIntent.putExtra("nights_number", Integer.parseInt(nights_num.getText().toString()));
            imDoneIntent.putExtra("mylist_nights", nights);
            imDoneIntent.putExtra("mylist_cities",cities);

            startActivity(imDoneIntent);
        }


    }}





