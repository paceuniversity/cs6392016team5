package app.ui.cbrobbi.com.trips;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class ImDoneActivity extends AppCompatActivity {
    ArrayList<Date> dates =new ArrayList();
    ArrayList<Integer> dates2 =new ArrayList();
    ArrayList<Integer> myList_nights_int = new ArrayList();
    ArrayList<Integer> layout_num = new ArrayList();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_im_done);

        LinearLayout parent_layout = (LinearLayout) findViewById(R.id.parent_layout);
        LinearLayout parent_layout1 = (LinearLayout) findViewById(R.id.parent_layout1);
        TextView data = (TextView) findViewById(R.id.testdata);

        TextView data1 = (TextView) findViewById(R.id.testdata1);

        TextView data2 = (TextView) findViewById(R.id.testdata2);

        TextView departure_city_entry = (TextView) findViewById(R.id.departure_city_entry);
        departure_city_entry.setText(getIntent().getExtras().getString("departure_city"));

        TextView cabin_class_entry = (TextView) findViewById(R.id.cabin_class_entry);
        cabin_class_entry.setText(getIntent().getExtras().getString("cabin_class"));

        TextView rooms_num_entry = (TextView) findViewById(R.id.rooms_num_entry);
        rooms_num_entry.setText(getIntent().getExtras().getString("rooms_num"));

        TextView arriving_city_entry = (TextView) findViewById(R.id.arriving_city_entry);
        arriving_city_entry.setText(getIntent().getExtras().getString("arriving_city"));

        TextView selected_date_entry = (TextView) findViewById(R.id.selected_date_entry);
        selected_date_entry.setText(getIntent().getExtras().getString("selected_date"));


        TextView adults_num_entry = (TextView) findViewById(R.id.adults_num_entry);
        adults_num_entry.setText(Integer.toString(getIntent().getExtras().getInt("adults_number")));

        TextView children_num_entry = (TextView) findViewById(R.id.children_num_entry);
        children_num_entry.setText(Integer.toString(getIntent().getExtras().getInt("children_number")));

        TextView nights_num_entry = (TextView) findViewById(R.id.nights_num_entry);
        nights_num_entry.setText(Integer.toString(getIntent().getExtras().getInt("nights_number")));

        TextView people_num = (TextView) findViewById(R.id.people_num);
        people_num.setText("for " +adults_num_entry.getText()+ "Adult(s), "+ children_num_entry.getText() +" Child(ren)");

        TextView deparure_city =(TextView) findViewById(R.id.departure_city);
        deparure_city.setText(departure_city_entry.getText());
        TextView arrival_city2 =(TextView) findViewById(R.id.arrival_city2);
        arrival_city2.setText(departure_city_entry.getText());

        TextView deparure_city2 =(TextView) findViewById(R.id.departure_city2);
        deparure_city2.setText(arriving_city_entry.getText());
        TextView arrival_city =(TextView) findViewById(R.id.arrival_city);
        arrival_city.setText(arriving_city_entry.getText());


        String allItems = "";
        ArrayList<String> myList_nights = (ArrayList<String>) getIntent().getSerializableExtra("mylist_nights");
        for (String night : myList_nights) {
            allItems = allItems + "\n" + night; //adds a new line between items
            data.setText(allItems);
        }

        String all_cities= "";
        ArrayList<String> myList_cities = (ArrayList<String>) getIntent().getSerializableExtra("mylist_cities");
        for (String city : myList_cities) {
            all_cities = all_cities + "\n" + city; //adds a new line between items
            data1.setText(all_cities);
        }

        Toast.makeText(getApplicationContext(), allItems, Toast.LENGTH_LONG).show();


        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        String start_date = selected_date_entry.getText().toString();

        for(String s : myList_nights){
            myList_nights_int.add(Integer.valueOf(s));
        }

        int[] dd= convertIntegers(myList_nights_int);

        for (int i = 0; i < myList_nights.size(); i++) {


            try {

                Date date = formatter.parse(start_date);
                Toast.makeText(getApplicationContext(), date.toString(), Toast.LENGTH_SHORT).show();
                Calendar c = Calendar.getInstance();
                c.setTime(date);
                c.add(Calendar.DATE, sumOfArray(dd,i));
                Date dt = c.getTime();
                dates.add(dt);

                Toast.makeText(getApplicationContext(), dt.toString(), Toast.LENGTH_SHORT).show();

            } catch (ParseException e) {
                e.printStackTrace();
            }}

        String all_dates = "";
        for (Date date : dates) {
            all_dates = all_dates + "\n" + date; //adds a new line between items
            data2.setText(all_dates);
            Toast.makeText(getApplicationContext(), all_dates, Toast.LENGTH_SHORT).show();
        }


        for (int i=0;i<myList_cities.size(); i++){
            TextView city = new TextView(this);
            city.setId(i);
            parent_layout1.addView(city);
            layout_num.add(i);
        }

        for (int i=0;i<myList_cities.size(); i++){
            TextView city_text = (TextView) findViewById(i);
                city_text.setText(myList_cities.get(i));


        }

    }


    public int sumOfArray(int[] a, int n) {
        if (n == 0){
            return a[n];}
        else{
            return a[n] + sumOfArray(a, n-1);}




    }

    public int sumListRecursive(List<Integer> numbers) {
        if (numbers.isEmpty() == true ) {
            return 0;
        }
        else {
            /* removed the print statement from here as it prints each time the function is called and else is executed. */
            return numbers.get(0) + sumListRecursive(numbers.subList(1, numbers.size()));
        }
    }

    public static int[] convertIntegers(List<Integer> integers)
    {
        int[] ret = new int[integers.size()];
        for (int i=0; i < ret.length; i++)
        {
            ret[i] = integers.get(i).intValue();
        }
        return ret;
    }


}
