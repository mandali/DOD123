package com.omniwyse.dod.customUtils;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;

/**
 * Created by surya on 3/8/2017.
 */

public class BaseFragment extends Fragment {

    private final ProgressDialog mProgressDialog = new ProgressDialog(getActivity());
    private boolean isResume = false;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mProgressDialog.setIndeterminate(true);
        mProgressDialog.setMessage("Loading...");

    }

    @Override
    public void onResume() {
        super.onResume();
        isResume = true;
    }

    @Override
    public void onPause() {
        super.onPause();
        isResume = false;
    }

    public void showProgerssDialod(){
        if (isResume)mProgressDialog.show();

    }
    public void stopProgerssDialog(){
        if(!isResume)mProgressDialog.dismiss();
    }

    public void setProgressMessage(String message){
        mProgressDialog.setMessage(message);
    }
}
