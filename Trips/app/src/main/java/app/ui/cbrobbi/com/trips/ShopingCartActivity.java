package app.ui.cbrobbi.com.trips;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class ShopingCartActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shoping_cart);
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
            Toast.makeText(this,"Good to go",Toast.LENGTH_LONG).show();
        }
        else
        {
            Toast.makeText(this,"BAd",Toast.LENGTH_LONG).show();
        }
    }
}
