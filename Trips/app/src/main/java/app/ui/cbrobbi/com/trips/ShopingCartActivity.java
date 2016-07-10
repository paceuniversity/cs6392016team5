package app.ui.cbrobbi.com.trips;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Gravity;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;
import android.widget.Toast;
import android.view.Menu;
import android.view.MenuItem;

import org.w3c.dom.Text;

public class ShopingCartActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shoping_cart);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        Intent intent = getIntent();
        Bundle extras = intent.getExtras();
        if (extras != null)
        {
            if (extras.containsKey("vacation") && extras.getString("vacation").matches("Going to London for 6 nights on: "))
            {
                LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(Toolbar.LayoutParams.WRAP_CONTENT, Toolbar.LayoutParams.FILL_PARENT);
                params.weight = 1.0f;
                params.gravity = Gravity.RIGHT;
                LinearLayout.LayoutParams params2 = new LinearLayout.LayoutParams(Toolbar.LayoutParams.WRAP_CONTENT, Toolbar.LayoutParams.FILL_PARENT);
                params.weight = 1.0f;
                params.gravity = Gravity.RIGHT;
                TableLayout tl = (TableLayout)findViewById(R.id.product_list);
                TextView tot = (TextView)findViewById(R.id.totalGoesHear);
                TableRow tr = new TableRow(this);
                tr.setLayoutParams(new TableRow.LayoutParams(TableRow.LayoutParams.MATCH_PARENT, TableRow.LayoutParams.WRAP_CONTENT));
                TextView tv = new TextView(this);
                TextView tv2 = new TextView(this);
                tv.setText(extras.getString("vacation") + extras.getString("date"));
                tv2.setText(extras.getString("cost"));
                tot.setText(extras.getString("cost"));
                tv.setLayoutParams(new TableRow.LayoutParams(TableRow.LayoutParams.FILL_PARENT, TableRow.LayoutParams.WRAP_CONTENT, 1f));
                tv2.setLayoutParams(new TableRow.LayoutParams(TableRow.LayoutParams.FILL_PARENT, TableRow.LayoutParams.WRAP_CONTENT, 1f));
                tv.setGravity(Gravity.LEFT);
                tv2.setGravity(Gravity.RIGHT);
                tr.addView(tv);
                tr.addView(tv2);
                tl.addView(tr, new TableLayout.LayoutParams(TableLayout.LayoutParams.FILL_PARENT, TableLayout.LayoutParams.WRAP_CONTENT));
            }
            else if (extras.containsKey("vacation") && extras.getString("vacation").matches("Going to the Middle East for 12 nights on: "))
            {
                LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(Toolbar.LayoutParams.WRAP_CONTENT, Toolbar.LayoutParams.FILL_PARENT);
                params.weight = 1.0f;
                params.gravity = Gravity.RIGHT;
                LinearLayout.LayoutParams params2 = new LinearLayout.LayoutParams(Toolbar.LayoutParams.WRAP_CONTENT, Toolbar.LayoutParams.FILL_PARENT);
                params.weight = 1.0f;
                params.gravity = Gravity.RIGHT;
                TableLayout tl = (TableLayout)findViewById(R.id.product_list);
                TextView tot = (TextView)findViewById(R.id.totalGoesHear);
                TableRow tr = new TableRow(this);
                tr.setLayoutParams(new TableRow.LayoutParams(TableRow.LayoutParams.MATCH_PARENT, TableRow.LayoutParams.WRAP_CONTENT));
                TextView tv = new TextView(this);
                TextView tv2 = new TextView(this);
                tv.setText(extras.getString("vacation")+ extras.getString("date"));
                tv2.setText(extras.getString("cost"));
                tot.setText(extras.getString("cost"));
                tv.setLayoutParams(new TableRow.LayoutParams(TableRow.LayoutParams.FILL_PARENT, TableRow.LayoutParams.WRAP_CONTENT, 1f));
                tv2.setLayoutParams(new TableRow.LayoutParams(TableRow.LayoutParams.FILL_PARENT, TableRow.LayoutParams.WRAP_CONTENT, 1f));
                tv.setGravity(Gravity.LEFT);
                tv2.setGravity(Gravity.RIGHT);
                tr.addView(tv);
                tr.addView(tv2);
                tl.addView(tr, new TableLayout.LayoutParams(TableLayout.LayoutParams.FILL_PARENT, TableLayout.LayoutParams.WRAP_CONTENT));
            }
            else if (extras.containsKey("vacation") && extras.getString("vacation").matches("Going To Asia for 10 nights on: "))
            {
                LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(Toolbar.LayoutParams.WRAP_CONTENT, Toolbar.LayoutParams.FILL_PARENT);
                params.weight = 1.0f;
                params.gravity = Gravity.RIGHT;
                LinearLayout.LayoutParams params2 = new LinearLayout.LayoutParams(Toolbar.LayoutParams.WRAP_CONTENT, Toolbar.LayoutParams.FILL_PARENT);
                params.weight = 1.0f;
                params.gravity = Gravity.RIGHT;
                TableLayout tl = (TableLayout)findViewById(R.id.product_list);
                TextView tot = (TextView)findViewById(R.id.totalGoesHear);
                TableRow tr = new TableRow(this);
                tr.setLayoutParams(new TableRow.LayoutParams(TableRow.LayoutParams.MATCH_PARENT, TableRow.LayoutParams.WRAP_CONTENT));
                TextView tv = new TextView(this);
                TextView tv2 = new TextView(this);
                tv.setText(extras.getString("vacation")+ extras.getString("date"));
                tv2.setText(extras.getString("cost"));
                tot.setText(extras.getString("cost"));
                tv.setLayoutParams(new TableRow.LayoutParams(TableRow.LayoutParams.FILL_PARENT, TableRow.LayoutParams.WRAP_CONTENT, 1f));
                tv2.setLayoutParams(new TableRow.LayoutParams(TableRow.LayoutParams.FILL_PARENT, TableRow.LayoutParams.WRAP_CONTENT, 1f));
                tv.setGravity(Gravity.LEFT);
                tv2.setGravity(Gravity.RIGHT);
                tr.addView(tv);
                tr.addView(tv2);
                tl.addView(tr, new TableLayout.LayoutParams(TableLayout.LayoutParams.FILL_PARENT, TableLayout.LayoutParams.WRAP_CONTENT));
            }
        }
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
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
        else if(id == R.id.action_cart)
        {
            Intent intent = new Intent(this, ShopingCartActivity.class);
            startActivity(intent);
        }
        else if(id == R.id.action_help)
        {
            Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://github.com/paceuniversity/cs6392016team5/wiki"));
            startActivity(browserIntent);
        }


        return super.onOptionsItemSelected(item);
    }
    public void validateCC(View v)
    {
        boolean go = true;
        EditText lstNm = (EditText)findViewById(R.id.ccLstNm);
        EditText fstNm = (EditText)findViewById(R.id.ccFstNm);
        EditText email = (EditText)findViewById(R.id.ccEmail);
        EditText zip = (EditText)findViewById(R.id.ccZip);
        EditText ccNbr = (EditText)findViewById(R.id.ccNbr);
        TextView ccNbrErr = (TextView) findViewById(R.id.ccNbrErr);
        TextView zipErr = (TextView)findViewById(R.id.zipErr);
        TextView eErr = (TextView)findViewById(R.id.emailErr);
        TextView lstNmErr = (TextView)findViewById(R.id.lastNmErr);
        TextView fstNmErr = (TextView)findViewById(R.id.fstNmErr);
        ccNbrErr.setText("");
        zipErr.setText("");
        eErr.setText("");
        fstNmErr.setText("");
        lstNmErr.setText("");
        if(lstNm.getText().toString().matches(""))
        {

            lstNmErr.setText("Enter Last Name");
            go = false;
        }
        if(fstNm.getText().toString().matches(""))
        {

            fstNmErr.setText("Enter First Name");
            go = false;
        }
        if(email.getText().toString().matches(""))
        {
            eErr.setText("Enter email address");
            go = false;
        }

        if(zip.getText().toString().matches(""))
        {
            TextView tv = (TextView)findViewById(R.id.zipErr);
            tv.setText("Enter a Zip Code");
            go = false;
        }
        else if (zip.getText().toString().length() != 5)
        {
            TextView tv = (TextView)findViewById(R.id.zipErr);
            zipErr.setText("Zip Codes Have 5 Digits");
            go = false;
        }

        if(!ccNbr.getText().toString().matches(""))
        {
            String nbr = ccNbr.getText().toString();
            if(!nbr.matches("[0-9]+"))
            {
                ccNbrErr.setText("Enter a Valid CC Number");
                go = false;
            }
            if(nbr.length() < 13) {

                ccNbrErr.setText("Enter a Valid CC Number");
                go = false;
            }
        }
        else
        {

            ccNbrErr.setText("Enter a Valid CC Number");
            go = false;
        }
        if(go == true)
        {
            Intent i = new Intent(Intent.ACTION_SENDTO);
            i.setType("text/plain");

            try {
                //startActivity(Intent.createChooser(i, "Your order is processing. A confirmation will arrive shortly."));
                Toast.makeText(this, "Your order is processing. A confirmation email will arrive shortly..", Toast.LENGTH_SHORT).show();
            } catch (android.content.ActivityNotFoundException ex) {
                Toast.makeText(this, "There are no email clients installed.", Toast.LENGTH_SHORT).show();
            }
            lstNm.setText("");
            fstNm.setText("");
            email.setText("");
            zip.setText("");
            ccNbr.setText("");
        }
        else
        {

            Toast.makeText(this,"Pleas fix errors in red and resubmit.",Toast.LENGTH_LONG).show();
        }
    }
}
