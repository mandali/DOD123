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

import com.omniwyse.dod.R;
import com.omniwyse.dod.api.APIInterface;
import com.omniwyse.dod.api.ApiClient;
import com.omniwyse.dod.api.ConsumerRegisterbodyrequest;
import com.omniwyse.dod.api.Loginbodyrequest;
import com.omniwyse.dod.model.ConsumerRegistresponse;
import com.omniwyse.dod.model.Loginresponse;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ConsumerRegistration extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dod_register_famous);
        Button btn = (Button) findViewById(R.id.btn_register);
        btn.setOnClickListener(new View.OnClickListener() {

                                   @Override
                                   public void onClick(View v) {


                                       EditText ed_inputemail = (EditText) findViewById(R.id.input_email);
                                       EditText ed_inputmobile = (EditText) findViewById(R.id.input_phone);
                                       EditText ed_inputcity = (EditText) findViewById(R.id.input_city);
                                       EditText ed_inputage = (EditText) findViewById(R.id.input_age);
                                       EditText ed_inputpassword = (EditText) findViewById(R.id.input_password);
                                       EditText ed_cinputpassword = (EditText) findViewById(R.id.input_cpassword);


                                       String strEmail = ed_inputemail.getText().toString();
                                       String strMobile = ed_inputmobile.getText().toString();
                                       String strCity = ed_inputcity.getText().toString();
                                       String strAge = ed_inputage.getText().toString();
                                       String strPassword = ed_inputpassword.getText().toString();
                                       String strCPassword = ed_cinputpassword.getText().toString();
                                       if (TextUtils.isEmpty(strEmail)) {
                                           ed_inputemail.setError("Enter Email ID");
                                           return;
                                       }
                                       if (TextUtils.isEmpty(strMobile)) {
                                           ed_inputemail.setError("Enter Valid Phoneno...");
                                           return;
                                       }
                                       if (TextUtils.isEmpty(strCity)) {
                                           ed_inputemail.setError("Enter City...");
                                           return;
                                       }
                                       if (TextUtils.isEmpty(strAge)) {
                                           ed_inputemail.setError("Enter Age");
                                           return;
                                       }
                                       if (TextUtils.isEmpty(strPassword)) {
                                           ed_inputemail.setError("Enter Password");
                                           return;
                                       }
                                       if (TextUtils.isEmpty(strCPassword)) {
                                           ed_inputemail.setError("Re-Enter Password");
                                           return;
                                       }

                                       if (!isValidEmail(strEmail)) {

                                           ed_inputemail.setError("Invalid Email"); /*"Invalid Text" or something like getString(R.string.Invalid)*/
                                           ed_inputemail.requestFocus();
                                           return;
                                       }
                                       if (!isValidPhoneNumber(strMobile)) {

                                           ed_inputmobile.setError("Invalid Phone number"); /*"Invalid Text" or something like getString(R.string.Invalid)*/
                                           ed_inputmobile.requestFocus();
                                           return;
                                       }

                                       if (!TextUtils.isEmpty(strPassword) && !TextUtils.isEmpty(strCPassword)) {

                                           if (!strPassword.equals(strCPassword)) {
                                               Toast.makeText(ConsumerRegistration.this, "Password or Confirm Password does not match.. Please try again..", Toast.LENGTH_SHORT).show();
                                               ed_inputpassword.setText("");
                                               ed_cinputpassword.setText("");
                                               ed_inputpassword.requestFocus();
                                               return;
                                           }
                                       }

                                       final ProgressDialog mProgressDialog = new ProgressDialog(ConsumerRegistration.this);
                                       mProgressDialog.setIndeterminate(true);
                                       mProgressDialog.setMessage("Registring...");
                                       mProgressDialog.show();

                                       APIInterface apiService =
                                               ApiClient.getClient().create(APIInterface.class);
                                       Call<ConsumerRegistresponse> apiconsumerresonse = apiService.ConsumerRegistration(new ConsumerRegisterbodyrequest("1"));
                                       apiconsumerresonse.enqueue(new Callback<ConsumerRegistresponse>() {
                                           @Override
                                           public void onResponse(Call<ConsumerRegistresponse> call, Response<ConsumerRegistresponse> response) {
                                               System.out.println("Mukesh Register "+ "The Response code is  " + response.code());
                                               System.out.println("Mukesh Register"+ "The Response is " + response.body().toString());
                                               if (response.code() == 200) {
                                                   System.out.println("Mukesh "+ "The Response is " + response.body().toString());
                                                   startActivity(new Intent(ConsumerRegistration.this, LoginActivity.class));
                                               }
                                           }

                                           @Override
                                           public void onFailure(Call<ConsumerRegistresponse> call, Throwable t) {
                                               Toast.makeText(ConsumerRegistration.this, "Some problem occured.. Please try some othe time..", Toast.LENGTH_SHORT).show();
                                               startActivity(new Intent(ConsumerRegistration.this, LoginActivity.class));

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
