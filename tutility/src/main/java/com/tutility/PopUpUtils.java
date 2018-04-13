package com.tutility;

import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.support.v7.app.AlertDialog;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.kaopiz.kprogresshud.KProgressHUD;

/**
 * This class is used to show Popups (Toast,Dialog,Popup)
 */

public class PopUpUtils {

    //ENABLE TOAST

    /**
     * Function used to show Toast Message ..
     *
     * @param context - Context Of Activity.
     * @param message - Message to show on Toast.
     */
    public static void showToastMessage(Context context, String message) {
        Toast.makeText(context, message, Toast.LENGTH_SHORT).show();
    }

    //Show simple alertDialog with okButton

    /**
     * Function used to show Alert Dialog with title and message
     *
     * @param context- Context Of Activity.
     * @param title    -  title of alert dialog
     * @param message  -- message of alert dialog
     */
    public static void showAlertPopUp(final Context context, String title, String message) {
        final AlertDialog.Builder alertDialog = new AlertDialog.Builder(context);
        alertDialog.setTitle(title);
        alertDialog.setMessage(message);

        alertDialog.setPositiveButton(context.getString(R.string.dialog_ok), new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                }

        );
        alertDialog.create().show();
    }

    /**
     * Function used to show Alert Dialog with  message
     *
     * @param context-          Context Of Activity.
     * @param responseMessage-- message of alert dialog
     */
    public static void showAlertDialog(Context context, String responseMessage) {
        final AlertDialog.Builder builder = new AlertDialog.Builder(context);

        View dialogView = View.inflate(context, R.layout.ft_err_dialog_layout, null);
        builder.setView(dialogView);
        final AlertDialog dialog = builder.show();
        final TextView message = dialogView.findViewById(R.id.header_txt);
        message.setText(responseMessage);
        FrameLayout okBtn = dialogView.findViewById(R.id.okBtn);
        okBtn.setOnClickListener(new View.OnClickListener() {
                                     @Override
                                     public void onClick(View v) {
                                         dialog.cancel();
                                     }
                                 }
        );


        if (dialog.getWindow() != null)
            dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        // display dialog
        dialog.show();
    }

    /**
     * Function used to show network error.
     *
     * @param context- Context Of Activity.
     */
    public static void noConnectionDialog(Context context) {
        try {
            final AlertDialog.Builder dialog = new AlertDialog.Builder(context);
            dialog.setTitle(context.getString(R.string.err_network_title))
                    .setMessage(context.getString(R.string.err_network_message))
                    .setPositiveButton(context.getString(R.string.dialog_ok), new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int which) {
                            dialogInterface.dismiss();
                        }
                    }
                            ).show();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public static KProgressHUD initProgressDialog(Context context) {
        return KProgressHUD.create(context)
                .setStyle(KProgressHUD.Style.SPIN_INDETERMINATE)
                .setCancellable(false)
                .setDimAmount(0.5f)
                .setAnimationSpeed(2);
    }
}
