package com.omniwyse.dod.fragement;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.omniwyse.dod.R;

/**
 * Created by surya on 2/6/2017.
 */

public class DiscountFragment extends Fragment {

    public DiscountFragment() {
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
        View rootView = inflater.inflate(R.layout.fragment_discount, container, false);
        // Inflate the layout for this fragment


        return rootView;

    }

}
