package app.ui.cbrobbi.com.trips;

import android.content.Intent;
import android.net.Uri;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;

public class BuddyLayActivity extends AppCompatActivity {
    Button sms, email, call;
    Button sms2, email2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_buddy_layout);



        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

//        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
//        fab.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
//                        .setAction("Action", null).show();
//            }
//        });
//        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        sms = (Button) findViewById(R.id.buttonSms);
        email= (Button) findViewById(R.id.buttonEmail);
        call = (Button) findViewById(R.id.buttonCall);

        sms2 = (Button) findViewById(R.id.buttonSms2);
        email2 = (Button) findViewById(R.id.buttonEmail2);

        //set onclick listener for the sms button
        sms.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                sendSMS();
            }


        });
        //set onclick listener for the sms button

        sms2.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                sendSMS2();
            }
        });
        email.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                sendEmail();
            }
        });
        email2.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                sendEmail2();
            }
        });
        call.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                callMeth();
            }
        });
    }
    //methods to send sms
    public void sendSMS(){
        Intent intent = new Intent(Intent.ACTION_SENDTO);
        intent.setData(Uri.parse("smsto:"+ Uri.encode("17248242135")));
        intent.putExtra("sms_body","hello");
        startActivity(intent);
    }
    public void sendSMS2(){
        Intent intent = new Intent(Intent.ACTION_SENDTO);
        intent.setData(Uri.parse("smsto:"+Uri.encode("17248242154")));
        intent.putExtra("sms_body","hello");
        startActivity(intent);
    }
    // methods for the two buttons to send email
    public void sendEmail(){
        Intent intent = new Intent(Intent.ACTION_SEND);
        intent.setType("text/html");
        intent.putExtra(Intent.EXTRA_EMAIL,"ba8768@gmail.com");
        intent.putExtra(Intent.EXTRA_SUBJECT, "Buddy olPal!");
        intent.putExtra(Intent.EXTRA_TEXT, "I'm emailing you.");
        startActivity(Intent.createChooser(intent, "Send Email"));
    }
    public void sendEmail2(){
        Intent intent = new Intent(Intent.ACTION_SEND);
        intent.setType("text/html");
        intent.putExtra(Intent.EXTRA_EMAIL,"redman@gmail.com");
        intent.putExtra(Intent.EXTRA_SUBJECT, "Buddy olPal!");
        intent.putExtra(Intent.EXTRA_TEXT, "I'm emailing you.");
        startActivity(Intent.createChooser(intent, "Send Email"));
    }
    //method to call
    public void callMeth(){
        Intent intent = new Intent(Intent.ACTION_DIAL);
        intent.setData(Uri.parse("tel:2124325566"));
        startActivity(intent);

    }



}
