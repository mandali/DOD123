package com.omniwyse.dod.ui;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.gson.Gson;
import com.omniwyse.dod.R;
import com.omniwyse.dod.api.APIInterface;
import com.omniwyse.dod.api.ApiClient;
import com.omniwyse.dod.api.ConsumerRegisterbodyrequest;
import com.omniwyse.dod.model.ConsumerRegistresponse;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ConsumerRegistrationActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dod_register_famous);
        Button btn = (Button) findViewById(R.id.btn_register);
        btn.setOnClickListener(new View.OnClickListener() {

                                   @Override
                                   public void onClick(View v) {


                                       EditText ed_inputmobile = (EditText) findViewById(R.id.input_mobile);


                                       final String strMobile = ed_inputmobile.getText().toString();

                                       if (!isValidPhoneNumber(strMobile)) {

                                           ed_inputmobile.setError("Invalid Phone number"); /*"Invalid Text" or something like getString(R.string.Invalid)*/
                                           ed_inputmobile.requestFocus();
                                           return;
                                       }


                                       final ProgressDialog mProgressDialog = new ProgressDialog(ConsumerRegistrationActivity.this);
                                       mProgressDialog.setIndeterminate(true);
                                       mProgressDialog.setMessage("Registring...");
                                       mProgressDialog.show();

                                       APIInterface apiService =
                                               ApiClient.getClient().create(APIInterface.class);
                                       Call<ConsumerRegistresponse> apiconsumerresonse = apiService.ConsumerRegistration(new ConsumerRegisterbodyrequest(strMobile));
                                       apiconsumerresonse.enqueue(new Callback<ConsumerRegistresponse>() {
                                           @Override
                                           public void onResponse(Call<ConsumerRegistresponse> call, Response<ConsumerRegistresponse> response) {
                                               System.out.println(" The compelte response " + response.code() + new Gson().toJson(response.body()));


                                               //      System.out.println(" Passed-..." + response.body().getOtpType() + " + OTY  " + response.body().getOtp());
                                               if (mProgressDialog.isShowing())
                                                   mProgressDialog.dismiss();

                                               if (response.code() == 200) {//&& response.body().getstatusCode().trim().equals("200")) {
                                                   System.out.println("Mukesh" + "The Response is " + response.body().toString());
                                                   startActivity(new Intent(ConsumerRegistrationActivity.this, OTPActivity.class));
                                               } else {
                                                   Toast.makeText(ConsumerRegistrationActivity.this, "Sorry , Mobile no is alredy exist ...", Toast.LENGTH_SHORT).show();


                                               }

                                           }

                                           @Override
                                           public void onFailure(Call<ConsumerRegistresponse> call, Throwable t) {
                                               if (mProgressDialog.isShowing())
                                                   mProgressDialog.dismiss();
                                               Toast.makeText(ConsumerRegistrationActivity.this, "Please try some other time " + t.getMessage(), Toast.LENGTH_SHORT).show();
                                               startActivity(new Intent(ConsumerRegistrationActivity.this, LoginActivity.class));


                                           }
                                       });
                                   }
                               }
        );


    }

    private boolean isValidEmail(CharSequence email) {
        if (!TextUtils.isEmpty(email)) {
            return Patterns.EMAIL_ADDRESS.matcher(email).matches();
        }
        return false;
    }

    private boolean isValidPhoneNumber(CharSequence phoneNumber) {
        if (!TextUtils.isEmpty(phoneNumber)) {
            return Patterns.PHONE.matcher(phoneNumber).matches();
        }
        return false;
    }
}
