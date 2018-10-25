package com.sun.customview;

import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

import com.sun.customviewlibrary.CustomBottomDialog;
import com.sun.customviewlibrary.CustomCenterDialog;

import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.tv_bottom_view)
    public void shoeBottomView() {
        CustomBottomDialog dialog = new CustomBottomDialog(this, R.layout.dialog_bottom_layout, new int[]{R.id.tv_sure, R.id.tv_cancel});
        dialog.setClickListener(new CustomBottomDialog.ClickListener() {
            @Override
            public void onItemClick(CustomBottomDialog dialog, View view) {
                switch (view.getId()) {
                    case R.id.tv_sure:
                        Toast.makeText(MainActivity.this, "sure", Toast.LENGTH_LONG).show();
                        break;
                }

            }
        });
        dialog.show();
    }

    @OnClick(R.id.tv_dialog)
    public void shoeDialog() {
        CustomCenterDialog.Builder builder = new CustomCenterDialog.Builder();
        builder.setContext(MainActivity.this)
                .setTitle("测试一下")
                .setTitleTextColor(R.color.colorAccent)
                .setTitleTextSize(30)
                .setMessage("这只是一个测试")
                .setLeftBtnText("NO", null)
                .setRightBtnText("YES", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(MainActivity.this, "YES", Toast.LENGTH_LONG).show();
                    }
                }).setRightBtnTextBg(R.drawable.red_shape)
                .setRightBtnTextColor(R.color.color_ffffff)
                .setDialogBg(R.drawable.my_dialog_shape)
                .create()
                .show();

    }

    @OnClick(R.id.tv_dialog_util)
    public void shoeDialogUtil() {
        DialogUtil.showDialog(MainActivity.this, "测试一下", "这只是一个测试", "取消", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(MainActivity.this, "取消", Toast.LENGTH_LONG).show();
            }
        }, "确定", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(MainActivity.this, "确定", Toast.LENGTH_LONG).show();
            }
        });
    }

    @OnClick(R.id.civ_binding_phone)
    public void shoeItemView() {
        Toast.makeText(MainActivity.this, "CustomItemView", Toast.LENGTH_LONG).show();
    }
}
