package com.omniwyse.dod.fragement;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.omniwyse.dod.R;
import com.omniwyse.dod.adapters.BeaconLiveAdapter;
import com.omniwyse.dod.adapters.RecyclerViewDataAdapter;
import com.omniwyse.dod.adapters.StoresAdapter;
import com.omniwyse.dod.api.APIInterface;
import com.omniwyse.dod.api.ApiClient;
import com.omniwyse.dod.api.BeaconRequest;
import com.omniwyse.dod.model.Beacon;
import com.omniwyse.dod.model.BeaconData;
import com.omniwyse.dod.model.BeaconPromotions;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by checking again on 2/23/2017.
 * @author surya.g21@gmail.com
 */

public class LiveFragment extends Fragment {


    private static final String TAG = "LiveFragment";
    List<BeaconPromotions> promotionsList = new ArrayList<>();
    View rootView;
    public LiveFragment() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRetainInstance(true);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.fragment_live, container, false);
        loadBeaconData();
        return rootView;
    }

    private void loadBeaconData() {
        final ProgressDialog mProgressDialog = new ProgressDialog(getActivity());
        mProgressDialog.setIndeterminate(true);
        mProgressDialog.setMessage("Authenticating...");
        mProgressDialog.show();

        List<String> list = new ArrayList<String>();
        list.add("1");
        list.add("2");
        list.add("3");

        APIInterface apiService =
                ApiClient.getClient().create(APIInterface.class);

        Call<Beacon> beaconLive = apiService.beaconLive(new BeaconRequest(list));

        beaconLive.enqueue(new Callback<Beacon>() {
            @Override
            public void onResponse(Call<Beacon> call, Response<Beacon> response) {
                Log.d(TAG, new Gson().toJson(response.body()));
                if (mProgressDialog.isShowing())
                    mProgressDialog.dismiss();

                if (response.code() == 200) {
                    Log.d(TAG, new Gson().toJson(response.body()));
                            promotionsList.clear();
                    for(BeaconData data : response.body().getData()){
                        for(BeaconPromotions promotions : data.getPromotionDtos()){
                            promotionsList.add(promotions);
                        }
                    }
                    setAdapter();
                } else if(response.code() == 400){
                    Toast.makeText(getActivity(), "Please try some other time ", Toast.LENGTH_SHORT).show();
                    Log.d(TAG, new Gson().toJson(response.body()));
                }
            }

            @Override
            public void onFailure(Call<Beacon> call, Throwable t) {
                if (mProgressDialog.isShowing())
                    mProgressDialog.dismiss();
                Toast.makeText(getActivity(), "Please try some other time " + t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void setAdapter(){
        RecyclerView my_recycler_view = (RecyclerView) rootView.findViewById(R.id.beacon_list);
        my_recycler_view.setHasFixedSize(true);
        BeaconLiveAdapter adapter = new BeaconLiveAdapter(getActivity(), promotionsList);
        my_recycler_view.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false));
        my_recycler_view.setAdapter(adapter);
    }

}
