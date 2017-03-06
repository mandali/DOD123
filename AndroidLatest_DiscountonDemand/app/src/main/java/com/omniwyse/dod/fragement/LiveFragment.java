package com.omniwyse.dod.fragement;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.estimote.sdk.EstimoteSDK;
import com.omniwyse.dod.R;

/**
 * Created by checking again on 2/23/2017.
 */

public class LiveFragment extends Fragment {

    public LiveFragment() {
        // Required empty public constructor
       // EstimoteSDK.initialize(applicationContext, appId, appToken);
// Optional, debug logging.
        EstimoteSDK.enableDebugLogging(true);
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_live, container, false);
    }

}
