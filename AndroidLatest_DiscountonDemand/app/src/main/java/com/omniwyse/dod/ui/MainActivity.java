package com.omniwyse.dod.ui;

import android.app.ProgressDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.omniwyse.dod.R;
import com.omniwyse.dod.api.APIInterface;
import com.omniwyse.dod.api.ApiClient;
import com.omniwyse.dod.api.Loginbodyrequest;
import com.omniwyse.dod.model.Loginresponse;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loginnew);
        Button btn = (Button) findViewById(R.id.btn_login);
        btn.setOnClickListener(new View.OnClickListener() {

                                   @Override
                                   public void onClick(View v) {

                                       final ProgressDialog mProgressDialog = new ProgressDialog(MainActivity.this);
                                       mProgressDialog.setIndeterminate(true);
                                       mProgressDialog.setMessage("Loading...");
                                       mProgressDialog.show();

                                       APIInterface apiService =
                                               ApiClient.getClient().create(APIInterface.class);

                                       /*
                                       Call<List<GetpromotionResponse>> callgetpromotions = apiService.getPromotions();
                                       callgetpromotions.enqueue(new Callback<List<GetpromotionResponse>>() {
                                           @Override
                                           public void onResponse(Call<List<GetpromotionResponse>> call, Response<List<GetpromotionResponse>> response) {
                                               List<GetpromotionResponse> gpr = response.body();
                                               System.out.println("The Total size of GPR is "+gpr.size());
                                               if (mProgressDialog.isShowing())
                                                   mProgressDialog.dismiss();
                                           }

                                           @Override
                                           public void onFailure(Call<List<GetpromotionResponse>> call, Throwable t) {
                                               System.out.println("The Failed  "+t.getMessage() );
                                               if (mProgressDialog.isShowing())
                                                   mProgressDialog.dismiss();
                                           }
                                       });
                                       */


                                     /*  Call<Loginresponse> loginresponse = apiService.(new Loginbodyrequest("9000509846"));
                                       loginresponse.enqueue(new Callback<Loginresponse>() {
                                           @Override
                                           public void onResponse(Call<Loginresponse> call, Response<Loginresponse> response) {
                                               System.out.println(" The compelte response " + response.code());
                                               System.out.println(" Passed-..." + response.body().getOtpType() + " + OTY  " + response.body().getOtp());
                                               if (mProgressDialog.isShowing())
                                                   mProgressDialog.dismiss();
                                           }

                                           @Override
                                           public void onFailure(Call<Loginresponse> call, Throwable t) {

                                               System.out.println(" Failed...");
                                               if (mProgressDialog.isShowing())
                                                   mProgressDialog.dismiss();
                                           }
                                       });
*/

                                   }
                               }
        );
    }
}
