package com.omniwyse.dod.ui;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.omniwyse.dod.R;
import com.omniwyse.dod.api.APIInterface;
import com.omniwyse.dod.api.ApiClient;
import com.omniwyse.dod.api.ConsumerRegisterbodyrequest;
import com.omniwyse.dod.api.Otpbodyrequest;
import com.omniwyse.dod.model.Loginresponse;
import com.omniwyse.dod.model.OTPResponse;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


/**
 * Created by Mukesh checking aain on 2/22/2017.
 */

public class OTPActivity extends AppCompatActivity {

    static int otpattempts=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_otp);
        Button btn = (Button) findViewById(R.id.btnotp);
        btn.setOnClickListener(new View.OnClickListener() {

                                   @Override
                                   public void onClick(View v) {

                                       final ProgressDialog mProgressDialog = new ProgressDialog(OTPActivity.this);
                                       mProgressDialog.setIndeterminate(true);
                                       mProgressDialog.setMessage("Verifying OTP. Please wait...");
                                       mProgressDialog.show();

                                       APIInterface apiService =
                                               ApiClient.getClient().create(APIInterface.class);
                                       Call<OTPResponse> otpbodyrequest = apiService.OTPValidate(new Otpbodyrequest(getIntent().getStringExtra("OTP"), getIntent().getStringExtra("MOBILENUMBER")));
                                       otpbodyrequest.enqueue(new Callback<OTPResponse>() {

                                           @Override
                                           public void onResponse(Call<OTPResponse> call, Response<OTPResponse> response) {

                                               if (mProgressDialog.isShowing())
                                                   mProgressDialog.dismiss();

                                               if (response.code() == 200 && response.body().getstatusCode().trim().equals("200")) {
                                                   System.out.println("Mukesh" + "The Response is " + response.body().toString());
                                                   startActivity(new Intent(OTPActivity.this, HomeActivity.class));
                                               } else {
                                                   Toast.makeText(OTPActivity.this, "Sorry , Wrong OTP No / Mobile no . Please enter again... ", Toast.LENGTH_SHORT).show();

                                                    otpattempts++;

                                                   if(otpattempts>2) {
                                                       startActivity(new Intent(OTPActivity.this, ConsumerRegistrationActivity.class));
                                                       otpattempts=0;
                                                   }
                                               }
                                           }

                                           @Override
                                           public void onFailure(Call<OTPResponse> call, Throwable t) {
                                               mProgressDialog.dismiss();
                                               startActivity(new Intent(OTPActivity.this, ConsumerRegistrationActivity.class));

                                           }
                                       });


                                   }
                               }
        );
    }
}
