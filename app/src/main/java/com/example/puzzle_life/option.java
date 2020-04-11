package com.example.puzzle_life;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class option extends Activity {

    protected static Context java;
    Button startButton;
    Button chooseimagestartButton;
    Button settingButton;
    Button helpButton;
    Button aboutButton;
    Button exitButton;
    static int grade;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_option);

        startButton = findViewById(R.id.start);
        settingButton = findViewById(R.id.setting);
        helpButton = findViewById(R.id.help);
        aboutButton =  findViewById(R.id.about);
        exitButton =  findViewById(R.id.exit);
        chooseimagestartButton = findViewById(R.id.choose_start);
        startButton.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                final Puzzle_Life puzzle = ((Puzzle_Life) getApplicationContext());
                final Intent intent = new Intent(option.this, start.class);
                final Intent intent1 = new Intent(option.this, start_four.class);
                if (3 ==puzzle.getgrade()) {
                    startActivity(intent);
                } else {
                    startActivity(intent1);
                }//
            }
        });
        chooseimagestartButton.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                final Intent intent = new Intent(option.this, chooseimage.class);
                startActivity(intent);
            }
        });
        settingButton.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(option.this, setting.class);
                startActivity(intent);
            }
        });
        helpButton.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                finish();
                Intent intent = new Intent(option.this, help.class);
                startActivity(intent);
            }
        });
        /*
         *
         *
         */
        aboutButton.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(option.this, about.class);
                startActivity(intent);
            }
        });
        exitButton.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                new AlertDialog.Builder(option.this)
                        .setTitle("提示")
                        .setMessage("确定退出吗")
                        .setPositiveButton("是",
                                new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialog,
                                                        int which) {
                                        // TODO Auto-generated method stub
                                        System.exit(0);
                                    }

                                }).setNegativeButton("否", null).show();
            }
        });
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            new AlertDialog.Builder(this).setTitle("提示")

                    .setMessage("确定退出吗")

                    .setNegativeButton("取消", null)

                    .setPositiveButton("确定", new DialogInterface.OnClickListener() {

                        public void onClick(DialogInterface dialog, int whichButton) {

                            System.exit(0);

                        }
                    }).show();

        }
        return true;
    }

}
