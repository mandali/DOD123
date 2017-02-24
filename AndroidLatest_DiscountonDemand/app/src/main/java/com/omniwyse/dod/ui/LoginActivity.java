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
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;
import com.omniwyse.dod.R;
import com.omniwyse.dod.api.APIInterface;
import com.omniwyse.dod.api.ApiClient;
import com.omniwyse.dod.api.Loginbodyrequest;
import com.omniwyse.dod.model.Loginresponse;

import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


//Test comment

public class LoginActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dod_login_famous);
        Button btn = (Button) findViewById(R.id.btn_login);
        btn.setOnClickListener(new View.OnClickListener() {

                                   @Override
                                   public void onClick(View v) {


                                       EditText ed_inputmobile = (EditText) findViewById(R.id.input_mobile);
                                       String strMobilenumber = ed_inputmobile.getText().toString();


                                       if (!isValidPhoneNumber(strMobilenumber)) {
                                           ed_inputmobile.setError("Invalid Phone number"); /*"Invalid Text" or something like getString(R.string.Invalid)*/
                                           ed_inputmobile.requestFocus();
                                           return;
                                       }


                                       final ProgressDialog mProgressDialog = new ProgressDialog(LoginActivity.this);
                                       mProgressDialog.setIndeterminate(true);
                                       mProgressDialog.setMessage("Authenticating...");
                                       mProgressDialog.show();

                                       APIInterface apiService =
                                               ApiClient.getClient().create(APIInterface.class);


                                       Call<Loginresponse> loginresponse = apiService.ComsumerLogin(new Loginbodyrequest(strMobilenumber));
                                       loginresponse.enqueue(new Callback<Loginresponse>() {
                                           @Override
                                           public void onResponse(Call<Loginresponse> call, Response<Loginresponse> response) {
                                               System.out.println(" The compelte response " + response.code() + new Gson().toJson(response.body()));
                                               //      System.out.println(" Passed-..." + response.body().getOtpType() + " + OTY  " + response.body().getOtp());
                                               if (mProgressDialog.isShowing())
                                                   mProgressDialog.dismiss();


                                               //Show the OTP Screen...
                                               if (response.code() == 200 && response.body().getstatusCode().trim().equals("200")) {
                                                   System.out.println(" The Login response " + response.code() + new Gson().toJson(response.body()));
                                                   startActivity(new Intent(LoginActivity.this, HomeActivity.class));
                                               } else {
                                                   Toast.makeText(LoginActivity.this, "Sorry , Wrong Credentials ", Toast.LENGTH_SHORT).show();

                                               }


                                           }


                                           @Override
                                           public void onFailure(Call<Loginresponse> call, Throwable t) {
                                               if (mProgressDialog.isShowing())
                                                   mProgressDialog.dismiss();
                                               Toast.makeText(LoginActivity.this, "Please try some other time " + t.getMessage(), Toast.LENGTH_SHORT).show();

                                           }
                                       });


                                   }
                               }
        );

        TextView txtregister = (TextView) findViewById(R.id.link_signup);
        txtregister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(LoginActivity.this, ConsumerRegistrationActivity.class));
            }
        });


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
