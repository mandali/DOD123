package com.omniwyse.dod.fragement;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.omniwyse.dod.R;
import com.omniwyse.dod.adapters.RecyclerViewDataAdapter;
import com.omniwyse.dod.api.APIInterface;
import com.omniwyse.dod.api.ApiClient;
import com.omniwyse.dod.api.GetBrandsresponse;
import com.omniwyse.dod.model.Datum;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by surya on 2/22/2017.
 */

public class BrandFragment extends Fragment {

    List<Datum> dataum = new ArrayList<>();
    View viewroot;

    public BrandFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        viewroot = inflater.inflate(R.layout.fragment_brands, container, false);

        final ProgressDialog mProgressDialog = new ProgressDialog(getActivity());
        mProgressDialog.setIndeterminate(true);
        mProgressDialog.setMessage("Loading...");
        mProgressDialog.show();

        APIInterface apiService =
                ApiClient.getClient().create(APIInterface.class);
        Call<GetBrandsresponse> callbrands = apiService.getBrands();
        callbrands.enqueue(new Callback<GetBrandsresponse>() {
            @Override
            public void onResponse(Call<GetBrandsresponse> call, Response<GetBrandsresponse> response) {

                if (mProgressDialog.isShowing())
                    mProgressDialog.dismiss();

                dataum = response.body().getData();


                System.out.println(" Get Total Categories... " + dataum.size());
                /*
                RecyclerView recyclerView = (RecyclerView)findViewById(R.id.my_recycler_view);
                recyclerView.setHasFixedSize(true);
                RecyclerView.LayoutManager layoutManager = new GridLayoutManager(getApplicationContext(),2);
                recyclerView.setLayoutManager(layoutManager);
                DataAdapter adapter = new DataAdapter(getApplicationContext(),dataum);
                recyclerView.setAdapter(adapter);
                    */

                RecyclerView my_recycler_view = (RecyclerView) viewroot.findViewById(R.id.my_recycler_view);
                my_recycler_view.setHasFixedSize(true);
                RecyclerViewDataAdapter adapter = new RecyclerViewDataAdapter(getActivity(), dataum);
                my_recycler_view.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false));
                my_recycler_view.setAdapter(adapter);

            }

            @Override
            public void onFailure(Call<GetBrandsresponse> call, Throwable t) {
                if (mProgressDialog.isShowing())
                    mProgressDialog.dismiss();
                System.out.println("Failing here " + t.getMessage().toString());

            }
        });


        return viewroot;
    }

}