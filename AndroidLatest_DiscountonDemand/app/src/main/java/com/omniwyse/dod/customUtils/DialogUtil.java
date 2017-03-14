package com.omniwyse.dod.customUtils;

import android.app.AlertDialog;
import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.support.annotation.StringRes;

import com.omniwyse.dod.R;

/**
 * Created by surya on 3/9/2017.
 */

public class DialogUtil {

    public static Dialog createSimpleOkErrorDialog(Context context, String title, String message) {
        AlertDialog.Builder alertDialog = new AlertDialog.Builder(context)
                .setTitle(title)
                .setMessage(message)
                .setNeutralButton("OK", null);
        return alertDialog.create();
    }

    public static Dialog createSimpleOkErrorDialog(Context context, int titleResource, int messageResource) {

        return createSimpleOkErrorDialog(context,
                context.getString(titleResource),
                context.getString(messageResource));
    }

    public static Dialog createGenericErrorDialog(Context context, String message) {
        AlertDialog.Builder alertDialog = new AlertDialog.Builder(context)
                .setTitle("Error")
                .setMessage(message)
                .setNeutralButton("Cancel", null);
        return alertDialog.create();
    }

    public static Dialog createGenericErrorDialog(Context context,  int messageResource) {
        return createGenericErrorDialog(context, context.getString(messageResource));
    }

    public static ProgressDialog createProgressDialog(Context context, String message) {
        ProgressDialog progressDialog = new ProgressDialog(context);
        progressDialog.setMessage(message);
        return progressDialog;
    }

    public static ProgressDialog createProgressDialog(Context context,
                                                       int messageResource) {
        return createProgressDialog(context, context.getString(messageResource));
    }
}
