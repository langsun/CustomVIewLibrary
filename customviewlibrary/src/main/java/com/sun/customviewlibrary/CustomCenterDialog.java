package com.sun.customviewlibrary;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.StyleRes;
import android.text.TextUtils;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.TextView;


/**
 * Created by sun on 18/1/3.
 */

public class CustomCenterDialog extends Dialog {
    private Context mContext;

    public CustomCenterDialog(@NonNull Context context) {
        super(context);
        mContext = context;
    }

    public CustomCenterDialog(@NonNull Context context, @StyleRes int themeResId) {
        super(context, themeResId);
        mContext = context;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        WindowManager windowManager = ((Activity) mContext).getWindowManager();
        Display display = windowManager.getDefaultDisplay();
        WindowManager.LayoutParams layoutParams = getWindow().getAttributes();
        layoutParams.width = (int) (display.getWidth() * 0.8);
        layoutParams.height = ViewGroup.LayoutParams.WRAP_CONTENT;
        this.getWindow().setAttributes(layoutParams);
    }

    public static class Builder {
        private Context mContext;
        private String mTitle;
        private String mMessage;
        private String mLeftBtnText;
        private String mRightBtnText;
        private DialogInterface.OnClickListener mLeftBtnListener;
        private DialogInterface.OnClickListener mRightBtnListener;
        private boolean mIsCanceledOnTouchOutside = true;

        private int mTitleTextSize = -1;
        private int mTitleTextColor = -1;
        private int mMessageTextSize = -1;
        private int mMessageTextColor = -1;
        private int mLeftBtnTextSize = -1;
        private int mLeftBtnTextColor = -1;
        private int mRightBtnTextSize = -1;
        private int mRightBtnTextColor = -1;
        private int mLeftBtnTextBg = -1;
        private int mRightBtnTextBg = -1;
        private int mDialogBg = -1;

        public Context getContext() {
            return mContext;
        }

        public Builder setContext(Context mContext) {
            this.mContext = mContext;
            return this;
        }

        public String getTitle() {
            return mTitle;
        }

        public Builder setTitle(String mTitle) {
            this.mTitle = mTitle;
            return this;
        }

        public String getMessage() {
            return mMessage;
        }

        public Builder setMessage(String mMessage) {
            this.mMessage = mMessage;
            return this;
        }

        public String getLeftBtnText() {
            return mLeftBtnText;
        }

        public Builder setLeftBtnText(String mLeftBtnText, DialogInterface.OnClickListener listener) {
            this.mLeftBtnText = mLeftBtnText;
            this.mLeftBtnListener = listener;
            return this;
        }

        public String getRightBtnText() {
            return mRightBtnText;
        }

        public Builder setRightBtnText(String mRightBtnText, DialogInterface.OnClickListener listener) {
            this.mRightBtnText = mRightBtnText;
            this.mRightBtnListener = listener;
            return this;
        }


        public Builder setIsCanceledOnTouchOutside(boolean isCanceledOnTouchOutside) {
            mIsCanceledOnTouchOutside = isCanceledOnTouchOutside;
            return this;
        }

        public Builder setTitleTextSize(int mTitleTextSize) {
            this.mTitleTextSize = mTitleTextSize;
            return this;
        }

        public Builder setTitleTextColor(int mTitleTextColor) {
            this.mTitleTextColor = mTitleTextColor;
            return this;
        }

        public Builder setMessageTextSize(int mMessageTextSize) {
            this.mMessageTextSize = mMessageTextSize;
            return this;
        }

        public Builder setMessageTextColor(int mMessageTextColor) {
            this.mMessageTextColor = mMessageTextColor;
            return this;
        }

        public Builder setLeftBtnTextSize(int mLeftBtnTextSize) {
            this.mLeftBtnTextSize = mLeftBtnTextSize;
            return this;
        }

        public Builder setLeftBtnTextColor(int mLeftBtnTextColor) {
            this.mLeftBtnTextColor = mLeftBtnTextColor;
            return this;
        }

        public Builder setRightBtnTextSize(int mRightBtnTextSize) {
            this.mRightBtnTextSize = mRightBtnTextSize;
            return this;
        }

        public Builder setRightBtnTextColor(int mRightBtnTextColor) {
            this.mRightBtnTextColor = mRightBtnTextColor;
            return this;
        }

        public Builder setLeftBtnTextBg(int mLeftBtnTextBg) {
            this.mLeftBtnTextBg = mLeftBtnTextBg;
            return this;
        }

        public Builder setRightBtnTextBg(int mRightBtnTextBg) {
            this.mRightBtnTextBg = mRightBtnTextBg;
            return this;
        }

        public Builder setDialogBg(int mDialogBg) {
            this.mDialogBg = mDialogBg;
            return this;
        }

        public CustomCenterDialog create() {
            LayoutInflater layoutInflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            final CustomCenterDialog myDialog = new CustomCenterDialog(mContext, R.style.my_dialog);
            myDialog.setCanceledOnTouchOutside(mIsCanceledOnTouchOutside);
            View view = layoutInflater.inflate(R.layout.custom_center_dialog, null);
            TextView title = view.findViewById(R.id.tv_title);
            TextView message = view.findViewById(R.id.tv_message);
            TextView LeftBtn = view.findViewById(R.id.tv_left_btn);
            TextView rightBtn = view.findViewById(R.id.tv_right_btn);
            if (TextUtils.isEmpty(mTitle)) {
                title.setVisibility(View.GONE);
            } else {
                title.setText(mTitle);
                if (mTitleTextSize != -1) {
                    title.setTextSize(mTitleTextSize);
                }
                if (mTitleTextColor != -1) {
                    title.setTextColor(mContext.getResources().getColor(mTitleTextColor));
                }
            }
            if (TextUtils.isEmpty(mMessage)) {
                message.setVisibility(View.GONE);
            } else {
                message.setText(mMessage);
                if (mMessageTextSize != -1) {
                    message.setTextSize(mMessageTextSize);
                }
                if (mMessageTextColor != -1) {
                    message.setTextColor(mContext.getResources().getColor(mMessageTextColor));
                }
            }

            if (!TextUtils.isEmpty(mLeftBtnText)) {
                LeftBtn.setText(mLeftBtnText);
                if (mLeftBtnTextSize != -1) {
                    LeftBtn.setTextSize(mLeftBtnTextSize);
                }
                if (mLeftBtnTextColor != -1) {
                    LeftBtn.setTextColor(mContext.getResources().getColor(mLeftBtnTextColor));
                }
                if (mLeftBtnTextBg != -1) {
                    LeftBtn.setBackground(mContext.getResources().getDrawable(mLeftBtnTextBg));
                }
                LeftBtn.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (mLeftBtnListener != null) {
                            mLeftBtnListener.onClick(myDialog, DialogInterface.BUTTON_POSITIVE);
                        }
                        myDialog.dismiss();

                    }
                });
            }
            if (!TextUtils.isEmpty(mRightBtnText)) {
                rightBtn.setText(mRightBtnText);
                if (mRightBtnTextSize != -1) {
                    rightBtn.setTextSize(mRightBtnTextSize);
                }
                if (mRightBtnTextColor != -1) {
                    rightBtn.setTextColor(mContext.getResources().getColor(mRightBtnTextColor));
                }
                if (mRightBtnTextBg != -1) {
                    rightBtn.setBackground(mContext.getResources().getDrawable(mRightBtnTextBg));
                }
                rightBtn.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (mRightBtnListener != null) {
                            mRightBtnListener.onClick(myDialog, DialogInterface.BUTTON_POSITIVE);
                        }
                        myDialog.dismiss();
                    }
                });
            }

            myDialog.setContentView(view);
            return myDialog;

        }
    }
}
