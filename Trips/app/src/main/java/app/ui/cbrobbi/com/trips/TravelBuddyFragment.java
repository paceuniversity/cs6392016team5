package app.ui.cbrobbi.com.trips;


import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroupOverlay;

public class TravelBuddyFragment extends Fragment {

    private Bundle savedState = null;

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState){
        View view = inflater.inflate(R.layout.travel_buddy_fragment, container, false);
        return view;
    }

}

