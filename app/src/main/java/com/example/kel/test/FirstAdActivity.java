package com.example.kel.test;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;

public class FirstAdActivity extends Activity {

    private SharedPreferences preferences;
    private Button mButton;
    private int mSeconds = 4;
    private Handler myHandler = new Handler();
    private Runnable myRunnable = new Runnable() {
        @Override
        public void run() {
            mSeconds--;
            if (mSeconds > 0) {
                myHandler.postDelayed(myRunnable, 1000);
            } else {
                myHandler.post(new Runnable() {
                    public void run() {
                        myHandler.removeCallbacks(myRunnable);
                        Access2Main();
                    }
                });
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first_ad);
    }

    @Override
    protected void onResume() {
        super.onResume();
        initGuideView();
        mButton = (Button) findViewById(R.id.button);
        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myHandler.removeCallbacks(myRunnable);
                Access2Main();
            }
        });
    }

    private void Access2Main() {
        Intent intent = new Intent();
        intent.setClass(FirstAdActivity.this, com.example.kel.test.MainActivity.class);
        startActivity(intent);
        FirstAdActivity.this.finish();
    }

    private void initGuideView() {
        preferences = getSharedPreferences("count", MODE_WORLD_READABLE);
        int count = preferences.getInt("count", 0);
        if (count == 0) {
            Intent intent = new Intent();
            //intent.setClass(getApplicationContext(), com.example.kel.test.guide.GuideActivity.class);
            intent.setClass(getApplicationContext(), com.example.kel.test.viewPage.ViewPagerGuideActivity.class);
            startActivity(intent);
            this.finish();
        } else {
            myHandler.postDelayed(myRunnable, 10);
        }
        SharedPreferences.Editor editor = preferences.edit();
        editor.putInt("count", ++count);
        editor.commit();
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if ((keyCode == KeyEvent.KEYCODE_BACK)) {
            return true;
        }
        //return super.onKeyDown(keyCode, event);
        return false;
    }
}
