package com.sun.customviewlibrary;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.Display;
import android.view.Gravity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

/**
 * Created by sun on 18/10/17.
 */

public class CustomBottomDialog extends Dialog implements View.OnClickListener {

    private Context mContext;
    private int mLayoutRes;//加载的布局文件
    private int[] mItemIds;//要监听的控件id
    private ClickListener mClickListener;
    private boolean mIsCanceledOnTouchOutside = true;//点击外部是否关闭Dialog
    private int mWidth = 1;//dialog的宽度   比如:1为宽度全屏，9/10整屏宽度的9/10

    /**
     * @param context   上下文
     * @param layoutRes 加载的布局文件
     * @param itemIds   要监听的控件id
     */
    public CustomBottomDialog(Context context, int layoutRes, int[] itemIds) {
        super(context, R.style.dialog_custom);
        this.mContext = context;
        this.mLayoutRes = layoutRes;
        this.mItemIds = itemIds;
    }

    /**
     * @param context   上下文
     * @param layoutRes 加载的布局文件
     * @param itemIds   要监听的控件id
     * @param width     dialog的宽度
     */
    public CustomBottomDialog(Context context, int layoutRes, int[] itemIds, int width) {
        super(context, R.style.dialog_custom);
        this.mContext = context;
        this.mLayoutRes = layoutRes;
        this.mItemIds = itemIds;
        this.mWidth = width;
    }

    /**
     * @param context                  上下文
     * @param layoutRes                加载的布局文件
     * @param itemIds                  要监听的控件id
     * @param width                    dialog的宽度
     * @param isCanceledOnTouchOutside 点击外部是否关闭
     */
    public CustomBottomDialog(Context context, int layoutRes, int[] itemIds, int width, boolean isCanceledOnTouchOutside) {
        super(context, R.style.dialog_custom);
        this.mContext = context;
        this.mLayoutRes = layoutRes;
        this.mItemIds = itemIds;
        this.mWidth = width;
        this.mIsCanceledOnTouchOutside = isCanceledOnTouchOutside;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Window window = getWindow();
        window.setGravity(Gravity.BOTTOM); // 此处可以设置dialog显示的位置
        window.setWindowAnimations(R.style.bottom_menu_animation); // 添加动画
        setContentView(mLayoutRes);
        // 宽度全屏
        WindowManager windowManager = ((Activity) mContext).getWindowManager();
        Display display = windowManager.getDefaultDisplay();
        WindowManager.LayoutParams lp = getWindow().getAttributes();
        lp.width = display.getWidth() * mWidth; // 设置宽度
        getWindow().setAttributes(lp);
        setCanceledOnTouchOutside(mIsCanceledOnTouchOutside);

        for (int id : mItemIds) {
            findViewById(id).setOnClickListener(this);
        }
    }

    public interface ClickListener {
        void onItemClick(CustomBottomDialog dialog, View view);
    }

    public void setClickListener(ClickListener listener) {
        this.mClickListener = listener;
    }

    @Override
    public void onClick(View view) {
        dismiss();
        if (mClickListener != null) {
            mClickListener.onItemClick(this, view);
        }
    }

}
