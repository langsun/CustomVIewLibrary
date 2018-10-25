package com.sun.customview;

import android.content.Context;
import android.content.DialogInterface;

import com.sun.customviewlibrary.CustomCenterDialog;

/**
 * Created by sun on 18/10/25.
 */

public class DialogUtil {

    public static void showDialog(final Context context, String title, String message, String leftButText, DialogInterface.OnClickListener leftButOnClickListener, String rightButText, DialogInterface.OnClickListener rightButOnClickListener) {
        CustomCenterDialog.Builder builder = new CustomCenterDialog.Builder();
        builder.setContext(context)
                .setTitle(title)
                .setTitleTextColor(R.color.colorAccent)
                .setTitleTextSize(30)
                .setMessage(message)
                .setRightBtnTextBg(R.drawable.red_shape)
                .setRightBtnTextColor(R.color.color_ffffff)
                .setDialogBg(R.drawable.my_dialog_shape)
                .setLeftBtnText(leftButText, leftButOnClickListener)
                .setRightBtnText(rightButText, rightButOnClickListener)
                .create()
                .show();
    }

}
