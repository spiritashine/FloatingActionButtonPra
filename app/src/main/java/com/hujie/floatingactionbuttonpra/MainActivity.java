package com.hujie.floatingactionbuttonpra;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomSheetBehavior;
import android.support.design.widget.BottomSheetDialog;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.app.AppCompatDelegate;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
        View view = findViewById(R.id.bottom_action);
        final BottomSheetBehavior bottomSheetBehavior = BottomSheetBehavior.from(view);

        findViewById(R.id.show).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //展开
                bottomSheetBehavior.setState(BottomSheetBehavior.STATE_EXPANDED);
            }
        });

        findViewById(R.id.dismiss).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //隐藏
                bottomSheetBehavior.setState(BottomSheetBehavior.STATE_HIDDEN);
            }
        });

        findViewById(R.id.collapsed).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //收缩
                bottomSheetBehavior.setState(BottomSheetBehavior.STATE_COLLAPSED);
            }
        });

        findViewById(R.id.expanded).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //展开
                bottomSheetBehavior.setState(BottomSheetBehavior.STATE_EXPANDED);
            }
        });
        findViewById(R.id.dialog).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //创建Dialog
                sheetDialog.show();
            }
        });

        createDialog();
    }
    BottomSheetDialog sheetDialog;
    public void createDialog(){
        sheetDialog=new BottomSheetDialog(MainActivity.this);
        sheetDialog.setContentView(R.layout.content_main);//设置显示的布局

        //1 获得Dialog的View
        AppCompatDelegate rootView = sheetDialog.getDelegate();
        //2 BottomSheetBahavior
        View view = rootView.findViewById(android.support.design.R.id.design_bottom_sheet);
        final BottomSheetBehavior<View> bottomSheetBehavior = BottomSheetBehavior.from(view);

        //检测 BottomSheetBahavior 状态
        bottomSheetBehavior.setBottomSheetCallback(new BottomSheetBehavior.BottomSheetCallback() {
            //状态变化的时候回调
            @Override
            public void onStateChanged(@NonNull View bottomSheet, int newState) {
                //往下滑动隐藏，状态STATE_HIDDEN  处理隐藏的状态
                if(newState==BottomSheetBehavior.STATE_HIDDEN){
                    sheetDialog.dismiss();
                    bottomSheetBehavior.setState(BottomSheetBehavior.STATE_COLLAPSED);
                }
            }
            //手指拖动的时候调用
            @Override
            public void onSlide(@NonNull View bottomSheet, float slideOffset) {

            }
        });




    }

}
