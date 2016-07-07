package app.ui.cbrobbi.com.trips;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class ImDoneActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_im_done);

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


}
}