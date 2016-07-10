package app.ui.cbrobbi.com.trips;


import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.InputStream;
import java.net.URL;

public class HotelUpgradeActivity extends AppCompatActivity {
    TextView website, map, gallery, youtube;
    TextView website2, map2, gallery2, youtube2;
    ImageView image1, image2;
    String site1 = "https://raw.githubusercontent.com/ba8768/CS6392016/master/TrumpPicture.png";
    String site2 = "https://raw.githubusercontent.com/ba8768/CS6392016/master/HiltonPicture.png";





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hotel_upgrade);
        image1 = (ImageView)findViewById(R.id.imageViewForAppS1);
        image2 = (ImageView)findViewById(R.id.imageViewForAppS2);

        final int id = getIntent().getExtras().getInt("id");

        Button upgrade1 = (Button) findViewById(R.id.upgrade1);

        upgrade1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent upgradeHotelIntent2 = new Intent(HotelUpgradeActivity.this, ImDoneActivity.class);
                upgradeHotelIntent2.putExtra("upgrade","new hotel");
                int n=id+222;
                upgradeHotelIntent2.putExtra("id_b", n);
                upgradeHotelIntent2.setFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT | Intent.FLAG_ACTIVITY_PREVIOUS_IS_TOP);
                startActivity(upgradeHotelIntent2);


            }


        });
    }

    public void prcoessFour (View v){
        TextView current = (TextView)v;
        switch(v.getId()){
            case R.id.webClick1:
                String r = ( "https://www.trumphotelcollection.com");
                Uri uriUrl = Uri.parse(r);
                Intent launchBrowser = new Intent(Intent.ACTION_VIEW, uriUrl);
                startActivity(launchBrowser);
                break;
            case R.id.mapClick1:
                String geoUri = String.format("geo: 40.712784, -74.005941");
                Uri geo = Uri.parse(geoUri);
                Intent geoMap = new Intent(Intent.ACTION_VIEW,geo);
                startActivity(geoMap);

                break;
            case R.id.galleryClick1:

                new ImageAsynch().execute(site1);

                break;
            case R.id.youtubeClick1:
                String link = ( "https://www.youtube.com/watch?v=GQiWhy8fkNs");
                Uri uriUrl3 = Uri.parse(link);
                Intent launchBrowser3 = new Intent(Intent.ACTION_VIEW, uriUrl3);
                startActivity(launchBrowser3);

                break;
            case R.id.webClick2:
                String youTubeLink = "http://www3.hilton.com/en/index.html?WT.srch1";
                Uri uriUrl2 = Uri.parse(youTubeLink);
                Intent launchBrowser2 = new Intent(Intent.ACTION_VIEW, uriUrl2);
                startActivity(launchBrowser2);
                break;
            case R.id.mapClick2:
                String geoUri2 = String.format("geo: 32.318231, -86.902298");
                Uri geo2 = Uri.parse(geoUri2);
                Intent geoMap2 = new Intent(Intent.ACTION_VIEW,geo2);
                startActivity(geoMap2);

                break;
            case R.id.galleryClick2:
                new ImageAsynch2().execute(site2);


                break;
            case R.id.youtubeClick2:
                String youTubeLink2 = ( "https://www.youtube.com/watch?v=vB6nodMeWn4");
                Uri uriUrl4 = Uri.parse(youTubeLink2);
                Intent launchBrowser4 = new Intent(Intent.ACTION_VIEW, uriUrl4);
                startActivity(launchBrowser4);

                break;
        }

    }





    ///AsyncTask to download the images
    public class ImageAsynch extends AsyncTask<String, Void,Bitmap> {

        @Override
        protected void onPreExecute() {
            super.onPreExecute();

        }
        @Override
        protected Bitmap doInBackground(String... p) {
            Bitmap bitMap;
            String imageURL = p[0];

            Bitmap bitmap = null;
            try {

                URL url = new URL(p[0]);
                InputStream is = url.openConnection().getInputStream();
                bitMap = BitmapFactory.decodeStream(is);
                return bitMap;

            } catch (Exception e) {
                Log.e("image","failed to load image",e);
                Log.e("error", e.getMessage());
            }
            return bitmap;
        }

        @Override
        protected void onPostExecute(Bitmap bitmap) {
            image1.setImageBitmap(bitmap);

        }
    }
    public class ImageAsynch2 extends AsyncTask<String, Void,Bitmap> {

        @Override
        protected void onPreExecute() {
            super.onPreExecute();

        }
        @Override
        protected Bitmap doInBackground(String... p) {
            Bitmap bitMap;
            String imageURL = p[0];

            Bitmap bitmap = null;
            try {

                URL url = new URL(p[0]);
                InputStream is = url.openConnection().getInputStream();
                bitMap = BitmapFactory.decodeStream(is);
                return bitMap;

            } catch (Exception e) {
                Log.e("image","failed to load image",e);
                Log.e("error", e.getMessage());
            }
            return bitmap;
        }

        @Override
        protected void onPostExecute(Bitmap bitmap) {
            image2.setImageBitmap(bitmap);

        }





    }



    public void upgrade_hotel(View view) {



    }
}