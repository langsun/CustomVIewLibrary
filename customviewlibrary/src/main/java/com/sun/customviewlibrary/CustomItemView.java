package com.sun.customviewlibrary;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;


/**
 * Created by sun on 18/10/25.
 */

public class CustomItemView extends RelativeLayout {
    private ImageView mLeftImage;
    private TextView mLeftText;
    private TextView mRightText;
    private ImageView mRightImage;
    private View mViewLine;
    private ClickListener mClickListener;

    public CustomItemView(Context context) {
        super(context);
    }

    public CustomItemView(Context context, AttributeSet attrs) {
        super(context, attrs);
        View view = LayoutInflater.from(context).inflate(R.layout.view_custom_item_view, this, true);
        mLeftImage = findViewById(R.id.iv_left_image);
        mLeftText = findViewById(R.id.tv_left_text);
        mRightImage = findViewById(R.id.iv_right_image);
        mRightText = findViewById(R.id.tv_right_text);
        mViewLine = findViewById(R.id.view_line);
        TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.CustomItemView);
        int leftImage = typedArray.getResourceId(R.styleable.CustomItemView_left_image, 0);
        String leftText = typedArray.getString(R.styleable.CustomItemView_left_text);
        int leftTextSize = typedArray.getInteger(R.styleable.CustomItemView_left_text_size, 0);
        int leftTextColor = typedArray.getResourceId(R.styleable.CustomItemView_left_text_color, 0);

        int rightImage = typedArray.getResourceId(R.styleable.CustomItemView_right_image, 0);
        String rightText = typedArray.getString(R.styleable.CustomItemView_right_text);
        int rightTextSize = typedArray.getInteger(R.styleable.CustomItemView_right_text_size, 0);
        int rightTextColor = typedArray.getResourceId(R.styleable.CustomItemView_right_text_color, 0);

        boolean viewLineVisible = typedArray.getBoolean(R.styleable.CustomItemView_view_line_visible, true);
        if (leftImage == 0) {
            mLeftImage.setVisibility(GONE);
        } else {
            mLeftImage.setVisibility(VISIBLE);
            mLeftImage.setImageResource(leftImage);
        }

        if (leftTextSize != 0) {
            mLeftText.setTextSize(leftTextSize);
        }
        if (leftTextColor != 0) {
            mLeftText.setTextColor(getResources().getColor(leftTextColor));
        }

        mLeftText.setText(leftText);

        if (rightImage == 0) {
            mRightImage.setVisibility(GONE);
        } else {
            mRightImage.setVisibility(VISIBLE);
            mRightImage.setImageResource(rightImage);
        }

        if (rightTextSize != 0) {
            mRightText.setTextSize(rightTextSize);
        }
        if (rightTextColor != 0) {
            mRightText.setTextColor(getResources().getColor(rightTextColor));
        }

        mRightText.setText(rightText);

        if (!viewLineVisible) {
            mViewLine.setVisibility(GONE);
        }

        this.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mClickListener != null)
                    mClickListener.click();
            }
        });
    }

    public void setRightTextColor(int res) {
        mRightText.setTextColor(getResources().getColor(res));
    }

    public void setRightText(String str) {
        mRightText.setText(str);
    }

    public void setRightImage(int res) {
        mRightImage.setImageResource(res);
    }

    public String getRightText() {
        return mRightText.getText().toString().trim();
    }

    public void setClickListener(ClickListener clickListener) {
        mClickListener = clickListener;
    }

    public interface ClickListener {
        void click();
    }
}
